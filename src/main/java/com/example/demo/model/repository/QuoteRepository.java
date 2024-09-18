package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entities.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer>
{

}
