package edu.web.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/recommend.do")
public class Get_recommend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Get_recommend() {
       
    }

	// 2. InfoServlet - <JSON Array 객체 생성> 참고 & LoginServlet - <>
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        String str = request.getParameter("str");
     	System.out.println(str);
     	
     	String result;
     	
     	if(str.charAt(0) == ' '){
     		result = " ";
     	}else if(str.charAt(0) == ' '){
     		result = " ";
     	}else if(str.charAt(0) == ' '){
     		result = " ";
     	}else{
     		result = " ";
     	}

        
        response.getWriter().write(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
