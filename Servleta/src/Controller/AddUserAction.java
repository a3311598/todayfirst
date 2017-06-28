package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.User;
import Service.UserService;
import Service.UserServiceImp;

@WebServlet("/Bootstrap/addUser")
public class AddUserAction extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		UserService service = new UserServiceImp();
		req.setCharacterEncoding("utf-8");
		user.setAccount(req.getParameter("account"));
		user.setPassword(req.getParameter("password"));
		user.setName(req.getParameter("name"));
		int count = service.register(user);
		
		if(count==1){
			req.getRequestDispatcher("../ManagerAction").forward(req, resp);
		}else{
			req.getRequestDispatcher("/user/adduser.jsp").forward(req, resp);
		}
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	}
}