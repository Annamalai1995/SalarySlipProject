package EmployeeDetails.SalarySlipDetails;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaySlipDetailsRepositary extends JpaRepository<PaySlipDetail, Integer>
{

	// findAll	>> multiple
				// findAllByDot	>> multiple data by dot
				// 
				// findBy	>> single
				// findById	>> single data by primary key
				// findByAmount	>> single data by amount
	
			@Query(" select  where date=:dt1 between date=:dt2 ")
			public List<PaySlipDetail> findAllByDates(Date dt1,Date dt2);
			
			
			public List<PaySlipDetail> findAllByEmpDetails(EmpDetails emp);

}