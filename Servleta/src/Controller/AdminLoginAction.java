package Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.Admin;
import Service.AdminService;
import Service.AdminServiceImp;
@WebServlet("/adminlogin")
public class AdminLoginAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin admin = new Admin();
		AdminService service = new AdminServiceImp();
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		admin = service.loginAdmin(account,password);
		if(admin!=null){
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			String path = req.getContextPath();
			resp.sendRedirect(path+"/Bootstrap/resource.jsp");
		}else{
//			resp.getWriter().print("用户名或密码错误！");
			req.getRequestDispatcher("/admin/adminlogin.jsp").forward(req, resp);
		}
	}
}
