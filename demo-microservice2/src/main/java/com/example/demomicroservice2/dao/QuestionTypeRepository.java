package com.example.demomicroservice2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demomicroservice2.domain.QuestionType;

@Repository
public interface QuestionTypeRepository extends CrudRepository<QuestionType, Integer> {

}
