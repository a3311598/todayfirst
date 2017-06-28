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

@WebServlet("/register")
public class RegisterAction extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		UserService service = new UserServiceImp();
		req.setCharacterEncoding("utf-8");
		user.setAccount(req.getParameter("account"));
		user.setPassword(req.getParameter("password"));
		user.setName(req.getParameter("name"));
		int count = service.register(user);
		if(count==1){
			req.getRequestDispatcher("/user/register.jsp").forward(req, resp);
		}
	}
	
}
