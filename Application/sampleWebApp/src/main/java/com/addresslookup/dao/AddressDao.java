package com.addresslookup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addresslookup.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address,Long> {

}
