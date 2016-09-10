package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Interface.ServiceForward;
import Interface.ServiceInterface;

public class LogoutService implements ServiceInterface {

  @Override
  public ServiceForward excute(HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub
    ServiceForward forward = new ServiceForward();
    forward.setRedirect(true);
    forward.setPath("./index.jsp");
    
    HttpSession session = request.getSession();
    session.removeAttribute("Member");
    session.invalidate();
       
    return forward;
  }

}