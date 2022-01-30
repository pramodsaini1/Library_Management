import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel ;
public class View_Librarian extends JFrame implements ActionListener{
	    JButton jb,jb1;
		DefaultTableModel dtm=null;
		JTable jt=null ;
		JScrollPane js = null ;
		Font f ;
	    JLabel header,body;
	    View_Librarian(String s){
			super(s);
			setLayout(null);
			header = new JLabel(new ImageIcon("lib4.jpg"));
			body = new JLabel(new ImageIcon("6.jpg"));
	    	  f = new Font("Courier New Lucida Console",Font.BOLD,14);
			jb = new JButton(new ImageIcon("exit.jpg"));
						 
			jb.setFont(f);
			jb1 = new JButton(new ImageIcon("logout.jpg"));
			jb1.setFont(f);
 			dtm = new DefaultTableModel();
			jt = new JTable();
			jt.setFont(f);
			dtm.addColumn("L-ID");
			dtm.addColumn("L-NAME");
			dtm.addColumn("EMAIL");
			dtm.addColumn("PASSWORD");
			dtm.addColumn("ADDRESS");
			dtm.addColumn("CITY");
			dtm.addColumn("CONTACT");
			add(header);
			add(body);
			try{
					  Class.forName("com.mysql.jdbc.Driver");
					  Connection cn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					  Statement st = cn.createStatement();
					  ResultSet rs = st.executeQuery("select * from librarian");
					  while(rs.next()){
 			             dtm.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
					  }
					  cn.close();
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(null,er.getMessage());
				
			}
			 
	     header.setBounds(0,0,950,200);
		 body.setBounds(0,200,950,800);
 			jb.setBounds(200,300,180,50);
			  jb1.setBounds(450,300,180,50);
			jt.setModel(dtm);
			js = new JScrollPane(jt);
			js.setBounds(50,420,850,400);
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
				Management d = new Management("Management Panel");
				   d.setSize(950,1000);
				   d.setVisible(true);
				   this.setVisible(false);
				 
			}
			else if(e.getSource()==jb1){
				   Login d = new Login("Login Panel");
				    d.setSize(950,1000);
				   d.setVisible(true);
				   this.setVisible(false); 
				  
			}
			 
			
			
		}
		public static void main(String[]arr){
			 View_Librarian d = new View_Librarian("View Librarian");
						 d.setSize(950,1000);
						 d.setVisible(true);
			
		}
		 
}