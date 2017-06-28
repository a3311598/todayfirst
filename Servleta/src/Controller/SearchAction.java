package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.User;
import Service.UserService;
import Service.UserServiceImp;
@WebServlet("/Bootstrap/list")
public class SearchAction extends HttpServlet{
	
	private UserService service = new UserServiceImp(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					
					req.setCharacterEncoding("UTF-8");
		
					User user = new User();
					
					user.setName(req.getParameter("username"));
				
				
						List<User> userList=service.listByname(user.getName());
						req.setAttribute("userList", userList);	
						if(req.getParameter("username")!=null){
							req.getRequestDispatcher("/user/list.jsp").forward(req, resp);
						}else{
							req.getRequestDispatcher("../ManagerAction").forward(req, resp);
						}
					} 
					
				
			}

