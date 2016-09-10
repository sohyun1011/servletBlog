package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBManager.DBManager;
import DTO.BoardDTO;

public class BoardDAO {

	public ArrayList<BoardDTO> getList() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		String sql = "SELECT * from board order by id desc, created_at desc limit 3";

		Connection conn = DBManager.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				BoardDTO dto = new BoardDTO();

				dto.setId(result.getInt("id"));
				dto.setTitle(result.getString("title"));
				dto.setContent(result.getString("content"));
				dto.setMember_id(result.getInt("member_id"));
				dto.setCreated_at(result.getDate("created_at"));
				dto.setAuthor(result.getString("author"));
				dto.setPassword(result.getString("password"));

				list.add(dto);

			}
			result.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public boolean Create(BoardDTO dto) {// board dto받아서 db에 집어넣을 겨
		boolean b = false;
		Connection conn = DBManager.getConnection();

		String sql = "Insert into board (title, content, created_at, member_id, author, password)"
				+ "values (?,?,now(),?,?,?);";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			
			pstmt.setInt(3, dto.getMember_id());
			pstmt.setString(4, dto.getAuthor());
			pstmt.setString(5, dto.getPassword());

			int index = pstmt.executeUpdate();
			if (index > 0) {
				b = true;
			} else {
				b = false;

			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;

	}

}
