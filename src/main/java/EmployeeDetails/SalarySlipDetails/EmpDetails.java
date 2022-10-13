package EmployeeDetails.SalarySlipDetails;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter setter,tostring
@NoArgsConstructor//super class
@AllArgsConstructor
@Entity
public class EmpDetails 
{
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String username;
	private String password;
	private String empDesignation;
	private int empExp;
	private double empSalary;
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="AllRecords",joinColumns = @JoinColumn(name="EmployeeId"),inverseJoinColumns = @JoinColumn(name="payslipId"))
	@Nullable
	private Collection<PaySlipDetail> mypayslip=new ArrayList<PaySlipDetail>();
	//collection<> obj=new Arraylist<>();
	

}
