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
 * Servlet implementation class NewsAction
 */
@WebServlet("/addNews")
public class AddNewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		NewsService service = new NewsServiceImp();
		News passage = new News();
		
		passage.setHeadline(request.getParameter("headline"));
		passage.setContent(request.getParameter("content"));
		passage.setHeadname(request.getParameter("headname"));
	
			
			service.addNews(passage);
			
			
//				response.sendRedirect(request.getContextPath()+"/Bootstrap/todayfirst.jsp");
				request.getRequestDispatcher("ManagerAction").forward(request, response);
			
			
		} 
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
