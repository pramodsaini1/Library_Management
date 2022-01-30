import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Management extends JFrame implements ActionListener {
	      JButton jb,jb1,jb2,jb3;
		  Font f ;
		  JLabel header ,body;
		  Management(String s){
			  super(s);
			  setLayout(null);
			  header = new JLabel(new ImageIcon("2.jpg"));
			  body = new JLabel(new ImageIcon("lib2.jpg"));
			 f = new Font("Courier New Lucida Console",Font.BOLD,18);
			  jb =  new JButton(new ImageIcon("librarian.jpg"));
			  jb.setFont(f);
			  jb1 = new JButton(new ImageIcon("view.jpg"));
			  jb1.setFont(f);
			  jb2 = new JButton(new ImageIcon("logout.jpg"));
			  jb2.setFont(f);
			   jb3 = new JButton(new ImageIcon("exit.jpg"));
			  jb3.setFont(f);
			  
			  header.setBounds(0,0,950,200);
			  body.setBounds(0,200,950,800);	
			  
			  jb.setBounds(0,250,180,50);
			  jb1.setBounds(180,400,180,50);
			  jb2.setBounds(360,550,180,50);
			   jb3.setBounds(600,700,180,50);
			  
			  
			  add(jb);
			  add(jb1);
			  add(jb2);
			  add(jb3);
			   add(header);
			   add(body);
			   
			  jb.addActionListener(this);
			  jb1.addActionListener(this);
			  jb2.addActionListener(this);
			  jb3.addActionListener(this);
			  
		  }
		  public void actionPerformed(ActionEvent e){ 
			   if(e.getSource()==jb){
				    Librarian d = new Librarian("Add Librarian");
					d.setVisible(true);
					d.setSize(800,1000);
					this.setVisible(false);
				   
			   }
			   else if(e.getSource()==jb1){
				     View_Librarian d = new View_Librarian("View Librarian");
					d.setVisible(true);
					d.setSize(950,1000);
					this.setVisible(false);
				   
			   }
			   else if(e.getSource()==jb2){
				   Login d = new Login("Login Panel");
				    d.setSize(950,1000);
				   d.setVisible(true);
				   this.setVisible(false); 
				   
			   }
			   else if(e.getSource()==jb3){
				    Admin d = new  Admin("Admin Panel");
				    d.setSize(950,1000);
				   d.setVisible(true);
				   this.setVisible(false); 
				   
			   }
			    
			  
		  }
		  public static void main(String[]arr){
			  Management d = new  Management("Management Panel");
				    d.setSize(950,1000);
				   d.setVisible(true);
			  
			  
			  
		  }
		   
		  
}
		  