public class Demo02
{
	public static void main(String[] args)
	{
		int[] num=new int[20];
		num[0]=1;
		num[1]=1;
		for(int i=2;i<20;i++)
		{
			num[i]=num[i-1]+num[i-2];//������λ���ϵ���=ǰ������λ�������ֵĺ�
		}
		int m=0;//ͳ�������ĸ���
		int n=0;//ͳ��ż���ĸ���
		for(int i=0;i<20;i++)
		{
			System.out.print(num[i]+" ");
			if(num[i]%2==0)
			{
				n++;
			}
			else
			{
				m++;
			}
		}
		System.out.print("ǰ��ʮλ����"+m+"����������"+n+"��ż��");
	}
}