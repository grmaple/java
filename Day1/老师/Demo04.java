import java.util.Scanner;
public class Demo04
{
	public static void main(String[] args)
	{
		/*
		 *实现输入m个班每个班n个同学的成绩
		 */
		Scanner input=new Scanner(System.in);
		System.out.println("请输入班级数量:");
		int m=input.nextInt();
		double Max=0;
		double Min=100;
		double total=0;
		int p=0;
		for(int i=1;i<=m;i++)
		{
			System.out.println("请输入第"+i+"个班级的人数:");
			int n=input.nextInt();
			p=p+n;
			double[] sc=new double[n];//声明一个长度为n的数组用于存储n个学生的成绩
			double max=0;
			double min=100;
			double sum=0;
			for(int j=0;j<n;j++)
			{
				System.out.println("请输入第"+(j+1)+"个学生的成绩:");
				sc[j]=input.nextDouble();
				if(sc[j]>max)//当前同学的成绩比所谓的最高分还要高
				{
					max=sc[j];
				}
				if(sc[j]<min)//当前同学的成绩比所谓的最低分还要低
				{
					min=sc[j];
				}
				sum=sum+sc[j];
			}
			System.out.println("当前班级的最高分是:"+max);
			System.out.println("当前班级的最低分是:"+min);
			System.out.println("当前班级的平均分是:"+sum/n);
			if(max>Max)
			{
				Max=max;
			}
			if(min<Min)
			{
				Min=min;
			}
			total=total+sum;
		}
		System.out.println("年级的最高分是:"+Max);
		System.out.println("年级的最低分是:"+Min);
		System.out.println("年级的平均分是:"+total/p);
	}
}