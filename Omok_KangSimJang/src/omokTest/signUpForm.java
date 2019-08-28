package omokTest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class signUpForm extends JFrame implements ActionListener{
//	 implements ActionListene
	JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JPasswordField passwordField;
	JPasswordField passwordField_1;
	Connection con = null;
	ResultSet rs;
    Statement stmt;
    JButton btnNewButton, btnNewButton_1;
	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUpForm frame = new signUpForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signUpForm() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 300, 289, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(221,221,221));
		setTitle("강심장_회원가입");
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("DungGeunMo", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.white);
		//lblNewLabel.setFont("맑은 고딕",16);
		lblNewLabel.setBounds(23, 33, 200, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setBounds(23, 83, 57, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(23, 98, 210, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(Color.yellow);
		lblNewLabel_2.setBounds(23, 134, 57, 15);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(23, 148, 210, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("패스워드");
		lblNewLabel_3.setForeground(Color.green);
		lblNewLabel_3.setBounds(23, 179, 70, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("패스워드 확인");
		lblNewLabel_4.setForeground(Color.green);
		lblNewLabel_4.setBounds(23, 230, 90, 15);
		panel.add(lblNewLabel_4);
		
		 btnNewButton = new JButton("확인");
		btnNewButton.setBounds(56, 294, 70, 23);
		btnNewButton.setBackground(new Color(191,128,78));
		btnNewButton.setForeground(Color.white);
	    btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBackground(new Color(191,128,78));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setBounds(127, 294, 70, 23);
		btnNewButton_1.addActionListener(this);
		panel.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(24, 193, 210, 21);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(23, 245, 210, 23);
		panel.add(passwordField_1);
	}


	 
	 public void SignConn() throws SQLException {
		try {
			//버튼을 눌렀을때로 수정
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버연결
			String url = "jdbc:mysql://localhost:3306/omok_db?serverTimezone=UTC"; // DB연결
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("데이터베이스 연결 성공");
			
			JTextField idch = new JTextField("");
			JTextField emailch = new JTextField("");
			
			
	  	    String id = textField.getText();
		    String idtwo = idch.getText();
		    String emailtwo = emailch.getText();
	  	    String email = textField_1.getText();
		    String check = passwordField.getText();
		    String checktwo =passwordField_1.getText();
		   
		    int win = 0;
		    int lose = 0;
		    stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user_info");
			String insertQuery = "INSERT INTO user_info(user_id, user_pass, user_email, user_win, user_lose) VALUES('"+ id +"','"+ check +"','"+ email+"','"+ win +"','" + lose +"')";
		
			System.out.println(insertQuery);
			System.out.println(check + checktwo);
             
			
		
			
			if(!check.equals(checktwo) || id.equals(idtwo) || email.equals(emailtwo)) {
				 System.out.println("정보를 모두 입력하지 않았거나 비밀번호가 다릅니다. 다시 확인해주세요.");
				 return;
			}

			int i = stmt.executeUpdate(insertQuery);
			if (i == 1 ) {
				System.out.println("회원가입을 축하드립니다.");
			    dispose();
			}
		
			else {
				System.out.println("빈칸이 있거나 중복된 아이디입니다.");
				return;
			}
		} catch (ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("중복된 아이디 입니다.");
	} 
 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton)
		{
			try {
				SignConn();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(e.getSource() == btnNewButton_1) {
			dispose();
		}
	}
}
