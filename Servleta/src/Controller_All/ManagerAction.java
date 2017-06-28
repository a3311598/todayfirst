package Controller_All;

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
import Service.UserService;
import Service.UserServiceImp;

/**
 * Servlet implementation class ManagerAction
 */
@WebServlet("/ManagerAction")
public class ManagerAction extends HttpServlet {
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
		UserService service2 = new UserServiceImp();
		User user = new User();
		
		passage.setHeadline(request.getParameter("headline"));
	
			List<News> newList=service.search(passage.getHeadline());
			List<Column> colList=service1.search(column.getColumnname());
			List<User> userList=service2.listByname("");
			
			request.getSession().setAttribute("newList", newList);
			request.getSession().setAttribute("colList", colList);
			request.getSession().setAttribute("userList", userList);
			
				response.sendRedirect(request.getContextPath()+"/Bootstrap/resource.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
