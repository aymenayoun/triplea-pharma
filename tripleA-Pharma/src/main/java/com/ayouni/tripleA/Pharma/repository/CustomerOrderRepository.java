package com.ayouni.tripleA.Pharma.repository;

import com.ayouni.tripleA.Pharma.entity.CustomerOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
