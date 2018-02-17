import java.util.Scanner;
public class Knapsack_0_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter no of items:");
		int n=scan.nextInt();
		int[] w=new int[n];
		int[] v=new int[n];
		System.out.println("Enter "+n+" weights and thier value\n");
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter weight for item "+(i+1)+":");
			w[i]=scan.nextInt();
			System.out.println("Enter value for item "+(i+1)+":");
			v[i]=scan.nextInt();
		}
		System.out.println("Enter Knapsack Capacity:");
		int W=scan.nextInt();
		System.out.println("\nDATA");
		System.out.println("Item\tWeight\tValue");
		for(int i=0;i<n;i++)
		{
			System.out.println("#"+(i+1)+"\t"+w[i]+"\t"+v[i]);
		}
		System.out.println("\nKnapsack Capacity:"+W);
		int[][] S=new int[(n+1)][(W+1)];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=W;j++)
			{
				S[i][0]=0;
			}
		}
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=W;j++)
			{
				S[0][j]=0;
			}
		}
		try 
		{
			for(int i=0;i<=n;i++)
			{
				for(int j=0;j<=W;j++)
				{
					if(w[i]>W)
					S[i][j]=S[i-1][j];
					else
					{
						if(S[i-1][j]>(S[i-1][j-w[i]]+v[i]))
						S[i][j]=S[i-1][j];
						else
						S[i][j]=S[i-1][j-w[i]]+v[i];
					}
				}
			}
		}
		catch(Exception e) {};
		while(n!=0&&W!=0)
		{
			if(S[n][W]!=S[n-1][W])
			{
				W=W-w[n];
				System.out.println(n);
			}
			n=n-1;
		}

	}

}
