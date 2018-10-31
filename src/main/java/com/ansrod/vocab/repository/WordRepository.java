package com.ansrod.vocab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ansrod.vocab.data.entity.Word;

@Repository
// <Word, Long> -- word is the class and Long is the id data type
public interface WordRepository extends CrudRepository<Word, Long> {
	
}
