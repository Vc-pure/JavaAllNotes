# 第一章 Spring概述

### 1.什么是Spring框架

```
它是一个容器。它是整合其他框架的框架。它的核心是IOC和AOP。它由20多个模块构成。它在很多领域都提供优秀的解决方案。

Spring  的主要作用就是为代码“解耦”，降低代码间的耦合度。就是让对象和对象（模块和模块）之间关系不是使用代码关联，而是通过配置来说明。即在 Spring 中说明对象（模块）的关系。
Spring 根据代码的功能特点，使用 Ioc 降低业务对象之间耦合度。IoC 使得主业务在相互调用过程中，不用再自己维护关系了，即不用再自己创建要使用的对象了。而是由 Spring 容器统一管理，自动“注入”,注入即赋值。 而 AOP 使得系统级服务得到了最大复用，且不用再由程序员手工将系统级服务“混杂”到主业务逻辑中了，而是由 Spring 容器统一完成“织入”。

我们课程里学Spring框架：Spring、SpringMVC、 SpringBoot、SpringCloud

```

### 2.Spring官网

```
官网：https://spring.io/。
    Spring官网有Spring家族技术的介绍,有相应框架的jar 包和文档,还有源码文件,必要的时候可以参考。
```

### 3.Spring的特点

```
1.轻量级
	由20多个模块构成，每个jar包都很小，小于1M，核心包也就3M左右，对代码无污染
2.面向接口编程
	使用接口，就是面向灵活，项目的可扩展性、可维护性都极高。
	接口不关心实现类的类型，使用时接口指向实现类，切换实现类即可切换整个功能。
3.面向切面编程
	将公共的、通用的、重复的代码单独开发，在需要的时候反织回去。底层的原理是动态代理。
4.整合其他框架
	它整合后使其他框架更易用。
```



### 4.Spring体系结构

![image-20220804130138117](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220804130138117.png)







# 第二章 IOC控制反转

### 1.什么是IOC

```
什么是IOC？
	控制反转IOC(Inversion of Control)是一个概念，是一种思想。由Spring容器进行对象的创建和依赖注入。
	程序员在使用时直接取出使用。
	
正转：由程序员进行对象的创建和依赖注入称为正转。程序员说了算。
	 Student stu = new Student();   ===>程序员创建对象
	 stu.setName("张三"); 		   ===>程序员进行赋值
	 stu.setAge(22);
反转：由Spring容器创建对象和依赖注入，将控制权从程序员手中夺走，交给Spring容器，称为反转。容器说了算。 
    <bean id="stu" class="com.bjpowernode.pojo.Student">  	===>Spring容器负责对象的创建
        <property name="name" value="张三">				   ===>Spring容器依赖注入值
        <property name="age" value="22">					===>Spring容器依赖注入值
    </bean>   
```



### 2.基于xml的IOC

```xml
1.创建对象
  <bean id="stu" class="com.bjpowernode.pojo.Student"></bean>
2.给创建的对象赋值
  A.使用setter注入法	(例子：spring_003_sancengxml)
  	注入分为简单类型注入和引用类型注入
  	简单类型注入值使用value属性
  	引用类型注入值使用ref属性
  	必须要注意：使用setter注入必须提供无参的构造方法，必须提供setXxx()方法。
  	
  	<!--创建学生对象-->
	<bean id="student" class="com.bjpowernode.pojo2.Student">
        <property name="name" value="李四"></property>
        <property name="age" value="22"></property>
        <property name="school" ref="school"></property>
	</bean>
	<!--创建学校对象-->
	<bean id="school" class="com.bjpowernode.pojo2.School">
        <property name="name" value="清华大学"></property>
        <property name="address" value="海淀区"> </property>
	</bean>
  
  B.使用构造方法注入
	a.使用构造方法的参数名称进行注入值
            <!--
                创建学校的对象，并注入值
                这里<constructor-arg>的name属性的内容是构造方法的参数名称，不是实体类方法的成员变量名称
            -->
            <bean id="school" class="com.bjpowernode.pojo3.School">
                <constructor-arg name="name" value="清华大学"></constructor-arg>
                <constructor-arg name="address" value="海淀区"></constructor-arg>
            </bean>

	b.使用构造方法参数的下标注入值
            <!--创建学校的对象-->
            <bean id="school" class="com.bjpowernode.pojo3.School">
                <constructor-arg name="name" value="清华大学"></constructor-arg>
                <constructor-arg name="address" value="海淀区"></constructor-arg>
            </bean>
            <!--创建学生的对象，使用构造方法的参数的下标注入值-->
            <bean id="student" class="com.bjpowernode.pojo3.Student">
                <constructor-arg index="0" value="钱七"></constructor-arg>
                <constructor-arg index="1" value="60"></constructor-arg>
                <constructor-arg index="2" ref="school"></constructor-arg>
            </bean>

	c.使用默认的构造方法的参数的顺序注入值
            <!--创建学校的对象-->
            <bean id="school" class="com.bjpowernode.pojo3.School">
                <constructor-arg name="name" value="清华大学"></constructor-arg>
                <constructor-arg name="address" value="海淀区"></constructor-arg>
            </bean>
            <!--创建学生对象，使用默认的构造方法的参数的顺序-->
            <bean id="stuSequence" class="com.bjpowernode.pojo3.Student">
                <constructor-arg value="陈十"></constructor-arg>
                <constructor-arg value="50"></constructor-arg>
                <constructor-arg ref="school"></constructor-arg>
            </bean>
		

3.项目案例：
  使用三层架构进行用户的插入操作。
  界面层 业务逻辑层 数据访问层 （模拟）

  Spring会接管三层架构中哪些对象的创建？	
	除了实体类，三层架构的全部对象都交给Spring去控制
  
  非Spring接管下的三层项目构建：
	实体类
	com.bjpowernode.pojo Users
	数据访问层
	com.bjpowernode.dao  UsersMapper.java(接口)
						 UsersMapperImpl.java(实现类)
	业务逻辑层
	com.bjpowernode.service  UsersService.java(接口)
							 UsersServiceImpl.java(实现类)
	界面层
	com.bjpowernode.controller  UsersController.java
```





### 3.基于注解的IOC

```java
也称为DI（Dependency Injection），它是IOC的具体实现的技术。但是也换汤不换药

基于注解的IOC，必须要在Spring的核心配置文件中添加包扫描。
    <!--添加包扫描-->
    <context:component-scan base-package="com.bjpowernode.s01"></context:component-scan>

药：创建对象并依赖注入 	
汤： 之前是xml       现在换成注解annotation
1.创建对象的注解
  @Component:可以创建任意对象。
			 创建的对象默认是类名的驼峰命名法（比如Student类的对象就默认是student）
			 也可以指定对象的名称@Component("指定名称") 
		案例：
        @Component("zy")  //交给Spring去创建对象，就是在容器启动时创建
        public class Student {
            private String name;
            private int age; 
			...

  @Controller:专门用来创建控制器的对象（界面层的对象，类似于Servlet），这种对象可以接收用户的请求，可以返回处理结果给客户端

  @Service:专门用来创建业务逻辑层的对象，负责向下访问数据访问层，处理完毕后的结果返回给界面层

  @Repository:专门用来创建数据访问层的对象，负责数据库中的增删改查的所有操作。
  
2.依赖注入的注解
  A.简单类型(8种基本类型+String)的注入
  @Value：用来给简单类型注入值
		案例：
            public class Student {
                @Value("张三")
                private String name;
                @Value("20")
                private int age;
  
  B.引用类型的注入
      a.@Autowired：
           使用类型注入值，从整个Bean工厂中搜索同源类型的对象，进行注入
      	    同源类型才可注入。
           	什么是同源类型？
      		  a.被注入的类型（Student中的school）与注入的类型是完全相同的类型。
      			案例：
                  //引用类型按类型注入
                  @Autowired
                  private School school;	
     
      		  b.被注入的类型（Student中的school父）与注入的类型（子）是父子类。
      		  c.被注入的类型（Student中的school接口）与注入的类型（实现类）是接口和实现类的类型
                  
    注意：在有父子类的情况下，使用按类型注入，就意味着有多个可注入的对象。此时按照名称进行二次筛选，选中与被注入对象相同名称的对象进行注入。

      b.@Autowired + @Qualifier("名称")： 
      	   使用名称注入值，从整个Bean工厂中搜索相同名称的对象，进行注入 
                 案例：
                  //引用类型按名称注入
                  @Autowired
                  @Qualifier("schoolNew")
                  private School school;	
        
       注意：如果有父子类的情况下，直接按名称进行注入值。  
  
      	   
```



### 4.添加包扫描的方式

```xml
1.单个包扫描（推荐使用）
  <context:component-scan base-package="com.bjpowernode.controller"></context:component-scan>
  <context:component-scan base-package="com.bjpowernode.service.impl"></context:component-scan>
  <context:component-scan base-package="com.bjpowernode.dao"></context:component-scan>
2.多个包扫描，多个包之间以逗号或者空格或者分号分隔
  <context:component-scan base-package="com.bjpowernode.controller com.bjpowernode.service.impl ,com.bjpowernode.dao"></context:component-scan>
3.扫描根包（不推荐）
  <context:component-scan base-package="com.bjpowernode"></context:component-scan>
     会降低容器启动的速度,导致多做无用功
```



### 5.为应用指定多个Spring 配置文件

```
当项目越来越大，需要多人合作开发，一个配置就存在很大隐患。
1.拆分配置文件的策略
  1.1 按层拆
      applicationContext_controller.xml
        <bean id="uController" class="com.bjpowernode.controller.UsersController">
        <bean id="bController" class="com.bjpowernode.controller.BookController">
        
      applicationContext_service.xml
        <bean id="uService" class="com.bjpowernode.controller.UsersService">
        <bean id="bService" class="com.bjpowernode.controller.BookService">
        
      applicationContext_mapper.xml
      	<bean id="uMapper" class="com.bjpowernode.controller.UsersMapper">
        <bean id="bMapper" class="com.bjpowernode.controller.BookMapper">
  1.2 按功能拆
  	  applicationContext_users.xml
  	    <bean id="uController" class="com.bjpowernode.controller.UsersController">
        <bean id="uService" class="com.bjpowernode.controller.UsersService">
        <bean id="uMapper" class="com.bjpowernode.controller.UsersMapper">
        
      applicationContext_book.xml
        <bean id="bController" class="com.bjpowernode.controller.BookController">
        <bean id="bService" class="com.bjpowernode.controller.BookService">
        <bean id="bMapper" class="com.bjpowernode.controller.BookMapper">
  
```



### 6.Spring配置文件的整合

```
1.单个文件导入
	<import resource="applicatoinContext_mapper.xml"></import>
    <import resource="applicatoinContext_service.xml"></import>
    <import resource="applicatoinContext_controller.xml"></import>
2.批量导入
	<import resource="applicatoinContext_*.xml"></import>
```





# 第三章 面向切面编程

### 1.AOP概述

```
AOP(Aspect Orient Programming),面向切面编程
切面：公共的、通用的、重复的功能称为切面。
面向切面编程：就是将切面提取出来，单独开发，在需要调用的方法中通过动态代理的方式进行织入

AOP是一种编程思想,是通过预编译方式和运行期动态代理的方式实现不修改源代码的情况下给程序动态统一添加功能的技术。面向对象编程将程序抽象成各个层次的对象,而面向切面编程是将程序抽象成各个切面。所谓切面,相当于应用对象间的横切点,我们可以将其单独抽象为单独的模块。 AOP技术利用一种称为“横切”的技术,剖解开封装对象的内部,将影响多个类的公共行为封装到一个可重用的模块中,并将其命名为切面。所谓的切面,简单来说就是与业务无关,却为业务模块所共同调用的逻辑,将其封装起来便于减少系统的重复代码,降低模块的耦合度,有利用未来的可操作性和可维护性。 利用AOP可以对业务逻辑各个部分进行隔离,从而使业务逻辑各部分之间的耦合度降低,提高程序的可重用性,同时提高开发效率。 AOP可以有多种实现方式,而Spring AOP支持如下两种实现方式。 - JDK动态代理：这是Java提供的动态代理技术,可以在运行时创建接口的代理实例。Spring AOP默认采用这种方式,在接口的代理实例中织入代码。 - CGLib动态代理：采用底层的字节码技术,在运行时创建子类代理的实例。当目标对象不存在接口时,Spring AOP就会采用这种方式,在子类实例中织入代码。 加分回答 在应用场景方面,Spring AOP为IoC的使用提供了更多的便利,一方面,应用可以直接使用AOP的功能,设计应用的横切关注点,把跨越应用程序多个模块的功能抽象出来,并通过简单的AOP的使用,灵活地编制到模块中,比如可以通过AOP实现应用程序中的日志功能。另一方面,在Spring内部,例如事务处理之类的一些支持模块也是通过Spring AOP来实现的。 AOP不能增强的类： 1. Spring AOP只能对IoC容器中的Bean进行增强,对于不受容器管理的对象不能增强。 2. 由于CGLib采用动态创建子类的方式生成代理对象,所以不能对final修饰的类进行代理。
```



### 2.手写AOP框架

```
业务：图书购买业务
切面：事务
1.第一个版本：业务和切面紧耦合在一起，没有拆分
2.第二个版本：使用子类代码的方式拆分业务和切面
3.第三个版本：使用静态代理拆分业务和切面。业务和业务接口已拆分。此时切面紧耦合在业务当中。
4.第四个版本：使用静态代理拆分业务和业务接口，切面和切面接口
5.第五个版本：使用动态代理完成第四个版本的优化。

案例：spring_006_aop 
```



**第四个版本底层AOP原理图：**

![image-20220805175119914](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220805175119914.png)



 

### 3.Spring支持AOP的实现

```
Spring支持AOP的编程，常用的有以下几种：
  1）Before通知：在目标方法被调用前调用，涉及接口org.springframework.aop.MethodBeforeAdvice; 
  2）After通知：在目标方法被调用后调用，涉及接口为org.springframework.aop.AfterReturningAdvice; 
  3）Throws通知：目标方法抛出异常时调用，涉及接口org.springframework.aop.ThrowsAdvice; 
  4）Around通知：拦截对目标对象方法调用，涉及接口为org.aopalliance.intercept.MethodInterceptor。
```



### 4.AOP的常用术语

```
1）切面(Aspect):就是那些重复的、公共的、通用的功能称为切面，例如：日志，事务，权限。
2）连接点:就是目标方法。因为在目标方法中要实现目标方法的功能和切面功能
3）切入点(Pointcut):多个连接点构成切入点。切入点可以是一个目标方法，可以是一个类中的所有方法，可以是某个包下的所有类中的方法。
4）目标对象(target object):操作谁，谁就是目标对象
5）通知（Advice）:来指定切入的时机，是在目标方法执行前还是执行后还是出错时，还是环绕目标方法切入切面功能。 
```



### 5.AspectJ框架

#### 5.1 什么是AspectJ框架

```
AspectJ是一个优秀的面向切面的框架。它扩展了Java语言，提供了强大的切面实现。它因为是基于java语言开发的，所以可以做到无缝扩展。
 easy to learn and use (易学易用)
```



#### 5.2 AspectJ常见通知类型

```
AspectJ中常用的通知类型有四种：
	1.前置通知@Before
	2.后置通知@AfterReturning
	3.环绕通知@Around
	4.最终通知@After
	5.定义切入点@Pointcut(了解)
```

#### 5.3 AspectJ的切入点表达式（掌握）

```
5.3.1 规范的公式：
execution(访问权限 方法返回值 方法声明(参数) 异常类型)

5.3.2 简化后的公式：
execution( 方法返回值 方法声明(参数) )

5.3.3 用到的符号：
*  代表任意个任意的字符(通配符)
.. 如果出现在方法的参数中，则代表任意参数
   如果出现在路径中，则代表本路径及其所有的子路径
示例：
	execution(public * *(..))  :指定切入点为-->任意的公共方法 
	execution(* set*(..))    :指定切入点为-->任何一个以"set"开始的方法
	execution(* com.xyz.service.impl.*.*(..)):指定切入点为-->任意的返回值类型，且在com.xyz.service.impl包下的任意类															 的任意参数的任意方法
	execution(* com.xyz.service..*.*(..)):指定切入点为-->任意的返回值类型，且在com.xyz.service及其子包下的任意类														   的任意参数的任意方法
										 如com.xyz.service.a.b.*.*(..) 或 com.xyz.service.*.*(..)
	execution(* *..service.*.*(..)):service之前可以有任意的子包
	execution(* *.service.*.*(..)):service之前只能由一个包
	
```

#### 5.4 AspectJ的前置通知@Before的流程分析

![image-20220806174431514](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220806174431514.png)



#### 5.5 AspectJ的前置通知@Before

```xml
前置通知@Before
在目标方法执行前切入切面功能。在切面方法中不可以获得目标方法的返回值，只能得到目标方法的签名
																	（签名包括访问权限、返回值、方法名以及参数）
																	
实现的步骤：
  添加依赖
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>5.2.5.RELEASE</version> 
    </dependency>
	1）创建业务接口(SomeService)
	2）创建业务实现(SomeServiceImpl)
	3）创建切面类(MyAspect)
	4）在applicationContext.xml文件中进行注册（切面绑定）
			<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

```

项目案例：

```java
  项目案例:
@Aspect  //交给AspectJ的框架去识别切面类
@Component
public class MyAspect {
    /**
     * 所有切面的功能都是由切面方法来实现的
     * 可以将各种切面都在此类中进行开发
     *
     * 前置通知的切面方法的规范
     * 1)访问权限是public
     * 2)方法的返回值是void
     * 3)方法名称自定义
     * 4)方法没有参数,如果有也只能是JoinPoint类型
     * 5)必须使用@Before注解来声明切入的时机是前切功能和切入点
     *   参数:value  指定切入点表达式
     *
     * 业务方法
     * public String doSome(String name, int age)
     */
    @Before(value = "execution(public String com.bjpowernode.s01.SomeServiceImpl.*(String,int))")
    public void myBefore(){
        System.out.println("切面方法中的前置通知功能实现............");
    }

    @Before(value = "execution(public * com.bjpowernode.s01.SomeServiceImpl.*(..))")
    public void myBefore(){
        System.out.println("切面方法中的前置通知功能实现............");
    }

    @Before(value = "execution( * com.bjpowernode.s01.*.*(..))")
    public void myBefore(JoinPoint jp){
        System.out.println("切面方法中的前置通知功能实现............");
        System.out.println("目标方法的签名:"+jp.getSignature());
        System.out.println("目标方法的参数:"+ Arrays.toString(jp.getArgs()));
    }
    @Before(value = "execution( * com.bjpowernode.s01..*(..))")
    public void myBefore(){
        System.out.println("切面方法中的前置通知功能实现............");
    }

    @Before(value = "execution( * *(..))")
    public void myBefore(){
        System.out.println("切面方法中的前置通知功能实现............");
    }
}
```



#### 5.6 AspectJ框架切换JDK动态代理和CGLib动态代理

```xml-dtd
<aop:aspectj-autoproxy ></aop:aspectj-autoproxy> 
								===>默认是JDK动态代理,取时必须使用接口类型
<aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy> 
								===>设置为CGLib子类代理,可以使用接口和实现类接
    记住:使用接口来接,永远不出错.
```



#### 5.7 AspectJ的前置通知@Before的注解方式实现

```java
/**
 * 业务实现类
 */
@Service  //这里也可以写@Component
public class SomeServiceImpl implements SomeService{
    
    
    
/**
 * 此类为切面类，包含各种切面方法
 */
@Aspect  //交给AspectJ的框架去识别切面类
@Component
public class MyAspect {
    
    
    /**
    * 测试类
    */
    @Test
    public void test02(){
        //创建容器并启动
        ApplicationContext ac = new ClassPathXmlApplicationContext("s01/applicationContext.xml");
        //取出代理对象
        SomeService someService = (SomeService) ac.getBean("someServiceImpl");  
        System.out.println(someService.getClass());
        someService.show();
    }
    //记住：因为改成注解之后，@Component创建对象的默认命名是这边实现类的驼峰命名法，也就是someServiceImpl
    
    
    
    /**
    * applicationContext.xml spring的核心配置文件
    */ 
    <!--基于注解的访问一定要添加包扫描-->
    <context:component-scan base-package="com.bjpowernode.s01"></context:component-scan>
        
```



#### 5.8 AspectJ的后置通知@AfterReturning的流程分析

![image-20220806175447707](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220806175447707.png)



#### 5.9 AspectJ的后置通知基本功能实现

```java
后置通知@AfterReturning
后置通知是在目标方法执行后切入切面功能,可以得到目标方法的返回值.
       如果目标方法的返回值是简单类型(8种基本类型+String)则不可改变.
       如果目标方法的返回值是引用类型则可以改变.
	@Aspect
	@Component
	public class MyAspect {
	    /**
	     * 后置通知的方法的规范
	     * 1)访问权限是public
	     * 2)方法没有返回值void
	     * 3)方法名称自定义
	     * 4)方法有参数(也可以没有参数,如果目标方法没有返回值,则可以写无参的方法,但一般会写有参,这样可以处理无参可以处理有参),这个切面方法的参数就是目标方法的返回值
	     * 5)使用@AfterReturning注解表明是后置通知
	     *   参数:
	     *      value:指定切入点表达式
	     *      returning:指定目标方法的返回值的名称,则名称必须与切面方法的参数名称一致.
	     */
	    @AfterReturning(value = "execution(* com.bjpowernode.s02.*.*(..))",returning = "obj")
	    public void myAfterReturning(Object obj){
	        System.out.println("后置通知功能实现..............");
	        if(obj != null){
	            if(obj instanceof String){
	                obj = obj.toString().toUpperCase();
	                System.out.println("在切面方法中目标方法的返回值:"+obj);
	            }
	            if(obj instanceof Student){
	                Student stu = (Student) obj;
	                stu.setName("李四");
	                System.out.println("在切面方法中目标方法的返回值:"+stu);
	            }
	        }
	    }
	}
```





#### 5.10 AspectJ的环绕通知@Around执行流程分析

![image-20220806211302255](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220806211302255.png)



#### 5.11 AspectJ的环绕通知@Around的代码实现

```java
环绕通知@Around
它是通过拦截目标方法的方式，在目标方法前后增强功能的通知。它是功能最强大的通知，一般事务使用此通知。它可以轻易的改变目标方法的返回值。

@Aspect
@Component
public class MyAspect {
    /**
     * 环绕通知方法的规范
     * 1)访问权限是public
     * 2)切面方法有返回值,此返回值就是目标方法的返回值
     * 3)方法名称自定义
     * 4)方法有参数,此参数就是目标方法
     * 5)回避异常Throwable
     * 6)使用@Around注解声明是环绕通知
     *   参数:
     *      value:指定切入点表达式
     */

    @Around(value = "execution(* com.bjpowernode.s03.*.*(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        //前切功能实现
        System.out.println("环绕通知中的前置功能实现............");
        //目标方法调用
        Object obj = pjp.proceed(pjp.getArgs());
        //后切功能实现
        System.out.println("环绕通知中的后置功能实现............");
        return obj.toString().toUpperCase();  //改变了目标方法的返回值
    }
}
```



#### 5.12 AspectJ的最终通知@After的代码实现

```java
最终通知@After
无论目标方法是否正常执行，最终通知的代码都会被执行。

@Aspect
@Component
public class MyAspect {
    /**
     * 最终通知方法的规范
     * 1）访问权限为public
     * 2）方法没有返回值
     * 3）方法名称自定义
     * 4）方法没有参数。如果有也只能是JoinPoint
     * 5）使用@After表明是最终通知
     *      参数：
     *          value：指定切入点表达式
     */
    @After(value = "execution( * com.bjpowernode.s04.*.*(..))")
    public void myAfter(){
        System.out.println("最终通知的功能。。。。");
        //System.out.println("1/0"); //就算添加一条这样的算术除零异常报错，最终通知的代码都会被执行
    }
```



### 5.13 给切入点表达式起别名@Pointcut



```java
 如果多个切面切入到同一个切入点，可以使用别名简化开发。
 使用@Pointcut注解，创建同一个空方法，此方法的名称就是别名

	@Aspect
	@Component
	public class MyAspect {
	    /**
	     * 最终通知方法的规范
	     * 1)访问权限是public
	     * 2)方法没有返回值
	     * 3)方法名称自定义
	     * 4)方法没有参数,如果有也只能是JoinPoint
	     * 5)使用@After注解表明是最终通知
	     *   参数:
	     *     value:指定切入点表达式
	     */
	    @After(value = "mycut()")
	    public void myAfter(){
	        System.out.println("最终通知的功能........");
	    }

	    @Before(value = "mycut()")
	    public void myBefore(){
	        System.out.println("前置通知的功能........");
	    }

	    @AfterReturning(value = "mycut()",returning = "obj")
	    public void myAfterReturning(Object obj){
	        System.out.println("后置通知的功能........");
	    }
	    @Around(value = "mycut()")
	    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
	        System.out.println("环绕通知中的前置通知的功能........");
	        Object obj = pjp.proceed(pjp.getArgs());
	        System.out.println("环绕通知中的后置通知的功能........");
	        return obj;
	    }

	    @Pointcut(value = "execution(* com.bjpowernode.s04.*.*(..))")
	    public void mycut(){}
	}
```



# 第四章 Spring 集成 MyBatis

### 1.SM整合的步骤

```
1）建表
2）新建项目，选择quickstart模板
3）修改目录
4）修改pom.xml文件，添加相关的依赖（使用老师提供的）
5）添加MyBatis相应的模板(SqlMapConfig.xml和XXXMapper.xml文件)
6）添加sqlMapConfig.xml文件(MyBatis核心配置文件),并拷贝jdbc.propertiest属性文件到resources目录下
7）添加applicationContext_mapper.xml
8）添加applicationContext.service.xml
9）添加User实体类，Accounts实体类
10）添加mapper包，添加UsersMapper接口和UsersMapper.xml文件并开发
11）添加service包，添加UsersService接口和UsersServiceImpl实现类
12）添加测试类进行功能测试 
```

#### 1.1 <context:property-placeholder>标签报错解决

注意：在使用<context:property-placeholder>标签读取属性文件的时候，如果该属性文件一直报错，那么将配置头修改一下即可

具体修改如下：（注释掉的是修改前IDEA自动生成的，会导致报错，下面没注释的才是不会报错的正确写法）![image-20220807131004549](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220807131004549.png)



```
<!--读取属性文件jdbc.properties-->
<context:property-placeholder location="jdbc.properties"></context:property-placeholder>
```



#### 1.2 MyTest运行的时候进入无限循环报错

```
因为mysql版本和驱动版本不匹配，在pom.xml文件里修改就可。
在老师给的资源里的使用的mysql版本是5的，而我更换为自己下载的8.0.23的mysql版本则运行通过。
```



![image-20220807150942494](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220807150942494.png)



#### 1.3 <tx:annotation-driven>标签报错解决

Spring配置文件<tx:annotation-driven transaction-manager>报错，原因是命名空间错误，idea自动导入的是

![image-20220807161143166](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220807161143166.png)

只需要把命名空间改为tx就可以了：

![image-20220807161240626](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220807161240626.png)







### 2.基于注解的事务添加步骤

```xml
  1)在applicationContext_service.xml文件中添加事务管理器
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!--因为事务必须关联数据库处理,所以要配置数据源-->
        <property name="dataSource" ref="dataSource"></property>
     </bean>

  2)在applicationContext_service.xml文件中添加事务的注解驱动
    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
  3)在业务逻辑的实现类上添加注解@Transactional(propagation = Propagation.REQUIRED)
    REQUIRED表示增删改操作时必须添加的事务传播特性
```



### 3.@Transactional注解参数详解

```java
	@Transactional(propagation = Propagation.REQUIRED,//事务的传播特性
	        noRollbackForClassName = "ArithmeticException", //指定发生什么异常不回滚,使用的是异常的名称
	        noRollbackFor = ArithmeticException.class,//指定发生什么异常不回滚,使用的是异常的类型
	        rollbackForClassName = "",//指定发生什么异常必须回滚
	        rollbackFor = ArithmeticException.class,//指定发生什么异常必须回滚
	        timeout = -1, //连接超时设置,默认值是-1,表示永不超时
	        readOnly = false, //默认是false,如果是查询操作,必须设置为true.
	        isolation = Isolation.DEFAULT//使用数据库自已的隔离级别        
	)
```



### 4.Spring的两种事务的处理方式

```
1）注解式的事务
	使用@Transactional注解完成事务控制
		此注解可添加到类上，则对类中所有方法执行事务的设定。
		此注解可添加到方法上，只是对此方法执行事务的处理。

2）声明式事务(必须掌握)
	在配置文件中添加一次，整个项目遵循事务的设定。
```



### 5.Spring中事务的五大隔离级别

```
1)未提交读(Read Uncommitted):允许脏读，也就是可能读取到其他会话中未提交事务修改的数据
2)提交读(Read Commit):只能读取到已经提交的数据。Oracle等多数数据库默认的都是该级别(不重复读)
3)可重复读(Repeated Read):可重复读。在同一个事务内的查询都是事务开始时刻一致的，InnoDB默认级别。在SQL标准中，该隔离级别消除了不可重复读，但是还存在幻想读，但是InnoDB解决了幻读
4)串行读(Serializable):完全串行化的读，每次读都需要获得表级共享锁，读写互相都会阻塞
5)使用数据库默认的隔离级别isolation = Isolation.DEFAULT
```

#### 5.1不同数据库的隔离级别（面试点)

```
**MySQL**：mysql默认的事务处理级别是'REPEATABLE-READ',也就是**可重复读**

**Oracle**：oracle数据库支持READ COMMITTED 和 SERIALIZABLE这两种事务隔离级别。

默认系统事务隔离级别是READ COMMITTED,也就是**读已提交**
```





### 6.为什么要添加事务管理器

```xml
JDBC:Connection  con.commit();   con.rollback();
MyBatis: SqlSession   SqlSession.commit();   SqlSession.rollback();
Hibernate: Session    session.commit();      session.rollback();

事务管理器用来生成相应技术的连接+执行语句的对象。(可能是Connection、可能是SqlSession、可能是Session)
如果使用MyBatis框架，必须使用DataSourceTransactionManager类完成处理
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!--因为事务必须关联数据库处理,所以要配置数据源-->
        <property name="dataSource" ref="dataSource"></property>
     </bean>

在使用mybatis的时候，加了DataSourceTransactionManager这个才会生成相应的连接+执行语句的对象。(可能是Connection、可能是SqlSession、可能是Session)
```



**项目中的所有事务，都必须添加到业务逻辑层上。** 

​	

### ***7 MyBatis框架与Hibernate框架使用的事务管理器（面试点）\****

#### ***\7.1 Spring+MyBatis的事务管理器配置\****

<!-- 定义事务管理器 -->	

<bean id="transactionManager"		class="**org.springframework.jdbc.datasource.DataSourceTransactionManager**">		

<property name="dataSource" ref="dataSource" />	

</bean>

<!--使用注解事务 -->	

<tx:annotation-driven  transaction-manager="transactionManager" />

#### ***\7.2 Spring+ Hibernate的事务管理器配置\****

<!-- 事务管理器配置,单数据源事务 -->	

<bean id="transactionManager" class="**org.springframework.orm.hibernate3.HibernateTransactionManager**">		

<property name="sessionFactory" ref="sessionFactory" />	

</bean>		

<!-- 使用annotation定义事务 -->	

<tx:annotation-driven  transaction-manager="transactionManager"  proxy-target-class="true" />





### 8.Spring事务的传播特性（重点）

```
多个事务之间的合并、互斥等都可以通过设置事务的传播特性来解决。

把并行变串行，提高并发性可以通过事务的传播特性来解决

 常用
  PROPAGATION_REQUIRED：必被包含事务(增删改必用)
  PROPAGATION_REQUIRES_NEW：自己新开事务，不管之前是否有事务
  PROPAGATION_SUPPORTS：支持事务，如果加入的方法有事务，则支持事务，如果没有，不单开事务
  PROPAGATION_NEVER：不能运行中事务中，如果包在事务中，抛异常
  PROPAGATION_NOT_SUPPORTED：不支持事务，运行在非事务的环境
 不常用
  PROPAGATION_MANDATORY：必须包在事务中，没有事务则抛异常
  PROPAGATION_NESTED：嵌套事务
```



### 9.Spring 的事务的传播特性解析

（注意：结果中的OK就是数据成功传到数据库中，NO就是没有传到数据库中）

![image-20220807195125858](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220807195125858.png)



### 10.为了测试传播特性改造项目

```java
    @Service  //交给Spring去创建对象
	@Transactional(propagation = Propagation.REQUIRED)
	public class UsersServiceImpl implements UsersService {    
	    @Autowired
	    UsersMapper usersMapper;

       @Autowired
        AccountsService accountsService;

        @Override
        public int insert(Users users) {
            int num = usersMapper.insert(users);
            System.out.println("用户增加成功!num="+num);

            //调用帐户的增加操作,调用的帐户的业务逻辑层的功能
            num = accountsService.save(new Accounts(300,"王五","帐户好的呢!"));
            return num;
        }
    }
```








### 11.声明式事务的实现

Spring非常有名的事务处理方式：声明式事务。

要求项目中的方法命名有规范：

1）完成增加操作   包含add save  insert set等等字眼

2）完成更新操作   包含update  change 	modify等字眼

3）完成删除操作   包含delete drop  remove   clear 等字眼

4）完成查询操作   包含select  find   search  get等字眼



配置事务切面时可以使用通配符*来匹配所有方法（就是写一个applicationContext_trans.xml来实现)

```xml
    <!--此配置文件与application_service.xml的功能一样，只是事务配置不同-->

    <!--导入application_mapper.xml文件-->
    <import resource="applicationContext_mapper.xml"></import>

    <!--添加包扫描-->
    <context:component-scan base-package="com.bjpowernode.service.impl"></context:component-scan>

    <!--添加事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>


<!--从这里开始到结束，就是声明式事务的具体代码实现-->
    <!--配置事务切面-->
    <tx:advice id="myadvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="*select*" read-only="true"/>
            <tx:method name="*find*" read-only="true"/>
            <tx:method name="*search*" read-only="true"/>
            <tx:method name="*get*" read-only="true"/>
            <tx:method name="*insert*" propagation="REQUIRED" no-rollback-for="ArithmeticException"/>
            <tx:method name="*add*" propagation="REQUIRED"/>
            <tx:method name="*save*" propagation="REQUIRED" no-rollback-for="ArithmeticException"/>
            <tx:method name="*set*" propagation="REQUIRED"/>
            <tx:method name="*update*" propagation="REQUIRED"/>
            <tx:method name="*change*" propagation="REQUIRED"/>
            <tx:method name="*modify*" propagation="REQUIRED"/>
            <tx:method name="*delete*" propagation="REQUIRED"/>
            <tx:method name="*remove*" propagation="REQUIRED"/>
            <tx:method name="*drop*" propagation="REQUIRED"/>
            <tx:method name="*clear*" propagation="REQUIRED"/>
            <tx:method name="*" propagation="SUPPORTS"/>
        </tx:attributes>
    </tx:advice>
    <!--绑定切面和切入点:哪些类的哪些方法参与事务-->
    <aop:config>
        <aop:pointcut id="mycut" expression="execution(* com.bjpowernode.service.impl.*.*(..))"></aop:pointcut>
        <aop:advisor advice-ref="myadvice" pointcut-ref="mycut"></aop:advisor>
    </aop:config>

</beans>
```



### 12.设置事务处理的优先级（了解就行）

可以在配置事务切面之前（<tx:advice id="myadvice" transaction-manager="transactionManager">），添加一个注解事务：

```xml
<tx:annotation-driven order="100"></tx:annotation-driven>
```

然后在绑定切面和切入点中的<aop:advisor> 里添加一个参数order,设置的order的值比上面添加的注解事务的order的值小就说明可以在局部将整体的声明式事务的实现给覆盖。

```xml
<aop:advisor order="1" advice-ref="myadvice" pointcut-ref="mycut"></aop:advisor>
```

这样就可以用自己的注解@Transactional去顶替掉全局声明式事务的配置





事务边界一般放在业务层，就是说给业务层的方法织入事务传播特性



spring课程总结pdf [Spring.pdf](06_笔记\Spring.pdf) 

要找什么知识点可通过这个pdf来导航，然后再导航到笔记当中寻找相应的知识点。





# 第五章 具体关于各种注解

**@Autowired**

```java
/**
 * 以前是这么做的：
 *        //1.读取核心配置文件
 *         InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
 *         //2.创建SqlSessionFactory工厂对象
 *         SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
 *         //3.取出sqlSession对象
 *        sqlSession = factory.openSession(true);
 *         //4.取出动态代理的对象，完成接口中方法的调用，实则是调用xml文件中相应的标签的功能
 *         //uMapper 是一个接口
 *         uMapper = sqlSession.getMapper(UsersMapper.class);
 * 现在只需要加一行注解 @Autowired
 */
```

**@Transactional**

```java
@Transactional(propagation = Propagation.REQUIRED,//事务的传播特性
        noRollbackForClassName = "ArithmeticException", //指定发生什么异常不回滚,使用的是异常的名称
        noRollbackFor = ArithmeticException.class,//指定发生什么异常不回滚,使用的是异常的类型
        rollbackForClassName = "",//指定发生什么异常必须回滚
        rollbackFor = ArithmeticException.class,//指定发生什么异常必须回滚
        timeout = -1, //连接超时设置,默认值是-1,表示永不超时
        readOnly = false, //默认是false,如果是查询操作,必须设置为true.
        isolation = Isolation.DEFAULT//使用数据库自已的隔离级别        
)
```


**@Component**

​					交给spring去创建对象（spring）

**@Controller** 

​					界面层交给spring去创建对象

**@Service**      

​					业务逻辑层交给spring去创建对象

**@Repository**

​					数据访问层交给spring去创建对象

**@Aspect**

​					交给AspectJ的框架去识别切面类(就是说放在谁头上，谁就是切面类)

**@Before**    

​					前置通知：在目标方法执行前切入切面功能

**@AfterReturning**

​					后置通知：在目标方法执行后切入切面功能

**@Around**

​					环绕通知：通过拦截目标方法的方式，在目标方法前后增强功能的通知。

**@After**

​					最终通知：无论目标方法是否正常执行，最终通知的代码都会被执行。

**@Pointcut**

​					如果多个切面切入到同一个切入点，可以使用别名简化开发。

​					 使用@Pointcut注解，创建同一个空方法，此方法的名称就是别名

​					