package com.revature.data;

import java.util.Set;

import com.revature.models.Status;

public interface StatusDAO {
	public Status getById(int id);
	public Set<Status> getAll();
	public Status getByName(String name);
}
