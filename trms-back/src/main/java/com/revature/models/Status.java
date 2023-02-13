package com.revature.models;

import java.util.Objects;

public class Status {
	private int statusId;
	private String statusName;
	private String approver;
	
	public Status() {
		super();
	}
	
	

	public Status(int statusId, String statusName, String approver) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
		this.approver = approver;
	}



	public int getStatusId() {
		return statusId;
	}



	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}



	public String getStatusName() {
		return statusName;
	}



	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}



	public String getApprover() {
		return approver;
	}



	public void setApprover(String approver) {
		this.approver = approver;
	}



	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName + ", approver=" + approver + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(approver, statusId, statusName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		return Objects.equals(approver, other.approver) && statusId == other.statusId
				&& Objects.equals(statusName, other.statusName);
	}



	

	
	
	
}
