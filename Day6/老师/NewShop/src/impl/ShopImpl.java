package impl;

import java.util.Scanner;

import bean.Good;
import bean.GoodList;
import bean.User;

public class ShopImpl
{
	/*
	 * �̳�ҵ����Ϣ��
	 * ��:���Ժͷ���
	 * ��������:������Ϊ������������ͣ������е�ÿ��Ԫ�ض��������Ķ��󣬵�����Щ������û��ʵ������
	 */
	Scanner input=new Scanner(System.in);
	String username=null;//�洢��¼��ע��ɹ����û���
	
	Good[] gs=new Good[10];//��������[] ������=new ��������[����]
	User[] us=new User[10];
	GoodList[] gl=new GoodList[10];
	
	public void init()
	{
		//ʵ����
		for(int i=0;i<10;i++)
		{
			gs[i]=new Good();//������=new ��();
			us[i]=new User();
			gl[i]=new GoodList();
		}
		
		//��ʼ��
		gs[0].id=1;
		gs[0].name="TCL42��Һ���ʵ�";
		gs[0].place="�й�";
		gs[0].price=1499;
		gs[0].num=10;
		gs[0].type="����";
	}
	
	public void show()
	{
		init();
		System.out.println("====================================================");
		System.out.println("                   ����̳�");
		String an=null;
		String typeName=null;
		do
		{
			an="n";
			System.out.println("��Ʒ����");
			System.out.println("                    1.����");
			System.out.println("                    2.����");
			System.out.println("                    3.ˮ��");
			System.out.println("��ѡ��:");
			int m=input.nextInt();
			if(m==1)
			{
				typeName="����";
			}
			else if(m==2)
			{
				typeName="����";
			}
			else if(m==3)
			{
				typeName="ˮ��";
			}
			else
			{
				an="y";
			}
		}while(an.equals("y"));
		showGood(typeName);
		System.out.println("������Ҫ�������Ʒ���:");
		int p=input.nextInt();
		if(username==null)
		{
			System.out.println("����û�е�¼�����¼��ע����!");
			showUser();
		}
	}
	
	public void showGood(String typeName)
	{
		/*
		 * ͨ����Ʒ���Ͳ�ѯ�����͵���Ʒ
		 */
	}
	
	public boolean checkGood(int gid,String typeName)
	{
		/*
		 * �ж�gid�Ƿ������typeName���͵���Ʒ��
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	
	public void showUser()
	{
		System.out.println("----------------------------------------------");
		System.out.println("                    1.��¼");
		System.out.println("                    2.ע��");
		System.out.println("��ѡ��:");
		int m=input.nextInt();
		if(m==1)
		{
			System.out.println("�������û���:");
			String name=input.next();
			System.out.println("��������    ��:");
			String pwd=input.next();
			boolean isFlag=login(name,pwd);
		}
		else if(m==2)
		{
			System.out.println("�������û���:");
			String name=input.next();
			checkName(name);
		}
		else
		{
			
		}
	}
	
	public boolean checkName(String name)
	{
		/*
		 * �ж��û����Ƿ����
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	
	public boolean login(String name,String pwd)
	{
		/*
		 * ��¼
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	
	
	public void register()
	{
		/*
		 * ע��
		 */
	}
	
	public boolean checkNum(int gid,int num)
	{
		/*
		 * �����Ʒ����Ƿ����
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	
	public void showList()
	{
		/*
		 * ��ʾ�û���СƱ��Ϣ
		 */
	}
	
	public boolean checkMoney(double sum)
	{
		/*
		 * �ж��û�����Ƿ����
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
}
