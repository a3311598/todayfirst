package Controller_News;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.News;
import Service.NewsService;
import Service.NewsServiceImp;

/**
 * Servlet implementation class DeleteNewsAction
 */
@WebServlet("/Bootstrap/deleteNews")
public class DeleteNewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService service = new NewsServiceImp();
		News passage = new News();
		int id = Integer.parseInt(request.getParameter("id"));
		service.deleteNews(id);
		request.getRequestDispatcher("../ManagerAction").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
