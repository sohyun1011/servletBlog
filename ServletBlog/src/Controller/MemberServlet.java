package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.ServiceForward;
import Interface.ServiceInterface;
import Service.LoginService;
import Service.LogoutService;

public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		System.out.println("분기 명령어 : " + cmd);

		ServiceForward forward = null;
		ServiceInterface service = null;

		if (cmd.equals("login")) { //로그인을 할 때
			service = new LoginService();
			forward = service.excute(request, response);

		}
		
	    if (forward != null) {

	    }
	    
	    if(cmd.equals("logout")){
	      service = new LogoutService();
	      
	      forward = service.excute(request, response);
	    }
		
	
			if (forward.isRedirect()) // redirect
			{
				response.sendRedirect(forward.getPath());
			}

			else // forward
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);

			}

	

	}

}
