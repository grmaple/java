/*
*	��    ����06
*	���ӹ��ܣ�
*	��� bug������0����Ʒ��bug
*/
import java.util.Scanner;
public class Shop06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//��Ʒ��Ϣ
		int[] gid=new int[10];//��Ʒ���
		String[] game=new String[10];//��Ʒ����
		String[] place=new String[10];//ԭ����
		int[] price=new int[10];//����
		int[] number=new int[10];//���
		String[] type=new String[10];//��Ʒ����
		//�û���Ϣ
		//int[] uid=new int[10];//�˺�
		String[] uname=new String[10];//�û���
		String[] password=new String[10];//����
		int[] money=new int[10];//���
		//�����嵥
		int[] id=new int[10];//�嵥���
		int[] goodid=new int[10];//��Ʒ���
		String[] goodname=new String[10];//��Ʒ����
		int[] goodpri=new int[10];//��Ʒ����
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
		//uid[0]=1001;
		uname[0]="admin";
		password[0]="123456";
		money[0]=1000;
		
		int elenum = 2;//��������
		int clonum = 2;//��������
		int frunum = 2;//ˮ������
		int goodsnum = 6;//��Ʒ����
		int usernum = 1;//�û�����
		int listnum = 0;//�嵥����
		int allsum =0;//�ܼ�
		int loc = 0;//��¼��ǰ���ĸ��˻���¼
		String an = "n";//��¼�Ƿ��¼
		while (true) {//������
			System.out.println("------------------------------------------------------------");
			System.out.println("                              �̳�                          ");
			System.out.println("------------------------------------------------------------");
			System.out.println("��Ʒ����:");
			System.out.println("                            1.����");
			System.out.println("                            2.ˮ��");
			System.out.println("                            3.����");
			System.out.println("11.�����嵥");
			System.out.println("0 .�˳��̳�");
			System.out.println("------------------------------------------------------------");
			System.out.print("��ѡ��:");
			int select = input.nextInt();
			if (select == 1) {//��������
				char tag = 'z';//��¼�Ƿ񷵻�������
				while (true) {
					System.out.println("------------------------------------------------------------");
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
					System.out.println("0.����������");
					System.out.println();
					System.out.print("��ѡ��:");
					int select2 = input.nextInt();
					if (select2 == 0){
						break;
					}
					if(!an.equals("y")) {
						System.out.println("����û�е�¼�����¼��ע����!");
					}
					while (!an.equals("y")) {//��¼ע��
						System.out.println("------------------------------------------------------------");
						System.out.println("                               1.��¼");
						System.out.println("                               2.ע��");
						System.out.print("��ѡ��:");
						int choose = input.nextInt();
						if (choose == 1) {//��¼
							String loguname;
							String logpassword;
							System.out.print("�������û���:");
							loguname = input.next();
							int i = 0;
							while (i<usernum) {
								if (loguname.equals(uname[i])) {
									loc = i;
									break;
								}
								i++;
							}
							if (i == usernum) {
								System.out.println("�˺Ų����ڣ������µ�¼/ע��");
								continue;
							}
							System.out.print("��������  ��:");
							logpassword = input.next();
							if (!logpassword.equals(password[loc])) {
								System.out.println("������������µ�¼/ע��");
								continue;
							}
							System.out.println("��¼�ɹ�����ӭ������");
							an="y";//�ѵ�¼
							break;
						} else if (choose == 2) {//ע��
							//int newuid;
							String newuname;
							String newpassword;
							int newmoney;
							boolean a = true;
							System.out.print("�������û���:");
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
							System.out.print("��������  ��:");
							newpassword = input.next();
							if (newpassword.length() < 6) {
								System.out.println("���볤�ȹ��̣������µ�¼/ע��");
								continue;
							}
							System.out.print("������ע����:");
							newmoney = input.nextInt();
							
							if (newmoney < 100) {
								System.out.println("ע������ͣ������µ�¼/ע��");
								continue;
							}
							uname[usernum] = newuname;
							password[usernum] = newpassword;
							money[usernum] = newmoney;
							usernum++;
							System.out.println("ע��ɹ�����ӭ���룡");
						} else {
							System.out.println("�����������������");
							continue;
						}
					}
					if (select2>0 && select2<=goodsnum) {
						int pos = select2-1;
						if (!type[pos].equals("����")) {//�ڵ������棬������������Ʒ�ı��
							System.out.println("������Ʒ��Ŵ�������������2!");
							continue;//��������
						}
						System.out.print("�����빺������:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum > 0 && buynum <= number[pos]) {//��������С�ڿ��
								number[pos] = number[pos]-buynum;
								//���궫�������빺���嵥
								int i = 0;
								while (i<listnum) {//��ԭ�����������
									if (gid[pos] == goodid[i]) {
										num[i] += buynum;
										sum[i] += buynum*price[pos];
										break;
									}
									i++;
								}
								if (i == listnum) {//������
									id[listnum] = listnum+1;
									goodid[listnum] = gid[pos];
									goodname[listnum] = game[pos];
									num[listnum] = buynum;
									goodpri[listnum] = price[pos];
									sum[listnum] = buynum*price[pos];
									listnum++;
								}
								//��������
								System.out.println("����Ҫ�������������? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//��ת����������
									break;
								} else if (c == 'n') {
									System.out.println("����Ҫ����������? y/n");
									tag = input.next().charAt(0);
									break;
								}
							} else if (buynum == 0) {//��0��
								break;
							} else {
								System.out.println("����"+number[pos]+"��"+goodname[pos]);
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
					System.out.println("------------------------------------------------------------");
					allsum = 0;
					System.out.println("���Ĺ����嵥����");
					System.out.println("���\t����\t\t����\t����\tС��");
					for (int i = 0; i < listnum; i++) {
							System.out.print(id[i]+"\t");
							System.out.print(goodname[i]+"\t");
							System.out.print(num[i]+"\t");
							System.out.print(goodpri[i]+"\t");
							System.out.print(sum[i]+"\n");
							allsum = allsum+sum[i];
					}
					System.out.println();
					System.out.println("�ܼ�:"+allsum);
					System.out.println("�����ڵ������"+money[loc]);
					System.out.println("�������ڽ�����y/n");
					char check = input.next().charAt(0);
					if (check == 'y') {//����
						if (money[loc] >= allsum) {
							money[loc] -= allsum;
							System.out.println("����ɹ����������ѹ���"+allsum+"�����������"+money[loc]+"!");
							listnum = 0;//�����嵥���
						} else {
							System.out.println("�������㣬���ֵ��");
							System.out.print("�������ֵ��");
							int mon = input.nextInt();
							money[loc] += mon;
							System.out.println("��ֵ�ɹ���");
							//money[loc] -= allsum;
							//System.out.println("����ɹ����������ѹ���"+allsum+"�����������"+money[loc]+"!");
						}
						continue;
					} else {
						System.out.println("������������£�");
						continue;
					}
				}
			} else if (select == 2) {//ˮ������
				char tag = 'z';//��¼�Ƿ񷵻�������
				while (true) {
					System.out.println("------------------------------------------------------------");
					System.out.println("���\t����\t\tԭ����\t���\t����");
					for (int i = 0; i < goodsnum; i++) {
						if (type[i].equals("ˮ��")) {
							System.out.print(gid[i]+"\t");
							System.out.print(game[i]+"\t");
							System.out.print(place[i]+"\t");
							System.out.print(number[i]+"\t");
							System.out.print(price[i]+"\n");
						}
					}
					System.out.println("0.����������");
					System.out.println();
					System.out.print("��ѡ��:");
					int select2 = input.nextInt();
					if (select2 == 0){
						break;
					}
					if(!an.equals("y")) {
						System.out.println("����û�е�¼�����¼��ע����!");
					}
					while (!an.equals("y")) {//��¼ע��
						System.out.println("------------------------------------------------------------");
						System.out.println("                               1.��¼");
						System.out.println("                               2.ע��");
						System.out.print("��ѡ��:");
						int choose = input.nextInt();
						if (choose == 1) {//��¼
							String loguname;
							String logpassword;
							System.out.print("�������û���:");
							loguname = input.next();
							int i = 0;
							while (i<usernum) {
								if (loguname.equals(uname[i])) {
									loc = i;
									break;
								}
								i++;
							}
							if (i == usernum) {
								System.out.println("�˺Ų����ڣ������µ�¼/ע��");
								continue;
							}
							System.out.print("��������  ��:");
							logpassword = input.next();
							if (!logpassword.equals(password[loc])) {
								System.out.println("������������µ�¼/ע��");
								continue;
							}
							System.out.println("��¼�ɹ�����ӭ������");
							an="y";//�ѵ�¼
							break;
						} else if (choose == 2) {//ע��
							//int newuid;
							String newuname;
							String newpassword;
							int newmoney;
							boolean a = true;
							System.out.print("�������û���:");
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
							System.out.print("��������  ��:");
							newpassword = input.next();
							if (newpassword.length() < 6) {
								System.out.println("���볤�ȹ��̣������µ�¼/ע��");
								continue;
							}
							System.out.print("������ע����:");
							newmoney = input.nextInt();
							
							if (newmoney < 100) {
								System.out.println("ע������ͣ������µ�¼/ע��");
								continue;
							}
							uname[usernum] = newuname;
							password[usernum] = newpassword;
							money[usernum] = newmoney;
							usernum++;
							System.out.println("ע��ɹ�����ӭ���룡");
						} else {
							System.out.println("�����������������");
							continue;
						}
					}
					if (select2>0 && select2<=goodsnum) {
						int pos = select2-1;
						if (!type[pos].equals("ˮ��")) {//��ˮ�����棬������������Ʒ�ı��
							System.out.println("������Ʒ��Ŵ�������������!");
							continue;//��������
						}
						System.out.print("�����빺������:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum > 0 && buynum <= number[pos]) {//��������С�ڿ��
								number[pos] = number[pos]-buynum;
								//���궫�������빺���嵥
								int i = 0;
								while (i<listnum) {//��ԭ�����������
									if (gid[pos] == goodid[i]) {
										num[i] += buynum;
										sum[i] += buynum*price[pos];
										break;
									}
									i++;
								}
								if (i == listnum) {//������
									id[listnum] = listnum+1;
									goodid[listnum] = gid[pos];
									goodname[listnum] = game[pos];
									num[listnum] = buynum;
									goodpri[listnum] = price[pos];
									sum[listnum] = buynum*price[pos];
									listnum++;
								}
								//��������
								System.out.println("����Ҫ��������ˮ����? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//��ת��ˮ������
									break;
								} else if (c == 'n') {
									System.out.println("����Ҫ����������? y/n");
									tag = input.next().charAt(0);
									break;
								}
							} else if (buynum == 0) {//��0��
								break;
							} else {
								System.out.println("����"+number[pos]+"��"+goodname[pos]);
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
					System.out.println("------------------------------------------------------------");
					allsum = 0;
					System.out.println("���Ĺ����嵥����");
					System.out.println("���\t����\t\t����\tС��");
					for (int i = 0; i < listnum; i++) {
							System.out.print(id[i]+"\t");
							System.out.print(goodname[i]+"\t");
							System.out.print(num[i]+"\t");
							System.out.print(sum[i]+"\n");
							allsum = allsum+sum[i];
					}
					System.out.println();
					System.out.println("�ܼ�:"+allsum);
					System.out.println("�����ڵ������"+money[loc]);
					System.out.println("�������ڽ�����y/n");
					char check = input.next().charAt(0);
					if (check == 'y') {//����
						if (money[loc] >= allsum) {
							money[loc] -= allsum;
							System.out.println("����ɹ����������ѹ���"+allsum+"�����������"+money[loc]+"!");
							listnum = 0;//�����嵥���
						} else {
							System.out.println("�������㣬���ֵ��");
							System.out.print("�������ֵ��");
							int mon = input.nextInt();
							money[loc] += mon;
							System.out.println("��ֵ�ɹ���");
						}
						continue;
					} else {
						System.out.println("������������£�");
						continue;
					}
				}
			} else if (select == 3) {//���ν���
				char tag = 'z';//��¼�Ƿ񷵻�������
				while (true) {
					System.out.println("------------------------------------------------------------");
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
					System.out.println("0.����������");
					System.out.println();
					System.out.print("��ѡ��:");
					int select2 = input.nextInt();
					if (select2 == 0){
						break;
					}
					if(!an.equals("y")) {
						System.out.println("����û�е�¼�����¼��ע����!");
					}
					while (!an.equals("y")) {//��¼ע��
						System.out.println("------------------------------------------------------------");
						System.out.println("                               1.��¼");
						System.out.println("                               2.ע��");
						System.out.print("��ѡ��:");
						int choose = input.nextInt();
						if (choose == 1) {//��¼
							String loguname;
							String logpassword;
							System.out.print("�������û���:");
							loguname = input.next();
							int i = 0;
							while (i<usernum) {
								if (loguname.equals(uname[i])) {
									loc = i;
									break;
								}
								i++;
							}
							if (i == usernum) {
								System.out.println("�˺Ų����ڣ������µ�¼/ע��");
								continue;
							}
							System.out.print("��������  ��:");
							logpassword = input.next();
							if (!logpassword.equals(password[loc])) {
								System.out.println("������������µ�¼/ע��");
								continue;
							}
							System.out.println("��¼�ɹ�����ӭ������");
							an="y";//�ѵ�¼
							break;
						} else if (choose == 2) {//ע��
							//int newuid;
							String newuname;
							String newpassword;
							int newmoney;
							boolean a = true;
							System.out.print("�������û���:");
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
							System.out.print("��������  ��:");
							newpassword = input.next();
							if (newpassword.length() < 6) {
								System.out.println("���볤�ȹ��̣������µ�¼/ע��");
								continue;
							}
							System.out.print("������ע����:");
							newmoney = input.nextInt();
							
							if (newmoney < 100) {
								System.out.println("ע������ͣ������µ�¼/ע��");
								continue;
							}
							uname[usernum] = newuname;
							password[usernum] = newpassword;
							money[usernum] = newmoney;
							usernum++;
							System.out.println("ע��ɹ�����ӭ���룡");
						} else {
							System.out.println("�����������������");
							continue;
						}
					}
					if (select2>0 && select2<=goodsnum) {
						int pos = select2-1;
						if (!type[pos].equals("����")) {//�ڷ��ν��棬������������Ʒ�ı��
							System.out.println("������Ʒ��Ŵ�������������!");
							continue;//��������
						}
						
						System.out.print("�����빺������:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum > 0 && buynum <= number[pos]) {//��������С�ڿ��
								number[pos] = number[pos]-buynum;
								//���궫�������빺���嵥
								int i = 0;
								while (i<listnum) {//��ԭ�����������
									if (gid[pos] == goodid[i]) {
										num[i] += buynum;
										sum[i] += buynum*price[pos];
										break;
									}
									i++;
								}
								if (i == listnum) {//������
									id[listnum] = listnum+1;
									goodid[listnum] = gid[pos];
									goodname[listnum] = game[pos];
									num[listnum] = buynum;
									goodpri[listnum] = price[pos];
									sum[listnum] = buynum*price[pos];
									listnum++;
								}
								//��������
								System.out.println("����Ҫ�������������? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//��ת�����ν���
									break;
								} else if (c == 'n') {
									System.out.println("����Ҫ����������? y/n");
									tag = input.next().charAt(0);
									break;
								}
							} else if (buynum == 0) {//��0��
								break;
							} else {
								System.out.println("����"+number[pos]+"��"+goodname[pos]);
								System.out.println("��治�㣬����������:");
								continue;
							}
						}
					} else {
						System.out.println("������Ʒ��Ŵ�������������!");
						continue;
					}
					if (tag == 'y') {//��ת�������棬��'n'���ص�������
						break;
					} else if (tag == 'n') {
						break;
					}
				}
				if (tag == 'n') {
					System.out.println("------------------------------------------------------------");
					allsum = 0;
					System.out.println("���Ĺ����嵥����");
					System.out.println("���\t����\t\t����\tС��");
					for (int i = 0; i < listnum; i++) {
							System.out.print(id[i]+"\t");
							System.out.print(goodname[i]+"\t");
							System.out.print(num[i]+"\t");
							System.out.print(sum[i]+"\n");
							allsum = allsum+sum[i];
					}
					System.out.println();
					System.out.println("�ܼ�:"+allsum);
					System.out.println("�����ڵ������"+money[loc]);
					System.out.println("�������ڽ�����y/n");
					char check = input.next().charAt(0);
					if (check == 'y') {//����
						if (money[loc] >= allsum) {
							money[loc] -= allsum;
							System.out.println("����ɹ����������ѹ���"+allsum+"�����������"+money[loc]+"!");
							listnum = 0;//�����嵥���
						} else {
							System.out.println("�������㣬���ֵ��");
							System.out.print("�������ֵ��");
							int mon = input.nextInt();
							money[loc] += mon;
							System.out.println("��ֵ�ɹ���");
						}
						continue;
					} else {
						System.out.println("������������£�");
						continue;
					}
				}
			} else if (select == 0) {//�˳�
				break;
			} else if (select == 11) {//�����嵥
				System.out.println("------------------------------------------------------------");
				allsum = 0;
				System.out.println("���Ĺ����嵥����");
				System.out.println("���\t����\t\t����\tС��");
				for (int i = 0; i < listnum; i++) {
						System.out.print(id[i]+"\t");
						System.out.print(goodname[i]+"\t");
						System.out.print(num[i]+"\t");
						System.out.print(sum[i]+"\n");
						allsum = allsum+sum[i];
				}
				System.out.println();
				System.out.println("�ܼ�:"+allsum);
				System.out.println("�����ڵ������"+money[loc]);
				System.out.println("�������ڽ�����y/n");
				char check = input.next().charAt(0);
				if (check == 'y') {//����
					if (money[loc] >= allsum) {
						money[loc] -= allsum;
						System.out.println("����ɹ����������ѹ���"+allsum+"�����������"+money[loc]+"!");
						listnum = 0;//�����嵥���
					} else {
						System.out.println("�������㣬���ֵ��");
						System.out.print("�������ֵ��");
						int mon = input.nextInt();
						money[loc] += mon;
						System.out.println("��ֵ�ɹ���");
					}
					continue;
				} else {
					System.out.println("������������£�");
					continue;
				}
			} else {
				System.out.println("��������޸�������Ʒ������������!");
				continue;
			}
		} 
		
	}
}