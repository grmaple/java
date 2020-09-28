package demo;
import org.junit.Test;
import bean.*;
public class Demo {
	//测试
	@Test
	public void test01() {
		//声明父类的对象，实例化的时候指向其子类
		//该对象无法使用子类独有的属性和方法
		User u = new Good();
		//instanceof用于判断对象实例化的时候指向谁
		if (u instanceof Good) {
			System.out.println("指向子类");
		} else if (u instanceof User) {
			System.out.println("指向父类");
		}
	}
}
