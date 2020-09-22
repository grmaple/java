public class Demo01
{
	public static void main(String[] args)
	{
		/*
		 * 利用三种循环实现1-100奇数的和、偶数的和以及能被3整除的数字的和
		 */
		 int i=1;
		 while(i<=100)
		 {
			 if(i%2==0)
			 {
				 //除以2没有余数的数都是偶数!
			 }
			 else
			 {
				 
			 }
			 i++;//等同于i=i+1;
		 }
		 //对于do...while();循环而言，即使条件第一次就不成立，循环体也会执行一次操作
		 int j=1;
		 do
		 {
			if(j%2==0)
			{
				
			}
			else
			{
				
			}
			j++;			
		 }while(j<=100);
		 //for循环
		 for(int k=1;k<=100;k++)
		 {
			 if(k%2==0)
			 {
				 
			 }
			 else
			 {
				 
			 }
		 }
		 
		 int[] num={1,2,3,4,5,6};
		 for(int m=0;m<6;m++)
		 {
			 System.out.println(num[m]);
		 }
	}
}