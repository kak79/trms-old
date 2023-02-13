package com.revature.models;

import java.util.Objects;

public class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private double funds;
	
	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", funds=" + funds + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, firstName, funds, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(firstName, other.firstName)
				&& Double.doubleToLongBits(funds) == Double.doubleToLongBits(other.funds)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	

	
	
	
}
