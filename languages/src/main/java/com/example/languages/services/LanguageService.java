package com.example.languages.services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.languages.models.Languages;
import com.example.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
			private final LanguageRepository languageRepository;

			public LanguageService(LanguageRepository languageRepository) {
				this.languageRepository = languageRepository;
			}

			public List<Languages> allLanguages() {
				return languageRepository.findAll();
			}

	
			public Languages createLanguage(Languages lang) {
				return languageRepository.save(lang);
			}
			
			
			public Languages findLanguage(Long id) {
				Optional<Languages> optionalLanguage = languageRepository.findById(id);
				if (optionalLanguage.isPresent()) {
					return optionalLanguage.get();
				} else {
					return null;
				}

			}

			
			public Languages updateLanguage(Long id, @ModelAttribute("language") Languages lang) {
				Optional<Languages> optionalLanguage = languageRepository.findById(id);
				if(optionalLanguage.isPresent()) {
					Languages language = optionalLanguage.get();
					language.setName(lang.getName());
					language.setCreator(lang.getCreator());
					language.setCurrentVersion(lang.getCurrentVersion());
					
					return languageRepository.save(language);
				}
				
				return null;
			
			}

			public void deleteLanguage(Long id) {
				languageRepository.deleteById(id);
			}

			
}
