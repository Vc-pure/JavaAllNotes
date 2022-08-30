米米商城后台开发系统

整个这套系统涉及到的内容：
          1.技术指标
	   技术一:   
		 Spring框架的使用（核心是IOC和AOP，主要用来优化控制器）
		 SpringMVC框架的使用
		 MyBatis框架的使用（主要来对数据访问层的优化）
	   技术二（亮点）:   
		 Ajax异步刷新技术的使用
		 Ajax文件上传实现
		 Ajax分页实现
		 Ajax多条件查询
		 Ajax单个删除、批量删除
	   技术三：
		 JSP标签库的使用
		 EL表达式的使用
		 jQuery的使用
		 BootStrap
		
          2.开发环境
	服务器端：
		Spring+SpringMVC+MyBatis框架整合
	数据库：
		Mysql8.0.23
	项目管理：
		Maven
	前端：
		Jquery+BootStrap+JS
	开发工具：
		IDEA 2021.2.2
          3.项目功能
	1）密码加密：登录处理
	2）分页显示商品：Ajax翻页显示商品，首页末页处理
	3）增加商品：异步Ajax上传文件，监听器处理商品类型
	4）更新商品：图片上传后即时回显，商品类型回显
	5）ajax删除商品：ajax批量删除商品，ajax 多条件批量删除
	6）ajax多条件查询：ajax多条件查询并分页，ajax多条件查询翻页
	7）ajax多条件查询后更新，ajax多条件查询后删除，ajax多条件查询后批量删除
	8）ajax多条件查询后删除和更新停留在当前页处理 




搭建SSM项目的步骤：
1）新建maven工厂
2）修改目录，修改pom.xml
3）添加SSM框架的所有依赖
4）拷贝jdbc.properties到resources目录下
5）新建applicationContext_dao.xml文件，进行数据访问层的配置
6）新建applicationContext_service.xml文件，进行业务逻辑层的配置
7）新建当前springmvc.xml文件，配置SpringMVC的框架
8）新建SqlMapConfig.xml文件，进行分页插件的配置
9）使用逆向工程生成pojo和mapper文件
10）开发业务逻辑层，实现登录判断
11）开发控制器AdminAction，完成登录处理
12）改造页面，发送登录请求，验证登录



在第九步完成以后，就开始进行开发：
	1.先进行登录功能的业务逻辑层的实现（service/Admin******)
	2.完成登录功能的业务逻辑层的实现以后，继续登录功能的界面层（controller）的开发
	3.进行登录功能的测试 http://localhost/admin/login.jsp
	4.进行商品业务逻辑层的不分页的开发（service/productInfo*****)
	5.商品分页所需数据的分析（PageInfo） 
	6.商品分页插件功能分析
	7.业务逻辑层实现类完成分页功能
	8.界面层ProductInfoAction的实现
	9.分页显示第一页的全部数据
	10.分页页码和总页码显示
	11.ajax提交分页请求页面功能实现（product.jsp)
	12.ajax分页控制器功能实现以及测试((productInfoAction)
	13.商品类型的业务逻辑层实现(productTypeService）
	14.商品类别监听器开发（listener/productTypeListener)
	15.新增商品时，页面下拉列表框显示全部商品类型(addproduct.jsp 100-109行）
	16.异步Ajax图片上传页面开发(addproduct.jsp 16-34行）：就是选择好上传的图片之后能回显到客户端
		过程中需要用到一个jQuery的类：ajaxfileupload.js	
	17.当前图片提交在服务器端以后，要进行文件名称的重新命名，就是存在服务器端的图片的名称，一定是要随机产生一个字符串，来构建当前图片的名称，这样就不会被后面再上传进来的同名名称覆盖掉。这是服务器端要进行的处理。
		要进行这种处理：要添加一个工具类：FileNameUtil.java
		而且要进行文件上传，要借助springmvc的核心组件：mutilpartResolver（在springmvc.xml里设置）
	18.异步Ajax图片上传功能实现（productInfoAction.java） 也就是对17的分析的功能实现（上传但未回显）
	19.完成回显并在浏览器测试。先添加一个json 的依赖（pom.xml 138-142行），
			就可以实现返回json数据的构建（productInfoAction.java 78-82行） 与16步呼应
	20.完成新增商品的jsp页面（addproduct.jsp里<div id="table">这个div里的内容） 
	21.完成新增商品的控制器（界面层）的开发（save） ：((productInfoAction) 在此之前还要在		productInfoService和其实现类里写save的方法及其实现方法，才能在productInfoAction里调用
	22.商品信息在更新页面的回显 ：前端开发：update.jsp中的<div id="table">这个div标签里的内容
				然后还要在product.jsp中进行回显功能的提交：找到”编辑“的按钮这
				然后写function one(){
		后台开发：ProductInfoAction.java里@RequestMapping("/one")这个方法，当然还有业务层的
	
	23.商品更新功能的实现（编辑-->提交）：先写前端：update.jsp中的<div id="table">里的内容
				后端实现：先在service进行”更新商品“的开发（productInfoService***）
					再到ProductInfoAction里写@RequestMapping("/update")的内容
	24.ajax单个商品删除功能：
		product.jsp中根据注释找到//单个删除 下面的代码实现
		业务逻辑层写ProductInfoService***里面	//单个商品删除  的功能
		界面层里写 @RequestMapping("/delete")
		  和@RequestMapping(value = "/deleteAjaxSplit",produces ="text/html;charset=UTF-8")

小技巧：如何在一个页面上快速找到将要写代码的位置：
	例如：进入product.jsp的页面，ctrl+F ，然后搜索全选，然后在结果中寻找所搜索的位置

	25.全选按钮的功能实现：product.jsp： function allClick() {
	26.单个复选框点击改变全选复选框功能实现：product.jsp：function ckClick() {
	27.ajax批量删除mapper层实现：ProductInfoMapper和ProductInfoMapper.xml中手动开发
				//批量删除商品的功能
	28.ajax批量删除service层实现：ProductInfoService和ProductInfoServiceImpl中：
				//批量删除商品
	29.ajax批量删除controller层实现：ProductInfoAction：    
				//批量删除商品
   			                @RequestMapping("/deleteBatch")
	30.ajax批量删除前端实现：product.jsp：
				//批量删除
    				function deleteBatch() {

	31.把四个查询条件写到一个pojo类里进行封装：ProductInfoVo.java
	32.多条件查询商品的mapper层实现：
			ProductInfoMapper：//多条件查询商品
			ProductInfoMapper.xml：//多条件查询商品
	32.多条件查询商品的mapper层功能测试：
			ProductInfo：mabatis的逆向工程产生的实体类没有复写toString，所以自己加上
			MyTest：public void testSelectCondition(){
			SqlMapConfig.xml：
				观察一下查询语句拼接条件是否正确，加入一个控制台的日志输出（logImpl）
	33.多条件查询商品的service层实现：
			ProductInfoService：//多条件商品查询
			ProductInfoServiceImpl：selectCondition
	34.多条件查询商品的controller层实现：
			ProductInfoAction:@RequestMapping("/condition")
	35.多条件查询商品的前端页面开发：
			product.jsp:   
				  function condition(){
				  <div id="brall">
	36.多条件查询功能测试：在浏览器中进行
	37.多条件查询（分页）：ProductInfoVo改造
	38.多条件查询（分页）service层改造：
			ProductInfoService：//多条件查询分页
			ProductInfoServiceImpl：splitPageVo
	39.多条件查询（分页）controller层改造：
			ProductInfoAction：@RequestMapping("/ajaxSplit")
	40.多条件查询（分页） product.jsp改造：
			                    <c:forEach items="${info.list}" var="p">
				    function ajaxsplit(page) {...
	41.多条件查询后停留在当前页以及保留多条件查询的条件功能实现：
			product.jsp:  
				  onclick="one(${p.pId},${info.pageNum})">编辑
				  function one(pid,page) {
			ProductInfoAction:
				  @RequestMapping("/one")
				  @RequestMapping("/update")
				  @RequestMapping("/split")
	42.删除之后停留在当前页以及保留多条件查询的条件功能实现：
	product.jsp:
				    onclick="del(${p.pId},${info.pageNum})">删除
				    function del(pid,page) {
	ProductInfoAction:
		@RequestMapping("/delete")
		@RequestMapping(value = "/deleteAjaxSplit",produces = "text/html;charset=UTF-8")
			
			
			
另外订单管理和用户管理两个功能自己模仿商品管理去实现。
