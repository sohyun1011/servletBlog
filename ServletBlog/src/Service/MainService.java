package Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardDTO;
import Interface.ServiceForward;
import Interface.ServiceInterface;

public class MainService implements ServiceInterface{
	
	public ServiceForward excute(HttpServletRequest request,HttpServletResponse response) {
		
		
		ServiceForward forward = new ServiceForward();
		forward.setPath("./index.jsp");
		forward.setRedirect(false);
		
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.getList();
		request.setAttribute("boardList",list);
		
		return forward;
		
		
	}

}
