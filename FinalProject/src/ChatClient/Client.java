package ChatClient;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private JPanel panel;
	private JTextField tf_ID; // ID를 입력받을곳
	private JTextField tf_IP; // IP를 입력받을곳
	ImageIcon ic  = new ImageIcon("C:\\Users\\skuin\\Desktop\\FinalProject\\src\\ChatClient\\pink.png");

	public Client() // 생성자
	{
		super("다정톡");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 200);
		setBackground(Color.WHITE);
		panel = new JPanel() {
			 {
		            setOpaque(false);
		     }
			public void paintComponent(Graphics g) {
				 Image img = new ImageIcon("C:\\Users\\skuin\\Desktop\\FinalProject\\src\\ChatClient\\pink.png").getImage();
		         g.drawImage(img, 0, 0, null);
		         super.paintComponent(g);
		      }
		};
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(53, 18, 90, 34);
		lblNewLabel.setFont(new Font("HY엽서L", Font.PLAIN, (int) 15));
		panel.add(lblNewLabel);

		tf_ID = new JTextField();
		tf_ID.setBounds(92, 20, 150, 21);
		panel.add(tf_ID);
		tf_ID.setColumns(10);

		// ID 입력칸
		
		JLabel lblServerIp = new JLabel("IP");
		lblServerIp.setFont(new Font("HY엽서L", Font.PLAIN, (int) 15));
		lblServerIp.setBounds(53, 53, 90, 34);
		panel.add(lblServerIp);

		tf_IP = new JTextField();
		tf_IP.setColumns(10);
		tf_IP.setBounds(92, 60, 150, 21);
		panel.add(tf_IP);
		
		// IP 입력칸
		JButton btnNewButton = new JButton("접    속");
		btnNewButton.setBounds(36, 90, 206, 52);
		btnNewButton.setFont(new Font("HY엽서L", Font.PLAIN, (int) 20));
		btnNewButton.setBackground(Color.lightGray);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String _id = tf_ID.getText().trim(); 
				String _ip= tf_IP.getText().trim(); 
				
				MainView view = new MainView(_id,_ip,5000);
				setVisible(false);				
			}
		});
		// IP와 ID를 입력했을경우 채팅창으로 넘어간다.
		

	}


}
