package lab.ssafy.corona.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatConnect {
	private String ip;
	private int port;
	private String name;
	private Socket s;

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ChatClientSwing ui;
	
	public ChatConnect(ChatClientSwing ui, String ip, int port, String name){
		this.ui = ui;
		this.ip = ip;
		this.port = port;
		this.name = name;
		connect();
	}

	public void setName(String name) {
    	this.name = name;
    }
	
	public void connect( ){
		
		try {
             s = new Socket(ip, port);

			 oos = new ObjectOutputStream( s.getOutputStream() );
			 ois = new ObjectInputStream( s.getInputStream() );

			 new Thread(){
				 public void run(){
					 try{
						while( true ) {
							String message = (String) ois.readObject();
							ui.updateChat(message);
						}
					 }catch(Exception e ) {
						 e.printStackTrace();
					 }
				 }				 
			 }.start();
			 
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	
	public void send(String msg){
		try {
			// [사용자 이름] 메세지 형태로
			oos.writeObject("[" + name + "] " + msg);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void sendExit(){
		try {
			oos.writeObject("^");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
