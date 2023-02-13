package com.revature.data.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.data.GradingFormatDAO;
import com.revature.models.GradingFormat;
import com.revature.utils.ConnectionUtil;

public class GradingFormatPostgres implements GradingFormatDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public GradingFormat getById(int id) {
		GradingFormat format = null;
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from grading_format where format_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			
			ResultSet resultSet = pStmt.executeQuery();
			
			if (resultSet.next()) {
				format = new GradingFormat();
				format.setFormatId(id);
				format.setName(resultSet.getString("format_name"));
				format.setExample(resultSet.getString("example"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return format;
	}

	@Override
	public Set<Object> getAll() {
		Set<Object> formats = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from grading_format";
			Statement stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while (resultSet.next()) {
				GradingFormat format = new GradingFormat();
				format.setFormatId(resultSet.getInt("format_id"));
				format.setName(resultSet.getString("format_name"));
				format.setExample(resultSet.getString("example"));
				formats.add(format);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formats;
	}

	@Override
	public GradingFormat getByName(String name) {
		GradingFormat format = new GradingFormat();
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from grading_format where format_name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			
			ResultSet resultSet = pStmt.executeQuery();
			
			while (resultSet.next()) {
				
				format.setFormatId(resultSet.getInt("format_id"));
				format.setName(resultSet.getString("format_name"));
				format.setExample(resultSet.getString("example"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return format;
	}

}
