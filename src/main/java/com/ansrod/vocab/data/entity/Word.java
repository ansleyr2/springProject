package com.ansrod.vocab.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WORD")
public class Word {
	@Id
	@Column(name="word_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	@Column(name="word")
	private String word;
	@Column(name="meaning")
	private String meaning;
	@Column(name="sentence")
	private String sentence;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
