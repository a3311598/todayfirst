package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.User;
import Service.UserService;
import Service.UserServiceImp;


	@WebServlet("/Bootstrap/modify")
	public class ModifyAction extends HttpServlet{
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			UserService service = new UserServiceImp();
			User user = new User();
			req.setCharacterEncoding("UTF-8");
					Integer id = (int)req.getSession().getAttribute("id");
					
						
//						req.setAttribute("id", user.getId());
						user.setId(id);
						user.setAccount(req.getParameter("account"));
						user.setPassword(req.getParameter("password"));
						user.setName(req.getParameter("name"));
						service.updateUser(user);//修改用户
						req.getRequestDispatcher("../ManagerAction").forward(req,resp);
					
				}
}
