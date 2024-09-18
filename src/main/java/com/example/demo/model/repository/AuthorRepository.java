package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>
{

}
