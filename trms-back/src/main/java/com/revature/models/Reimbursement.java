package com.revature.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reimbursement {
	private int reqId;
	private Employee requestor;
	private String eventDate;
	private String eventTime;
	private String location;
	private String description;
	private double cost;
	private GradingFormat gradingFormat;
	private EventType eventType;
	private Status status;
	private String submittedDate;
	private String submittedTime;
	
	
	public Reimbursement() {
		super();
	}
	
	


	public Reimbursement(int reqId) {
		super();
		this.reqId = reqId;
	}


	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public Employee getRequestor() {
		return requestor;
	}

	public void setRequestor(Employee requestor) {
		this.requestor = requestor;
	}

	public LocalDate getEventDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localEventDate = LocalDate.parse(eventDate,formatter);
		return localEventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = String.valueOf(eventDate);
	}

	public LocalTime getEventTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localEventTime = LocalTime.parse(eventTime,formatter);
		return localEventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = String.valueOf(eventTime);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public GradingFormat getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(GradingFormat gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getSubmittedDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localSubmittedDate = LocalDate.parse(submittedDate,formatter);
		return localSubmittedDate;
	}

	public void setSubmittedDate(LocalDate eventDate) {
		this.submittedDate = String.valueOf(submittedDate);
	}

	public LocalTime getSubmittedTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localSubmittedTime = LocalTime.parse(submittedTime,formatter);
		return localSubmittedTime;
	}

	public void setSubmittedTime(LocalTime eventTime) {
		this.submittedDate = String.valueOf(submittedTime);
	}




	@Override
	public String toString() {
		return "Reimbursement [reqId=" + reqId + ", requestor=" + requestor + ", eventDate=" + eventDate
				+ ", eventTime=" + eventTime + ", location=" + location + ", description=" + description + ", cost="
				+ cost + ", gradingFormat=" + gradingFormat + ", eventType=" + eventType + ", status=" + status
				+ ", submittedDate=" + submittedDate + ", submittedTime=" + submittedTime + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(cost, description, eventDate, eventTime, eventType, gradingFormat, location, reqId,
				requestor, status, submittedDate, submittedTime);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(description, other.description) && Objects.equals(eventDate, other.eventDate)
				&& Objects.equals(eventTime, other.eventTime) && Objects.equals(eventType, other.eventType)
				&& Objects.equals(gradingFormat, other.gradingFormat) && Objects.equals(location, other.location)
				&& reqId == other.reqId && Objects.equals(requestor, other.requestor)
				&& Objects.equals(status, other.status) && Objects.equals(submittedDate, other.submittedDate)
				&& Objects.equals(submittedTime, other.submittedTime);
	}

	

	
	
	
	
	
}
