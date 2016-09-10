package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import DTO.BoardDTO;
import DTO.MemberDTO;
import Interface.ServiceForward;
import Interface.ServiceInterface;

public class BoardRegisterService implements ServiceInterface {

	@Override
	public ServiceForward excute(HttpServletRequest request,
			HttpServletResponse response) {
		
		ServiceForward forward = new ServiceForward();
		//글작성 페이지는  sendredirect
		
		forward.setRedirect(true);
		forward.setPath("./index.jsp");
		
		
		
		//글을 등록할 애 찾아와야댐
		BoardDTO dto = new BoardDTO();
		dto.setTitle(request.getParameter("title")); //post.jsp에서 이러케 두개를 보내 
		dto.setContent(request.getParameter("content"));
		dto.setMember_id(1);
		
		HttpSession session = request.getSession();
		
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		dto.setAuthor(member.getId());
		dto.setPassword(member.getPw());
		
		BoardDAO dao = new BoardDAO(); 
		dao.Create(dto);
		
		
		
		
		
	
		return forward;
	}

}
