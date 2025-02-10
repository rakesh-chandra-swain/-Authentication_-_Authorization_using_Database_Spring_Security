package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Component
public class CustomerUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	Employee emp=repo.findByEmail(email);
		
		if(emp==null) {
			throw new UsernameNotFoundException("user name not found");
		}
		else {
			return new CustomerUser(emp);
		}
		
	}

}
