

# 此笔记可联合jQuery-project的详细代码复习，代码里也有具体笔记

# 1.jQuery

```
jQuery是一个JS库
库：相当于java的工具类，库是存放东西的， jQuery是存放js代码的地方， 放的用js代码写的function（函数）

为什么[why]使用 jQuery
非常重要的理由就是：它能够兼容市面上主流的浏览器， IE 和 FireFox，Google 浏览器
处理 AJAX，创建异步对象是不同的，而 jQuery 能够使用一种方式在不同的浏览器创建 AJAX
异步对象。
其他优点：
（1）写少代码,做多事情【write less do more】 （2）免费，开源且轻量级的 js 库，容量很小
（3）兼容市面上主流浏览器，例如 IE，Firefox，Chrome
（4）能够处理 HTML/JSP/XML、CSS、DOM、事件、实现动画效果，也能提供异步 AJAX
功能
（5）文档手册很全，很详细
（6）成熟的插件可供选择，多种 js 组件，例如日历组件（点击按钮显示下来日期）
（7）出错后，有一定的提示信息
（8）不用再在 html 里面通过<script>标签插入一大堆 js 来调用命令了
        例如：使用 JavaScript 定位 DOM 对象常用的三种方式：
        （1）通过 ID 属性：document.getElementById()
        （2）通过 class 属性：getElementsByClassName()
        （3）通过标签名：document.getElementsByTagName()
        上面代码可以看出 JavaScript 方法名太长了，大小写的组合太多了，编写代码效率，容易出
        错。jQuery 分别使用$(“#id”) , $(“.class 名”) , $(“标签名) 封装了上面的 js 方法。
        
        
        
官网地址： https://jquery.com/

```

![image-20220811224140754](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220811224140754.png)



## 1.1 第一个JQuery例子

具体步骤：

```
第一个例子完成：浏览器完全装载 html 页面 DOM 后,显示一个提示信息框

实现步骤：

\1. 使用 HBuilder 或 HbuilderX, idea 都可以，以 HbuilderX 为工具，创建一个项目（名称：

jquery-course），给项目选择一个文件存放目录。

\2. 在项目中再创建一个目录

右键项目名称—新建—目录，常用名称为 js

\3.拷贝下载的 jQuery.js 文件到目录

\4. 使用 jQuery，首先要将 jQuery 库引入。使用如下语句：

<script type="text/javascript" src="js/jquery-3.4.1.js"></script>

\5. $(document)，将 DOM 对象 document 转换为 jQuery 对象。$(document).ready()函数是当

DOM 对象加载完毕后，马上执行的函数。

$(document).ready()与$()、jQuery()、window.jQuery()是等价的，所以$(document).ready()可以

写成 $(function() { alert(“Hello jQuery”) } );
```













# 2.dom对象和jquery对象

```
dom对象，使用javascript的语法创建的对象叫做dom对象， 也就是js对象。
    var obj=  document.getElementById("txt1");  obj是dom对象，也叫做js对象

jquery对象： 使用jquery语法表示对象叫做jquery对象， 注意：jquery表示的对象都是数组。
     例如  var jobj =  $("#txt1") , jobj就是使用jquery语法表示的对象。 也就是jquery对象。 
     		它是一个数组。现在数组中就一个值。

dom对象可以和jquery对象相互的转换。
  dom对象可以转为jquery ， 语法： $(dom对象)
  jquery对象也可以转为dom对象， 语法： 从数组中获取第一个对象， 第一个对象就是dom对象， 使用[0]或者get(0).

为什么要进行dom和jquery的转换：目的是要使用对象的方法或者属性。
  当你的dom对象时，可以使用dom对象的属性或者方法， 如果你要想使用jquery提供的函数，必须是jquery对象才可以。
```



#  3.选择器

    选择器： 就是一个字符串， 用来定位dom对象的。定位了dom对象，就可以通过jquery的函数操作dom
    
    常用的选择器（掌握前三个就好）：
    1） id选择器， 	 语法： $("#dom对象的id值")
    		通过dom对象的id定位dom对象的。 通过id找对象，id在当前页面中是唯一值。
    2） class选择器， 语法： $(".class样式名)
        	class表示css中的样式， 使用样式的名称定位dom对象的。
    3） 标签选择器，   语法： $("标签名称")
        	使用标签名称定位dom对象的
    4） 所有选择器	 语法:  $("*")
    		选取页面中所有的DOM对象
    5） 组合选择器	 语法： $("#id,.class,标签名")
    		组合选择器是多个被选对象间使用逗号分隔后形成的选择器，可以组合id,class,标签名等

# 4.表单选择器

```
表单选择器是为了能更加容易的操作表单，表单选择器是根据元素类型来定义的。
表单选择器与是否有表单<form>无关，只要有<input type="text">这样的组件，就可以使用。

表单选择器：使用<input>标签的type属性值，定位dom对象的方式。
语法： $(":type属性值")
例如： $(":text"),选择的是所有的单行文本框
	  $(":password"),选择的是所有的密码框
      $(":button"),选择的是所有的按钮
      $(":checkbox"),选择的是所有的复选框
```



# 5.过滤器

```
过滤器：在定位了dom对象后，根据一些条件筛选dom对象。
  过滤器也是一个字符串，用来筛选dom对象的。
  过滤器不能单独使用， 必须和选择器一起使用。

  1）$("选择器:first") : 第一个dom对象
  2）$("选择器:last"): 数组中的最后一个dom对象
  3）$("选择器:eq(数组的下标)") ：获取指定下标的dom对象
  4）$("选择器:lt(下标)") ： 获取小于下标的所有dom对象
  5）$("选择器:gt(下标)") ： 获取大于下标的所有dom对象
```



# 6.表单属性过滤器

```
表单属性过滤器： 根据表单中dom对象的状态情况，定位dom对象的。
    启用状态    enabled 
	不可用状态  disabled
	选中状态    checked ， 例如radio， checkbox 
	
1.选择可用的文本框 ${":text:enabled"}
2.选择不可以的文本框 ${":text:disabled"}
3.复选框选中的元素 ${":checkbox:checked"}
4.选择指定下拉列表的被选中元素  选择器>option:selected
```



# 7.函数1

```
1. val（常用）
    操作数组中 DOM 对象的 value 属性.
    $(选择器).val() ：无参数调用形式， 读取数组中第一个 DOM 对象的 value 属性值
    $(选择器).val(值)：有参形式调用;对数组中所有 DOM 对象的 value 属性值进行统一赋值
2.text
    操作数组中所有 DOM 对象的【文字显示内容属性】
    $(选择器).text():无参数调用，读取数组中所有 DOM 对象的文字显示内容，将得到内容拼接为一个字符串返回
    $(选择器).text(值):有参数方式，对数组中所有 DOM 对象的文字显示内容进行统一赋值

3.attr 		
	对 val, text 之外的其他属性操作
    $(选择器).attr(“属性名”): 获取 DOM 数组第一个对象的属性值
    $(选择器).attr(“属性名”,“值”): 对数组中所有 DOM 对象的属性设为新值
```



# 8.函数2

```
1.hide
	$(选择器).hide() :将数组中所有 DOM 对象隐藏起来
	
2.show
	$(选择器).show():将数组中所有 DOM 对象在浏览器中显示起来
	
3.remove
	$(选择器).remove() : 将数组中所有 DOM 对象及其子对象一并删除
	
4.empty
	$(选择器).empty()：将数组中所有 DOM 对象的子对象删除
	
5.append（常用）
	为数组中所有 DOM 对象添加子对象
	$(选择器).append("<div>我动态添加的 div</div>")
	
6.html
	设置或返回被选元素的内容（innerHTML）。
	$(选择器).html()：无参数调用方法，获取 DOM 数组第一个匹元素的内容。
	$(选择器).html(值)：有参数调用，用于设置 DOM 数组中所有元素的内容。
```







# 9.函数3：each语法（常用）



    语法1 
    	可以对数组、json、dom数组循环处理。 数组、json中的每个成员都会调用一次处理函数。
         var arr = { 1, 2, 3} //数组
    	 var json = {"name":"lisi","age":20 } 
         var obj = $(":text");
         
     语法1：$.each( 要遍历的对象, function(index,element) { 处理程序 } ) 
     			表示使用jquery的each来循环数组，每个数组成员都会执行后面的“处理函数”一次。
                $: 相当于是java的一个类名
                each:就是类中的静态方法。
                静态方法调用，可以使用 类名.方法名称 
                处理函数:function(index, element) :
                  index, element都是自定义的形参，名称自定义。
                  index：循环的索引
                  element：数组中的成员
    
     传统js循环数组：
      for(var i=0;i<arr.length;i++){
         var item = arr[i]; //数组成员
    		//操作数组成员
    		shuchu( i , item);
      }
      function shuchu(index, emlemnt){
        输出index ，element
      }
      
      Jquery的each写法来循环数组arr：
      	$.each(arr,function(index,element){})


​            
​            
    语法2.
    	循环jquery对象， jquery对象就是dom数组
    		语法规则：jQuery对象.each( function( index, element ) { 处理程序 } )






# 10.jquery中给dom对象绑定事件



	1） $(选择器).事件名称( 事件的处理函数)
	        $(选择器)：定位dom对象， dom对象可以有多个，这些dom对象都绑定事件了
	        事件名称：就是js中事件去掉on的部分
	        	例如 js中的单击事件 onclick(),那么jquery中的事件名称，就是click，都是小写的。
	        事件的处理函数：就是一个function ，当事件发生时，执行这个函数的内容。
	        
	        例如给id是btn的按钮绑定单击事件： （但是要在入口函数里面才能绑定）
		        $("#btn").click(funtion(){
		         alert("btn按钮单击了")
		       })


	2) on 事件绑定
	   $(选择器).on( 事件名称 , 事件的处理函数)
	 
	  事件名称： 就是js事件中去掉on的部分， 例如js中onclick ,这里就是click
	  事件的处理函数： function 定义。
	
	  例如， <input type="button" id="btn">
	   $("#btn").on("click", function() { 处理按钮单击 } )

# 11.使用jquery的函数，实现ajax请求的处理。


	没有jquery之前，使用XMLHttpRequest做ajax，有4个步骤。  
	但是现在jquery简化了ajax请求的处理。使用三个函数可以实现ajax请求的处理。
	
	 1） $.ajax() : jquery中实现ajax的核心函数。
	 2） $.post() : 使用post方式做ajax请求。
	 3） $.get() : 使用get方式发送ajax请求。
	
	 $.post()和$.get() 他们在内部都是调用的 $.ajax() 


​	 介绍 $.ajax函数的使用，该函数的参数表示请求的url， 请求的方式(get|post)，参数值等信息。
​	 $.ajax()参数是一个json的结构。

	   语法：$.ajax( { name:value, name:value, ... } )
	
	         例如： $.ajax(  {  
	         					   async:true , 
				                   contentType:"application/json" , 
				                   data: {name:"lisi",age:20 },
								   dataType:"json",
								   error:function(){
	                              	请求出现错误时，执行的函数
								   },
								   success:function( data ) {
	                            	 // data 就是responseText, 是jquery处理后的数据。
								   },
								   url:"bmiAjax",
								   type:"get"
							}  
						 )
						 
	 json结构的参数说明：
	     1)async:是一个boolean类型的值， 默认是true ，表示异步请求的。可以不写async这个配置项
	            xmlHttp.open(get,url,true),第三个参数一样的意思。
	     2)contentType: 一个字符串，表示从浏览器发送服务器的参数的类型。 可以不写。
	                    例如你想表示请求的参数是json格式的， 可以写application/json
	     3)data: 可以是字符串，数组，json，表示请求的参数和参数值。 常用的是json格式的数据
	     4)dataType: 表示期望从服务器端返回的数据格式，可选的有： xml ， html ，text ，json
	          当我们使用$.ajax()发送请求时， 会把dataType的值发送给服务器， 那我们的servlet能够
	            读取到dataType的值，就知道你的浏览器需要的是 json或者xml的数据，那么服务器就可以
	            返回你需要的数据格式。
	     5)error: 一个function ，表示当请求发生错误时，执行的函数。
	        error:function() {   发生错误时执行  }  
	
	     6)sucess:一个function , 请求成功了，从服务器端返回了数据，会执行success指定函数
	              之前使用XMLHttpRequest对象， 当readyState==4 && status==200的时候。
	        success(resp)：当请求成功时运行的函数，其中resp是自定义的形参名
	
	     7)url:请求的地址
	     8)type:请求方式，get或者post， 不用区分大小写。 默认是get方式。
	     
	主要使用的是 url , data ,dataType, success .






**$.get()**

```
$.get() 方法使用 HTTP GET 请求从服务器加载数据。

语法：$.get(url,data,function(data,status,xhr),dataType)

url 必需。规定您需要请求的 URL。

data 可选。规定连同请求发送到服务器的数据。

function(data,status,xhr)可选。当请求成功时运行的函数。data,status,xhr 是自定义形参名。

参数说明：

data - 包含来自请求的结果数据

status - 包含请求的状态（"success"、"notmodified"、"error"、"timeout"、"parsererror"）

xhr - 包含 XMLHttpRequest 对象

dataType 可选。规定预期的服务器响应的数据类型。默认地，jQuery 会智能判断。可能的

类型：

"xml" - 一个 XML 文档

"html" - HTML 作为纯文本

"text" - 纯文本字符串

"json" - 以 JSON 运行响应，并以对象返回
```



**$.post()**

```
$.post() 方法使用 HTTP POST 请求从服务器加载数据。

语法：$.post(URL,data,function(data,status,xhr),dataType)

参数同$get()
```

