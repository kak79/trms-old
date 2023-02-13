package com.revature.models;

import java.util.Objects;

public class EventType {
	private int typeId;
	private String typeName;
	private double percentCoverage;
	
	public EventType() {
		super();
	}
	
	public EventType(int eventId, String name, double percentCovered) {
		super();
		this.typeId = eventId;
		this.typeName = name;
		this.percentCoverage = percentCovered;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getPercentCoverage() {
		return percentCoverage;
	}

	public void setPercentCoverage(double percentCoverage) {
		this.percentCoverage = percentCoverage;
	}

	@Override
	public String toString() {
		return "EventType [typeId=" + typeId + ", typeName=" + typeName + ", percentCoverage=" + percentCoverage + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(percentCoverage, typeId, typeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventType other = (EventType) obj;
		return Double.doubleToLongBits(percentCoverage) == Double.doubleToLongBits(other.percentCoverage)
				&& typeId == other.typeId && Objects.equals(typeName, other.typeName);
	}




	
	
	
}
