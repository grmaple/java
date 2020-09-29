## Day8

今天上午学的是java连接mysql。

可以通过navicat进行mysql数据库管理和设计工具。

navicat自己有图形化界面和命令行界面操作数据库。

我们这里学习如何通过java文件来连接mysql，然后在navicat中显示出来。

### java连接mysql

##### 一、打开myql服务

管理员命令行下打开 

net start mysql

##### 二、在navicat中创建数据库

1.连接mysql

2.创建myuser数据库

3.创建user表

![image-20200929104656830](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200929104656830.png)

4.给user添加数据

![image-20200929104745846](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200929104745846.png)

也可以通过命令行添加数据

点击新建查询，打开命令行，输入sql命令

增加

insert into user(id,name,password,money) value(1,'张三',122,2222)

修改

update user set name='中是',password='10',money=12 where id=1

删除

delete from user where id=1

查询

select * from user

![image-20200929105015166](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200929105015166.png)

##### 三、在eclipse中创建java项目，操作mysql

###### 1.加入jdbc包，mysql-connector-java-5.1.7-bin.jar

通过配置构造路径将这个jdbc包加入到项目。

![image-20200929105634420](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200929105634420.png)

###### 2.写测试函数，通过加入junit测试框架实现

2.1加载驱动

驱动字符串："com.mysql.jdbc.Driver"

Class.forName("com.mysql.jdbc.Driver");

2.2建立连接

连接字符串："jdbc:mysql://localhost:3306/myuser"

后面的myuser对应myuser数据库

如果想能显示中文需要加上 ?characterEncoding=utf-8

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser", "root", "root");

后面的两个字符串分别是mysql的账号和密码。

记住需要 

import java.sql.Connection;

import java.sql.DriverManager;

```java
package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
public class Demo {
	@Test
	public void test01() {
		//应用程序和数据库的连接
		//1.加载驱动，指明应用程序和哪个数据库服务器建立连接
		//2.建立连接，指明应用程序具体和服务器中的哪一个数据库建立连接
		//3.
		try {
			//1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");//驱动字符串
			//2.建立连接，conn是连接对象
            //一个Connection对象就代表一个数据库的连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser", "root", "root");//连接字符串
			if(conn!=null) {
				System.out.println("连接成功");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
```

https://www.runoob.com/java/java-mysql-connect.html

注意这里MySQL 8.0 以上版本需要驱动包版本mysql-connector-java-8.0.16.jar

然后修改两个地方：

驱动字符串改成 com.mysql.cj.jdbc.Driver

连接字符串改成 jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

- MySQL 8.0 以上版本不需要建立 SSL 连接的，需要显示关闭。
- allowPublicKeyRetrieval=true 允许客户端从服务器获取公钥。
- 最后还需要设置 CST。

###### 3.增删改查操作

3.1增加

先建立sql语句对应的字符串sql。并且使用?占位符，留到后面给其赋值。

然后利用连接对象拿到能处理sql语句的对象

PreparedStatement pstmt=conn.prepareStatement(sql);

这里需要import java.sql.PreparedStatement;

如何给?占位符的内容赋值呢？使用set类型方法可以给数据赋值。

然后执行更新，增删改是updata，返回的是受影响的行数

int num=pstmt.executeUpdate();

```java
if(conn!=null) {
    //此处？称之为占位符，意味着这里有值需要赋
    String sql="insert into user(id,name,password,money) value(?,?,?,?)";
    //利用连接对象拿到能处理sql语句的对象
    PreparedStatement pstmt=conn.prepareStatement(sql);
    //如何给占位符赋值？第几个问号是什么类型就利用pstmt对象使用set类型给第几个问号赋值
    pstmt.setInt(1,2);
    pstmt.setString(2, "李四");
    pstmt.setString(3, "1872");
    pstmt.setDouble(4, 200);
    //增删改是updata，返回的是受影响的行数
    int num=pstmt.executeUpdate();
    if(num>0) {
        System.out.println("添加成功");
    }
}
```

3.2修改

修改和增加不一样的只是sql语句

```java
if(conn!=null) {
    //此处？称之为占位符，意味着这里有值需要赋
    String sql="update user set name=?,password=?,money=? where id=?";
    //利用连接对象拿到能处理sql语句的对象
    PreparedStatement pstmt=conn.prepareStatement(sql);
    //如何给占位符赋值？第几个问号是什么类型就利用pstmt对象使用set类型给第几个问号赋值
    pstmt.setString(1,"李四");
    pstmt.setString(2, "187222");
    pstmt.setDouble(3, 200);
    pstmt.setInt(4, 2);
    //增删改是updata，返回的是受影响的行数
    int num=pstmt.executeUpdate();
    if(num>0) {
    System.out.println("修改成功");
    }
}
```

3.3删除

删除和增加不一样的只是sql语句

```java
if(conn!=null) {
    String sql="delete from user where id=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, 2);
    int num=pstmt.executeUpdate();
    if(num>0) {
        System.out.println("删除成功");
    }
}
```

3.4查找

查找和增删改是不一样的，因为后者返回的是修改的行数，前者返回的是数据库对象

查询，需要把数据从数据库丢到应用程序，所以要有东西接收数据，需要import java.sql.ResultSet;

ResultSet rs=pstmt.executeQuery();

那么怎么将rs内的数据输出到终端?通过get类型方法可以获得数据。

怎么判断有没有数据，什么时候没有数据?下一行为空时就退出。

为什么不把第一行输出出来?因为rs内的第一行数据是列名，不用输出出来

```java
if(conn!=null) {
    String sql="select * from user";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    //查询返回结果值，结果是包含列名在内的虚拟表
    ResultSet rs=pstmt.executeQuery();
    while(rs.next()) {//next方法判断下一行是否存在数据，第一行是列名，所以一开始就是下一行
        System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("password")+"\t"+rs.getDouble("money"));
    }
}
```



##### 打开navicat

myschool数据库

年级信息表grade

id int 主键

name varchar

1 大一

2 大二

3 大三

4 大四

5 研一

学生信息表student

id  int 11 主键

name varchar 20

sex varchar 4

address varchar 50

phone varchar 20 

gid int 11 外键

外键添加

stu_fk_gid gid myschool grade id

![image-20200929140653369](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200929140653369.png)

2017001 小林 男 广东湛江 110 4

2018002 小慧 女 广东广州 120 3

##### 打开eclipse

新建MyJdbc项目

新建文件夹lib

把jdbc包放到lib下面

构造路径，add jars 添加jdbc。这样其物理位置是在项目下的。

之前是从外部添加进来，物理位置是在电脑的某个位置。

新建类dbc.BaseDao

```java
package dbc;
public class BaseDao{
    public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(" com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(" jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","root");
        } catch (Exception e){
            e.printStackTrace();
        }   
        return conn;
    }
    public void closeConn(Connection conn,PreparedStatement pstmt,ResultSet rs) {
        //
        if (rs!=null) {
            try{
                rs.close();
            } catch (Exception e){
                e.printStackTrace();
            }  
        }
        if (pstmt!=null) {
            try{
                pstmt.close();
            } catch (Exception e){
                e.printStackTrace();
            }  
        }
        if (conn!=null) {
            try{
                conn.close();
            } catch (Exception e){
                e.printStackTrace();
            }  
        }
    }
}
```

新建类demo.Demo

使用jnuit测试框架

```java
package demo;
public class Demo{
    //添加一个新年级
    //添加一个新学生
    //查询某年级的学生信息
    //查询某个学号的学生信息
    Scanner input = new Scanner(System.in);
    BaseDao bs = new BaseDao();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    @Test
    public void test01(){//添加一个新年级
        System.out.println("请输入年级的id：");
        int id = input.nextInt();
        System.out.println("请输入年级的name：");
        String name = input.next();
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "insert into grade(id,name) values(?,?)";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.setString(2, name);
                int num=pstmt.executeUpdate();
                if(num>0) {
                    System.out.println("添加成功");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
    }
    @Test
    public void test02(){//添加一个新学生
        System.out.println("请输入学生的学号：");
        int id = input.nextInt();
        System.out.println("请输入学生的姓名：");
        String name = input.next();
        System.out.println("请输入学生的性别：");
        String sex = input.next();
        System.out.println("请输入学生的籍贯：");
        String address = input.next();
        System.out.println("请输入学生的联系方式：");
        String phone = input.next();
        System.out.println("编号\t名称");
        showGrade();
        System.out.println("请选择年级的编号：");
        int gid = input.nextInt();
        
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "insert into student values(?,?,?,?,?,?)";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.setString(2, name);
                pstmt.setString(3, sex);
                pstmt.setString(4, address);
                pstmt.setString(5, phone);
                pstmt.setInt(6, gid);
                int num=pstmt.executeUpdate();
                if(num>0) {
                    System.out.println("添加成功");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
    }
    public void showGrade(){
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from grade";
            try{
                pstmt=conn.prepareStatement(sql);
                ResultSet rs=pstmt.executeQuery();
   				while(rs.next()) {
                    System.out.println(rs.getInt("id")+"\t"+rs.getString("name"));
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
    }
}
```



