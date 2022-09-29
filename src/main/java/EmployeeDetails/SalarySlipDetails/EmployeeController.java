package EmployeeDetails.SalarySlipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmpDetailsService service;
	
	@PostMapping("/newone")
	public String makecreate(@RequestBody EmpDetails emp)
	{
		return service.create(emp).getClass()+" this accountholder has been added";
	}

}
