package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.OptionRepository;
import domain.Question_Option;
import domain.Question;

@Service
@Transactional
public class OptionService {

	// Managed repository ------------------------------------------------------

	@Autowired
	private OptionRepository optionRepository;

	// Supporting services -----------------------------------------------------

	@Autowired
	private QuestionService questionService;

	// Constructors ------------------------------------------------------------

	public OptionService() {
		super();
	}

	// Simple CRUD methods -----------------------------------------------------

	public Question_Option create(final int questionId, final String description) {
		final Question_Option option = new Question_Option();
		final Question question = this.questionService.findOne(questionId);
		option.setQuestion(question);
		option.setDescription(description);
		this.optionRepository.saveAndFlush(option);
		return option;
	}

	public Question_Option findOne(final int optionId) {
		return this.optionRepository.findOne(optionId);
	}

	public Collection<Question_Option> findByQuestion(final int questionId) {
		final Question question = this.questionService.findOne(questionId);
		return question.getOptions();
	}

	public Collection<Question_Option> findAll() {
		return this.optionRepository.findAll();
	}

	public int saveAndFlush(final Question_Option option) {
		Assert.notNull(option);
		final Question_Option _option = this.optionRepository.saveAndFlush(option);
		final int optionId = _option.getId();
		return optionId;
	}

	public void delete(final Question_Option option) {
		Assert.notNull(option);
		this.optionRepository.delete(option);
	}

	// Other business methods --------------------------------------------------

}
