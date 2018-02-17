import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SwingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Abc obj=new Abc();
	}

}
class Abc extends JFrame implements ActionListener
{
	JTextField t1,t2;
	JButton b1;
	JLabel l1;
	Abc()
	{
		t1=new JTextField(20);
		t2=new JTextField(20);
		b1=new JButton("OK");
		l1=new JLabel("Result");
		
		b1.addActionListener(this);
		
		add(t1);
		add(t2);
		add(b1);
		add(l1);
		
		setVisible(true);
		setSize(400,400);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		int a=Integer.parseInt(t1.getText());
		int b=Integer.parseInt(t2.getText());
		int c=a+b;
		l1.setText("Result : "+c);
	}
}