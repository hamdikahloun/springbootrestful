package com.kahloun.api.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kahloun.api.mapping.SkillInput;
import com.kahloun.api.mapping.SkillsListResponse;
import com.kahloun.api.mapping.SkillsResponse;
import com.kahloun.api.service.SkillsService;

import io.swagger.annotations.ApiOperation;

@RestController
@Validated
public class SkillsEndpoint {

	@Autowired
	private SkillsService skillsService;

	@CrossOrigin()
	@RequestMapping(value = "/skills/new", method = RequestMethod.POST)
	@ApiOperation(value = "\nAdd new skill\n", notes = "\nCode 1 : skill Saved successfully.\n"
			+ "\n Code -1 : Error occurred.\n", response = SkillsResponse.class)
	public SkillsResponse addNewSkill(@Valid @RequestBody SkillInput skillInput) {
		return skillsService.addNewSkill(skillInput);
	}

	@CrossOrigin()
	@RequestMapping(value = "/skills/all", method = RequestMethod.POST)
	@ApiOperation(value = "\nGet All Skills\n", notes = "\nCode 1 : Get All Skills successfully.\n"
			+ "\n Code -1 : Error occurred.\n", response = SkillsListResponse.class)
	public SkillsListResponse getAllSkills() {
		return skillsService.getAllSkills();
	}
}
