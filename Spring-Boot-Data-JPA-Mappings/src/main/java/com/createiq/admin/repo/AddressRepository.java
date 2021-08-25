package com.createiq.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.admin.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
