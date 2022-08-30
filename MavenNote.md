# 第一章 Maven简介

### 1.1软件是一个工程

**完成一个java项目，需要做哪些工作**

​	1.分析项目要做什么，知道项目有哪些组成部分。
​	2.设计项目，通过哪些步骤，使用哪些技术。需要多少人， 多长的时间。
​	3.组建团队，招人， 购置设备，服务器， 软件， 笔记本。
​	4.开发人员写代码。 开发人员需要测试自己写代码。 重复多次的工作。
​	5.测试人员，测试项目功能是否符合要求。
  	测试开发人员提交代码-如果测试有问题--需要开发人员修改--在提交代码给测试
  	--测试人员在测试代码-如果还有问题-在交给开发人员-开发人员在提交-在测试
 	 直到-测试代码通过。



### 1.2 传统开发项目的问题存在的问题

（没有使用maven管理的项目）

  1）很多模块，模块之间有关系， 手工管理关系，比较繁琐。
  2）需要很多第三方功能， 需要很多jar文件，需要手工从网络中获取各个jar
  3）需要管理jar的版本， 你需要的是mysql.5.1.5.jar 拿你不能给给一个mysql.4.0.jar
  4）管理jar文件之间的依赖， 你的项目要使用a.jar 需要使用b.jar里面的类。
     必须首先获取到b.jar才可以， 然后才能使用a.jar. 

     a.jar需要b.jar这个关系叫做依赖， 或者你的项目中要使用mysql的驱动， 也可以叫做项目依赖mysql驱动。
     a.class使用b.class， a依赖b类

###  1.3 Maven概述

**需要改进项目的开发和管理，需要maven**

​    1）maven可以管理jar文件
​    2）自动下载jar和他的文档，源代码
​    3）管理jar直接的依赖， a.jar需要b.jar ， maven会自动下载b.jar
​    4）管理你需要的jar版本
​    5）帮你编译程序，把java编译为class
​    6）帮你测试你的代码是否正确。
​    7）帮你打包文件，形成jar文件，或者war文件
​    8）帮你部署项目

###  1.4 构建： 项目的构建。（maven的生命周期）

   构建是面向过程的，就是一些步骤，完成项目代码的编译，测试，运行，打包，部署等等。
   maven支持的构建包括有：
    1.清理， 把之前项目编译的东西删除掉，为新的编译代码做准备。
    2.编译， 把程序源代码编译为执行代码， java-class文件
             批量的，maven可以同时把成千上百的文件编译为class。
	     javac 不一样，javac一次编译一个文件。
    3.测试， maven可以执行测试程序代码，验证你的功能是否正确。
             批量的，maven同时执行多个测试代码，同时测试很多功能。
    4.报告， 生成测试结果的文件， 测试通过没有。
    5.打包， 把你的项目中所有的class文件，配置文件等所有资源放到一个压缩文件中。
              这个压缩文件就是项目的结果文件， 通常java程序，压缩文件是jar扩展名的。
	      对于web应用，压缩文件扩展名是.war
    6.安装， 把5中生成的文件jar，war安装到本机仓库
    7.部署， 把程序安装好可以执行。



### 1.5 maven的核心概念

>用好maven，了解这些概念

①POM：一个文件，名称是pom.xml,   pom翻译过来叫做项目对象模型 。

​				maven把一个项目当做一个模型使用。控制maven构建项目的过程，管理依赖jar依赖。

②约定的目录结构： 	maven项目的目录和文件的位置都是规定的。

③坐标：	是一个唯一的字符串，用来表示资源的

④依赖管理：	管理你的项目可以使用jar文件

⑤仓库管理（了解）：	你的资源存放的位置

⑥生命周期（了解）：	maven工具构建项目的过程，就是生命周期

⑦插件和目标（了解）：执行maven构建的时候用的工具是插件

⑧继承

⑨聚合

​	

maven的使用，是先难后易的。难在使用maven的命令，完成maven的使用；易在idea中直接使用maven，代替命令。



### 1.6 Maven工具的安装和环境配置。

1）需要从maven的官网下载maven的安装包 apache-maven-3.3.9-bin.zip（这个版本和jdk1.8适配）

2）解压安装包，解压到一个目录，非中文目录即可。

​		子目录 bin ：执行程序，主要是mvn.cmd

​					conf：maven工具本身的配置文件  setting.xml

3）配置环境变量

​		在系统的环境变量中，指定一个M2_HOME的名称，指定它的值是maven工具安装目录，bin之前的目录

​		MAVEN_HOME=D:\Maven\apache-maven-3.3.9

​		再把MAVEN_HOME加到path中（%MAVEN_HOME%\bin）

4）验证maven是否配置成功：在cmd窗口中，执行mvn -v

​	出现以下内容则说明配置成功：

![image-20220731185130913](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220731185130913.png)

注意：

- 如果出现说mvn不是内部命令，则就是因为环境变量配置失败，如果检查了一遍全都没有问题还是提示mvn不是内部命令，则可能 是因为那些路径是自己手动输入的，删掉之后重新通过复制再配置一遍，即可。
- 需要配置JAVA_HOME，指定jdk路径





# 第二章 maven的核心概念（*）

**注意：*号标注的是重点。**

### 2.1 maven约定的目录结构  （*）

 （约定是大家都遵循的一个原则）

​	每一个maven项目在磁盘中都是一个文件夹（项目） （以项目hello为例：）

```
hello
----|src
-------|main    	  #放置主程序java代码和配置文件
---------|java  	  #放置程序包和包中的java文件
---------|resources   #放置java程序中要使用的配置文件

-------|test		  #放置测试程序代码和文件的（可以没有）
---------|java		  #放置测试程序包和包中的java文件
---------|resources   #测试java程序中要使用的配置文件
----|pom.xml          #maven的核心文件（maven项目必须有）
	
```



### 2.2  mvn  compile 编译src/main目录下的所有java文件

​	1）为什么要下载？

​			maven工具执行的操作需要很多的插件（java类--jar文件）来完成

​	2）下载什么东西了？

​			jar文件--叫做插件 --插件是完成某些功能

​	3）下载的东西存放到哪里了？

​			默认仓库（本机仓库）：

```java
C:\Users\Nicolasbruno\.m2\repository
```



	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-parameter-documenter-2.0.9.pom

   https://repo.maven.apache.org ：中央仓库的地址

只要看见这个就是下载成功了：

![image-20220731205704907](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220731205704907.png)





执行mvn compile  ，结果是在项目的根目录下生成target目录（结果目录）

maven编译的java程序，最后的class文件都放在target目录中



>设置本机存放资源的目录位置（配置本地仓库位置）：

```
	1.修改maven的配置文件：maven安装目录/conf/settings.xml
		在这之前记得先备份 
	2.修改 <localRepository>来指定你的目录（不要使用中文目录）
	D:\Maven\repository   
```





### 2.3 仓库

```
1.仓库是什么：仓库是存放东西的，存放maven使用的jar和我们项目使用的jar
	> maven使用的插件（各种jar）
	> 我项目使用的jar（第三方的工具）
	
2.仓库的分类
	>本地仓库，就是你个人计算机上的文件夹，存放各种jar
	>远程仓库，在互联网上的，使用网络才能使用的仓库
		2.1 中央仓库：最权威的，所有开发人员都能共享使用的一个集中的仓库
				   https://repo.maven.apache.org ：中央仓库的地址
		2.2 中央仓库的镜像：就是中央仓库的备份，在各大洲，重要的城市都是镜像
		2.3 私服：在公司的内部，在局域网中使用的，不是对外使用的。
3.仓库的使用：maven仓库的使用不需要人为参与。
	开发人员需要使用mysql驱动：
		maven首先是查本地仓库，如果本地仓库没有，那就去查私服，如果私服中有就把这个驱动给本地仓库，本地	  仓库存一份，然后再把		这个内容给到程序中；如果私服中也没有，那就访问中央仓库镜像。如果镜像中有资源，那么这个资源会下载到私服，再私服中保留一			份，然后私服再把资源下载到本地仓库，本地仓库再把资源给到程序中；如果镜像中也没有，那就访问最权威的中央仓库。
		（本地仓库-->私服-->镜像-->中央仓库）
4.Maven对仓库的使用
	
```



### 2.4 pom文件（*）

```xml
pom:项目对象模型，是一个pom.xml文件
1.坐标：唯一值，在互联网中唯一标识一个项目的
  <groupId>公司域名的倒写</groupId>  
  <artifactId>自定义的项目名称</artifactId>
  <version>自定版本号</version>
	https://mvnrepository.com/ :搜索使用的中央仓库 -->使用groupId或者artifactId作为搜索条件
2.packaging： 打包后压缩文件的扩展名，默认是jar ，web应用是war
	packaging可以不写，默认是jar
3.依赖
	dependencies和dependency
	你的项目中要使用的各种资源说明， 比如我的项目要使用mysql驱动
	比如pom.xml文件中：
	<dependencies>
		<!--依赖  相当于java代码中的import -->
        <dependency>
            <groupId>mysql</groupId>
            <atrifactId>mysql-connector-java</atrifactId>
            <version>5.1.9</version>
        </dependency>
	</dependencies>

4.properties：设置属性
5.build ： maven在进行项目的构建时， 配置信息，例如指定编译java代码使用的jdk的版本等
```



### 2.5 坐标(gav)（*）

```
Maven 把任何一个插件都作为仓库中的一个项目进行管理，用一组(三个)向量组成的坐标来表示。坐标在仓库
中可以唯一定位一个 Maven 项目。
groupId：组织名，通常是公司或组织域名倒序+项目名
artifactId：模块名，通常是工程名
version：版本号
需要特别指出的是，项目在仓库中的位置是由坐标来决定的：groupId、artifactId 和 version 决定项目在仓库中
的路径，artifactId 和 version 决定 jar 包的名称。
```



### 2.6 依赖（dependency） （*）

```xml
一个 Maven 项目正常运行需要其它项目的支持，Maven 会根据坐标自动到本地仓库中进行查找。
对于程序员自己的 Maven 项目需要进行安装，才能保存到仓库中。
不用 maven 的时候所有的 jar 都不是你的，需要去各个地方下载拷贝，用了 maven 所有的 jar 包都是你的，想
要谁，叫谁的名字就行。maven 帮你下载。
pom.xml 加入依赖的方式：
 log4j 日志依赖
<dependency>
 <groupId>log4j</groupId>
 <artifactId>log4j</artifactId>
 <version>1.2.17</version>
</dependency>
 junit 单元测试依赖
<dependency>
 <groupId>junit</groupId>
 <artifactId>junit</artifactId>
 <version>4.11</version>
</dependency>
```



### 2.7 Maven的生命周期，maven的命令，maven的插件

```
maven的生命周期：就是maven构建项目的过程--清理、编译、测试、报告、打包、安装、部署
maven的命令：maven独立使用，通过命令，完成maven的生命周期的执行。
			也就是说maven可以使用命令，完成项目的清理、编译、测试等。
maven的插件：maven命令执行时真正完成功能的是插件，插件就是一些jar文件，一些类。

maven命令详细：
mvn clean 清理(会删除原来编译和测试的目录，即 target 目录，但是已经 install 到仓库里的包不会删除)
mvn compile 编译主程序(会在当前目录下生成一个 target,里边存放编译主程序之后生成的字节码文件)
mvn test-compile 
编译测试程序(会在当前目录下生成一个 target,里边存放编译测试程序之后生成的字节码文件)
mvn test 测试(会生成一个目录surefire-reports，保存测试结果)
	（会先执行以上三个方法再执行test）
mvn package
打包主程序(会编译、编译测试、测试、并且按照 pom.xml 配置把主程序打包生成 jar 包或者 war 包)
	打包生成一个.jar文件（里面是src/main里面所有的东西）
mvn install 安装主程序(会把本工程打包，并且按照本工程的坐标保存到本地仓库中)
mvn deploy 部署主程序(会把本工程打包，按照本工程的坐标保存到本地库中，并且还会保存到私服仓库中。
还会自动把项目部署到 web 容器中)。
注意：执行以上命令必须在命令行进入 pom.xml 所在目录！
```



### 2.8 练习maven命令（单元测试）

```xml
1.单元测试（测试方法）：用的是junit，junit是一个专门测试的框架(工具)。
		junit测试的内容：测试的是类中的方法，每一个方法都是独立测试的。
						方法是测试的基本单位（单元）。
	maven借助单元测试，批量的测试你类中的大量方法是否符合预期的。
2.使用步骤
	2.1 加入依赖，在pom.xml文件中加入单元测试依赖
		 <!-- 单元测试 -->
		 <dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>
	2.2 在maven项目中的src/test/java目录下，创建测试程序。
		推荐的创建类和方法的提示：
		1.测试类的名称  是Test + 你要测试的类名
		2.测试的方法名称 是：Test + 方法名称
		例如你要测试HelloMaven
		那就要创建测试类 TestHelloMaven
		@Test
		Public void testAdd(){
			测试HelloMaven的add方法是否正确
		}

		其中testAdd叫做测试方法，它的定义规则
		1.方法必须是public的
		2.方法必须没有返回值（void）
		3.方法名称是自定义的，推荐是Test + 方法名称
		4.在方法的上面加入@Test

3.mvn compile 
	   编译main/java/目录下的java为class文件，同时把class拷贝到target/classes目录下面
	   把main/resources目录下的所有文件都拷贝到target/classes目录下
```





# 第三章 Maven在IDEA中的应用

### 3.1 IDEA集成Maven

```
在idea中设置maven，让maven和idea结合使用
idea中内置了maven，一般不使用内置的，因为用内置修改maven的设置不方便。
使用自己安装的maven，需要覆盖idea中的默认的设置。让idea指定maven安装位置等信息。

1.配置的入口 ：
	1.1 file --settings :配置当前工程的设置
	  具体配置路径：
		file(文件)-->settings(设置)-->Build,Excution,Deployment(构建，执行，部署)-->Build Tools(构建工具)-->Maven
	 		 Maven Home directory(Maven主路径):maven的安装目录
	  		 User Settings File(用户设置文件): 就是maven安装目录conf/setting.xml配置文件
	  		 Local Repository(本地仓库):本机仓库的位置
	 	-->Maven--Runner(运行程序)
	 		 VM options(VM选项): -DarchetypeCatalog=internal  
	 		 			目的是为了让maven的项目创建得快一点，maven项目创建时，会联网下载模版文件，
						  比较大， 使用-DarchetypeCatalog=internal，不用下载， 创建maven项目速度快。
	 		 JRE: 你项目的jdk	  
	  
	1.2 file --other settings:配置以后新建工程的设置
	   具体配置路径：
	   	  file(文件)-->other settings(新项目设置)-->Settings for New Project(新项目的设置)--				  			  >Build,Excution,Deployment(构建，执行，部署)-->Build Tools(构建工具)-->Maven--Runner(运行程序)
	   	  具体同上
	   	  
2.使用模板创建项目(Create from archetype)
	2.1 maven-archetype-quickstart : 普通的java项目
	2.2 maven-archetype-webapp : web工程
	   
```

### 3.2 IDEA中导入Maven工程（module）

![image-20220801125109985](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220801125109985.png)

![image-20220801125130444](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220801125130444.png)

![image-20220801125215529](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220801125215529.png)











# 第四章 依赖管理

```
1.依赖范围，使用scope来标识的。
	scope的值有：compile 、test 、provided  （默认是compile）
	scope：表示依赖使用的范围，也就是在maven构建项目的哪些阶段起作用
		maven构建项目：清理，编译，测试，打包，安装，部署（这些都是阶段）
	junit的依赖范围是test（就是指在进行测试阶段中起作用，在其他阶段都不需要）
	<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    
    <dependency>
      <groupId>a</groupId>
      <artifactId>b</artifactId>  b.jar 
      <version>4.11</version>
      <scope>compile</scope>
    </dependency>
    如果这里依赖范围是compile，那么就是说在进行编译及其以后的阶段，都必须要有这个b.jar，不然代码通过不了
    
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>  提供者
    </dependency>
    当项目在编译、测试等过程的时候需要提供这个servlet jar包，但是等到打包安装的时候就不需要提供这个jar包了
    
    
    
    你在写项目的过程中的用到的所有依赖（jar） ，必须在本地仓库中有。
	没有必须通过maven下载， 包括provided的都必须下载。

	你在servlet需要继承HttpServlet( provided) , 你使用的HttpServlet是maven仓库中的。

	当你的写好的程序， 放到 tomat服务器中运行时， 此时你的程序中不包含servlet的jar
	因为tomcat提供了 servlet的.jar
    
```

![image-20220801130530345](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220801130530345.png)





# 第五章 Maven常用设置

### 1.maven常用操作

```
1.maven的属性设置
	<properties>设置maven的常用属性
2.maven的全局变量
	自定义属性
		规则：2.1 在<properties>通过自定义标签声明变量（标签名就是变量名）
			 2.2 在pom.xml文件中的其他位置，使用${标签名}使用变量的值
  自定义全部变量一般是定义 依赖的版本号，当你的项目中要使用多个相同的版本号，先使用全局变量定义，再使用${变量名}
```



### 2.maven的全局变量

>定义全局变量

```xml
<properties>
    <spring.version>4.3.10.RELEASE</spring.version>
</properties>
```

>引用全局变量

```xml
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
	<version>${spring.version}</version>
</dependency>
```

>Maven系统采用的变量

```xml
<properties>
 	<maven.compiler.source>1.8</maven.compiler.source> 源码编译 jdk 版本
 	<maven.compiler.target>1.8</maven.compiler.target> 运行代码的 jdk 版本
 	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding> 项目构建使用的编码，避免中文乱码
 	<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding> 生成报告的编码
</properties>
```





### 3. 指定资源的位置（resource资源插件）

```xml
src/main/java 和 src/test/java 这两个目录中的所有*.java 文件会分别在 comile 和 test-comiple 阶段被编译，编
译结果分别放到了 target/classes 和 targe/test-classes 目录中，但是这两个目录中的其他文件都会被忽略掉。
如果需要把 src 目录下的文件包放到 target/classes 目录，作为输出的 jar 一部分。需要指定资源文件位置。以下内容放到
<build>标签中。

<build>
	<resources>
 		<resource>
			 <directory>src/main/java</directory><!--所在的目录-->
 			 <includes><!--包括目录下的.properties,.xml 文件都会扫描到-->
			 <include>**/*.properties</include>
			 <include>**/*.xml</include>
			 </includes>
			 <!--filtering 选项 false 不启用过滤器， *.property 已经起到过滤的作用了 -->
			 <filtering>false</filtering>
 		</resource>
 	</resources>
</build>

    在pom.xml中加上这一段之后，在执行编译的时候，就不仅会把src/main/java 和 src/test/java 这两个目录中的所有*.java 文件编	译，编译结果分别放到了 target/classes 和 targe/test-classes 目录中，而且.properties和.xml文件也会被编译放到			target/classes目录下。

```









