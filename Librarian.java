import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Librarian extends JFrame implements ActionListener{
	    JLabel jl0,jl,jl1,jl2,jl3,jl4,jl5;
		JTextField  jt0,jt ,jt1,jt2,jt3,jt4,jt5 ;
		JButton jb,jb1,jb2,jb3,jb4;
		JPasswordField jp ;
		Font f ;
		int flag ;
		JLabel header ,body ;
		Librarian(String s){
			 super(s);
			 setLayout(null);
			 flag=0;
			 header = new JLabel(new ImageIcon("lib3.jpg"));
			 body = new JLabel(new ImageIcon("lib8.jpg"));
			 f = new Font("Courier New Lucida Console",Font.BOLD,18);
			 jl0 = new JLabel("Librarian Id:");
			 jl0.setFont(f);
			 
			 jt0 = new JTextField(20);
			 jl = new JLabel("Name :");
			 jl.setFont(f);
			 jl1 = new JLabel("Email-Id:");
			 jl1.setFont(f);
			 jl2 = new JLabel("Password:");
			 jl2.setFont(f);
			 jl3 = new JLabel("Address:");
			 jl3.setFont(f);
			 jl4 = new JLabel("City:");
			 jl4.setFont(f);
			 jl5 = new JLabel("Contact No:");
			 jl5.setFont(f);
			 
			 jt = new JTextField(20);
			 jt.setFont(f);
			 jt1 = new JTextField(20);
			 jt1.setFont(f);
			 jp = new JPasswordField(20);
			 jp.setFont(f);
			 jt3 = new JTextField(20);
			 jt3.setFont(f);
			 jt4 = new JTextField(20);
			 jt4.setFont(f);
			 jt5 = new JTextField(20);
			 jt5.setFont(f);
			 
			 jb = new JButton(new ImageIcon("librarian.jpg"));
			 jb.setFont(f);
			 jb1 = new JButton(new ImageIcon("edit.jpg"));
			 jb1.setFont(f);
			 jb2 = new JButton(new ImageIcon("delete.jpg"));
			 jb2.setFont(f);
			 jb3 = new JButton(new ImageIcon("exit.jpg"));
			 jb3.setFont(f);
			 jb4 = new JButton(new ImageIcon("logout.jpg")); 
			 jb4.setFont(f);
			 header.setBounds(0,0,950,200);
			  body.setBounds(0,200,950,800);
             jl0.setBounds(100,250,130,30);
			 jt0.setBounds(250,250,180,30);
			 jt0.setFont(f);
			jl.setBounds(100,300,130,30);
			jt.setBounds(250,300,150,30);
			jb1.setBounds(420,300,180,30);
			
			jl1.setBounds(100,350,130,30);
			jt1.setBounds(250,350,150,30);
			jb2.setBounds(420,350,180,30);
			
			jl2.setBounds(100,400,130,30);
			jp.setBounds(250,400,150,30);
			jb3.setBounds(420,400,180,30);
			
			jl3.setBounds(100,450,130,30);
			jt3.setBounds(250,450,150,30);
			jb4.setBounds(420,450,180,30);
			
			jl4.setBounds(100,500,130,30);
			jt4.setBounds(250,500,150,30);
			
			jl5.setBounds(100,550,130,30);
			jt5.setBounds(250,550,150,30);
			
			jb.setBounds(150,650,180,50);
			add(jl0);
			add(jt0);
			
			add(jl);
			add(jt);
			
			add(jl1);
			add(jt1);
			
			add(jl2);
			add(jp);
			
			add(jl3);
			add(jt3);
			
			add(jl4);
			add(jt4);
			
			add(jl5);
			add(jt5);
			
			add(jb);
			add(jb1);
			add(jb2);
			add(jb3);
			add(jb4);
			add(header);
			add(body);
			jb.addActionListener(this);
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jb3.addActionListener(this);
			jb4.addActionListener(this);
			
		}
		public void actionPerformed(ActionEvent e){
			int id = Integer.parseInt(jt0.getText());
			 String name = jt.getText();
			 String email = jt1.getText();
			 String pass  = jp.getText();
			 String address = jt3.getText();
			 String city   = jt4.getText();
			 String contact = jt5.getText();
			 
			 
			 if(e.getSource()==jb3){
				 Management d = new Management("Management Panel");
				   d.setSize(950,1000);
				   d.setVisible(true);
				   this.setVisible(false);
				 
			 }
			 else if(e.getSource()==jb4){
				  Login d = new Login("Login Panel");
				    d.setSize(950,1000);
				   d.setVisible(true);
				   this.setVisible(false);
				 
			 }
			 else if(e.getSource()==jb1||e.getSource()==jb2){
				  if(e.getSource()==jb1){
					  flag=1 ;
					  
					  
				  }
				  else if(e.getSource()==jb2){
					  flag=2 ;
				  }
				  try{
					  Class.forName("com.mysql.jdbc.Driver");
					  Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					  Statement st  = cn.createStatement();
					  ResultSet rs  = st.executeQuery("select * from librarian where l_id="+id+"");
					  if(rs.next()){
						   jt.setText(rs.getString("name"));
						   jt1.setText(rs.getString("email"));
						   jp.setText(rs.getString("password"));
						   jt3.setText(rs.getString("address"));
						   jt4.setText(rs.getString("city"));
						   jt5.setText(rs.getString("contact"));
					  }
					  else{
						   JOptionPane.showMessageDialog(null,"Invalid Librarian id");
					  }
					  
				  }
				  catch(Exception er){
					  JOptionPane.showMessageDialog(null,er.getMessage());
					  
				  }
 				 
			 }
			 else{
				    try{
						 Class.forName("com.mysql.jdbc.Driver");
						 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
						 if(flag==0){
							 PreparedStatement ps = cn.prepareStatement("insert into librarian values(?,?,?,?,?,?,?)");
							 ps.setInt(1,id);
							 ps.setString(2,name);
							 ps.setString(3,email);
							 ps.setString(4,pass);
							 ps.setString(5,address);
							 ps.setString(6,city);
							 ps.setString(7,contact);
							 if(ps.executeUpdate()>0){
								 JOptionPane.showMessageDialog(null,"Librarian added successfully");
								  Librarian d = new Librarian("Add Librarian");
								 d.setSize(950,1000);
								 d.setVisible(true);
								 this.setVisible(false);
							 }
							 else{
								 JOptionPane.showMessageDialog(null,"Librarian added Not successfully");
								  Librarian d = new Librarian("Add Librarian");
								 d.setSize(950,1000);
								 d.setVisible(true);
								 this.setVisible(false);
							 }						 
						 }
						 else if(flag==1){
							 PreparedStatement ps = cn.prepareStatement("update librarian set name=?,email=?,password=?,address=?,city=?,contact=? where l_id=?");
							 ps.setString(1,name);
							 ps.setString(2,email);
							 ps.setString(3,pass);
							 ps.setString(4,address);
							 ps.setString(5,city);
							 ps.setString(6,contact);
							 ps.setInt(7,id);
							 if(ps.executeUpdate()>0){
								 JOptionPane.showMessageDialog(null,"Librarian Updated");
								  Librarian d = new Librarian("Add Librarian");
								 d.setSize(950,1000);
								 d.setVisible(true);
								 this.setVisible(false);
							 }
							 else{
								 JOptionPane.showMessageDialog(null,"Librarian Not Updated");
								  Librarian d = new Librarian("Add Librarian");
								 d.setSize(950,1000);
								 d.setVisible(true);
								 this.setVisible(false);
							 }
							 
						 }
						 else if(flag==2) {
							 PreparedStatement ps = cn.prepareStatement("delete from librarian where l_id=?");
							 ps.setInt(1,id);
							 if(ps.executeUpdate()>0){
								 JOptionPane.showMessageDialog(null,"Librarian Deleted");
								  Librarian d = new Librarian("Add Librarian");
						           d.setSize(950,1000);
						           d.setVisible(true);
						           this.setVisible(false);
							 }
							 else{
								 JOptionPane.showMessageDialog(null,"Librarian Not Deleted");
								  Librarian d = new Librarian("Add Librarian");
						         d.setSize(950,1000);
						         d.setVisible(true);
						         this.setVisible(false);
							 }
							 
						 }
						
					}
					catch(Exception ep){
						 JOptionPane.showMessageDialog(null,ep.getMessage());
						 Librarian d = new Librarian("Add Librarian");
						 d.setSize(950,1000);
						 d.setVisible(true);
						 this.setVisible(false);
					}
				 
			 }
			
			
		}
		public static void main(String[]arr){
			 Librarian d = new Librarian("Add Librarian");
						 d.setSize(950,1000);
						 d.setVisible(true);
			
		}
		 
}