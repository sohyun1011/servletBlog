package Interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceInterface {
	
	public ServiceForward excute(HttpServletRequest request, HttpServletResponse response);

}
