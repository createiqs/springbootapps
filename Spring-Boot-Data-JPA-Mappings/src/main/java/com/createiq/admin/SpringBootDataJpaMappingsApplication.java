package com.createiq.admin;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.createiq.admin.entity.Role;
import com.createiq.admin.entity.User;
import com.createiq.admin.repo.AddressRepository;
import com.createiq.admin.repo.DepartmentRepository;
import com.createiq.admin.repo.EmployeeRepository;
import com.createiq.admin.repo.RoleRepository;
import com.createiq.admin.repo.UserRepository;

@SpringBootApplication

public class SpringBootDataJpaMappingsApplication implements CommandLineRunner {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaMappingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Address a1 = new Address();
		// a1.setCity("SKLM");
		// a1.setState("AP");
		//
		//
		//
		// Address a2 = new Address();
		// a2.setCity("HYD");
		// a2.setState("TG");
		//
		// addressRepository.save(a1);
		// addressRepository.save(a2);
		//
		// Employee employee1 = new Employee();
		// employee1.setEname("Balaji");
		// employee1.setEsal(20000.00);
		// employee1.setAddress(a1);
		//
		// Employee employee2 = new Employee();
		// employee2.setEname("Raja");
		// employee2.setEsal(30000.00);
		// employee2.setAddress(a2);
		//
		// employeeRepository.save(employee1);
		// employeeRepository.save(employee2);
		//
		// List<Employee> employees = Arrays.asList(new Employee[] { employee1,
		// employee2 });
		//
		// Department department = new Department();
		// department.setDname("IT");
		// department.setEmployees(employees);
		//
		// departmentRepository.save(department);
		// System.out.println("Done....");

		Role r1 = new Role();
		r1.setRname("ROLE_ADMIN");
		Role r2 = new Role();
		r2.setRname("ROLE_USER");

		List<Role> roles = Arrays.asList(new Role[] { r1, r2 });

		
		
		User u1 = new User();
		u1.setUname("Balaji");
		
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		
		User u2 = new User();
		u2.setUname("Raja");
		
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);
		
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		
		userRepository.save(u1);
		userRepository.save(u2);

	}

}
