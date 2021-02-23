package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkSimpleClient {
	public static void main(String[] args) {
		String host = "localhost";
		int port = 5400;
		
		try ( Socket socket = new Socket(host, port) ) { // 클라이언트는 소켓
			
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input)); // 소켓으로부터 받아서 읽음
 
			String message = reader.readLine();
			System.out.println(message);
			reader.close();
			
		 } catch ( IOException e) {
			 System.out.println("NetworkSimpleClient exception: " + e.getMessage());
			 e.printStackTrace();
		 }
	}
}
