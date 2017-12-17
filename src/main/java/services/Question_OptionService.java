package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.Question_OptionRepository;
import domain.Question_Option;
import domain.Question;

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

	public Question_Option create(Question question) {
		final Question_Option result = new Question_Option();
		result.setQuestion(question);
		return result;
	}

	public Question_Option findOne(final int optionId) {
		return this.optionRepository.findOne(optionId);
	}
	
	public Collection<Question_Option> findAll() {
		return this.optionRepository.findAll();
	}

	public Question_Option save(final Question_Option option) {
		Assert.notNull(option);
		return this.optionRepository.save(option);
	}

	// Other business methods --------------------------------------------------

}
