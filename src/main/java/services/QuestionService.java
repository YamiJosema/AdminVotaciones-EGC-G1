
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.QuestionRepository;
import domain.DomainEntity;
import domain.Poll;
import domain.Question;

@Service
public class QuestionService extends DomainEntity {

	//Repository
	@Autowired
	private QuestionRepository	questionRepository;
	@Autowired
	private PollService			pollService;


	//Methods

	public Question create(final Integer pollId, final String description) {
		final Question question = new Question();

		final Poll poll = this.pollService.findOne(pollId);
		question.setPoll(poll);
		question.setDescription(description);

		this.questionRepository.saveAndFlush(question);
		return question;
	}

	public int saveAndFlush(final Question question) {
		Assert.notNull(question);
		final Question q2 = this.questionRepository.saveAndFlush(question);
		final int questionID = q2.getId();
		return questionID;
	}

	public Collection<Question> findAllFromPoll(final int pollId) {
		final Poll poll = this.pollService.findOne(pollId);
		return poll.getQuestions();
	}

	public Question findOne(final int questionId) {
		return this.questionRepository.findOne(questionId);
	}

	public Collection<Question> findAll() {
		return this.questionRepository.findAll();
	}

	public Question findOneToEdit(final int questionId) {
		Question result;

		result = this.findOne(questionId);
		//		this.checkPrincipal(result);

		return result;
	}

}
