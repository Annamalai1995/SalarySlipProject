package EmployeeDetails.SalarySlipDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaySlipDetails 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payslipId;
	private int payslipBasicSalary;
	private double paysilpHRA;
	private double payslipDRA;
	private double payslipTDS;
	private double payslipTakeHome;
	

}
