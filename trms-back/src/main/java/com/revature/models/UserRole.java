package com.revature.models;

import java.util.Objects;

public class UserRole {
	private int roleId;
	private String roleName;
	
	public UserRole() {
		super();
	}
	
	public UserRole(int roleId) {
		super();
		this.roleId = roleId;
	}

	public UserRole(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return roleId == other.roleId && Objects.equals(roleName, other.roleName);
	}


	

	
	


	
}
