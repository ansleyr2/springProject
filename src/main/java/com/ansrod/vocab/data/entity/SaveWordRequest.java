package com.ansrod.vocab.data.entity;

public class SaveWordRequest {
	private Long id;
	private String word;
	private String meaning;
	private String sentence;
	// private String created_date;
	
	
	
	public Long getId() {
		return id;
	}
	public SaveWordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaveWordRequest(String word, String meaning, String sentence) {
		super();
		// this.id = id;
		this.word = word;
		this.meaning = meaning;
		this.sentence = sentence;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	
	
}
