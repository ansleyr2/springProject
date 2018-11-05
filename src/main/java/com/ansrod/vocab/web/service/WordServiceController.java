package com.ansrod.vocab.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ansrod.vocab.business.domain.LearnedWord;
import com.ansrod.vocab.business.service.WordService;
import com.ansrod.vocab.data.entity.SaveWordRequest;
import com.ansrod.vocab.data.entity.Word;
import com.ansrod.vocab.data.repository.WordRepository;

@RestController
@RequestMapping(value="/api")
public class WordServiceController {
	//@Autowired
	//private Word word;
	
	@Autowired
	private WordRepository wordRepository;
	
	@Autowired
	ConversionService conversionService;
	
	@Autowired
	private WordService wordService;
	// The path param is not used, just a mock that shows how is can be utilized.
	//Get words for specified date
	@RequestMapping(method = RequestMethod.GET, value="/words/{date}")
	public List<LearnedWord> getWordsForDate(@PathVariable(value="date") String dateString){
		return this.wordService.getLearnedWords();
	}

	// Get all words.
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET, value="/words")
	public List<LearnedWord> getWordsForDate(){
		return this.wordService.getLearnedWords();
	}
	
	// Save word
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method= RequestMethod.POST, value="/saveword", produces= MediaType.APPLICATION_JSON_UTF8_VALUE ,
			consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<LearnedWord> saveWord(
			@RequestBody
			SaveWordRequest saveWordRequest){
		
		Word word = conversionService.convert(saveWordRequest, Word.class);
		wordRepository.save(word);
		
		return new ResponseEntity<>(new LearnedWord(), HttpStatus.CREATED);
	}
}
