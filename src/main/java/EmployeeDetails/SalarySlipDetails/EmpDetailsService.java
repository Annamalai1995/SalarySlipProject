package EmployeeDetails.SalarySlipDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmpDetailsService implements UserDetailsService
{
	@Autowired
	EmpDetailsRepositary repo;
	
	public EmpDetails create(EmpDetails empdetails)
	{
		return repo.save(empdetails);
	}
	
	public String erasing(int id)
	{
		EmpDetails emp=repo.findById(id).orElse(new EmpDetails());
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
	
	public List<EmpDetails> list()
	{
		return repo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		EmpDetails emp=repo.findByUsername(username);
		
		if(emp==null)
		{
			throw new UsernameNotFoundException(username);
		}
		
		
		return emp;
	}
}