package EmployeeDetails.SalarySlipDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter setter,tostring
@NoArgsConstructor//super class
@Entity
public class EmpDetails 
{
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String empPassword;
	private String empDesignation;
	private int empExp;
	private double empSalary;

}
