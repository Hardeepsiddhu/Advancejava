package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QueryString")
public class QueryString extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("in queryString do get..!");
	
	String name = req.getParameter("name");
	System.out.println("name = "+name);
	
	String [] address = req.getParameterValues("address");
	for (String add : address) {
		System.out.println(add);
	}
	
//	String address = req.getParameter("address");
//	
//	System.out.println("addess ="+address);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	System.out.println("in query string do post..!");
	}

}
