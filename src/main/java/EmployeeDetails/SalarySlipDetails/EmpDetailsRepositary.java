package EmployeeDetails.SalarySlipDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDetailsRepositary extends CrudRepository<EmpDetails, Integer>
{
	

}
