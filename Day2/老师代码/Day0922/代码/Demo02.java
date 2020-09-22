public class Demo02
{
	public static void main(String[] args)
	{
		int[] num=new int[20];
		num[0]=1;
		num[1]=1;
		for(int i=2;i<20;i++)
		{
			num[i]=num[i-1]+num[i-2];//第三个位置上的数=前面两个位置上数字的和
		}
		int m=0;//统计奇数的个数
		int n=0;//统计偶数的个数
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
		System.out.print("前二十位共有"+m+"个奇数，有"+n+"个偶数");
	}
}