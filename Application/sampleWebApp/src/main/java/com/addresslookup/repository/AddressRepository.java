package com.addresslookup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addresslookup.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
