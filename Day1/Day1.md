## Day1

大家利用Notepad写代码，在DOS里面利用javac和java命令编译执行，清楚后就开始做，给大家十五分钟，收到请回复

我先来试试大家的基础，大家完成两个案例:1.利用循环实现九九乘法表  2.实现一个七行的菱形

我们十点开始正式讲，到时候我从JDK的安装、配置以及命令的使用开始，再带着大家写着两个例子，看看大家听和学怎么样，好吧

##### 1.利用循环实现九九乘法表  

```java
public class MyFirstJavaProgram {//文件名要和类名一致
	public static void main(String args[]) {
		for(int i = 1; i <= 9; i = i+1) {
			for(int j = i; j <= 9; j = j+1) {
				if(j>i) {
					System.out.print("\t");
				}
				System.out.print(i+"*"+j+"="+i*j);//+是连接符
			}
			System.out.print("\n");
			//System.out.println();//换行
		}
	}
}
```

##### 2.实现一个七行的菱形

```java
import java.util.Scanner;
public class Demo02{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入菱形的行数：");
        int num = input.nextInt();
        //System.out.println(num);
        //菱形只能是奇数
        if (num%2==0){
            System.out.println("菱形的行数只能是奇数!");
        } else {
            int m = (num+1)/2;
            for(int i = 1; i<=m; i++){
                for(int j = 1; j<=m-i;j++){
                    System.out.print(" ");
                }
                for(int k = 1; k<=2*i-1;k++){
                    System.out.print("*");
                }
                System.out.println();
            }
            int n = num-m;
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=i;j++){
                    System.out.print(" ");
                }
                for(int k = 1; k<=num-2*i;k++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
```

做完了的同学尝试把循环加上去，可以重复使用，没做完的同学继续，我们不着急，把每个案例做好理解透好吧，收到请回复

```java
import java.util.Scanner;
public class Demo02{
    public static void main(String[] args) {
        /*如果想向正在运行的程序输入数据，
        需要利用Scanner的对象调用各种方法输入值，
        相当于scanf的作用。
        */
        Scanner input = new Scanner(System.in);
        String an = null;
        do {
            System.out.println("请输入菱形的行数：");
            int num = input.nextInt();
            //System.out.println(num);
            //菱形只能是奇数
            if (num%2==0){
                System.out.println("菱形的行数只能是奇数!");
            } else {
                int m = (num+1)/2;
                /*上部分
    行数 空格数 *数量
    i	m-i		2*i-1
                */
                for(int i = 1; i<=m; i++){
                    for(int j = 1; j<=m-i;j++){
                        System.out.print(" ");
                    }
                    for(int k = 1; k<=2*i-1;k++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                /*上部分
    行数 空格数 *数量
    i	i		num-2*i
                */
                int n = num-m;
                for(int i = 1; i<=n; i++){
                    for(int j = 1; j<=i;j++){
                        System.out.print(" ");
                    }
                    for(int k = 1; k<=num-2*i;k++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
            System.out.println("请问要继续吗？(y/n)");
            an = input.next();
        } while(an.equals("y"));
        
    }
}
```

### 案列：

1.四则运算，输入两个数字和运算符（+,-,*,/,%）,如果运算符输入错误，要求重新输入。

请输入第一个数：5

请输入第二个数：2

请输入运算符：+

7

2.输入m个班，每个班n个同学的成绩。统计每个班的最高分，最低分和平均分，并统计年级的最高分，最低分和平均分

请输入班级的数量：2

请输入第一个班的人数：3

请输入第一个同学的成绩：75

请输入第二个同学的成绩：80

请输入第三个同学的成绩：85

当前班级的最高分是85，最低分是75，平均分是80！

请输入第一个班的人数：4

请输入第一个同学的成绩：70

请输入第二个同学的成绩：80

请输入第三个同学的成绩：90

请输入第三个同学的成绩：100

当前班级的最高分是100，最低分是70，平均分是85！

年级的最高分是100，最低分是70，平均分是82.8！



