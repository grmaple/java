import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//��Ʒ��Ϣ
		int[] gid=new int[10];//��Ʒ���
		String[] game=new String[10];//��Ʒ����
		String[] place=new String[10];//ԭ����
		double[] price=new double[10];//����
		int[] number=new int[10];//���
		String[] type=new String[10];//��Ʒ����
		//�û���Ϣ
		int[] uid=new int[10];//�˺�
		String[] uname=new String[10];//�û���
		String[] password=new String[10];//����
		double[] money=new double[10];//���
		//�����嵥
		int[] id=new int[10];//�嵥���
		int[] goodid=new int[10];//��Ʒ���
		//int[] userid=new int[10];//�û����
		int[] num=new int[10];//��Ʒ����
		int[] sum=new int[10];//С��

		//��ʼ������
		//������Ʒ
		gid[0]=1;
		game[0]="TCL42��Һ���ʵ�";
		place[0]="CHINA";
		price[0]=2500;
		number[0]=50;
		type[0]="����";

		gid[1]=2;
		game[1]="�������ܵ����";
		place[1]="CHINA";
		price[1]=4500;
		number[1]=50;
		type[1]="����";

		gid[2]=3;
		game[2]="��������Ь";
		place[2]="CHINA";
		price[2]=500;
		number[2]=50;
		type[2]="����";

		gid[3]=4;
		game[3]="�ǵ�10����Ь";
		place[3]="USA";
		price[3]=1500;
		number[3]=20;
		type[3]="����";

		gid[4]=5;
		game[4]="ɽ����̨ƻ��";
		place[4]="CHINA";
		price[4]=5;
		number[4]=50;
		type[4]="ˮ��";

		gid[5]=6;
		game[5]="�������߹�";
		place[5]="USA";
		price[5]=15;
		number[5]=20;
		type[5]="ˮ��";
		//�����û�
		uid[0]=1001;
		uname[0]="admin";
		password[0]="123456";
		money[0]=1000;
		int goodsnum = 6;
		int usernum = 1;
		//�̳���ҳ
		System.out.println("------------------------------------------------------------");
		System.out.println("                        �̳�                                        ");
		System.out.println("------------------------------------------------------------");
		String an = "n";//��¼�Ƿ��¼
		char tag = 'z';//��¼�Ƿ񷵻�������
		while (true) {//������
			System.out.println("��Ʒ����:");
			System.out.println("                            1.����");
			System.out.println("                            2.ˮ��");
			System.out.println("                            3.����");
			System.out.print("��ѡ��:");
			int select = input.nextInt();
			if (select == 1) {//��������
				while (true) {
					System.out.println("���\t����\t\tԭ����\t���\t����");
					for (int i = 0; i < goodsnum; i++) {
						if (type[i].equals("����")) {
							System.out.print(gid[i]+"\t");
							System.out.print(game[i]+"\t");
							System.out.print(place[i]+"\t");
							System.out.print(number[i]+"\t");
							System.out.print(price[i]+"\n");
						}
					}
					System.out.println();
					System.out.print("��ѡ��:");
					select = input.nextInt();
					if(!an.equals("y")) {
						System.out.println("����û�е�¼�����¼��ע����!");
					}
					while (!an.equals("y")) {//��¼ע��
						System.out.println("---------------------------------------------------------");
						System.out.println("                               1.��¼");
						System.out.println("                               2.ע��");
						System.out.print("��ѡ��:");
						int choose = input.nextInt();
						if (choose == 1) {//��¼
							String loguname;
							String logpassword;
							System.out.print("�������˺�:");
							loguname = input.next();
							int loc = 0;
							int i = 0;
							// while (i<usernum) {
								// if (loguname.equals(uname[i])) {
									// loc = i;
									// break;
								// }
								// i++;
							// }
							for (int i = 0; i<usernum; i++) {
								if (loguname.equals(uname[i])) {
									loc = i;
									break;
								}
							}
							if (i == usernum) {
								System.out.println("�˺Ų����ڣ������µ�¼/ע��");
								continue;
							}
							System.out.print("����������:");
							logpassword = input.next();
							if (!logpassword.equals(password[loc])) {
								System.out.println("������������µ�¼/ע��");
								continue;
							}
							an="y";//�ѵ�¼
							break;
						} else if (choose == 2) {//ע��
							//int newuid;
							String newuname;
							String newpassword;
							double newmoney;
							boolean a = true;
							System.out.print("�������˺�:");
							newuname = input.next();
							for (int i = 0; i<usernum; i++) {
								if (newuname.equals(uname[i])) {
									System.out.println("�˺��Ѵ��ڣ������µ�¼/ע��");
									a = false;
									break;
								}
							}
							if (a == false) {
								continue;
							}
							System.out.print("����������:");
							newpassword = input.next();
							if (newpassword.length() < 6) {
								System.out.println("���볤�ȹ��̣������µ�¼/ע��");
								continue;
							}
							System.out.print("������ע����:");
							newmoney = input.nextDouble();
							
							if (newmoney < 100) {
								System.out.println("ע������ͣ������µ�¼/ע��");
								continue;
							}
							uname[usernum] = newuname;
							password[usernum] = newpassword;
							money[usernum] = newmoney;
							usernum++;
						} else {
							System.out.println("�����������������");
							continue;
						}
					}
				}
			}
		}
	}
}