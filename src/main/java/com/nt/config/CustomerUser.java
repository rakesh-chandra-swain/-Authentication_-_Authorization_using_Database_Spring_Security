package com.nt.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nt.entity.Employee;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class CustomerUser implements UserDetails {
	
	private Employee emp;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(emp.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		
		return emp.getPassword();
	}

	@Override
	public String getUsername() {
		
		return emp.getEmail();
	}

}
