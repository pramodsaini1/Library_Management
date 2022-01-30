import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener {
	      JButton jb,jb1,jb2;
		  Font f ;
		  JLabel header,body;
		  Admin(String s){
			  super(s);
			  setLayout(null);
			  header = new JLabel(new ImageIcon("lib.jpg"));
			  body= new JLabel(new ImageIcon("3.jpg"));
			 f = new Font("Courier New Lucida Console",Font.BOLD,18);
			  jb =  new JButton(new ImageIcon("admin.jpg"));
			  jb.setFont(f);
			  jb1 = new JButton(new ImageIcon("ll.jpg"));
			  jb1.setFont(f);
			   
			  jb.setBounds(100,350,180,60);
			  jb1.setBounds(300,550,180,60);
  			   
              header.setBounds(0,0,950,200);
			  body.setBounds(0,180,950,820);			
			  
			  add(jb);
			  add(jb1);
 			   add(header);
			  add(body);
			  jb.addActionListener(this);
			  jb1.addActionListener(this);
 			  
		  }
		  public void actionPerformed(ActionEvent e){ 
			   if(e.getSource()==jb){
				    Login d = new Login("Login Panel");
					d.setVisible(true);
					d.setSize(950,1000);
					this.setVisible(false);
				   
			   }
			   else if(e.getSource()==jb1){
				     librarian_login d = new librarian_login(" Librarian Login Panel");
					d.setVisible(true);
					d.setSize(950,1000);
					this.setVisible(false);
				   
			   }
			    
			    
			  
		  }
		  public static void main(String[]arr){
			 Admin d = new Admin("Library Management Panel");
             d.setSize(950,1000);
             d.setVisible(true);			 
			  
			  
		  }
		   
		  
}
		  