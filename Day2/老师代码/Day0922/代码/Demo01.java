public class Demo01
{
	public static void main(String[] args)
	{
		/*
		 * ��������ѭ��ʵ��1-100�����ĺ͡�ż���ĺ��Լ��ܱ�3���������ֵĺ�
		 */
		 int i=1;
		 while(i<=100)
		 {
			 if(i%2==0)
			 {
				 //����2û��������������ż��!
			 }
			 else
			 {
				 
			 }
			 i++;//��ͬ��i=i+1;
		 }
		 //����do...while();ѭ�����ԣ���ʹ������һ�ξͲ�������ѭ����Ҳ��ִ��һ�β���
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
		 //forѭ��
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