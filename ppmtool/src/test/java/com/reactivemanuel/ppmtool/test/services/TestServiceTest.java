package com.reactivemanuel.ppmtool.test.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.reactivemanuel.ppmtool.domain.Project;
import com.reactivemanuel.ppmtool.repositories.ProjectRepository;
import com.reactivemanuel.ppmtool.services.TestService;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceTest {

	@InjectMocks
	private TestService				testService;
	
	@Mock
	private ProjectRepository		projectRepository;
	
	@Test
	public void retrieveAllItems_test() {
		List<Project> projectList = Arrays.asList(
				new Project(1L, "ProjName01","PID01","Description01"),
				new Project(2L, "ProjName02","PID03","Description02")
				);	
		when(projectRepository.findAll()).thenReturn(projectList);
		
		List<Project> items = (List<Project>) testService.retrieveAllItems();
		assertEquals("PID01", items.get(0).getProjectIdentifier());
		assertEquals("PID03", items.get(1).getProjectIdentifier());
	}
}
