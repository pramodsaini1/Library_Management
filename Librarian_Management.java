import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Librarian_Management extends JFrame implements ActionListener {
	      JButton jb,jb1,jb2,jb3,jb4,jb5,jb6;
		  Font f ;
		  JLabel header,body;
		  Librarian_Management(String s){
			  super(s);
			  setLayout(null);
			  header=new JLabel(new ImageIcon("lib5.jpg"));
			   body=new JLabel(new ImageIcon("mk.jpg"));
			 f = new Font("Courier New Lucida Console",Font.BOLD,18);
			  jb =  new JButton(new ImageIcon("book.jpg"));
			  jb.setFont(f);
			  jb1 = new JButton(new ImageIcon("View_Book.jpg"));
			  jb1.setFont(f);
			  jb2 = new JButton(new ImageIcon("issue_book.jpg"));
			  jb2.setFont(f);
			  jb3 = new JButton(new ImageIcon("view_issued.jpg"));
			  jb3.setFont(f);
			  jb4 = new JButton(new ImageIcon("return_book.jpg"));
			  jb4.setFont(f);
			  jb5 = new JButton(new ImageIcon("exit.jpg"));
			  jb5.setFont(f);
			  jb6 = new JButton(new ImageIcon("logout.jpg"));
			  jb6.setFont(f);
			   header.setBounds(0,0,950,200);
			  body.setBounds(0,200,950,800);	
			  
			  jb.setBounds(0,250,180,50);
			   jb1.setBounds(100,340,180,50);
			   jb3.setBounds(200,430,240,50);
			  jb4.setBounds(300,520,180,50);
			  jb2.setBounds(400,620,180,50);
			  jb5.setBounds(500,720,180,50);
			  jb6.setBounds(600,820,180,50);
			  
			  add(jb);
			  add(jb1);
			  add(jb2);
			  add(jb3);
			  add(jb4);
			  add(jb5);
			  add(jb6);
			    add(header);
			  add(body);
			  jb.addActionListener(this);
			  jb1.addActionListener(this);
			  jb2.addActionListener(this);
			  jb3.addActionListener(this);
			  jb4.addActionListener(this);
			  jb5.addActionListener(this);
			  jb6.addActionListener(this);
			  
		  }
		  public void actionPerformed(ActionEvent e){ 
			     if(e.getSource()==jb){
					 Book d = new Book("Add Book Panel");
				     d.setSize(950,1000);
				      d.setVisible(true);
					 this.setVisible(false);
				 }
				 else if(e.getSource()==jb1){
					 View_Book d = new View_Book("View Book Panel");
				     d.setSize(950,1000);
				      d.setVisible(true);
					 this.setVisible(false);
				 }
				 else if(e.getSource()==jb2){
					  Issue_Book d = new Issue_Book("Issue Book");
					   d.setSize(950,1000);
				      d.setVisible(true);
					   this.setVisible(false);
				 }
				 else if(e.getSource()==jb3){
					 View_Issued_Book d = new View_Issued_Book("View Issue  Book");
					   d.setSize(950,1000);
				      d.setVisible(true);
					  this.setVisible(false);

					 
				 }
				 else if(e.getSource()==jb4){
					  Return_Book d = new Return_Book("Return Book");
					   d.setSize(950,1000);
				      d.setVisible(true);
					   this.setVisible(false);
					 
				 }
				 else if(e.getSource()==jb5){
					Admin d = new Admin ("Admin Panel");
					   d.setSize(950,1000);
				      d.setVisible(true);
					   this.setVisible(false);
					 
					 
				 }
				 else if(e.getSource()==jb6){
					 librarian_login d = new librarian_login("Librarian Login Panel");
					   d.setSize(950,1000);
				      d.setVisible(true);
					   this.setVisible(false);
					 
					 
				 }
			    
			  
		  }
		  public static void main(String[]arr){
			    Librarian_Management d = new Librarian_Management("Librarian Management Panel");
					   d.setSize(950,1000);
				      d.setVisible(true);
			  
			  
			  
		  }
		    
		  
		   
		  
}
		  