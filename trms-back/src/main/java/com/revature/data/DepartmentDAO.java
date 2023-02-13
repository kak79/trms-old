package com.revature.data;

import java.util.Set;

import com.revature.models.Department;

public interface DepartmentDAO {
	public Department getById(int id);
	public Set<Department> getAll();
	public Department getByName(String name);
}
