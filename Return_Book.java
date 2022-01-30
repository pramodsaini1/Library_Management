import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Return_Book extends JFrame implements ActionListener{
	      JLabel jl1,jl2 ;
		  JTextField jt1,jt2 ;
		  JButton jb1,jb2,jb3 ;
		  JLabel header,body;
		  Font f ;
		  public Return_Book(String s){
			  super(s);
			  setLayout(null);
			 f = new Font("Courier New Lucida Console",Font.BOLD,18);
			 
			  header = new JLabel(new ImageIcon("body.jpg"));
			  body   = new JLabel(new ImageIcon("header.jpg"));
			  
			  jl1 = new JLabel("Book Callno:");
			  jl1.setFont(f);
			  
			  jl2 = new JLabel("Student-Id:");
			  jl2.setFont(f);
			  
			  jt1 = new JTextField(20);
			  jt1.setFont(f);
			  
			  jt2 = new JTextField(20);
			  jt2.setFont(f);
			  
			  jb1 = new JButton(new ImageIcon("return_book.jpg"));
			  jb1.setFont(f);
			  
			  jb2 = new JButton(new ImageIcon("exit.jpg"));
			  jb2.setFont(f);
			  
			  jb3 = new JButton(new ImageIcon("logout.jpg"));
			  jb3.setFont(f);
			  
			  header.setBounds(0,0,950,200);
			  body.setBounds(0,200,950,800);
			  
			  jl1.setBounds(130,450,130,30);
			  jt1.setBounds(270,450,180,30);
			  jb2.setBounds(470,450,180,30);
			  
			  jl2.setBounds(130,500,130,30);
			  jt2.setBounds(270,500,180,30);
			  jb3.setBounds(470,500,180,30);
			  
			  jb1.setBounds(170,600,180,50);
			  
			  add(jl1);
			  add(jt1);
			  
			  add(jl2);
			  add(jt2);
			  
			  add(jb1);
			  add(jb2);
			  add(jb3);
			  
			  add(header);
			  add(body);
			  
			  jb1.addActionListener(this);
			  jb2.addActionListener(this);
			  jb3.addActionListener(this);
			  
			  
		  }
		  public void actionPerformed(ActionEvent e){
			  if(e.getSource()==jb1){
				   String bookcall = jt1.getText();;
				   int s_id = Integer.parseInt(jt2.getText());
                   try{
                        Class.forName("com.mysql.jdbc.Driver");
						Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
						Statement st = cn.createStatement();
						ResultSet rs = st.executeQuery("select * from issue where bookcallno='"+bookcall+"' AND student_id="+s_id+"");
 						if(rs.next()){
							int status=1 ;
							PreparedStatement ps = cn.prepareStatement("update issue set status="+status+" where student_id="+s_id+"");
							if(ps.executeUpdate()>0){
								JOptionPane.showMessageDialog(null,"Retun Book successfully");
								Return_Book d = new Return_Book("Return Book  Panel");
					            d.setSize(950,1000);
				               d.setVisible(true);
							   this.setVisible(false);
							}
							else{
								JOptionPane.showMessageDialog(null,"Sorry,unable to return book");
								Return_Book d = new Return_Book("Return Book  Panel");
					            d.setSize(950,1000);
				               d.setVisible(true);
							   this.setVisible(false);
								
							}
						}
						else{
							JOptionPane.showMessageDialog(null,"Sorry,Invalid student id and book id");
								Return_Book d = new Return_Book("Return Book  Panel");
					            d.setSize(950,1000);
				               d.setVisible(true);
							   this.setVisible(false);
								
						}
                   }
                   catch(Exception em){
                       JOptionPane.showMessageDialog(null,em.getMessage());

                   }				   
			  }
			  else if(e.getSource()==jb2){
				   Librarian_Management d = new Librarian_Management(" Librarian Management Panel");
					   d.setSize(950,1000);
				      d.setVisible(true);
					   this.setVisible(false);
				  
			  }
			  else if(e.getSource()==jb3){
				   librarian_login d = new librarian_login("Librarian Login Panel");
					   d.setSize(950,1000);
				      d.setVisible(true);
					   this.setVisible(false);
				  
			  }
			  
		  }
		  public static void main(String[]arr){
			    Return_Book d = new Return_Book("Return Book  Panel");
					   d.setSize(950,1000);
				      d.setVisible(true);
			  
			  
		  }
		   
}