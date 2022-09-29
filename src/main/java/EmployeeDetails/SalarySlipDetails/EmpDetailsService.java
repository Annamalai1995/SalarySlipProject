package EmployeeDetails.SalarySlipDetails;

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

}
