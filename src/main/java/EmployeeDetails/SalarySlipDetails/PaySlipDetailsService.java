package EmployeeDetails.SalarySlipDetails;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaySlipDetailsService 
{
	@Autowired
	PaySlipDetailsRepositary prepo;
	
	public PaySlipDetail newoneps(PaySlipDetail pay)
	{
		return prepo.save(pay);
	}
	public List<PaySlipDetail> getbyEmpDetails(EmpDetails emp)
	{
		return prepo.findAllByEmpDetails(emp);
	}
	
	public List<PaySlipDetail> getbybetweendates(Date dt1,Date dt2)
	{
		return prepo.findAllByDates(dt1, dt2);
	}
	
}
