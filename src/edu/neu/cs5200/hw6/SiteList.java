package edu.neu.cs5200.hw6;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="siteDatabase")
@XmlAccessorType(value = XmlAccessType.NONE)
public class SiteList {
	
	
	@XmlElement(name="site")
	private List<Site> sites;

	public SiteList(List<Site> sites) {
		super();
		this.sites = sites;
	}

	public SiteList() {
		super();
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	} 
					

}
