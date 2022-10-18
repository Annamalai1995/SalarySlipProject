package EmployeeDetails.SalarySlipDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpDetailsService 
{
	@Autowired
	EmpDetailsRepositary repo;
	
	public EmpDetails create(EmpDetails empdetails)
	{
		return repo.save(empdetails);
	}
	
	public String erasing(int id)
	{
		EmpDetails emp=repo.findById(id).orElse(new EmpDetails() );
		String tmp=emp.getEmpName()+"Has deleted Successfully";
		repo.delete(emp);
		return tmp;
	}
	public EmpDetails GettingbyExactNumber(int idnum)
	{
		return repo.findById(idnum).orElse(new EmpDetails());
	}
	//updatedbysalary
	public void updatingSalary(String value)
	{
		repo.UpdatebySalary(value);
	}
	//geetingansalaryand name
	public List<EmpDetails> fetchingAnSalaryName(double salary1,String name1)
	{
		return repo.gettingAnSalaryAndName(salary1, name1);
	}
}