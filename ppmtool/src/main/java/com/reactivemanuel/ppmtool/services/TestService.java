package com.reactivemanuel.ppmtool.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reactivemanuel.ppmtool.domain.Project;

@Service
public class TestService {

	public Project retrieveHardcodedItem() {
		return new Project(1L, "ProjName","PID01","Description");	
	}
	
	public Iterable<Project>  retrieveHardcodedItemList() {
		List<Project> projectList = Arrays.asList(
				new Project(1L, "ProjName01","PID01","Description01"),
				new Project(2L, "ProjName02","PID03","Description02")
				);
		return projectList;	
	}
}
