package com.ansrod.vocab.business.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LearnedWord {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long wordId;
	private String word;
	private String meaning;
	public LearnedWord(String word, String meaning, String sentence) {
		//super();
		this.word = word;
		this.meaning = meaning;
		this.sentence = sentence;
	}
	public LearnedWord() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String sentence;
	private Date date;
	
	public long getWordId() {
		return wordId;
	}
	public void setWordId(long wordId) {
		this.wordId = wordId;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
