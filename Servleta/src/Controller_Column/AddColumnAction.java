package Controller_Column;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Column;
import Service.ColumnService;
import Service.ColumnServiceImp;

/**
 * Servlet implementation class NewsAction
 */
@WebServlet("/Bootstrap/addColumn")
public class AddColumnAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ColumnService service = new ColumnServiceImp();
		Column column = new Column();
		column.setColumnname(request.getParameter("columnname"));
			service.addColumn(column);
			
//				response.sendRedirect(request.getContextPath()+"/Bootstrap/todayfirst.jsp");
				request.getRequestDispatcher("../ManagerAction").forward(request, response);
			
			
		} 
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
