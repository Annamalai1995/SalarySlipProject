package EmployeeDetails.SalarySlipDetails;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmpDetailsService service;
	
	@Autowired
	PaySlipDetailsService Pserv;
	
	@PostMapping("/newone")
	public String makecreate(@RequestBody EmpDetails emp)
	{
		return service.create(emp).getEmpName()+" employee has been added";
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
		EmpDetails temp=service.GettingbyExactNumber(paydetails.getEmpDetails().getEmpId());
		double month=temp.getEmpSalary()/12;
		double basic=month-(month*(paydetails.getPayslipAllowance())/100);
		paydetails.setPayslipBasicSalary((int)basic);
		month=basic-paydetails.getPayslipTDS()/100;
		paydetails.setPayslipTakeHome(month);
		temp.getMypayslip().add(paydetails);
		Pserv.newoneps(paydetails);
		service.create(temp);
		return paydetails;
	}
//	@GetMapping("/getall/{accnum}")
//	public List<Transaction> callAllByAcc(@PathVariable("accnum") long accnum)
//	{
//		Account t=aserv.gettingByNumberExact(accnum);
//		return tserv.getByAccount(t);
//	}
	
	@GetMapping("getAll/{empid}")
	public List<PaySlipDetail> callAllbyAcc(@PathVariable("empid")int empid)
	{
		EmpDetails emp=service.GettingbyExactNumber(empid);
		return Pserv.getbyEmpDetails(emp);
	}
	
	@GetMapping("bysalary/{salary}")
	public List<EmpDetails> callingReadSalary(@PathVariable("salary")double salary)
	{
		return service.makereadSalary(salary);
	}
	@PutMapping("/upd/{name}")
	public void callingupdatesalary(@PathVariable("name")String name)
	{
		service.makeupdate(name);
	}
	
	@GetMapping("/bytwo/{one}/{two}")
	public List<EmpDetails> callingFetchTwo(@PathVariable("one")double one,@PathVariable("two")String two)
	{
		return service.makeFetchBySalaryName(one, two);
	}
	
	@GetMapping("/bydates/{dt1}/{dt2}")
	public List<PaySlipDetail> FetchingDates(@PathVariable("dt1")Date dt1,@PathVariable("dt2")Date dt2)
	{
		return Pserv.getbybetweendates(dt1, dt2);
	}
}
