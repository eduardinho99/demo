package com.example.demo.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.entities.Author;

public class AuthorDTO 
{
	
	
	private int id;
	private String name;
	private LocalDate date;
	List<QuoteDTO> quotes = new ArrayList<>();
	
	
	public AuthorDTO(Author author, QuoteMapper quoteMapper)
	{
		super();
		this.id = author.getId();
		this.name = author.getName();
		this.date = author.getDate();
		this.quotes = quoteMapper.toDTO(author.getQuotes());
	}
	
	public AuthorDTO() {};


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public List<QuoteDTO> getQuotes() {
		return quotes;
	}


	public void setQuotes(List<QuoteDTO> quotes) {
		this.quotes = quotes;
	}
	
	
	
	
	
}
