import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Swing2 {

	public static void main(String[] args) {
		Abc a1=new Abc();
	}
}
class Abc extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4;
	JLabel l1;
	JButton b1,b2,b3,b4,b5;
	public Abc() {
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		l1=new JLabel("Result");
		b1=new JButton("Display");
		b2=new JButton("Search Record");
		b3=new JButton("Delete Record");
		b4=new JButton("Update Record");
		b5=new JButton("Insert Record"); 
		add(t1); add(t2); add(t3);add(t4);add(b1); add(b2); add(b3); add(b4); add(b5); add(l1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		setVisible(true);
		setSize(600,600);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","rishabh");
			Statement st=con.createStatement();
		
		if(ae.getSource()==b1)
		{
			ResultSet rs=st.executeQuery("Select * from emp");
			l1.setText("\nTable");
			l1.setText("ID\tName\tSalary\tDept No.");
			while(rs.next())
			{
				l1.setText(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
			}
		}
		if(ae.getSource()==b2)
		{
			l1.setText("Enter Id:");
			int id=Integer.parseInt(t1.getText());
			ResultSet rs=st.executeQuery("Select * from emp where empno="+id);
			l1.setText("\nID\tName\tSalary\tDept No.");
			while(rs.next())
			{
				l1.setText(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
			}
		}
		
		if(ae.getSource()==b3)
		{
			l1.setText("Enter Id:");
			int id=Integer.parseInt(t1.getText());
			st.executeUpdate("delete from emp where empno="+id);
			l1.setText("Record Deleted\n");
		}
		
		if(ae.getSource()==b4)
		{
			l1.setText("Enter Id:");
			int id=Integer.parseInt(t1.getText());
			l1.setText("Enter new Name:");
			String name=t2.getText();
			l1.setText("Enter new Salary:");
			int sal=Integer.parseInt(t3.getText());
			l1.setText("Enter new Dept No:");
			int deptno=Integer.parseInt(t4.getText());
			st.executeUpdate("update emp set ename='"+name+"' where empno="+id);
			st.executeUpdate("update emp set salary="+sal+" where empno="+id);
			st.executeUpdate("update emp set deptno="+deptno+" where empno="+id);
			l1.setText("Record Updated\n");
		}
		
		if(ae.getSource()==b5)
		{
			l1.setText("Enter Name:");
			String name=t2.getText();
			l1.setText("Enter Salary:");
			int sal=Integer.parseInt(t3.getText());
			System.out.print("Enter Dept No:");
			int deptno=Integer.parseInt(t4.getText());
			st.executeUpdate("insert into emp values(NULL,'"+name+"',"+sal+","+deptno+")");
			l1.setText("Record Inserted\n");
		}
		
		con.close();
		}
		catch(Exception e) {}
		
	}
	
}
