package com.ansrod.vocab.business.service;

import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ansrod.vocab.business.domain.LearnedWord;
import com.ansrod.vocab.data.entity.Word;
import com.ansrod.vocab.data.repository.WordRepository;

@Service
public class WordService {
	// This should be properly used from classes.Hence keeping it final
	private final WordRepository wordRepository;

	@Autowired
	public WordService(WordRepository wordRepository) {
		//super();
		this.wordRepository = wordRepository;
	}
	
	// Get all words
	public List<LearnedWord> getLearnedWords(){
		Iterable<Word> words = this.wordRepository.findAll();
		Map<Long, LearnedWord> learnedWordMap = new HashMap<>();
		words.forEach(word ->{
			LearnedWord learnedWord = new LearnedWord();
			learnedWord.setWordId(word.getId());
			learnedWord.setWord(word.getWord());
			learnedWord.setMeaning(word.getMeaning());
			learnedWord.setSentence(word.getSentence());
			learnedWordMap.put(word.getId(), learnedWord);
		});
		List<LearnedWord> learnedWords = new ArrayList<LearnedWord>();
		for(Long wordId: learnedWordMap.keySet()) {
			learnedWords.add(learnedWordMap.get(wordId));
		}
		return learnedWords;
	}
	
}
