import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc c1=new Calc();
	}

}
class Calc extends JFrame implements ActionListener
{
	JTextField t1,t2;
	JLabel l1;
	JButton b1,b2,b3,b4;
	public Calc()
	{
		t1=new JTextField(10);
		t2=new JTextField(10);
		l1=new JLabel("Result");
		b1=new JButton("Display");
		b2=new JButton("Search Record");
		b3=new JButton("Delete Record");
		b4=new JButton("/");
		
		add(t1); add(t2); add(b1); add(b2); add(b3); add(b4); add(l1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		setVisible(true);
		setSize(600,600);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		int a=Integer.parseInt(t1.getText());
		int b=Integer.parseInt(t2.getText());
		
		if(ae.getSource()==b1) {
			l1.setText(""+(a+b));
		}
		if(ae.getSource()==b2) {
			l1.setText(""+(a-b));
		}
		if(ae.getSource()==b3) {
			l1.setText(""+(a*b));
		}
		if(ae.getSource()==b4) {
			l1.setText(""+(a/b));
		}
	}
	
}
