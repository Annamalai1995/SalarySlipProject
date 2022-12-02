package EmployeeDetails.SalarySlipDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.encoder.Encoder;
//localhost:8080/maddy/tty
@RestController
@RequestMapping("/maddy")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController
{
	@Autowired
	EmpDetailsService service;
	@Autowired
	PaySlipDetailsService Pserv;
	@Autowired
	PasswordEncoder encoder;

	@GetMapping("/{user}")
	public EmpDetails purpose(@PathVariable("user") String user){
		EmpDetails e=(EmpDetails) service.loadUserByUsername(user);
		return e;
	}
	
	@PostMapping("/newone")
	public String makecreate(@RequestBody EmpDetails emp)
	{
		String tmp=encoder.encode(emp.getPassword());
		emp.setPassword(tmp);
		return service.create(emp).getEmpName()+"employee has been added successfully in database.... ";	
	}
	
	@PutMapping("/update")
	public String  update(@RequestBody EmpDetails emp)
	{
		String tmp=encoder.encode(emp.getPassword());
		emp.setPassword(tmp);
		EmpDetails obj=service.create(emp);
		return obj.getEmpName()+"has been updated";
	}
	
	@DeleteMapping("/Delete/{user}")
	public String erasing(@PathVariable("user")String user)
	{
		EmpDetails e = purpose(user);
		Pserv.impleDeleteByCondition(e.getEmpId());
		return service.erasing(e.getEmpId());
	}
	
	@PostMapping ("/createpayslip/{user}")
	public PaySlipDetail callnewone(@PathVariable("user") String user, @RequestBody PaySlipDetail paydetails)
	{

			EmpDetails tmp = purpose(user);//service.GettingbyExactNumber(paydetails.getEmpDetails().getEmpId());
			double month = tmp.getEmpSalary() / 12;
			double basic = month - (month * (paydetails.getPayslipAllowance()) / 100);
			paydetails.setPayslipBasicSalary((int) basic);
			month = basic - (month * paydetails.getPaysilpTds() / 100);
			paydetails.setPayslipTakeHome(month);
			tmp.getMypayslip().add(paydetails);
			//service.create(tmp);
			paydetails.setEmpDetails(tmp);//
			Pserv.newoneps(paydetails);
		return paydetails;	
	}
	//updatingsalary
	
	@PutMapping("/updating/{value}")
	public String updatingansalary(@PathVariable("value")String value )
	{
		EmpDetails emp=purpose(value);
		if(emp.getEmpSalary()<=400000) {
			service.updatingSalary(value);
			return emp.getEmpName()+" got appraisal";
		}
		else{
			return emp.getEmpName()+" not eligible to get appraisal";
		}
	}
	
	@GetMapping("/checking/{one}/{two}")
	public List<EmpDetails> gettingTwo( @PathVariable("one")double one,@PathVariable("two")String name)
	{
		return service.fetchingAnSalaryName(one, name);
	}
	
	@GetMapping("/fetch/{user}")
	public List<PaySlipDetail> getByEmps(@PathVariable("user") String user)
	{

		//System.out.println(emp.getEmpName()+" "+emp.getEmpSalary());
		//System.out.println(Pserv.getbyEmpDetails(emp));
		return Pserv.getbyEmpDetails(purpose(user));
	}
	@GetMapping("/datem/{user}/{date1}/{date2}")
	public List<PaySlipDetail> gettingdatesAndEmp(@PathVariable("user") String user,@PathVariable("date1")String date1,@PathVariable("date2")String date2) throws ParseException
	{
		//Date dt1=new SimpleDateFormat("YYYY-MM-DD").parse(date1);
		//Date dt2=new SimpleDateFormat("YYYY-MM-DD").parse(date2);
		EmpDetails e=purpose(user);
		System.out.println(date1+" "+date2+" "+e.getEmpId());
		System.out.println(Pserv.impleDateAndEmp(e.getEmpId(),date1,date2).size());
		return Pserv.impleDateAndEmp(e.getEmpId(),date1,date2);
	}
	@GetMapping("/dating/{date1}/{date2}")
	public List<PaySlipDetail> gettingdates(@PathVariable("date1")String date1,@PathVariable("date2")String date2) throws ParseException
	{
		Date dt1=new SimpleDateFormat("YYYY-MM-DD").parse(date1);
		Date dt2=new SimpleDateFormat("YYYY-MM-DD").parse(date2);
		System.out.println(date1+" "+date2);
		return Pserv.getBetweenDates(dt1, dt2);
	}
}
