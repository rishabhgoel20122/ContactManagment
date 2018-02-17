import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class LoginPage implements ActionListener
{
	

	public static void main(String[] args) 
	{
		LoginPage lp=new LoginPage();
	}
	
	
	JFrame loginForm=new JFrame("Login"); 
	JFrame dashForm=new JFrame("Dashboard");
	JFrame regForm=new JFrame("Registration");
	JFrame addForm=new JFrame("Add my Contact");
	JFrame modifyForm =new JFrame("Modification");
	JFrame detailsForm=new JFrame("Details"); 
	
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15,lbl16;
	
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16;
	
	JButton loginB,exitB1,newB,addB,showB,modifyB,exitB2,regB,exitB3,alreadyRegB;
	
	JButton addConB,exitB4,searchB,exitB5,search1B,delUpB,exitB0;
	
	ButtonGroup cbg1=new ButtonGroup();
	ButtonGroup cbg2=new ButtonGroup();
	JRadioButton rb1,rb2,rb3,rb4;
	
	JTextArea ta1;
	final JTextField tf17;
	
	LoginPage()
	{

		tf1=new JTextField(10);
		tf2=new JTextField(10);
		lbl1=new JLabel("Email ID    ");
		lbl2=new JLabel("Password");
		loginB=new JButton("Login");
		exitB1=new JButton("Exit");
		newB=new JButton("New User? Click here");
		loginB.addActionListener(this);
		exitB1.addActionListener(this);
		newB.addActionListener(this);
		
		loginForm.add(lbl1);
		loginForm.add(tf1);
		loginForm.add(lbl2);
		loginForm.add(tf2);
		loginForm.add(loginB);
		loginForm.add(exitB1);
		loginForm.add(newB);
		
		loginForm.setVisible(true);
		loginForm.setSize(250,200);
		loginForm.setLocationRelativeTo(null);
		loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginForm.setLayout(new FlowLayout());
		
		
		addB=new JButton("Add");
		showB=new JButton("Show");
		modifyB=new JButton("Modify");
		exitB2=new JButton("Exit");
		
		dashForm.add(addB);
		dashForm.add(showB);
		dashForm.add(modifyB);
		dashForm.add(exitB2);
		exitB2.addActionListener(this);
		addB.addActionListener(this);
		showB.addActionListener(this);
		modifyB.addActionListener(this);
		
		dashForm.setSize(250,200);
		dashForm.setLocationRelativeTo(null);
		dashForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashForm.setLayout(new FlowLayout());
		
		
		tf3=new JTextField(10);
		tf4=new JTextField(10);
		tf5=new JTextField(10);
		tf6=new JTextField(10);
		tf7=new JTextField(10);
		lbl3=new JLabel("Name");
		lbl4=new JLabel("Email ID");
		lbl5=new JLabel("Password");
		lbl6=new JLabel("Confirm");
		lbl7=new JLabel("Phone");
		regB=new JButton("Register");
		exitB3=new JButton("Exit");
		alreadyRegB=new JButton("Already Registered ?");
		
		regForm.add(alreadyRegB);
		regForm.add(lbl3);
		regForm.add(tf3);
		regForm.add(lbl4);
		regForm.add(tf4);
		regForm.add(lbl5);
		regForm.add(tf5);
		regForm.add(lbl6);
		regForm.add(tf6);
		regForm.add(lbl7);
		regForm.add(tf7);
		regForm.add(regB);
		regForm.add(exitB3);
		alreadyRegB.addActionListener(this);
		regB.addActionListener(this);
		exitB3.addActionListener(this);
		
		regForm.setSize(550,200);
		regForm.setLocationRelativeTo(null);
		regForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regForm.setLayout(new FlowLayout());
		
		
		tf8=new JTextField(10);
		tf9=new JTextField(10);
		tf10=new JTextField(10);
		tf11=new JTextField(10);
		tf12=new JTextField(10);
		lbl8=new JLabel("Name");
		lbl9=new JLabel("Email ID");
		lbl10=new JLabel("Ph. No");
		lbl11=new JLabel("Address");
		lbl12=new JLabel("Gender");
		addConB=new JButton("Add");
		exitB4=new JButton("Exit");
		addConB.addActionListener(this);
		exitB4.addActionListener(this);
		
		addForm.add(lbl8);
		addForm.add(tf8);
		addForm.add(lbl9);
		addForm.add(tf9);
		addForm.add(lbl10);
		addForm.add(tf10);
		addForm.add(lbl11);
		addForm.add(tf11);
		addForm.add(lbl12);
		addForm.add(tf12);
		addForm.add(addConB);
		addForm.add(exitB4);
		
		addForm.setSize(350,200);
		addForm.setLocationRelativeTo(null);
		addForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addForm.setLayout(new FlowLayout());
		
		rb1=new JRadioButton("by Name",false);
		rb2=new JRadioButton("by Phone",false);
		tf13=new JTextField(10);
		searchB=new JButton("Search");
		exitB5=new JButton("Exit");
		ta1=new JTextArea(20,70);
		cbg1.add(rb1);
		cbg1.add(rb2);
		detailsForm.add(rb1);
		detailsForm.add(rb2);
		detailsForm.add(tf13);
		detailsForm.add(searchB);
		detailsForm.add(ta1);
		detailsForm.add(exitB5);
		exitB5.addActionListener(this);
		searchB.addActionListener(this);
		
		detailsForm.setSize(800,430);
		detailsForm.setLocationRelativeTo(null);
		detailsForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		detailsForm.setLayout(new FlowLayout());
		
		
		rb3=new JRadioButton("Delete",false);
		rb4=new JRadioButton("Update",false);
		tf14=new JTextField(5);
		tf15=new JTextField(10);
		tf16=new JTextField(10);
		tf17=new JTextField(10);
		search1B=new JButton("Search");
		lbl13=new JLabel("ID:");
		lbl14=new JLabel("Name");
		lbl15=new JLabel("Email");
		lbl16=new JLabel("Phone");
		delUpB=new JButton("Delete/Update");

		exitB0=new JButton("Exit");
		cbg2.add(rb3);
		cbg2.add(rb4);
		
		modifyForm.setSize(350,200);
		modifyForm.setLocationRelativeTo(null);
		modifyForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modifyForm.setLayout(new FlowLayout());
		
		modifyForm.add(rb3);
		modifyForm.add(rb4);
		modifyForm.add(lbl13);
		modifyForm.add(tf14);
		modifyForm.add(search1B);
		modifyForm.add(lbl14);
		modifyForm.add(tf15);
		modifyForm.add(lbl15);
		modifyForm.add(tf16);
		modifyForm.add(lbl16);
		modifyForm.add(tf17);
		modifyForm.add(delUpB);
		modifyForm.add(exitB0);	
		
		delUpB.addActionListener(this);
		exitB0.addActionListener(this);
		search1B.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","rishabh");
			Statement st=con.createStatement();
			
			if(ae.getSource()==loginB) 
			{
				String email=tf1.getText();
				String pwd=tf2.getText();
				ResultSet rs=st.executeQuery("select * from login_details where email LIKE '"+email+"'");
				while(rs.next()) {
					if(rs.getString(4).equals(pwd)) 
					{
						loginForm.dispose();
						dashForm.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Wrong Details");
						tf1.setText("");
						tf2.setText("");
					}
				}
			}
			
			if(ae.getSource()==exitB1) 
			{
				System.exit(0);
			}
			
			if(ae.getSource()==exitB2) 
			{
				System.exit(0);
			}
			
			if(ae.getSource()==newB) 
			{
				loginForm.dispose();
				regForm.setVisible(true);
			}
			
			if(ae.getSource()==alreadyRegB)
			{
				regForm.dispose();
				loginForm.setVisible(true);
			}
			
			if(ae.getSource()==regB)
			{
				String name=tf3.getText();
				String email=tf4.getText();
				String pwd=tf5.getText();
				String cpwd=tf6.getText();
				int ph=Integer.parseInt(tf7.getText());
				
				if(pwd.equals(cpwd)) 
				{
					st.executeUpdate("insert into login_details values(NULL,'"+name+"','"+email+"','"+pwd+"',"+ph+")");
					JOptionPane.showMessageDialog(null,"Data Inserted");
					regForm.dispose();
					loginForm.setVisible(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Password did not match");
					tf6.setText("");
					tf5.setText("");
				}
			}
			
			if(ae.getSource()==exitB3) 
			{
				System.exit(0);
			}
			
			if(ae.getSource()==addB)
			{
				dashForm.dispose();
				addForm.setVisible(true);
			}
			
			if(ae.getSource()==addConB)
			{
				String name=tf8.getText();
				String email=tf9.getText();
				int phone=Integer.parseInt(tf10.getText());
				String address=tf11.getText();
				String gender=tf12.getText();
				
				st.executeUpdate("insert into contacts values(NULL,'"+name+"','"+email+"',"+phone+",'"+address+"','"+gender+"')");
				JOptionPane.showMessageDialog(null,"Contact Inserted");
				
				tf8.setText("");
				tf9.setText("");
				tf10.setText("");
				tf11.setText("");
				tf12.setText("");
				
			}
			
			if(ae.getSource()==exitB4) 
			{
				System.exit(0);
			}
			
			if(ae.getSource()==showB)
			{
				dashForm.dispose();
				detailsForm.setVisible(true);
			}
			
			if(ae.getSource()==modifyB) 
			{
				
				dashForm.dispose();
				modifyForm.setVisible(true);
				
			}
			
			if(ae.getSource()==searchB)
			{
				
				if(rb1.isSelected()==true) 
				{
					String name=tf13.getText();
					ResultSet rs1=st.executeQuery("select * from contacts where name like '"+name+"'");
					ta1.setText("");
					ta1.append("Id\tName\tEmail\t\t\tPhone\tAddress\tGender\n");
					while(rs1.next()) {
						ta1.append(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t\t"+rs1.getInt(4)+"\t"+rs1.getString(5)+"\t"+rs1.getString(6)+"\n");
					}
				}
				
				if(rb2.isSelected()==true)
				{
					int phone=Integer.parseInt(tf13.getText());
					ResultSet rs2=st.executeQuery("select * from contacts where phone="+phone+"");
					ta1.setText("");
					ta1.append("Id\tName\tEmail\t\t\tPhone\tAddress\tGender\n");
					while(rs2.next()) {
						ta1.append(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t\t"+rs2.getInt(4)+"\t"+rs2.getString(5)+"\t"+rs2.getString(6)+"\n");
					}
				}
				
				if(rb2.isSelected()==false && rb1.isSelected()==false)
				{
					ResultSet rs3=st.executeQuery("select * from contacts");
					ta1.setText("");
					ta1.append("Id\tName\tEmail\t\t\tPhone\tAddress\tGender\n");
					while(rs3.next()) {
						ta1.append(rs3.getInt(1)+"\t"+rs3.getString(2)+"\t"+rs3.getString(3)+"\t\t"+rs3.getInt(4)+"\t"+rs3.getString(5)+"\t"+rs3.getString(6)+"\n");
					}
				}
			}
			
			if(ae.getSource()==exitB5) 
			{
				System.exit(0);
			}
			
			if(ae.getSource()==exitB0) 
			{
				System.exit(0);
			}
			
			if(ae.getSource()==search1B)
			{
				int n=Integer.parseInt(tf14.getText());
				ResultSet rs =st.executeQuery("Select * from contacts where id="+n+"");
				
				while(rs.next())
				{
					tf15.setText(rs.getString(2));
					tf16.setText(rs.getString(3));
					tf17.setText(rs.getString(4));
				}
					
			}
			
			if(ae.getSource()==delUpB) 
			{
				
				int n=Integer.parseInt(tf14.getText());
				
				if(rb3.isSelected()) 
				{
					st.executeUpdate("delete from contacts where id="+n+"");
					JOptionPane.showMessageDialog(null,"Record Deleted");
					tf14.setText("");
					tf15.setText("");
					tf16.setText("");
					tf17.setText("");
				}
				
				if(rb4.isSelected())
				{
					String name=tf15.getText();
					String email=tf16.getText();
					int ph=Integer.parseInt(tf17.getText());
					st.executeUpdate("update contacts set name='"+name+"' where id="+n+"");
					st.executeUpdate("update contacts set email='"+email+"' where id="+n+"");
					st.executeUpdate("update contacts set phone="+ph+" where id="+n+"");
					JOptionPane.showMessageDialog(null,"Record Updated");
					tf14.setText("");
					tf15.setText("");
					tf16.setText("");
					tf17.setText("");
				}
			}
			
		}
		catch(Exception e) {}
	}
}
