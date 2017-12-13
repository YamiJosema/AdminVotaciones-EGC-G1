package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.OptionRepository;
import domain.Option;
import domain.Question;

@Service
public class OptionService {

	// Managed repository ------------------------------------------------------

	@Autowired
	private OptionRepository optionRepository;

	// Supporting services -----------------------------------------------------

	@Autowired
	private QuestionService questionService;

	// CRUD methods ------------------------------------------------------------

	public Option create(final int questionId, final String description) {
		final Option option = new Option();
		final Question question = this.questionService.findOne(questionId);
		option.setQuestion(question);
		option.setDescription(description);
		this.optionRepository.saveAndFlush(option);
		return option;
	}

	public int saveAndFlush(final Option option) {
		Assert.notNull(option);
		final Option _option = this.optionRepository.saveAndFlush(option);
		final int optionId = _option.getId();
		return optionId;
	}

	public Option findOne(final int optionId) {
		return this.optionRepository.findOne(optionId);
	}

	public Collection<Option> findByQuestion(final int questionId) {
		final Question question = this.questionService.findOne(questionId);
		return question.getOptions();
	}

	public Collection<Option> findAll() {
		return this.optionRepository.findAll();
	}

	// Other methods -----------------------------------------------------------

}
