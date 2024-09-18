package com.example.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.AuthorDTO;
import com.example.demo.model.dto.AuthorMapper;
import com.example.demo.model.entities.Author;
import com.example.demo.model.repository.AuthorRepository;

@RestController
@RequestMapping("/demo/api/authors")
public class AuthorAPI 
{
	@Autowired
	AuthorMapper mapperAuthor;
	
	@Autowired
	AuthorRepository authRepo;

	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getAuthor(@PathVariable("id") int id)
	{
		
		//Non funziona un gran cazzo di niente mi da il quoteMapper null porcodio
	
		try 
		{
			if(id <= 0)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
			Optional<Author> optionalAuthor = authRepo.findById(id);
			
			if(optionalAuthor.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			AuthorDTO res = mapperAuthor.toDTO(optionalAuthor.get());
			
			return new ResponseEntity<>(res, HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<>(new RuntimeException("Errori nella select by id"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Object> insertAuthor(@RequestBody AuthorDTO dto)
	{
		try 
		{
			if(dto.getId() > 0)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
			Author res = mapperAuthor.fromDTO(dto);
			
			authRepo.save(res);
			
			return new ResponseEntity<>(mapperAuthor.toDTO(res), HttpStatus.CREATED);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<>(new RuntimeException("Errori nella insert di Author"), HttpStatus.BAD_REQUEST);
		}
	}
}
