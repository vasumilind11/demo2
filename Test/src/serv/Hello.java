package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import z.Mailer;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			PrintWriter out = resp.getWriter();
			out.print("abc");
	        resp.setContentType("text/html"); 		
			String to = req.getParameter("to");
			String subject =req.getParameter("subject");
			String msg = req.getParameter("msg");
			
			Mailer.send(to, subject, msg);
			out.write("Mailed sucessfully" + to + subject + msg);
		}

	}


