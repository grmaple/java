/*
 *	��    ��:grample
 *	��    ����01
 *	���ӹ��ܣ�
 *	��� bug��
 */
import java.util.Scanner;
public class Rentcar {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String username=null;//�洢�⳵�ʸ���֤ͨ�����û����֤
		//�������Դ��Ϣ
		//������Ϣ
		int[] cid=new int[10];//���
		String[] cname=new String[10];//����
		double[] cdep=new double[10];//Ѻ��
		double[] cpri=new double[10];//�����
		int[] cnum=new int[10];//���
		double[] clat=new double[10];//���ɽ�
		String[] ctype=new String[10];//����
		//�û���Ϣ
		int[] uid=new int[10];//�û�id
		String[] uname=new String[10];//�û����֤
		String[] udriver=new String[10];//�û���ʻ֤
		String[] uphone=new String[10];//�û��绰����
		//�嵥��Ϣ
		int[] bid=new int[20];//���޵��������
		int[] bnum=new int[20];//���޵���������
		String[] bname=new String[20];//�����������û�
		String[] bdata1=new String[10];//�⳵����
		String[] bdata2=new String[10];//��������
		//�����û�
		uid[0]=1001;
		uname[0]="123456789123456789";
		udriver[0]="10000";
		uphone[0]=null;
		
		uid[1]=1002;
		uname[1]="123456789123456780";
		udriver[1]=null;
		uphone[1]=null;
		//��������
		cid[0]=1;
		cname[0]="����";
		cdep[0]=6000;
		cpri[0]=400;
		cnum[0]=2;
		clat[0]=800;
		ctype[0]="�γ�";
		
		cid[1]=2;
		cname[1]="����";
		cdep[1]=5000;
		cpri[1]=300;
		cnum[1]=5;
		clat[1]=600;
		ctype[1]="�γ�";
		
		cid[2]=3;
		cname[2]="����";
		cdep[2]=4000;
		cpri[2]=200;
		cnum[2]=10;
		clat[2]=400;
		ctype[2]="�γ�";
		
		cid[3]=4;
		cname[3]="����";
		cdep[3]=3000;
		cpri[3]=100;
		cnum[3]=10;
		clat[3]=200;
		ctype[3]="�γ�";
		
		cid[4]=5;
		cname[4]="����";
		cdep[4]=4500;
		cpri[4]=250;
		cnum[4]=2;
		clat[4]=500;
		ctype[4]="�ͳ�";
		
		cid[5]=6;
		cname[5]="��";
		cdep[5]=3500;
		cpri[5]=150;
		cnum[5]=2;
		clat[5]=300;
		ctype[5]="�ͳ�";
		
		System.out.println("------------------------------------------------------------");
		System.out.println("                              ��������ϵͳ");
		System.out.println("------------------------------------------------------------");
		String a7=null;
		do {
			a7 = "n";
			String a1=null;
			do {//�⳵������
				String typeName = null;
				String a2 = null;
				do {//�������ͽ���
					a2 = "n";//һ��ʼ���ò�ѭ��
					System.out.println("------------------------------------------------------------");
					System.out.println("�������ͣ�");
					System.out.println("                              1.�γ�");
					System.out.println("                              2.�ͳ�");
					System.out.println("------------------------------------------------------------");
					System.out.println("��ѡ������Ҫѡ��ĳ�������:");
					int i1=input.nextInt();
					if (i1 == 1) {
						typeName = "�γ�";
					} else if (i1 == 2) {
						typeName = "�ͳ�";
					} else {//�������ѭ��
						System.out.println("����ѡ�����������ѡ��!");
						a2="y";
					}
				} while(a2.equals("y"));
				String a3 = null;
				do {//�����������
					int i2 = 0;//���޵ĳ������
					String a4 = null;
					do {//�������޳������
						a4 = "n";
						System.out.println("���\t����\tѺ��\t�����\t���\t���ɽ�");
						for(int i=0;i<10;i++)
						{
							if(cname[i]!=null)
							{
								if(ctype[i].equals(typeName))
								{
									System.out.println(cid[i]+"\t"+cname[i]+"\t"+cdep[i]+"\t"+cpri[i]+"\t"+cnum[i]+"\t"+clat[i]);
								}
							}
						}
						System.out.println("��ѡ������Ҫѡ��ĳ�����ţ�");
						i2=input.nextInt();
						if(username==null) {//��ʻ�ʸ���֤
							System.out.println("����û��ͨ����ʻ�ʸ���֤��������֤!");
							//String a9 = null;
							while(true) {
								//a9 = "n";
								boolean flag=false;
								System.out.println("�������������֤��");
								String inName=input.next();
								int i=0;
								for(;i<10;i++) {
									if(uname[i]!=null) {
										if(uname[i].equals(inName)) {
											flag=true;
											break;
										}
									}
								}
								if(!flag) {
									System.out.println("����������֤�����ڣ����������룡");
									//a9="y";
									continue;
								} else {//���֤����
									if(uname[i].equals(inName) && udriver[i]!=null) {//�м�ʻ֤
										System.out.println("�������飬���ļ�ʻ֤�ǣ�"+udriver[i]);
									} else {
										System.out.println("�������飬û�в��ҵ����ļ�ʻ֤�����������룡");
										//a9="y";
										continue;
									}
								}
								System.out.println("���������ĵ绰���룺");
								String inPho=input.next();
								uphone[i] = inPho;
								System.out.println("��ϲ�㣬��ͨ���⳵�ʸ���֤��");
								username = inName;
								break;
							} 
						}
						boolean isFlag=false;
						for(int i=0;i<10;i++) {
							if(cname[i]!=null) {
								if(ctype[i].equals(typeName)) {
									if(cid[i]==i2) {//ѡ�еı�Ŵ���
										isFlag=true;
										break;
									}
								}
							}
						}
						if(isFlag==false) {//��Ŵ�����������
							System.out.println("��������������������ѡ��!");
							a4="y";
						}
					} while(a4.equals("y"));
					int i3 = 0;//���޵�����
					String a5 = null;
					do {//������������
						a5 = "n";
						boolean isFlag = false;
						System.out.println("��ѡ����������������������");
						i3 = input.nextInt();
						for(int i=0; i<10; i++) {
							if(cid[i]!=0 && cid[i]==i2) {
								if(cnum[i]<i3) {
									isFlag = true;//��治��
								} else {
									cnum[i] = cnum[i] - i3;//������
								}
							}
						}
						//System.out.println(cnum[i2-1]+"test"+isFlag);
						if(isFlag == true) {
							System.out.println("��治�㣬���������룡");
							a5 = "y";
							for(int i=0; i<10; i++) {
								if(cid[i]!=0 && cid[i]==i2) { 
									System.out.println(cid[i]+"\t"+cname[i]+"\t"+cdep[i]+"\t"+cpri[i]+"\t"+cnum[i]+"\t"+clat[i]);
								}
							}
						}
					} while(a5.equals("y"));
					boolean fg = false;
					//�����嵥
					for(int i=0; i<10; i++) {
						if(bid[i]!=0 && bid[i] == i2) {//�ظ�����
							bnum[i] = bnum[i] + i3;
							fg = true;
							break;
						}
					}
					if(fg == false) {//��ѡ�������
						for(int i=0; i<10; i++) {
							if(bnum[i] == 0) {//�ҵ���һ���յ�λ�ò���
								bid[i] = i2;
								bnum[i] = i3;
								bname[i]=username;
								break;
							}
						}
					}
					System.out.println("����Ҫ��������"+typeName+"��?(y/n)");
					a3=input.next();
				} while(a3.equals("y"));
				System.out.println("����Ҫ����������?(y/n)");
				a1=input.next();
			} while(a1.equals("y"));
			System.out.println("------------------------------------------------------------");
			System.out.println("                              �⳵�嵥");
			double depsum = 0;//Ѻ�𹲼�
			double prisum = 0;//��𹲼�
			System.out.println("���\t����\t����\tѺ��\t�����\t�⳵����\t��������\tС��\t���ɽ�");
			for(int i=0;i<20; i++) {
				if(bid[i]!=0 && bname[i].equals(username)) {
					for(int j=0; j<10; j++) {
						if(bid[i]==cid[j]) {
							System.out.println(bid[i]+"\t"+cname[j]+"\t"+bnum[i]+"\t"+cdep[j]+"\t"+cpri[j]+"\t"+cpri[j]*bnum[i]+"\t"+clat[j]);
							depsum = depsum+cdep[j];
							prisum = prisum+cpri[j]*bnum[i];
						}
					}
				}
			}
			System.out.println("Ѻ��ϼƣ�"+depsum);
			System.out.println("���ϼƣ�"+prisum);
			System.out.println("�ϼƣ�"+(prisum+depsum));
			System.out.println("����Ҫ������?(y/n)��");
			String a6=input.next();
			if(a6.equals("y")) {
				System.out.println("лл���Ļݹˣ�����Ҫ�����⳵��?(y/n):");
				String a8=input.next();
				if (a8.equals("y")) {
					a7="y";
				}
			} else {
				System.out.println("�����ȼ�����䣡");
				a7="y";
			}
		} while(a7.equals("y"));
		
	}
}