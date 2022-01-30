import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	    JLabel jl,jl1,jl2 ;
		JTextField jt ;
		JPasswordField jp ;
		JButton jb ;
		 Font f ;
		 public Login(String s){
			 super(s);
			 setLayout(null);
			 f = new Font("Brush Script MT",Font.BOLD,35);
			 jl = new JLabel("Email:");
			 jl.setFont(f);
			 jl1 = new JLabel("Password");
			 jl1.setFont(f);
			 jt = new JTextField(20);
			 jt.setFont(f);
			 jp = new JPasswordField(20);
			 jp.setFont(f);
			 jl2 = new JLabel(new ImageIcon("login.jpg"));
			 jb = new JButton(new ImageIcon("submit.jpg"));
			 jb.setFont(f);
			 
			 jl.setBounds(350,300,160,30);
 			 jt.setBounds(540,300,240,30);
			 jl1.setBounds(350,400,160,30);
 			 jp.setBounds(540,400,240,30);
			 jb.setBounds(490,500,150,30);
			 jl2.setBounds(0,0,1000,1000);
			 add(jl);
			 add(jt);
			 add(jl1);
			 add(jp);
			 add(jb);
			 add(jl2);
			 jb.addActionListener(this);
			 
		 }
		 public void actionPerformed(ActionEvent e){
			  String email = jt.getText();
			  String pass  = jp.getText();
			  try{
				   Class.forName("com.mysql.jdbc.Driver");
				   Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				   Statement st  = cn.createStatement();
				   ResultSet rs  = st.executeQuery("select * from admin where email='"+email+"'");
				   if(rs.next()){
					    if(rs.getString("password").equals(pass)){
							 Management d = new Management("Management Panel");
							 d.setSize(800,1000);
							 d.setVisible(true);
							 this.setVisible(false);
							
						}
						else{
							 JOptionPane.showMessageDialog(null,"Invalid Password");
					   
					    }
				   }
				   else{
					    JOptionPane.showMessageDialog(null,"Invalid Email-Id");
					   
				   }
				  cn.close();
			  }
			  catch(Exception er){
				  JOptionPane.showMessageDialog(null,er.getMessage());
			  }
			  
		 }
          
}
			 
			 