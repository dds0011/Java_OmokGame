package omokTest;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class MainForm extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JTextField textField;
   private JPanel panel;
   JButton btnNewButton, btnNewButton_1,btnNewButton_2;
   //private ImageIcon black,white;
   boolean check =false;
   //////
   private Container c;
   String newline = "\n";

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	MainForm main = new MainForm();
               main.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public MainForm() {
	   
	  //이미지 생성
	  //ImageIcon img = new ImageIcon("jpg");
	   
	  c= getContentPane();
      setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      setTitle("강심장");
      setBounds(300, 200, 900, 600);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setBackground(Color.gray);
      setContentPane(c);
      contentPane.setLayout(null);
      //contentPane.setOpaque(false);
		
      
      ImageIcon black = new ImageIcon("./black.png");
      ImageIcon white = new ImageIcon("./white.png");
      
	  
	  //addMouseListener(new MouseEventHandler(map, size, d, this));
	  setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      panel = new JPanel();
      //panel.setBackground(new Color(191,128,78));
      panel.setBounds(0, 0, 570, 561);
      panel.setLayout(null);
      //panel.setOpaque(false);   
      
    
    	  
      
       MapSize size = new MapSize();
       Map map = new Map(size);
       DrawBoard d = new DrawBoard(size,map);
       d.addMouseListener(new MouseEventHandler(map, size, d, this));
       panel.add(d);
       d.setVisible(false);
        
      	  
      contentPane.add(panel);	  
    		  
      btnNewButton = new JButton("시작");
      btnNewButton.setBounds(590, 280, 74, 23);
      btnNewButton.setBackground(Color.black);
      btnNewButton.setForeground(Color.pink);
      btnNewButton.setBorderPainted(false);
      btnNewButton.setDefaultCapable(false);
      btnNewButton.setFocusPainted(false);
      btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btnNewButton.setEnabled(false);
				d.setVisible(true);
				//다이얼로그
			}
			});
      contentPane.add(btnNewButton);
      
      btnNewButton_1 = new JButton("기권");
      btnNewButton_1.setBounds(687, 280, 76, 23);
      btnNewButton_1.setBackground(Color.black);
      btnNewButton_1.setForeground(Color.yellow);
      btnNewButton_1.setBorderPainted(false);
      btnNewButton_1.setDefaultCapable(false);
      btnNewButton_1.setFocusPainted(false);
      btnNewButton_1.addActionListener(this);
      
      contentPane.add(btnNewButton_1);
      
      btnNewButton_2 = new JButton("나가기");
      btnNewButton_2.setBounds(786, 280, 78, 23);
      btnNewButton_2.setBackground(Color.black);
      btnNewButton_2.setForeground(Color.green);
      btnNewButton_2.setBorderPainted(false);
      btnNewButton_2.setDefaultCapable(false);
      btnNewButton_2.setFocusPainted(false);
      btnNewButton_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
			});
      contentPane.add(btnNewButton_2);
      
      textField = new JTextField();
      textField.setBounds(590, 530, 275, 21);
      textField.requestFocus();
    
      //textField.addActionListener(l);
      contentPane.add(textField);
     
      textField.setColumns(10);
      
      JTextArea textArea = new JTextArea();
      textArea.setBounds(590, 320, 275, 200);
      textArea.setEditable(false);
      contentPane.add(textArea);
      
      textField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String text = textField.getText();
				textArea.append(text+ newline);
				textField.selectAll();
				textArea.setCaretPosition(textArea.getDocument().getLength());
			    textField.setText("");
			}
			});
      
      
      
      JPanel panel_1 = new JPanel(){
          
          public void paintComponent(Graphics g) {
                
                  Dimension d = getSize();
                  g.drawImage(black.getImage(), 0, 20, 100, 100, null);
                 
                 setOpaque(false);
                 super.paintComponent(g);
               
          }  
          };
          
    panel_1.setBounds(590, 42, 118, 160);
    contentPane.add(panel_1);
    
    JPanel panel_2 = new JPanel(){
       
          public void paintComponent(Graphics g) {
                
                  Dimension d = getSize();
                  g.drawImage(white.getImage(), 10, 20, 100, 100, null);
                 
                 setOpaque(false);
                 super.paintComponent(g);
                 
          }  
          };
      panel_2.setBounds(754, 42, 118, 160);
      contentPane.add(panel_2);
      
      JLabel lblNewLabel = new JLabel("아이디");
      lblNewLabel.setBounds(600, 216, 57, 15);
      contentPane.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("승패");
      lblNewLabel_1.setBounds(600, 241, 57, 15);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("아이디");
      lblNewLabel_2.setBounds(786, 216, 57, 15);
      contentPane.add(lblNewLabel_2);
      
      JLabel lblNewLabel_3 = new JLabel("승패");
      lblNewLabel_3.setBounds(786, 241, 57, 15);
      contentPane.add(lblNewLabel_3);
      
      
      c.add(contentPane);
      //add(c);
     
     
   }
	public void showPopUp(String message) {
		JOptionPane.showMessageDialog(this, message, "", JOptionPane.INFORMATION_MESSAGE);;
		System.exit(0);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	   if(e.getSource() == btnNewButton_1)
	   {
		dispose();
		MyLoginForm mg = new MyLoginForm();
		mg.display();
  
		
	   }
	}
 
}