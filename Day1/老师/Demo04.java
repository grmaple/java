import java.util.Scanner;
public class Demo04
{
	public static void main(String[] args)
	{
		/*
		 *ʵ������m����ÿ����n��ͬѧ�ĳɼ�
		 */
		Scanner input=new Scanner(System.in);
		System.out.println("������༶����:");
		int m=input.nextInt();
		double Max=0;
		double Min=100;
		double total=0;
		int p=0;
		for(int i=1;i<=m;i++)
		{
			System.out.println("�������"+i+"���༶������:");
			int n=input.nextInt();
			p=p+n;
			double[] sc=new double[n];//����һ������Ϊn���������ڴ洢n��ѧ���ĳɼ�
			double max=0;
			double min=100;
			double sum=0;
			for(int j=0;j<n;j++)
			{
				System.out.println("�������"+(j+1)+"��ѧ���ĳɼ�:");
				sc[j]=input.nextDouble();
				if(sc[j]>max)//��ǰͬѧ�ĳɼ�����ν����߷ֻ�Ҫ��
				{
					max=sc[j];
				}
				if(sc[j]<min)//��ǰͬѧ�ĳɼ�����ν����ͷֻ�Ҫ��
				{
					min=sc[j];
				}
				sum=sum+sc[j];
			}
			System.out.println("��ǰ�༶����߷���:"+max);
			System.out.println("��ǰ�༶����ͷ���:"+min);
			System.out.println("��ǰ�༶��ƽ������:"+sum/n);
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
		System.out.println("�꼶����߷���:"+Max);
		System.out.println("�꼶����ͷ���:"+Min);
		System.out.println("�꼶��ƽ������:"+total/p);
	}
}