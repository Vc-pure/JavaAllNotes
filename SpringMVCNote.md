# 第一章 SpringMVC概述

## 1.什么是SpringMVC

```
它是基于MVC开发模式的框架，用来优化控制器。它是Spring家族的一员。它也具备IOC和AOP
```



## 2.什么是MVC？

```
它是一种开发模式，它是模型视图控制器的简称。所有的web应用都是基于MVC开发的。

M：模型层，包含实体类，业务逻辑层，数据访问层。

V：视图层，html，JavaScript，vue等都是视图层，用来显现数据

C：控制器，它是用来接收客户端的请求，并返回响应到客户端的组件，Servlet就是组件
```

## 3.SSM框架优化的方向（示意图）

![image-20220807223841707](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220807223841707.png)

MyBatis优化的是Model模型层

SpringMVC优化的是Controller控制器

Spring优化的是MyBatis和SpringMVC





## 4.SpringMVC框架的优点

```
1）轻量级，基于MVC的框架
2）易于上手，容易理解，功能强大
3）它具备IOC和AOP
4）完全基于注解开发
```



## 5.SpringMVC优化的方向（时序图）

![image-20220807224516333](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220807224516333.png)



## 6.SpringMVC的执行流程

![image-20220807224709856](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220807224709856.png)





## 6.基于注解的SpringMVC框架开发的步骤

```xml
1）新建项目，选择webapp模板
2）修改目录，添加缺失的test，java，resources（两套），并修改目录属性
3）修改pom.xml文件，添加SpringMVC的依赖，添加Servlet的依赖
4）添加springmvc.xml配置文件，指定包扫描（因为是基于注解开发），添加视图解析器（ViewResolver）
5）删除web.xml文件，新建web.xml
6）在web.xml中注册SpringMVC框架（所有的web请求都是基于servlet的）
7）在webapp目录下新建admin目录，在admin目录下新建main.jsp页面，删除index.jsp界面，并新建，发送请求给服务器
8）开发控制器（Servlet），它是一个普通的类
9）添加tomcat进行测试功能
```



## 7.分析web请求

 web请求执行的流程：
  							                核心处理器
  index.jsp<--------------->DispatcherServlet<------------------->SpringMVC的处理器是一个普通的方法
  one.jsp  <---------------->DispatcherServlet<------------------->SpringMVC的处理器是一个普通的方法

  DispatcherServlet要在web.xml文件中注册才可用.





## 8.基于注解的SpringMVC程序

所谓 SpringMVC 的注解式开发是指，在代码中通过对类与方法的注解，便可完成处理器在 springmvc 容器的注册。注解式开发是重点。

项目案例功能：用户提交一个请求，服务端处理器在接收到这个请求后，给出一条欢迎信息，在响应页面中显示该信息。

创建步骤：

1）新建maven_web项目

![img](file:///C:\Users\Nicolasbruno\AppData\Local\Temp\ksohtml19152\wps1.jpg) 

2）添加依赖

```xml
<dependency>
     <groupId>org.springframework</groupId> 
     <artifactId>spring-webmvc</artifactId>
     <version>5.2.5.RELEASE</version> 
</dependency> 

<dependency> 
    <groupId>javax.servlet</groupId> 
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version> 
</dependency>
```



3）删除web.xml文件重新添加，因为自动生成的web.xml文件版本太低了。

![img](file:///C:\Users\Nicolasbruno\AppData\Local\Temp\ksohtml19152\wps2.jpg) 

4）在web.xml文件中注册SpringMvc框架。因为web的请求都是由Servlet来进行处理的，而SpringMVC的核心处理器就是一个DispatcherServlet，它负责接收客户端的请求，并根据请求的路径分派给对应的action（控制器）进行处理，处理结束后依然由核心处理器DispatcherServlet进行响应返回。

中央调度器的全限定性类名在导入的 Jar 文件 spring-webmvc-5.2.5.RELEASE.jar 的第一个包org.springframework.web.servlet下可找到。

```xml
 <servlet> 
    <servlet-name>springmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     <init-param>
     	<param-name>contextConfigLocation</param-name> 
     	<param-value>classpath:springmvc.xml</param-value> 
     </init-param>
 </servlet>

 <servlet-mapping>
     <servlet-name>springmvc</servlet-name> 
     <url-pattern>*.action</url-pattern> 
 </servlet-mapping>

<!--
	<param-value>classpath:springmvc.xml</param-value>表示从类路径下加载SpringMVC的配置文件。
	<url-pattern>指定拦截以.action结尾的请求，交给核心处理器DispatcherServlet处理。
-->
```





5）删除index.jsp页面，重新建index.jsp页面，因为自动生成的页面缺失指令设置。

6）开发页面，发出请求。

```
<a href="${pageContext.request.contextPath}/zar/hello.action">访问action</a>
```

其中：

 /zar  是类上的注解路径

 /hello 是方法上的注解路径

7）在webapp目录上新添目录/admin。

8）在/admin目录下新建main.jsp页面。用来进行服务器处理完毕后数据的回显。

9）开发HelloSpringMvc.java-->控制器（相当于以前的servlet）。这是一个普通的类，不用继承和实现接口。类中的每个方法就是一个具体的action控制器。

```java
/**
     * 以前的Servlet规范：
     * protected void doPost(HttpServletRequest request,HttpServletResponse response)
                throws ServletException,IOException{}
     *
     * action中所有的功能实现都是由方法来完成的
     * action方法的规范
     * 1）访问权限是public
     * 2）方法的返回值是任意
     * 3）方法名称任意
     * 4）方法可以没有参数，如果有，可以是任意类型
     * 5）要使用@RequestMapping注解来声明一个访问的路径(其实就是一个访问的名称）
*/
@Controller 
@RequestMapping("/zar") 
public class HelloSpringMvc { 
	@RequestMapping("/hello") 
	public String one(){ 
	return "main"; 
  }
}
//@Controller：表示当前类为处理器，交给Spring容器去创建对象。
//@RequestMapping：表示路径映射。该注解可以加在类上相当于包名，还可以加在方法上相当于action的名称，都是来指定映射路径的。
```



10）完成springmvc.xml文件的配置。在工程的类路径即resources目录下创建 SpringMVC 的配置文件 springmvc.xml。该文件名可以任意命名。推荐使用springmvc.xml.

```xml
<context:component-scan base-package="com.bjpowernode.controller"></context:component-scan>
<!--添加视图解析器-->
 <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver"> 			<property name="prefix" value="/WEB-INF/jsp/"></property> 
	<property name="suffix" value=".jsp"></property> 
 </bean> 

<!--
	SpringMVC框架为了避免对于请求资源路径与扩展名上的冗余，在视图解析器InternalResouceViewResolver 中引入了请求的前辍与后	 辍。而action中只需给出要跳转页面的文件名即可，对于具体的文件路径与文件扩展名，视图解析器会自动完成拼接。

	<context:component-scan>:用来进行包扫描，这里用于指定@Controller注解所在的包路径。
-->
```





# 第二章 SpringMVC注解式开发

## 1.@RequestMapping注解详解

```java
此注解就是来映射服务器访问的路径.
1）此注解可加在方法上，是为此方法注册一个可以访问的名称（其实就是注册一个路径）
	@RequestMapping("/demo")
    public String demo(){
        System.out.println("服务器被访问到了。。。");
        return "main";  //可以直接跳到/admin/main.jsp页面上
    }
    
    <a href="${pageContext.request.contextPath}/demo.action">访问服务器</a>
        
2）此注解可加在类上，相当于是包名（其实就是提供一个虚拟路径），区分不同类中相同的action的名称
    @RequestMapping("/user")
    public class DemoAction1 {..}

    <a href="${pageContext.request.contextPath}/user/demo.action">访问服务器</a>
        
        
    @RequestMapping("/zy")
    public class DemoAction {..}

    <a href="${pageContext.request.contextPath}/zy/demo.action">访问服务器</a>
        
 3）此注解可区分get请求和post请求 
        @Controller
        public class ReqAction {
            @RequestMapping(value = "/req",method = RequestMethod.GET)
            public String req(){
                System.out.println("我是处理get请求的");
                return "main";
            }
            @RequestMapping(value = "/req",method = RequestMethod.POST)
            public String req1(){
                System.out.println("我是处理post请求的");
                return "main";
            }
        }

```



## 2.五种数据提交的方式

### 2.1SpringMVC可优化的内容（1234）：

![image-20220808111945251](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220808111945251.png)

### 2.2 五种数据提交方式的优化

```java
1）散提交数据（单个提交数据）
  页面:  
  <form action="${pageContext.request.contextPath}/one.action">
      姓名:<input name="myname"><br>
      年龄:<input name="age"><br>
      <input type="submit" value="提交">
  </form>
          
  action:
  @RequestMapping("/one")
    public String one(String myname,int age){  ===>自动注入,并且类型转换
        System.out.println("myname="+myname+",age="+(age+100));
        return "main";
    }

2）对象封装提交数据
    在提交请求中，保证请求参数的名称与实体类中成员变量的名称一致，则可以自动创建对象，自动提交数据，自动类型转换，自动封装数据到对象中。
    实体类:
    public class Users {
    private String name;
    private int age;}

    页面:
	<form action="${pageContext.request.contextPath}/two.action" method="post">
	    姓名:<input name="name"><br>
	    年龄:<input name="age"><br>
	    <input type="submit" value="提交">
	</form>
            
    action:
    @RequestMapping("/two")
    public String two(Users u){
        System.out.println(u);
        return "main";
    }
    
3）动态占位符提交
    仅限于超链接或地址栏提交数据。它是一杠一值，一杠一大括号，使用注解@PathVariable来解析。 
        <a href="${pageContext.request.contextPath}/three/张三/22.action">动态提交</a>    
        @RequestMapping("/three/{uname}/{uage}")
        public String three(
                @PathVariable("uname")  ===>用来解析路径中的请求参数
                String name,
                @PathVariable("uage")
                int age){
            System.out.println("name="+name+",age="+(age+100));
            return "main";
        }

4）映射名称不一致
    提交请求参数与action方法的形参的名称不一致，使用注解@RequestParam来解析
    
        /**
         * 姓名：<input name="name"><br>
         * 年龄：<input name="age"><br>
         * @param uname
         * @param uage
         * @return
         */
        @RequestMapping("/four")
        public String four(
                @RequestParam("name")  ===>专门用来解决名称不一致的问题
                String uname,
                @RequestParam("age")
                int uage){
            System.out.println("uname="+uname+",uage="+(uage+100));
            return "main";
        }

5）手工提取数据
      /**
     *  姓名:<input name="name"><br>
     *  年龄:<input name="age"><br>
     */
  @RequestMapping("/five")
    public String five(HttpServletRequest request){
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("name="+name+",age="+(age+100));
        return "main";
    }   
```



## 3.中文乱码解决方案

​	 配置过滤器

```xml
    <!--中文编码过滤器配置 最好写在最前面-->
    <filter>
        <filter-name>encode</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <!--
            配置参数 把UTF8塞进去
            private String encoding;
            private boolean forceRequestEncoding;
            private boolean forceResponseEncoding;
        -->
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceRequestEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
        <init-param>
            <param-name>forceResponseEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encode</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```



## 4. action方法的返回值

```
1）String：客户端资源的地址，自动拼接前缀和后缀。还可以屏蔽自动拼接字符串，可以指定返回的路径。
2）Object：返回json格式的对象。自动将对象或集合转为json。使用的jackson工具进行转换，必须要添加jackson依赖。一般用于ajax请求
3）void：无返回值，一般用于ajax请求。
4）基本数据类型：用于ajax请求。
5）ModelAndView：返回数据和视图对象，现在用的很少。
```



## 5.完成ajax请求访问服务器，返回学生集合

```xml
1）添加jackson依赖
	<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.6</version>
    </dependency>
2）在webapp目录下新建js目录，添加JQuery函数库
3）在index.jsp页面上导入函数库
4）在action上添加注解@ResponseBody，用来处理Ajax请求
5）在springmvc.xml文件中添加注解驱动<mvc:annotationdriven/>，它用来解析@ResponseBody注解
```





## 6.SpringMVC的四种跳转方式

### 6.1 转发和重定向的区别（图示）

![image-20220808165936411](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220808165936411.png)



### 6.2 四种跳转方式

**本质还是两种跳转:请求转发和重定向,衍生出四种是请求转发页面,转发action,重定向页面,重定向action**

```java
<a href="${pageContext.request.contextPath}/one.action">1.请求转发页面(默认)</a>  <br>
<a href="${pageContext.request.contextPath}/two.action">2.请求转发action</a> <br>
<a href="${pageContext.request.contextPath}/three.action">3.重定向页面</a> <br>
<a href="${pageContext.request.contextPath}/four.action">4.重定向action</a> <br>
<a href="${pageContext.request.contextPath}/five.action">5.随便跳页面</a> <br>



	@RequestMapping("/one")
    public String one(){
        System.out.println("这是请求转发页面跳转......");
        return "main";  //默认是请求转发，使用视图解析器拼接前缀后缀进行页面跳转
    }


    @RequestMapping("/two")
    public String two(){
        //转发路径是two.action --> other.action  -->  main.jsp
        //地址栏出现的是two.action ,但是实际上显示的是main.jsp
        System.out.println("这是请求转发action跳转......");
        // /admin/ /other.action .jsp
        //forward:  这组字符串可以屏蔽前缀和后缀的拼接
        return "forward:/other.action";  //默认是请求转发，使用视图解析器拼接前缀后缀进行页面跳转
    }

	@RequestMapping("/three")
    public String three(){
        System.out.println("这是重定向页面.....");
        //redirect:  这组字符串可以屏蔽前缀和后缀的拼接,实现重定向跳转
        return "redirect:/admin/main.jsp";
    }

    @RequestMapping("/four")
    public String four(){
        //转发路径是four.action --> other.action  -->  main.jsp
        //地址栏通过重定向出现的是other.action ,但是实际上显示的是main.jsp的内容
        System.out.println("这是重定向action.....");
        //redirect:  这组字符串可以屏蔽前缀和后缀的拼接,实现重定向跳转
        return "redirect:/other.action";
    }

    @RequestMapping("/five")
    public String five(){
        System.out.println("这里是随便跳页面");
        return "forward:/fore/login.jsp";
    }
```



## 7.SpringMVC支持的默认参数类型

​	不需要去创建，可以直接拿来使用

```java
1) HttpServletRequest
2) HttpServletResponse
3) HttpSession
4) Model
5) Map
6) ModelMap
这些对象可以进行数据携带
注意：Map，Model，ModelMap和request一样，都使用请求作用域（request域）进行数据传递。所以服务器端的跳转必须是请求转发。
		要想让重定向好使，就只能在用session的时候。
		
		
  		//做一个数据,传到main.jsp页面上
        Users u = new Users("张三",22);

        //传递数据
        request.setAttribute("requestUsers",u);
        session.setAttribute("sessionUsers",u);
        model.addAttribute("modelUsers",u);
        map.put("mapUsers",u);
        modelMap.addAttribute("modelMapUsers",u);
       //以上五行代码就相当于是把数据装在的这几个对象的兜兜里面

        return "main";  //默认是请求转发方式跳转
	  //return "redirect:/admin/main.jsp"; //如果采用重定向跳转页面，那么数据只剩下session的携带过来了，剩下的都丢了

        main.jsp:
        requestUsers的数据：${requestUsers} <br>
        sessionUsers：${sessionUsers} <br>
        modelUsers：${modelUsers} <br>
        mapUsers：${mapUsers} <br>
        modelMapUsers：${modelMapUsers} <br>
        从index.jsp页面来的数据：${param.name}


```



## 8.日期处理

```xml
1）日期的提交处理
   A:单个日期处理
   	  要使用注解@DateTimeFormat，此注解必须搭配springmvc.xml文件中的<mvc:annotationdriven标签>
   B:类中全局日期处理
	  注册一个注解，用来解析本类中所有的日期类型，自动转换。
        //注册一个全局的日期处理注解(有了它，都不用写springmvc.xml文件中的<mvc:annotationdriven标签了)
        @InitBinder
        public void initBinder(WebDataBinder dataBinder){
            dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sf,true));
        }

        @RequestMapping("/mydate")
        public String mydate(Date mydate){
            System.out.println(mydate);
            System.out.println(sf.format(mydate));
            return "show";
        }


2）日期的显示处理
    在页面上显示好看的日期，必须使用JSTL
    步骤：
     A.添加依赖jstl
        <dependency>
          <groupId>jstl</groupId>
          <artifactId>jstl</artifactId>
          <version>1.2</version>
        </dependency>
     B.在页面上导入标签库
    	 如果是单个日期对象,直接转为好看的格式化的字符串进行显示.
   		 如果是list中的实体类对象的成员变量是日期类型,则必须使用jstl进行显示.
            <%--导入jstl核心标签库--%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%--导入jstl格式化标签库--%>
            <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     C.使用标签显示数据
    <table width="800px" border="1">
    <tr>
    <th>姓名</th>
    <th>生日</th>
    </tr>
    <c:forEach items="${list}" var="stu">
        <tr>
        <td>${stu.name}</td>
        <td>${stu.birthday}------ <fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
        </tr>
        </c:forEach>
            </table>

```



>**日期注入以及日期显示的相关补充：**

***\*2.7.1 日期注入\****

日期类型不能自动注入到方法的参数中。需要单独做转换处理。使用@DateTimeFormat注解，需要在springmvc.xml文件中添加<mvc:annotation-driven/>标签。

**（1）*****\*在方法的参数上使用@DateTimeFormat注解\****

@RequestMapping("/submitone") public String submitdateone( @DateTimeFormat(pattern="yyyy-MM-dd")     Date mydate){   System.*out*.println(mydate);   return "dateShow"; }

***\*（2）在类的成员setXXX()方法上使用@DateTimeFormat注解\****

@DateTimeFormat(pattern="yyyy-MM-dd") public void setDate(Date date) { this.date = date; }

但这种解决方案要在每个使用日期类型的地方都去添加使用@DateTimeFormat注解，比较麻烦，我们可以使用@InitBinder注解来进行类中统一日期类型的处理。

***\*（3）@InitBinder注解解决类中日期问题\****

@InitBinder public void initBinder(WebDataBinder dataBinder) {   SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd"); dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true)); }

这样在类中出现的所有日期都可以进行转换了。



***\*2.7.2 日期显示\****

***\*JSON中的日期显示\****

需要在类中的成员变量的getXXX方法上加注解.

@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") public Date getDate() { return date; }







## 9.SpringMVC执行流程分析



DispatcherServlet 核心处理器

HandlerMapping  地址映射器

HandlerAdapter  处理器适配器

ViewResolver   视图解析器



DispatcherServlet是 核心处理器，一个好汉三个帮（一个好汉就是DispatcherServlet，三个帮是HandlerMapping，HandlerAdapter，ViewResolver），当你从客户端发送了一个请求：http://localhost:8080/demo.action，当这个请求到达DispatcherServlet的时候，DispatcherServlet它会调用第一个小帮手：HandlerMapping，让HandlerMapping去解析整个的请求路径中的服务器端的资源的地址，也就意味着它从整个字符串中解析出来了demo，HandlerMapping就是地址映射器，它从整个地址中找到.action前面的这个名称，或者最后一个反斜杠后面的名称，这就是你要访问的action的名称，HandlerMapping解析回来以后还是交给DispatcherServlet，然后DispatcherServlet紧接着调用下一个小帮手：HandlerAdapter，这里用到了适配器模式，为什么要用适配器呢？就是我拿到这个demo的名字，但是我不是只要这个字符串的，而是要创建控制器的对象，要根据demo的名称创建控制器的对象，而控制器的对象我们有两种方式去生成，可能是xml中的bean标签，可能是当前注解的方式，因为xml和注解是两种完全不同的方式去创建demo 的对象，所以我们通过适配器找到如果你是xml，我去解析xml文件；如果是注解，就去分析注解，通过反射拿到注解生成后的对象，两种方式我得找，你是哪种方式进行的对象的创建，最后构建出来的就是demo 的对象，就是我们的controller，然后在HandlerAdapter里面会有数据绑定，包括数据转化，数据格式化，数据验证，然后当我们拿到demo的action的时候，你会发现它里面提交的数据已经自动注入成功了，然后到了生成的对象handler，这里面又再去调用业务逻辑层，数据访问层，然后将数据返回业务逻辑层，然后返回到我们的控制器，也就是回到handler这，然后最后的这些数据回去，就是到达了ModelAndView的这个封装，回到DispatcherServlet，但是更多的跳转是String，回来的String就是目标资源的地址，然后DispatcherServlet拿到String 的返回值，比如说是main，然后它又调用下一个小帮手：ViewResolver，然后让ViewResolver进行返回路径的拼接，给的是一个main，但是会拼成/admin/main.jsp，拼好之后再返回DispatcherServlet，这时候View才会带上数据最终将响应的结果返回到客户端。

![image-20220809073704090](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220809073704090.png)



## 10.< mvc:annotation-driven/>标签的使用

```
<mvc:annotation-driven/>会自动注册两个bean，分别为DefaultAnnotationHandlerMapping和AnnotationMethodHandlerAdapter。是springmvc为@controller分发请求所必须的。除了注册了这两个bean，还提供了很多支持。
1）支持使用ConversionService 实例对表单参数进行类型转换；
 2）支持使用 @NumberFormat 、@DateTimeFormat；
 3）注解完成数据类型的格式化；
 4）支持使用 @RequestBody 和 @ResponseBody 注解；
 5）静态资源的分流也使用这个标签;
```



## 11.资源在WEB-INF目录下

```java
  此目录下的动态资源,不可直接访问,只能通过请求转发的方式进行访问 .
  @Controller
	public class WebInfAction {
	    @RequestMapping("/showIndex")
	    public String showIndex(){
	        System.out.println("访问index.jsp");
	        return "index";
	    }
	    @RequestMapping("/showMain")
	    public String showMain(){
	        System.out.println("访问main.jsp");
	        return "main";
	    }
	    @RequestMapping("/showLogin")
	    public String showLogin(){
	        System.out.println("访问login.jsp");
	        return "login";
	    }
	    //登录的业务判断
	    @RequestMapping("/login")
	    public String login(String name, String pwd, HttpServletRequest request){
	        if("zar".equalsIgnoreCase(name) && "123".equalsIgnoreCase(pwd)){
	            return "main";
	        }else{
	            request.setAttribute("msg","用户名或密码不正确!");
	            return "login";
	        }
	    }
	}
```







# 第三章 SpringMVC拦截器

## 1.什么是拦截器

```
针对请求和响应进行额外的处理。在请求和响应的过程中添加预处理、后处理和最终处理。
```



## 2.拦截器执行的时机

```
1）preHandle():在请求被处理之前操作。预处理
2）postHandle():在请求被处理之后，但结果还没有渲染前进行操作，可以改变响应结果。后处理
3）afterCompletion():所有的请求响应结束后执行善后工作，清理对象，关闭资源。	最终处理
```



## 3.拦截器实现的两种方式

```
1）继承HandlerInterceptionAdapter的父类。
2）实现HandlerInterception接口。  
		推荐使用实现接口的方式
```

## 4.拦截器实现的步骤

```java
1）改造登录方法，在session中存储用户信息，用于进行权限验证
2）开发拦截器的功能，实现HandlerInterception接口，重写preHandle()方法
    public class LoginInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            //是否登录过的判断
            if(request.getSession().getAttribute("users")==null){
                //此时就是没有登录，打回到登录页面，并给出提示
                request.setAttribute("msg","您还没有登录，请先去登录");
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
                return false;
            }
            return true;//放行请求
        }
    }
3）在springmvc.xml文件中注册拦截器
    <!--注册拦截器-->
    <mvc:interceptors>
        <mvc:interceptor>
            <!--mapping这里是映射要拦截的请求-->
            <mvc:mapping path="/**"/>
            <!--设置放行的请求-->
            <mvc:exclude-mapping path="/showLogin"></mvc:exclude-mapping>
            <mvc:exclude-mapping path="/login"></mvc:exclude-mapping>
            <!--配置具体的拦截器实现功能的类-->
            <bean class="com.bjpowernode.interceptor.LoginInterceptor"></bean>
        </mvc:interceptor>
    </mvc:interceptors>
```







# 第四章 SSM整合

## 1.SSM整合的步骤

```
0）建库，建表
1）新建Maven项目，选择webapp模板
2）修改目录
3）修改pom.xml文件（使用老师提供）
4）添加jdbc.properties属性文件
5）添加SqlMapConfig.xml文件（使用模板）
6）添加applicationContext_mapper.xml(数据访问层的核心配置文件)
7）添加applicationContext_service.xml(业务逻辑层的核心配置文件)
8）添加springmvc.xml文件
9）删除web.xml文件，新建，改名设置中文编码，并注册springmvc框架，并注册Spirng框架
10）新建实体类User
11）新建UserMapper.java接口
12）新建UserMapper.xml实现增删查所有功能，没有更新
13）新建service接口和实现类
14）新建测试类，完成所有功能的测试（myTest.java)  
	如果逻辑足够复杂，每一层写完都要测完再写下一层
15）新建界面层（控制器controller），完成所有功能
16）浏览器测试功能
```

## 2.SSM整合步骤中各个配置文件模板（基于springmvc_006_ssm)

>4) jdbc.properties

```properties
jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssmuser?useUnicode=true&characterEncoding=utf8
jdbc.username=root
jdbc.password=123456
```

>5)SqlMapConfig.xml(使用模板)

```xml
    <!--设置日志输出语句,显示相应操作的sql语名-->
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
```

>6)applicationContext_mapper.xml (数据访问层的核心文件)

```xml
    <!--读取属性文件-->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
    <!--配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driverClassName}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
    <!--配置SqlSessionFactoryBean-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--配置数据源-->
        <property name="dataSource" ref="dataSource"></property>
        <!--配置SqlMapConfig.xml核心配置-->
        <property name="configLocation" value="classpath:SqlMapConfig.xml"></property>
        <!--注册实体类-->
        <property name="typeAliasesPackage" value="com.bjpowernode.pojo"></property>
    </bean>
    <!--注册mapper.xml文件-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.bjpowernode.mapper"></property>
    </bean>

```

>7)applicationContext_service.xml(业务逻辑层的核心文件)

```xml
    <!--添加包扫描-->
    <context:component-scan base-package="com.bjpowernode.service.impl"></context:component-scan>
    <!--添加事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!--切记切记：配置数据源-->
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <!--配置事务切面-->
    <tx:advice id="myadvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="*select*" read-only="true"/>
            <tx:method name="*find*" read-only="true"/>
            <tx:method name="*search*" read-only="true"/>
            <tx:method name="*get*" read-only="true"/>
            <tx:method name="*insert*" propagation="REQUIRED"/>
            <tx:method name="*add*" propagation="REQUIRED"/>
            <tx:method name="*save*" propagation="REQUIRED"/>
            <tx:method name="*set*" propagation="REQUIRED"/>
            <tx:method name="*update*" propagation="REQUIRED"/>
            <tx:method name="*change*" propagation="REQUIRED"/>
            <tx:method name="*modify*" propagation="REQUIRED"/>
            <tx:method name="*delete*" propagation="REQUIRED"/>
            <tx:method name="*drop*" propagation="REQUIRED"/>
            <tx:method name="*remove*" propagation="REQUIRED"/>
            <tx:method name="*clear*" propagation="REQUIRED"/>
            <tx:method name="*" propagation="SUPPORTS"/>
        </tx:attributes>
    </tx:advice>
    <!--配置切入点+绑定-->
    <aop:config>
        <aop:pointcut id="mycut" expression="execution(* com.bjpowernode.service.impl.*.*(..))"></aop:pointcut>
        <aop:advisor advice-ref="myadvice" pointcut-ref="mycut"></aop:advisor>
    </aop:config>
```

>8)springmvc.xml文件

```xml
    <!--添加包扫描-->
    <context:component-scan base-package="com.bjpowernode.controller"></context:component-scan>
    <!--添加注解驱动-->
    <mvc:annotation-driven></mvc:annotation-driven>
    <!--因为本项目全部是ajax请求，所以不需要配置视图解析器(viewResolver)-->
```

> 9）web.xml文件

```xml
    <!--
        添加中文编码过滤器
    private String encoding;
    private boolean forceRequestEncoding;
    private boolean forceResponseEncoding;

    -->
    <filter>
        <filter-name>encode</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceRequestEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
        <init-param>
            <param-name>forceResponseEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encode</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    
    <!--注册SpringMVC框架-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    
    <!--注册Spring框架,目的就是启动Spring容器-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext_*.xml</param-value>
    </context-param>
```



> 14）myTest.java

```
java.lang.Exception: No runnable methods 解决方案
有可能是测试方法头上没有加@Test
```

```java
@RunWith(SpringJUnit4ClassRunner.class)  //启动spring的容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml",
        "classpath:applicationContext_service.xml"})
public class MyTest {
    @Autowired
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> list = userService.selectUserPage("三","男",0);
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testCreateUser(){
        User u = new User("1","身份证","11","zy","男","22","学生");
        int num = userService.createUser(u);
        System.out.println(num);
    }

    @Test
    public void testDeleteUserById(){
        int num = userService.deleteUserById("15968162087363060");
        System.out.println(num);
    }

    @Test
    public void testGetRowCount(){
        int num = userService.getRowCount(null,"女");
        System.out.println(num);

    }
}
```

```
没有写前端如何测试controller？
打开tomcat之后输入http://localhost:8080/user/selectUserPage
地址后面的详细情况是统一user，因为在controller的类头上写了@RequestMapping("/user")
然后user之后就是每个方法头上写的对应的@RequestMapping("/xxx")
比如这个方法头上的是：@RequestMapping("/selectUserPage")

	@RequestMapping("/selectUserPage")
    @ResponseBody  //ajax请求的注解
    public List<User> selectUserPage(String userName,String userSex,Integer page){
那么/user后面就写/selectUserPage

其他controller里的方法测试依此类推。

```



## 3.跨域访问（后端）

在controller的类上写一个注解@CrossOrigin 表示后端在服务器端支持跨域访问，然后把tomcat的配置的HTTP端口改成8082，因为vue在服务器的端口就是8082







## 4.SSM整合后端（p70-p83)

### 4.1 cmd命令行构建vue项目

>构建步骤

```
使用命令行进入到当前要运行的vue的项目的目录下,运行以下命令进行项目搭建.
cd E:\idea_workspace\vuedemo01 进入到当前项目的目录下
npm i element -ui -S 下载elementUI的框架
npm install //打包项目
npm install --save vue-axios //下载跨域访问组件axios
```

>构建结果

```
C:\Users\Nicolasbruno>d:

D:\>cd D:\vuedemo01

D:\vuedemo01>npm i element -ui -S
npm WARN read-shrinkwrap This version of npm is compatible with lockfileVersion@1, but package-lock.json was generated for lockfileVersion@2. I'll try to do my best with it!
npm WARN ajv-keywords@2.1.1 requires a peer of ajv@^5.0.0 but none is installed. You must install peer dependencies yourself.
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.13 (node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.13: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@2.3.2 (node_modules\chokidar\node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@2.3.2: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})

+ element@0.1.4
added 9 packages from 11 contributors, updated 1 package and audited 1851 packages in 24.242s

57 packages are looking for funding
  run `npm fund` for details

found 184 vulnerabilities (19 low, 76 moderate, 63 high, 26 critical)
  run `npm audit fix` to fix them, or `npm audit` for details

D:\vuedemo01>npm install
npm WARN ajv-keywords@2.1.1 requires a peer of ajv@^5.0.0 but none is installed. You must install peer dependencies yourself.
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@2.3.2 (node_modules\chokidar\node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@2.3.2: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.13 (node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.13: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})

audited 1851 packages in 7.337s

57 packages are looking for funding
  run `npm fund` for details

found 184 vulnerabilities (19 low, 76 moderate, 63 high, 26 critical)
  run `npm audit fix` to fix them, or `npm audit` for details

D:\vuedemo01>npm install --save vue-axios
npm WARN ajv-keywords@2.1.1 requires a peer of ajv@^5.0.0 but none is installed. You must install peer dependencies yourself.
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@2.3.2 (node_modules\chokidar\node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@2.3.2: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.13 (node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.13: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})

+ vue-axios@3.4.1
updated 1 package and audited 1851 packages in 10.534s

57 packages are looking for funding
  run `npm fund` for details

found 184 vulnerabilities (19 low, 76 moderate, 63 high, 26 critical)
  run `npm audit fix` to fix them, or `npm audit` for details
```

### 4.2 为idea添加vue插件

这个在后端项目的idea里添加就可以

![image-20220809221529078](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220809221529078.png)



### 4.3 配置启动项

这个就是在新的打开的前端项目的idea里面添加配置，同时后端打开的idea项目不要关掉。

![image-20220809221636229](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220809221636229.png)

### 4.4 vue项目结构

![image-20220809221818090](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220809221818090.png)



vue项目结构解析：

```
Vue.prototype.$axios = axios   // axios这个就是用来跨域访问，没有别的作用
Vue.prototype.qs = qs    //qs就是把给的串自动转为json
```



```
build 	项目构建(webpack)相关代码
config 	配置目录，包括端口号等。我们初学可以使用默认的。
node_modules 	npm 加载的项目依赖模块
src 	
这里是我们要开发的目录，基本上要做的事情都在这个目录里。里面包含了几个目录及文件：
    assets: 放置一些图片，如logo等。
    components: 目录里面放了一个组件文件，可以不用。
    App.vue: 项目入口文件，我们也可以直接将组件写这里，而不使用 components 目录。
    main.js: 项目的核心文件。

static 	静态资源目录，如图片、字体等。
test 	初始测试目录，可删除
.xxxx文件 	这些是一些配置文件，包括语法配置，git配置等。
index.html 	首页入口文件，你可以添加一些 meta 信息或统计代码啥的。
package.json 	项目配置文件。
README.md 	项目的说明文档，markdown 格式


(6)UserHome.vue解读
UserHome.vue是所有功能实现的组件.与后台跨域访问,分页显示数据,并实现增加,按主键删除,批量删除,更新,多条件查询等功能.
A.首先确定钩子函数中的启动访问函数
	  created() {
	    this.handlePageChange();           ===>分页
	    this.getRowCount();                ===>计算总行数
	  }
B.分页函数解析
		 handlePageChange() {
		 //定义变量,封装将要提交的数据
	     let postData=this.qs.stringify({
	        page:this.currentPage,
	        userName:this.formInline.search1,
	        userSex:this.formInline.search2
	      });
	      this.$axios({                    ==>发出跨域访问的请求,参考$.ajax();
	        method:'post',                 ==>请求提交的方式
	        url:'/api/user/selectUserPage',==>服务器的地址
	        data:postData  //this.qs.stringify==>{"page":1,"userName":"","userSex":""}                               ==>提交的数据
	      }).then(response=>{              ==>成功后进入到这里
	        this.tableData=response.data;  ==>数据绑定,返回的5个用户的json数据,一下子绑定给表格
	      }).catch(error=>{                ==>出错了进入到这里
	        console.log(error);
	      })
	    }
 C.计算总行数函数分析
	      getRowCount() {
	      //创建变量,提取文本框和下拉列表框中的数据
	      let postData=this.qs.stringify({
	        userName:this.formInline.search1,
	        userSex:this.formInline.search2
	      });
	      this.$axios({                  ==>发出跨域访问的请求,参考$.ajax();
	        method:'post',               ==>请求提交的方式
	        url:'/api/user/getRowCount', ==>服务器的地址
	        data:postData                ===>提交的数据
	      }).then(response=>{
	        this.total=response.data;    ==>返回的总行数赋值给变量total
	      }).catch(error=>{
	        console.log(error);
	      })
	    },
D.按主键删除分析
	  //弹出提示框,让用户确定是否删除 
      this.$confirm('删除操作, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'                      ==>黄色的警告图标
      }).then(() => {                        ==>用户点击确定后进入到这里
        let postData = this.qs.stringify({   ==>封装成JSON数据格式
          userId: row.userId,                ==>将要提交的主键值
        });
        this.$axios({                      ==>发出跨域访问的请求,参考$.ajax();
          method: 'post',                    ==>请求提交的方式
          url: '/api/user/deleteUserById',
          data: postData  //{"userId":15968162893439470}
        }).then(response => {                ==>跨域请求成功后进入这里
          this.getRowCount();     ==>计算删除后的总行数,进行分页插件的页码变化
          ...
          this.handlePageChange();            ==>删除后重新分页
          this.$message({                     ==>删除成功后弹框
            type: 'success',
            message: '删除成功!'
          });          
        }).catch(error => {
          console.log(error);
        });

      }).catch(() => {                        ===>用户点击取消后进入到这里
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
```



















# 只需要写完spring_006_ssm那些后端代码，一个jsp都不用写，再把vue的项目构建出来，那就可以在浏览器上显示一个好看的实现完全后端功能的界面。这就是前后端分离

















