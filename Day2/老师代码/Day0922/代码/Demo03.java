import java.util.Scanner;
public class Demo03
{
	public static void main(String[] args)
	{
		/*
		 *  3  4  2  5  1
		 *  第一轮:3  2  4  1  5  通过四次比较
		 *  第二轮:2  3  1  4  5  通过三次比较
		 *  第三轮:2  1  3  4  5  通过两次比较
		 *  第四轮:1  2  3  4  5  通过一次比较
		 */
		Scanner input=new Scanner(System.in);
		int[] m=new int[5];
		for(int i=0;i<5;i++)
		{
			System.out.println("请输入第"+(i+1)+"个数字:");
			m[i]=input.nextInt();
		}
		System.out.println("排序前:");
		for(int i=0;i<5;i++)
		{
			System.out.print(m[i]+" ");
		}
		System.out.println();
		System.out.println("-------------排序-----------");
		for(int i=1;i<=4;i++)//外循环控制论数
		{
			for(int j=0;j<=4-i;j++)//内循环控制次数
			{
				if(m[j]>m[j+1])
				{
					int temp=m[j];
					m[j]=m[j+1];
					m[j+1]=temp;
				}
			}
		}
		System.out.println("排序后:");
		for(int i=0;i<5;i++)
		{
			System.out.print(m[i]+" ");
		}
	}
}