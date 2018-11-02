package com.ansrod.vocab.converter;

import org.springframework.core.convert.converter.Converter;

import com.ansrod.vocab.data.entity.SaveWordRequest;
import com.ansrod.vocab.data.entity.Word;

// Convert a Request body to entity so that we can save it.
public class SaveWordRequestToWordConverter implements Converter<SaveWordRequest, Word> {

	@Override
	public Word convert(SaveWordRequest source) {
		// TODO Auto-generated method stub
		Word word = new Word();
		word.setWord(source.getWord());
		word.setMeaning(source.getMeaning());
		word.setSentence(source.getSentence());
		if(null != source.getId()) {
			word.setId(source.getId());
		}
		return word;
	}

}
