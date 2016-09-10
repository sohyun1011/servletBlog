package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DBManager.DBManager;
import DTO.BoardDTO;

public class BoardDAO {
	
	public ArrayList<BoardDTO> getList(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		return list;
		
	}
	
	
	
	
	
	
	
	public boolean Create(BoardDTO dto){//board dto받아서 db에 집어넣을 겨 
		boolean b = false; 
		Connection conn = DBManager.getConnection();
		
		String sql = "Insert into board ('title', 'content', 'created_at', 'member_id', 'author', 'password')" 
				+ "values (?,?,now(),?,?,?);";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(0, dto.getTitle());
			pstmt.setString(1, dto.getContent());
			pstmt.setDate(2, dto.getCreated_at());
			pstmt.setInt(3, dto.getMember_id());
			pstmt.setString(4, dto.getAuthor());
			pstmt.setString(5, dto.getPassword());
			
			int index = pstmt.executeUpdate();
			if(index>0){
				b = true;
			}else{
				b= false;
				
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return b ;
		
	}

}
