package com.example.languages.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.languages.models.Languages;


@Repository
public interface LanguageRepository extends CrudRepository<Languages, Long>{
		List<Languages> findAll();

}

