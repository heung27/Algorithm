package lab.ssafy.corona.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherDAO {
	private List<Weather> list = new ArrayList<>();
	
	public List<Weather> getWeatherList() {
		connectXML();
		return list;
	}
	
	public WeatherDAO() {
		
	}
	
//	XML SAX 파서
	class WeatherXMLHandler extends DefaultHandler {
		private ArrayList<Weather> list = new ArrayList<>();
		Weather w;
		String s = "";
		
		public ArrayList<Weather> getlist() {
			return list;
		}
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equalsIgnoreCase("data")) {
				w = new Weather();
				w.setSeq(attributes.getValue("seq"));
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
//			</hour>
			switch (qName) {
			case "hour":
				w.setHour(Integer.parseInt(s));
				break;
			case "temp":
				w.setTemp(Double.parseDouble(s));
				break;
			case "wfKor":
				w.setWfKor(s);
				break;
			case "reh":
				w.setReh(Integer.parseInt(s));
				break;
			case "data":
				list.add(w);
				break;
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
//			<hour> 12 </hour>
			s = new String(ch, start, length); // 12가 읽힘
			s.trim(); // 앞 뒤 공백 제거
		}
		
	}
	
	public void connectXML() {
		String address = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4719067000";
		
//		팩토리 디자인 패턴 => 파서를 공장에서 얻어온다. 내가 new X 공장에서 얻어오도록 디자인 설계
//		1. 팩서팩토리 생성
		SAXParserFactory factory = SAXParserFactory.newInstance(); // 싱글톤
		SAXParser parser = null;
		
		try {
//			2. SAXParser 얻기
			parser = factory.newSAXParser();
			
//			3. handler 만들기
			WeatherXMLHandler handler = new WeatherXMLHandler();
			
//			4. parser의 parse 메소드 호출
			URL url = null;
			url = new URL(address);
			InputStream is = url.openConnection().getInputStream();
			parser.parse(is, handler);
			
//			5. handler에서 결과로 생성된 자바 객체 반환하기
			list = handler.getlist();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		String address = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4719067000";
//		
//		URL url = null;
//		HttpURLConnection conn = null;
//		BufferedReader br = null;
//		try {
////			1. URL 객체 생성
//			url = new URL(address);
////			2. 접속하기 (인터넷 사용가능)
//			conn = (HttpURLConnection)url.openConnection();
//			System.out.println(conn.getResponseCode()); // 코드 100, 200, 300, 400, 500
//			System.out.println(conn.getResponseMessage());
//			
//			br = new BufferedReader(new InputStreamReader(conn.getInputStream())); // 바이트 단위
//			String str = "";
//			StringBuilder sb = new StringBuilder();
//			while ((str = br.readLine()) != null) {
//				sb.append(str).append("\r\n");
//			}
//			
//			System.out.println(sb.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			conn.disconnect();
//		}
	}
}
