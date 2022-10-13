package EmployeeDetails.SalarySlipDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDetailsRepositary extends JpaRepository<EmpDetails, Integer>
{


}
