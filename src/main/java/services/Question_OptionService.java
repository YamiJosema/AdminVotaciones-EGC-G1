package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.Question_OptionRepository;
import domain.question_option;
import domain.question;

@Service
@Transactional
public class Question_OptionService {

	// Managed repository ------------------------------------------------------

	@Autowired
	private Question_OptionRepository optionRepository;

	// Supporting services -----------------------------------------------------

	@Autowired
	private QuestionService questionService;

	// Constructors ------------------------------------------------------------

	public Question_OptionService() {
		super();
	}

	// Simple CRUD methods -----------------------------------------------------

	public question_option create(question question) {
		final question_option result = new question_option();
		result.setQuestion(question);
		return result;
	}

	public question_option findOne(final int optionId) {
		return this.optionRepository.findOne(optionId);
	}
	
	public Collection<question_option> findAll() {
		return this.optionRepository.findAll();
	}

	public question_option save(final question_option option) {
		Assert.notNull(option);
		return this.optionRepository.save(option);
	}

	// Other business methods --------------------------------------------------

}
