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

	public Question create(final Integer pollId, final String description) {
		final Question question = new Question();
		final Poll poll = this.pollService.findOne(pollId);
		question.setPoll(poll);
		question.setDescription(description);
		this.questionRepository.saveAndFlush(question);
		return question;
	}

	public Question findOne(final int questionId) {
		return this.questionRepository.findOne(questionId);
	}

	public Question findOneToEdit(final int questionId) {
		Question result;

		result = this.findOne(questionId);
		// this.checkPrincipal(result);

		return result;
	}

	public Collection<Question> findByPoll(final int pollId) {
		final Poll poll = this.pollService.findOne(pollId);
		return poll.getQuestions();
	}

	public Collection<Question> findAll() {
		return this.questionRepository.findAll();
	}

	public int saveAndFlush(final Question question) {
		Assert.notNull(question);
		final Question _question = this.questionRepository
				.saveAndFlush(question);
		final int questionID = _question.getId();
		return questionID;
	}

	public void delete(final Question question) {
		Assert.notNull(question);
		this.questionRepository.delete(question);
	}

	// Other business methods --------------------------------------------------

}
