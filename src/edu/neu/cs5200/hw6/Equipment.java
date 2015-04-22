package edu.neu.cs5200.hw6;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the equipment database table.
 * 
 */
@Entity
@NamedQuery(name="Equipment.findAll", query="SELECT e FROM Equipment e")
@XmlRootElement(name="equipment")
@XmlAccessorType(value = XmlAccessType.NONE)
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute(name="id")
	private int id;
	
	@XmlAttribute(name="brand")
	private String brand;

	@XmlAttribute(name="description")
	private String description;
	
	@XmlAttribute(name="name")
	private String name;
	
	@XmlAttribute(name="price")
	private double price;

	//bi-directional many-to-one association to Tower
	@ManyToOne
	@JoinColumn(name="towerId")
	private Tower tower;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Tower getTower() {
		return this.tower;
	}

	public void setTower(Tower tower) {
		this.tower = tower;
	}
	
	public Equipment(){
		super();
	}
	
	public Equipment(int id, String brand, String description, String name,
			double price, Tower tower) {
		super();
		this.id = id;
		this.brand = brand;
		this.description = description;
		this.name = name;
		this.price = price;
		this.tower = tower;
	}
}