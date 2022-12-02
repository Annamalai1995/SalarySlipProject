package EmployeeDetails.SalarySlipDetails;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDetailsRepositary extends JpaRepository<EmpDetails, Integer>
{
	
	public EmpDetails findByUsername(String Username);
	//update `EmpDetails` set empsalary=empsalary+(empsalary*20/100) where empname
	@Transactional
	@Modifying
	@Query("update EmpDetails set empSalary=empSalary+(empSalary*10/100) where username=:emp")
	public void UpdatebySalary(String emp);
	
	@Query("from EmpDetails where empSalary>=:salary or empName=:name")
	public List<EmpDetails> gettingAnSalaryAndName(double salary,String name);
	

}
