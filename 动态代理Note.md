

# 第一章 代理模式

### 1.什么是代理模式

```java
目标对象不可访问，通过代理对象增强功能访问。

  生活中:
  房东                ===>目标对象
  房屋中介            ===>代理对象
  你,我               ===>客户端对象

  服装生产厂          ===>目标对象
  门店（旗舰店）        ===>代理对象
  你,我               ===>客户端
  
  开发中:
  运营商（电信，移动）	==>目标对象
  第三方公司			   ==>代理对象
  开发的应用程序需要发送短信的功能   ==>客户端
  开发的应用程序需要支付的功能	  ==>客户端

```



### 2.代理模式的作用

```
1.控制目标对象的访问
2.增强功能
```



### 3.代理模式的分类

```
1.静态代理

2.动态代理
	JDK动态代理
	CGLib动态代理（子类代理）
```



### 4.代理实现的方式

```
1.静态代理实现
2.动态代理的实现
	JDK动态代理实现
	CGLib动态代理实现
```





# 第二章 静态代理

### 1.什么是静态代理

```
它是代理模式的一种
它具备以下特点：
	1.目标对象和代理对象实现同一个业务接口（*）
	2.目标对象必须实现接口
	3.代理对象在程序运行前就已经存在
	4.能够灵活进行目标对象的切换，却无法进行功能的灵活处理（使用动态代理解决此问题）
```



### 2.静态代理实现

```
业务功能：请明星进行节目表演
明星刘德华：目标对象（无法直接访问）
刘德华助理：代理对象（我们可以访问，他还可以跟明星对接）
我们	   ：客户端对象
```

**静态代理流程梳理图**

![image-20220801170834219](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220801170834219.png)

**代码实现：**

```java
  业务接口Service
  public interface Service {
    //规定的唱歌的业务功能
    void sing();
  }
```

```java
  目标对象:
	/**
	 *   目标对象:刘德华,实现业务接口中的功能,进行唱歌表演
	 */
	public class SuperStarLiu implements Service {
	    @Override
	    public void sing() {
	        System.out.println("我是刘德华,我正在表演唱歌............");
	    }
	}

  目标对象：
      	/**
         * 目标对象
         */
        public class SuperStarZhou implements Service {

            @Override
            public void sing() {
                System.out.println("我是周润发，我正在唱歌");
            }
        }
```

```java
	代理对象：
        /**
         * 助理：代理对象，完成除了唱歌主业务之外的其他业务：时间，场地预定，结算费用
         */
        public class Agent implements Service {
            //面向接口编程之 类中的成员变量设计为接口
            public Service target;  //目标对象

            //传入目标对象， 面向接口编程之  方法的参数设计为接口
            public Agent(Service target){
                this.target=target;
            }

            @Override
            public void sing() {
                System.out.println("预定时间");
                System.out.println("预定场地");
                //切记切记：业务功能必须由目标对象亲自实现
        //        SuperStarLiu liu=new SuperStarLiu();
        //        liu.sing();

        //        SuperStarZhou zhou=new SuperStarZhou();
        //        zhou.sing();
                //面向接口编程之 调用时接口指向实现类
                target.sing();
                System.out.println("结算费用");
            }
        }
```

```java
	客户端对象：
        public class MyTest {
            @Test
            public void testAgent(){
                //测试功能
        //        Agent agent=new Agent();
        //        agent.sing();   //不是最优写法

                //有接口和实现类 必须使用接口指向实现类(规范)
        //        Service agent=new Agent();
        //        agent.sing();

            }
            @Test
            public void testAgent1(){
        //        Service agent=new Agent(new SuperStarLiu());
                Service agent=new Agent(new SuperStarZhou());
                agent.sing();
            }
        }
```



###  3.面向接口编程（essential)

```
类中的成员变量设计为接口
方法的形参设计为接口
方法的返回值设计为接口
调用时接口指向实现类
```





# 第三章 动态代理

​	代理对象在程序运行的过程中动态地在内存中构建，可以灵活的进行业务功能的切换。



### 1.JDK动态代理（*）

```
1.目标对象必须实现业务接口（*）
2.代理对象不需要实现业务接口（*）
3.动态代理的对象在程序运行前不存在，在程序运行时动态地的内存中构建。（*）
4.动态代理灵活的进行业务功能的切换
5.本类中的方法（非接口中的方法）不能被代理
```



### 2.JDK动态代理用到的类和接口（*）

​	它是使用现成的工具类完成JDK动态实现。

```j
1.Proxy类
    它是java.lang.reflect.Proxy包下的类，它有一个方法Proxy.newProxyInstance(...)专门用来生成动态代理对象
    
	public static Object newProxyInstance(ClassLoader loader,  //类加载器
                                          Class<?>[] interfaces, //目标对象实现的所有接口
                                          InvocationHandler h  //它就类似于Agent的功能，代理的功能和目标对象的业务																   功能调用在这 
                                          )
        throws IllegalArgumentException
	{...}

2.Method类
  反射用的类，用来进行目标对象的方法的反射调用。
  method对象接住我们正在调用的方法sing(),show()
  method==sing(),show()
  method.invoke(); ==>手工调用目标方法 sing(); show();
   
3.InvocationHandler接口
  它是实现代理和业务功能的。我们在调用时使用匿名内部实现。
```



代码实现：

```java
  public class ProxyFactory {
    //类中的成员变量设计为接口,目标对象
    Service target;

    //传入目标对象
    public ProxyFactory(Service target){
        this.target = target;
    }

    //返回动态代理对象
    public Object getAgent(){
        return Proxy.newProxyInstance(
                //ClassLoader loader, 类加载器,完成目标对象的加载
                target.getClass().getClassLoader(),
                //Class<?>[] interfaces,目标对象实现的所有接口
                target.getClass().getInterfaces(),
                //InvocationHandler h,实现代理功能的接口 ,我们传入的是匿名内部实现
                new InvocationHandler() {
                    @Override
                    public Object invoke(
                            //创建代理对象
                            Object proxy,
                            //method就是目标方法sing(),show()
                            Method method,
                            //目标方法的参数
                            Object[] args) throws Throwable {

                        //代理功能
                        System.out.println("预订时间........");
                        //代理功能
                        System.out.println("预订场地........");
                        //主业务功能实现	
                        //target.sing();还是写死了方法的调用, 不成
                        //sing(),show(),one()
                        Object obj = method.invoke(target,args);
                        //代理功能
                        System.out.println("结算费用........");
                        return obj;  //切记:这个是目标方法的返回值
                    }
                }
        );
    }
}
```

**动态代理的重点（标红）**

![image-20220801214315226](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220801214315226.png)



### 3.CGLib动态代理

```
CGLib动态代理又称为子类代理。通过动态的在内存中构建子类对象，重写父类的方法进行代理功能的增强。
如果目标对象没有实现接口，则只能通过CGLib子类代理来进行功能增强。 
子类代理是对象字节码框架ASM来实现的。

注意：
	被代理的类不能是final，否则报错
	目标对象的方法(被代理的类的方法)如果为final/static，那么就不会被拦截，即不会执行目标对象额外的业务方法
	

  public Object getProxyInstance(){		
		//1.使用工具类
		Enhancer en=new Enhancer();
		//2.设置父类
		en.setSuperclass(target.getClass());
		//3.设置回调函数
		en.setCallback(this);
		//4.创建子类（代理）对象
		return en.create();  ===>返回的是子类代理对象
```









**动态代理总结（标红的都是重点）**

 [动态代理.pdf](动态代理笔记\动态代理.pdf) 











