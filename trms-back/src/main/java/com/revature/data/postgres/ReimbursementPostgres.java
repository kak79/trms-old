package com.revature.data.postgres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import com.revature.data.ReimbursementDAO;
import com.revature.data.StatusDAO;
import com.revature.models.Employee;
import com.revature.models.EventType;
import com.revature.models.GradingFormat;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.DAOFactory;

public class ReimbursementPostgres implements ReimbursementDAO {
	private StatusDAO sd = DAOFactory.getStatusDAO();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public int create(Reimbursement dataToAdd) {
		int generatedId=0;
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String[] keys = {"req_id"};
			String sql="insert into reimbursement"
					+ " (emp_id,"
					+ " event_date,"
					+ " event_time,"
					+ " location,"
					+ " description,"
					+ " cost,"
					+ " grading_format_id,"
					+ " event_type_id,"
					+ " status_id,"
					+ " submitted_at)"
					+ " values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql,keys);
			pStmt.setInt(1, dataToAdd.getRequestor().getEmpId());
			pStmt.setDate(2, Date.valueOf(dataToAdd.getEventDate()));
			pStmt.setTime(3, Time.valueOf(dataToAdd.getEventTime()));
			pStmt.setString(4, dataToAdd.getLocation());
			pStmt.setString(5, dataToAdd.getDescription());
			pStmt.setDouble(6, dataToAdd.getCost());
			pStmt.setInt(7, dataToAdd.getGradingFormat().getFormatId());
			pStmt.setInt(8, dataToAdd.getEventType().getEventId());
			pStmt.setInt(9, dataToAdd.getStatus().getStatusId());
			pStmt.setTimestamp(10, Timestamp.valueOf(dataToAdd.getSubmittedAt()));
			
			pStmt.executeUpdate();
			ResultSet generatedKeys = pStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				generatedId = generatedKeys.getInt(1);
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedId;
	}

	@Override
	public Reimbursement getById(int id) {
		Reimbursement request = new Reimbursement();
		try (Connection conn = connUtil.getConnection()) {
			String sql="select" + 
					" req_id," + 
					" emp_id," + 
					" event_date," + 
					" event_time," + 
					" location," + 
					" description," + 
					" cost," + 
					" grading_format_id," + 
					" format_name," + 
					" example as format_example," + 
					" event_type_id," + 
					" type_name," + 
					" percent_coverage," + 
					" r.status_id," + 
					" status_name," + 
					" approver," + 
					" submitted_at " + 
					" from reimbursement r" + 
					" join grading_format gf on r.grading_format_id=gf.format_id" + 
					" join event_type et on r.event_type_id=et.type_id" + 
					" join status s on r.status_id=s.status_id"
					+ " where req_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			
			ResultSet resultSet = pStmt.executeQuery();
			while (resultSet.next()) {
				int rId = resultSet.getInt("req_id");
				int eId = resultSet.getInt("emp_id");
				LocalDate ld = resultSet.getDate("event_date").toLocalDate();
				LocalTime lt = resultSet.getTime("event_time").toLocalTime();
				String loc = resultSet.getString("location");
				String desc = resultSet.getString("description");
				double cost = resultSet.getDouble("cost");
				int gfId = resultSet.getInt("grading_format_id");
				String fn = resultSet.getString("format_name");
				String fe = resultSet.getString("format_example");
				int etId = resultSet.getInt("event_type_id");
				String tn = resultSet.getString("type_name");
				double pCov = resultSet.getDouble("percent_coverage");
				int sId = resultSet.getInt("status_id");
				String sn = resultSet.getString("status_name");
				String approver = resultSet.getString("approver");
				LocalDateTime ldt = resultSet.getTimestamp("submitted_at").toLocalDateTime();
				
				request.setReqId(rId);
				request.getRequestor().setEmpId(eId);
				request.setEventDate(ld);
				request.setEventTime(lt);
				request.setLocation(loc);
				request.setDescription(desc);
				request.setCost(cost);
				GradingFormat gf = new GradingFormat();
				gf.setFormatId(gfId);
				gf.setName(fn);
				gf.setExample(fe);
				request.setGradingFormat(gf);
				EventType et = new EventType();
				et.setEventId(etId);
				et.setName(tn);
				et.setPercentCovered(pCov);
				request.setEventType(et);
				Status s = new Status();
				s.setStatusId(sId);
				s.setName(sn);
				s.setApprover(approver);
				request.setStatus(s);
				request.setSubmittedAt(ldt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return request;
	}

	@Override
	public Set<Reimbursement> getAll() {
		Set<Reimbursement> requests = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql="select" + 
					" req_id," + 
					" emp_id," + 
					" event_date," + 
					" event_time," + 
					" location," + 
					" description," + 
					" cost," + 
					" grading_format_id," + 
					" format_name," + 
					" example as format_example," + 
					" event_type_id," + 
					" type_name," + 
					" percent_coverage," + 
					" r.status_id," + 
					" status_name," + 
					" approver," + 
					" submitted_at " + 
					" from reimbursement r" + 
					" join grading_format gf on r.grading_format_id=gf.format_id" + 
					" join event_type et on r.event_type_id=et.type_id" + 
					" join status s on r.status_id=s.status_id";
			Statement stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				int rId = resultSet.getInt("req_id");
				int eId = resultSet.getInt("emp_id");
				LocalDate ld = resultSet.getDate("event_date").toLocalDate();
				LocalTime lt = resultSet.getTime("event_time").toLocalTime();
				String loc = resultSet.getString("location");
				String desc = resultSet.getString("description");
				double cost = resultSet.getDouble("cost");
				int gfId = resultSet.getInt("grading_format_id");
				String fn = resultSet.getString("format_name");
				String fe = resultSet.getString("format_example");
				int etId = resultSet.getInt("event_type_id");
				String tn = resultSet.getString("type_name");
				double pCov = resultSet.getDouble("percent_coverage");
				int sId = resultSet.getInt("status_id");
				String sn = resultSet.getString("status_name");
				String approver = resultSet.getString("approver");
				LocalDateTime ldt = resultSet.getTimestamp("submitted_at").toLocalDateTime();
			
				Reimbursement request = new Reimbursement();
				
				request.setReqId(rId);
				request.getRequestor().setEmpId(eId);
				request.setEventDate(ld);
				request.setEventTime(lt);
				request.setLocation(loc);
				request.setDescription(desc);
				request.setCost(cost);
				GradingFormat gf = new GradingFormat();
				gf.setFormatId(gfId);
				gf.setName(fn);
				gf.setExample(fe);
				request.setGradingFormat(gf);
				EventType et = new EventType();
				et.setEventId(etId);
				et.setName(tn);
				et.setPercentCovered(pCov);
				request.setEventType(et);
				Status s = new Status();
				s.setStatusId(sId);
				s.setName(sn);
				s.setApprover(approver);
				request.setStatus(s);
				request.setSubmittedAt(ldt);
		
				requests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return requests;
	}

	@Override
	public void update(Reimbursement dataToUpdate) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql="update reimbursement set"
					+ " emp_id=?,"
					+ " event_date=?,"
					+ " event_time=?,"
					+ " location=?,"
					+ " description=?,"
					+ " cost=?,"
					+ " grading_format_id=?,"
					+ " event_type_id=?,"
					+ " status_id=?,"
					+ " submitted_at=?"
					+ " where req_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, dataToUpdate.getRequestor().getEmpId());
			pStmt.setDate(2, Date.valueOf(dataToUpdate.getEventDate()));
			pStmt.setTime(3, Time.valueOf(dataToUpdate.getEventTime()));
			pStmt.setString(4, dataToUpdate.getLocation());
			pStmt.setString(5, dataToUpdate.getDescription());
			pStmt.setDouble(6, dataToUpdate.getCost());
			pStmt.setInt(7, dataToUpdate.getGradingFormat().getFormatId());
			pStmt.setInt(8, dataToUpdate.getEventType().getEventId());
			pStmt.setInt(9, dataToUpdate.getStatus().getStatusId());
			pStmt.setTimestamp(10, Timestamp.valueOf(dataToUpdate.getSubmittedAt()));
			pStmt.setInt(10, dataToUpdate.getReqId());
			
			int rowsAffected = pStmt.executeUpdate();
			if (rowsAffected <= 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Reimbursement dataToDelete) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql="delete from reimbursement"
					+ " where req_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, dataToDelete.getReqId());
			
			int rowsAffected = pStmt.executeUpdate();
			if (rowsAffected <= 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Reimbursement> getByRequestor(Employee requestor) {
		Set<Reimbursement> requests = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql="select" + 
					" req_id," + 
					" emp_id," + 
					" event_date," + 
					" event_time," + 
					" location," + 
					" description," + 
					" cost," + 
					" grading_format_id," + 
					" format_name," + 
					" example as format_example," + 
					" event_type_id," + 
					" type_name," + 
					" percent_coverage," + 
					" r.status_id," + 
					" status_name," + 
					" approver," + 
					" submitted_at " + 
					" from reimbursement r" + 
					" join grading_format gf on r.grading_format_id=gf.format_id" + 
					" join event_type et on r.event_type_id=et.type_id" + 
					" join status s on r.status_id=s.status_id"
					+ " where emp_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, requestor.getEmpId());
			
			ResultSet resultSet = pStmt.executeQuery();
			while (resultSet.next()) {

				int rId = resultSet.getInt("req_id");
				int eId = resultSet.getInt("emp_id");
				LocalDate ld = resultSet.getDate("event_date").toLocalDate();
				LocalTime lt = resultSet.getTime("event_time").toLocalTime();
				String loc = resultSet.getString("location");
				String desc = resultSet.getString("description");
				double cost = resultSet.getDouble("cost");
				int gfId = resultSet.getInt("grading_format_id");
				String fn = resultSet.getString("format_name");
				String fe = resultSet.getString("format_example");
				int etId = resultSet.getInt("event_type_id");
				String tn = resultSet.getString("type_name");
				double pCov = resultSet.getDouble("percent_coverage");
				int sId = resultSet.getInt("status_id");
				String sn = resultSet.getString("status_name");
				String approver = resultSet.getString("approver");
				LocalDateTime ldt = resultSet.getTimestamp("submitted_at").toLocalDateTime();
			
				Reimbursement request = new Reimbursement();
				
				request.setReqId(rId);
				request.getRequestor().setEmpId(eId);
				request.setEventDate(ld);
				request.setEventTime(lt);
				request.setLocation(loc);
				request.setDescription(desc);
				request.setCost(cost);
				GradingFormat gf = new GradingFormat();
				gf.setFormatId(gfId);
				gf.setName(fn);
				gf.setExample(fe);
				request.setGradingFormat(gf);
				EventType et = new EventType();
				et.setEventId(etId);
				et.setName(tn);
				et.setPercentCovered(pCov);
				request.setEventType(et);
				Status s = new Status();
				s.setStatusId(sId);
				s.setName(sn);
				s.setApprover(approver);
				request.setStatus(s);
				request.setSubmittedAt(ldt);
		
				requests.add(request);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return requests;
		}

	@Override
	public Set<Reimbursement> getByStatus(Status status) {
		Set<Reimbursement> requests = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql="select" + 
					" req_id," + 
					" emp_id," + 
					" event_date," + 
					" event_time," + 
					" location," + 
					" description," + 
					" cost," + 
					" grading_format_id," + 
					" format_name," + 
					" example as format_example," + 
					" event_type_id," + 
					" type_name," + 
					" percent_coverage," + 
					" r.status_id," + 
					" status_name," + 
					" approver," + 
					" submitted_at " + 
					" from reimbursement r" + 
					" join grading_format gf on r.grading_format_id=gf.format_id" + 
					" join event_type et on r.event_type_id=et.type_id" + 
					" join status s on r.status_id=s.status_id"
					+ " where r.status_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, status.getStatusId());
			
			ResultSet resultSet = pStmt.executeQuery();
			while (resultSet.next()) {
				Reimbursement request = new Reimbursement();
				request.setReqId(resultSet.getInt("req_id"));
				request.getRequestor().setEmpId(resultSet.getInt("emp_id"));
				request.setEventDate(resultSet.getDate("event_date").toLocalDate());
				request.setEventTime(resultSet.getTime("event_time").toLocalTime());
				request.setLocation(resultSet.getString("location"));
				request.setDescription(resultSet.getString("description"));
				request.setCost(resultSet.getDouble("cost"));
				GradingFormat gf = new GradingFormat();
				gf.setFormatId(resultSet.getInt("grading_format_id"));
				gf.setName(resultSet.getString("format_name"));
				gf.setExample(resultSet.getString("format_example"));
				request.setGradingFormat(gf);
				EventType et = new EventType();
				et.setEventId(resultSet.getInt("event_type_id"));
				et.setName(resultSet.getString("type_name"));
				et.setPercentCovered(resultSet.getDouble("percent_coverage"));
				request.setEventType(et);
				Status s = new Status();
				s.setStatusId(resultSet.getInt("status_id"));
				s.setName(resultSet.getString("status_name"));
				s.setApprover(resultSet.getString("approver"));
				request.setStatus(s);
				request.setSubmittedAt(resultSet.getTimestamp("submitted_at").toLocalDateTime());
				
				requests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return requests;
	}

	@Override
	public Set<Reimbursement> getPendByApprover(Employee approver, int s) {
		Set<Reimbursement> pendReqs = new HashSet<>();
		if (s==1) {
			pendReqs = getStatusId(s);
		}else if (s==4) {
			pendReqs = getStatusId(s);
		}else if (s==7) {
			pendReqs = getStatusId(s);
		}

		Set<Reimbursement> approverReqs = new HashSet<>();
		pendReqs.forEach(req -> {
			if(approver.getEmpId() == req.getRequestor().getSupervisor().getEmpId()) {
				approverReqs.add(req);
			}
		});
		return pendReqs;
	}
	
	private Set<Reimbursement> getStatusId(int s){
		Status s1 = sd.getById(s);
		Set<Reimbursement> pendReqs = this.getByStatus(s1);
		return pendReqs;
	}

}
