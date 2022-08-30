package com.bjpowernode.javaweb.servlet;

import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.Map;
import java.util.*;
/*
username=zhangsan&userpwd=123&interest=s&interest=d&interest=tt
Map<String,String[]>
    key�洢String
    value�洢String[]
    key				value
    ----------------------
    username		{"abc"}
	userpwd			{"111"}
	interest		{"s","d","tt"}


�ܽ�һ�£�request�ӿ����ĸ��ǳ���Ҫ�ķ���
	Map<String,String[]> parameterMap=request.getParameterMap();
	String[] names=request.getParameterNames();
	String[] values=request.getParameterValues("name");
	String value=request.getParameter("name");
*/
public class RequestTestServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException{
		//����ӿڱ�̣�HttpServletRequest�ӿڡ�
		//��ȡǰ���ύ������
		//ǰ�˻��ύʲô�����أ�
		//username=zhangsan&userpwd=123&interest=s&interest=d&interest=tt
		//���ϵ����ݻᱻСè���װ��request������

		//��ȡ����Map����
		Map<String,String[]> parameterMap=request.getParameterMap();
		//����Map����
		//������ķ�ʽ����ȡMap���������е�key������
		Set<String> keys=parameterMap.keySet();
		Iterator<String> it =keys.iterator();
		while(it.hasNext()){
			String key=it.next();
			//System.out.println(key);
			//ͨ��key��ȡvalue
			String[] values=parameterMap.get(key);
			/*
			username=[Ljava.lang.String;@107e6128
			userpwd=[Ljava.lang.String;@237ea34b
			interest=[Ljava.lang.String;@61e092fa
			*/
			//System.out.println(key +"="+  values);
			
			//����һά����
			System.out.print(key+ "=");
			for(String value:values){
				System.out.print(value+",");
			}

			//����
			System.out.println();
		}

		//�������Ϸ���֮�⣬���ǻ�����ֱ��ͨ��getParameterNames()�������ֱ�ӻ�ȡ���Map���ϵ�����key
		Enumeration<String> names=request.getParameterNames(); 
		while(names.hasMoreElements()){
			String name=names.nextElement();
			System.out.println(name);
		}

		//ֱ��ͨ��name��ȡvalue���һά����
		String[] usernames=request.getParameterValues("username");
		String[] userpwds=request.getParameterValues("userpwd");
		String[] interests=request.getParameterValues("interest");
		//����һά����
		for(String username:usernames){
			System.out.println(username);
		}
		for(String userpwd:userpwds){
			System.out.println(userpwd);
		}
		for(String interest:interests){
			System.out.println(interest);
		}


		//ͨ��name��ȡvalue���һά����ĵ�һ��Ԫ��
		//�������ʹ����࣬��Ϊ���һά������һ��ֻ��һ��Ԫ��
		String username= request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		//String interest=request.getParameter("interest");
		
		//��Ȼ��checkbox�������ǾͲ�����getParameter��"interest"���ˣ�Ӧ����getParameterValues("interest")
		String[] interests2=request.getParameterValues("interest");
		//��interests���һά������б���
		for(String interest:interests){
			System.out.println(interest);
		}

		//��ȡ�Ķ���һά���鵱�еĵ�һ��Ԫ��
		System.out.println(username);
		System.out.println(userpwd);
		//System.out.println(interest);



	}
}