package com.revature.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Comment {
	private int commentId;
	private Reimbursement request;
	private Employee approver;
	private String commentText;
	private String sentDate;
	private String sentTime;
	
	public Comment() {
		super();
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Reimbursement getRequest() {
		return request;
	}

	public void setRequest(Reimbursement request) {
		this.request = request;
	}

	public Employee getApprover() {
		return approver;
	}

	public void setApprover(Employee approver) {
		this.approver = approver;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public LocalDate getSentDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(sentDate,formatter);
		return ld;
	}

	public void setSentDate(LocalDate sentDate) {
		this.sentDate = String.valueOf(sentDate);
	}

	public LocalTime getSentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime lt = LocalTime.parse(sentTime,formatter);
		return lt;
	}

	public void setSentTime(LocalTime sentTime) {
		this.sentTime = String.valueOf(sentTime);
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", request=" + request + ", approver=" + approver + ", commentText="
				+ commentText + ", sentDate=" + sentDate + ", sentTime=" + sentTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(approver, commentId, commentText, request, sentDate, sentTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(approver, other.approver) && commentId == other.commentId
				&& Objects.equals(commentText, other.commentText) && Objects.equals(request, other.request)
				&& Objects.equals(sentDate, other.sentDate) && Objects.equals(sentTime, other.sentTime);
	}


	
	
	
	
}	