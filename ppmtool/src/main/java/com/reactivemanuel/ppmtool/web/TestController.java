package com.reactivemanuel.ppmtool.web;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reactivemanuel.ppmtool.services.ValidationErrorService;
import com.reactivemanuel.ppmtool.domain.Project;
//import com.reactivemanuel.ppmtool.services.ProjectService;
import com.reactivemanuel.ppmtool.services.TestService;

@RestController
@RequestMapping("/api/test")
@CrossOrigin

public class TestController {

//	@Autowired(required=false)
	@Autowired
	private TestService			testService;
	
	
	@GetMapping("")
	public String getTest(){
		return ("Test");		
	}
	
//	@GetMapping("/project")
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public Project getTestProject(){		
		return new Project(1L, "ProjName","PID01","Description");		
	}
	
	@GetMapping("/project-from-business-service")
	public Project getTestProjectFromService(){		
		Project project = testService.retrieveHardcodedItem();
		return project;
//		return new Project(1L, "ProjName","PID01","Description");
	}
	
}
