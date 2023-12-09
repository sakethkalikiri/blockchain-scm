package com.chaintrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaintrack.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
