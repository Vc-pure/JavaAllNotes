SpringBoot

# 第一章 SpringBoot简介

## 回顾什么是Spring

Spring是一个开源框架，2003 年兴起的一个轻量级的Java 开发框架，作者：Rod Johnson  。

**Spring是为了解决企业级应用开发的复杂性而创建的，简化开发。**



## 了解微服务

分布式架构会遇到的四个核心问题：

1. 这么多服务，客户端该如何去访问？
2. 这么多服务，服务之间该如何进行通信？
3. 这么多服务，如何治理呢？
4. 服务挂了，该怎么办？

解决方案：

​	SpringCloud，是一套生态，就是用来解决以上分布式架构的4个问题

​	想使用Springcloud，必须要掌握SpringBoot，因为SpringCloud是基于Springboot的



![image-20220829073627790](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220829073627790.png)

![image-20220829074049550](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220829074049550.png)

![image-20220829074126211](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220829074126211.png)

![image-20220829074308886](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220829074308886.png)

![image-20220829074422587](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220829074422587.png)

![image-20220829074528666](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220829074528666.png)



**程序猿，不要停下学习的脚步**



## Spring是如何简化Java开发的

为了降低Java开发的复杂性，Spring采用了以下4种关键策略：

1、基于POJO的轻量级和最小侵入性编程，所有东西都是bean；

2、通过IOC，依赖注入（DI）和面向接口实现松耦合；

3、基于切面（AOP）和惯例进行声明式编程；

4、通过切面和模版减少样式代码，RedisTemplate，xxxTemplate；



## 什么是SpringBoot

学过javaweb的同学就知道，开发一个web应用，从最初开始接触Servlet结合Tomcat, 跑出一个Hello Wolrld程序，是要经历特别多的步骤；后来就用了框架Struts，再后来是SpringMVC，到了现在的SpringBoot，过一两年又会有其他web框架出现；你们有经历过框架不断的演进，然后自己开发项目所有的技术也在不断的变化、改造吗？建议都可以去经历一遍；

言归正传，什么是SpringBoot呢，就是一个javaweb的开发框架，和SpringMVC类似，对比其他javaweb框架的好处，官方说是简化开发，约定大于配置，  you can "just run"，能迅速的开发web应用，几行代码开发一个http接口。

所有的技术框架的发展似乎都遵循了一条主线规律：从一个复杂应用场景 衍生 一种规范框架，人们只需要进行各种配置而不需要自己去实现它，这时候强大的配置功能成了优点；发展到一定程度之后，人们根据实际生产应用情况，选取其中实用功能和设计精华，重构出一些轻量级的框架；之后为了提高开发效率，嫌弃原先的各类配置过于麻烦，于是开始提倡“约定大于配置”，进而衍生出一些一站式的解决方案。

是的这就是Java企业级应用->J2EE->spring->springboot的过程。

随着 Spring 不断的发展，涉及的领域越来越多，项目整合开发需要配合各种各样的文件，慢慢变得不那么易用简单，违背了最初的理念，甚至人称配置地狱。Spring Boot 正是在这样的一个背景下被抽象出来的开发框架，目的为了让大家更容易的使用 Spring 、更容易的集成各种常用的中间件、开源软件；

Spring Boot 基于 Spring 开发，Spirng Boot 本身并不提供 Spring 框架的核心特性以及扩展功能，只是用于快速、敏捷地开发新一代基于 Spring 框架的应用程序。也就是说，它并不是用来替代 Spring 的解决方案，而是和 Spring 框架紧密结合用于提升 Spring 开发者体验的工具。Spring Boot 以**约定大于配置的核心思想**，默认帮我们进行了很多设置，多数 Spring Boot 应用只需要很少的 Spring 配置。同时它集成了大量常用的第三方库配置（例如 Redis、MongoDB、Jpa、RabbitMQ、Quartz 等等），Spring Boot 应用中这些第三方库几乎可以零配置的开箱即用。

简单来说就是SpringBoot其实不是什么新的框架，它默认配置了很多框架的使用方式，就像maven整合了所有的jar包，spring boot整合了所有的框架 。

Spring Boot 出生名门，从一开始就站在一个比较高的起点，又经过这几年的发展，生态足够完善，Spring Boot 已经当之无愧成为 Java 领域最热门的技术。

**Spring Boot的主要优点：**

- 为所有Spring开发者更快的入门
- **开箱即用**，提供各种默认配置来简化项目配置
- 内嵌式容器简化Web项目
- 没有冗余代码生成和XML配置的要求



# 第二章 第一个Springboot程序：hello world

## 准备工作

我们将学习如何快速的创建一个Spring Boot应用，并且实现一个简单的Http请求处理。通过这个例子对Spring Boot有一个初步的了解，并体验其结构简单、开发快速的特性。

我的环境准备：

- java version "1.8.0_181"
- Maven-3.6.1
- SpringBoot 2.x 最新版

开发工具：

- IDEA

  

## 创建基础项目说明

Spring官方提供了非常方便的工具让我们快速构建应用

Spring Initializr：https://start.spring.io/

**项目创建方式一：**使用Spring Initializr 的 Web页面创建项目

1、打开  https://start.spring.io/

2、填写项目信息

3、点击”Generate Project“按钮生成项目；下载此项目

4、解压项目包，并用IDEA以Maven项目导入，一路下一步即可，直到项目导入完毕。

5、如果是第一次使用，可能速度会比较慢，包比较多、需要耐心等待一切就绪。



**项目创建方式二：**使用 IDEA 直接创建项目

1、创建一个新项目

2、选择spring initalizr ， 可以看到默认就是去官网的快速构建工具那里实现

3、填写项目信息

4、选择初始化的组件（初学勾选 Web 即可）

5、填写项目路径

6、等待项目构建成功



**项目结构分析：**

通过上面步骤完成了基础项目的创建。就会自动生成以下文件。

1、程序的主启动类

2、一个 application.properties 配置文件

3、一个 测试类

4、一个 pom.xml



## pom.xml 分析

打开pom.xml，看看Spring Boot项目的依赖：

```xml
<!-- 父依赖 -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.7.3</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

<dependencies>
    <!-- web场景启动器 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!--spring-boot-starter：所有的springboot依赖都是使用这个开头的-->
    <!-- springboot单元测试 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
        <!-- 剔除依赖 -->
        <exclusions>
            <exclusion>
                <groupId>org.junit.vintage</groupId>
                <artifactId>junit-vintage-engine</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>

<build>
    <plugins>
        <!-- 打包插件（打jar包） -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

- ![image-20220818231353681](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220818231353681.png)
- 

## 编写一个http接口

1、在主程序的同级目录下，新建一个controller包，一定要在同级目录下，否则识别不到

2、在包中新建一个HelloController类

```java
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    
}
```

3、编写完毕后，从主程序启动项目，浏览器发起请求，看页面返回；控制台输出了 Tomcat 访问的端口号！

![image-20220818230928391](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220818230928391.png)

简单几步，就完成了一个web接口的开发，SpringBoot就是这么简单。所以我们常用它来建立我们的微服务项目！



## 将项目打成jar包，点击 maven的 package

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7L1vFQMnaRIJSmeZ58T2eZiczfno2TOQbfItia25xQzicMFnkicKh5pVD7IrHrUicb03y381CicrLFKXNMw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

如果遇到以上错误，可以配置打包时 跳过项目运行测试用例

```xml
<!--
    在工作中,很多情况下我们打包是不想执行测试用例的
    可能是测试用例不完事,或是测试用例会影响数据库数据
    跳过测试用例执
    -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <configuration>
        <!--跳过项目运行测试用例-->
        <skipTests>true</skipTests>
    </configuration>
</plugin>
```

如果打包成功，则会在target目录下生成一个 jar 包

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7L1vFQMnaRIJSmeZ58T2eZic03vupvIqMbibWh4aIKyjiaQfwuvDWKo033g9kRvj6aXnJO4brKTdwnvA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



打成了jar包后，就可以在任何地方运行了！OK



**彩蛋**



如何更改启动时显示的字符拼成的字母，SpringBoot呢？也就是 banner 图案；

只需一步：到项目下的 resources 目录下新建一个banner.txt 即可。

图案可以到：https://www.bootschool.net/ascii 这个网站生成，然后拷贝到文件中即可！

![image-20220819073034726](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220819073034726.png)



# 第三章 运行原理探究

自动配置：

我们之前写的HelloSpringBoot，到底是怎么运行的呢，Maven项目，我们一般从pom.xml文件探究起；

## **pom.xml**

### 父依赖	

其中它主要是依赖一个父项目，主要是管理项目的资源过滤及插件！

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.7.3</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

点进去，发现还有一个父依赖

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.7.3</version>
    <relativePath>../../spring-boot-dependencies</relativePath>
</parent>
```

这里才是真正管理SpringBoot应用里面所有依赖版本的地方，SpringBoot的版本控制中心；

**以后我们导入依赖默认不需要指定版本；但是如果导入的包没有在依赖中管理着就需要手动配置版本了；**



### 启动器 spring-boot-starter

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

**springboot-boot-starter-xxx**：就是spring-boot的场景启动器

**spring-boot-starter-web**：帮我们导入了web模块正常运行所依赖的组件；

SpringBoot将所有的功能场景都抽取出来，做成一个个的starter （启动器），只需要在项目中引入这些starter即可，所有相关的依赖都会导入进来 ， 我们要用什么功能就导入什么样的场景启动器即可 ；我们未来也可以自定义 ’starter‘；



## **主程序**

分析完了 pom.xml 来看看这个启动类

### 默认的主启动类

```java
//@SpringBootApplication ：标注一个主程序类，说明这个类是一个springboot的应用
@SpringBootApplication
public class Springboot01HelloworldApplication {

    public static void main(String[] args) {
        //将springboot应用启动，以为是启动了一个方法，没想到启动了一个服务
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }
}
```

但是**一个简单的启动类并不简单！**我们来分析一下这些注解都干了什么

-  注解

  - ```
    @SpringBootApplication：springboot的配置
    	@Configuration：spring的配置类
    	@Component：说明这也是一个spring的组件
    ```


### @SpringBootApplication

作用：标注在某个类上说明这个类是SpringBoot的主配置类 ， SpringBoot就应该运行这个类的main方法来启动SpringBoot应用；

进入这个注解：可以看到上面还有很多其他注解！

```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
    // ......
}
```



### @ComponentScan

这个注解在Spring中很重要 ,它对应XML配置中的元素。

作用：自动扫描并加载符合条件的组件或者bean ， 将这个bean定义加载到IOC容器中



### @SpringBootConfiguration

作用：SpringBoot的配置类 ，标注在某个类上 ， 表示这是一个SpringBoot的配置类；

我们继续进去这个注解查看

```java
// 点进去得到下面的 @Component
@Configuration
public @interface SpringBootConfiguration {}

@Component
public @interface Configuration {}
```

这里的 @Configuration，说明这是一个配置类 ，配置类就是对应Spring的xml 配置文件；

里面的 @Component 这就说明，启动类本身也是Spring中的一个组件而已，负责启动应用！

我们回到 SpringBootApplication 注解中继续看。





### @EnableAutoConfiguration

**@EnableAutoConfiguration ：开启自动配置功能**

以前我们需要自己配置的东西，而现在SpringBoot可以自动帮我们配置 ；@EnableAutoConfiguration告诉SpringBoot开启自动配置功能，这样自动配置才能生效；

点进注解接续查看：

**@AutoConfigurationPackage ：自动配置包**

```java
@Import({Registrar.class})
public @interface AutoConfigurationPackage {
}
```

**@import** ：Spring底层注解@import ， 给容器中导入一个组件

Registrar.class 作用：将主启动类的所在包及包下面所有子包里面的所有组件扫描到Spring容器 ；

这个分析完了，退到上一步，继续看

**@Import({AutoConfigurationImportSelector.class}) ：给容器导入组件 ；**

AutoConfigurationImportSelector ：自动配置导入选择器，那么它会导入哪些组件的选择器呢？我们点击去这个类看源码：

1、这个类中有一个这样的方法

```java
// 获得候选的配置
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
    //这里的getSpringFactoriesLoaderFactoryClass（）方法
    //返回的就是我们最开始看的启动自动导入配置文件的注解类；EnableAutoConfiguration
    List<String> configurations = SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
    Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
    return configurations;
}
```

2、这个方法又调用了  SpringFactoriesLoader 类的静态方法！我们进入SpringFactoriesLoader类loadFactoryNames() 方法

```java
public static List<String> loadFactoryNames(Class<?> factoryClass, @Nullable ClassLoader classLoader) {
    String factoryClassName = factoryClass.getName();
    //这里它又调用了 loadSpringFactories 方法
    return (List)loadSpringFactories(classLoader).getOrDefault(factoryClassName, Collections.emptyList());
}
```

3、我们继续点击查看 loadSpringFactories 方法

```java
private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
    //获得classLoader ， 我们返回可以看到这里得到的就是EnableAutoConfiguration标注的类本身
    MultiValueMap<String, String> result = (MultiValueMap)cache.get(classLoader);
    if (result != null) {
        return result;
    } else {
        try {
            //去获取一个资源 "META-INF/spring.factories"
            Enumeration<URL> urls = classLoader != null ? classLoader.getResources("META-INF/spring.factories") : ClassLoader.getSystemResources("META-INF/spring.factories");
            LinkedMultiValueMap result = new LinkedMultiValueMap();

            //将读取到的资源遍历，封装成为一个Properties
            while(urls.hasMoreElements()) {
                URL url = (URL)urls.nextElement();
                UrlResource resource = new UrlResource(url);
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                Iterator var6 = properties.entrySet().iterator();

                while(var6.hasNext()) {
                    Entry<?, ?> entry = (Entry)var6.next();
                    String factoryClassName = ((String)entry.getKey()).trim();
                    String[] var9 = StringUtils.commaDelimitedListToStringArray((String)entry.getValue());
                    int var10 = var9.length;

                    for(int var11 = 0; var11 < var10; ++var11) {
                        String factoryName = var9[var11];
                        result.add(factoryClassName, factoryName.trim());
                     }
                }
            }

            cache.put(classLoader, result);
            return result;
        } catch (IOException var13) {
            throw new IllegalArgumentException("Unable to load factories from location [META-INF/spring.factories]", var13);
        }
    }
}
```

4、发现一个多次出现的文件：spring.factories（核心配置文件），

![image-20220820150532037](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220820150532037.png)

全局搜索它

### spring.factories

我们根据源头打开spring.factories ， 看到了很多自动配置的文件；这就是自动配置根源所在！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7L1vFQMnaRIJSmeZ58T2eZicEIZDCZKtTPxQrKTvEdxHFGsG824OkO8XN8CfP2x4OdpC8DwjHYwcFw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

```
Properties properties = PropertiesLoaderUtils.loadProperties(resource);
所有资源加载到配置类中！
```



**WebMvcAutoConfiguration**

我们在上面的自动配置类随便找一个打开看看，比如 ：WebMvcAutoConfiguration

可以看到这些一个个的都是JavaConfig配置类，而且都注入了一些Bean，可以找一些自己认识的类，看着熟悉一下！

所以，自动配置真正实现是从classpath中搜寻所有的META-INF/spring.factories配置文件 ，并将其中对应的 org.springframework.boot.autoconfigure. 包下的配置项，通过反射实例化为对应标注了 @Configuration的JavaConfig形式的IOC容器配置类 ， 然后将这些都汇总成为一个实例并加载到IOC容器中。

### **结论：**

1. SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值
2. 将这些值作为自动配置类导入容器 ， 自动配置类就生效 ， 帮我们进行自动配置工作；
3. 以前需要我们自动配置的东西，现在springboot帮我们做了。
4. 整个J2EE的整体解决方案和自动配置都在springboot-autoconfigure的jar包中；
5. 它会把所有需要导入的组件，以类名的方式返回，这些组件就会被添加到容器
6. 它会给容器中导入非常多的自动配置类 （xxxAutoConfiguration）的文件（@Bean）, 就是给容器中导入这个场景需要的所有组件 ， 并自动配置好这些组件 ； 
7. 有了自动配置类 ， 免去了我们手动编写配置注入功能组件等的工作； 

 

结论的结论：springboot所有自动配置都是在启动的时候扫描并加载`spring.factories`，所有的自动配置类都在这里面，但是不一定生效，要判断条件是否成立，只要导入了对应的start，就有对应的启动器了，有了启动器，我们自动装配就会生效，然后就配置成功了。

**现在大家应该大概的了解了下，SpringBoot的运行原理，后面我们还会深化一次！**

## 在讲完以后跟着以上流程自己去源码里面走一遍，看不懂就把源码粘出来，写上注释，然后写思维导图走一遍就好了。





> **SpringApplication**

## 了解下主启动类怎么运行

## 不简单的方法（SpringApplication.run()）

我最初以为就是运行了一个main方法，没想到却开启了一个服务；

```java
@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
```

**SpringApplication.run分析**

分析该方法主要分两部分，一部分是SpringApplication的实例化，二是run方法的执行；

### **SpringApplication**

**这个类主要做了以下四件事情：**

1、推断应用的类型是普通的项目还是Web项目（※）

2、查找并加载所有可用初始化器 ， 设置到initializers属性中

3、找出所有的应用程序监听器，设置到listeners属性中

4、推断并设置main方法的定义类，找到运行的主类（※）

查看构造器：

```java
public SpringApplication(ResourceLoader resourceLoader, Class... primarySources) {
    // ......
    this.webApplicationType = WebApplicationType.deduceFromClasspath();
    this.setInitializers(this.getSpringFactoriesInstances();
    this.setListeners(this.getSpringFactoriesInstances(ApplicationListener.class));
    this.mainApplicationClass = this.deduceMainApplicationClass();
}
```

### run方法

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7L1vFQMnaRIJSmeZ58T2eZicjafiawQLp9u8wc4ic1Mjy6OyfibzfjVofeL5pnS1NSFKVjlIg6neI9ySg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



跟着源码和这幅图就可以一探究竟了！

关于springboot，谈谈你的理解：

- 自动装配
- run()方法
  - 推断应用的类型是普通java项目还是web项目，如果是web项目可以一直启动，如果是普通java项目就直接跪了
  - 推断当前的主类（main）
  - run方法里有一些监听器（监听器是全局存在的），获取上下文去处理我们的一些bean
  - ...







# 第四章 SpringBoot配置

## yaml语法学习

### 配置文件

SpringBoot使用一个全局的配置文件 ， 配置文件名称是固定的

- application.properties

- - 语法结构 ：key=value

- application.yml

- - 语法结构 ：key：空格 value

**配置文件的作用 ：**修改SpringBoot自动配置的默认值，因为SpringBoot在底层都给我们自动配置好了；

比如我们可以在配置文件中修改Tomcat 默认启动的端口号！测试一下！

```
server.port=8081
```



### yaml概述

YAML是 "YAML Ain't a Markup Language" （YAML不是一种标记语言）的递归缩写。在开发的这种语言时，YAML 的意思其实是："Yet Another Markup Language"（仍是一种标记语言）

**这种语言以数据****作****为中心，而不是以标记语言为重点！**

以前的配置文件，大多数都是使用xml来配置；比如一个简单的端口配置，我们来对比下yaml和xml

传统xml配置：

```xml
<server>
    <port>8081<port>
</server>
```

yaml配置：

```yaml
server：
  prot: 8080
```



### yaml基础语法

说明：语法要求严格！

1、空格不能省略

2、以缩进来控制层级关系，只要是左边对齐的一列数据都是同一个层级的。

3、属性和值的大小写都是十分敏感的。

**字面量：普通的值  [ 数字，布尔值，字符串  ]**

字面量直接写在后面就可以 ， 字符串默认不用加上双引号或者单引号；

```
k: v
```

注意：

- “ ” 双引号，不会转义字符串里面的特殊字符 ， 特殊字符会作为本身想表示的意思；

  比如 ：name: "zhong \n yi"  输出 ：zhong  换行  yi

- '' 单引号，会转义特殊字符 ， 特殊字符最终会变成和普通字符一样输出

  比如 ：name: ‘zhong \n yi’  输出 ：zhong  \n  yi

  

**对象、Map（键值对）**

```yaml
#对象、Map格式
k: 
    v1:
    v2:
```

在下一行来写对象的属性和值得关系，注意缩进；比如：

```yaml
student:
    name: zhongyi
    age: 3
```

行内写法：

```yaml
student: {name: zhongyi,age: 3}
```



**数组（ List、set ）**

用 - 值表示数组中的一个元素,比如：

```yaml
pets:
 - cat
 - dog
 - pig
```

行内写法：

```yaml
pets: [cat,dog,pig]
```



**修改SpringBoot的默认端口号**

配置文件中添加，端口号的参数，就可以切换端口；

```yaml
server:
  port: 8082
```





## 注入配置文件

yaml文件更强大的地方在于，他可以给我们的实体类直接注入匹配值！（就是说yaml可以直接给实体类赋值）

### yaml注入配置文件

1、在springboot项目中的resources目录下新建一个文件 application.yml（application.yaml也可以）

2、编写一个实体类 Dog；

```java
@Component  //注册bean到容器中
public class Dog {
    private String name;
    private Integer age;
    
    //有参无参构造、get、set方法、toString()方法  
}
```

3、思考，我们原来是如何给bean注入属性值的！@Value，给狗狗类测试一下：

```java
@Component //注册bean
public class Dog {
    @Value("阿黄")
    private String name;
    @Value("18")
    private Integer age;
}
```

4、在SpringBoot的测试类下注入狗狗输出一下；

```java
@SpringBootTest
class DemoApplicationTests {

    @Autowired //将狗狗自动注入进来
    Dog dog;

    @Test
    public void contextLoads() {
        System.out.println(dog); //打印看下狗狗对象
    }

}
```

结果成功输出，@Value注入成功，这是我们原来的办法.

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtjyIb9NEaYlz0tCWSiboOYUjoO9N8358vr0uTf3KR0FP0C5QOC3uQOIrlcuy7v0jmkXw0PPM4U5w/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



5、我们再编写一个复杂一点的实体类：Person 类

```java
@Component //注册bean到容器中
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
    
    //有参无参构造、get、set方法、toString()方法  
}
```

6、我们来使用yaml配置的方式进行注入，大家写的时候注意区别和优势，我们编写一个yaml配置！

```yaml
person:
  name: zhongyi
  age: 22
  happy: false
  birth: 2000/10/11
  maps: {k1: v1,k2: v2}
  lists:
   - code
   - girl
   - music
  dog:
    name: 旺财
    age: 3
```

7、我们刚才已经把person这个对象的所有值都写好了，我们现在来注入到我们的类中！

```java
/*
@ConfigurationProperties作用：
将配置文件中配置的每一个属性的值，映射到这个组件中；
告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
参数 prefix = “person” : 将配置文件中的person下面的所有属性一一对应
*/
@Component //注册bean
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
```

8、IDEA 提示，springboot配置注解处理器没有找到，让我们看文档，我们可以查看文档，找到一个依赖！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtjyIb9NEaYlz0tCWSiboOYFrPO6PAYI7eQAEVzql1Sfic03AbzpiboQLP9eWo5I2McfQ2dicibIibh0fw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtjyIb9NEaYlz0tCWSiboOYhxNnwKv6bDsrCvMS4OscxxV0EWU7ibUD9G0N164rxEUNfaT9NFTVU4A/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

```xml
<!-- 导入配置文件处理器，配置文件进行绑定就会有提示，需要重启 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
  <optional>true</optional>
</dependency>
```

9、确认以上配置都OK之后，我们去测试类中测试一下：

```java
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    Person person; //将person自动注入进来

    @Test
    public void contextLoads() {
        System.out.println(person); //打印person信息
    }
}
```

结果：所有值全部注入成功！

![image-20220820200303476](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220820200303476.png)



**yaml配置注入到实体类完全OK！**



课堂测试：

1、将配置文件的key 值 和 属性的值设置为不一样，则结果输出为null，注入失败(意思就是Person类的属性如果为lists，那么application.yml文件里的其中一个key值写成不为lists的其他值，那么输出时就会为null)

2、再配置一个person2，然后将 @ConfigurationProperties(prefix = "person2") 指向我们的person2；	





### 加载指定的配置文件

**@PropertySource ：**加载指定的配置文件；

**@configurationProperties**：默认从全局配置文件中获取值；

1、我们去在resources目录下新建一个**person.properties**文件

```properties
name=kuangshen
```

2、然后在我们的代码中指定加载person.properties文件

```java
@PropertySource(value = "classpath:person.properties")
@Component //注册bean
public class Person {

    @Value("${name}")
    private String name;

    ......  
}
```

3、再次输出测试一下：指定配置文件绑定成功！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtjyIb9NEaYlz0tCWSiboOYAyueVvGpddTEkyGqCwbKsJrfQCbkWrZAFdL3ibMwTYhLKE9GclVyQ7A/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



### 配置文件占位符

配置文件还可以编写占位符生成随机数

```yml
person:
  name: zhongyi${random.uuid}
  age: ${random.int}
  happy: false
  birth: 2000/10/11
  maps: {k1: v1,k2: v2}
  hello: happy
  lists:
    - code
    - music
    - girl
  dog:
    name: ${person.hello:hello}_旺财  # 如果冒号前的值存在就让它为这个值 ，如果冒号前的值不存在就写死为冒号后的值hello
    age: 3

```



### 回顾properties配置

我们上面采用的yaml方法都是最简单的方式，开发中最常用的；也是springboot所推荐的！那我们来唠唠其他的实现方式，道理都是相同的；写还是那样写；配置文件除了yml还有我们之前常用的properties ， 我们没有讲，我们来唠唠！

【注意】properties配置文件在写中文的时候，会有乱码 ， 我们需要去IDEA中设置编码格式为UTF-8；

settings-->FileEncodings 中配置；

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtjyIb9NEaYlz0tCWSiboOYAr9nCaBDe8o7JeMWACZicQkicqrVMeiaWFgrTamHjc668RNx4c4z8UcXw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



**测试步骤：**

1、新建一个实体类User

```java
@Component //注册bean
public class User {
    private String name;
    private int age;
    private String sex;
}
```

2、编辑配置文件 user.properties

```properties
user1.name=kuangshen
user1.age=18
user1.sex=男
```

3、我们在User类上使用@Value来进行注入！

```java
@Component //注册bean
@PropertySource(value = "classpath:user.properties")
public class User {
    //直接使用@value
    @Value("${user.name}") //从配置文件中取值
    private String name;
    @Value("#{9*2}")  // #{SPEL} Spring表达式
    private int age;
    @Value("男")  // 字面量
    private String sex;
}
```

4、Springboot测试

```java
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    User user;

    @Test
    public void contextLoads() {
        System.out.println(user);
    }

}
```

结果正常输出：

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtjyIb9NEaYlz0tCWSiboOYxFwDQMxmyVQjVPt794RCuhfVOEbqDrpH2u84DT8y01xAhuQh47AFYA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



### 对比小结

@Value这个使用起来并不友好！我们需要为每个属性单独注解赋值，比较麻烦；我们来看个功能对比图

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtjyIb9NEaYlz0tCWSiboOYjMibiaov73iaTsiaWEPoArDcAB1Ooibx9uR5JxtacIuicHblEtUI9SrySX2A/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



1、@ConfigurationProperties只需要写一次即可 ， @Value则需要每个字段都添加

2、松散绑定：这个什么意思呢? 比如我的yml中写的last-name，这个和lastName是一样的， - 后面跟着的字母默认是大写的。这就是松散绑定。可以测试一下

3、JSR303数据校验 ， 这个就是我们可以在字段是增加一层过滤器验证 ， 可以保证数据的合法性

4、复杂类型封装，yml中可以封装对象 ， 使用value就不支持



**结论：**

配置yml和配置properties都可以获取到值 ， 强烈推荐 yml；

如果我们在某个业务中，只需要获取配置文件中的某个值，可以使用一下 @value；

如果说，我们专门编写了一个JavaBean来和配置文件进行一一映射，就直接@configurationProperties，不要犹豫！





## JSR303数据校验 

### 先看看JSR303如何使用

Springboot中可以用@validated来校验数据，如果数据异常则会统一抛出异常，方便异常中心统一处理。我们这里来写个注解让我们的name只能支持Email格式；

```java
@Component //注册bean
@ConfigurationProperties(prefix = "person")
@Validated  //数据校验
public class Person {

    @Email(message="邮箱格式错误") //name必须是邮箱格式
    private String name;
}
```

运行结果 ：default message [不是一个合法的电子邮件地址];

![image-20220820221302765](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220820221302765.png)

**使用数据校验，可以保证数据的正确性；** 



### JSR303的常见参数

```java
@NotNull(message="名字不能为空")
private String userName;
@Max(value=120,message="年龄最大不能查过120")
private int age;
@Email(message="邮箱格式错误")
private String email;

空检查
@Null       验证对象是否为null
@NotNull    验证对象是否不为null, 无法查检长度为0的字符串
@NotBlank   检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
@NotEmpty   检查约束元素是否为NULL或者是EMPTY.
    
Booelan检查
@AssertTrue     验证 Boolean 对象是否为 true  
@AssertFalse    验证 Boolean 对象是否为 false  
    
长度检查
@Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内  
@Length(min=, max=) string is between min and max included.

日期检查
@Past       验证 Date 和 Calendar 对象是否在当前时间之前  
@Future     验证 Date 和 Calendar 对象是否在当前时间之后  
@Pattern    验证 String 对象是否符合正则表达式的规则  ：正则表达式

.......等等
除此以外，我们还可以自定义一些数据校验规则
```

![image-20220820222013890](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220820222013890.png)





## 多环境切换

profile是Spring对不同环境提供不同配置功能的支持，可以通过激活不同的环境版本，实现快速切换环境；

### 多配置文件

我们在主配置文件编写的时候，文件名可以是 application-{profile}.properties/yml , 用来指定多个环境版本；

**例如：**

application-test.properties 代表测试环境配置

application-dev.properties 代表开发环境配置

但是Springboot并不会直接启动这些配置文件，它**默认使用application.properties主配置文件**；

我们需要通过一个配置来选择需要激活的环境：

```properties
#比如在配置文件中指定使用dev环境，我们可以通过设置不同的端口号进行测试；
#我们启动SpringBoot，就可以看到已经切换到dev下的配置了；
spring.profiles.active=dev
```

### yaml的多文档块

yml的多文档块也就是多环境切换的yaml版本

和properties配置文件中一样，但是使用yml去实现不需要创建多个配置文件，更加方便了 !

```yaml

server:
  port: 8081
#选择要激活那个环境块
spring:
  profiles:
    active: prod

---
server:
  port: 8082
spring:
  profiles: test #配置环境的名称

---
server:
  port: 8083
spring:
  profiles: dev #配置环境的名称


---

server:
  port: 8084
spring:
  profiles: prod  #配置环境的名称
```

**注意：如果yml和properties同时都配置了端口，并且没有激活其他环境 ， 默认会使用properties配置文件的！**



### 配置文件加载位置

**外部加载配置文件的方式十分多，我们选择最常用的即可，在开发的资源文件中进行配置！**

官方外部配置文件说明参考文档

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IPEXZtUAUBhnSZvUmrPzbDUoiazZ6ehegLG4doZK0uSJHribIqwVKiaNibSaYZSgjZf4kGzhLdGrkzzw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



springboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件：

```
优先级1：项目路径下的config文件夹配置文件
优先级2：项目路径下配置文件
优先级3：资源路径下的config文件夹配置文件
优先级4：资源路径下配置文件
```

优先级由高到底，高优先级的配置会覆盖低优先级的配置；

**SpringBoot会从这四个位置全部加载主配置文件；互补配置；**

我们在最低级的配置文件中设置一个项目访问路径的配置来测试互补问题；

```yaml
#配置项目的访问路径
server.servlet.context-path=/kuang
```





# 第五章 自动配置原理再理解

配置文件到底能写什么？怎么写？

SpringBoot官方文档中有大量的配置，我们无法全部记住

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IPEXZtUAUBhnSZvUmrPzbD7ibqw837BhN1F7lHdAMhMmYNCYF2tSdvUGv0y3X48tzetuuYc8tUMLg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



## 分析自动配置原理

我们以**HttpEncodingAutoConfiguration（Http编码自动配置）**为例解释自动配置原理；

```java
//表示这是一个配置类，和以前编写的配置文件一样，也可以给容器中添加组件；
@Configuration 

//启动指定类的ConfigurationProperties功能；
  //自动配置属性：HttpProperties
  //进入这个HttpProperties查看，将配置文件中对应的值和HttpProperties绑定起来；
  //并把HttpProperties加入到ioc容器中
@EnableConfigurationProperties({HttpProperties.class}) 

//Spring底层@Conditional注解：根据不同的条件判断，如果满足指定的条件，整个配置类里面的配置就会生效
//这里的意思就是判断当前应用是否是web应用，如果是，当前配置类生效
@ConditionalOnWebApplication(
    type = Type.SERVLET
)

//这里的意思是判断当前项目有没有这个类CharacterEncodingFilter；SpringMVC中进行乱码解决的过滤器；
@ConditionalOnClass({CharacterEncodingFilter.class})

//判断配置文件中是否存在某个配置：spring.http.encoding.enabled；
  //如果不存在，判断也是成立的
  //即使我们配置文件中不配置pring.http.encoding.enabled=true，也是默认生效的；
@ConditionalOnProperty(
    prefix = "spring.http.encoding",
    value = {"enabled"},
    matchIfMissing = true
) 

public class HttpEncodingAutoConfiguration {
    //他已经和SpringBoot的配置文件映射了
    private final Encoding properties;
    //只有一个有参构造器的情况下，参数的值就会从容器中拿
    public HttpEncodingAutoConfiguration(HttpProperties properties) {
        this.properties = properties.getEncoding();
    }
    
    //给容器中添加一个组件，这个组件的某些值需要从properties中获取
    @Bean
    @ConditionalOnMissingBean //判断容器没有这个组件？
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding(this.properties.getCharset().name());
        filter.setForceRequestEncoding(this.properties.shouldForce(org.springframework.boot.autoconfigure.http.HttpProperties.Encoding.Type.REQUEST));
        filter.setForceResponseEncoding(this.properties.shouldForce(org.springframework.boot.autoconfigure.http.HttpProperties.Encoding.Type.RESPONSE));
        return filter;
    }
    //。。。。。。。
}
```

**一句话总结 ：根据当前不同的条件判断，决定这个配置类是否生效！**

- 一但这个配置类生效；这个配置类就会给容器中添加各种组件；
- 这些组件的属性是从对应的properties类中获取的，这些类里面的每一个属性又是和配置文件绑定的；
- 所有在配置文件中能配置的属性都是在xxxxProperties类中封装着；
- 配置文件能配置什么就可以参照某个功能对应的这个属性类

```java
//从配置文件中获取指定的值和bean的属性进行绑定
@ConfigurationProperties(prefix = "spring.http") 
public class HttpProperties {
    // .....
}
```

我们去配置文件里面试试前缀，看提示！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IPEXZtUAUBhnSZvUmrPzbD4hfI8rrZuGnuFRBjKdaR8mvkyuGfHG1IxBPw0vcTP5LoXIJT9davlA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**这就是自动装配的原理！**

## 精髓

1、SpringBoot启动会加载大量的自动配置类

2、我们看我们需要的功能有没有在SpringBoot默认写好的自动配置类当中；

3、我们再来看这个自动配置类中到底配置了哪些组件；（只要我们要用的组件存在在其中，我们就不需要再手动配置了）

4、给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们只需要在配置文件中指定这些属性的值即可；

**xxxxAutoConfigurartion（在spring.factories中注册）：自动配置类；**给容器中添加组件

**xxxxProperties：封装配置文件中相关属性；** 比如public class WebMvcProperties {里就封装了springmvc的相关属性

​																				而且所有的xxxProperties里都有@ConfigurationProperties(prefix = "") 

如何修改**xxxxProperties里封装的属性呢？说白了就是springboot配置：.yml文件



## 了解：@Conditional

了解完自动装配的原理后，我们来关注一个细节问题，**自动配置类必须在一定的条件下才能生效；**

**@Conditional派生注解（Spring注解版原生的@Conditional作用）**

作用：必须是@Conditional指定的条件成立，才给容器中添加组件，配置配里面的所有内容才生效；

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IPEXZtUAUBhnSZvUmrPzbDGcJRvdK3PtqHPAWYBBmpe1XBVjQJeiatU4vasEaxckHlOga1BV9RPaw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



**那么多的自动配置类，必须在一定的条件下才能生效；也就是说，我们加载了这么多的配置类，但不是所有的都生效了。**

我们怎么知道哪些自动配置类生效？在application.yml里写debug=true然后启动主程序。

**我们可以通过启用 debug=true属性；来让控制台打印自动配置报告，这样我们就可以很方便的知道哪些自动配置类生效；**

```yaml
#开启springboot的调试类，来查看哪些自动配置类生效了，哪些没生效 
debug=true 
```

启动之后的控制台中的结果分析：

**Positive matches:（自动配置类启用的：正匹配）**

**Negative matches:（没有启动，没有匹配成功的自动配置类：负匹配）**

**Unconditional classes: （没有条件的类）**



## 自动装配原理面试题：

```
说说Spring Boot的自动装配

解题思路
得分点 自动装配概念,自动装配流程 标准回答 使用Spring Boot时,我们需要引入对应的Starters,Spring Boot启动时便会自动加载相关依赖,配置相应的初始化参数,以最快捷、简单的形式对第三方软件进行集成,这便是Spring Boot的自动配置功能。 整个自动装配的过程是：Spring Boot通过@EnableAutoConfiguration注解开启自动配置,加载spring.factories中注册的各种AutoConfiguration类,当某个AutoConfiguration类满足其注解@Conditional指定的生效条件（Starters提供的依赖、配置或Spring容器中是否存在某个Bean等）时,实例化该AutoConfiguration类中定义的Bean（组件等）,并注入Spring容器,就可以完成依赖框架的自动配置。 加分回答 @EnableAutoConfiguration 作用 从classpath中搜索所有META-INF/spring.factories配置文件然后,将其中org.springframework.boot.autoconfigure.EnableAutoConfiguration key对应的配置项加载到spring容器 只有spring.boot.enableautoconfiguration为true（默认为true）的时候,才启用自动配置 @EnableAutoConfiguration还可以根据class来排除（exclude）,或是根据class name（excludeName）来排除 其内部实现的关键点有 1. ImportSelector 该接口的方法的返回值都会被纳入到spring容器管理中 2. SpringFactoriesLoader 该类可以从classpath中搜索所有META-INF/spring.factories配置文件,并读取配置
```







# 第六章 SpringBoot Web开发

从这一章往后都是实战部分

思考：spring boot到底帮我们配置了什么？我们能不能进行修改？能修改哪些东西？能不能扩展？

- xxxAutoConfiguration  ： 向容器中自动配置组件
- xxxProperties ： 自动配置类，装配配置文件中自定义的一些内容！



需要解决的问题是：

- 导入静态资源...
- 首页
- jsp，模板引擎Thymeleaf
- 装配和扩展SpringMVC
- 增删改查
- 拦截器
- 国际化！



## **使用SpringBoot的步骤**

1、创建一个SpringBoot应用，选择我们需要的模块，SpringBoot就会默认将我们的需要的模块自动配置好

2、手动在配置文件中配置部分配置项目就可以运行起来了

3、专注编写业务代码，不需要考虑以前那样一大堆的配置了。

要熟悉掌握开发，之前学习的自动配置的原理一定要搞明白！

比如SpringBoot到底帮我们配置了什么？我们能不能修改？我们能修改哪些配置？我们能不能扩展？

- 向容器中自动配置组件 ：*** Autoconfiguration
- 自动配置类，封装配置文件的内容：***Properties

没事就找找类，看看自动装配原理！

我们之后来进行一个单体项目的小项目测试，让大家能够快速上手开发！



## 静态资源

### 静态资源映射规则

**首先，我们搭建一个普通的SpringBoot项目，回顾一下HelloWorld程序！**

写请求非常简单，那我们要引入我们前端资源，我们项目中有许多的静态资源，比如css，js等文件，这个SpringBoot怎么处理呢？

如果我们是一个web应用，我们的main下会有一个webapp，我们以前都是将所有的页面导在这里面的，对吧！但是我们现在的pom呢，打包方式是为jar的方式，那么这种方式SpringBoot能不能来给我们写页面呢？当然是可以的，但是SpringBoot对于静态资源放置的位置，是有规定的！

**我们先来聊聊这个静态资源映射规则：**

SpringBoot中，SpringMVC的web配置都在 WebMvcAutoConfiguration 这个配置类里面；

我们可以去看看 WebMvcAutoConfigurationAdapter 中有很多配置方法；

有一个方法：addResourceHandlers 添加资源处理

```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!this.resourceProperties.isAddMappings()) {
        // 已禁用默认资源处理
        logger.debug("Default resource handling disabled");
        return;
    }
    // 缓存控制
    Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
    CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
    // webjars 配置
    if (!registry.hasMappingForPattern("/webjars/**")) {
        customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
                                             .addResourceLocations("classpath:/META-INF/resources/webjars/")
                                             .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
    }
    // 静态资源配置
    String staticPathPattern = this.mvcProperties.getStaticPathPattern();
    if (!registry.hasMappingForPattern(staticPathPattern)) {
        customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
                                             .addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
                                             .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
    }
}
```

读一下源代码：比如所有的 /webjars/** ， 都需要去 classpath:/META-INF/resources/webjars/ 找对应的资源；



### 什么是webjars 呢？

Webjars本质就是以jar包的方式引入我们的静态资源 ， 我们以前要导入一个静态资源文件，直接导入即可。

使用SpringBoot需要使用Webjars，我们可以去搜索一下：

网站：https://www.webjars.org 

要使用jQuery，我们只要要引入jQuery对应版本的pom依赖即可！

```xml
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>3.4.1</version>
</dependency>
```

导入完毕，查看webjars目录结构，并访问Jquery.js文件！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LheYVC0eZ6Rjt0MVjviaRZ6wt4N51VrTR1uzYBRo97UEoMJSnY1I0475oCajSe50e3tW5j0SXVwRA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

访问：只要是静态资源，SpringBoot就会去对应的路径寻找资源，我们这里访问：http://localhost:8080/webjars/jquery/3.4.1/jquery.js

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LheYVC0eZ6Rjt0MVjviaRZ6JzDrsHnyDZbfzsBxwR77xMoM2ia3ic9b8uyOngzt3aH8QztXugXM2jhA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

### 第二种静态资源映射规则

那我们项目中要是使用自己的静态资源该怎么导入呢？我们看下一行代码；

我们去找staticPathPattern发现第二种映射规则 ：/** , 访问当前的项目任意资源，它会去找 resourceProperties 这个类，我们可以点进去看一下分析：

```java
// 进入方法
public String[] getStaticLocations() {
    return this.staticLocations;
}
// 找到对应的值
private String[] staticLocations = CLASSPATH_RESOURCE_LOCATIONS;
// 找到路径
private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { 
    "classpath:/META-INF/resources/",
  	"classpath:/resources/", 
    "classpath:/static/", 
    "classpath:/public/" 
};
```

ResourceProperties 可以设置和我们静态资源有关的参数；这里面指向了它会去寻找资源的文件夹，即上面数组的内容。

所以得出结论，以下四个目录存放的静态资源可以被我们识别：

```java
"classpath:/META-INF/resources/"
"classpath:/resources/"
"classpath:/static/"
"classpath:/public/"
```

我们可以在resources根目录下新建对应的文件夹，都可以存放我们的静态文件；

比如我们访问 http://localhost:8080/1.js , 他就会去这些文件夹中寻找对应的静态资源文件；

### 自定义静态资源路径

我们也可以自己通过配置文件来指定一下，哪些文件夹是需要我们放静态资源文件的，在application.properties中配置；

```properties
spring.resources.static-locations=classpath:/coding/,classpath:/kuang/
```

一旦自己定义了静态文件夹的路径，原来的自动配置就都会失效了！





### 总结：

1. 在springboot中，我们可以使用以下方式处理静态资源：
   - webjars： `localhost:8080/webjars/目标文件`
   - public，static，/**，resources      `localhost：8080/webjars/目标文件`
2. 优先级：resources>static：一般将静态资源默认放在这里>public 

但是如果在application.properties里定义了一个spring.mvc.static-path-pattern=/hello/,classpath:/kuang/，那么在浏览器上的静态资源访问（比如在static里写的1.js文件）就会访问不了，会报错。





## 首页如何定制

静态资源文件夹说完后，我们继续向下看源码！可以看到一个欢迎页的映射，就是我们的首页！

```java
@Bean
public WelcomePageHandlerMapping welcomePageHandlerMapping(ApplicationContext applicationContext,
                                                           FormattingConversionService mvcConversionService,
                                                           ResourceUrlProvider mvcResourceUrlProvider) {
    WelcomePageHandlerMapping welcomePageHandlerMapping = new WelcomePageHandlerMapping(
        new TemplateAvailabilityProviders(applicationContext), applicationContext, getWelcomePage(), // getWelcomePage 获得欢迎页
        this.mvcProperties.getStaticPathPattern());
    welcomePageHandlerMapping.setInterceptors(getInterceptors(mvcConversionService, mvcResourceUrlProvider));
    return welcomePageHandlerMapping;
}
```

点进去继续看

```java
private Optional<Resource> getWelcomePage() {
    String[] locations = getResourceLocations(this.resourceProperties.getStaticLocations());
    // ::是java8 中新引入的运算符
    // Class::function的时候function是属于Class的，应该是静态方法。
    // this::function的funtion是属于这个对象的。
    // 简而言之，就是一种语法糖而已，是一种简写
    return Arrays.stream(locations).map(this::getIndexHtml).filter(this::isReadable).findFirst();
}
// 欢迎页就是一个location下的的 index.html 而已
private Resource getIndexHtml(String location) {
    return this.resourceLoader.getResource(location + "index.html");
}
```

欢迎页，静态资源文件夹下的所有 index.html 页面；被 /** 映射。

比如我访问  http://localhost:8080/ ，就会找静态资源文件夹下的 index.html

新建一个 index.html ，在我们上面的3个目录中任意一个；然后访问测试  http://localhost:8080/  看结果！

**关于网站图标说明**：(但是版本大概要在2.1.7.RELEASE左右，版本高了找不到该资源了，直接在pom.xml里改就可以了)

![image-20220821204339043](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220821204339043.png)



![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LheYVC0eZ6Rjt0MVjviaRZ6ugmXIE9bON3P8hrtQAZDLnEaG1OPLNcGsuOZGGPibLGgLBuG5pqgibpQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

与其他静态资源一样，Spring Boot在配置的静态内容位置中查找 favicon.ico。如果存在这样的文件，它将自动用作应用程序的favicon。

1、关闭SpringBoot默认图标

```properties
#关闭默认图标
spring.mvc.favicon.enabled=false
```

2、自己放一个图标在静态资源目录下，我放在 public 目录下

3、清除浏览器缓存！刷新网页，发现图标已经变成自己的了！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LheYVC0eZ6Rjt0MVjviaRZ6awkOYiaHoiatBZQrAeAO2MFRWC5kUuyWur0XMIXHAcV8ORgM90fIaVNQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)





# 第七章  Thymeleaf

## 模板引擎

前端交给我们的页面，是html页面。如果是我们以前开发，我们需要把他们转成jsp页面，jsp好处就是当我们查出一些数据转发到JSP页面以后，我们可以用jsp轻松实现数据的显示，及交互等。

jsp支持非常强大的功能，包括能写Java代码，但是呢，我们现在的这种情况，SpringBoot这个项目首先是以jar的方式，不是war，像第二，我们用的还是嵌入式的Tomcat，所以呢，**他现在默认是不支持jsp的**。

那不支持jsp，如果我们直接用纯静态页面的方式，那给我们开发会带来非常大的麻烦，那怎么办呢？

**SpringBoot推荐你可以来使用模板引擎：**

模板引擎，我们其实大家听到很多，其实jsp就是一个模板引擎，还有用的比较多的freemarker，包括SpringBoot给我们推荐的Thymeleaf，模板引擎有非常多，但再多的模板引擎，他们的思想都是一样的，什么样一个思想呢我们来看一下这张图：

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6V42bcomyzTYY0q6ic7AB8lvciaoicxyalNYQYZgslIrIjdXWLFNcOxUmQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

模板引擎的作用就是我们来写一个页面模板，比如有些值呢，是动态的，我们写一些表达式。而这些值，从哪来呢，就是我们在后台封装一些数据。然后把这个模板和这个数据交给我们模板引擎，模板引擎按照我们这个数据帮你把这表达式解析、填充到我们指定的位置，然后把这个数据最终生成一个我们想要的内容给我们写出去，这就是我们这个模板引擎，不管是jsp还是其他模板引擎，都是这个思想。只不过呢，就是说不同模板引擎之间，他们可能这个语法有点不一样。其他的我就不介绍了，我主要来介绍一下SpringBoot给我们推荐的Thymeleaf模板引擎，这模板引擎呢，是一个高级语言的模板引擎，他的这个语法更简单。而且呢，功能更强大。

我们呢，就来看一下这个模板引擎，那既然要看这个模板引擎。首先，我们来看SpringBoot里边怎么用。



## 引入Thymeleaf

怎么引入呢，对于springboot来说，什么事情不都是一个start的事情嘛，我们去在项目中引入一下。给大家三个网址：

Thymeleaf 官网：https://www.thymeleaf.org/

Thymeleaf 在Github 的主页：https://github.com/thymeleaf/thymeleaf

Spring官方文档：找到我们对应的版本

https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#using-boot-starter 

找到对应的pom依赖：可以适当点进源码看下本来的包！

```xml
<!--        Thymeleaf,我们都是基于3.x开发-->
<dependency>
    <groupId>org.thymeleaf</groupId>
    <artifactId>thymeleaf-spring5</artifactId>
</dependency>
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-java8time</artifactId>
</dependency>
```

Maven会自动下载jar包，我们可以去看下下载的东西；

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6o4dAJHKh0872nmgaPYMaQDJ8KWfHJYWyoMXHW2pmVOtLVnREViaTziaw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



## Thymeleaf分析

前面呢，我们已经引入了Thymeleaf，那这个要怎么使用呢？

我们首先得按照SpringBoot的自动配置原理看一下我们这个Thymeleaf的自动配置规则，在按照那个规则，我们进行使用。

我们去找一下Thymeleaf的自动配置类：ThymeleafProperties

```java
@ConfigurationProperties(
    prefix = "spring.thymeleaf"
)
public class ThymeleafProperties {
    private static final Charset DEFAULT_ENCODING;
    public static final String DEFAULT_PREFIX = "classpath:/templates/";
    public static final String DEFAULT_SUFFIX = ".html";
    private boolean checkTemplate = true;
    private boolean checkTemplateLocation = true;
    private String prefix = "classpath:/templates/";
    private String suffix = ".html";
    private String mode = "HTML";
    private Charset encoding;
}
```

我们可以在其中看到默认的前缀和后缀！

我们只需要把我们的html页面放在类路径下的templates下，thymeleaf就可以帮我们自动渲染了。

使用thymeleaf什么都不需要配置，只需要将他放在指定的文件夹下即可！



**测试**

1、编写一个TestController

```java
@Controller
public class TestController {
    
    @RequestMapping("/t1")
    public String test1(){
        //classpath:/templates/test.html
        return "test";
    } 
}
```

2、编写一个测试页面  test.html 放在 templates 目录下

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>测试页面</h1>

</body>
</html>
```

3、启动项目请求测试



## Thymeleaf 语法学习

要学习语法，还是参考官网文档最为准确，我们找到对应的版本看一下；

Thymeleaf 官网：https://www.thymeleaf.org/ ， 简单看一下官网！我们去下载Thymeleaf的官方文档！

**我们做个最简单的练习 ：我们需要查出一些数据，在页面中展示**

1、修改测试请求，增加数据传输；

```java
@RequestMapping("/t1")
public String test1(Model model){
    //存入数据
    model.addAttribute("msg","Hello,Thymeleaf");
    //classpath:/templates/test.html
    return "test";
}
```

2、我们要使用thymeleaf，需要在html文件中导入命名空间的约束，方便提示。

我们可以去官方文档的#3中看一下命名空间拿来过来：

```java
 xmlns:th="http://www.thymeleaf.org"
```

3、我们去编写下前端页面

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>狂神说</title>
</head>
<body>
<h1>测试页面</h1>

<!--th:text就是将div中的内容设置为它指定的值，和之前学习的Vue一样-->
<!--所有的html元素都可以被thymeleaf替换接管：   th: 元素名 -->
<div th:text="${msg}"></div>
</body> 
</html>
```

4、启动测试！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6ia0fYFrNsXdHekjLfPlq4ZMpF0rtPzFRBTWsw6K8zic3ywna1LgcM6Gw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



**OK，入门搞定，我们来认真研习一下Thymeleaf的使用语法！**

**1、我们可以使用任意的 th:attr 来替换Html中原生属性的值！**

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6fGYIwv043icVDYuybRJDCGTSNTMEibFzzMdlKS4t07TQoicQJKQAe0slQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**2、我们能写哪些表达式呢？**

```

Simple expressions:（表达式语法）
Variable Expressions: ${...}：获取变量值；OGNL；
    1）、获取对象的属性、调用方法
    2）、使用内置的基本对象：#18
         #ctx : the context object.
         #vars: the context variables.
         #locale : the context locale.
         #request : (only in Web Contexts) the HttpServletRequest object.
         #response : (only in Web Contexts) the HttpServletResponse object.
         #session : (only in Web Contexts) the HttpSession object.
         #servletContext : (only in Web Contexts) the ServletContext object.

    3）、内置的一些工具对象：
　　　　　　#execInfo : information about the template being processed.
　　　　　　#uris : methods for escaping parts of URLs/URIs
　　　　　　#conversions : methods for executing the configured conversion service (if any).
　　　　　　#dates : methods for java.util.Date objects: formatting, component extraction, etc.
　　　　　　#calendars : analogous to #dates , but for java.util.Calendar objects.
　　　　　　#numbers : methods for formatting numeric objects.
　　　　　　#strings : methods for String objects: contains, startsWith, prepending/appending, etc.
　　　　　　#objects : methods for objects in general.
　　　　　　#bools : methods for boolean evaluation.
　　　　　　#arrays : methods for arrays.
　　　　　　#lists : methods for lists.
　　　　　　#sets : methods for sets.
　　　　　　#maps : methods for maps.
　　　　　　#aggregates : methods for creating aggregates on arrays or collections.
==================================================================================

  Selection Variable Expressions: *{...}：选择表达式：和${}在功能上是一样；
  Message Expressions: #{...}：获取国际化内容
  Link URL Expressions: @{...}：定义URL；
  Fragment Expressions: ~{...}：片段引用表达式

Literals（字面量）
      Text literals: 'one text' , 'Another one!' ,…
      Number literals: 0 , 34 , 3.0 , 12.3 ,…
      Boolean literals: true , false
      Null literal: null
      Literal tokens: one , sometext , main ,…
      
Text operations:（文本操作）
    String concatenation: +
    Literal substitutions: |The name is ${name}|
    
Arithmetic operations:（数学运算）
    Binary operators: + , - , * , / , %
    Minus sign (unary operator): -
    
Boolean operations:（布尔运算）
    Binary operators: and , or
    Boolean negation (unary operator): ! , not
    
Comparisons and equality:（比较运算）
    Comparators: > , < , >= , <= ( gt , lt , ge , le )
    Equality operators: == , != ( eq , ne )
    
Conditional operators:条件运算（三元运算符）
    If-then: (if) ? (then)
    If-then-else: (if) ? (then) : (else)
    Default: (value) ?: (defaultvalue)
    
Special tokens:
    No-Operation: _
```





**练习测试：**

1、 我们编写一个Controller，放一些数据

```java
@RequestMapping("/t2")
public String test2(Map<String,Object> map){
    //存入数据
    map.put("msg","<h1>Hello</h1>");
    map.put("users", Arrays.asList("qinjiang","kuangshen"));
    //classpath:/templates/test.html
    return "test";
}
```

2、测试页面取出数据

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>狂神说</title>
</head>
<body>
<h1>测试页面</h1>

<div th:text="${msg}"></div>
<!--不转义-->
<div th:utext="${msg}"></div>

<!--遍历数据-->
<!--th:each每次遍历都会生成当前这个标签：官网#9-->
<h4 th:each="user :${users}" th:text="${user}"></h4>

<h4>
    <!--行内写法：官网#12-->
    <span th:each="user:${users}">[[${user}]]</span>
</h4>

</body>
</html>
```

3、启动项目测试！

**我们看完语法，很多样式，我们即使现在学习了，也会忘记，所以我们在学习过程中，需要使用什么，根据官方文档来查询，才是最重要的，要熟练使用官方文档！**







# 第八章 SpringMVC自动配置原理

## 官网阅读

在进行项目编写前，我们还需要知道一个东西，就是SpringBoot对我们的SpringMVC还做了哪些配置，包括如何扩展，如何定制。

只有把这些都搞清楚了，我们在之后使用才会更加得心应手。途径一：源码分析，途径二：官方文档！

地址 ：https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-auto-configuration

```java
Spring MVC Auto-configuration
// Spring Boot为Spring MVC提供了自动配置，它可以很好地与大多数应用程序一起工作。
Spring Boot provides auto-configuration for Spring MVC that works well with most applications.
// 自动配置在Spring默认设置的基础上添加了以下功能：
The auto-configuration adds the following features on top of Spring’s defaults:
// 包含视图解析器
Inclusion of ContentNegotiatingViewResolver and BeanNameViewResolver beans.
// 支持静态资源文件夹的路径，以及webjars
Support for serving static resources, including support for WebJars 
// 自动注册了Converter：
// 转换器，这就是我们网页提交数据到后台自动封装成为对象的东西，比如把"1"字符串自动转换为int类型
// Formatter：【格式化器，比如页面给我们了一个2019-8-10，它会给我们自动格式化为Date对象】
Automatic registration of Converter, GenericConverter, and Formatter beans.
// HttpMessageConverters
// SpringMVC用来转换Http请求和响应的的，比如我们要把一个User对象转换为JSON字符串，可以去看官网文档解释；
Support for HttpMessageConverters (covered later in this document).
// 定义错误代码生成规则的
Automatic registration of MessageCodesResolver (covered later in this document).
// 首页定制
Static index.html support.
// 图标定制
Custom Favicon support (covered later in this document).
// 初始化数据绑定器：帮我们把请求数据绑定到JavaBean中！
Automatic use of a ConfigurableWebBindingInitializer bean (covered later in this document).

/*
如果您希望保留Spring Boot MVC功能，并且希望添加其他MVC配置（拦截器、格式化程序、视图控制器和其他功能），则可以添加自己
的@configuration类，类型为webmvcconfiguer，但不添加@EnableWebMvc。如果希望提供
RequestMappingHandlerMapping、RequestMappingHandlerAdapter或ExceptionHandlerExceptionResolver的自定义
实例，则可以声明WebMVCregistrationAdapter实例来提供此类组件。
*/
If you want to keep Spring Boot MVC features and you want to add additional MVC configuration 
(interceptors, formatters, view controllers, and other features), you can add your own 
@Configuration class of type WebMvcConfigurer but without @EnableWebMvc. If you wish to provide 
custom instances of RequestMappingHandlerMapping, RequestMappingHandlerAdapter, or 
ExceptionHandlerExceptionResolver, you can declare a WebMvcRegistrationsAdapter instance to provide such components.

// 如果您想完全控制Spring MVC，可以添加自己的@Configuration，并用@EnableWebMvc进行注释。
If you want to take complete control of Spring MVC, you can add your own @Configuration annotated with @EnableWebMvc.
```



我们来仔细对照，看一下它怎么实现的，它告诉我们SpringBoot已经帮我们自动配置好了SpringMVC，然后自动配置了哪些东西呢？



## **ContentNegotiatingViewResolver 内容协商视图解析器** 

自动配置了ViewResolver，就是我们之前学习的SpringMVC的视图解析器；

即根据方法的返回值取得视图对象（View），然后由视图对象决定如何渲染（转发，重定向）。

我们去看看这里的源码：我们找到 WebMvcAutoConfiguration ， 然后搜索ContentNegotiatingViewResolver。找到如下方法！

```java
@Bean
@ConditionalOnBean(ViewResolver.class)
@ConditionalOnMissingBean(name = "viewResolver", value = ContentNegotiatingViewResolver.class)
public ContentNegotiatingViewResolver viewResolver(BeanFactory beanFactory) {
    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    resolver.setContentNegotiationManager(beanFactory.getBean(ContentNegotiationManager.class));
    // ContentNegotiatingViewResolver使用所有其他视图解析器来定位视图，因此它应该具有较高的优先级
    resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return resolver;
}
```

我们可以点进这类看看！找到对应的解析视图的代码；

```java

@Nullable // 注解说明：@Nullable 即参数可为null
public View resolveViewName(String viewName, Locale locale) throws Exception {
    RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
    Assert.state(attrs instanceof ServletRequestAttributes, "No current ServletRequestAttributes");
    List<MediaType> requestedMediaTypes = this.getMediaTypes(((ServletRequestAttributes)attrs).getRequest());
    if (requestedMediaTypes != null) {
        // 获取候选的视图对象
        List<View> candidateViews = this.getCandidateViews(viewName, locale, requestedMediaTypes);
        // 选择一个最适合的视图对象，然后把这个对象返回
        View bestView = this.getBestView(candidateViews, requestedMediaTypes, attrs);
        if (bestView != null) {
            return bestView;
        }
    }
    // .....
}
```

我们继续点进去看，他是怎么获得候选的视图的呢？

getCandidateViews中看到他是把所有的视图解析器拿来，进行while循环，挨个解析！

```
Iterator var5 = this.viewResolvers.iterator();
```

所以得出结论：**ContentNegotiatingViewResolver 这个视图解析器就是用来组合所有的视图解析器的** 

我们再去研究下他的组合逻辑，看到有个属性viewResolvers，看看它是在哪里进行赋值的！

```java
protected void initServletContext(ServletContext servletContext) {
    // 这里它是从beanFactory工具中获取容器中的所有视图解析器
    // ViewRescolver.class 把所有的视图解析器来组合的
    Collection<ViewResolver> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(this.obtainApplicationContext(), ViewResolver.class).values();
    ViewResolver viewResolver;
    if (this.viewResolvers == null) {
        this.viewResolvers = new ArrayList(matchingBeans.size());
    }
    // ...............
}
```

既然它是在容器中去找视图解析器，我们是否可以猜想，我们就可以去实现一个视图解析器了呢？

我们可以自己给容器中去添加一个视图解析器；这个类就会帮我们自动的将它组合进来；**我们去实现一下**

1、我们在我们的主程序中去写一个视图解析器来试试；

```java
@Bean //放到bean中
public ViewResolver myViewResolver(){
    return new MyViewResolver();
}

//我们写一个静态内部类，视图解析器就需要实现ViewResolver接口
private static class MyViewResolver implements ViewResolver{
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return null;
    }
}
```

2、怎么看我们自己写的视图解析器有没有起作用呢？

我们给 DispatcherServlet 中的 doDispatch方法 加个断点进行调试一下，因为所有的请求都会走到这个方法中

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6QBbBv34R87hGpeWiaPnuYhBG1FlfdhtZxlIKicA2Y4kHy9XqRicibmQkWQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

3、我们启动我们的项目，然后随便访问一个页面，看一下Debug信息；

找到this![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6NnU4IPDPs8jKYRjDJGia7t3C5YgjCSHuiaxlpthKpBwGh9m6icsF5zuow/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

找到视图解析器，我们看到我们自己定义的就在这里了；

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp67xW1M2s2aOnolP1tAedrqAtUuBHRjz7ALePedpHkpz9MXVyLwe6wYw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

所以说，我们如果想要使用自己定制化的东西，我们只需要给容器中添加这个组件就好了！剩下的事情SpringBoot就会帮我们做了！

```
//如果你想自定义一些定制化的功能，只需要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配
```





## 转换器和格式化器

找到格式化转换器：

```java
@Bean
@Override
public FormattingConversionService mvcConversionService() {
    // 拿到配置文件中的格式化规则
    WebConversionService conversionService = 
        new WebConversionService(this.mvcProperties.getDateFormat());
    addFormatters(conversionService);
    return conversionService;
}
```

点击去：

```java
public String getDateFormat() {
    return this.dateFormat;
}

/**
* Date format to use. For instance, `dd/MM/yyyy`. 默认的
 */
private String dateFormat;
```

可以看到在我们的Properties文件中，我们可以进行自动配置它！

如果配置了自己的格式化方式，就会注册到Bean中生效，我们可以在配置文件中配置日期格式化的规则：

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6zdySrKJPkADN9jtsIpz6QPOyC2nI04l0EiaAOMuU47pwiaPq2RrhUdaA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

其余的就不一一举例了，大家可以下去多研究探讨即可！

## 修改SpringBoot的默认配置

这么多的自动配置，原理都是一样的，通过这个WebMVC的自动配置原理分析，我们要学会一种学习方式，通过源码探究，得出结论；这个结论一定是属于自己的，而且一通百通。

SpringBoot的底层，大量用到了这些设计细节思想，所以，没事需要多阅读源码！得出结论；

SpringBoot在自动配置很多组件的时候，先看容器中有没有用户自己配置的（如果用户自己配置@bean），如果有就用用户配置的，如果没有就用自动配置的；

如果有些组件可以存在多个，比如我们的视图解析器，就将用户配置的和自己默认的组合起来！

**扩展使用SpringMVC**  官方文档如下：

If you want to keep Spring Boot MVC features and you want to add additional MVC configuration (interceptors, formatters, view controllers, and other features), you can add your own @Configuration class of type WebMvcConfigurer but without @EnableWebMvc. If you wish to provide custom instances of RequestMappingHandlerMapping, RequestMappingHandlerAdapter, or ExceptionHandlerExceptionResolver, you can declare a WebMvcRegistrationsAdapter instance to provide such components.

我们要做的就是编写一个@Configuration注解类，并且类型要为WebMvcConfigurer，还不能标注@EnableWebMvc注解；我们去自己写一个；我们新建一个包叫config，写一个类MyMvcConfig；

```java
//应为类型要求为WebMvcConfigurer，所以我们实现其接口
//可以使用自定义类扩展MVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送/test ， 就会跳转到test页面；
        registry.addViewController("/test").setViewName("test");
    }
}
```

我们去浏览器访问一下：

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6smNnW3fpooPSQpiaoMajpXYGDoH0aQnv8awIibPa9eKkJhewdMrTtLTg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**确实也跳转过来了！所以说，我们要扩展SpringMVC，官方就推荐我们这么去使用，既保SpringBoot留所有的自动配置，也能用我们扩展的配置！**

我们可以去分析一下原理：

1、WebMvcAutoConfiguration 是 SpringMVC的自动配置类，里面有一个类WebMvcAutoConfigurationAdapter

2、这个类上有一个注解，在做其他自动配置时会导入：@Import(EnableWebMvcConfiguration.class)

3、我们点进EnableWebMvcConfiguration这个类看一下，它继承了一个父类：DelegatingWebMvcConfiguration

这个父类中有这样一段代码：

```java
public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {
    private final WebMvcConfigurerComposite configurers = new WebMvcConfigurerComposite();
    
  // 从容器中获取所有的webmvcConfigurer
    @Autowired(required = false)
    public void setConfigurers(List<WebMvcConfigurer> configurers) {
        if (!CollectionUtils.isEmpty(configurers)) {
            this.configurers.addWebMvcConfigurers(configurers);
        }
    }
}
```

4、我们可以在这个类中去寻找一个我们刚才设置的viewController当做参考，发现它调用了一个

```java
protected void addViewControllers(ViewControllerRegistry registry) {
    this.configurers.addViewControllers(registry);
}
```

5、我们点进去看一下

```java
public void addViewControllers(ViewControllerRegistry registry) {
    Iterator var2 = this.delegates.iterator();

    while(var2.hasNext()) {
        // 将所有的WebMvcConfigurer相关配置来一起调用！包括我们自己配置的和Spring给我们配置的
        WebMvcConfigurer delegate = (WebMvcConfigurer)var2.next();
        delegate.addViewControllers(registry);
    }

}
```

所以得出结论：所有的WebMvcConfiguration都会被作用，不止Spring自己的配置类，我们自己的配置类当然也会被调用；





## 全面接管SpringMVC

官方文档：

```java
If you want to take complete control of Spring MVC
you can add your own @Configuration annotated with @EnableWebMvc.
```

全面接管即：SpringBoot对SpringMVC的自动配置不需要了，所有都是我们自己去配置！

只需在我们的配置类中要加一个@EnableWebMvc。

我们看下如果我们全面接管了SpringMVC了，我们之前SpringBoot给我们配置的静态资源映射一定会无效，我们可以去测试一下；

不加注解之前，访问首页：

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp6ic2wzwiaMd6YwOHuK1fcn3ibhuXD60XiarS9NLdTIDJJicFZJt1wQ0ibuUxg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

给配置类加上注解：@EnableWebMvc

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7Idia351qHgmH2vbzurk1Pp68kRH4rPKMyhAdkIL46HW90qsSoyMcNibRxDbfu7iboWM6AMRr5tFSicPA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

我们发现所有的SpringMVC自动配置都失效了！回归到了最初的样子；

**当然，我们开发中，不推荐使用全面接管SpringMVC**

思考问题？为什么加了一个注解，自动配置就失效了！我们看下源码：

1、这里发现它是导入了一个类，我们可以继续进去看

```java
@Import({DelegatingWebMvcConfiguration.class})
public @interface EnableWebMvc {
}
```

2、它继承了一个父类 WebMvcConfigurationSupport

```java
public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {
  // ......
}
```

3、我们来回顾一下Webmvc自动配置类

```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication(type = Type.SERVLET)
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })
// 这个注解的意思就是：容器中没有这个组件的时候，这个自动配置类才生效
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
@AutoConfigureAfter({ DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class,
    ValidationAutoConfiguration.class })
public class WebMvcAutoConfiguration {
    
}
```

总结一句话：@EnableWebMvc将WebMvcConfigurationSupport组件导入进来了；

而导入的WebMvcConfigurationSupport只是SpringMVC最基本的功能！

**在SpringBoot中会有非常多的扩展配置(xxxConfiguration)，只要看见了这个，我们就应该多留心注意~**





# 第九章 员工管理系统（springboot的一个小系统）

## 相关知识补充：

### lombok

#### 1、介绍

[lombok](https://so.csdn.net/so/search?q=lombok&spm=1001.2101.3001.7020)是一个插件，用途是使用注解给你类里面的字段，自动的加上属性，构造器，ToString方法，Equals方法等等,比较方便的一点是，你在更改字段的时候，lombok会立即发生改变以保持和你代码的一致性。

#### 2、常用的 lombok 注解介绍

@Getter 加在类上，可以自动生成参数的getter方法。

@Setter 加在类上，可以自动生成参数的setter方法

@ToString 加在类上，调用toString()方法，可以输出[实体类](https://so.csdn.net/so/search?q=实体类&spm=1001.2101.3001.7020)中所有属性的值

@RequiredArgsConstructor会生成一个包含常量，和标识了NotNull的变量的构造方法。生成的构造方法是私有的private。这个我用的很少。

@EqualsAndHashCode
(1).它会生成[equals](https://so.csdn.net/so/search?q=equals&spm=1001.2101.3001.7020)和hashCode方法
(2).默认使用非静态的属性
(3).可以通过exclude参数排除不需要生成的属性
(4).可以通过of参数来指定需要生成的属性
(5).它默认不调用父类的方法，只使用本类定义的属性进行操作，可以使用callSuper=true来解决，会在@Data中进行讲解。

@Data这个是非常常用的注解，这个注解其实是五个注解的合体：(提供类的get、set、EqualsAndHashCode、toString方法)

@NoArgsConstructor生成一个无参数的构造方法。

@AllArgsConstructor生成一个包含所有变量的构造方法。

#### 3.idea安装lombok插件

![img](https://img-blog.csdnimg.cn/228ea0ac4fbd4037a2a964445538ca32.jpg)

![img](https://img-blog.csdnimg.cn/75534b22921b47c48497b9903754ee6c.jpg?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAQmx1ZS1TZWE=,size_20,color_FFFFFF,t_70,g_se,x_16)

![img](https://img-blog.csdnimg.cn/97a07f2fccc8469bb86860f23980b3c9.jpg?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAQmx1ZS1TZWE=,size_20,color_FFFFFF,t_70,g_se,x_16)

**注意：安装完后一定要重启idea**

#### 4.lombok使用

（1）引入依赖

```xml
<!--引入lombok依赖-->
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
```

（2）在Employee类上添加lombok注解

```java
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Employee {
 private Long empId;
 private String name;
 private String empGender;
 private Integer age;
 private String email;
}
/*
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data //常用注解：
@AllArgsConstructor //全参数构造器
@NoArgsConstructor //无参数构造器
@TableName("employee") //能够和底层的数据库表明进行对应：
*/ 


```



### Fragment Expressions

Fragment Expressions: `~{...}`：片段引用表达式 （可以提取出公共的部分写到一个新的文件里）

比如在前端页面顶部导航栏或者侧边导航栏中通过 th:fragment="自定义名称",把这个导航栏抽取出来定义为刚才自定义名称的部分

然后在另一个前端页面通过片段引用表达式进行引用。

(该例中<div th:insert="~{dashboard::topbar}"></div>  就是片段引用表达式，dashboard表示引用片段的出处，topbar表示引用的片段) （insert可以换成replace）

```html
dashboard.html:
<!--	定义顶部导航栏-->
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0" th:fragment="topbar">

list.html:
<div th:insert="~{dashboard::topbar}"></div>  
```

当然也可把重复部分如顶部导航栏和侧边导航栏抽取出来，放到一个新的html页面，如commons/commons.html，这样的话引用的代码就变成了dashboard.html和list.html都要写且写的形式如下

```html
...
<div th:replace="~{commons/commons::topbar}"></div>

...

<div th:replace="~{commons/commons::sidebar}"></div>
```











## 一.准备工作



**1.**

**把静态资源导入到IDEA中**

![image-20220822164724752](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220822164724752.png)

将拿到的静态资源文件中的html文件导入templates中，css/img/js文件则导入static中



**2.**

**先建立两个pojo实体类对象，并通过lombok插件进行方法的实现**

![image-20220822163921655](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220822163921655.png)

```java
//Employee.java

//员工表
@Data    //lombok
@NoArgsConstructor   //无参构造方法
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0代表女，1代表男
    private Department department;
    private Date birth;

    //在这里内嵌一个日期
    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认的创建日期
        this.birth = new Date();
    }
}
```



```java
//Department.java

//部门表
@Data    //lombok
@AllArgsConstructor  //有参构造
@NoArgsConstructor   //无参构造
public class Department {

    private Integer id;
    private String DepartmentName;
}
```



**3.**

**在dao层建立两个与pojo类对应的Dao文件，并模拟数据库中的数据以及增删查改的操作**

![image-20220822164156470](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220822164156470.png)

```java
//DepartmentDemo.java

//部门dao
@Repository
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();  //创建一个部门表

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartment(Integer id){
        return departments.get(id);
    }

}
```

```java
//EmployeeDao.java

//员工Dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();  //创建一个部门表

        employees.put(1001,new Employee(1001,"AA","111111111@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","222222222@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","333333333@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","444444444@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","555555555@qq.com",0,new Department(105,"后勤部")));

    }
    //主键自增
    private static Integer initId =1006;
    //增加一个员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //如果连以上以及以下的能力都没有， 就把这个代码敲一百遍，就能对数据库精通了

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    //一般规范一点都是用Integer，因为如果用int的话会去自动装箱和自动拆箱，涉及到时间片问题，会影响效率
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

}

/*
    如果想把这些数据对标到数据库，只需要把数据改一下就好了，增删改查写成一个mapper里面对应的sql
 */

```







## 二.首页实现

**1.由于在templates下的文件无法直接访问，所以我们要写东西去控制它**

传统的SpringMVC写法是在controller层写一个IndexController来控制跳转到index.html页面

![image-20220822170009215](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220822170009215.png)



但是在springboot接管之后，可以不用写控制器了，IndexController都可以删掉了，直接在config里面写（**扩展SpringMVC**），通过自己定义的方式去**扩展SpringMVC**：

在config文件夹下写一个Config：例如MyMvcConfig，然后重写addViewControllers（添加视图控制）

```java
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
}
```





**2.由于现在静态资源如css等无法加载进来，但是我们使用了thymeleaf，所以要把html等文件改成thymeleaf的形式**

 改造步骤：（以index.html为例）

```html
index.html:
a:引入xmlns:th="http://www.thymeleaf.org"
<html lang="en" xmlns:th="http://www.thymeleaf.org">
    
b:超链接的改造
<!-- Bootstrap core CSS -->
<link href="asserts/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="asserts/css/signin.css" rel="stylesheet">
	改成
<!-- Bootstrap core CSS -->
<link th:href="@{/css/bootstrap.min.css}" rel="stylesheet">
<!-- Custom styles for this template -->
<link th:href="@{/css/signin.css}" rel="stylesheet">
  
c:图片链接的改造
<img class="mb-4" src="asserts/img/bootstrap-solid.svg" alt="" width="72" height="72">
    改成
<img class="mb-4" th:src="@{/img/bootstrap-solid.svg}" alt="" width="72" height="72">

    
其他的html文件改造步骤同index.html一致
    
但是在线链接比如href="http://getbootstrap.com/docs/4.0/examples/dashboard/#"就不用改造，因为不是本地的

```

但是改造以后可能还是不奏效，可能是因为thymeleaf的缓存问题

所以在application.properties文件里加入一个关闭thymeleaf缓存

```properties
# 关闭thymeleaf模板引擎的缓存
spring.thymeleaf.cache=false
```

之后清除浏览器缓存，然后首页就会加载出css样式了

还可以配置首页根路径：(application.properties)

```properties
# 配置一个根路径，现在访问首页就要输入http://localhost:8080/kuang
server.servlet.context-path=/kuang
```



注意：**所有页面的静态资源都需要使用thymeleaf接管，用 `@{}`**











## 三.页面国际化

1.在resources中建立一个i18n文件夹，里面创建login.properties,login_en_US.properties,login_zh_CN.properties三个文件，

![image-20220822191310722](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220822191310722.png)

2.这三个文件内容如图所示，然后去application.properties里配置文件所放的真实位置：

```properties
# 我们的配置文件放在的真实位置
spring.messages.basename=i18n.login
```



3.然后改造index.html:

```html
1.<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
2.<label class="sr-only">Username</label>
<input type="text" class="form-control" placeholder="Username" required="" autofocus="">

3.<label class="sr-only">Password</label>
<input type="password" class="form-control" placeholder="Password" required="">

4.<label>
<input type="checkbox" value="remember-me"> Remember me
5.</label>
<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

	改成

1.<h1 class="h3 mb-3 font-weight-normal" th:text="#{login.tip}">Please sign in</h1>
2.<label class="sr-only" th:text="#{login.username}">Username</label>
<input type="text" class="form-control" th:placeholder="#{login.username}" required="" autofocus="">

3.<label class="sr-only" th:text="#{login.password}">Password</label>
<input type="password" class="form-control" th:placeholder="#{login.password}" required="">


4.		<label>
          <input type="checkbox" value="remember-me"> [[#{login.remember}]]
        </label>
5.<button class="btn btn-lg btn-primary btn-block" type="submit">[[#{login.btn}]]</button>


```

这样改完以后，首页就全部由英文变成中文了。

但是无法实现点击中文就转换成中文版本，点击English就转换为英文版本



4.接着改造index.html文件：

```html
<a class="btn btn-sm">中文</a>
<a class="btn btn-sm">English</a>
	改成
<a class="btn btn-sm" th:href="@{/index.html(l='zh-CN')}">中文</a>
<a class="btn btn-sm" th:href="@{/index.html(l='en-US')}">English</a>
```



5.然后通过看源码，发现一个LocaleResolver这样一个地区解析器，我们就可以在config里写一个解析器MyLocaleResolver来实现这个LocaleResolver接口，然后重写方法,按照源码AcceptHeaderLocaleResolver.class里的LocaleResolver方法照猫画虎重写

```java
public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的语言参数
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault(); //如果没有就使用默认的
        //如果请求的链接携带了国际化参数
        if(!StringUtils.isEmpty(language)){
            //zh_CN
            String[] split = language.split("_");
            //国家，地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
```

然后这个自己的地区解析器写完之后，要放到Bean里面（就是往容器中注入这样一个组件），然后就去MyMvcConfig里写一个@Bean

```java
//自定义的国际化组件就生效了！
@Bean
public LocaleResolver localeResolver(){
    return new MyLocaleResolver();
}
```

- 注意：
  - 要完成页面国际化：
    - 我们需要配置i18n文件
    - 我们如果需要在项目中进行按钮自动切换，我们需要自定义一个组件`LocaleResolver`
    - 记得将自己写的组件配置到spring容器中 `@Bean`
    - #{}

**ResourceBund界面：安装一个Resource Bundle Editor的插件就有了**



```java
这里在切换中英文的时候会产生一个500错误，但是根据评论区的
/*
P22国际化中文和英文无法切换的问题，首先在html中
<a class="btn btn-sm" th:href="@{/index.html(l='zh_CN')}">中文</a>    
<a class="btn btn-sm" th:href="@{/index.html(l='en_US')}">English</a>
狂神在视频里面的那个不是l,是1 123的1，在视频里一直说l（L）
对应的就是MyLocaleResolver中的这一句
 String language = httpServletRequest.getParameter("l");
类名怕打错就复制就好了，然后就是在自定义Bean中检查好
	@Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
*/
这里面的所有跟项目里面一样的代码粘贴过去覆盖自己写的，就能够运行了
        我也不知道为什么，花了我一个多小时抱着试试看的态度粘贴到自己项目里覆盖自己的对应的代码，居然成功了、
```





## 四.登录功能实现

1.先改造index.html

```html
<form class="form-signin" action="dashboard.html">
    	改成
<form class="form-signin" th:action="@{/user/login}">
```

2.然后创建一个LoginController(这里选择让用户直接登录成功，只要名字不空就可以)

```java
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    @ResponseBody
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model){
        //具体的业务：
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            return "dashboard";
        }else {
            //告诉用户你登录失败了，用Model传一个信息
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }
}
```

3.然后测试一下能正常运行之后，就进行登录失败的信息提示

```html
在index.html的h1下面加上一行这个：

<!--			如果msg的值为空，则不显示消息-->
<p style="color: red" th:text="${msg}" th:if="${not #strings.isEmpty(msg)}"></p>
那么就能够在只有登录失败的时候才显示msg了
```

4.然后在MyMvcConfig里增加一行，以防止信息泄露在url中

```java
registry.addViewController("/main.html").setViewName("dashboard");
//就在登录成功以后url上显示的不是用户名和密码，而是指定的main.html，其实这个main.html是假的html，只是一个名字
```



5.最后在LoginController中重定向到真正的main.html中

```java
把            return "dashboard";
改成			 return "redirect:/main.html";
```





但是现在问题是不论登录不登录，只要知道http://localhost:8080/kuang/main.html这个url，就能够进入到后台页面，所以需要拦截器



## 五.登录拦截器

1.新建一个LoginHandlerInterceptor来实现`HandlerInterceptor`接口以及重写`preHandle`方法

```java
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登录成功之后，应该有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");

        if(loginUser==null){//没有登录
            request.setAttribute("msg","没有权限，请先登录"); //还没登录，那就提醒他登录
            request.getRequestDispatcher("/index.html").forward(request,response);
            return  false;
        }else {
            return true;
        }

    }
}
```

拦截器写好以后，要将这个拦截器注册到Bean里面（在`MyMvcConfig`中注册--重写`addInterceptors`方法）

```java
@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginHandlerInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**");
}
```



2.在LoginController的login方法参数签名中加入`HttpSession session` ，并完善具体的session相关业务

```java
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){
        //具体的业务：
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);   //在这部分里面加的就是这句代码,其他的和上面的一样
            return "redirect:/main.html";
        }else {
            //告诉用户你登录失败了，用Model传一个信息
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }
```



3.把用户登录的名字显示在登录成功的main.html页面上

```html
<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">company name</a>

 	改成

<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">[[${session.loginUser}]]</a>
```







## 六.展示员工列表

1.新建EmployeeController，并完善相关功能

```java
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
}
```

2.修改dashboard.html员工列表相关

3.修改list.html相关，把list.html放入新建的emp文件夹下 (跟th有关的就都是修改了的)

4.新建一个commons/commons.html，把头部导航栏和侧边导航栏抽取出来放到其中

5.修改导航高亮显示，点到哪个导航，哪个就显示高亮（传递参数active并接收判断）

6.修改展示：list.html里的thead和tbody



**tips:**

​	**A.提取公共页面**

​		a.   `th:fragment="sidebar"`

​		b.   `th:replace="~{commons/commons::topbar}"`

​		c.   `如果要传递参数，可以直接使用()传参，然后接收判断即可`

```html
传参具体代码：
<!--传递参数给组件-->
<div th:replace="~{commons/commons::sidebar(active='main.html')}"></div>

接收判断具体代码：
<a th:class="${active=='main.html'?'nav-link active':'nav-link'}" th:href="@{/index.html}">
```

这里用到的是thymeleaf里的   条件运算（三元运算符） ===>  If-then-else: (if) ? (then) : (else)



​	**B.列表循环展示（thead和tbody）**

```html
<thead>
	<tr>
		<th>id</th>
		<th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>department</th>
        <th>birth</th>
        <th>操作</th>
    </tr>
</thead>
<tbody>
	<tr th:each="emp:${emps}">
		<td th:text="${emp.getId()}"></td>
        <td>[[ ${emp.getLastName()} ]]</td>   <!--行内写法-->
        <td th:text="${emp.getEmail()}"></td>
        <td th:text="${emp.getGender()==0?'女':'男'}"></td>  
        <!--判断，如果0就女，否则男-->
        <td th:text="${emp.getDepartment()}"></td>
        <!--<td th:text="${emp.getBirth()}"></td>-->
        <td th:text="${#dates.format(emp.getBirth(),'yyyy-MM-dd HH:mm:ss')}">	</td>
        <td>
            <button class="btn btn-sm btn-primary">编辑</button>  
            <!--class是样式，btn是按钮，btn-sm是小按钮，btn-primary是按钮的颜色-->
            <button class="btn btn-sm btn-danger">删除</button>
        </td>
    </tr>
</tbody>
```



## 七.增加员工实现

1.按钮提交

2.跳转到添加页面

3.添加员工成功

4.返回首页

```html
<form action="">
    <div class="form-group">
        <label>LastName</label>
        <input type="text" class="form-control" placeholder="kuangshen">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" class="form-control" placeholder="123456789@qq.com">
    </div>
    <div class="form-group">
        <label>Gender</label><br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" value="1">
            <label class="form-check-label">男</label>
        </div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="gender" value="0">
    <label class="form-check-label">女</label>
        </div>
    </div>
    <div class="form-group">
        <label>department</label>
        <select class="form-control">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
    </div>
    <div class="form-group">
        <label>Birth</label>
        <input type="text" class="form-control" placeholder="kuangstudy">
    </div>
    <button type="submit" class="btn btn-primary">添加</button>
</form>    
```



1.增加一个add.html（直接复制list.html，然后用上面那段表单模板代码覆盖掉list.html里的表单代码），

然后再加上name属性，在下拉列表框加上所有部门信息的读取

`<option th:each="dept:${departments}" th:text="${dept.getDepartmentName()}" th:value="${dept.getId()}"></option>`

信息肯定是要从后端传过来，所以在EmployeeController里写一个toAddpage方法

```java
@GetMapping("/emp")
public String toAddpage(Model model){
    //查出所有部门的信息
    Collection<Department> departments = departmentDao.getDepartments();
    model.addAttribute("departments",departments);
    return "emp/add";
}
```

然后点击添加按钮的一瞬间会走到form表单里的一个action请求，<form th:action="@{/emp}" method="post">

然后根据这个action请求再在EmployeeController里写一个addEmp方法

```java
@PostMapping("/emp")
public String addEmp(Employee employee){
    System.out.println("save===>"+employee);
    employeeDao.save(employee);//调用底层业务方法保存员工的信息
    return "redirect:/emps";
}
```



springboot默认的日期格式是`dd/MM/yyyy`

但是可以在application.properties里手动设置一个格式

```properties
spring.mvc.date-format=yyyy-MM-dd
```

如果在添加数据的时候日期格式不正确，就会报400错误



## 八.修改员工信息

1.在list.html中的编辑处写一个 th:href="@{/emp/}+${emp.getId()}"

```html
<a class="btn btn-sm btn-primary" th:href="@{/emp/}+${emp.getId()}">编辑</a>
```

2.在EmployeeController写一个：去员工的修改页面（restful风格）的方法toUpdateEmp

```java
//model是给前端返回数据用的
@GetMapping("/emp/{id}")
public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
    //查出原来的数据
    Employee employee = employeeDao.getEmployeeById(id);
    model.addAttribute("emp",employee);

    return "emp/update";
}
```

3.增加一个update.html（复制一个add.html然后修改）

4.在EmployeeController写一个：员工信息修改的方法：updateEmp

```java
//员工信息修改
@PostMapping("updateEmp")
public String updateEmp(Employee employee){
    employeeDao.save(employee);
    return "redirect:/emps";
}
```

但是做完之后，发现没把id放在隐藏域里，就导致每次编辑完，提交以后都会新增一条而不是改变原有的数据

所以我们在update.html里把id放在隐藏域里携带过去。

```html
<!--把id放在隐藏域里携带过去-->
<input type="hidden" name="id" th:value="${emp.getId()}">
```



注意：**日期格式化**很重要，springboot会严格按照配置文件里的spring.mvc.date-format=yyyy-MM-dd去执行，如果不是这个格式，提交就会报400错误





## 九.删除以及404处理

### **删除**：修改list页面的删除处

```html
<a class="btn btn-sm btn-danger" th:href="@{/delemp/}+${emp.getId()}">删除</a>
```

在EmployeeController写一个删除方法

```java
//删除员工(restful风格）
@GetMapping("/delemp/{id}")
public String deleteEmp(@PathVariable("id")  Integer id){
    employeeDao.delete(id);
    return "redirect:/emps";
}
```



### 404处理：

在springboot中404错误处理非常简单，在templates文件夹下建一个404.html就好，报了错就自动会去找这个文件夹

500错误同理



### 注销

在commons/commons.html里面修改注销处的语句

```html
<a class="nav-link" th:href="@{/user/logout}">注销</a>
```

在LoginController里面写注销的功能

```java
//注销
@RequestMapping("/user/logout")
public String logout(HttpSession session){
    session.invalidate();
    return "redirect:/index.html";
}
```





# 第十章 如何写一个网站

前端：

- 模板：别人写好的，我们拿来改成自己需要的（百度搜索bootstrap后台模板，或者去模板之家下载，拿来自己改）
- 框架：组件 ----->自己手动组合拼接！  如Bootstrap，Layui，semantic-ui, element ui
  - 栅格系统：要知道一个页面分成多少份
  - 导航栏
  - 侧边栏
  - 表单

```
    # 1. 前端搞定：要知道页面长什么样子，才能知道数据库怎么设计

    # 2. 设计数据库(数据库设计是难点！)

    # 3. 设计数据库的同时要让前端能够自动运行（独立化工程）

    # 4. 数据接口如何对接：json，或者手动的给它传对象 all in one!

    # 5. 前后端联调测试!


        1.无论用别人的模板，还是自己写模板，都要首先保证：
                有一套自己熟悉的后台模板：工作必要！ 如x-admin
        2.前端页面：至少自己能够通过前端框架，组合出来一个网站页面
                - index(首页)
                - about(详情)
                - blog(博客)
                - post(提交)
                - user(用户) 
                至少要有这五个才能跑起来这个网站
        3.让这个网站能够独立运行！
        至少全心全意扑在这上面一个月的时间！一个月不一定能整出来，第一次是最慢的，后面就快起来了
```





# # 

# 回顾：第一章到第八章

- Spingboot是什么？
- 微服务
- 第一个springboot程序helloworld
- 探究源码~   自动装配的原理 ~ 
- 配置 yaml
- 多文档环境切换
- 静态资源映射
- Thymeleaf   th:xxx
- SpringBoot 如何扩展MVC    javaConfig~
- 如何修改springboot默认配置~
- 用springboot去简单的实现CRUD
- restful风格怎么实现
- 国际化
- 拦截器
- 定制首页，错误页



# 展望接下来要学习的和作业

- **JDBC：重点**
- **MyBatis：重点**
- **Druid：重点**
- **Shiro：安全   重点**
- **Spring Security：安全  重点**
- 异步任务~，邮件发送，定时任务
- Swagger
- Dubbo + Zookeeper

**作业**：把员工管理系统的两个实体类改成数据库里的字段，然后自己封装测试

# # 





# 第十一章 整合JDBC

## 										SpringData简介

对于数据访问层，无论是 SQL(关系型数据库) 还是 NOSQL(非关系型数据库)，Spring Boot 底层都是采用 Spring Data 的方式进行统一处理。

Spring Boot 底层都是采用 Spring Data 的方式进行统一处理各种数据库，Spring Data 也是 Spring 中与 Spring Boot、Spring Cloud 等齐名的知名项目。

Sping Data 官网：https://spring.io/projects/spring-data

数据库相关的启动器 ：可以参考官方文档：

https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#using-boot-starter







## 										整合JDBC

**原生的JDBC千万不能忘，最开始的东西忘记了后面的也学不好**

### 创建测试项目测试数据源

1、我去新建一个项目测试：springboot-data-jdbc ; 引入相应的模块！基础模块

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LYLicOHVGnwu7ibGvbwXibYeuW0A5wz8gu4q4AMoBCoYic2Juyiate9VBZe4S0sgkCZVFV2lD6quLKVZw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

2、项目建好之后，发现自动帮我们导入了如下的启动器：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

3、编写yaml配置文件连接数据库；

```yml
spring:
  datasource:
    username: root
    password: 123456
    #?serverTimezone=UTC解决时区的报错
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
```

4、配置完这一些东西后，我们就可以直接去使用了，因为SpringBoot已经默认帮我们进行了自动配置；去测试类测试一下

```java
@SpringBootTest
class SpringbootDataJdbcApplicationTests {

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);
        //关闭连接
        connection.close();
    }
}
```

结果：我们可以看到他默认给我们配置的数据源为 : class com.zaxxer.hikari.HikariDataSource ， 我们并没有手动配置

我们来全局搜索一下，找到数据源的所有自动配置都在 ：`DataSourceAutoConfiguration`文件：

```java
@Import(
    {Hikari.class, Tomcat.class, Dbcp2.class, Generic.class, DataSourceJmxConfiguration.class}
)
protected static class PooledDataSourceConfiguration {
    protected PooledDataSourceConfiguration() {
    }
}
```

这里导入的类都在 `DataSourceConfiguration` 配置类下，可以看出 Spring Boot 2.2.5 默认使用HikariDataSource 数据源，而以前版本，如 Spring Boot 1.5 默认使用 org.apache.tomcat.jdbc.pool.DataSource 作为数据源

**HikariDataSource 号称 Java WEB 当前速度最快的数据源，相比于传统的 C3P0 、DBCP、Tomcat jdbc 等连接池更加优秀；**

**可以使用 spring.datasource.type 指定自定义的数据源类型，值为 要使用的连接池实现的完全限定名。**

关于数据源我们并不做介绍，有了数据库连接，显然就可以 CRUD 操作数据库了。但是我们需要先了解一个对象 **JdbcTemplate**



### JDBCTemplate

1、有了数据源(com.zaxxer.hikari.HikariDataSource)，然后可以拿到数据库连接(java.sql.Connection)，有了连接，就可以使用原生的 JDBC 语句来操作数据库；

2、即使不使用第三方第数据库操作框架，如 MyBatis等，Spring 本身也对原生的JDBC 做了轻量级的封装，即JdbcTemplate。

3、数据库操作的所有 CRUD 方法都在` JdbcTemplate` 中。

4、Spring Boot 不仅提供了默认的数据源，同时默认已经配置好了 `JdbcTemplate` 放在了容器中，程序员只需自己注入即可使用

5、JdbcTemplate 的自动配置是依赖 org.springframework.boot.autoconfigure.jdbc 包下的` JdbcTemplateConfiguration` 类

**`JdbcTemplate`主要提供以下几类方法：**

- execute方法：可以用于执行任何SQL语句，一般用于执行DDL语句；
- update方法及batchUpdate方法：update方法用于执行新增、修改、删除等语句；batchUpdate方法用于执行批处理相关语句；
- query方法及queryForXXX方法：用于执行查询相关语句；
- call方法：用于执行存储过程、函数相关语句。

### 测试

编写一个Controller，注入 jdbcTemplate，编写测试方法进行访问测试；

```java
package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    /**
     * Spring Boot 默认提供了数据源，默认提供了 org.springframework.jdbc.core.JdbcTemplate
     * JdbcTemplate 中会自己注入数据源，用于简化 JDBC操作
     * 还能避免一些常见的错误,使用起来也不用再自己来关闭数据库连接
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询employee表中所有数据
    //List 中的1个 Map 对应数据库的 1行数据
    //Map 中的 key 对应数据库的字段名，value 对应数据库的字段值
    @GetMapping("/list")
    public List<Map<String, Object>> userList(){
        String sql = "select * from employee";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    
    //新增一个用户
    @GetMapping("/add")
    public String addUser(){
        //插入语句，注意时间问题
        String sql = "insert into employee(last_name, email,gender,department,birth)" +
                " values ('狂神说','24736743@qq.com',1,101,'"+ new Date().toLocaleString() +"')";
        jdbcTemplate.update(sql);
        //查询
        return "addOk";
    }

    //修改用户信息
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        //插入语句
        String sql = "update employee set last_name=?,email=? where id="+id;
        //数据
        Object[] objects = new Object[2];
        objects[0] = "秦疆";
        objects[1] = "24736743@sina.com";
        jdbcTemplate.update(sql,objects);
        //查询
        return "updateOk";
    }

    //删除用户
    @GetMapping("/delete/{id}")
    public String delUser(@PathVariable("id") int id){
        //插入语句
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql,id);
        //查询
        return "deleteOk";
    }
    
}
```

测试请求，结果正常；

到此，CURD的基本操作，使用 JDBC 就搞定了。





# 第十二章 整合Druid数据源

## Druid简介

Java程序很大一部分要操作数据库，为了提高性能操作数据库的时候，又不得不使用数据库连接池。

Druid 是阿里巴巴开源平台上一个数据库连接池实现，结合了 C3P0、DBCP 等 DB 池的优点，同时加入了日志监控。

Druid 可以很好的监控 DB 池连接和 SQL 的执行情况，天生就是针对监控而生的 DB 连接池。

Druid已经在阿里巴巴部署了超过600个应用，经过一年多生产环境大规模部署的严苛考验。

Spring Boot 2.0 以上默认使用 Hikari 数据源，可以说 Hikari 与 Driud 都是当前 Java Web 上最优秀的数据源，我们来重点介绍 Spring Boot 如何集成 Druid 数据源，如何实现数据库监控。

Github地址：https://github.com/alibaba/druid/

**com.alibaba.druid.pool.DruidDataSource 基本配置参数如下：**

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LYLicOHVGnwu7ibGvbwXibYeupdhDcaDPRLHgnULFbaJB5kPtC8n5QVLaUbbTRfa4ZyqficzZYrd2llA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LYLicOHVGnwu7ibGvbwXibYeubiciawTdz0tg1EKDjZ1xaIgjRW9CZ4Apr4hvNz3iaQVQIKS3sXy629Lgg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LYLicOHVGnwu7ibGvbwXibYeuaVD6mK3LJrtZ4B6fRKCLDgYicAVGzTUTzWdCNB5lF4tLpbcCT0uq1EA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



## 配置数据源

1、添加上 Druid 数据源依赖。

```xml
<!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.21</version>
</dependency>
```

2、切换数据源；之前已经说过 Spring Boot 2.0 以上默认使用 com.zaxxer.hikari.HikariDataSource 数据源，但可以 通过 spring.datasource.type 指定数据源。

```yml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource # 自定义数据源
```

3、数据源切换之后，在测试类中注入 DataSource，然后获取到它，输出一看便知是否成功切换；

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LYLicOHVGnwu7ibGvbwXibYeuuxN8UrBxIAhgFpAvyQOgKyZLVbPXRhtvVO764zeJpXiaBFTX2e4cYVQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

4、切换成功！既然切换成功，就可以设置数据源连接初始化大小、最大连接数、等待时间、最小连接数 等设置项；可以查看源码

```yml
spring:
  datasource:
    username: root
    password: 123456
    #?serverTimezone=UTC解决时区的报错
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    #Spring Boot 默认是不注入这些属性值的，需要自己绑定
    #druid 数据源专有配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，stat:监控统计、log4j：日志记录、wall：防御sql注入
    #如果允许时报错  java.lang.ClassNotFoundException: org.apache.log4j.Priority
    #则导入 log4j 依赖即可，Maven 地址：https://mvnrepository.com/artifact/log4j/log4j
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
```

5、导入Log4j 的依赖

```xml
<!-- https://mvnrepository.com/artifact/log4j/log4j -->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

6、现在需要程序员自己为 DruidDataSource 绑定全局配置文件中的参数，再添加到容器中，而不再使用 Spring Boot 的自动生成了；我们需要 自己添加 DruidDataSource 组件到容器中，并绑定属性；

```java
package com.kuang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    /*
       将自定义的 Druid数据源添加到容器中，不再让 Spring Boot 自动创建
       绑定全局配置文件中的 druid 数据源属性到 com.alibaba.druid.pool.DruidDataSource从而让它们生效
       @ConfigurationProperties(prefix = "spring.datasource")：作用就是将 全局配置文件中
       前缀为 spring.datasource的属性值注入到 com.alibaba.druid.pool.DruidDataSource 的同名参数中
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

}
```

7、去测试类中测试一下；看是否成功！

```java
@SpringBootTest
class SpringbootDataJdbcApplicationTests {

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }
}
```

输出结果 ：可见配置参数已经生效！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LYLicOHVGnwu7ibGvbwXibYeu14qkV9vFaME5ficcLe7MqPFgOH4iaEicia05eNNkSvhoVhWodykDXMtUcQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



## 配置Druid数据源监控

Druid 数据源具有监控的功能，并提供了一个 web 界面方便用户查看，类似安装 路由器 时，人家也提供了一个默认的 web 页面。

所以第一步需要设置 Druid 的后台管理页面，比如 登录账号、密码 等；配置后台管理；

```java
//配置 Druid 监控管理后台的Servlet；
//因为springboot内置了servlet容器，所以没有web.xml，但是想使用web.xml方式，就使用替代方法：ServletRegistrationBean
//内置 Servlet 容器时没有web.xml文件，所以使用 Spring Boot 的注册 Servlet 方式
@Bean
public ServletRegistrationBean statViewServlet() {
    ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

    // 这些参数可以在 com.alibaba.druid.support.http.StatViewServlet 
    // 的父类 com.alibaba.druid.support.http.ResourceServlet 中找到
    Map<String, String> initParams = new HashMap<>();
    initParams.put("loginUsername", "admin"); //后台管理界面的登录账号
    initParams.put("loginPassword", "123456"); //后台管理界面的登录密码

    //后台允许谁可以访问
    //initParams.put("allow", "localhost")：表示只有本机可以访问
    //initParams.put("allow", "")：为空或者为null时，表示允许所有访问
    initParams.put("allow", "");
    //deny：Druid 后台拒绝谁访问
    //initParams.put("kuangshen", "192.168.1.20");表示禁止此ip访问

    //设置初始化参数
    bean.setInitParameters(initParams);
    return bean;
}
```

配置完毕后，我们可以选择访问 ：http://localhost:8080/druid/login.html

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LYLicOHVGnwu7ibGvbwXibYeu5TbyjT1Hib2vCDW9988ibXicDcXEnvooGfvNbchJrZ7TUwe3wJm0ktooA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

进入之后

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LYLicOHVGnwu7ibGvbwXibYeuaibKTBtqpoSiaZib9WTRdZaZhIYBRLB8Em7a5aLGw88uKjR8UCian11yCg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



### **配置 Druid web 监控 filter 过滤器**

```java
//配置 Druid 监控 之  web 监控的 filter
//因为springboot内置了servlet容器，所以没有web.xml，但是想使用web.xml方式，就使用替代方法：FilterRegistrationBean
//WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
@Bean
public FilterRegistrationBean webStatFilter() {
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.setFilter(new WebStatFilter());

    //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
    Map<String, String> initParams = new HashMap<>();
    initParams.put("exclusions", "*.js,*.css,/druid/*,/jdbc/*");
    bean.setInitParameters(initParams);

    //"/*" 表示过滤所有请求
    bean.setUrlPatterns(Arrays.asList("/*"));
    return bean;
}
```

平时在工作中，按需求进行配置即可，主要用作监控！



# 第十三章 整合MyBatis框架



## 整合之前的准备

**这个整合的框架和springboot的版本要关联，比如**![image-20220825072946302](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220825072946302.png)![image-20220825072958050](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220825072958050.png)

如果springboot的版本过高（如2.7.2），会导致自动装配失败

**tips：**

```
//这个注解表示了这是一个mybatis的mapper类
@Mapper
public interface UserMapper {
}
这里的@Mapper就相当于以前的包扫描

现在仍可使用包扫描：
在Springboot05MybatisApplication里加上
@SpringBootApplication
@MapperScan("com.zy.mapper")
public class Springboot05MybatisApplication {

这两个用法的效果是一样的，一个是直接在mapper包下的类进行@Mapper注解，一个是在主程序的头上加上mapper包的包扫描@MapperScan("com.zy.mapper")

```





官方文档：http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

Maven仓库地址：https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter/2.1.1

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KJtP0ZFbTV1gOh8TWzQjj5M0AoJvS3kvTvat9dyzbb71tQicKdTQ31PiaH8nicEx6GpaPgmcA2Qyhxg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

## 整合mybatis测试

**1、导入 MyBatis 所需要的依赖**

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.1</version>
</dependency>
```

**2、配置数据库连接信息（不变）**

```yml
spring:
  datasource:
    username: root
    password: 123456
    #?serverTimezone=UTC解决时区的报错
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    #Spring Boot 默认是不注入这些属性值的，需要自己绑定
    #druid 数据源专有配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，stat:监控统计、log4j：日志记录、wall：防御sql注入
    #如果允许时报错  java.lang.ClassNotFoundException: org.apache.log4j.Priority
    #则导入 log4j 依赖即可，Maven 地址：https://mvnrepository.com/artifact/log4j/log4j
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
```

**3、测试数据库是否连接成功！**

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05MybatisApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

}

```

**4、创建实体类，导入 Lombok！**

User.java

```java
package com.zy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;
}
```



**5、创建mapper目录以及对应的 Mapper 接口**

UserMapper.java

```java
//这个注解表示了这是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();  //查询所有用户

    User queryUserById(int id);  //通过id查询用户

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
```

**6、对应的Mapper映射文件**

UserMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.zy.mapper.UserMapper">

    <select id="queryUserList" resultType="User">
        select  * from user;
    </select>

    <select id="queryUserById" resultType="User">
        select * from user where id=#{id}
    </select>

    <insert id="addUser" parameterType="User">
        insert into user (id,name,pwd) values (#{id},#{name},#{pwd})
    </insert>

    <update id="updateUser" parameterType="User">
        update user set name=#{name},pwd=#{pwd} where id=#{id}
    </update>

    <delete id="deleteUser" parameterType="User">
        delete from user where id=#{id}
    </delete>

</mapper>
```



**7、maven配置资源过滤问题**

```xml
<resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
    </resource>
</resources>
```

**8、编写用户的 UserController 进行测试！**

```java
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(4,"zz","123"));
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(4,"zx","122"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(4);
        return "ok";
    }
}
```

**启动项目访问进行测试！**



## 作业：完成员工管理系统两个实体类改成数据库里的字段，然后自己封装测试

创建两个实体类department,employee，把相应的依赖导过来，把application.properties配置完整，并进行以上八步，然后进行测试即可。

依赖：

```xml
1.mybatis-spring-boot-starter
2.spring-boot-starter-jdbc
3.mysql-connector-java
```

具体步骤如下：（看kuang博客）

步骤总结：

1.导入包

2.配置文件

3.mybatis配置

4.编写sql

5.service层调用dao层

6.controller调用service层



## MVC三层架构的理解：

MVC：

M：数据和业务

V：HTML等前端

C：负责前端和后端的交接





# 第十四章 SpringSecurity（安全）

写一个最简单的测试一下这个页面长什么样子：

首先来个controller.RouterController.java(就是专门跳路由的)

## 安全简介

在 Web 开发中，安全一直是非常重要的一个方面。安全虽然属于应用的非功能性需求，但是应该在应用开发的初期就考虑进来。如果在应用开发的后期才考虑安全的问题，就可能陷入一个两难的境地：一方面，应用存在严重的安全漏洞，无法满足用户的要求，并可能造成用户的隐私数据被攻击者窃取；另一方面，应用的基本架构已经确定，要修复安全漏洞，可能需要对系统的架构做出比较重大的调整，因而需要更多的开发时间，影响应用的发布进程。因此，从应用开发的第一天就应该把安全相关的因素考虑进来，并在整个应用的开发过程中。

市面上存在比较有名的：Shiro，Spring Security ！

这里需要阐述一下的是，每一个框架的出现都是为了解决某一问题而产生了，那么Spring Security框架的出现是为了解决什么问题呢？

首先我们看下它的官网介绍：Spring Security官网地址

Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications.

Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. Like all Spring projects, the real power of Spring Security is found in how easily it can be extended to meet custom requirements

Spring Security是一个功能强大且高度可定制的身份验证和访问控制框架。它实际上是保护基于spring的应用程序的标准。

Spring Security是一个框架，侧重于为Java应用程序提供身份验证和授权。与所有Spring项目一样，Spring安全性的真正强大之处在于它可以轻松地扩展以满足定制需求

从官网的介绍中可以知道这是一个权限框架。想我们之前做项目是没有使用框架是怎么控制权限的？对于权限 一般会细分为功能权限，访问权限，和菜单权限。代码会写的非常的繁琐，冗余。

怎么解决之前写权限代码繁琐，冗余的问题，一些主流框架就应运而生而Spring Scecurity就是其中的一种。

Spring 是一个非常流行和成功的 Java 应用开发框架。Spring Security 基于 Spring 框架，提供了一套 Web 应用安全性的完整解决方案。一般来说，Web 应用的安全性包括用户认证（Authentication）和用户授权（Authorization）两个部分。用户认证指的是验证某个用户是否为系统中的合法主体，也就是说用户能否访问该系统。用户认证一般要求用户提供用户名和密码。系统通过校验用户名和密码来完成认证过程。用户授权指的是验证某个用户是否有权限执行某个操作。在一个系统中，不同用户所具有的权限是不同的。比如对一个文件来说，有的用户只能进行读取，而有的用户可以进行修改。一般来说，系统会为不同的用户分配不同的角色，而每个角色则对应一系列的权限。

对于上面提到的两种应用情景，Spring Security 框架都有很好的支持。在用户认证方面，Spring Security 框架支持主流的认证方式，包括 HTTP 基本认证、HTTP 表单验证、HTTP 摘要认证、OpenID 和 LDAP 等。在用户授权方面，Spring Security 提供了基于角色的访问控制和访问控制列表（Access Control List，ACL），可以对应用中的领域对象进行细粒度的控制。



## 实战测试

### 实验环境搭建

1、新建一个初始的springboot项目web模块，thymeleaf模块

2、导入静态资源

```
welcome.html
|views
|level1
1.html
2.html
3.html
|level2
1.html
2.html
3.html
|level3
1.html
2.html
3.html
Login.html
```

3、controller跳转！

```java
package com.zy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    //想办法让它进入首页
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    //想办法让它进入login页
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }

    //想办法让它进入views/level*.*.html
    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }

}

```

4、测试实验环境是否OK！



### 认识SpringSecurity

Spring Security 是针对Spring项目的安全框架，也是Spring Boot底层安全模块默认的技术选型，他可以实现强大的Web安全控制，对于安全控制，我们仅需要引入 spring-boot-starter-security 模块，进行少量的配置，即可实现强大的安全管理！

记住几个类：

- WebSecurityConfigurerAdapter：自定义Security策略
- AuthenticationManagerBuilder：自定义认证策略
- @EnableWebSecurity：开启WebSecurity模式     (@Enablexxxxxxx：开启某个功能)

Spring Security的两个主要目标是 “认证” 和 “授权”（访问控制）。

**“认证”（Authentication）**

身份验证是关于验证您的凭据，如用户名/用户ID和密码，以验证您的身份。

身份验证通常通过用户名和密码完成，有时与身份验证因素结合使用。

 **“授权” （Authorization）**

授权发生在系统成功验证您的身份后，最终会授予您访问资源（如信息，文件，数据库，资金，位置，几乎任何内容）的完全权限。

这个概念是通用的，而不是只在Spring Security 中存在



### 认证和授权

目前，我们的测试环境，是谁都可以访问的，我们使用 Spring Security 增加上认证和授权的功能

1、引入 Spring Security 模块

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2、编写 Spring Security 配置类

参考官网：https://spring.io/projects/spring-security 

查看我们自己项目中的版本，找到对应的帮助文档：

https://docs.spring.io/spring-security/site/docs/5.3.0.RELEASE/reference/html5  #servlet-applications 8.16.4

如下图，这是个固定的架子

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JolV3xA4rEtxSCgbN76QbXheImAPwVia7gtcx2cNCUXAXbCJpst1geQCOElXLQMMvAibMLmYNqXF5g/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

3、编写基础配置类

```java
package com.zy.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 开启WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         
    }
}
```

4、定制请求的授权规则

```java
    //授权
                    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level1/**").hasRole("vip2")
                .antMatchers("/level1/**").hasRole("vip3");
```

5.测试一下：发现除了首页都进不去了！因为我们目前没有登录的角色，因为请求需要登录的角色拥有对应的权限才可以！

6、在configure()方法中加入以下配置，开启自动配置的登录功能！

```java
// 开启自动配置的登录功能
// /login 请求来到登录页
// /login?error 重定向到这里表示登录失败
http.formLogin();
```

7、测试一下：发现，没有权限的时候，会跳转到登录的页面！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JolV3xA4rEtxSCgbN76QbXMBrh9xGQDQjlW4EpV2DscJbUzAMwjqIGGgw8fqWET4swGIue9mbwwQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

8、查看刚才登录页的注释信息；

我们可以定义认证规则，重写configure(AuthenticationManagerBuilder auth)方法

```java
//定义认证规则
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   
   //在内存中定义，也可以在jdbc中去拿....
   auth.inMemoryAuthentication()
          .withUser("kuangshen").password("123456").roles("vip2","vip3")
          .and()
          .withUser("root").password("123456").roles("vip1","vip2","vip3")
          .and()
          .withUser("guest").password("123456").roles("vip1","vip2");
}
```

![image-20220825222625709](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220825222625709.png)





9、测试，我们可以使用这些账号登录进行测试！发现会报错！

There is no PasswordEncoder mapped for the id “null”

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JolV3xA4rEtxSCgbN76QbXSHnC5kd7W2DeryMuzoSOx3evDWoqlVIoGxBA3TEjAF54s4cRQsld0g/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

10、原因，我们要将前端传过来的密码进行某种方式加密，否则就无法登录，修改代码

```java
//定义认证规则
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   //在内存中定义，也可以在jdbc中去拿....
   //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
   //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
   //spring security 官方推荐的是使用bcrypt加密方式。
   
   auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
        .and()
        .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
        .and()
        .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2");
}
```

11、测试，发现，登录成功，并且每个角色只能访问自己认证下的规则！搞定

如果该角色访问非自己认证下的规则，则会产生如下报错![image-20220825222346354](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220825222346354.png)



### 权限控制和注销

1、开启自动配置的注销的功能

```java
//定制请求的授权规则
@Override
protected void configure(HttpSecurity http) throws Exception {
   //....
   //开启自动配置的注销的功能
      // /logout 注销请求
   http.logout();
}
```

2、我们在前端，增加一个注销的按钮，index.html 导航栏中

```html
<a class="item" th:href="@{/logout}">
   <i class="sign-out icon"></i> 注销
</a>
```

3、我们可以去测试一下，登录成功后点击注销，发现注销完毕会跳转到登录页面！

4、但是，我们想让他注销成功后，依旧可以跳转到首页，该怎么处理呢？

```java
// .logoutSuccessUrl("/"); 注销成功来到首页
http.logout().logoutSuccessUrl("/");
```

5、测试，注销完毕后，发现跳转到首页OK

6、我们现在又来一个需求：用户没有登录的时候，导航栏上只显示登录按钮，用户登录之后，导航栏可以显示登录的用户信息及注销按钮！还有就是，比如kuangshen这个用户，它只有 vip2，vip3功能，那么登录则只显示这两个功能，而vip1的功能菜单不显示！这个就是真实的网站情况了！该如何做呢？

**我们需要结合thymeleaf中的一些功能**

sec：authorize="isAuthenticated()":是否认证登录！来显示不同的页面

Maven依赖：

```xml
<!-- https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity4 -->
<!--thymeleaf-security整合包-->
<dependency>
   <groupId>org.thymeleaf.extras</groupId>
   <artifactId>thymeleaf-extras-springsecurity5</artifactId>
   <version>3.0.4.RELEASE</version>
</dependency>

这个整合包对于springboot的支持版本也有要求，高于2.0.9.RELEASE的就不支持了，不然就算引入了下面的第七步，也不会生效，但是用这个版本页面会变得有点丑
```

7、修改我们的 前端页面

1. 导入命名空间

2. ```html
   xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5"
   ```

3. 修改导航栏，增加认证判断

4. ```html
   <!--登录注销-->
   <div class="right menu">
       <!--如果未登录-->
       <div sec:authorize="!isAuthenticated()">
           <a class="item" th:href="@{/toLogin}">
               <i class="address card icon"></i> 登录
           </a>
       </div>
       <!--如果已登录：显示用户名和注销按钮-->
       <div sec:authorize="isAuthenticated()">
           <a class="item">
               用户名： <span sec:authentication="name"></span>
               <!-- 角色：  <span sec:authentication="principal.getAuthorities()"></span>-->
           </a>
       </div>
       <div sec:authorize="isAuthenticated()">
           <a class="item" th:href="@{/logout}">
               <i class="sign-out icon"></i> 注销
           </a>
       </div>
   </div>
   ```

5. 8、重启测试，我们可以登录试试看，登录成功后确实，显示了我们想要的页面；

6. 

7. 9、如果注销("/logout")404了，就是因为它默认防止csrf跨站请求伪造，因为会产生安全问题，我们可以将请求改为post表单提交，或者在spring security中关闭csrf功能；我们试试：在 配置中增加 `http.csrf().disable();`

8. ```java
   http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求.注销失败可能的原因
   http.logout().logoutSuccessUrl("/");
   ```

9. 10、我们继续将下面的角色功能块认证完成！

10. ```html
    <!-- sec:authorize="hasRole('vip1')" -->
    <!--菜单根据用户的角色动态的实现：有vip几就显示vip几的权限内容-->
    <div class="column" sec:authorize="hasRole('vip1')"> <!--sec这个东西表示如果有vip1，就显示下面的div-->
       <div class="ui raised segment">
           <div class="ui">
               <div class="content">
                   <h5 class="content">Level 1</h5>
                   <hr>
                   <div><a th:href="@{/level1/1}"><i class="bullhorn icon"></i> Level-1-1</a></div>
                   <div><a th:href="@{/level1/2}"><i class="bullhorn icon"></i> Level-1-2</a></div>
                   <div><a th:href="@{/level1/3}"><i class="bullhorn icon"></i> Level-1-3</a></div>
               </div>
           </div>
       </div>
    </div>
    
    <div class="column" sec:authorize="hasRole('vip2')">
       <div class="ui raised segment">
           <div class="ui">
               <div class="content">
                   <h5 class="content">Level 2</h5>
                   <hr>
                   <div><a th:href="@{/level2/1}"><i class="bullhorn icon"></i> Level-2-1</a></div>
                   <div><a th:href="@{/level2/2}"><i class="bullhorn icon"></i> Level-2-2</a></div>
                   <div><a th:href="@{/level2/3}"><i class="bullhorn icon"></i> Level-2-3</a></div>
               </div>
           </div>
       </div>
    </div>
    
    <div class="column" sec:authorize="hasRole('vip3')">
       <div class="ui raised segment">
           <div class="ui">
               <div class="content">
                   <h5 class="content">Level 3</h5>
                   <hr>
                   <div><a th:href="@{/level3/1}"><i class="bullhorn icon"></i> Level-3-1</a></div>
                   <div><a th:href="@{/level3/2}"><i class="bullhorn icon"></i> Level-3-2</a></div>
                   <div><a th:href="@{/level3/3}"><i class="bullhorn icon"></i> Level-3-3</a></div>
               </div>
           </div>
       </div>
    </div>
    ```

11. 11、测试一下！

12. 12、权限控制和注销搞定！

### 记住我

现在的情况，我们只要登录之后，关闭浏览器，再登录，就会让我们重新登录，但是很多网站的情况，就是有一个记住密码的功能，这个该如何实现呢？很简单

1、开启记住我功能

```java
//定制请求的授权规则
@Override
protected void configure(HttpSecurity http) throws Exception {
//...............
   //记住我
   http.rememberMe();
}
```

2、我们再次启动项目测试一下，发现登录页多了一个记住我功能，我们登录之后关闭 浏览器，然后重新打开浏览器访问，发现用户依旧存在！

思考：如何实现的呢？其实非常简单

我们可以查看浏览器的cookie

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JolV3xA4rEtxSCgbN76QbXqDg8FodHRKUM8K5z79zEghbybrKD6WtqO0B9JBkD6FQNQ6dhARQsTA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

3、我们点击注销的时候，可以发现，spring security 帮我们自动删除了这个 cookie

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JolV3xA4rEtxSCgbN76QbXS8kt9d3jGhJPZGNa5V97ZKVBIUNdHmtPibNia7U59tbfQyzla4mHFtYg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

4、结论：登录成功后，将cookie发送给浏览器保存，以后登录带上这个cookie，只要通过检查就可以免登录了。如果点击注销，则会删除这个cookie，具体的原理我们在JavaWeb阶段都讲过了，这里就不在多说了！ 



### 定制登录页

现在这个登录页面都是spring security 默认的，怎么样可以使用我们自己写的Login界面呢？

1、在刚才的登录页配置后面指定 loginpage

```java
http.formLogin().loginPage("/toLogin");
```

2、然后前端也需要指向我们自己定义的 login请求

```html
<a class="item" th:href="@{/toLogin}">
   <i class="address card icon"></i> 登录
</a>
```

**tips(小扩展)**： /*

如果这里非要去login界面登录而不是到toLogin，那第1步的定制登录页就要改成

```
http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");

且th:href这里要把toLogin改成login，这样就是说虽然登录页是toLogin，但是其实是在login页面进行实际登录。
但是源码默认这种方法接收的参数叫username和password，如果传的参数名称不是这个，就会登录出错，但是我们可以手动定制参数名称，比如：前端传的参数是user和pwd，那就可以改成：     http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");

```

这样定制完参数以后，前端login.html中就变成了这样：

```html
<form th:action="@{/login}" method="post">
   <div class="field">
       <label>Username</label>
       <div class="ui left icon input">
           <input type="text" placeholder="Username" name="user">
           <i class="user icon"></i>
       </div>
   </div>
   <div class="field">
       <label>Password</label>
       <div class="ui left icon input">
           <input type="password" name="pwd">
           <i class="lock icon"></i>
       </div>
   </div>
   <input type="submit" class="ui blue submit button"/>
</form>
```

*/



3、我们登录，需要将这些信息发送到哪里，我们也需要配置，login.html 配置提交请求及方式，方式必须为post:

在 loginPage()源码中的注释上有写明：

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JolV3xA4rEtxSCgbN76QbXCxA0YjyGXDmBHOMYfpwolJ5yZxvMAINJRvTx7HBwyTtO4azI2QuqdA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

```html
<form th:action="@{/login}" method="post">
   <div class="field">
       <label>Username</label>
       <div class="ui left icon input">
           <input type="text" placeholder="Username" name="username">
           <i class="user icon"></i>
       </div>
   </div>
   <div class="field">
       <label>Password</label>
       <div class="ui left icon input">
           <input type="password" name="password">
           <i class="lock icon"></i>
       </div>
   </div>
   <input type="submit" class="ui blue submit button"/>
</form>
```

4、这个请求提交上来，我们还需要验证处理，怎么做呢？我们可以查看formLogin()方法的源码！我们配置接收登录的用户名和密码的参数！

```java
http.formLogin()
  .usernameParameter("username")
  .passwordParameter("password")
  .loginPage("/toLogin")
  .loginProcessingUrl("/login"); // 登陆表单提交请求
```

5、在登录页增加记住我的多选框

```html
<input type="checkbox" name="remember"> 记住我
```

6、后端验证处理！

```java
//定制记住我的参数！
http.rememberMe().rememberMeParameter("remember");
```

7、测试，OK





## 完整配置代码

```java
package com.zy.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   //定制请求的授权规则
   @Override
   protected void configure(HttpSecurity http) throws Exception {

       http.authorizeRequests().antMatchers("/").permitAll()
      .antMatchers("/level1/**").hasRole("vip1")
      .antMatchers("/level2/**").hasRole("vip2")
      .antMatchers("/level3/**").hasRole("vip3");


       //开启自动配置的登录功能：如果没有权限，就会跳转到登录页面！
           // /login 请求来到登录页
           // /login?error 重定向到这里表示登录失败
       http.formLogin()
          .usernameParameter("username")
          .passwordParameter("password")
          .loginPage("/toLogin")
          .loginProcessingUrl("/login"); // 登陆表单提交请求

       //开启自动配置的注销的功能
           // /logout 注销请求
           // .logoutSuccessUrl("/"); 注销成功来到首页

       http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
       http.logout().logoutSuccessUrl("/");

       //记住我
       http.rememberMe().rememberMeParameter("remember");
  }

   //定义认证规则
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //在内存中定义，也可以在jdbc中去拿....
       //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
       //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
       //spring security 官方推荐的是使用bcrypt加密方式。

       auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
              .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
              .and()
              .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
              .and()
              .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2");
  }
}
```





# 第十五章 Swagger

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9ZTC6jIsjNx49oFBGgaKyeYOEwIDAabKy11vOWkXYau0uYkH2RG5Rkvg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

学习目标：

- 了解Swagger的作用和概念
- 了解前后端分离
- 在Springboot中集成Swagger自动生成API文档



## Swagger简介

**前后端分离**

- 前端 -> 前端控制层、视图层
  - 伪造后端数据：json。已经存在了，不需要后端，前端工程依旧能跑起来
- 后端 -> 后端控制层、服务层、数据访问层
- 前后端通过API进行交互
- 前后端相对独立且松耦合

**产生的问题**

- 前后端集成，前端或者后端无法做到“及时协商，尽早解决”，最终导致问题集中爆发

**解决方案**

- 首先定义schema [ 计划的提纲 ]，并实时跟踪最新的API，降低集成风险
- 早些年，制定word计划文档；
- 前后端分离：
  - 前端测试后端接口：postman
  - 后端提供接口，需要实时更新最新的消息及改动！

**Swagger**

- 号称世界上最流行的API框架
- Restful Api 文档在线自动生成器 => **API 文档 与API 定义同步更新**
- 直接运行，可以在线测试API
- 支持多种语言 （如：Java，PHP等）
- 官网：https://swagger.io/



在项目中使用Swagger

## SpringBoot集成Swagger

**SpringBoot集成Swagger** => **springfox**，两个jar包

- **Springfox-swagger2**
- swagger-springmvc



**使用Swagger**

要求：jdk 1.8 + 否则swagger2无法运行

步骤：

1、新建一个SpringBoot-web项目

2、添加Maven依赖

```xml
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger2</artifactId>
   <version>2.9.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>2.9.2</version>
</dependency>
```

3、编写HelloController，测试确保运行成功！

4、要使用Swagger，我们需要编写一个配置类-SwaggerConfig来配置 Swagger

```java
@Configuration //配置类
@EnableSwagger2// 开启Swagger2的自动配置
public class SwaggerConfig {  
}
```

5、访问测试 ：http://localhost:8080/swagger-ui.html ，可以看到swagger的界面；

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9ZzSgcwYhS2RhtRXv0Wfg9OkiaE6xDEQibt8TSJTt9OHzFzeq9NrQCJNZQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



## 配置Swagger

1、Swagger实例Bean是Docket，所以通过配置Docket实例来配置Swaggger。

```java
@Bean //配置docket以配置Swagger具体参数
public Docket docket() {
   return new Docket(DocumentationType.SWAGGER_2);
}
```

2、可以通过apiInfo()属性配置文档信息

```java
//配置文档信息
private ApiInfo apiInfo() {
   Contact contact = new Contact("联系人名字", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
   return new ApiInfo(
           "Swagger学习", // 标题
           "学习演示如何配置Swagger", // 描述
           "v1.0", // 版本
           "http://terms.service.url/组织链接", // 组织链接
           contact, // 联系人信息
           "Apach 2.0 许可", // 许可
           "许可链接", // 许可连接
           new ArrayList<>()// 扩展
  );
}

比如：
    //配置Swagger信息=apiInfo()
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("钟懿", "https://www.baidu.com/", "1344602406@qq.com");

        return new ApiInfo("我的SwaggerAPI文档",
               "云在青天水在瓶",
               "1.0",
               "https://www.baidu.com/",
                contact,
               "Apache 2.0",
               "http://www.apache.org/licenses/LICENSE-2.0",
               new ArrayList());
    }
```

3、Docket 实例关联上 apiInfo()

```java
@Bean
public Docket docket() {
   return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
}
```

4、重启项目，访问测试 http://localhost:8080/swagger-ui.html  看下效果；





## 配置扫描接口

![image-20220827112246668](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220827112246668.png)

配置扫描接口就是指定要不要扫描出这些接口来或者具体扫描出哪一个来

Docket.select()   

1、构建Docket时通过select()方法配置怎么扫描接口。

```java
@Bean
public Docket docket() {
   return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
      .apis(RequestHandlerSelectors.basePackage("com.zy.swagger.controller"))
      .build();  
}
```

2、重启项目测试，由于我们配置根据包的路径扫描接口，所以我们只能看到一个类

3、除了通过包路径配置扫描接口外，还可以通过配置其他方式扫描接口，这里注释一下所有的配置方式：

```java
// 扫描所有，项目中的所有接口都会被扫描到
any()
// 不扫描接口
none() 
// 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
withMethodAnnotation(final Class<? extends Annotation> annotation)
// 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
withClassAnnotation(final Class<? extends Annotation> annotation)
// 根据包路径扫描接口(常用)
basePackage(final String basePackage) 
```

4、除此之外，我们还可以配置接口扫描过滤：( **paths(PathSelectors.ant())**，过滤什么路径 )

```java
@Bean
public Docket docket() {
   return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
      .apis(RequestHandlerSelectors.basePackage("com.zy.swagger.controller"))
       // 配置如何通过path过滤,过滤什么路径（这里就是过滤/zy下面的东西）
      .paths(PathSelectors.ant("/zy/**"))
      .build();
}
```

5、这里的可选值还有

```java
any() // 任何请求都扫描
none() // 任何请求都不扫描
regex(final String pathRegex) // 通过正则表达式控制
ant(final String antPattern) // 通过ant()控制
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9Zbja0VwsQkjaNVC5GWsge3SlQeg0jmxdjBMLOoOsqqD6gc6jshv4Qdw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)





## 配置Swagger开关

1、通过**enable()**方法配置是否启用swagger，如果是**false**，swagger将**不能在浏览器中访问**了

```java
@Bean
public Docket docket() {
   return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .enable(false) //配置是否启用Swagger，如果是false，在浏览器将无法访问
      .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
      .apis(RequestHandlerSelectors.basePackage("com.zy.swagger.controller"))
       // 配置如何通过path过滤,过滤什么路径
      .paths(PathSelectors.ant("/zy/**"))
      .build();
}
```

2、如何动态配置当项目处于test、dev环境时显示swagger，处于prod时不显示？

```java
@Bean
public Docket docket(Environment environment) {
   // 设置要显示swagger的环境
   Profiles profiles = Profiles.of("dev", "test");
   // 判断当前是否处于该环境
   // 通过environment.acceptsProfiles（环境监听变量）判断是否处在自己设定的环境当中
   boolean flag = environment.acceptsProfiles(profiles);
   
   return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .enable(flag) //配置是否启用Swagger，如果是false，在浏览器将无法访问
      .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
      .apis(RequestHandlerSelectors.basePackage("com.zy.swagger.controller"))
       // 配置如何通过path过滤,过滤什么路径
      .paths(PathSelectors.ant("/zy/**"))
      .build();
}
```

然后设置properties文件进行切换

![image-20220827140538999](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220827140538999.png)



3、可以在项目中增加一个dev的配置文件查看效果！

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9Zf87yQGBYZKyqCsjP79C67S0NgdOmrQWJ7tkpPsdkrWQeQiaIZia7VD8w/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)



## 配置API分组

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9Z7k4Y8iaVnHtPd78o82ff8hItej9Cyf0wvbG8u8KgXic7gVh77NoZw4RQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

1、如果没有配置分组，默认是default。通过groupName()方法即可配置分组：

```java
@Bean
public Docket docket(Environment environment) {
   return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
      .groupName("zhongyi") // 配置分组
       // 省略配置....
}
```

2、重启项目查看分组

![image-20220827140409736](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220827140409736.png)



3、如何配置多个分组？配置多个分组只需要配置多个Docket实例即可:

```java
@Bean
public Docket docket1(){
   return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
}
@Bean
public Docket docket2(){
   return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
}
@Bean
public Docket docket3(){
   return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
}
```

4、重启项目查看即可



## 实体类配置

API中Models的位置的配置

1、新建一个实体类

```java
@ApiModel("用户实体类")
public class User {
   @ApiModelProperty("用户名")
   public String username;
   @ApiModelProperty("密码")
   public String password;
}
```

2、只要这个实体在**请求接口**的返回值上（即使是泛型），都能映射到实体项中：

```
//只要我们的接口中的返回值中存在实体类，他就会被扫描到Swagger中
下面这整个User()方法就是一个接口
```

```java
//只要我们的接口中的返回值中存在实体类，他就会被扫描到Swagger中
@RequestMapping("/User")
public User User(){
   return new User();
}
```

3、重启查看测试

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9ZS0qBoaXrHX5r42ic5kUDzv5gaiaVqVeMBne4TDe5JLRPqRShgY3WiaQPg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

注：并不是因为@ApiModel这个注解让实体显示在这里了，而是只要出现在接口方法的返回值上的实体都会显示在这里，而@ApiModel和@ApiModelProperty这两个注解只是为实体添加注释的。

@ApiModel为类添加注释

@ApiModelProperty为类属性添加注释



## 常用注解

Swagger的所有注解定义在io.swagger.annotations包下

下面列一些经常用到的，未列举出来的可以另行查阅说明：

| Swagger注解                                            | 简单说明                                             |
| ------------------------------------------------------ | ---------------------------------------------------- |
| @Api(tags = "xxx模块说明")                             | 作用在模块类上                                       |
| @ApiOperation("xxx接口说明")                           | 作用在接口方法上                                     |
| @ApiModel("xxxPOJO说明")                               | 作用在模型类上：如VO、BO                             |
| @ApiModelProperty(value = "xxx属性说明",hidden = true) | 作用在类方法和属性上，hidden设置为true可以隐藏该属性 |
| @ApiParam("xxx参数说明")                               | 作用在参数、方法和字段上，类似@ApiModelProperty      |

我们也可以给请求的接口配置一些注释

```java
@ApiOperation("钟懿的接口")
@PostMapping("/zy")
@ResponseBody
public String kuang(@ApiParam("这个名字会被返回")String username){
   return username;
}
```

```java
package com.zy.swagger.controller;

import com.zy.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //只要我们的接口中的返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping("/user")
    public User user(){
        return new User();
    }


    //Operation接口,不是放在类上的，是方法
    @ApiOperation("Hello控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名")String username){
        return "hello"+username;
    }

    @ApiOperation("Post测试类")
    @PostMapping("/postTest")
    public User postTest(@ApiParam("用户名")User user){
        int i =5/0;
        return user;
    }
}
```

这样的话，可以给一些比较难理解的属性或者接口，增加一些配置信息，让人更容易阅读！

相较于传统的Postman或Curl方式测试接口，使用swagger简直就是傻瓜式操作，不需要额外说明文档(写得好本身就是文档)而且更不容易出错，只需要录入数据然后点击Execute，如果再配合自动化框架，可以说基本就不需要人为操作了。

Swagger是个优秀的工具，现在国内已经有很多的中小型互联网公司都在使用它，相较于传统的要先出Word接口文档再测试的方式，显然这样也更符合现在的快速迭代开发行情。当然了，提醒下大家在正式环境要记得关闭Swagger，一来出于安全考虑二来也可以节省运行时内存。

## 拓展：其他皮肤

我们可以导入不同的包实现不同的皮肤定义：

1、默认的  **访问 http://localhost:8080/swagger-ui.html**

```xml
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>2.9.2</version>
</dependency>
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9ZrYUroibnsmILAYo1PyuaSDAkrqUvlNibxW9S9niaRomPFd9rrD6SY4wjA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

2、bootstrap-ui  **访问 http://localhost:8080/doc.html**

```xml
<!-- 引入swagger-bootstrap-ui包 /doc.html-->
<dependency>
   <groupId>com.github.xiaoymin</groupId>
   <artifactId>swagger-bootstrap-ui</artifactId>
   <version>1.9.1</version>
</dependency>
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9ZxQ9fXkPFt9TtX6PiaPDWWFSCJQK6H0ibiagM2w2f99zqHuOJffyRycCIg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

3、Layui-ui  **访问 http://localhost:8080/docs.html**

```xml
<!-- 引入swagger-ui-layer包 /docs.html-->
<dependency>
   <groupId>com.github.caspar-chen</groupId>
   <artifactId>swagger-ui-layer</artifactId>
   <version>1.1.3</version>
</dependency>
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9ZYA6g5VyspYIqFMokAGg7dbx47P2ibC8Z80saA7XdrByPFhgmrduSHbA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

4、mg-ui  **访问 http://localhost:8080/document.html**

```xml
<!-- 引入swagger-ui-layer包 /document.html-->
<dependency>
   <groupId>com.zyplayer</groupId>
   <artifactId>swagger-mg-ui</artifactId>
   <version>1.0.6</version>
</dependency>
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IExpkhknhzRFQicsic8yibm9ZBJPCcHFicV2dklg3l88IuYia3OIFNfNVbWZXpppPS93jghTUJiaeJQx6Q/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)





## 总结：

1. 我们可以通过Swagger给一些比较难理解的属性或接口，增加注释信息
2. 接口文档实时更新
3. 可以在线测试

【注意点】在正式发布的时候，关闭Swagger！！！一来出于安全考虑二来也可以节省运行时内存。

【掌握点】怎么给Swagger上面写一个注释，会简单操作Swagger页面，以及会把下图所示处标志成自己的就OK了

![image-20220827201717749](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220827201717749.png)



# 第十六章 异步、定时、邮件任务

## 前言

>在我们的工作中，常常会用到异步处理任务，比如我们在网站上发送邮件，后台会去发送邮件，此时前台会造成响应不动，直到邮件发送完毕，响应才会成功，所以我们一般会采用多线程的方式去处理这些任务。还有一些定时任务，比如需要在每天凌晨的时候，分析一次前一天的日志信息。还有就是邮件的发送，微信的前身也是邮件服务呢？这些东西都是怎么实现的呢？其实SpringBoot都给我们提供了对应的支持，我们上手使用十分的简单，只需要开启一些注解支持，配置一些配置文件即可！那我们来看看吧~  



## 异步任务

1、创建一个service包

2、创建一个类AsyncService

异步处理还是非常常用的，比如我们在网站上发送邮件，后台会去发送邮件，此时前台会造成响应不动，直到邮件发送完毕，响应才会成功，所以我们一般会采用多线程的方式去处理这些任务。

编写方法，假装正在处理数据，使用线程设置一些延时，模拟同步等待的情况；

```java
@Service
public class AsyncService {

   public void hello(){
       try {
           Thread.sleep(3000);
      } catch (InterruptedException e) {
           e.printStackTrace();
      }
       System.out.println("业务进行中....");
  }
}
```

3、编写controller包

4、编写AsyncController类

我们去写一个Controller测试一下

```java
@RestController
public class AsyncController {

   @Autowired
   AsyncService asyncService;

   @GetMapping("/hello")
   public String hello(){
       asyncService.hello();
       return "success";
  }

}
```

5、访问http://localhost:8080/hello进行测试，3秒后出现success，这是同步等待的情况。

问题：我们如果想让用户直接得到消息，就在后台使用多线程的方式进行处理即可，但是每次都需要自己手动去编写多线程的实现的话，太麻烦了，我们只需要用一个简单的办法，在我们的方法上加一个简单的注解即可，如下：

6、给hello方法添加@Async注解；

```java
//告诉Spring这是一个异步方法
@Async
public void hello(){
   try {
       Thread.sleep(3000);
  } catch (InterruptedException e) {
       e.printStackTrace();
  }
   System.out.println("业务进行中....");
}
```

SpringBoot就会自己开一个线程池，进行调用！但是要让这个注解生效，我们还需要在主程序上添加一个注解@EnableAsync ，开启异步注解功能；

```java
@EnableAsync //开启异步注解功能
@SpringBootApplication
public class SpringbootTaskApplication {

   public static void main(String[] args) {
       SpringApplication.run(SpringbootTaskApplication.class, args);
  }

}
```

7、重启测试，网页瞬间响应，后台代码依旧执行！



## 定时任务

项目开发中经常需要执行一些定时任务，比如需要在每天凌晨的时候，分析一次前一天的日志信息，Spring为我们提供了异步执行任务调度的方式，提供了两个接口。

- TaskExecutor接口    （任务执行者）
- TaskScheduler接口  （任务调度者）

两个注解：

- @EnableScheduling   //开启定时功能的注解
- @Scheduled               //什么时候执行

**cron表达式：**

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LUziamJeeiaLFt7YwxJtAgSMKLnW0ibMAiaR5yXOER51iaH9WTkrLhr0rSAnAJxJUM9c8eTGaCWXuYOibA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LUziamJeeiaLFt7YwxJtAgSMfyibiaXGFm87zic2Ng3ICjicp4tlAia8MXDafQXZ9UZ7bsreJoTU9VWaBXg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**测试步骤：**

1、创建一个ScheduledService

我们里面存在一个hello方法，他需要定时执行，怎么处理呢？

```java
@Service
public class ScheduledService {
   
    //在一个特点的时间执行这个方法
    //cron表达式
    //秒 分 时 日 月 周几
   @Scheduled(cron = "0 * * * * 0-7")
   public void hello(){
       System.out.println("hello，你被执行了");
  }
}
```

2、这里写完定时任务之后，我们需要在主程序上增加@EnableScheduling 开启定时任务功能

```java
@EnableAsync //开启异步注解功能
@EnableScheduling //开启基于注解的定时任务
@SpringBootApplication
public class SpringbootTaskApplication {

   public static void main(String[] args) {
       SpringApplication.run(SpringbootTaskApplication.class, args);
  }

}
```

3、我们来详细了解下cron表达式；

http://www.bejson.com/othertools/cron/

4、常用的表达式

```
（1）0/2 * * * * ?   表示每2秒 执行任务
（1）0 0/2 * * * ?   表示每2分钟 执行任务
（1）0 0 2 1 * ?   表示在每月的1日的凌晨2点调整任务
（2）0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业
（3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期六上午10:15执行作
（4）0 0 10,14,16 * * ?   每天上午10点，下午2点，4点
（5）0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
（6）0 0 12 ? * WED   表示每个星期三中午12点
（7）0 0 12 * * ?   每天中午12点触发
（8）0 15 10 ? * *   每天上午10:15触发
（9）0 15 10 * * ?     每天上午10:15触发
（10）0 15 10 * * ?   每天上午10:15触发
（11）0 15 10 * * ? 2005   2005年的每天上午10:15触发
（12）0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发
（13）0 0/5 14 * * ?   在每天下午2点到下午2:55期间的每5分钟触发
（14）0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
（15）0 0-5 14 * * ?   在每天下午2点到下午2:05期间的每1分钟触发
（16）0 10,44 14 ? 3 WED   每年三月的星期三的下午2:10和2:44触发
（17）0 15 10 ? * MON-FRI   周一至周五的上午10:15触发
（18）0 15 10 15 * ?   每月15日上午10:15触发
（19）0 15 10 L * ?   每月最后一日的上午10:15触发
（20）0 15 10 ? * 6L   每月的最后一个星期五上午10:15触发
（21）0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发
（22）0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发
```



## 邮件任务

邮件发送，在我们的日常开发中，也非常的多，Springboot也帮我们做了支持

- 邮件发送需要引入spring-boot-start-mail
- SpringBoot 自动配置MailSenderAutoConfiguration
- 定义MailProperties内容，配置在application.yml中
- 自动装配JavaMailSender
- 测试邮件发送

**测试：**

1、引入pom依赖

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

看它引入的依赖，可以看到 jakarta.mail

```xml
<dependency>
   <groupId>com.sun.mail</groupId>
   <artifactId>jakarta.mail</artifactId>
   <version>1.6.4</version>
   <scope>compile</scope>
</dependency>
```

2、查看自动配置类：MailSenderAutoConfiguration

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LUziamJeeiaLFt7YwxJtAgSMquaTFVg62FCj7M1T6e08TIF0rhlffjxhTZ1C6Q43eDiceibia600KwoZw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

这个类中存在bean，JavaMailSenderImpl



![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LUziamJeeiaLFt7YwxJtAgSMJsstibaMQuMsAKmickRKVlc1dsicbp7PR8aaFOdwaVukjBoiaqhyJDrZKQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

然后我们去看下配置文件（源码：MailProperties.java)

```java
@ConfigurationProperties(
   prefix = "spring.mail"
)
public class MailProperties {
   private static final Charset DEFAULT_CHARSET;
   private String host;
   private Integer port;
   private String username;
   private String password;
   private String protocol = "smtp";
   private Charset defaultEncoding;
   private Map<String, String> properties;
   private String jndiName;
}
```

3、配置application.properties文件：

```properties
spring.mail.username=24736743@qq.com
spring.mail.password=isijrvzelxqhjche # 授权码
spring.mail.host=smtp.qq.com
# qq需要配置ssl  开启加密授权验证
spring.mail.properties.mail.smtp.ssl.enable=true
```

获取授权码：在QQ邮箱中的设置->账户->开启pop3和smtp服务



![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7LUziamJeeiaLFt7YwxJtAgSMx85j2ATOfy0GUeO3l8bLvWaOX0FrY39NljleEIyPOyrgV8gEaLCwbw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

4、Spring单元测试

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("初学邮件任务");
        mailMessage.setText("谢谢你的课程");
        mailMessage.setTo("1344602406@qq.com");
        mailMessage.setFrom("1344602406@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    public void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装起来
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("一个复杂的邮件");
        helper.setText("<p style='color:red'>发过来了没</p>",true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Nicolasbruno\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\Nicolasbruno\\Desktop\\1.jpg"));

        helper.setTo("1344602406@qq.com");
        helper.setFrom("1344602406@qq.com");

        mailSender.send(mimeMessage);
    }
    
    
    
    
    
//把它封装成一个发送邮件的方法，以后可以当作自己的工具类
    
/**
 * @param html Text邮件内容是否支持html格式的代码
 * @param subject 邮件的标题
 * @param text   邮件的内容
 * @throws MessagingException
 * @Author ze
 */
public void sendMail(Boolean html,String subject,String text) throws MessagingException {
    //一个复杂的邮件
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    //组装起来
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);

    //正文
    helper.setSubject(subject);
    helper.setText(text,true);

    //附件
    helper.addAttachment("1.jpg",new File("C:\\Users\\Nicolasbruno\\Desktop\\1.jpg"));
    helper.addAttachment("2.jpg",new File("C:\\Users\\Nicolasbruno\\Desktop\\1.jpg"));

    helper.setTo("1344602406@qq.com");
    helper.setFrom("1344602406@qq.com");

    mailSender.send(mimeMessage);
}

}

```

查看邮箱，邮件接收成功！

我们只需要使用Thymeleaf进行前后端结合即可开发自己网站邮件收发功能了！







# 第十七章 Dubbo+Zookeeper集成

## 分布式理论

### **什么是分布式系统？**

在《分布式系统原理与范型》一书中有如下定义：“分布式系统是若干独立计算机的集合，这些计算机对于用户来说就像单个相关系统”；

分布式系统是由一组通过网络进行通信、为了完成共同的任务而协调工作的计算机节点组成的系统。分布式系统的出现是为了用廉价的、普通的机器完成单个计算机无法完成的计算、存储任务。其目的是**利用更多的机器，处理更多的数据**。

分布式系统（distributed system）是建立在网络之上的软件系统。

首先需要明确的是，只有当单个节点的处理能力无法满足日益增长的计算、存储任务的时候，且硬件的提升（加内存、加磁盘、使用更好的CPU）高昂到得不偿失的时候，应用程序也不能进一步优化的时候，我们才需要考虑分布式系统。因为，分布式系统要解决的问题本身就是和单机系统一样的，而由于分布式系统多节点、通过网络通信的拓扑结构，会引入很多单机系统没有的问题，为了解决这些问题又会引入更多的机制、协议，带来更多的问题。。。

### Dubbo文档

随着互联网的发展，网站应用的规模不断扩大，常规的垂直应用架构已无法应对，分布式服务架构以及流动计算架构势在必行，急需**一个治理系统**确保架构有条不紊的演进。

在Dubbo的官网文档有这样一张图

![image-20220828105216349](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105216349.png)

### 单一应用架构

当网站流量很小时，只需一个应用，将所有功能都部署在一起，以减少部署节点和成本。此时，用于简化增删改查工作量的数据访问框架(ORM)是关键。

![image-20220828105300364](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105300364.png)

适用于小型网站，小型管理系统，将所有功能都部署到一个功能里，简单易用。

**缺点：**

1、性能扩展比较难

2、协同开发问题

3、不利于升级维护

### 垂直应用架构

当访问量逐渐增大，单一应用增加机器带来的加速度越来越小，将应用拆成互不相干的几个应用，以提升效率。此时，用于加速前端页面开发的Web框架(MVC)是关键。

![image-20220828105338733](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105338733.png)

通过切分业务来实现各个模块独立部署，降低了维护和部署的难度，团队各司其职更易管理，性能扩展也更方便，更有针对性。

缺点：公用模块无法重复利用，开发性的浪费

### 分布式服务架构

当垂直应用越来越多，应用之间交互不可避免，将核心业务抽取出来，作为独立的服务，逐渐形成稳定的服务中心，使前端应用能更快速的响应多变的市场需求。此时，用于提高业务复用及整合的**分布式服务框架(RPC)**是关键。

![image-20220828105410760](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105410760.png)

### 流动计算架构

当服务越来越多，容量的评估，小服务资源的浪费等问题逐渐显现，此时需增加一个调度中心基于访问压力实时管理集群容量，提高集群利用率。此时，用于**提高机器利用率的资源调度和治理中心**(SOA)[ Service Oriented Architecture]是关键。

![image-20220828105459350](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105459350.png)





## 什么是RPC

RPC【Remote Procedure Call】是指远程过程调用，是一种进程间通信方式，他是一种技术的思想，而不是规范。它允许程序调用另一个地址空间（通常是共享网络的另一台机器上）的过程或函数，而不用程序员显式编码这个远程调用的细节。即程序员无论是调用本地的还是远程的函数，本质上编写的调用代码基本相同。

也就是说两台服务器A，B，一个应用部署在A服务器上，想要调用B服务器上应用提供的函数/方法，由于不在一个内存空间，不能直接调用，需要通过网络来表达调用的语义和传达调用的数据。为什么要用RPC呢？就是无法在一个进程内，甚至一个计算机内通过本地调用的方式完成的需求，比如不同的系统间的通讯，甚至不同的组织间的通讯，由于计算能力需要横向扩展，需要在多台机器组成的集群上部署应用。RPC就是要像调用本地的函数一样去调远程函数；

推荐阅读文章：https://www.jianshu.com/p/2accc2840a1b

**RPC基本原理**

![image-20220828105538094](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105538094.png)

**步骤解析**

![image-20220828105553392](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105553392.png)

RPC两个核心模块：通讯，序列化。







## 测试环境搭建

### Dubbo

Apache Dubbo |ˈdʌbəʊ| 是一款高性能、轻量级的开源Java RPC框架，它提供了三大核心能力：面向接口的远程方法调用，智能容错和负载均衡，以及服务自动注册和发现。

dubbo官网 http://dubbo.apache.org/zh-cn/index.html

1.了解Dubbo的特性

2.查看官方文档

**dubbo基本概念**

![image-20220828105647696](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105647696.png)

**服务提供者**（Provider）：暴露服务的服务提供方，服务提供者在启动时，向注册中心注册自己提供的服务。

**服务消费者**（Consumer）：调用远程服务的服务消费方，服务消费者在启动时，向注册中心订阅自己所需的服务，服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。

**注册中心**（Registry）：注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者

**监控中心**（Monitor）：服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心

**调用关系说明**

l 服务容器负责启动，加载，运行服务提供者。

l 服务提供者在启动时，向注册中心注册自己提供的服务。

l 服务消费者在启动时，向注册中心订阅自己所需的服务。

l 注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。

l 服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。

l 服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心。



### Dubbo环境搭建

点进dubbo官方文档，推荐我们使用Zookeeper 注册中心

什么是zookeeper呢？可以查看官方文档

### Window下安装zookeeper

1、下载zookeeper ：https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.6.3/， 我们下载3.6.3！解压zookeeper

![image-20220828155651497](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828155651497.png)



2、运行/bin/zkServer.cmd ，初次运行会报错，没有zoo.cfg配置文件；

可能遇到问题：闪退 !

解决方案：编辑zkServer.cmd文件末尾添加pause 。这样运行出错就不会退出，会提示错误信息，方便找到原因。

![image-20220828105743472](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828105743472.png)



3、修改zoo.cfg配置文件

将conf文件夹下面的zoo_sample.cfg复制一份改名为zoo.cfg即可。

注意几个重要位置：

dataDir=./  临时数据存储的目录（可写相对路径）

clientPort=2181  zookeeper的端口号

修改完成后再次启动zookeeper



修改后再次运行，出现ZooKeeper audit is disabled，修改zkServer.cmd 添加

```
"-Dzookeeper.audit.enable=true"
```

 ![image-20220828160041231](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828160041231.png)

或zoo.cfg新增一行

```
audit.enable=true
```

 再次打开 OK。（变成enabled就OK了）

![image-20220828155952748](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828155952748.png)



4、使用zkCli.cmd测试

ls /：列出zookeeper根下保存的所有节点(注意：ls和/之间有一个空格)

```
[zk: 127.0.0.1:2181(CONNECTED) 4] ls /
[zookeeper]
```

create –e /zhongyi 123：创建一个zhongyi节点，值为123

get /zhongyi：获取/zhongyi节点的值

set /zhongyi 123 : 设置/zhongyi节点的值（如果create的时候没设置就可以这样设置）

```
[zk: localhost:2181(CONNECTED) 0] ls /
[zookeeper]
[zk: localhost:2181(CONNECTED) 1] create –e /zhongyi 123
Created /zhongyi
[zk: localhost:2181(CONNECTED) 2] ls /
[zhongyi, zookeeper]
[zk: localhost:2181(CONNECTED) 3] get /zhongyi
123
```







### window下安装dubbo-admin

dubbo本身并不是一个服务软件。它其实就是一个jar包，能够帮你的java程序连接到zookeeper，并利用zookeeper消费、提供服务。

但是为了让用户更好的管理监控众多的dubbo服务，官方提供了一个可视化的监控程序dubbo-admin，不过这个监控即使不装也不影响使用。

dubbo-admin是一个监控管理后台，可以查看我们注册了哪些服务，哪些服务被消费了。

我们这里来安装一下：

**1、下载dubbo-admin**

地址 ：https://github.com/apache/dubbo-admin/tree/master

**2、解压进入目录**

修改 dubbo-admin\src\main\resources \application.properties 指定zookeeper地址

```properties
server.port=7001
spring.velocity.cache=false
spring.velocity.charset=UTF-8
spring.velocity.layout-url=/templates/default.vm
spring.messages.fallback-to-system-locale=false
spring.messages.basename=i18n/message
spring.root.password=root
spring.guest.password=guest
# 注册中心的地址
dubbo.registry.address=zookeeper://127.0.0.1:2181
```

**3、在项目目录下**打包dubbo-admin

```
mvn clean package -Dmaven.test.skip=true
```

安裝[dubbo](https://so.csdn.net/so/search?q=dubbo&spm=1001.2101.3001.7020)時 运行mvn clean package一直bulid失败

![img](https://img-blog.csdnimg.cn/20200620111324206.png)

把[maven](https://so.csdn.net/so/search?q=maven&spm=1001.2101.3001.7020) settings.xml里面的镜像换成 

```xml
<mirror> 
  <id>alimaven</id>
  <name>aliyun maven</name>
  <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
  <mirrorOf>central</mirrorOf>        
</mirror>
```

**第一次打包的过程有点慢，需要耐心等待！直到成功！**

![image-20220828112802839](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828112802839.png)

4、执行 dubbo-admin\target 下的dubbo-admin-0.0.1-SNAPSHOT.jar

```
java -jar dubbo-admin-0.0.1-SNAPSHOT.jar
```

【注意：zookeeper的服务一定要打开！】

执行完毕，我们去访问一下 http://localhost:7001/ ， 这时候我们需要输入登录账户和密码，我们都是默认的root-root；

登录成功后，查看界面

![image-20220828112826147](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828112826147.png)

安装完成！





## SpringBoot + Dubbo + zookeeper

### 框架搭建

**1. 启动zookeeper ！**

**2. IDEA创建一个空项目；**

**3.创建一个模块，实现服务提供者：provider-server ， 选择web依赖即可**

**4.项目创建完毕，我们写一个服务，比如卖票的服务；**

编写接口

```java
package com.kuang.provider.service;

public interface TicketService {
   public String getTicket();
}
```

编写实现类

```java
package com.kuang.provider.service;

public class TicketServiceImpl implements TicketService {
   @Override
   public String getTicket() {
       return "《狂神说Java》";
  }
}
```

**5.创建一个模块，实现服务消费者：consumer-server ， 选择web依赖即可**

**6.项目创建完毕，我们写一个服务，比如用户的服务；**

编写service

```java
package com.kuang.consumer.service;

public class UserService {
   //我们需要去拿去注册中心的服务
}
```

**需求：现在我们的用户想使用买票的服务，这要怎么弄呢 ？**



## 服务提供者

**1、将服务提供者注册到注册中心，我们需要整合Dubbo和zookeeper，所以需要导包**

**我们从dubbo官网进入github，看下方的帮助文档，找到dubbo-springboot，找到依赖包**

```xml
<!-- Dubbo Spring Boot Starter -->
<dependency>
   <groupId>org.apache.dubbo</groupId>
   <artifactId>dubbo-spring-boot-starter</artifactId>
   <version>2.7.3</version>
</dependency>   
```

**zookeeper的包我们去maven仓库下载，zkclient；**

```xml
<!-- https://mvnrepository.com/artifact/com.github.sgroschupf/zkclient -->
<dependency>
   <groupId>com.github.sgroschupf</groupId>
   <artifactId>zkclient</artifactId>
   <version>0.1</version>
</dependency>
```

**【新版的坑】zookeeper及其依赖包，解决日志冲突，还需要剔除日志依赖；**

```xml
<!-- 引入zookeeper -->
<dependency>
   <groupId>org.apache.curator</groupId>
   <artifactId>curator-framework</artifactId>
   <version>2.12.0</version>
</dependency>
<dependency>
   <groupId>org.apache.curator</groupId>
   <artifactId>curator-recipes</artifactId>
   <version>2.12.0</version>
</dependency>
<dependency>
   <groupId>org.apache.zookeeper</groupId>
   <artifactId>zookeeper</artifactId>
   <version>3.4.14</version>
   <!--排除这个slf4j-log4j12-->
   <exclusions>
       <exclusion>
           <groupId>org.slf4j</groupId>
           <artifactId>slf4j-log4j12</artifactId>
       </exclusion>
   </exclusions>
</dependency>
```

**2、在springboot配置文件中配置dubbo相关属性！**

```properties
server.port=8081
#当前应用名字
dubbo.application.name=provider-server
#注册中心地址
dubbo.registry.address=zookeeper://127.0.0.1:2181
#扫描指定包下服务
dubbo.scan.base-packages=com.zy.service
```

**3、在service的实现类中配置服务注解，发布服务！注意导包问题**

```java
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service //将服务发布出去
@Component //放在容器中
public class TicketServiceImpl implements TicketService {
   @Override
   public String getTicket() {
       return "《狂神说Java》";
  }
}
```

**逻辑理解 ：应用启动起来，dubbo就会扫描指定的包下带有@component注解的服务，将它发布在指定的注册中心中！**



## 服务消费者

**1、导入依赖，和之前的依赖一样；**

```xml
<!--dubbo-->
<!-- Dubbo Spring Boot Starter -->
<dependency>
   <groupId>org.apache.dubbo</groupId>
   <artifactId>dubbo-spring-boot-starter</artifactId>
   <version>2.7.3</version>
</dependency>
<!--zookeeper-->
<!-- https://mvnrepository.com/artifact/com.github.sgroschupf/zkclient -->
<dependency>
   <groupId>com.github.sgroschupf</groupId>
   <artifactId>zkclient</artifactId>
   <version>0.1</version>
</dependency>
<!-- 引入zookeeper -->
<dependency>
   <groupId>org.apache.curator</groupId>
   <artifactId>curator-framework</artifactId>
   <version>2.12.0</version>
</dependency>
<dependency>
   <groupId>org.apache.curator</groupId>
   <artifactId>curator-recipes</artifactId>
   <version>2.12.0</version>
</dependency>
<dependency>
   <groupId>org.apache.zookeeper</groupId>
   <artifactId>zookeeper</artifactId>
   <version>3.4.14</version>
   <!--排除这个slf4j-log4j12-->
   <exclusions>
       <exclusion>
           <groupId>org.slf4j</groupId>
           <artifactId>slf4j-log4j12</artifactId>
       </exclusion>
   </exclusions>
</dependency>
```

2、**配置参数**

```properties
server.port=8082

#当前应用名字 消费者去哪里拿服务需要暴露自己的名字
dubbo.application.name=consumer-server
#注册中心地址
dubbo.registry.address=zookeeper://127.0.0.1:2181
```

**3. 本来正常步骤是需要将服务提供者的接口打包，然后用pom文件导入，我们这里使用简单的方式，直接将服务的接口拿过来，路径必须保证正确，即和服务提供者相同；**

![image-20220828113134514](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828113134514.png)



**4. 完善消费者的服务类**

```java
package com.zy.service;

import com.zy.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service //注入到容器中
public class UserService {

    //想要拿到provider-server提供的票，要去注册中心拿到服务
   @Reference //远程引用指定的服务，他会按照全类名进行匹配，看谁给注册中心注册了这个全类名
    			//pom坐标，可以定义路径相同的接口名
   TicketService ticketService;

   public void bugTicket(){
       String ticket = ticketService.getTicket();
       System.out.println("在注册中心拿到=>"+ticket);
  }

}
```

**5. 测试类编写；**

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerServerApplicationTests {

   @Autowired
   UserService userService;

   @Test
   public void contextLoads() {

       userService.bugTicket();

  }

}
```

## 启动测试

**1. 开启zookeeper**

**2. 打开dubbo-admin实现监控【可以不用做】**

**3. 开启服务者**

**4. 消费者消费测试，结果：**

![image-20220828113213611](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828113213611.png)



**监控中心 ：**

![image-20220828113233190](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220828113233190.png)

**ok , 这就是SpingBoot + dubbo + zookeeper实现分布式开发的应用，其实就是一个服务拆分的思想；**



## 总结步骤：

前提：zookeeper服务已开启！

1. 提供者提供服务
   1. 导入依赖
   2. 配置注册中心的地址，以及服务发现名，和要扫描的包
   3. 在想要被注册的服务上面增加一个注解 @Service （这个是dubbo的service的，不是spring 的）

2. 消费者如何消费

   1. 导入依赖
   2. 配置注册中心的地址，配置自己的服务名
   3. 从远程注入服务  @Reference

   





# 知识补充：Restful风格

### RestFul 风格

**概念**

Restful就是一个资源定位及资源操作的风格。不是标准也不是协议，只是一种风格。基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存等机制。

**功能**

资源：互联网所有的事物都可以被抽象为资源

资源操作：使用POST、DELETE、PUT、GET，使用不同方法对资源进行操作。

分别对应 添加、 删除、修改、查询。

**传统方式操作资源**  ：通过不同的参数来实现不同的效果！方法单一，post 和 get

​	http://127.0.0.1/item/queryItem.action?id=1 查询,GET

​	http://127.0.0.1/item/saveItem.action 新增,POST

​	http://127.0.0.1/item/updateItem.action 更新,POST

​	http://127.0.0.1/item/deleteItem.action?id=1 删除,GET或POST

**使用RESTful操作资源** ：可以通过不同的请求方式来实现不同的效果！如下：请求地址一样，但是功能可以不同！

​	http://127.0.0.1/item/1 查询,GET

​	http://127.0.0.1/item 新增,POST

​	http://127.0.0.1/item 更新,PUT

​	http://127.0.0.1/item/1 删除,DELETE

**学习测试**

1. 在新建一个类 RestFulController

   ```
   @Controller
   public class RestFulController {
   }
   ```

2. 在Spring MVC中可以使用  @PathVariable 注解，让方法参数的值对应绑定到一个URI模板变量上。

   ```
   @Controller
   public class RestFulController {
   
      //映射访问路径
      @RequestMapping("/commit/{p1}/{p2}")
      public String index(@PathVariable int p1, @PathVariable int p2, Model model){
          
          int result = p1+p2;
          //Spring MVC会自动实例化一个Model对象用于向视图中传值
          model.addAttribute("msg", "结果："+result);
          //返回视图位置
          return "test";
          
     }
      
   }
   ```

3. 我们来测试请求查看下

   ![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JOmNdhqNbrRK9XaseXIDsu5BqyAspPK6GlhgxeV1nS0RWPnUfVBuaiadicaicQepibic2EVkyDflUh3qQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

4. 思考：使用路径变量的好处？

5. - 使路径变得更加简洁；

   - 获得参数更加方便，框架会自动进行类型转换。

   - 通过路径变量的类型可以约束访问参数，如果类型不一样，则访问不到对应的请求方法，如这里访问是的路径是/commit/1/a，则路径与方法不匹配，而不会是参数转换失败。

     

     ![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JOmNdhqNbrRK9XaseXIDsumkKQDDBx9D7E67IK9dmVtHnjn0WjPSOZxKnwz9AXrTPRLy6Xu42yrg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

6. 我们来修改下对应的参数类型，再次测试

   ```
   //映射访问路径
   @RequestMapping("/commit/{p1}/{p2}")
   public String index(@PathVariable int p1, @PathVariable String p2, Model model){
   
      String result = p1+p2;
      //Spring MVC会自动实例化一个Model对象用于向视图中传值
      model.addAttribute("msg", "结果："+result);
      //返回视图位置
      return "test";
   
   }
   ```

   ![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JOmNdhqNbrRK9XaseXIDsuJXyVjg5EaXZiaO78ibGzhUXnEz5UlbRTRDKzGNh0t5WspXrpvSLe9y9w/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**使用method属性指定请求类型**

用于约束请求的类型，可以收窄请求范围。指定请求谓词的类型如GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE等

我们来测试一下：

- 增加一个方法

  ```
  //映射访问路径,必须是POST请求
  @RequestMapping(value = "/hello",method = {RequestMethod.POST})
  public String index2(Model model){
     model.addAttribute("msg", "hello!");
     return "test";
  }
  ```

- 我们使用浏览器地址栏进行访问默认是Get请求，会报错405：

  ![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JOmNdhqNbrRK9XaseXIDsucZBtV1jA2Clpa2utiajS6zkWWoYIo8VhqlUGIOSiacAjCsiaJEOeVvNUQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

- 如果将POST修改为GET则正常了；

  ```
  //映射访问路径,必须是Get请求
  @RequestMapping(value = "/hello",method = {RequestMethod.GET})
  public String index2(Model model){
     model.addAttribute("msg", "hello!");
     return "test";
  }
  ```

  ![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JOmNdhqNbrRK9XaseXIDsua1f90EJnCRJxuBoeSWiaTmdVfjIDgUo5v6ENY5N307GfoXUp4PxYu0g/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**小结：**

Spring MVC 的 @RequestMapping 注解能够处理 HTTP 请求的方法, 比如 GET, PUT, POST, DELETE 以及 PATCH。

**所有的地址栏请求默认都会是 HTTP GET 类型的。**

方法级别的注解变体有如下几个：组合注解

```
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PatchMapping
```

@GetMapping 是一个组合注解，平时使用的会比较多！

它所扮演的是 @RequestMapping(method =RequestMethod.GET) 的一个快捷方式。