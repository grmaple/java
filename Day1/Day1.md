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



### 理论基础

一、初始Java

- Java是一种面向对象的高级编程语言，主要用于移动端(安卓)和WEB端(网站)的开发
- Java语言严格区分大小写，对于文件名和类名之间的关系有着严格要求
- Java项目是一个或多个Java文件组成，Java文件是指后缀名为java，内容符合java文件编写要求的文件
- JDK，是一种环境，Java文件编译和执行的一种环境，需要根据相应的电脑进行下载，安装以及进行环境变量的配置
- 命令
  - javac：编译java源文件，编译成功会生成class文件
  - java：执行class文件，一般是执行拥有main方法的编译生成的class文件，得到运行的结果。

二、变量、运算符、表达式

- 变量：就是一个可以存储数据的空间，存储在这个空间里的值是可以变换的，是不唯一的，所以称之为变。

  - 变量是由三要素组成的：数据类型、变量名、变量值 

    int num = 9;

  - 数据类型-数据类型是指在声明变量的时候约束变量赋值的要求，常用数据类型有int、double、float、char、String、boolean

  - 变量名-变量命名是有要求的

    - 只能用字符、下划线和$符号开头
    - 其余的部分可以是字符、下划线、$和数字
    - 关键字不能做变量名
    - 驼峰命名法

  - 变量值-变量的值是根据变量的数据类型给变量的数据

    - int num = 9;
    - double m = 9.0;
    - float n = 9.0f;
    - char c = 'c';
    - String str = "hello";
    - boolean isFlag = true;

  - 在java中，变量声明之后，必须赋值后才能使用

- 运算符：

  - 算术运算符：+、-、*、/
    - +几乎在所有编程语言都被称之为连接运算符，只有前后都是数字的时候才称之为加号
  - 赋值运算符：=
  - 比较运算符：>、>=、<、<=、==、!=、
    - equals()用于判断字符串是否相同
    - "admin".equals("root"),使用比较运算符的结果只能是true/flase
  - 逻辑运算符：&&并且、||或者、!取反

- 表达式：数据和运算符连接在一起的这种结构称之为表达式

  - 5/2就是由两个整数和一个/连接起来的表达式
  - "admin".equals("root")是由两个字符串类型的数据加比较运算符equals连接起来的表达式
  - 表达式是有数据类型的，表达式的数据类型是由组成表达式的数据决定的

三、选择结构

- if…else结构
  - 最简单的if结构
    - if() {}
  - 最基本的if…else结构
    - if() {} else {}
  - 多重的if…else结构
    - if() {} else if() {} else {}
    - 每个else都去找最近的那个if和其匹配
    - 有if才有else
  - 嵌套if…else结构
    - if() {if() {} else {}} else {if() {} else {}}
- switch…case结构
  - switch(val) {case val1:{break;} case val2:{break;} default:{}}
  - switch…case结构就是一种傻瓜式的匹配结构，看哪一个case后面的val值和switch后面的val值相同，就执行哪一个case下的代码，如果没有任何一个case匹配，就执行default下的代码

四、循环

五、数组

### 案例

1.冒泡排序算法

输入任意的整数，利用冒泡排序（从小到大）

```java
import java.util.Scanner;
import java.util.Arrays;
public class Demo05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入要排序的数组长度:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("请输入要排序的数字:");
        for (int i = 0; i<n; i++) {
            arr[i] = input.nextInt();
        }
        BubbleSort(arr);
		System.out.print("排序结果:");
		for (int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
		//System.out.println(Arrays.toString(arr));
    }
	public static void BubbleSort(int[] arr) {
		int temp;//定义一个临时变量
		boolean flag = false;
		for(int i=0;i<arr.length-1;i++){//冒泡趟数
			flag = true;
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j+1]<arr[j]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag == true){
				break;
			}
		}
	}
}

```

2.斐波拉契数列

1、1、2、3、5...

统计前二十位，并统计出前二十位有多少奇数和偶数

```java
import java.util.Scanner;
public class Demo06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入斐波那契数列的长度:");
		int n = input.nextInt();
		int[] arr = new int[n];
		int even = Fibonacci(arr);
		int odd = arr.length - even;
		System.out.println("斐波那契数列前"+n+"个数:");
		for (int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
		System.out.println();
		System.out.println("斐波那契数列前"+n+"个数中有"+odd+"个奇数");
		System.out.println("斐波那契数列前"+n+"个数中有"+even+"个偶数");
	}
	public static int Fibonacci(int[] arr) {
		int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[0] = 1;
            }else if (i == 1) {
                arr[1] =1;
            }else {
                arr[i] = arr[i-1] +arr[i-2];
				if (arr[i]%2 == 0) {
					ret++;
				}
            }
        }
		return ret;
    }
}
```

