package EmployeeDetails.SalarySlipDetails;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;

@Repository
public interface PaySlipDetailsRepositary extends JpaRepository<PaySlipDetail, Integer>
{
	// findAll	>> multiple
			// findAllByDot	>> multiple data by dot
			// 
			// findBy	>> single
			// findById	>> single data by primary key
			// findByAmount	>> single data by amount
		
		//public List<PaySlipDetail> findAllByDate(Date dd);
	
		@Query("from PaySlipDetail where date between :date1 and :date2")
		public List<PaySlipDetail> findAllByDateBetween(Date date1,Date date2);

		//@Query("from PaySlipDetail where empDetails=:emp and date between :d1 and :d2")
		@Query(value = "select * from pay_slip_detail where emp_id=?1 and date between ?2 and ?3",nativeQuery = true)
		public List<PaySlipDetail> findAllByDateRanges(int emp,String d1,String d2);
		//public List<PaySlipDetail> findAllByDateRanges(@Param("emp") int emp, @Param("d1") String d1,@Param("d2") String d2);

		@Transactional
		@Modifying
		@Query(value="delete from pay_slip_detail where emp_id=?1",nativeQuery = true)
		public void deleteByEmpId(int id);
		
		public List<PaySlipDetail> findAllByEmpDetails(EmpDetails emp);
 
}
