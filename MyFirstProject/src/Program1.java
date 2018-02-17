import java.util.Scanner;
public class Program1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n;
		do {
			System.out.println("1.Play");
			System.out.println("0.Exit");
			System.out.print("Enter your choice:");
			n=scan.nextInt();
			if(n==1) {
				double r1=Math.random();
				double r2=Math.random();
				double r3=Math.random();
				r1=r1*10;
				r2=r2*10;
				r3=r3*10;
				int R1=(int)r1;
				int R2=(int)r2;
				int R3=(int)r3;
				System.out.println(R1+"\t"+R2+"\t"+R3);
				if(R1==R2 && R2==R3)
				System.out.println("\nJACKPOT!!!");
			}
		}while(n!=0);
	}
}