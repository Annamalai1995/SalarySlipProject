package EmployeeDetails.SalarySlipDetails;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDetailsRepositary extends CrudRepository<EmpDetails, Integer>
{
	public List<EmpDetails> findAllByempSalary(double salary);
	
	
	@Transactional
	@Modifying
	@Query("update from EmpDetails set empSalary=empSalary+(empSalary*20/100) where empName=:ene")
	public void updateSalaryByname(String ene);
	
	@Query("from EmpDetails where empSalary>=:salary and empName=:emp")
	public List<EmpDetails> findAllByEmpnameAndSalary(double salary,String emp);
	
}
