package com.bjpowernode.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet
{
	//�������
	public void init(ServletConfig config) throws ServletException{
	}

	public void service(ServletRequest request,ServletResponse response)
		throws ServletException,IOException{
		//�����̨��ӡ���
		System.out.println("My First Servlet,Hello Servlet");

		//������Ӧ��������������ͨ�ı�����HTML����
		//��Ҫ�ڻ�ȡ������֮ǰ���ò���Ч��
		response.setContentType("text/html");


		//��ô��һ����Ϣֱ�������������ϣ�
		//��Ҫʹ��ServletResponse�ӿڣ�response
		//response��ʾ��Ӧ���ӷ�������������������ݽ�����Ӧ
		PrintWriter out =response.getWriter();
		
		//������Ӧ����������ʱ��Ҫ�ڻ�ȡ��֮�����á�
		//response.setContentType("text/html");

		//���������ӡ���
		out.print("Hello Servlet,you are my first servlet");

		//������ǿ���ʶ��HTML����ģ��������ǲ��ǿ������һ��һ��HTML�����أ�
		out.print("<h1>hello servlet</h1>");

		//����һ�����������������ַ���
		//������������Ҫ����ˢ�£�Ҳ����Ҫ���ǹرգ���Щ����Tomcat��ά��
		/*
		out.flush();
		out.close();
		*/
	}
	
	public void destroy(){
	}

	public String getServletInfo(){
		return "";
	}

	public ServletConfig getServletConfig(){
		return null;
	}

}