package Session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.User;
@WebServlet("/view")
public class TestSession extends HttpServlet{
	private static long fjfjfjjfjfjf;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getSession(arg0);
		//参数true:
		//req.getSession();等价于req.getSession(true)
		//false
		User user = new User();
		user.setAccount("admin");
		HttpSession session = req.getSession();
		req.getSession().setAttribute("user",user);
		session.setAttribute("user", user);
		req.getRequestDispatcher("/user/view.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
