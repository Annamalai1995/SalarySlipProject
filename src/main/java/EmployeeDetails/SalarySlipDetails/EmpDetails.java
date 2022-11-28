package EmployeeDetails.SalarySlipDetails;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter setter,destroying
@NoArgsConstructor//super class
@AllArgsConstructor
@Entity
public class EmpDetails implements UserDetails
{
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	//@Column(unique = true)
	private String username;
	private String password;
	private String empDesignation;
	private int empExp;
	private double empSalary;
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="AllRecords",joinColumns = @JoinColumn(name="EmployeeId"),inverseJoinColumns = @JoinColumn(name="payslipId"))
	@Nullable
	@JsonBackReference
	private Collection<PaySlipDetail> mypayslip=new ArrayList<PaySlipDetail>();
	//collection<> obj=new Arraylist<>();
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getUsername()
	{
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
