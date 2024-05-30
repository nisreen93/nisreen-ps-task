package com.demo.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Deal;

@Repository("dealDao")
public interface DealDao extends JpaRepository<Deal, UUID> {

}
