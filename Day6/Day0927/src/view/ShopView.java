package view;
import java.util.Scanner;
import bean.Good;

public class ShopView
{
	public static void main(String[] args)
	{
		/*
		 * ��ͬ���е�����Ҫ�໥���ñ���ʹ��import���������
		 * ������:����.����
		 */
		Scanner input=new Scanner(System.in);
		Good g=new Good();//����Good��Ķ���g��ʵ����,g����Good��ľ�����壬����ʹ��������Ժͷ���
		g.show();
	}
}
