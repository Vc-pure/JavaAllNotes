# 第一章 框架概述

### 1.软件开发常用结构

#### 	**1.1 三层架构**

```
1.什么是三层架构？
	在项目开发中遵循的一种开发模式，分为三层：
		a.界面层：用来接收客户端的输入，调用业务逻辑层进行功能处理，返回结果给客户端，之前学的Servlet就是界面层的功能
		b.业务逻辑层：用来进行整个项目的业务逻辑处理，向上给界面层提供处理结果，向下问数据访问层要数据
		c.数据访问层：专门用来进行数据库的增删改查操作，向上给业务逻辑层提供数据
		
	各层之间的调用顺序是固定的，不允许跨层访问
	界面层<---->业务逻辑层<----->数据访问层
2.生活中的三层架构 （如下图所示）
3.为什么要使用三层架构：
	a.结构清晰、耦合度低,  各层分工明确
	b.可维护性高，可扩展性高
	c.有利于标准化
	d.开发人员可以只关注整个结构中的其中某一层的功能实现
	e.有利于各层逻辑的复用
	
```

三层架构示意图：

![image-20220801223100867](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220801223100867.png)



#### 1.2 常用框架（SSM）

```
Spring:它是整合其他框架的框架。它的核心是IOC和AOP，它由20多个模块构成，在很多领域都提供了很好的解决方案。是一个大佬级别的存在.

SpringMVC:它是Spring家族的一员，专门用来优化控制器（相当于Serlvet）的。提供了极简单的数据提交、数据携带、页面跳转等功能.

MyBatis:是持久化层（就是数据访问层）的一个框架，用来进行数据库访问的优化，专注于sql语句，极大的简化了JDBC的访问.
```



### 2.什么是框架

​	它是一个半成品软件，将所有的公共的，重复的功能解决掉，帮助程序员快速高效的进行开发。它是可复用、可扩展的。



### 3.MyBatis框架概述

```
1.什么是MyBatis框架?
  MyBatis 本是 apache 的一个开源项目iBatis, 2010 年这个项目由 apache software foundation 迁移到了 google code，并且   改名为 MyBatis  。2013 年 11 月迁移到 Github,最新版本是 MyBatis 3.5.7 ，其发布时间是 2021 年 4月 7日。
  MyBatis完成数据访问层的优化.它专注于sql语句.简化了过去JDBC繁琐的访问机制. 

2.MyBatis框架解决的主要问题：
	MyBatis完成数据访问层的优化.它专注于sql语句.简化了过去JDBC繁琐的访问机制. 
	减轻使用 JDBC 的复杂性，不用编写重复的创建 Connetion , Statement ; 不用编写关闭资源代码。直接使用 java 对象，表示结果	 数据。让开发者专注 SQL的处理。其他分心的工作由 MyBatis 代劳。
```



#### 3.1 MyBatis框架的结果图以及解释

![image-20220801230139244](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220801230139244.png)

```
1、mybatis配置
SqlMapConfig.xml，此文件作为mybatis的全局配置文件，配置了mybatis的运行环境等信息。
mapper.xml文件即sql映射文件，文件中配置了操作数据库的sql语句。此文件需要在SqlMapConfig.xml中加载。
2、通过mybatis环境等配置信息构造SqlSessionFactory即会话工厂
3、由会话工厂创建sqlSession即会话，操作数据库需要通过sqlSession进行。
4、mybatis底层自定义了Executor执行器接口操作数据库，Executor接口有两个实现，一个是基本执行器、一个是缓存执行器。
5、Mapped Statement也是mybatis一个底层封装对象，它包装了mybatis配置信息及sql映射信息等。mapper.xml文件中一个sql对应一个Mapped Statement对象，sql的id即是Mapped statement的id。
6、Mapped Statement对sql执行输入参数进行定义，包括HashMap、基本类型、pojo，Executor通过Mapped Statement在执行sql前将输入的java对象映射至sql中，输入参数映射就是jdbc编程中对preparedStatement设置参数。
7、Mapped Statement对sql执行输出结果进行定义，包括HashMap、基本类型、pojo，Executor通过Mapped Statement在执行sql后将输出结果映射至java对象中，输出结果映射过程相当于jdbc编程中对结果的解析处理过程。
```





# 第二章 MyBatis框架快速入门



### 1.添加框架的步骤

```xml
1.添加依赖
2.添加配置文件
具体步骤(具体见项目：mybatis_001_student)：
	1.新建数据库新建表
	2.新建maven项目，选择quickstart模板
	3.修改目录，添加缺失的目录，修改目录属性
	4.修改pom.xml文件，添加MyBatis的依赖，添加mysql的依赖
            <!--添加mybatis框架的依赖-->
            <dependency>
              <groupId>org.mybatis</groupId>
              <artifactId>mybatis</artifactId>
              <version>3.5.6</version>
            </dependency>
            <!--添加mysql的依赖-->
            <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.32</version>
            </dependency>
	5.修改pom.xml文件，添加资源文件指定
            <!--添加资源文件的指定-->
            <build>
                <resources>

                    <resource>
                        <directory>src/main/java</directory>
                        <includes>
                            <include>**/*.xml</include>
                            <include>**/*.properties</include>
                        </includes>
                    </resource>

                    <resource>
                        <directory>src/main/resources</directory>
                        <includes>
                            <include>**/*.xml</include>
                            <include>**/*.properties</include>
                        </includes>
                    </resource>

                </resources>
            </build>

	6.在idea中添加数据库的可视化
	7.添加jdbc.properties属性文件（数据库的配置）
		jdbc.driverClassName=com.mysql.jdbc.Driver
        jdbc.url=jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf8
        jdbc.username=root
        jdbc.password=123456
	8.添加SqlMapConfig.xml文件，MyBatis的核心配置文件
            <?xml version="1.0" encoding="UTF-8" ?>
            <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
                                                    "http://mybatis.org/dtd/mybatis-3-config.dtd">
            <configuration>
                <!--读取属性文件(jdbc.properties)
                     属性：
                     resources：从resources目录下找指定名称的文件加载
                     url：使用绝对路径加载属性文件
                -->
                <properties resource="jdbc.properties"></properties>


                <!--设置日志输出底层执行的代码-->
                <settings>
                    <setting name="logImpl" value="STDOUT_LOGGING"/>
                </settings>



                <!--注册实体类的别名-->
                <typeAliases>
                    <!--单个实体类别名注册,type是实体类Student类的完整路径，alias是别名-->
                    <!-- <typeAlias type="com.bjpowernode.pojo.Student" alias="s"></typeAlias>-->

                    <!--
                         批量注册别名
                         别名是类名的驼峰命名法（规范）
                         比如实体类名是Student，那么别名就是student；实体类名是StudentAll，那么别名就是studentAll
                     -->
                    <package name="com.bjpowernode.pojo"></package>
                </typeAliases>



                <!--配置数据库的环境变量（数据库连接配置）
                            default：使用下面的environment标签的id属性进行指定配置
                 -->
                <environments default="development">
                    <!--开发时在公司使用的数据库配置
                               id：就是提供给environments的default属性使用
                    -->
                    <environment id="development">
                        <!--transactionManager:配置事务管理器
                               type：指定事务管理的方式
                               JDBC:事务的控制交给程序员处理
                               MANAGED：由容器（Spring）来管理事务
                         -->
                        <transactionManager type="JDBC"></transactionManager>
                        <!--配置数据源
                             type：指定不同的配置方式
                             JNDI：java命名目录接口，在服务器端进行数据库连接池的管理
                             POOLED:使用数据库连接池
                             UNPOOLED:不使用数据库连接池
                             -->
                        <dataSource type="POOLED">
                            <!--配置数据库连接的基本参数
                                 private String driver;
                                 private String url;
                                 private String username;
                                 private String password;
                             -->
                            <property name="driver" value="${jdbc.driverClassName}"></property>
                            <property name="url" value="${jdbc.url}"></property>
                            <property name="username" value="${jdbc.username}"></property>
                            <property name="password" value="${jdbc.password}"></property>
                        </dataSource>
                    </environment>

                    <!--        &lt;!&ndash;在家的数据库配置&ndash;&gt;-->
                    <!--        <environment id="home">-->
                    <!--            <transactionManager type=""></transactionManager>-->
                    <!--            <dataSource type=""></dataSource>-->
                    <!--        </environment>-->

                    <!--        &lt;!&ndash;上线后的数据库配置&ndash;&gt;-->
                    <!--        <environment id="online">-->
                    <!--            <transactionManager type=""></transactionManager>-->
                    <!--            <dataSource type=""></dataSource>-->
                    <!--        </environment>-->
                </environments>

                <!--注册mapper.xml文件
                    resource:从resources目录下找指定名称的文件注册
                    url：使用绝对路径注册
                    class：动态代理方式下的注册
                -->
                <mappers>
                    <!--单独注册mapper-->
                    <mapper resource="StudentMapper.xml"></mapper>
                    
                    <!--批量注册mapper-->
                    <package name="com.bjpowernode.mapper"></package>
                </mappers>
            </configuration>
	9.创建实体类Student，用来封装数据
	10.添加完成学生表的增删改查的功能的StudentMapper.xml文件
	11.创建测试类进行功能测试
		
```





 >StudentMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--
    mapper：是整个文件的大标签，用来开始和结束xml文件
    属性：
        namespace：指定命名空间（相当于包名），用来区分不同mapper.xml文件中相同的id属性
-->
<mapper namespace="zy">
    <!--
        完成查询全部学生的功能
        List<Student> getAll();
            resultType:指定查询返回的结果集的类型，如果是集合，则必须是泛型的类型 (有返回值就用它）
            只能写完整的路径：因为只有把全部的路径给我，我才能通过反射创建这个类型的对象
            parameterType:如果有参数，则通过它来指定参数的类型（有入参就用它）
    -->
    <select id="getAll" resultType="com.bjpowernode.pojo.Student">
        select id,name,email,age
        from student
    </select>

    <!--
        按主键id查询学生信息
        Student getById(Integer id);
        如果有入参，就用parameterType
    -->
    <select id="getById" parameterType="int" resultType="com.bjpowernode.pojo.Student">
        select id,name,email,age
        from student
        where id=#{id}
    </select>


    <!--
        按学生名称模糊查询
        List<Student> getByName(String name);
    -->
    <select id="getByName" parameterType="string" resultType="com.bjpowernode.pojo.Student">
        select id,name,email,age
        from student
        where name like '%${name}%'
    </select>

    <!--
        增加学生
        int insert(Student stu);

        实体类：
            private Integer id;
            private String name;
            private String email;
            private Integer age;
    -->
    <insert id="insert" parameterType="com.bjpowernode.pojo.Student">
        insert into student (name,email,age) values(#{name},#{email},#{age})

    </insert>

    <!--
        按主键删除学生
        int delete(Integer id)
    -->
    <delete id="delete" parameterType="int">
        delete from student where id=#{id}
    </delete>


    <!--
        更新学生
        int update(Student stu)
        #{} 大括号里面的要和实体类Student类里面的属性名相同
    -->
    <update id="update" parameterType="com.bjpowernode.pojo.Student">
        update student set name=#{name},email=#{email},age=#{age}  where id=#{id}
    </update>

</mapper>
```



>测试类MyTest.java

```java
public class MyTest {
    @Test
    public void testGetAll() throws IOException {
        //1.使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
        //3.取出sqlSession的对象
        SqlSession sqlSession=factory.openSession();
        //4.完成查询操作
        List<Student>  list = sqlSession.selectList("zy.getAll");
        list.forEach(student -> System.out.println(student));
        //5.关闭sqlSession
        sqlSession.close();

    }

    @Test
    public void testGetById() throws IOException {
        //读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象  //这里用的是建造者模式
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        //从工厂中取出SqlSession
        SqlSession sqlSession=factory.openSession();
        //按主键查学生
        Student stu = sqlSession.selectOne("zy.getById",1);
        System.out.println(stu);
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetByName() throws  IOException{
        //1.使用流读取核心配置文件
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
        //3.取出SqlSession
        SqlSession  sqlSession = factory.openSession();
        //4.调用方法，进行模糊查询
        List<Student> list=sqlSession.selectList("zy.getByName","张");
        list.forEach(student -> System.out.println(student));
        //5.关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
        //读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //取出SqlSession
        SqlSession sqlSession = factory.openSession();
        //调用方法，进行插入
        int num = sqlSession.insert("zy.insert",new Student("haha","haha@qq.com",23));
        //切记切记切记：在所有的增删改之后必须手工提交事务
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }


    @Test
    public void testDelete() throws  IOException{
        //输入流读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //取出SqlSession
        SqlSession sqlSession = factory.openSession();
        //调用方法，完成删除
        int num = sqlSession.delete("zy.delete",5);
        //切记切记：增删改要手动提交事务
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws  IOException{
        //输入流读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //取出sqlSession
        SqlSession sqlSession = factory.openSession();
        //完成更新
        int num = sqlSession.update("zy.update",new Student(3,"zy","zy.126.com",20));
        //切记切记切记：增删改的时候要手动提交事务
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }


}

但凡多重复，必可被提取
```





### 2.MyBatis对象分析

```java
1.Resources类
	就是解析SqlMapConfig.xml文件，创建出相应的对象
	InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
	
2.SqlSessionFactory接口
	使用ctrl+h快捷键查看本接口的子接口和实现类
	DefaultSqlSessionFactory是实现类
	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

3.SqlSession接口
    DefaultSqlSession实现类
```



### 3.测试类优化(MyTest.java)

```java
public class MyTest {
    SqlSession sqlSession;
    @Before  //在所有的@Test方法执行前先执行的代码
    public void openSqlSession() throws IOException{
        //使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
        //取出sqlSession的对象
        sqlSession=factory.openSession();
    }

    @After  //在所有的@Test方法执行后再执行的代码
    public void closeSqlSession() {
        //关闭sqlSession
        sqlSession.close();
    }


    @Test
    public void testGetAll() throws IOException {
        //完成查询操作
        List<Student>  list = sqlSession.selectList("zy.getAll");
        list.forEach(student -> System.out.println(student));

    }

    @Test
    public void testGetById() throws IOException {
        //按主键查学生
        Student stu = sqlSession.selectOne("zy.getById",1);
    }

    @Test
    public void testGetByName() throws  IOException{
        //4.调用方法，进行模糊查询
        List<Student> list=sqlSession.selectList("zy.getByName","张");
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void testInsert() throws IOException {
        //调用方法，进行插入
        int num = sqlSession.insert("zy.insert",new Student("haha","haha@qq.com",23));
        //切记切记切记：在所有的增删改之后必须手工提交事务
        sqlSession.commit();
    }


    @Test
    public void testDelete() throws  IOException{
        //调用方法，完成删除
        int num = sqlSession.delete("zy.delete",5);
        //切记切记：增删改要手动提交事务
        sqlSession.commit();
    }

    @Test
    public void testUpdate() throws  IOException{
        //完成更新
        int num = sqlSession.update("zy.update",new Student(3,"zy","zy.126.com",20));
        //切记切记切记：增删改的时候要手动提交事务
        sqlSession.commit();
    }


}
```



### 4.为实体类注册别名

```xml
a.单个注册
    <typeAliases>
        <!--单个实体类别名注册,type是实体类Student类的完整路径，alias是别名-->
        <typeAlias type="com.bjpowernode.pojo.Student" alias="s"></typeAlias>
    </typeAliases>


b.批量注册
    <typeAliases>
        <!--
            批量注册别名
            别名默认是类名的驼峰命名法（规范）
            比如实体类名是Student，那么别名就是student；实体类名是StudentAll，那么别名就是studentAll
        -->
        <package name="com.bjpowernode.pojo"></package>
    </typeAliases>
```



### 5.设置日志输出

```xml
    <!--设置日志输出底层执行的代码-->
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
```







# 第三章 动态代理

### 1.动态代理存在的意义

![image-20220802183631081](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220802183631081.png)



**动态代理存在的意义**

```
在三层架构中，业务逻辑层要通过接口访问数据访问层的功能，动态代理可以实现。
```



### 2.动态代理的实现规范

```
1.UsersMapper.xml文件与UsersMapper.java的接口文件必须同一个目录下。
2.UsersMapper.xml文件与UsersMapper.java的接口文件的文件名必须一致，后缀不管。
3.UsersMapper.xml文件中标签的id值与UsersMapper.java的接口文件中的方法的名称完全一致。
4.UsersMapper.xml文件中标签的parameterType的属性值与UsersMapper.java的接口文件中的方法的参数类型完全一致。
5.UsersMapper.xml文件中标签的resultType的属性值与UsersMapper.java的接口文件中的方法的返回值类型完全一致
6.UsersMapper.xml文件中namespace属性必须是接口的完全限定名称（意思就是必须是com.bjpowernode.mapper.UsersMapper)
7.在SqlMapConfig.xml文件中注册mapper文件时，使用class=接口的完全限定名称（com.bjpowernode.mapper.UsersMapper）
```

### 3.动态代理访问的步骤

```
1.建表Users
2.新建maven工程，刷新可视化
3.修改目录
4.修改pom.xml文件，添加依赖
5.添加jdbc.properties文件到resources目录下
6.添加SqlMapConfig.xml文件
7.添加实体类
8.添加mapper文件夹，新建UsersMapper接口文件
9.在mapper文件夹下，新建UsersMapper.xml文件，完成增删改查功能
10.添加测试类，测试功能
```

### 4.优化mapper.xml文件的注册

```xml
   <!--注册mapper.xml文件-->
    <mappers>
        <!--绝对路径注册-->
        <mapper url="/////"></mapper>
        <!--非动态代理方式下的注册-->
        <mapper resource="StudentMapper.xml"></mapper>
        <!--动态代理方式下的单个mapper.xml文件注册-->
        <mapper class="com.bjpowernode.mapper.UsersMapper"></mapper>
        <!--批量注册-->
        <package name="com.bjpowernode.mapper"></package>
    </mappers> 
```



### 5.#{} 和 ${} 

```xml
1. #{}相当于占位符
	传参大部分使用#{}传参，它的底层是使用PreparedStatement对象，是安全的数据库访问，防止SQL注入
	#{}里如何写，看parameterType参数的类型
	a.如果parameterType的类型是简单类型（8种基本（加上8种封装） + String），则#{}里随便写。
	    <select id="getById" parameterType="int" resultType="users"> <!--入参类型是简单类型-->
            select id,userName,birthday,sex,address
            from users
            where id=#{fagadgdhadgadxgad} <!--这里{}里写什么都可以-->
        </select>
	b.parameterType的类型是实体类的类型，则#{}里只能是类中成员变量的名称，而且区别大小写。
		<insert id="insert" parameterType="users">   <!--入参类型是实体类-->
        insert into users (id,username,birthday,sex,address)
        values(#{id},#{userName},#{birthday},#{sex},#{address})  <!--这里{}里面只能写实体类里的成员变量名称-->
    	</insert>

2. ${}字符串拼接或字符串替换
	a.字符串拼接，一般用于模糊查询中，建议少用，因为有SQL注入的风险。
	  也分两种情况，同样看parameterType的类型。
		a1.如果parameterType的类型是简单类型，则${}里随便写，但是分版本，如果是3.5.1及以下的mybatis版本，只能写value。
            <select id="getByName" parameterType="string" resultType="users">  <!--入参类型是简单类型-->
                select id,username,birthday,sex,address
                from users
                where userName like '%${dfagagadga}%' <!--这里{}里写什么都可以-->
            </select>
		a2.如果parameterType的类型是实体类的类型，则${}里只能说类中成员变量的名称。（现在已经很少用了）

		a3.优化后的模糊查询（以后都要使用的方式）
            <select id="getByNameBetter" parameterType="string" resultType="users">
                select  id,username,birthday,sex,address
                from users
                where username like concat('%',#{suibianxie},'%')
            </select>

	b.字符串替换
	需求：模糊地址或用户名查询
	select * from users where username like '%小%';
	select * from users where address  like '%市%';
	    <!--
        //模糊用户名和地址查询
        //如果参数超过一个，则parameterType不写
            List<Users> getByNameOrAddress(
            @Param("columnName")
            String columnName,
            @Param("columnValue")
            String columnValue);
    	-->
        <select id="getByNameOrAddress" resultType="users">
            select id,username,birthday,sex,address
            from users
            where ${columnName} like concat('%',#{columnValue},'%')
        </select>			
```



### 6.返回主键标签

```xml
返回主键值
 在插入语句结束后，返回自增的主键值到入参的users对象的id属性中
   <insert id="insert" parameterType="users">
        <selectKey keyProperty="id" resultType="int" order="AFTER">
            select last_insert_id()
        </selectKey>
        insert into users (id,username,birthday,sex,address)
        values(#{id},#{userName},#{birthday},#{sex},#{address})
   </insert>
	<selectKey>标签的参数详解：</selectKey>
		keyProperty：users对象的哪个属性来接返回的主键值
		resultType：返回的主键的类型
		order：在插入语句执行前还是执行后返回主键的值
```

  

### 7.UUID

​	这是一个全球唯一字符串，由36个字母数字中划线组成。

```
UUID uuid = UUID.randomUUID();
System.out.println(uuid.toString().replace("-","").substring(20));
```

比如淘宝订单 每一个订单号都是一个主键，每一个订单号都是不同的。这里就用的是UUID。







# 第四章 动态sql（※）

### 1.什么是动态sql

```
可以定义代码片段，可以进行逻辑判断，可以进行循环处理（批量处理），使条件判断更为简单。
```



### 2. 动态sql 的标签及其用法

```xml
	1.<sql>	：用来定义代码片段，可以将所有的列名，或复杂的条件定义为代码片段，供使用时调用
	2.<include> ：用来引用<sql>定义的代码片段
        <!--定义代码片段-->
        <sql id="allColumns">
            id,username,birthday,sex,address
        </sql>
        
        //引用定义好的代码片段
        <select id="getAll" resultType="users" >
            select <include refid="allColumns"></include>
            from users
        </select>
        
    3.<if>：进行条件判断
    4.<where>：进行多条件拼接，在查询、删除、更新中使用
        <select id="getByCondition" parameterType="users" resultType="users">
            select <include refid="allColumns"></include>
            from users
            <where>
                <if test="userName != null and userName != '' ">
                    and username like concat('%',#{userName},'%')
                </if>
                <if test="birthday != null">
                    and birthday=#{birthday}
                </if>
                <if test="sex != null and sex != '' ">
                    and sex=#{sex}
                </if>
                <if test="address != null and address != '' ">
                    and address like  concat('%',#{address},'%')
                </if>
            </where>
        </select>
        
        
    5.<set>：有选择的进行更新处理，但至少更新一列。 
            <update id="updateBySet" parameterType="users">
                update users
                <set>
                    <if test="userName != null and userName!= '' ">
                        username=#{userName},
                    </if>
                    <if test="birthday != null">
                        birthday=#{birthday},
                    </if>
                    <if test="sex != null and sex!= null">
                        sex=#{sex},
                    </if>
                    <if test="address != null and address != '' ">
                        address=#{address},
                    </if>
                </set>
                where id=#{id}
            </update>
        
    6.<foreach>：用来进行循环遍历，完成循环条件查询，批量删除（最常用），批次增加（偶尔用），批量更新（最少用）。
        
        <foreach>的标签详解：
         	collection：用来指定入参的类型，如果是List集合则为list，如果是Map集合则为map，如果是数组则为array。
         	item：每次循环遍历出来的值或对象
         	separator：多个值或者对象或语句之间的分隔符
         	open：整个循环外边的前括号
         	close：整个循环外边的后括号
            
        6.1 查询实现：
             <select id="getByIds" resultType="users">
                select<include refid="allColumns"></include>
                from users
                where id in
                    <foreach collection="array" item="id" separator="," open="(" close=")">
                        #{id}
                    </foreach>
            </select>
         
        6.2 批量删除
             <delete id="deleteBatch" >
                delete from users
                where id in
                    <foreach collection="array" item="id" separator="," open="(" close=")">
                        #{id}
                    </foreach>
            </delete>
         
       6.3 批量增加（学有余力）
            <!--    批量增加-->
            <insert id="insertBatch" >
                insert into users(username,birthday,sex,address) values
                <foreach collection="list" separator="," item="u">
                    (#{u.userName},#{u.birthday},#{u.sex},#{u.address})
                </foreach>
            </insert>
      6.4 批量更新（学有余力）
            <!--    有选择的批量更新,至少更新一列-->
            <update id="updateSet"  >
                <foreach collection="list" item="u" separator=";">
                    update users
                    <set>
                        <if test="u.userName != null  and u.userName != ''">
                            username=#{u.userName},
                        </if>
                        <if test="u.birthday != null">
                            birthday = #{u.birthday},
                        </if>
                        <if test="u.sex != null  and u.sex != ''">
                            sex = #{u.sex},
                        </if>
                        <if test="u.address != null  and u.address != ''">
                            address = #{u.address}
                        </if>
                    </set>
                    where id = #{u.id}
                </foreach>
            </update>
            注意:要使用批量更新，必须在jdbc.properties属性文件中的url中添加&allowMultiQueries=true，允许多行操作。
         
```



### 3.指定参数位置

​		如果入参是多个，可以通过指定参数位置进行传参。是实体类包含不住的条件。实体类只能封装住成员变量的条件，如果某个成员变量要有区间范围内的判断，或者有两个值进行处理，则实体类包不住。

​		例如：查询指定日期范围内的用户信息。

```xml
<!--
  	//查询指定日期范围内的用户
	List<Users> getByBirthday(Date begin, Date end);
-->
    <select id="getByBirthday" resultType="users">
        select <include refid="allColumns"></include>
        from users
        where birthday between #{arg0} and #{arg1}
    </select>   
```

### 4.@Param指定参数名称

```java
UsersMapper.java接口中：

//切换列名进行模糊查询
//@Param("columnName"):这里定义的columnName的名称是要在xml文件中的${引用定义的名称}
List<Users> getByColunm(@Param("columnName") String columnName,
                     @Param("columnValue") String columnValue);
```



```xml
UsersMapper.xml文件中：

<select id="getByColumn" resultType="users">
    select <include refid="columns"></include>
    from users
    where ${columnName} =#{columnValue}
</select>
```

<select id="getByColunm" resultType="users">
  select <include refid="columns"></include>
  from users
  where ${columnName} =#{columnValue}
</select>

### 5.入参是map（重点掌握）

​	如果入参超过一个以上，使用map封装查询条件，更有语义，查询条件更明确。

```xml
<!--
    //入参是map
    List<Users> getByMap(Map map);
    #{birthdayBegin}: 就是map中的key
-->
    <select id="getByMap" resultType="users">
        select<include refid="allColumns"></include>
        from users
        where birthday between #{birthdayBegin} and #{birthdayEnd}
    </select>
```



### 6.返回值是map

返回多个值（因为每个值都来自不同的表，没有一个实体类能全部包住这些来自不同表的数据，所以返回值用map）

![image-20220803193000590](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220803193000590.png)

如果返回的数据实体类无法包含，可以使用map返回多张表中的若干数据。返回后这些数据之间没有任何关系，就是一些散的Object类型

返回的map的key就是列名或别名



#### 6.1 map封装的返回值是一行

```xml
<!--    //返回值是map(一行）
    Map getReturnMap(Integer id);
-->
    <select id="getReturnMap" parameterType="int" resultType="map">
        select username name,address a
        from users
        where id=#{id}
    </select>
```

#### 6.2 map封装的返回值是多行

```xml
<!--
    //返回多行的map
    List<Map> getMulMap();
-->
    <select id="getMulMap" resultType="map">
        select username name,address ad
        from users
    </select>
```







### 7.列名与类中成员变量名称不一致

```xml
<!--
    //查询全部图书
    List<Book> getAll();
    实体类中：
        private Integer id;
        private String name;
-->

 <!-- 解决方案一：
   		加入别名
 -->
    <select id="getAll" resultType="book">
        select bookid id,bookname name
        from book
    </select>





<!--解决方案二：
    使用resultMap手工完成映射
    property表示实体类中属性的名字
    column表示数据库表中列的名字
-->
<resultMap id="bookmap" type="book">
    <!--主键绑定-->
    <id property="id" column="bookid"></id>
    <!--非主键绑定-->
    <id property="name" column="bookname"></id>
</resultMap>
<select id="getAll" resultMap="bookmap">
    select bookid,bookname
    from book
</select>
```







# 第五章 表之间的关联关系

```
关联关系是有方向的。
1.一对多关联：
    一个老师可以教多个学生，多个学生只有一个老师来教
    站在老师方，就是一对多关联

2.多对一关联：
	一个老师可以教多个学生，多个学生只有一个老师来教
	站在学生方，就是多对一关联
	
3.一对一关联
	一个老师辅导一个学生，一个学生只请教一个老师。
	学生和老师是一对一

4.多对多关联
	园区划线的车位和园区的每一辆车。任意一个车位可以停任意一辆车，任意一辆车可以停在任意一个车位上
	车位和车就是多对多
```



### 1.一对多关联

```xml
客户和订单就是典型的一对多关联关系
一个客户名下可以有多个订单
客户表是一方，订单表是多方。客户表一方持有订单的集合

使用一对多的关联关系，可以满足查询客户的同时查询该客户名下的所有订单。

<mapper namespace="com.bjpowernode.mapper.CustomerMapper">
<!--
    //根据客户的主键id查询客户所有信息并同时查询该客户名下的所有订单
    Customer getById(Integer id);

    实体类：
    //customer表中的三个列
    private Integer id;
    private String name;
    private Integer age;

    //该客户名下所有订单的集合
    private List<Orders> ordersList;
-->
    <resultMap id="customermap" type="customer">
        <!--主键绑定
            这里起了别名之后，数据库的列名就成了别名，所以column要用别名cid
        -->
        <id property="id" column="cid"></id>
        <!--非主键绑定-->
        <result property="name" column="name"></result>
        <result property="age" column="age"></result>
        <!--多出来的一咕噜绑定:ordersList
           Orders的实体类：
            private Integer id;
            private String orderNumber;
            private Double orderPrice;
        -->
        <collection property="ordersList" ofType="orders">
            <!--主键绑定
            这里起了别名之后，数据库的列名就成了别名，所以column要用别名oid
            -->
            <id property="id" column="oid"></id>
            <!--非主键绑定-->
            <result property="orderNumber" column="orderNumber"></result>
            <result property="orderPrice" column="orderPrice"></result>
        </collection>
    </resultMap>

    <select id="getById" parameterType="int" resultMap="customermap">
        select c.id cid,name,age,o.id oid,orderNumber,orderPrice,customer_id
        from customer c left join orders o    //这里如果用inner join则无法查询出没有对应订单信息的客户信息
        on c.id=o.customer_id
        where c.id=#{id}
    </select>
```





### 2.多对一关联

```xml
订单和客户就是多对一关联
站在订单的方向查询订单的同时将客户信息查出
订单是多方，会持有一方的对象。客户是一方。


<mapper namespace="com.bjpowernode.mapper.OrdersMapper">
<!--
    //根据主键查订单并同时查询下此订单的客户信息
    Orders getById(Integer id);
    实体类：
    private Integer id;
    private String orderNumber;
    private Double orderPrice;
    //关联下此订单的客户信息，多方持有一方的对象
    private Customer customer;
-->
    <resultMap id="ordersmap" type="orders">
        <!--主键绑定-->
        <id property="id" column="oid"></id>
        <!--非主键绑定-->
        <result property="orderNumber" column="orderNumber"></result>
        <result property="orderPrice" column="orderPrice"></result>
        <!--
            customer绑定
            property指代的是当前类中成员变量的名称
            javaType指代的是这个成员变量的类型
            实体类：
                private Integer id;
                private String name;
                private Integer age;
             association和collection两个标签是可以互相嵌套的
        -->
        <association property="customer" javaType="customer">
            <!--主键绑定-->
            <id property="id" column="cid"></id>
            <!--非主键绑定-->
            <result property="name" column="name"></result>
            <result property="age" column="age"></result>
        </association>
    </resultMap>

    <select id="getById" parameterType="int" resultMap="ordersmap">
        select o.id oid,orderNumber,orderPrice,customer_id,c.id cid,name,age
        from orders o inner join customer c
        on o.customer_id = c.id
        where o.id=#{id}
    </select>

注意：当数据库的某一个列起了别名，那么绑定处的对应名称也要改成别名，不然该值会返回null
```



### 3.一对一关联

![image-20220804080600195](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220804080600195.png)



### 4.多对多关联

![image-20220804082803933](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220804082803933.png)

![image-20220804082821749](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220804082821749.png)





**总结：无论是什么关联关系，如果某方持有另一方的集合，则使用<collection>标签完成映射；如果某方持有另一方的对象，则使用<association>标签完成映射。**







# 第六章 事务

```
a.多个操作同时完成，或同时失败称为事务处理

b.事务有四个特性：一致性，持久性，原子性，隔离性。
	下订单的业务：
		1.订单表中完成增加一条记录的操作
		2.订单明细表中完成N条记录的增加
		3.商品数据更新（减少）
		4.购物车中已支付商品删除
		5.用户积分更新（增加）
		
		
c.在MyBatis框架中设置事务：	
	<transactionManager type="JDBC"></transaction>   ===>type="JDBC"表示程序员自己控制事务的提交和回滚

	可设置为为自动提交：
	sqlSession = factory.openSession();  
							===>默认是手工提交事务，设置为false也是手工提交事务，如果设置为true，则为自动提交
	sqlSession = factory.openSession(true); 
							===>设置为自动提交事务，在增删改之后不需要写sqlSession.commit(); 
```





# 第七章 缓存

```
缓存机制基本上就是用来应付面试，自己基本很少用，很少去设置二级缓存，Mybatis框架默认就是一级缓存
```



```
1.MyBtis框架提供两级缓存，一级缓存和二级缓存。默认开启一级缓存

2.缓存就是为了提高查询效率

3.使用缓存后，查询的流程：
		查询时先到缓存里查，如果没有则查询数据库，放缓存一份，再返回客户端。下次再查询的时候直接从缓存返回，不再访问数据库。
		如果数据库中发生commit()操作，则清空缓存。
4.缓存的作用域：
	a.一级缓存使用的是SqlSession的作用域，同一个sqlSession共享一级缓存的数据
	b.二级缓存使用的是mapper的作用域，不同的sqlSession只要访问的是同一个mapper.xml文件，则共享二级缓存作用域。

```

**缓存执行的流程**：  

![image-20220804092558061](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220804092558061.png)







# 第八章 ORM

```
什么是ORM？
ORM（Object Relational Mapping） ： 对象关系映射

MyBatis框架是ORM非常优秀的框架。
java语言中以对象的方式操作数据，存到数据库中是以表的方式进行存储，对象中的成员变量与表中的列之间的数据互换称为映射。整个这套操作就是ORM。

持久化的操作：将对象保存到关系型数据库中，将关系型数据库中的数据读取出来以对象的形式封装。
MyBatis是持久化层优秀的框架。


```











MyBatis框架总结如下pdf（标红的为重点）

 [MyBatis.pdf](06_笔记\MyBatis.pdf) 







