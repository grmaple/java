import java.util.Scanner;
public class Demo03
{
	public static void main(String[] args)
	{
		/*
		 *  3  4  2  5  1
		 *  ��һ��:3  2  4  1  5  ͨ���ĴαȽ�
		 *  �ڶ���:2  3  1  4  5  ͨ�����αȽ�
		 *  ������:2  1  3  4  5  ͨ�����αȽ�
		 *  ������:1  2  3  4  5  ͨ��һ�αȽ�
		 */
		Scanner input=new Scanner(System.in);
		int[] m=new int[5];
		for(int i=0;i<5;i++)
		{
			System.out.println("�������"+(i+1)+"������:");
			m[i]=input.nextInt();
		}
		System.out.println("����ǰ:");
		for(int i=0;i<5;i++)
		{
			System.out.print(m[i]+" ");
		}
		System.out.println();
		System.out.println("-------------����-----------");
		for(int i=1;i<=4;i++)//��ѭ����������
		{
			for(int j=0;j<=4-i;j++)//��ѭ�����ƴ���
			{
				if(m[j]>m[j+1])
				{
					int temp=m[j];
					m[j]=m[j+1];
					m[j+1]=temp;
				}
			}
		}
		System.out.println("�����:");
		for(int i=0;i<5;i++)
		{
			System.out.print(m[i]+" ");
		}
	}
}