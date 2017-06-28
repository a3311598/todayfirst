package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Column;
import Domain.News;
import Domain.User;
import Service.ColumnService;
import Service.ColumnServiceImp;
import Service.NewsService;
import Service.NewsServiceImp;

/**
 * Servlet implementation class NewsAction
 */
@WebServlet("/NewsAction")
public class NewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		NewsService service = new NewsServiceImp();
		News passage = new News();
		ColumnService service1 = new ColumnServiceImp();
		Column column = new Column();
		passage.setHeadline(request.getParameter("headline"));
		List<News> newList=service.search(passage.getHeadline());
		List<Column> colList=service1.search(column.getColumnname());
		request.getSession().setAttribute("colList", colList);
		request.getSession().setAttribute("newList", newList);
		System.out.println(colList);
			
				response.sendRedirect(request.getContextPath()+"/Bootstrap/todayfirst.jsp");
//				request.getRequestDispatcher("/Bootstrap/todayfirst.jsp").forward(request, response);
			
			
		} 
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
