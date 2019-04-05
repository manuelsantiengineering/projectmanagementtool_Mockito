package com.reactivemanuel.ppmtool.test.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.reactivemanuel.ppmtool.domain.Project;
import com.reactivemanuel.ppmtool.repositories.ProjectRepository;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ProjectRepositoryTest {
	
	@Autowired
	private ProjectRepository			projectRepository;
	
	@Test
	public void findAll_test() {
		List<Project> projectList = (List<Project>) projectRepository.findAll();		
		assertEquals(3, projectList.size());
	}

//	@Test
//	public void findProjectByIdentifier_test() {
//		Project project = projectRepository.findByProjectIdentifier("ID01");
//		
//		assertEquals("Tuca Frita Project 1", project.getProjectName());
//		assertEquals("Description 01", project.getDescription());
//	}
	
}
