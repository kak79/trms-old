package com.revature.data;

import java.util.Set;

import com.revature.beans.GradingFormat;

public interface GradingFormatDAO {
	public GradingFormat getById(int id);
	public Set<GradingFormat> getAll();
	public GradingFormat getByName(String name);
}
