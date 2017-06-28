package Controller_Column;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Column;
import Domain.News;
import Service.ColumnService;
import Service.ColumnServiceImp;

/**
 * Servlet implementation class NewsAction
 */
@WebServlet("/searchColumn")
public class SearchColumnAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ColumnService service = new ColumnServiceImp();
		Column column = new Column();
		
		column.setColumnname(request.getParameter("columnname"));
			List<Column> colList=service.search(column.getColumnname());
			request.getSession().setAttribute("colList", colList);
//			System.out.println(newList);
			
//				response.sendRedirect(request.getContextPath()+"/Bootstrap/newslist.jsp");
			if(request.getParameter("columnname")!=null){
				request.getRequestDispatcher("/Bootstrap/columnlist.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("../ManagerAction").forward(request, response);
			}
			
			
		} 
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
