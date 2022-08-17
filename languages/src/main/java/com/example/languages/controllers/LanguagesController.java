package com.example.languages.controllers;

import java.util.*;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.languages.models.Languages;
import com.example.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguagesController {

	private final LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	// display dashboard
	@RequestMapping("")
	public String display(Model model, @ModelAttribute("language") Languages language) {
		List<Languages> lang = languageService.allLanguages();
		model.addAttribute("lang", lang);
		return "dashboard.jsp";
	}

	// create language, handle data
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Languages language, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			List<Languages> lang = languageService.allLanguages();
			model.addAttribute("lang", lang);
			return "dashboard.jsp";
		} else {
			languageService.createLanguage(language);
			redirectAttributes.addFlashAttribute("success", "language created !");
			return "redirect:/languages";
		}

	}

	// display language data in the fields
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Languages lang = languageService.findLanguage(id);
		model.addAttribute("lang", lang);
		return "edit.jsp";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("lang") Languages lang,
			BindingResult result,
			@PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	languageService.updateLanguage(id, lang);
            return "redirect:/languages";
        }
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";

	}

	@RequestMapping("/{id}/view")
	public String display(@PathVariable("id") Long id, Model model) {
		Languages lang = languageService.findLanguage(id);
		model.addAttribute("language", lang);
		return "view.jsp";
	}
}
