import java.util.Scanner;
public class Myshop01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
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
		String al=null;//��yΪ����ѭ������nΪ����ѭ��
		do {//�̳�����
			String typeName = null;
			String an = null;//��yΪ����ѭ������nΪ����ѭ��
			do {//��Ʒ�������
				an = "n";
				System.out.println("��Ʒ����");
				System.out.println("                   1.����");
				System.out.println("                   2.����");
				System.out.println("                   3.ˮ��");
				System.out.println("��ѡ��:");
				int m=input.nextInt();
				if (m == 1) {
					typeName = "����";
				} else if (m == 2) {
					typeName = "����";
				} else if (m == 3) {
					typeName = "ˮ��";
				} else {
					System.out.println("����ѡ�����������ѡ��!");
					an="y";
				}
			} while(an.equals("y"));
			String ap=null;
			do {//������Ʒ���
				int p = 0;//�������Ʒ���
				do {//��Ʒ����
					an = "n";
					System.out.println("���\t����\t\t����\t����\t���");
					for(int i=0;i<10;i++) {
						if(game[i]!=null) {//������
							if(type[i].equals(typeName)) {//���ϵ�ǰ���͵���Ʒ
								System.out.println(gid[i]+"\t"+game[i]+"\t"+place[i]+"\t"+price[i]+"\t"+num[i]);
							}
						}
					}
					System.out.println("������Ҫ�������Ʒ���:");
					p=input.nextInt();
					if(username==null) {//��¼����
						System.out.println("����û�е�¼�����¼��ע����!");
						System.out.println("----------------------------------------------------");
						System.out.println("                       1.��¼");
						System.out.println("                       2.ע��");
						System.out.println("��ѡ��:");
					}
					boolean isFlag=false;
					for(int i=0;i<10;i++) {
						if(game[i]!=null) {
							if(type[i].equals(typeName)) {
								if(gid[i]==p) {//ѡ�еı�Ŵ���
									isFlag=true;
									break;
								}
							}
						}
					}
					if(isFlag==false) {//��Ŵ�����������
						System.out.println("��Ʒ����������������ѡ��!");
						an="y";
					}
				} while(an.equals("y"));
				int n = 0;//��������
				do {//���빺������
					an = "n";
					boolean isFlag=false;
					System.out.println("������Ҫ���������:");
					n=input.nextInt();
					for(int i=0;i<10;i++) {
						if (gid[i]!=0 && gid[i]==p) {//��Ų�Ϊ0�����������Ʒ
							if (num[i]<n){//��治��
								isFlag = true;
							} else {
								num[i] = num[i]-n;//������
							}
						}
					}
					if(isFlag==true){
						System.out.println("��治�㣬����������!");
						an="y";
						for(int i=0;i<10;i++) {
							if(gid[i]!=0&&gid[i]==p) {
								System.out.println(gid[i]+"\t"+game[i]+"\t"+place[i]+"\t"+price[i]+"\t"+num[i]);
							}
						}
					}
				} while(an.equals("y"));
				System.out.println("����Ҫ��������"+typeName+"��?");
				ap=input.next();
			} while (ap.equals("y"));
			System.out.println("����Ҫ����������?");
			al=input.next();
		} while(al.equals("y"));
	}
}