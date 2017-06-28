package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.User;
import Service.UserService;
import Service.UserServiceImp;
@WebServlet("/Bootstrap/update")
public class UpdateAction extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 User user = new User();
		 req.setCharacterEncoding("UTF-8");
		
					int id=Integer.parseInt(req.getParameter("id"));
					req.getSession().setAttribute("id", id);
					req.getRequestDispatcher("/user/update.jsp").forward(req,resp);
			}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	
	
}