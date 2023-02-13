package com.revature.models;

import java.util.Objects;

public class GradingFormat {
	private int formatId;
	private String formatName;
	private String example;
	
	public GradingFormat() {
		super();
	}

	public GradingFormat(int formatId, String name, String example) {
		super();
		this.formatId = formatId;
		this.formatName = name;
		this.example = example;
	}



	public int getFormatId() {
		return formatId;
	}

	public void setFormatId(int formatId) {
		this.formatId = formatId;
	}

	public String getName() {
		return formatName;
	}

	public void setName(String name) {
		this.formatName = name;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	@Override
	public int hashCode() {
		return Objects.hash(example, formatId, formatName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradingFormat other = (GradingFormat) obj;
		return Objects.equals(example, other.example) && formatId == other.formatId && Objects.equals(formatName, other.formatName);
	}

	@Override
	public String toString() {
		return "GradingFormat [formatId=" + formatId + ", formatName=" + formatName + ", example=" + example + "]";
	}
}
