public class Demo01
{
	public static void main(String[] args)
	{
		/*
		 *  i*j
		 *  1*1=1
		 *  2*1=2 2*2=4
		 *  3*1=3 3*2=6 3*3=9
		 */
		for(int i=1;i<=9;i++)
		{
			//��ѭ����������
			for(int j=1;j<=i;j++)
			{
				System.out.print(i+"*"+j+"="+i*j+" ");
			}
			System.out.println();//�����ֵ�����У�
		}
		for(int i=8;i>=1;i--)
		{
			//��ѭ����������
			for(int j=1;j<=i;j++)
			{
				System.out.print(i+"*"+j+"="+i*j+" ");
			}
			System.out.println();//�����ֵ�����У�
		}
	}
}