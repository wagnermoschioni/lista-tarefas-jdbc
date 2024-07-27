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

@WebServlet(urlPatterns = {"/main", "/novaTarefa", "/listar", "/excluir", "/excluirTudo"})
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
		} else if (action.equals("/excluir")) {
			try {
				String idParam = req.getParameter("id");		
				Long id = Long.parseLong(idParam);		
				excluirTarefa(id);
				resp.sendRedirect("main");
			} catch (ServletException | IOException | SQLException e) {
				
				e.printStackTrace();
			}
		} else if (action.equals("/excluirTudo")) {
			try {			
				excluirTudo();
				resp.sendRedirect("main");
			} catch (ServletException | IOException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
protected void excluirTudo () throws ServletException, IOException, SQLException {
		
		
		new TarefaDAO().excluirTudo();
		
	}
	
	protected void excluirTarefa (Long id) throws ServletException, IOException, SQLException {
		
		
		new TarefaDAO().excluirTarefa(id);
		
	}
	
	protected void editarTarefa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		
		
}
	
	protected void novaTarefa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
			
			
			bean.setDescricao(req.getParameter("descricao"));
			bean.setStatus(req.getParameter("status"));			
			new TarefaDAO().inserirTarefa(bean);			
			resp.sendRedirect("main");
			
			
			
	}
}
