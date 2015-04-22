package edu.neu.cs5200.hw6;

import java.io.*; 
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.*; 
import javax.xml.transform.*; 
import javax.xml.transform.stream.*; 

public class SiteDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("HomeWork6");
	EntityManager em = null;

	public Site findSite(int SiteId) {
		Site site = null;

		em = factory.createEntityManager();
		em.getTransaction().begin();

		site = em.find(Site.class, SiteId);

		em.getTransaction().commit();
		em.close();

		return site;
	}

	public List<Site> findAllSites() {
		List<Site> sites = new ArrayList<Site>();

		em = factory.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select site from Site site");
		sites = query.getResultList();

		em.getTransaction().commit();
		em.close();

		return sites;
	}

	public void exportSiteDatabaseToXmlFile(SiteList siteList, String xmlFileName) {
		File xmlFile = new File(xmlFileName);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(SiteList.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(siteList, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void convertXmlFileToOutputFile(String inputXmlFileName, String outputXmlFileName, String xsltFileName) {
		File inputXmlFile = new File(inputXmlFileName);
		File outputXmlFile = new File(outputXmlFileName);
		File xsltFile = new File(xsltFileName);
		
		StreamSource source = new StreamSource(inputXmlFile);
		StreamSource xslt    = new StreamSource(xsltFile);
		StreamResult output = new StreamResult(outputXmlFile);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer transformer = factory.newTransformer(xslt);
			transformer.transform(source, output);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	SiteDAO dao = new SiteDAO();
	SiteList siteList = new SiteList();	
	siteList.setSites(dao.findAllSites());
	new File("xml/sites.xml");
	dao.exportSiteDatabaseToXmlFile(siteList, "xml/sites.xml");	
	dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/sites.html", "xml/sites2html.xslt");
	dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/equipments.html", "xml/sites2equipment.xslt");
	}
}
