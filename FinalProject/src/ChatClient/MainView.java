package ChatClient;

import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField textField; // 보낼 메세지 쓰는곳

	private String id;
	private String ip;
	private int port;
	
	JButton imoticon1;		// 이모티콘 버튼
	JButton imoticon2;		// 이모티콘 버튼
	JButton imoticon3;		// 이모티콘 버튼
	JButton imoticon4;

	JButton filebtn; //파일전송
	
	JButton sendBtn; // 전송버튼
	JTextArea textArea; // 수신된 메세지를 나타낼 변수

	private Socket socket; // 연결소켓
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public MainView(String id, String ip, int port)// 생성자
	{
		this.id = id;
		this.ip = ip;
		this.port = port;

		init();
		start();

		textArea.append(id + "님이 접속하셨습니다.\n");
		textArea.append("처음 보내는 메시지로 닉네임을 설정 할 수 있습니다\n");
		network();

	}

	public void network() {
		// 서버에 접속
		try {
			socket = new Socket(ip, port);
			if (socket != null) // socket이 null값이 아닐때 즉! 연결되었을때
			{
				Connection(); // 연결 메소드를 호출
			}
		} catch (UnknownHostException e) {
			textArea.append("호스트 IP 아님");
		} catch (IOException e) {
			textArea.append("소켓 접속 에러!!\n");
		}
	}

	public void Connection() { // 실직 적인 메소드 연결부분

		try { // 스트림 설정
			is = socket.getInputStream();
			dis = new DataInputStream(is);

			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
		} catch (IOException e) {
			textArea.append("스트림 설정 에러!!\n");
		}


		Thread th = new Thread(new Runnable() { // 스레드를 돌려서 서버로부터 메세지를 수신
					@Override
					public void run() {
						while (true) {

							try {
								String msg = dis.readUTF(); // 메세지를 수신한다
								textArea.append(msg + "\n");
							} catch (IOException e) {
								textArea.append("메세지 수신 에러!!\n");
								// 서버와 소켓 통신에 문제가 생겼을 경우 소켓을 닫는다
								try {
									os.close();
									is.close();
									dos.close();
									dis.close();
									socket.close();
									break; // 에러 발생하면 while문 종료
								} catch (IOException e1) {

								}

							}
						} // while문 끝

					}// run메소드 끝
				});

		th.start();

	}

	public void send_Message(String str) { // 서버로 메세지를 보내는 메소드
		try {
			dos.writeUTF(str);
		} catch (IOException e) {
			textArea.append("메세지 송신 에러!!\n");
		}
	}
	 
	public void init() { // 화면구성 메소드

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 340, 302);
		contentPane.add(scrollPane);

		textArea = new JTextArea() {
			 {
		            setOpaque(false);
		     }
			public void paintComponent(Graphics g) {
				 Image img = new ImageIcon("C:\\Users\\skuin\\Desktop\\FinalProject\\src\\ChatClient\\main.png").getImage();
		         g.drawImage(img, 0, 0, null);
		         super.paintComponent(g);
		      }
		};
		scrollPane.setViewportView(textArea);

		textField = new JTextField();
		
		textField.setBounds(0, 312, 200, 42);
		contentPane.add(textField);
		textField.setColumns(10);

		sendBtn = new JButton("전   송");
		sendBtn.setBounds(230, 312, 100, 42);
		contentPane.add(sendBtn);
		
		imoticon1 = new JButton("행복");
		imoticon1.setBounds(0, 360, 60, 42);
		contentPane.add(imoticon1);
		
		imoticon2 = new JButton("슬픔");
		imoticon2.setBounds(60, 360, 60, 42);
		contentPane.add(imoticon2);

		imoticon3 = new JButton("좌절");
		imoticon3.setBounds(120, 360, 60, 42);
		contentPane.add(imoticon3);
		
		imoticon4 = new JButton("애교");
		imoticon4.setBounds(180,360,60,42);
		contentPane.add(imoticon4);
		
		filebtn = new JButton("이미지전송");
		filebtn.setBounds(240,360,90,42);
		contentPane.add(filebtn);


		textArea.setEnabled(false); // 사용자가 수정못하게 막는다

		setVisible(true);

	}

	public void start() { // 액션이벤트 지정 메소드
		sendBtn.addActionListener(new Myaction()); // 내부클래스로 액션 리스너를 상속받은 클래스로
		// 지정
		imoticon1.addActionListener(new ImoticonAction1());
		imoticon2.addActionListener(new ImoticonAction2());
		imoticon3.addActionListener(new ImoticonAction3());
		imoticon4.addActionListener(new ImoticonAction4());
		
		filebtn.addActionListener(new FileButton());
	}

	class Myaction implements ActionListener // 내부클래스로 액션 이벤트 처리 클래스
	{

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == sendBtn)	 // 액션 이벤트가 sendBtn일때
			{

				send_Message(textField.getText());
				textField.setText(""); 		// 메세지를 보내고 나면 메세지 쓰는창을 비운다.
				textField.requestFocus();   // 메세지를 보내고 커서를 다시 텍스트 필드로 위치시킨다
			}

		}

	}
	class ImoticonAction1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==imoticon1)
			{
				send_Message("(^_^)");
			}
		}
	}
	class ImoticonAction2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==imoticon2)
			{
				send_Message("(ㅜ_ㅜ)");
			}
		}
	}
	class ImoticonAction3 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==imoticon3)
			{
				send_Message("(OTL)");
			}
		}
	}

	class ImoticonAction4 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==imoticon4)
			{
				send_Message("(>_<)");
			}
		}
	}
	
	class FileButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==filebtn)
			{
				send_Message("위 기능 미구현");
			}
		}	
	}
}


