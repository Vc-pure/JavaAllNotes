# 1.全局刷新和局部刷新

**全局刷新**：整个浏览器被新的数据覆盖。在网络中传输大量的数据。浏览器需要加载，渲染页面。

**局部刷新**：在浏览器的内部，发送请求，获取数据，改变页面中的部分内容。其余的页面无需加载和渲染。网络中数据传输量少，给用户的感受好。



# 2.AJAX

```
ajax：Asynchronous JavaScript and XML(异步的 			  JavaScript 和 XML)
Asynchronous：异步的意思
JavaScript：JavaScript脚本，在浏览器中执行
and：和
xml：是一种数据格式
```



ajax是一种做局部刷新的方法，不是一种语言。Ajax包含的技术主要有JavaScript，dom，css，xml等等。核心是JavaScript和xml。

JavaScript：负责创建异步对象，发送请求，更新页面的dom对象。Ajax请求需要服务器端的数据。

xml：网络中的传输的数据格式。 使用json替换了xml

       <数据>
          <数据1>宝马1</数据1>
      <数据2>宝马2</数据2>
      <数据3>宝马3</数据3>
      <数据4>宝马4</数据4>
      </数据>


# 3.Ajax中使用XMLHttpRequest对象步骤（AJAX异步实现步骤）

```
1）创建异步对象 var xmlHttp = new XMLHttpRequest();
2）给异步对象绑定事件。  
	onreadystatechange事件:当异步对象发起请求，获取了数据都会触发这个事件。这个事件需要指定一个函数，在函数中处理状态的变化。	 以前：
   btn.onclick = fun1()
   function fun1(){
   	  alert("按钮单击");
   }
   
   现在的语法：
   xmlHttp.onreadystatechange = function(){
   		处理请求的状态变化。	
   		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
   			//可以处理服务器端的数据，更新当前页面
   			var data = xmlHttp.responseText;
   			document.getElementById("name").value=data;
   		}
   }
   
   
   
   下面是 XMLHttpRequest 对象的三个重要的属性：
   onreadystatechange属性：一个 js 函数名 或 直接定义函数，每当 readyState 属性改变时，就会调用该函数
   
   readyState属性：表示异步对象请求(XMLHttpRequest)的状态变化。从0到4发生变化
       0:请求未初始化，创建异步请求对象 var xmlHttp = new XMLHttpRequest()
       1:初始化异步请求对象，xmlHttp.open(请求方式，请求地址，true)
       2:异步对象发送请求， xmlHttp.send()
       3:异步对象接收应答数据，从服务端返回数据。异步对象(XMLHttpRequest)内部处理，获取了原始的数据
       4:异步请求对象已经将数据解析完毕。此时才可以读取数据。
         此时开发人员在4的时候处理数据。在4的时候，开发人员做什么？更新当前页面。
   
   status属性
   	表示网络请求的情况
   		200:"OK"
    	404:未找到页面
    	500:服务器端代码出错
    需要的是当status==200时，表示网络请求是成功的。

3）初始化异步请求对象
	异步对象的方法open().
	xmlHttp.open(请求方式get|post,"服务器端的访问地址",同步|异步请求(默认是true,异步请求))  
	例如：
	xmlHttp.open("get","loginServlet?name=zs&pwd=123",true);
	
4）使用异步对象发送请求
	xmlHttp.send()
		
  如何获取服务器端返回的数据，使用异步对象的一个属性responseText 
  使用例子：
  	xmlHttp.responseText
  
  回调：当请求的状态发生变化的时候，异步对象会自动调用onreadystatechange事件对应的函数。每变化一次，都会调用一次该函数方法。
  		比如执行open时会执行一次xmlHttp.onreadystatechange = function(){ 
  		再执行send时也会再执行一次xmlHttp.onreadystatechange = function(){
	
  访问地址： 使用get方式传递参数
  http://localhost:8080/course_myajax/bmiPrint?name=李四&w=82&h=1.8
```



```
//接收请求参数
String strName = request.getParameter("name");
String height = request.getParameter("h");
String weight = request.getParameter("w");

//计算bmi ：bmi=体重/身高的平方
float h = Float.valueOf(height);
float w = Float.valueOf(weight);
float bmi = w / (h*h);

//判断bmi的范围
String msg="";
if(bmi <= 18.5 ){
    msg = "您比较瘦";
}else if(bmi > 18.5 && bmi <=23.9){
    msg="您的bmi是正常的";
}else if(bmi > 24 && bmi<=27 ){
    msg = "您的身体比较胖";
}else {
    msg = "您的身体肥胖";
}
System.out.println("msg="+msg);
msg = "您好："+strName +"先生/女士，您的bmi的值是:"+bmi+","+","+msg;
```



Ajax请求处理方式：

![image-20220810153734043](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220810153734043.png)







# 21集末尾可以总结servlet的执行步骤帮助巩固理解web基础和Ajax







# 4.json的使用

```
 ajax发起请求-------servlet（返回的一个json格式的字符串 { name:"河北", jiancheng:"冀","shenghui":"石家庄"}）
 
json分类：
  	1. json对象 ，JSONObject ,这种对象的格式   名称:值， 也可以看做是 key:value 格式。
    2. json数组， JSONArray, 基本格式  [{ name:"河北", jiancheng:"冀","shenghui":"石家庄"} , { name:"山				西", jiancheng:"晋","shenghui":"太原"} ]
        
        
为什么要使用json ：
     1. json格式好理解
	 2. json格式数据在多种语言中，比较容易处理。 使用java， javascript读写json格式的数据比较容易。
	 3. json格式数据占用的空间小，在网络中传输快， 用户的体验好。
	 

处理json的工具库： gson（google）， fastjson（阿里），jackson， json-lib


 在js中，可以把json格式的字符串，转为json对象， json中的key，就是json对象的属性名。
```





# 5.Ajax知识点总结思维导图：

![image-20220810213552275](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220810213552275.png)

![image-20220810192116538](C:\Users\Nicolasbruno\AppData\Roaming\Typora\typora-user-images\image-20220810192116538.png)



















