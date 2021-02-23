package com.ssafy;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkSimpleServer {
	
	public static void main(String[] args) {
		int port = 5500; // 포트 설정
		
		try (ServerSocket serverSocket = new ServerSocket(port)) { // 열어준 자원을 자동으로 닫아줌. 서버 소켓
			
			System.out.println("NetworkSimpleServer Started");
			
			while (true) {
				Socket socket = serverSocket.accept(); // 대기하고 있는 모듈. 클라이언트가 접속하게 되면 아래 소스 실행
				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				writer.println("Hello SSAFY!"); // Hello SSAFY가 클라이언트로 넘어감
			}
			
		 } catch (IOException e) {
			 System.out.println("NetworkSimpleServer exception: " + e.getMessage());
			 e.printStackTrace();
		 }
	}
}
