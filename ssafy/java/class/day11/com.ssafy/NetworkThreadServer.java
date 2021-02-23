package com.ssafy;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkThreadServer {
	public static void main(String[] args) {
		int port = 5400;
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			System.out.println("NetworkThreadServer Started");
			 
			while (true) {
				Socket socket = serverSocket.accept();
				NetworkThread thread = new NetworkThread(socket);
				thread.start();
			}
			
		 } catch (IOException e) {
			 System.out.println("NetworkThreadServer exception: " + e.getMessage());
			 e.printStackTrace();
		 }
	}
}

class NetworkThread extends Thread{
	Socket client;
	
	public NetworkThread() {}
	public NetworkThread(Socket client) {
		this.client = client;
	}
	@Override
	public void run() {
		try {
			OutputStream output = client.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			writer.println("Hello SSAFY!");			
		} catch (IOException e) {
			 System.out.println("NetworkSimpleServer exception: " + e.getMessage());
			 e.printStackTrace();
		}

	}
}	