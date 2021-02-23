package lab.ssafy.corona.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class VirusReportSaxHandler extends DefaultHandler {
	private VirusReport vr = new VirusReport();
	private StringBuilder data = null;
	private StringBuilder dateStr = new StringBuilder();

	boolean bAuthor = false;
	boolean bAbout = false;
	boolean bDate = false;
	boolean bYear = false;
	boolean bMonth = false;
	boolean bDay = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attr) 
		throws SAXException {

		if (qName.equals("author")) {
			bAuthor = true;
		} else if (qName.equals("about")) {
			bAbout = true;
		} else if (qName.equals("date")) {
			bDate = true;
		} else if (qName.equals("year")) {
			bYear = true;
		} else if (qName.equals("month")) {
			bMonth = true;
		} else if (qName.equals("day")) {
			bDay = true;
		} 
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bAuthor) {
			vr.setAuthor(data.toString());
			bAuthor = false;
		} else if (bAbout) {
			vr.setAbout(data.toString());
			bAbout = false;
		} else if (bYear) {
			dateStr.append(data.toString()); 
			bYear = false;
		} else if (bMonth) {
			dateStr.append(data.toString()); 
			bMonth = false;
		} else if (bDay) {
			dateStr.append(data.toString()); 
			bDay = false;
		} else if (bDate) {
			vr.setDate(dateStr.toString());
			bDate = false;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
	
	public VirusReport getVirusReport() {
		return vr;
	}
}
