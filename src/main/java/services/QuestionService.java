package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.QuestionRepository;
import domain.poll;
import domain.question;

@Service
@Transactional
public class QuestionService {

	// Managed repository ------------------------------------------------------

	@Autowired
	private QuestionRepository questionRepository;

	// Supporting services -----------------------------------------------------

	@Autowired
	private PollService pollService;

	// Constructors ------------------------------------------------------------

	public QuestionService() {
		super();
	}

	// Simple CRUD methods -----------------------------------------------------

	public question create(final poll poll) {
		final question question = new question();
		question.setPoll(poll);
		return question;
	}

	public question findOne(final int questionId) {
		return this.questionRepository.findOne(questionId);
	}

	public Collection<question> findAll() {
		return this.questionRepository.findAll();
	}

	public question save(final question question) {
		Assert.notNull(question);
		return this.questionRepository.save(question);
	}


	// Other business methods --------------------------------------------------

}
