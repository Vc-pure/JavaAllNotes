package com.bjpowernode.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet
{
	//�������
	public void init(ServletConfig config) throws ServletException{
	}

	public void service(ServletRequest request,ServletResponse response)
		throws ServletException,IOException{

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//��дJDBC���룬�������ݿ⣬��ѯ����ѧ����Ϣ
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			String url="jdbc:mysql://localhost:3306/bjpowernode?useUnicode=true&characterEncoding=utf8&useSSL=false";
			String user="root";
			String password="123456";
			//���ӳɹ�
			conn=DriverManager.getConnection(url,user,password);
			//��ȡԤ��������ݿ��������
			String sql="select no,name from t_student";
			ps=conn.prepareStatement(sql);
			//ִ��SQL
			rs=ps.executeQuery();
			//������ѯ�����
			while(rs.next()){
				String no=rs.getString("no");
				String name=rs.getString("name");
				//System.out.println(no+name);
				out.print(no+","+name+"<br>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
		if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		}
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