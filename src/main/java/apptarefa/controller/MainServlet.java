package apptarefa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apptarefa.dao.Conexao;

@WebServlet("/main")
public class MainServlet extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		Conexao con = new Conexao();	
		/*
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Teste Servlet Main</body></html>");
		*/
		
		String action = req.getServletPath();
		System.out.println(action);
		
		if (action.equals("/main")) {
			resp.sendRedirect("quadro.jsp");
		}
		
		
	}
}
