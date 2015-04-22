package edu.neu.cs5200.hw6;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import java.util.List;


/**
 * The persistent class for the tower database table.
 * 
 */
@Entity
@NamedQuery(name="Tower.findAll", query="SELECT t FROM Tower t")
@XmlRootElement(name="tower")
@XmlAccessorType(value = XmlAccessType.NONE)
public class Tower implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute(name="id")
	private int id;
	
	@XmlAttribute(name="height")
	private double height;
	
	@XmlAttribute(name="name")
	private String name;
	
	@XmlAttribute(name="sides")
	private int sides;

	//bi-directional many-to-one association to Equipment
	@OneToMany(mappedBy="tower")
	@XmlElement(name="equipment")
	private List<Equipment> equipments;

	//bi-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name="siteId")
	private Site site;

	public Tower() {
	}
	
	public Tower(int id, double height, String name, int sides,
			List<Equipment> equipments, Site site) {
		super();
		this.id = id;
		this.height = height;
		this.name = name;
		this.sides = sides;
		this.equipments = equipments;
		this.site = site;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSides() {
		return this.sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public List<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Equipment addEquipment(Equipment equipment) {
		getEquipments().add(equipment);
		equipment.setTower(this);

		return equipment;
	}

	public Equipment removeEquipment(Equipment equipment) {
		getEquipments().remove(equipment);
		equipment.setTower(null);

		return equipment;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}