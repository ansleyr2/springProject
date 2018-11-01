package com.ansrod.vocab.business.domain;

import java.util.Date;

public class LearnedWord {
	private long wordId;
	private String word;
	private String meaning;
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
