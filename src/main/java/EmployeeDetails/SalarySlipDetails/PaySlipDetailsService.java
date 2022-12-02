package EmployeeDetails.SalarySlipDetails;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaySlipDetailsService {
	@Autowired
	PaySlipDetailsRepositary prepo;

	public void impleDeleteByCondition(int id){
		prepo.deleteByEmpId(id);
	}

	public List<PaySlipDetail> impleDateAndEmp(int emp,String d1, String d2){
		return prepo.findAllByDateRanges(emp,d1,d2);
	}
	
	public PaySlipDetail newoneps(PaySlipDetail pay)
	{
		return prepo.save(pay);
	}
	
	public List<PaySlipDetail> getbyEmpDetails(EmpDetails emp)
	{
		return prepo.findAllByEmpDetails(emp);
	}
//	
//	public List<PaySlipDetail> makeReadByDate(Date dd)
//	{
//		return prepo.findAllByDate(dd);
//	}
	 public List<PaySlipDetail> getBetweenDates(Date date1,Date date2)
	 {
		 return prepo.findAllByDateBetween(date1, date2);
	 }

}
