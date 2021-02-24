package lab.ssafy.corona.weather;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class WeatherTest {
	JFrame f;
	JButton btn;
	JList<Weather> list;
	WeatherDAO dao = null;
	
	public WeatherTest() {
		dao = new WeatherDAO();
		createGUI();
		addEvent();
	}
	
// 	이벤트, 이벤트 리스너, 이벤트 핸들러, 이벤트 리스너 등록, 이벤트 소스
// 	GUI
	public void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		btn.addActionListener(e -> showList()); // Lamda
	}
	
	public void createGUI() {
		f = new JFrame("날씨 검색");
		btn = new JButton("검색");
		f.add(btn, BorderLayout.NORTH);
//		list = new JList<String>(new String[] {"ssafy", "java"});
		list = new JList<>();
		f.add(list, BorderLayout.CENTER);
		f.setBounds(200, 200, 400, 600);
		f.setVisible(true);
	}
	
	public void showList() {
		List<Weather> dlist = dao.getWeatherList();
		list.removeAll();
		list.setListData(dlist.toArray(new Weather[dlist.size()]));
		System.out.println("end");
	}
		
//	public void showList() {
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
//	}
	
	public static void main(String[] args) {
		new WeatherTest();
	}
}
