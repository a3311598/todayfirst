package Session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import Domain.User;
import Service.UserService;
import Service.UserServiceImp;
@WebListener
/**
 * Servlet implementation class ListenerSession
 */

public class ListenerSession implements HttpSessionListener{
	private static final long serialVersionUID = 1L;
	private int count = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenerSession() {
    
    	
      System.out.println("在线人数："+count);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/view.jsp").forward(request, response);;
		request.getRequestedSessionId();
//		request.getSession().invalidate();//销毁session
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		count++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		count--;
		
	}

}
