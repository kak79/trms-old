package com.revature.data;

import java.util.Set;

import com.revature.models.GradingFormat;

public interface GradingFormatDAO {
	public GradingFormat getById(int id);
	public Set<Object> getAll();
	public GradingFormat getByName(String name);
}
