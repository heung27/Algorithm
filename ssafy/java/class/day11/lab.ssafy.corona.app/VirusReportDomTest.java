package lab.ssafy.corona.app;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import lab.ssafy.corona.xml.VirusReport;

public class VirusReportDomTest {
	
	public static void main(String[] args) {

		File file = new File("./src/lab/ssafy/corona/xml/virus-report.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		VirusReport vr = new VirusReport();
		String date = "";
		
		try {
			
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();

			Element root = doc.getDocumentElement();
			System.out.println("Root element : " + root.getNodeName());

			NodeList childNodes = root.getChildNodes();

			for(int i = 0; i < childNodes.getLength(); i++){
				Node node = childNodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					
					Element element = (Element) node;
					String textContent = element.getTextContent();
					String nodeName = element.getNodeName();
					switch( nodeName ) {
						case "author" 	: 
							System.out.println("author : " + textContent); 
							vr.setAuthor(textContent); 
							break;
						case "about" 	: 
							System.out.println("about : " + textContent); 
							vr.setAbout(textContent); 
							break;
						case "date" 	: 
							NodeList dateChildNodes = element.getChildNodes();
							for(int j = 0; j < dateChildNodes.getLength(); j++){
								Node childNode = dateChildNodes.item(j);
								if(childNode.getNodeType() == Node.ELEMENT_NODE){
									Element childElement = (Element) childNode;
									String childTextContent = childElement.getTextContent();
									String childNodeName = childElement.getNodeName();
									switch( childNodeName ) {
										case "year" 	: 
											System.out.println("date-year : " + childTextContent); 
											date = childTextContent; 
											break;
										case "month" 	: 
											System.out.println("date-month : " + childTextContent); 
											date += childTextContent; 
											break;
										case "day" 		: 
											System.out.println("date-day : " + childTextContent); 
											date += childTextContent;
											break;
									}
								}
							}
							
							vr.setDate(date);
							break;
					}
				}
			}

		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(vr);
	}
}
