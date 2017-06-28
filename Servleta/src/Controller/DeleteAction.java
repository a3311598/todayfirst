package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Dao.UserDaoImp;
import Domain.User;
@WebServlet("/Bootstrap/delete")
public class DeleteAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDaoImp();
		User user = new User();
		req.setCharacterEncoding("UTF-8");
		String delete = req.getParameter("id");

					user.setId(Integer.parseInt(delete));
					dao.delete(user.getId());//删除用户
					req.getRequestDispatcher("../ManagerAction").forward(req, resp);

	}
			

		}
			
			
	
	
	

