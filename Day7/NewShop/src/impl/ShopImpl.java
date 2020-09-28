package impl;
import java.util.Scanner;

import bean.Good;
import bean.GoodList;
import bean.User;

public class ShopImpl {
	//�̳�ҵ����Ϣ��
	Scanner input = new Scanner(System.in);
	//����Ϊ�����е�Ԫ�أ���Щ��û��ʵ����
	//��������[] ������ = new ��������[����]
	Good[] gs = new Good[10];
	User[] us = new User[10];
	GoodList[] gl = new GoodList[10];
	String typeName = null;
	String username = null;
	public void init() {
		for(int i = 0; i < 10; i++) {
			//ʵ������������
			//������ = new ��()
			gs[i] = new Good();
			us[i] = new User();
			gl[i] = new GoodList();
		}
		//��ʼ��
		gs[0].id = 1;
		gs[0].name = "TCL42��Һ���ʵ�";
		gs[0].place = "CHINA";
		gs[0].price = 2500;
		gs[0].num = 10;
		gs[0].type = "����";
		
		gs[1].id = 2;
		gs[1].name = "�������ܵ����";
		gs[1].place = "CHINA";
		gs[1].price = 2499;
		gs[1].num = 10;
		gs[1].type = "����";
		
		gs[2].id = 3;
		gs[2].name = "��������Ь";
		gs[2].place = "CHINA";
		gs[2].price = 500;
		gs[2].num = 50;
		gs[2].type = "����";
		
		gs[3].id = 4;
		gs[3].name = "�ǵ�10����Ь";
		gs[3].place = "USA";
		gs[3].price = 1500;
		gs[3].num = 20;
		gs[3].type = "����";
		
		gs[4].id = 5;
		gs[4].name = "ɽ����̨ƻ��";
		gs[4].place = "China";
		gs[4].price = 5;
		gs[4].num = 50;
		gs[4].type = "ˮ��";
		
		gs[5].id = 6;
		gs[5].name = "�������߹�";
		gs[5].place = "USA";
		gs[5].price = 15;
		gs[5].num = 20;
		gs[5].type = "ˮ��";
		//�����û�
		us[0].id=1001;
		us[0].name="admin";
		us[0].password="123456";
		us[0].money=1000;
	}
	public void show() {
		init();//show()��Ҫ����init()
		System.out.println("======================================================");
		System.out.println("                   GD�̳�                             ");
		String ab=null;
		do {
			String al=null;
			do {
				
				String an=null;
				do {
					an = "n";
					System.out.println("======================================================");
					System.out.println("0.�˳�ϵͳ");
					System.out.println("1.��Ʒ����");
					System.out.println("2.��¼ע��");
					System.out.println("3.�����嵥");
					System.out.println("4.�˳���¼");
					System.out.println("��ѡ��:");
					int m=input.nextInt();
					if(m==0) {
						return;
					} else if(m==1) {

						boolean fg4 = showType();
						if (fg4 == true) {
							an="y";
						}
					} else if(m==2) {
						if(username == null) {
							showUser();
							an="y";
						} else {
							System.out.println("�û�"+username+"���Ѿ���¼!");
							an="y";
						}
					} else if(m==3) {
						boolean fg3 = showList();
						if(fg3==false) {
							return;
						} else {
							an="y";
						}
					} else if(m==4) {
						if (username == null) {
							System.out.println("����û�е�¼���޷��˳������ȵ�¼!");
							an="y";
						} else {
							//��¼���˳���¼
							System.out.println("�û�"+username+"�ɹ��˳���¼!");
							username = null;
							an="y";
						}
					} else {
						System.out.println("����ѡ�����������ѡ��!");
						an="y";
					}
				}while(an.equals("y"));
				String ap=null;
				do {
					int p=0;
					do {
						an="n";
						showGood(typeName);
						System.out.println("������Ҫ�������Ʒ���:");
						p = input.nextInt();
						if(username == null) {
							System.out.println("����û�е�¼�����¼��ע����!");
							showUser();
						}
						boolean isFlag=checkGood(p,typeName);
						if(isFlag==false)
						{
							System.out.println("��Ʒ����������������ѡ��!");
							an="y";
						}
					}while(an.equals("y"));
					int n=0;//���������
					do {
						an="n";
						System.out.println("������Ҫ���������:");
						n=input.nextInt();
						boolean isFlag = checkNum(p,n);
						if(isFlag==true)
						{
							System.out.println("��治�㣬����������!");
							an="y";
							for(int i=0;i<10;i++)
							{
								if(gs[i].id!=0&&gs[i].id==p)
								{
									System.out.println(gs[i].id+"\t"+gs[i].name+"\t"+gs[i].place+"\t"+gs[i].price+"\t"+gs[i].num);
								}
							}
						}
					}while(an.equals("y"));
					if (n > 0) {//���˶�������ӽ��嵥
						boolean fg = checkBuy(p,n);
						if(fg==false)
						{
							for(int i=0;i<10;i++)
							{
								if(gl[i].gid==0)//�ҵ���һ����λ�ò���������
								{
									gl[i].gid=p;
									gl[i].num=n;
									gl[i].uname=username;
									break;
								}
							}
						}
					}
					System.out.println("����Ҫ��������"+typeName+"��?");
					ap=input.next();
				} while(ap.equals("y"));
				System.out.println("����Ҫ����������?");
				al=input.next();
			}while(al.equals("y"));
			boolean fg2 = showList();
			if(fg2==false) {
				ab = "n";
			} else {
				ab = "y";
			}
		}while(ab.equals("y"));
	}
	public boolean showType() {
		boolean isFlag = false;
		String a3 = null;
		do {
			a3 = "n";
			System.out.println("======================================================");
			System.out.println("��Ʒ����:");
			System.out.println("                   1.����");
			System.out.println("                   2.����");
			System.out.println("                   3.ˮ��");
			System.out.println("                   0.����");
			System.out.println("��ѡ��:");
			int a=input.nextInt();
			if(a==1) {
				typeName="����";
			} else if(a==2) {
				typeName="����";
			} else if(a==3) {
				typeName="ˮ��";
			} else if(a==0) {
				isFlag = true;
			} else {
				System.out.println("����ѡ�����������ѡ��!");
				a3="y";
			}
		} while(a3.equals("y"));
		return isFlag;
	}
	public void showGood(String typeName) {
		//ͨ����Ʒ���Ͳ�ѯ����Ʒ
		System.out.println("======================================================");
		System.out.println("���\t����\t\t����\t����\t���");
		for(int i=0;i<10;i++)
		{
			if(gs[i].name!=null)
			{
				if(gs[i].type.equals(typeName))
				{
					System.out.println(gs[i].id+"\t"+gs[i].name+"\t"+gs[i].place+"\t"+gs[i].price+"\t"+gs[i].num);
				}
			}
		}
	}
	public boolean checkGood(int gid, String typeName) {
		//�ж�gid�Ƿ������ͨ��typeName���͵���Ʒ��
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(gs[i].name!=null)
			{
				if(gs[i].type.equals(typeName))
				{
					if(gs[i].id==gid)
					{
						isFlag=true;
						break;
					}
				}
			}
		}
		return isFlag;
	}
	public void showUser() {
		
		String ap = null;
		do
		{
			ap="n";
			System.out.println("======================================================");
			System.out.println("                       1.��¼");
			System.out.println("                       2.ע��");
			System.out.println("��ѡ��:");
			int m=input.nextInt();
			if(m==1) {
				do {
					ap="n";
					System.out.println("�������û���:");
					String inName=input.next();
					System.out.println("��������  ��:");
					String inPwd=input.next();
					boolean isFlag = login(inName,inPwd);
					if(isFlag)
					{
						username=inName;
						System.out.println("��¼�ɹ�����ӭ�û�"+username);
					}
					else
					{
						System.out.println("��¼ʧ�ܣ�����������!");
						ap="y";
					}
				}while(ap.equals("y"));
			} else if (m==2) {
				register();
			} else {
				System.out.println("ѡ�����������ѡ��!");
				ap="y";
			}
		} while (ap.equals("y"));
	}
	public boolean checkName(String name) {
		//�ж��û����Ƿ����
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(us[i].name!=null)
			{
				if(us[i].name.equals(name))
				{
					isFlag=true;
					break;
				}
			}
		}
		return isFlag;
	}
	public boolean login(String name, String pwd) {
		//��¼
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(us[i].name!=null)
			{
				if(us[i].name.equals(name)&&us[i].password.equals(pwd))
				{
					isFlag=true;
					break;
				}
			}
		}
		
		return isFlag;
	}
	public void register() {
		//ע��
		String ap =null;
		String name = null;
		do {
			ap="n";
			System.out.println("�������û���:");
			name=input.next();
			boolean isFlag = checkName(name);
			if(isFlag)
			{
				System.out.println("���û����ѱ�ռ�ã�����������!");
			    ap="y";
			}
		} while(ap.equals("y"));
		String pwd = null;
		do {
			ap="n";
			System.out.println("����������:");
			pwd=input.next();
			if(pwd.length()<6)
			{
				System.out.println("���볤�Ȳ���������λ������������!");
				ap="y";
			}
		} while(ap.equals("y"));
		String confPwd=null;
		do
		{
			ap="n";
			System.out.println("������ȷ������:");
			confPwd=input.next();
			if(!pwd.equals(confPwd))
			{
				System.out.println("ȷ����������벻һ�£�����������!");
				ap="y";
			}
		}while(ap.equals("y"));
		double money=0;
		do
		{
			ap="n";
			System.out.println("������ע����:");
			money=input.nextDouble();
			if(money<100)
			{
				System.out.println("ע����ܵ���100Ԫ�����������!");
				ap="y";
			}
		}while(ap.equals("y"));
		for(int j=0;j<10;j++)
		{
			if(us[j].id==0)
			{
				us[j].id=us[j-1].id+1;
				us[j].name=name;
				us[j].password=pwd;
				us[j].money=money;
				break;
			}
		}
		username=name;
		System.out.println("ע��ɹ�����ӭ���û�"+username);
	}
	public boolean checkNum(int gid, int num) {
		//�����Ʒ����Ƿ����
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(gs[i].id!=0&&gs[i].id==gid)
			{
				if(gs[i].num<num)
				{
					isFlag=true;
				}
				else
				{
					gs[i].num=gs[i].num-num;//������
				}
			}
		}
		return isFlag;
	}
	public boolean checkBuy(int gid, int num) {
		//�жϹ������Ʒ�Ƿ��ڱ��ι���������Ѿ����
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(gl[i].gid!=0&&gl[i].gid==gid)
			{
				gl[i].num=gl[i].num+num;
				isFlag=true;
				break;
			}
		}
		return isFlag;
	}
	public boolean showList() {
		//��ʾ�����嵥
		boolean isFlag = false;
		System.out.println("======================================================");
		System.out.println("�����嵥��");
		double sum=0;
		System.out.println("���\t����\t\t����\t����\t����\tС��");
		for(int i=0;i<10;i++)//��ѭ���ߵ����ѹ������Ʒ��Ϣ
		{
			if(gl[i].gid!=0&&gl[i].uname.equals(username))
			{
				for(int j=0;j<10;j++)//��ѭ���ߵ�����Ʒ��Ϣ
				{
					if(gl[i].gid==gs[j].id)
					{
						System.out.println(gl[i].gid+"\t"+gs[j].name+"\t"+gs[j].place+"\t"+gs[j].price+"\t"+gl[i].num+"\t"+gs[j].price*gl[i].num);
					    sum=sum+gs[j].price*gl[i].num;
					}
				}
			}
		}
		if (sum == 0.0) {
			System.out.println("���Ĺ����嵥Ϊ�գ���ȥ����£�");
			return true;
		}
		System.out.println("�������ѹ���:"+sum+"ȷ��������?(y/n)");
		String ak=input.next();
		String as=null;
		do
		{
			if(ak.equals("y"))
			{
				for(int i=0;i<10;i++)
				{
					if(us[i].name!=null&&us[i].name.equals(username))
					{
						if(us[i].money<sum)
						{
							System.out.println("�������㣬���ֵ!");
							System.out.println("�������ֵ���:");
							double mq=input.nextDouble();
							us[i].money=us[i].money+mq;
							as="y";
						}
						else
						{
							us[i].money=us[i].money-sum;
							//�򵥺󣬰��嵥��ա�ͨ��������жϡ�
							for(int k = 0; k<10; k++) {
								gl[k].gid = 0;
							}
							as="n";
							System.out.println("���������:"+us[i].money);
							System.out.println("лл���Ļݹˣ�");
							System.out.println("��Ҫ��Ҫ�������?(y/n)");
							String a1=input.next();
							if(a1.equals("y")) {
								isFlag = true;
							} else {
								isFlag = false;
							}
						}
					}
				}
			} else {
				System.out.println("������������£�");
				as="n";
				isFlag = true;
			}
		}while(as.equals("y"));
		return isFlag;
	}
	
}
