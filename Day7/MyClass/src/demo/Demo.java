package demo;
import org.junit.Test;
import bean.*;
public class Demo {
	//����
	@Test
	public void test01() {
		//��������Ķ���ʵ������ʱ��ָ��������
		//�ö����޷�ʹ��������е����Ժͷ���
		User u = new Good();
		//instanceof�����ж϶���ʵ������ʱ��ָ��˭
		if (u instanceof Good) {
			System.out.println("ָ������");
		} else if (u instanceof User) {
			System.out.println("ָ����");
		}
	}
}
