package com.example.demo.model.dto;

import com.example.demo.model.entities.Quote;

public class QuoteDTO 
{
	private int id;
	private String text;
	private int score;
	private int authorId;
	
	
	
	
	public QuoteDTO(Quote quote) {
		super();
		this.id = quote.getId();
		this.text = quote.getText();
		this.score = quote.getScore();
		this.authorId = quote.getAuthor().getId();
	}
	
	public QuoteDTO() {};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	
}
