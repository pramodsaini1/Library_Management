import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;
 
public class  Issue_Book extends JFrame implements ActionListener {
		JLabel jl1,jl2,jl3,jl4,jl5;
		JTextField jt1,jt2,jt3,jt4,jt5 ;
		JButton jb,jb1,jb2,jb3,jb4;
 		int flag=0 ;
		Font f;
		JLabel header,body;
   		   Issue_Book(String s){ 
			super(s);
			   setLayout(null); 
			   
 			 header = new JLabel(new ImageIcon("iss_book.jpg"));
			 body = new JLabel(new ImageIcon("ram.jpg"));
			f = new Font("Tahoma",Font.BOLD,18);
			
			jl1 = new JLabel("Book Id:");
			jt1 = new JTextField(20);
			jl1.setFont(f);
			jt1.setFont(f);
			
			jl2 = new JLabel("Book CallNo:");
			jt2 = new JTextField(20);
			jl2.setFont(f);
			jt2.setFont(f);
			
			
			jl3 = new JLabel("Student Id:");
			jt3 = new JTextField(20);
			jl3.setFont(f);
			jt3.setFont(f);
			
			
			jl4 = new JLabel("Student Name:");
			jt4 = new JTextField(20);
			jl4.setFont(f);
			jt4.setFont(f);
			
			
			jl5 = new JLabel("Contact :");
			jt5 = new JTextField(20);
			jl5.setFont(f);
			jt5.setFont(f);
			
			 
			
			  
			
			 
			jb = new JButton(new ImageIcon("issue_book.jpg"));
			jb1=new JButton(new ImageIcon("edit.jpg"));
			jb2=new JButton(new ImageIcon("delete.jpg"));
			jb3=new JButton(new ImageIcon("logout.jpg"));
			jb4=new JButton(new ImageIcon("exit.jpg"));
			jb.setFont(f);
			jb1.setFont(f);
			jb2.setFont(f);
			jb3.setFont(f);
			jb4.setFont(f);
			 
		    
            header.setBounds(0,0,950,200);
			body.setBounds(0,200,950,800);

            jl1.setBounds(100,250,160,30);
			jt1.setBounds(280,250,180,30);
			jb1.setBounds(490,250,180,30);
			
			jl2.setBounds(100,300,160,30);
			jt2.setBounds(280,300,180,30);
			jb2.setBounds(490,300,180,30);


			jl3.setBounds(100,350,160,30);
			jt3.setBounds(280,350,180,30);
			jb3.setBounds(490,350,180,30);

			
			jl4.setBounds(100,400,160,30);
			jt4.setBounds(280,400,180,30);
			jb4.setBounds(490,400,180,30);

			jl5.setBounds(100,450,160,30);
			jt5.setBounds(280,450,180,30);
 			
			 
			jb.setBounds(180,550,180,50);
			
			
			
			add(jl1);
			add(jt1);
			
			add(jl2);
			add(jt2);
			
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
	
	public void actionPerformed(ActionEvent et){
		Date  date = new Date();
              String  dt =date.toString();
			  int status=0;
		 	   if(et.getSource()==jb2||et.getSource()==jb1){
				    if(et.getSource()==jb1){
						flag=1 ;
					}
					else if(et.getSource()==jb2){
						flag=2 ;
					}
			     try{
			         int book_id=  Integer.parseInt(jt1.getText());
 				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery("select * from issue where id="+book_id);
				if(rs.next()){
					jt2.setText(rs.getString(2));
				    jt3.setText(rs.getInt(3)+"");
					jt4.setText(rs.getString(4));
					jt5.setText(rs.getString(5));
					 
					  
				}
				else{
					flag=0;
					JOptionPane.showMessageDialog(null,"Record not found");
					  Book ob= new  Book("Book Added Successfully");
				  ob.setSize(950,1000);
				   ob.setVisible(true);	
					this.setVisible(false);
					
					
				}
				cn.close();
			   }
			   catch(ClassNotFoundException e){
				System.out.println("Driver :"+e.getMessage());
				}
				catch(SQLException e){
					System.out.println("SQL :"+e.getMessage());
				}   
		    }
		     else if(et.getSource()==jb3){
			     librarian_login ob = new librarian_login("Librarian Login Panel");
				 ob.setSize(950,1000);
				 ob.setVisible(true);
				 this.setVisible(false);
		      }
			 else if(et.getSource()==jb4){
			     Librarian_Management ob = new Librarian_Management("Librarian Management Panel");
				 ob.setSize(950,1000);
				 ob.setVisible(true);
				 this.setVisible(false);
			 
		      }
			  
			  
		    
			
			
		else{
			        int book_id=  Integer.parseInt(jt1.getText());
			             String book_call = jt2.getText();
						 int s_id = Integer.parseInt(jt3.getText());
						 String s_name= jt4.getText();
						 String contact = jt5.getText();
					  
						  
						   
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				PreparedStatement ps=null;
				String msg="";
						if(flag==0){
				            	ps=cn.prepareStatement("insert into issue values(?,?,?,?,?,?,?)"); 
								ps.setInt(1,book_id);
								ps.setString(2,book_call);
								ps.setInt(3,s_id);
								ps.setString(4,s_name);
								ps.setString(5,contact); 
								ps.setString(6,dt);
								ps.setInt(7,status);
								 
								 
					msg="Book Issued Successfully";
					
                 }
				 
				 else if(flag==1){
                    ps=cn.prepareStatement("update issue set bookcallno=?,student_id=?,student_name=?,contact=? where id=?");
				 
					ps.setString(1,book_call);
					ps.setInt(2,s_id);
					ps.setString(3,s_name);
					ps.setString(4,contact); 
					ps.setInt(5,book_id);

					msg="Book Issue Updated";
					

                 }		
                   else if(flag==2){
                     ps=cn.prepareStatement("delete from addbook where id=?");
				     ps.setInt(1,book_id);
					 msg="Book Issue Deleted";
					
                    }			
						
				if(ps.executeUpdate()>0){
				   JOptionPane.showMessageDialog(null,msg); 
				   Issue_Book ob = new Issue_Book ("Issue Book Panel");
			     ob.setSize(950,1000);
			        ob .setVisible(true);
				   this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null,"Try Again"); 
				}
				cn.close();
				
			}
			catch(ClassNotFoundException e){
				
				System.out.println("Driver :"+e.getMessage());
			}
			catch(SQLException e){
				System.out.println("SQL :"+e.getMessage());
				
			}   
	  		 			  
	     }
			 
  } 
  public static void main(String[]arr){

           Issue_Book d= new Issue_Book("Insert Record");
				   d.setSize(950,1000);
				   d.setVisible(true);	
   }  
          
 
}
