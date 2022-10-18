package EmployeeDetails.SalarySlipDetails;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaySlipDetail 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payslipId;
	@Temporal(TemporalType.DATE)
	private java.util.Date date;
	private int payslipBasicSalary;
	private int payslipAllowance;
	private double payslipTDS;
	private double payslipTakeHome;
	@ManyToOne
	@JoinColumn(name="EmpId")
	@Nullable
	private EmpDetails empDetails;
	
	

}
