/*
*	��    �ߣ�grmaple
*	��    ����01
*	���ӹ��ܣ�ʵ���˵��û����̳�ϵͳ������˵�������
*	��� bug��
*/
import java.util.Scanner;
public class Shop {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//��Ʒ��Ϣ
		String[] goods = new String[5];
		goods[0] = "1";//��Ʒ���
		goods[1] = "TCL42��Һ���ʵ�";//����
		goods[2] = "CHINA";//ԭ����
		goods[3] = "50";//���
		goods[4] = "2459";//����
		//�û���Ϣ
		String[] user = new String[3];
		user[0] = "admin";//�˺�
		user[1] = "123456";//����
		user[2] = "100";//���
		//�����嵥
		String[] list = new String[4];
		list[0] = "";//��Ʒ���
		list[1] = "";//����
		list[2] = "0";//����
		list[3] = "0";//С��
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
					for (int i = 0; i < 5; i++) {
						System.out.print(goods[i]+"\t");
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
							String[] log = new String[2];
							System.out.print("�������˺�:");
							log[0] = input.next();
							if (!log[0].equals(user[0])) {
								System.out.println("�˺Ų����ڣ������µ�¼/ע��");
								continue;
							}
							System.out.print("����������:");
							log[1] = input.next();
							if (!log[1].equals(user[1])) {
								System.out.println("������������µ�¼/ע��");
								continue;
							}
							an="y";//�ѵ�¼
							break;
						} else if (choose == 2) {//ע��
							String[] newuser = new String[3];
							System.out.print("�������˺�:");
							newuser[0] = input.next();
							if (newuser[0].equals(user[0])) {
								System.out.println("�˺��Ѵ��ڣ������µ�¼/ע��");
								continue;
							}
							System.out.print("����������:");
							newuser[1] = input.next();
							if (newuser[1].length() < 6) {
								System.out.println("���볤�ȹ��̣������µ�¼/ע��");
								continue;
							}
							
							System.out.print("������ע����:");
							newuser[2] = input.next();
							if (Integer.parseInt(newuser[2]) < 100) {
								System.out.println("ע������ͣ������µ�¼/ע��");
								continue;
							}
							user[0] = newuser[0];
							user[1] = newuser[1];
							user[1] = newuser[1];
						} else {
							System.out.println("�����������������");
							continue;
						}
					}

					if (select == 1) {//ѡ���һ����Ʒ
						System.out.print("�����빺������:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum <= Integer.parseInt(goods[3])) {//��������С�ڿ��
								//Stringתint���мӼ�����Ȼ��intתString
								goods[3] = String.valueOf(Integer.parseInt(goods[3])-buynum);
								//���궫�������빺���嵥
								list[0] = goods[0];
								list[1] = goods[1];
								//ԭ��������
								int oldnum = Integer.parseInt(list[2]);
								list[2] = String.valueOf(buynum+oldnum);
								//ԭС��
								int oldsum = Integer.parseInt(list[3]);
								list[3] = String.valueOf(Integer.parseInt(goods[4])*buynum + oldsum);
								//��������
								System.out.println("����Ҫ�������������? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//��ת����������
									break;
								} else {//
									System.out.println("����Ҫ����������? y/n");
									tag = input.next().charAt(0);
									break;
								}
							} else {
								System.out.println("��治�㣬����������:");
								continue;
							}
						}
					} else {
						System.out.println("������Ʒ��Ŵ�������������!");
						continue;
					}
					if (tag == 'y') {//��ת��������
						break;
					} else if (tag == 'n') {
						break;
					}
				}
				if (tag == 'n') {
					System.out.println("���Ĺ����嵥����");
					System.out.println("���\t����\t\t����\tС��");
					for (int i = 0; i < 4; i++) {
						System.out.print(list[i]+"\t");
					}
					System.out.println();
					System.out.println("�ܼ�:"+list[3]);
					System.out.println("�������ڽ�����y/n");
					char check = input.next().charAt(0);
					if (check == 'y') {//����
						if (Integer.parseInt(user[2]) >= Integer.parseInt(list[3])) {
							System.out.println("����ɹ�����ӭ�ٴι��٣�");
						} else {
							System.out.println("�������㣬���ֵ��");
						}
						break;
					} else {
						System.out.println("������������£�");
						continue;
					}
				}
			} else if (select == 2) {
				System.out.println("��������Ʒ�Ѿ������ˣ�����������!");
				continue;
			} else if (select == 3) {
				System.out.println("��������Ʒ�Ѿ������ˣ�����������!");
				continue;
			} else {
				System.out.println("��������޸�������Ʒ������������!");
				continue;
			}
		} 
		
	}
}