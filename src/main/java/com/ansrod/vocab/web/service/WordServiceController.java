package com.ansrod.vocab.web.service;

import java.util.List;
import java.util.NoSuchElementException;

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
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@RequestMapping(method= RequestMethod.POST, value="/words/saveword", produces= MediaType.APPLICATION_JSON_UTF8_VALUE ,
			consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public LearnedWord saveWord(
			@RequestBody
			SaveWordRequest saveWordRequest){
		
		Word word = conversionService.convert(saveWordRequest, Word.class);
		wordRepository.save(word);
		
		//TO-DO : return the saved entity
		return new LearnedWord(saveWordRequest.getWord(), saveWordRequest.getMeaning(),
				saveWordRequest.getSentence());
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/words/update/{wordId}", produces= MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Word updateWithPut(@PathVariable(value="wordId") long id,
			@RequestBody
			SaveWordRequest saveWordRequest){
		Word word = verifyWord(id);
		word.setMeaning(saveWordRequest.getMeaning());
		word.setSentence(saveWordRequest.getSentence());
		word.setWord(saveWordRequest.getWord());
		wordRepository.save(word);
		// return new ResponseEntity<>(new LearnedWord(), HttpStatus.OK);
		//return new Word(saveWordRequest.getWord(), saveWordRequest.getMeaning(),
			//	saveWordRequest.getSentence());
		return verifyWord(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.PATCH, value="/words/update/{wordId}", produces= MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Word updateWithPatch(@PathVariable(value="wordId") long id,
			@RequestBody
			SaveWordRequest saveWordRequest){
		Word word = verifyWord(id);
		//LearnedWord learnedWord = new LearnedWord();
		if(saveWordRequest.getMeaning() != null) {
			word.setMeaning(saveWordRequest.getMeaning());
			//learnedWord.setMeaning(saveWordRequest.getMeaning());
		}
		if(saveWordRequest.getSentence() != null) {
			word.setSentence(saveWordRequest.getSentence());
			//learnedWord.setSentence(saveWordRequest.getSentence());
		}
		if(saveWordRequest.getWord() != null) {
			word.setWord(saveWordRequest.getWord());
			//learnedWord.setWord(saveWordRequest.getWord());
		}
		
		wordRepository.save(word);
		return verifyWord(id);
	}
	
	// Returns the word for the id
	private Word verifyWord(long wordid) throws NoSuchElementException {
		Word word = wordRepository.findOne(wordid);
		if(word == null) {
			throw new NoSuchElementException("No word found");
		}
		return word;
	}
}
