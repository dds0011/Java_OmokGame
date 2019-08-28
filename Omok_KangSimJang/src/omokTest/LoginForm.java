package omokTest;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLoginForm login = new MyLoginForm();
		login.display();
	}

}
class MyLoginForm extends JFrame implements ActionListener{
	Connection con = null;
	ResultSet rs;
    Statement stmt;
	Container cPane;
	ImageIcon img;
	JLabel ImgBox;
	JPanel p0,p1,p2,p3;
	JPanel p4; // 버튼 올리는 패널 FlowLayout
	JPanel p5,p6; // id,pw,tf 올리는 패널 FlowLayout
	
	JLabel l_id, l_passwd;
	JButton b_join, b_login, b_close;
	JTextField tf_id;
	JPasswordField tf_passwd;
	
	Font font = new Font("210 옴니고딕", Font.BOLD,17);

	MyLoginForm(){
		cPane=getContentPane();
		cPane.setLayout(null);
		ImgBox = new JLabel(""); 
		ImageIcon img = new ImageIcon("./omok_login.jpg");
		p0 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(img.getImage(),0,0,d.width,550,null);
				//g.drawImage(img.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		
		l_id = new JLabel("아  이  디 ");
		l_id.setFont(font);
		l_id.setForeground(Color.white);
		l_passwd = new JLabel("비밀번호 ");
		l_passwd.setForeground(Color.white);
		l_passwd.setFont(font);
		
		b_login = new JButton("로 그 인");
		b_login.setFont(font);
		b_login.setBackground(new Color(191,128,78));
		b_login.setForeground(new Color(255,255,255));
		b_login.addActionListener(this);
		
		b_join = new JButton("회원가입");
		b_join.setFont(font);
		b_join.setBackground(new Color(191,128,78));
		b_join.setForeground(new Color(255,255,255));
		b_join.addActionListener(this);
		
		b_close = new JButton("종    료");
		b_close.setFont(font);
		b_close.setBackground(new Color(191,128,78));
		b_close.setForeground(new Color(255,255,255));
		b_close.addActionListener(this);
		
		b_join.setBorderPainted(false);
		b_join.setDefaultCapable(false);
		b_join.setFocusPainted(false);
		
		b_login.setBorderPainted(false);
		b_login.setDefaultCapable(false);
		b_login.setFocusPainted(false);
		
		b_close.setBorderPainted(false);
		b_close.setDefaultCapable(false);
		b_close.setFocusPainted(false);

		tf_id = new JTextField(17);
		tf_passwd = new JPasswordField(17);
		
		// 버튼 이미지
		
		//버튼 이벤트

		p4 = new JPanel();
	
		p4.setLayout(new FlowLayout());
		p4.setOpaque (false);
		
		p4.add(b_join);
		p4.add(b_login);
		p4.add(b_close);
		 
		p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		p5.setOpaque (false);
		p5.add(l_id);
		p5.add(tf_id);
		
		p6 = new JPanel();
		p6.setLayout(new FlowLayout());
		p6.setOpaque (false);
		p6.add(l_passwd);
		p6.add(tf_passwd);

		p0.setOpaque(true);
		p0.setPreferredSize(new Dimension(900,600));
		p1.setBounds(50,330,800,300);
		p0.setLayout(null);
		p3.setLayout(new BoxLayout(p3,3));
		
		p3.add(p5);
		p3.add(p6);
		p3.add(p4);

		p1.add(p3);
		p1.setBackground(new Color(0,0,0,0));
		p3.setBackground(new Color(0,0,0,0));

		cPane.add(p0);
		p0.add(p1);

	}

	void display() {
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(900,600);
		setLocation(300,200);
		setTitle("강심장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public void Login() throws SQLException {
		try {
			//버튼을 눌렀을때로 수정
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버연결
			String url = "jdbc:mysql://localhost:3306/omok_db?serverTimezone=UTC"; // DB연결
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("데이터베이스 연결 성공");
		
	  	    String idtext = tf_id.getText();
		    String passtext = tf_passwd.getText();
		    
		    stmt = con.createStatement();

			String LoginQuery = "SELECT * FROM user_info where user_id ='"+idtext+"'";
			System.out.println(LoginQuery);
			
			rs = stmt.executeQuery(LoginQuery);
		
			//rs실행 (SELECT)
			if(rs.next() && !idtext.equals("") && !passtext.equals(""))
			{
				String id = rs.getString("user_id");
				String pass = rs.getString("user_pass");
				String win = rs.getString("user_win");
				String lose = rs.getString("user_lose");
//				lblNewLabel = new JLabel("아이디"+id);			
//				lblNewLabel_1 = new JLabel("승:"+win+"패:"+lose);
				System.out.println(id);
				if(!pass.equals(passtext)) {
					System.out.println("비밀번호가 일치하지 않습니다.");
				
				}
				else {
					MainForm ma = new MainForm();
					ma.setVisible(true);
					System.out.println("비밀번호가 일치합니다.");
				}
			}
			else {
			    System.out.println("빈칸이 있거나 아이디가 존재하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			
		} catch (SQLException e) {
			System.out.println("연결실패"+e);
      } 
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		if(arg0.getSource()==b_login) {
			try {
				Login();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
		}
		if(arg0.getSource()==b_close) {
			dispose();
		}
		
		if(arg0.getSource()==b_join) {
			
			signUpForm form = new signUpForm();
			form.setVisible(true);
		}
	}

}





	    

