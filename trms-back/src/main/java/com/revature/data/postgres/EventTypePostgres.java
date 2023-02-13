package com.revature.data.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.data.EventTypeDAO;
import com.revature.models.EventType;
import com.revature.utils.ConnectionUtil;

public class EventTypePostgres implements EventTypeDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public EventType getById(int id) {
		EventType eventType = null;
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from event_type where type_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			
			ResultSet resultSet = pStmt.executeQuery();
			
			if (resultSet.next()) {
				eventType = new EventType();
				eventType.setEventId(id);
				eventType.setName(resultSet.getString("type_name"));
				eventType.setPercentCovered(resultSet.getDouble("percent_coverage"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventType;
	}

	@Override
	public Set<Object> getAll() {
		Set<Object> eventTypes = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from event_type";
			Statement stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery(sql);
			
			if (resultSet.next()) {
				EventType eventType = new EventType();
				eventType.setEventId(resultSet.getInt("type_id"));
				eventType.setName(resultSet.getString("type_name"));
				eventType.setPercentCovered(resultSet.getDouble("percent_coverage"));
				
				eventTypes.add(eventType);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventTypes;
	}

	@Override
	public EventType getByName(String name) {
		EventType eventType = new EventType();
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from event_type where type_name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			
			ResultSet resultSet = pStmt.executeQuery();
			
			if (resultSet.next()) {
				
				eventType.setEventId(resultSet.getInt("type_id"));
				eventType.setName(resultSet.getString("type_name"));
				eventType.setPercentCovered(resultSet.getDouble("percent_coverage"));
				
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventType;
	}

}
