package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Author;
import com.example.demo.model.entities.Quote;
import com.example.demo.model.repository.AuthorRepository;

@Service
public class QuoteMapper 
{	
	
	@Autowired
	AuthorRepository authRepo;
	
	public QuoteDTO toDTO(Quote quote)
	{
		return new QuoteDTO(quote);
	}
	
	public List<QuoteDTO> toDTO(List<Quote> quotes)
	{
		List<QuoteDTO> res = new ArrayList<>();
		
		for(Quote q : quotes)
			res.add(toDTO(q));
		
		return res;
	}
	
	public Quote fromDTO(QuoteDTO dto)
	{
		if(dto.getAuthorId() <= 0)
		{
			throw new RuntimeException("Incorrect Author id");
		}
		
		Optional<Author> optionalAuthor = authRepo.findById(dto.getAuthorId());
		
		if(optionalAuthor.isEmpty())
		{
			throw new RuntimeException("Author doesn't exist");
		}
		
		
		
		
		Quote res = new Quote();
		res.setId(dto.getId());
		res.setText(dto.getText());
		res.setScore(dto.getScore());
		res.setAuthor(optionalAuthor.get());
		
		return res;
	}
	
	public List<Quote> fromDTO(List<QuoteDTO> dtos)
	{
		List<Quote> res = new ArrayList<>();
		
		for(QuoteDTO q : dtos)
			res.add(fromDTO(q));
		
		return res;
	}
}
