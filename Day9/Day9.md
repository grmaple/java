## Day9

​                                                       员工管理系统

请输入工号：

请输入密码：

登陆成功，欢迎研发部经理张三！

​                                                       1.添加新员工

​                                                       2.删除离职员工

​                                                       3.修改员工信息

​                                                       4.查询员工信息

​                                                       5.修改密码

​                                                       6.退出

请选择：1

请输入员工姓名：

请输入员工性别：

请输入员工籍贯：

请输入员工电话：

请输入员工入职日期：

请输入员工薪资：

请选择员工岗位：

1.开发工程师

2.UI设计师

3.测试工程师

请选择：1

添加成功！请问要继续吗？y

​                                                       1.添加新员工

​                                                       2.删除离职员工

​                                                       3.修改员工信息

​                                                       4.查询员工信息

​                                                       5.修改密码

​                                                       6.退出

请选择：2

请输入要删除的离职员工工号：

该工号不存在，请重新输入！

删除成功，请问要继续吗?y

​                                                       1.添加新员工

​                                                       2.删除离职员工

​                                                       3.修改员工信息

​                                                       4.查询员工信息

​                                                       5.修改密码

​                                                       6.退出

请选择：3

请输入要修改的员工工号：

该工号不存在，请重新输入！（工号不能修改其余皆可）

修改成功，请问要继续吗?y

​                                                       1.添加新员工

​                                                       2.删除离职员工

​                                                       3.修改员工信息

​                                                       4.查询员工信息

​                                                       5.修改密码

​                                                       6.退出

请选择：4

方式1：通过部门查询(可以看其他部门员工信息，但是只能看本部门员工的工资)

方式2：通过职位查询

请问要继续吗?y

​                                                       1.添加新员工

​                                                       2.删除离职员工

​                                                       3.修改员工信息

​                                                       4.查询员工信息

​                                                       5.修改密码

​                                                       6.退出

请选择：5

（只能修改自己的密码）

修改成功，请问要继续吗?y

​                                                       1.添加新员工

​                                                       2.删除离职员工

​                                                       3.修改员工信息

​                                                       4.查询员工信息

​                                                       5.修改密码

​                                                       6.退出

请选择：6

​                                                       员工管理系统

请输入工号：

请输入密码：

登陆成功，欢迎研发部UI工程师李四！

​                                                       1.查询个人信息

​                                                       2.修改个人密码

​                                                       3.退出



- 本部门经理只能添加本部门的员工
- 本部门只能删除本部门离职员工
- 本部门经理可以查看本部门员工的所有信息，包括工资，可以查看其他部门员工信息，但是看不到工资
- 本部门经理可以修改员工除工号外所有信息
- 经理只能修改自己的密码



### 一、建数据库

数据库OA

数据表：

dep部门信息表

- 部门编号，did，int
- 部门名称，dname，string

pos职位信息表，每个职位都有隶属的部门

- 职位编号，pid，int

- 职位名称，pname，string
- 部门，pdep，int外键

emp员工信息表，员工都有自己的职位

- 工号，id，int

- 姓名，name，string

- 性别，sex，string
- 籍贯，address，string
- 电话，phone，string
- 入职日期，data，string
- 薪资，wage，int
- 岗位，epos，int外键

emplog员工登录信息表，员工用工号和密码登录

- 工号，id，int，外键
- 密码，pwd，string

### 二、java编程

使用面向对象的思想，采用Dao模式开发

1.根据表建立实体类，特点是表名即类名，列名即属性名。

创建bean.Dep实体类

创建bean.EmpLog实体类

创建bean.Emp实体类

创建bean.Pos实体类

2.新建数据库的连接以及关闭类DaseDao

3.设计接口

创建dao.DepDao接口类

```java
package dao;
import java.util.List;
import bean.Dep;
public interface DepDao{
    //接口是一种特殊的类interface，只能拥有抽象方法的类，抽象方法是指没有方法体的方法,即没有实现的方法。
    //List是集合，是一种特殊的数组，普通数组是有类型和长度限制的，集合是没有长度没有类型约束的数组。
    //List<Dep>是泛型集合，是一种有类型约束的集合。
    public List<Dep> findAllDep();//查询所有的部门信息
    public Dep findDepById(int id);//查询具体编号的部门信息
}
```

接口用于设计，设计项目中需要实现的功能，根据需求分析中功能依赖于那张表，我们就在这个类对应的接口设计该方法

我们根据实体类设计接口。实体类Dep设计的对应接口是DepDao，DepDao中设计的都是和表dep相关的增删改查操作。

因此

创建dao.EmpLogDao接口类

```java
package dao;
import bean.Emp;
public interface EmpLogDao{
    public boolean login(int logid,String logpwd);//登录，登录成功说明logid是正确的，即该工号是存在的
}
```

创建dao.EmpDao接口类

```java
package dao;
import java.util.List;
import bean.EmpLog;
public interface EmpDao{
    public Emp findEmpById(int id);//登录成功，工号正确的，通过工号把该员工查询出来
}
```

创建dao.PosDao接口类

```java
package dao;
import bean.Pos;
public interface PosDao{
   
}
```

为什么根据表设计类对象？因为类和表是对应的，因此类对象可以存储表中数据。



建立dao.impl.DepDaoImpl实现类

```java
package dao.impl;
import java.util.List;
import bean.Dep;
public class DepDaoImpl implements DepDao{
    //类实现某个接口，那么这个类必须实现这个接口的所有方法
    Scanner input = new Scanner(System.in);
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    @Override
    public List<Dep> findAllDep(){
        Lisp<Dep> list = new ArrayList<Dep>();
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from dep";
            try{
                pstmt=conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while(rs.next()) {
               		Dep dep = new Dep();
                    dep.setDid(rs.getInt(1));
                    dep.setDname(rs.getString(2));
                    list.add(dep);
                    
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
    }
    @Override
    public Dep findDepById(int id){
        Dep dep = null;
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from dep where id = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
               		dep = new Dep();
                    dep.setDid(rs.getInt(1));
                    dep.setDname(rs.getString(2));
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

