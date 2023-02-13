package com.revature.models;

import java.util.Objects;

public class EmployeeRole {

	private Employee empId;
	private UserRole roleId;
	private Employee supervisor_id;
	private Department dept_id;
	
	EmployeeRole() {
		super();
	}

	public Employee getEmpId() {
		return empId;
	}

	public void setEmpId(Employee empId) {
		this.empId = empId;
	}

	public UserRole getRoleId() {
		return roleId;
	}

	public void setRoleId(UserRole roleId) {
		this.roleId = roleId;
	}

	public Employee getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(Employee supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public Department getDept_id() {
		return dept_id;
	}

	public void setDept_id(Department dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "EmployeeRole [empId=" + empId + ", roleId=" + roleId + ", supervisor_id=" + supervisor_id + ", dept_id="
				+ dept_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept_id, empId, roleId, supervisor_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRole other = (EmployeeRole) obj;
		return Objects.equals(dept_id, other.dept_id) && Objects.equals(empId, other.empId)
				&& Objects.equals(roleId, other.roleId) && Objects.equals(supervisor_id, other.supervisor_id);
	}
	
	
	
	
	
	
	
}
