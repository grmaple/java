import java.util.Scanner;
public class Demo02
{
	public static void main(String[] args)
	{
		/*
		 *��������������еĳ����������ݣ���ô������Ҫ����Scanenr�Ķ�����ø��ַ�������ֵ
		 */
		 Scanner input=new Scanner(System.in);
		 System.out.println("���������ε�����:");
		 int num=input.nextInt();
		 if(num%2==0)
		 {
			 System.out.println("����ֻ����������!");
		 }
		 else
		 {
			 int m=(num+1)/2;
			 for(int i=1;i<=m;i++)
			 {
				 for(int j=1;j<=m-i;j++)
				 {
					 System.out.print(" ");
				 }
				 for(int k=1;k<=2*i-1;k++)
				 {
					 System.out.print("*");
				 }
				 System.out.println();
			 }
			 int n=num-m;
			 for(int i=1;i<=n;i++)
			 {
				 for(int j=1;j<=i;j++)
				 {
					 System.out.print(" ");
				 }
				 for(int k=1;k<=num-2*i;k++)
				 {
					 System.out.print("*");
				 }
				 System.out.println();
			 }
		 }
	}
}

 
 
 
 
 