package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Skills;
import com.demo.repository.SkillsRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SkillsController {

	@Autowired
	private SkillsRepository skillsRepository;
	
	@GetMapping("/skills")
	public List<Skills> getAllSkills()
	{
		return skillsRepository.findAll();
	}
	
	@PostMapping("/skills")
	public Skills createSkills(@RequestBody Skills skills)
	{
		return skillsRepository.save(skills);
	}
	
	
}
