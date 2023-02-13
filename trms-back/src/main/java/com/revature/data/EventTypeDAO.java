package com.revature.data;

import java.util.Set;

import com.revature.models.EventType;

public interface EventTypeDAO {
	public EventType getById(int id);
	public Set<Object> getAll();
	public EventType getByName(String name);
}
