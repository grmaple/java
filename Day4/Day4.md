## Day4

同学们，今天上午的任务三个:
1.消化昨天的代码，不看我代码的原则上自己独立能够敲出来。
2.继续完成剩下的三分之一，把购物清单和充值付款完成，并实现退出和二次登录购买。
3.预习面向对象并安装Mysql数据库，今天下午我们完成商城后进入面向对象阶段



### mysql安装

安装压缩包，解压到D:\mysql-8.0.21-winx64

在该目录下创建my.ini 配置文件

```imi
# my.ini 
[client]
# 设置mysql客户端默认字符集
default-character-set=utf8
 
[mysqld]
# 设置3306端口
port = 3306
# 设置mysql的安装目录
basedir=C:\\web\\mysql-8.0.11
# 设置 mysql数据库的数据的存放目录，MySQL 8+ 不需要以下配置，系统自己生成即可，否则有可能报错
# datadir=C:\\web\\sqldata
# 允许最大连接数
max_connections=20
# 服务端使用的字符集默认为8比特编码的latin1字符集
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
```

以管理员身份打开 cmd 命令行工具

cd D:\mysql-8.0.21-winx64\bin

初始化数据库：mysqld --initialize --console

会输出root默认密码：2018-04-20T02:35:05.464644Z 5 [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: **APWCY5ws&hjQ**

安装命令：mysqld install

设置环境变量：

MYSQL_HOME      D:\mysql-8.0.21-winx64

PATH 		  %MYSQL_HOME%\bin

启动服务：net start mysql   //需要在管理员模式下

进入mysql：mysql -u root -p 然后输入密码APWCY5ws&hjQ

输入 **exit** 或 **quit** 退出登录

关闭服务： net stop mysql

修改密码：

在进入mysql前，

格式：mysqladmin -u用户名 -p旧密码 password 新密码  

mysqladmin -uroot -pAPWCY5ws&hjQ password 123



### 面向对象

万物皆对象！

类：模糊抽象的概念，是通过对象总结出来的。

对象：对象是类具体的个体体现，是清晰的，具体的。

通过总结对象得出类的概念，道理总结的是对象的什么特点?

简单来说，观察对象的特点就是观察它的**动静二态**

对象的静态的特点我们称之为属性；

对象的动态的特点我们称之为方法(行为)。

在类中，属性和方法只需要起到描述的作用就可以了，具体的对象是需要实际值的。

在开发中，我们如何通过类拿到对象？

- 类 对象名 = new 类();

- 其中，对象名就代表当前类的一个具体的对象，这个过程称之为实例化。

- 具体的过程是：

  - 类 对象名 = null;//声明对象
  - 对象名 = new 类();//实例化

- 一旦对象被实例化，也就意味着该对象可以使用类具备的属性和方法

- 方法：

  - 普通方法
    - 无返回值且无参数的方法
      - 无返回值的关键字:void 
      - public void f(){}
    - 有返回值且无参数的方法
      - 如果一个方法是有返回值的值，那么这个方法的最后一句一定是return+value;这个value的数据类型一定和方法的返回值类型保持一致.
      - 调用有返回值的方法的时候需要声明和该方法返回值类型相同的变量去接收返回的值
      - public int f(){return n;}
    - 无返回值且有参数的方法
      - 有参数的方法，这些参数被称之为形式参数，简称形参，形参相当于声明的但是没有赋值的变量，调用该方法的时候必须给这些参数赋值，赋的值被称之为实参。
      - public void f(int a){}
    - 有返回值且有参数的方法
      - public int f(int a){return a;}

  - 2.构造方法
    - 类的对象之所以能被实例化就是因为类中存在着构造方法!
    - new后面的跟着的 类()其实是一个方法,即使构造方法。
    - 在创建一个类的时候，这个类中的无参构造方法就伴随着类的生成而生成了！
    - 构造方法的特点是与类同名，且没有任何返回值类型!
    - 我们可以手动添加带参的构造方法，参数有多少个自行决定，带参的构造方法很大的一个优势就在于实例化对象的同时给对象的属性赋值!
    - 但是需要记住，一旦手动添加了带参的构造方法，那么默认存在于的无参的构造方法就会被覆盖了，如果像继续使用无参构造方法，那么就必须手动添加回来!