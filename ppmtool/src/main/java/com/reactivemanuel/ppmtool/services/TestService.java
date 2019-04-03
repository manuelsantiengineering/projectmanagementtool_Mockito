package com.reactivemanuel.ppmtool.services;

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
}
