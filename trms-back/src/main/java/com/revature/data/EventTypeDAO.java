package com.revature.data;

import java.util.Set;

import com.revature.beans.EventType;

public interface EventTypeDAO {
	public EventType getById(int id);
	public Set<EventType> getAll();
	public EventType getByName(String name);
}
