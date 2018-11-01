package com.ansrod.vocab.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/words")
public class LearnedWordController {
	@RequestMapping(method= RequestMethod.GET)
	public String getLearnedWords() {
		return "words";
	}
}
