package ChatServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{

	private ServerSocket socket; //서버소켓
	private Socket soc; // 연결소켓 
	private int Port; // 포트번호

	private ArrayList vc = new ArrayList(); // 연결된 사용자를 저장할 벡터

	public static void main(String[] args)
	{
	
			Server server = new Server();
	}

	public Server() {
		try {
			socket = new ServerSocket(5000); // 서버가 포트 여는부분
			System.out.println("서버 실행중");
			
			if(socket!=null) // socket 이 정상적으로 열렸을때
			{
			Connection();
			}
			
		} catch (IOException e) {
			System.out.println("사용중임.");
		}
		}
	
	private void Connection() {

		Thread th = new Thread(new Runnable() { // 사용자 접속을 받을 스레드
			@Override
			public void run() {
				while (true) { // 사용자 접속을 계속해서 받기 위해 while문
					try {
						soc = socket.accept(); // accept가 일어나기 전까지는 무한 대기중
						UserInfo user = new UserInfo(soc, vc); // 연결된 소켓 정보는 금방 사라지므로, user 클래스 형태로 객체 생성
						                                                     // 매개변수로 현재 연결된 소켓과, 벡터를 담아둔다
						vc.add(user); // 해당 벡터에 사용자 객체를 추가

						user.start(); // 만든 객체의 스레드 실행

					} catch (IOException e) {
						System.out.println("에러발생");
					} 

				}

			}
		});

		th.start();
	}

	class UserInfo extends Thread {

		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private Socket user_socket;
		private ArrayList user_vc;

		private String Nickname = "";

		public UserInfo(Socket soc, ArrayList vc) // 생성자메소드
		{
			// 매개변수로 넘어온 자료 저장
			this.user_socket = soc;
			this.user_vc = vc;

			User_network();

		}

		public void User_network() {
			try {
				is = user_socket.getInputStream();
				dis = new DataInputStream(is);
				os = user_socket.getOutputStream();
				dos = new DataOutputStream(os);

				Nickname = dis.readUTF(); // 사용자의 닉네임 받는부분
				System.out.println("접속자 : "+Nickname+"\n");
				send_Message(Nickname+"님이 정상 접속 되었습니다"); // 연결된 사용자에게 정상접속을 알림

			} catch (Exception e) {
				System.out.println("접속실패!");
			}

		}

		public void InMessage(String str) {
			System.out.println("사용자 메시지 :"+str);
			// 사용자 메세지 처리
			broad_cast(str);

		}

		public void broad_cast(String str) {
			for (int i = 0; i < user_vc.size(); i++) {
				UserInfo imsi = (UserInfo) user_vc.get(i);
				imsi.send_Message(Nickname+" : "+str);

			}

		}

		public void send_Message(String str) {
			try {
				dos.writeUTF(str);
			} 
			catch (IOException e) {
				System.out.println("에러발생");
			}
		}

		public void run() // 스레드 정의
		{

			while (true) {
				try {
					
					// 사용자에게 받는 메세지
					String msg = dis.readUTF();
					InMessage(msg);
					
				} 
				catch (IOException e) 
				{
					
					try {
						dos.close();
						dis.close();
						user_socket.close();
						vc.remove( this ); // 에러가난 현재 객체를 벡터에서 지운다
						break;
					} catch (Exception ee) {
					
					}// catch문 끝
				}// 바깥 catch문끝

			}
			
			
			
		}// run메소드 끝

	} // 내부 userinfo클래스끝
	
	

}
