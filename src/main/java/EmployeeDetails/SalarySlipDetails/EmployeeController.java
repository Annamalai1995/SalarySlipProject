package EmployeeDetails.SalarySlipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
	@Autowired
	EmpDetailsService service;
	@Autowired
	PaySlipDetailsService Pserv;
	
	@PostMapping("/newone")
	public String makecreate(@RequestBody EmpDetails emp)
	{
		return service.create(emp).getEmpName()+"employee has been added successfully in database.... ";
				
	}
	
	@PutMapping("/update")
	public String  update(@RequestBody EmpDetails emp)
	{
		EmpDetails obj=service.create(emp);
		return obj.getEmpName()+"has been updated";
	}
	
	@DeleteMapping("/Delete/{key}")
	public String erasing(@PathVariable("key")int key)
	{
		return service.erasing(key);
	}
	
	@PostMapping ("/createpayslip")
	public PaySlipDetail callnewone(@RequestBody PaySlipDetail paydetails)
	{
		EmpDetails tmp=service.GettingbyExactNumber(paydetails.getEmpDetails().getEmpId());
		double month=tmp.getEmpSalary()/12;
		double basic=month-(month*(paydetails.getPayslipAllowance())/100);
		paydetails.setPayslipBasicSalary((int)basic);
		month=basic-paydetails.getPaysilpTds()/100;
		paydetails.setPayslipTakeHome(month);
		tmp.getMypayslip().add(paydetails);
		Pserv.newoneps(paydetails);
		service.create(tmp);
		return paydetails;	
	}

	
	
}
