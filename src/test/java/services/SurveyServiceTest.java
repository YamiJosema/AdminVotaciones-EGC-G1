								package services;

import java.util.ArrayList;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


import domain.Question;
import domain.Survey;

import utilities.AbstractTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class SurveyServiceTest extends AbstractTest{

	//Service under test ------------------------------------------------------
	@Autowired
	private SurveyService surveyService;
	
	//Supporting Services -----------------------------------------------------
	
	@Autowired
	private QuestionService questionService;
	
	//Tests -------------------------------------------------------------------
	
	@Test
	public void testFindOne(){
		Survey res;
		int id;
		
		id = 0;
		
		res = surveyService.findOne(1);
		System.out.println("\n\n\n/////////////////////////////////////////////////////////////////////////////////");
		System.out.println("///////////////////////////// Test find one /////////////////////////////////////////");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////\n");
		
		System.out.println("Surveys:");
		
		for(Survey s: surveyService.allSurveys()){
			System.out.println("Id: " + s.getId() + "," + s);
			id = s.getId();
		}
		
		
		System.out.println(surveyService.findOne(id));
		
	}
	
	
	@Test
	public void testCreate(){
		Survey res;
		
		res = surveyService.create();
		
		System.out.println("\n\n\n///////////////////////////////////////////////////////////////////////");
		System.out.println("////////////// Test de Creación de un Objeto Survey //////////////////");
		System.out.println("///////////////////////////////////////////////////////////////////////\n");
		
		System.out.println(res);
	}
	
	@Test
	public void testSave(){
		Survey res;
//		Date startDate;
//		Date endDate;
		String user ="user";
		
//		startDate= new Date();
//		endDate= new Date();
		
		
		res = surveyService.create();
		res.setName("Cuestionario prueba");
		res.setDescription("Descripcion de cuestionerio de pruebas");
//		res.setStartDate(startDate);
//		res.setEndDate(endDate);
//		res.setCensus(7);
//		res.setTipo("Cuestionario");
		
		System.out.println("Surveys: ");
		for(Survey s: surveyService.allSurveys()){
			System.out.println(s);
		}
		
		surveyService.save(res,user);
		
		System.out.println("\n\n\n/////////////////////////////////////////////////////////////////////////////////");
		System.out.println("////////////// Test de guardar una encuesta de forma persistente //////////////////");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////\n");
		
		System.out.println("La encuesta se ha guardado con éxito");
		
	}

	@Test
	public void testDelete(){
		
		
		Survey res;
		
		res = new Survey();
		
		res = surveyService.findOne(1);
		surveyService.delete(res.getId());
		
		System.out.println("\n\n\n//////////////////////////////////////////////////////////////////////////////////");
		System.out.println("////////////// Test de eliminar una encuesta de forma persistente //////////////////");
		System.out.println("//////////////////////////////////////////////////////////////////////////////////\n");
		
		System.out.println("La encuesta se ha eliminado con éxito");
		
		authenticate(null);
	}
	
	
	
	
	
//	@Test
//	public void testallFinishedSurveys(){
//		
//		Collection<Survey> all;
//		
//		all = surveyService.allFinishedSurveys();
//		
//		System.out.println("\n\n\n//////////////////////////////////////////////////////////////////////////////////");
//		System.out.println("////////////// Test de mostrar todas las encuestas finalizadas //////////////////");
//		System.out.println("//////////////////////////////////////////////////////////////////////////////////\n");
//	
//		for (Survey i: all){
//			System.out.println(i.getName() + " - " + i.getEndDate().toString());
//		}
//	}
//	
	@Test
	public void testsaveQuestion(){
		
		Survey s;
		
		s = new Survey();
		
		
		//surveyService.saveAddQuestion(1, 3, false);
		
		System.out.println("\n\n\n//////////////////////////////////////////////////////////////////////////////////");
		System.out.println("////////////// Test añadir a una encuesta una pregunta //////////////////");
		System.out.println("//////////////////////////////////////////////////////////////////////////////////\n");
		
		System.out.println("Encuesta: ");
		s.setName("Encuesta 1");
		s.setDescription("Descripcion 1");
		s.setUsernameCreator("Usuario");
		
		
		s.setQuestions(new ArrayList<Question>());
		s = surveyService.findOne(surveyService.save(s, s.getUsernameCreator()));
		System.out.println(s.getId() + " Preguntas: " + s.getQuestions());
		Question q = new Question();
		q.setText("Pregunta de prueba");
		q = questionService.findOne(questionService.saveAndFlush(q));
		surveyService.saveAddQuestion(s.getId(), q.getId(), true);
		System.out.println("Preguntas despues de añadir: " + s.getQuestions());

		System.out.println("La pregunta se ha añadido con exito");

	}
	
	@Test
	public void testallCreatedSurveys(){
		
		Collection<Survey> all;
		
		all = surveyService.allCreatedSurveys("pepe");
		
		System.out.println("\n\n\n//////////////////////////////////////////////////////////////////////////////////");
		System.out.println("////////////// Test de mostrar todas las encuestas de un usuario //////////////////");
		System.out.println("//////////////////////////////////////////////////////////////////////////////////\n");
	
		for (Survey i: all){
			System.out.println(i.getName().toString());
		}
	}
	
}
