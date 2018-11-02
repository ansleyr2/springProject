package com.ansrod.vocab.web.application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ansrod.vocab.business.domain.LearnedWord;
import com.ansrod.vocab.business.service.WordService;

@Controller
@RequestMapping(value="/words")
public class LearnedWordController {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private WordService wordService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String getLearnedWords( @RequestParam(value="date", required=false) String dateString, Model model ) {
		Date date = null;
		if(null != dateString) {
			try {
				date = DATE_FORMAT.parse(dateString);
				
			}catch(ParseException e) {
				date = new Date();
			}
		}else {
			date = new Date();
		}
		List<LearnedWord> wordList = this.wordService.getLearnedWords();
		model.addAttribute("words", wordList);
		return "words";
	}
}
