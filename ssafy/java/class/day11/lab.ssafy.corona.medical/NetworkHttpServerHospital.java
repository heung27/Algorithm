package lab.ssafy.corona.medical;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NetworkHttpServerHospital {
	public static void main(String[] args) {
		Hospital univHospital = new Hospital("대학병원", 15, "001", 50, 10);
		Hospital localHospital = new Hospital("동네병원", 3, "901", 10, 2);
		
		// 병원 Collection
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalList.add(univHospital);
		hospitalList.add(localHospital);
				
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><style>table,th,td{ border: 1px solid green;}</style></head>");
		sb.append("<body><h2>병원 정보</h2><table>");
		sb.append("<tr><th>병원이름</th><th>직원 수</th><th>전체 병실 수</th><th>빈 병실 수</th></tr>");
		
		for( Hospital h : hospitalList ) {
			sb.append("<tr>")
			.append("<td>").append(h.getName()).append("</td>")
			.append("<td>").append(h.getEmployeeCount()).append("</td>")
			.append("<td>").append(h.getRoomTotalCount()).append("</td>")
			.append("<td>").append(h.getRoomEmptyCount()).append("</td>")
			.append("</tr>");
		}
		sb.append("</table></body></html>");
		String html = sb.toString();
		
		System.out.println(html);
		System.out.println(html.length());
		
		try (ServerSocket ss = new ServerSocket(8080)) {
			System.out.println("[Hospital Info Server is ready]");
			
			while (true) {
				try ( Socket socket = ss.accept() ) {

					BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

					// 통신 규약
					bw.write("HTTP/1.1 200 OK \r\n");
					bw.write("Content-Type: text/html;charset=utf-8\r\n");
					bw.write("\r\n");
					bw.write(html);
					bw.write("\r\n");
	                bw.flush();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
