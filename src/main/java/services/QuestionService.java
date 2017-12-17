package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.QuestionRepository;
import domain.Poll;
import domain.Question;

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

	public Question create(final Poll poll) {
		final Question question = new Question();
		question.setPoll(poll);
		return question;
	}

	public Question findOne(final int questionId) {
		return this.questionRepository.findOne(questionId);
	}

	public Collection<Question> findAll() {
		return this.questionRepository.findAll();
	}

	public Question save(final Question question) {
		Assert.notNull(question);
		return this.questionRepository.save(question);
	}


	// Other business methods --------------------------------------------------

}
