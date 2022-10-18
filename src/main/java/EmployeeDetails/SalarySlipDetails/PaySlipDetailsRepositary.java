package EmployeeDetails.SalarySlipDetails;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
		
		public List<PaySlipDetail> findAllByDate(Date dd);
		

}
