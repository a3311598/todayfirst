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
@WebServlet("/userlogin")
public class UserLoginAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		UserService service = new UserServiceImp();
		user.setAccount(req.getParameter("account"));
		user.setPassword(req.getParameter("password"));
		System.out.println(user);
		if(user.getAccount()!=null&&user.getPassword()!=null){
			if(service.loginUser(user)==1){
			resp.sendRedirect(req.getContextPath()+"/Bootstrap/todayfirst.jsp");
		} else{
			resp.sendRedirect(req.getContextPath()+"/Bootstrap/userlogin.jsp");
		}                    
		
		}          
	}

		
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}