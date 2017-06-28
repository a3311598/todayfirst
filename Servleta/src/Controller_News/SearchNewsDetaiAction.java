package Controller_News;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/Bootstrap/newsDetail")
public class SearchNewsDetaiAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		NewsService service = new NewsServiceImp();
		News passage = new News();
		
		 int id = Integer.parseInt(request.getParameter("id"));
			News passage1=service.searchNews(id);
			request.setAttribute("news", passage1);
				System.out.println(passage1);
//				response.sendRedirect(request.getContextPath()+"/Bootstrap/newslist.jsp");
				request.getRequestDispatcher("/Bootstrap/newsdetail.jsp").forward(request, response);
			
			
		} 
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
