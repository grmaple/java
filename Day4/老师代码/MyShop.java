import java.util.Scanner;
public class MyShop
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		String username=null;//�洢��¼��ע��ɹ����û���
		//�������Դ��Ϣ
		int[] gid=new int[10];
		String[] game=new String[10];
		String[] place=new String[10];
		double[] price=new double[10];
		int[] num=new int[10];
		String[] type=new String[10];
		
		int[] uid=new int[10];
		String[] uame=new String[10];
		String[] uwd=new String[10];
		double[] money=new double[10];
		
		int[] bid=new int[20];//�������Ʒ���
		int[] bum=new int[20];//�������Ʒ����
		String[] bame=new String[20];//������Ʒ���û�
		
		//��ʼ������
		gid[0]=1;
		game[0]="TCL42��Һ���ʵ�";
		place[0]="CHINA";
		price[0]=1499;
		num[0]=10;
		type[0]="����";
		
		gid[1]=2;
		game[1]="�������ܵ����";
		place[1]="CHINA";
		price[1]=2499;
		num[1]=10;
		type[1]="����";
		
		gid[2]=3;
		game[2]="��������ɫϴ�»�";
		place[2]="GERMANY";
		price[2]=5499;
		num[2]=5;
		type[2]="����";
		
		uid[0]=1001;
		uame[0]="admin";
		uwd[0]="123456";
		money[0]=1000;
		
		System.out.println("======================================================");
		System.out.println("                   JD�̳�                             ");
		String al=null;
		do
		{
			String typeName=null;
			String an=null;
			do
			{
				an="n";
				System.out.println("��Ʒ����");
				System.out.println("                   1.����");
				System.out.println("                   2.����");
				System.out.println("                   3.ˮ��");
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
					System.out.println("����ѡ�����������ѡ��!");
					an="y";
				}
			}while(an.equals("y"));
			String ap=null;
			do
			{
				int p=0;//�������Ʒ���
				do
				{
					an="n";
					System.out.println("���\t����\t\t����\t����\t���");
					for(int i=0;i<10;i++)
					{
						if(game[i]!=null)
						{
							if(type[i].equals(typeName))
							{
								System.out.println(gid[i]+"\t"+game[i]+"\t"+place[i]+"\t"+price[i]+"\t"+num[i]);
							}
						}
					}
					System.out.println("������Ҫ�������Ʒ���:");
					p=input.nextInt();
					if(username==null)
					{
						System.out.println("����û�е�¼�����¼��ע����!");
						do
						{
							ap="n";
							System.out.println("----------------------------------------------------");
							System.out.println("                       1.��¼");
							System.out.println("                       2.ע��");
							System.out.println("��ѡ��:");
							int a=input.nextInt();
							if(a==1)
							{
								do
								{
									ap="n";
									boolean flag=false;
									System.out.println("�������û���:");
									String inName=input.next();
									System.out.println("��������  ��:");
									String inPwd=input.next();
									for(int i=0;i<10;i++)
									{
										if(uame[i]!=null)
										{
											if(uame[i].equals(inName)&&uwd[i].equals(inPwd))
											{
												flag=true;
												break;
											}
										}
									}
									if(flag)
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
							}
							else if(a==2)
							{
								String inName=null;
								do
								{
									ap="n";
									boolean flag=false;
									System.out.println("�������û���:");
									inName=input.next();
									for(int i=0;i<10;i++)
									{
										if(uame[i]!=null)
										{
											if(uame[i].equals(inName))
											{
												flag=true;
												break;
											}
										}
									}
									if(flag)
									{
										System.out.println("���û����ѱ�ռ�ã�����������!");
									    ap="y";
									}
								}while(ap.equals("y"));
								String inPwd=null;
								do
								{
									ap="n";
									System.out.println("����������:");
									inPwd=input.next();
									if(inPwd.length()<6)
									{
										System.out.println("���볤�Ȳ���������λ������������!");
										ap="y";
									}
								}while(ap.equals("y"));
								String confPwd=null;
								do
								{
									ap="n";
									System.out.println("������ȷ������:");
									confPwd=input.next();
									if(!inPwd.equals(confPwd))
									{
										System.out.println("ȷ����������벻һ�£�����������!");
										ap="y";
									}
								}while(ap.equals("y"));
								double inMoney=0;
								do
								{
									ap="n";
									System.out.println("������ע����:");
									inMoney=input.nextDouble();
									if(inMoney<100)
									{
										System.out.println("ע����ܵ���100Ԫ�����������!");
										ap="y";
									}
								}while(ap.equals("y"));
								for(int j=0;j<10;j++)
								{
									if(uid[j]==0)//�ҵ���һ��uidֵΪ0�ļ���
									{
										uid[j]=uid[j-1]+1;
										uame[j]=inName;
										uwd[j]=inPwd;
										money[j]=inMoney;
										break;
									}
								}
								username=inName;
								System.out.println("ע��ɹ�����ӭ���û�"+username);
							}
							else
							{
								System.out.println("ѡ�����������ѡ��!");
								ap="y";
							}
						}while(ap.equals("y"));
					}
					boolean isFlag=false;
					for(int i=0;i<10;i++)
					{
						if(game[i]!=null)
						{
							if(type[i].equals(typeName))
							{
								if(gid[i]==p)
								{
									isFlag=true;
									break;
								}
							}
						}
					}
					if(isFlag==false)
					{
						System.out.println("��Ʒ����������������ѡ��!");
						an="y";
					}
				}while(an.equals("y"));
				int n=0;//���������
				do
				{
					an="n";
					boolean isFlag=false;
					System.out.println("������Ҫ���������:");
					n=input.nextInt();
					for(int i=0;i<10;i++)
					{
						if(gid[i]!=0&&gid[i]==p)
						{
							if(num[i]<n)
							{
								isFlag=true;
							}
							else
							{
								num[i]=num[i]-n;//������
							}
						}
					}
					if(isFlag==true)
					{
						System.out.println("��治�㣬����������!");
						an="y";
						for(int i=0;i<10;i++)
						{
							if(gid[i]!=0&&gid[i]==p)
							{
								System.out.println(gid[i]+"\t"+game[i]+"\t"+place[i]+"\t"+price[i]+"\t"+num[i]);
							}
						}
					}
				}while(an.equals("y"));
				boolean fg=false;
				for(int i=0;i<20;i++)
				{
					/*
					 *�洢�ѹ������Ʒ��Ϣ
					 */
					if(bid[i]!=0&&bid[i]==p)//�жϹ������Ʒ�Ƿ��ڱ��ι���������Ѿ����
					{
						bum[i]=bum[i]+n;
						fg=true;
						break;
					}
				}
				if(fg==false)
				{
					for(int i=0;i<20;i++)
					{
						if(bid[i]==0)
						{
							bid[i]=p;
							bum[i]=n;
							bame[i]=username;
							break;
						}
					}
				}
				System.out.println("����Ҫ��������"+typeName+"��?");
				ap=input.next();
			}while(ap.equals("y"));
			System.out.println("����Ҫ����������?");
			al=input.next();
		}while(al.equals("y"));
		System.out.println("------------------------�����嵥-------------------------");
		double sum=0;
		System.out.println("���\t����\t\t����\t����\t����\tС��");
		for(int i=0;i<20;i++)//��ѭ���ߵ����ѹ������Ʒ��Ϣ
		{
			if(bid[i]!=0&&bame[i].equals(username))
			{
				for(int j=0;j<10;j++)//��ѭ���ߵ�����Ʒ��Ϣ
				{
					if(bid[i]==gid[j])
					{
						System.out.println(bid[i]+"\t"+game[j]+"\t"+place[j]+"\t"+price[j]+"\t"+bum[i]+"\t"+price[j]*bum[i]);
					    sum=sum+price[j]*bum[i];
					}
				}
			}
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
					if(uame[i]!=null&&uame[i].equals(username))
					{
						if(money[i]<sum)
						{
							System.out.println("�������㣬���ֵ!");
							System.out.println("�������ֵ���:");
							double mq=input.nextDouble();
							money[i]=money[i]+mq;
							as="y";
						}
						else
						{
							money[i]=money[i]-sum;
							as="n";
							System.out.println("���������:"+money[i]);
						}
					}
				}
			}
		}while(as.equals("y"));
	}
}