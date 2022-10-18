package EmployeeDetails.SalarySlipDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpDetailsService 
{
	@Autowired
	EmpDetailsRepositary repo;
	
	public EmpDetails create(EmpDetails emp)
	{
		return repo.save(emp);
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
	
	//findallbysalary
	public List<EmpDetails> makereadSalary(double salary)
	{
		return repo.findAllByempSalary(salary);
	}
	//update salary by name
	public void makeupdate(String which)
	{
		repo.updateSalaryByname(which);
	}
	
	//findallbysalaryandname
	public List<EmpDetails> makeFetchBySalaryName(double sal,String name)
	{
		return repo.findAllByEmpnameAndSalary(sal, name);
	}
}
