package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Author;

@Service
public class AuthorMapper 
{
	@Autowired
	QuoteMapper quoteMapper;
	
	public AuthorDTO toDTO(Author author)
	{
		return new AuthorDTO(author, quoteMapper);
	}
	
	public List<AuthorDTO> toDTO(List<Author> authors)
	{
		List<AuthorDTO> res = new ArrayList<AuthorDTO>();
	
	for(Author a : authors)
		res.add(toDTO(a));
	
	return res;
	}
	
	public Author fromDTO(AuthorDTO dto)
	{
		Author res = new Author();
		
		res.setId(dto.getId());
		res.setName(dto.getName());
		res.setDate(dto.getDate());
		res.setQuotes(quoteMapper.fromDTO(dto.getQuotes()));
		
		return res;
	}
	
	public List<Author> fromDTO(List<AuthorDTO> dtos)
	{
		List<Author> res = new ArrayList<>();
		
		for(AuthorDTO a : dtos)
			res.add(fromDTO(a));
		
		return res;
	}
}
