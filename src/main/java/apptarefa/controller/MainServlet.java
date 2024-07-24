package apptarefa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apptarefa.dao.TarefaDAO;
import apptarefa.model.TarefaBeans;

@WebServlet(urlPatterns = {"/main", "/novaTarefa", "/listar"})
public class MainServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

		
	TarefaBeans bean = new TarefaBeans();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		
		String action = req.getServletPath();
		System.out.println(action);
		
		if (action.equals("/main")) {
			List<TarefaBeans> lista =  new TarefaDAO().listaTarefas();
			
			req.setAttribute("tarefas", lista);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("quadro.jsp");
			requestDispatcher.forward(req, resp);
			//resp.sendRedirect("quadro.jsp");
		} else if (action.equals("/novaTarefa")) {
			try {
				novaTarefa(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	protected void novaTarefa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
			
			bean.setDescricao(req.getParameter("descricao"));
			bean.setStatus(req.getParameter("status"));
			
			new TarefaDAO().inserirTarefa(bean);
			
			resp.sendRedirect("main");
			
			
			
	}
}
