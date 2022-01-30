import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel ;

public class View_Issued_Book extends JFrame implements ActionListener{
	   JButton jb,jb1 ;
	   DefaultTableModel dtm=null ;
	   JTable jt =null ;
	   JScrollPane js = null ;
	   Font f,f1 ;
	   JLabel header ,body;
 	   View_Issued_Book(String s){
		   super(s);
		   setLayout(null);
		     header = new JLabel(new ImageIcon("pk.jpg"));
		     body = new JLabel(new ImageIcon("15.jpg"));
			  f = new Font("Courier New Lucida Console",Font.BOLD,18);
			  f1 = new Font("Courier New Lucida Console",Font.BOLD,13);
			  jb = new JButton(new ImageIcon("exit.jpg"));
			  jb.setFont(f);	
			  jb1 = new JButton(new ImageIcon("logout.jpg"));
			  jb1.setFont(f);
			  
			  dtm = new DefaultTableModel();
			  jt  = new JTable();
			  jt.setFont(f1);
			  			  

			  dtm.addColumn("ID");
			  dtm.addColumn("Bookcallno");
			  dtm.addColumn("Student-id");
			  dtm.addColumn("Student-name");
			  dtm.addColumn("Contact");
			  dtm.addColumn("IssuedDate");
			   
			  try{
					  Class.forName("com.mysql.jdbc.Driver");
					  Connection cn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					  Statement st = cn.createStatement();
					  ResultSet rs = st.executeQuery("select * from issue ");
					  int status=0;
					  while(rs.next()){
						  if(rs.getInt("status")==0){
 			                dtm.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
						  }
					 }
					  cn.close();
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(null,er.getMessage());
				
			}
			
			 
			header.setBounds(0,0,950,200);
			body.setBounds(0,200,950,800);
			
			  jb.setBounds(200,250,180,50);
			  jb1.setBounds(450,250,180,50);
			  
			  jt.setModel(dtm);
			  js = new JScrollPane(jt);
			  js.setBounds(50,380,850,500);
              add(js);
			  
			  add(jb);
			  add(jb1);
			  add(header);
			  add(body);
			  
			  jb.addActionListener(this);
			  jb1.addActionListener(this);
	   }
	   public void actionPerformed(ActionEvent e){
		    if(e.getSource()==jb){
				Librarian_Management d = new Librarian_Management("Librarian Management Panel");
				   d.setSize(950,1000);
				   d.setVisible(true);
				   this.setVisible(false);
				 
			}
			else if(e.getSource()==jb1){
				   librarian_login d = new librarian_login(" Librarian Login Panel");
				    d.setSize(950,1000);
				   d.setVisible(true);
				   this.setVisible(false); 
				  
			}
			 
	   }
	   public static void main(String[]arr){
		    View_Issued_Book d = new View_Issued_Book("  Panel");
				    d.setSize(950,1000);
				   d.setVisible(true);
		   
		   
	   }
	    
	    
}
		   
		   
		   
		   
		   
		   
		   
		   
	   