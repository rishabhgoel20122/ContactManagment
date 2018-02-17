import java.util.Scanner;
import java.sql.*;
public class JDBC_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","rishabh");
			Statement st=con.createStatement();
			int n;
			do {
				System.out.println("\n1->Print Details");
				System.out.println("2->Search Records");
				System.out.println("3->Delete Records");
				System.out.println("4->Update Records");
				System.out.println("5->Insert Records");
				System.out.print("\nEnter Your Choice:");
				n=scan.nextInt();
				if(n==1)
				{
					ResultSet rs=st.executeQuery("Select * from emp");
					System.out.println("\nTable");
					System.out.println("ID\tName\tSalary\tDept No.");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
					}
				}
				
				if(n==2)
				{
					System.out.print("Enter Id:");
					int id=scan.nextInt();
					ResultSet rs=st.executeQuery("Select * from emp where empno="+id);
					System.out.println("\nID\tName\tSalary\tDept No.");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
					}
				}
				
				if(n==3)
				{
					System.out.print("Enter Id:");
					int id=scan.nextInt();
					st.executeUpdate("delete from emp where empno="+id);
					System.out.println("Record Deleted\n");
				}
				
				if(n==4)
				{
					System.out.print("Enter Id:");
					int id=scan.nextInt();
					System.out.print("Enter new Name:");
					String name=sc.nextLine();
					System.out.print("Enter new Salary:");
					int sal=scan.nextInt();
					System.out.print("Enter new Dept No:");
					int deptno=scan.nextInt();
					st.executeUpdate("update emp set ename='"+name+"' where empno="+id);
					st.executeUpdate("update emp set salary="+sal+" where empno="+id);
					st.executeUpdate("update emp set deptno="+deptno+" where empno="+id);
					System.out.print("Record Updated\n");
				}
				
				if(n==5)
				{
					System.out.print("Enter Name:");
					String name=sc.nextLine();
					System.out.print("Enter Salary:");
					int sal=scan.nextInt();
					System.out.print("Enter Dept No:");
					int deptno=scan.nextInt();
					st.executeUpdate("insert into emp values(NULL,'"+name+"',"+sal+","+deptno+")");
					System.out.println("Record Inserted\n");
				}	
			}
			while(n==1||n==2||n==3||n==4||n==5);
			con.close();
		}
		catch(Exception e) {}
	}

}
