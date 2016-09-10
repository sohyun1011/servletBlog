package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBManager.DBManager;
import DTO.MemberDTO;

public class MemberDAO {

	// 로그인 처리
	public boolean login(MemberDTO dto) {
		boolean b = false;

		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		String sql = "Select * from member where mid=? and mpwd=?";

		try 
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getId());
			
			ResultSet rs = pstmt.executeQuery();
			
			int count = 0;
			
			while(rs.next())
			{
				count++;
			}
			
			if(count>0)
				b = true; //true되면 로그인 처리 성공 
			rs.close();
			pstmt.close();
			con.close();
			
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

}
