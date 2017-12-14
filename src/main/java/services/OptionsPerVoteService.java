package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.OptionsPerVoteRepository;
import domain.Option;
import domain.OptionsPerVote;

@Service
@Transactional
public class OptionsPerVoteService {

	// Managed repository ------------------------------------------------------

	@Autowired
	private OptionsPerVoteRepository optionsPerVoteRepository;

	// Supporting services -----------------------------------------------------

	@Autowired
	private OptionService optionService;

	// Constructors ------------------------------------------------------------

	public OptionsPerVoteService() {
		super();
	}

	// Simple CRUD methods -----------------------------------------------------

	public OptionsPerVote create(final int optionId) {
		final OptionsPerVote optionsPerVote = new OptionsPerVote();
		final Option option = this.optionService.findOne(optionId);
		optionsPerVote.setOption(option);
		this.optionsPerVoteRepository.saveAndFlush(optionsPerVote);
		return optionsPerVote;
	}

	public OptionsPerVote findOne(final int optionsPerVoteId) {
		return this.optionsPerVoteRepository.findOne(optionsPerVoteId);
	}

	public Collection<OptionsPerVote> findByOption(final int optionId) {
		final Option option = this.optionService.findOne(optionId);
		return option.getOptionsPerVotes();
	}

	public Collection<OptionsPerVote> findAll() {
		return this.optionsPerVoteRepository.findAll();
	}

	public int saveAndFlush(final OptionsPerVote optionsPerVote) {
		Assert.notNull(optionsPerVote);
		final OptionsPerVote _optionsPerVote = this.optionsPerVoteRepository
				.saveAndFlush(optionsPerVote);
		final int optionsPerVoteId = _optionsPerVote.getId();
		return optionsPerVoteId;
	}

	public void delete(final OptionsPerVote optionsPerVote) {
		Assert.notNull(optionsPerVote);
		this.optionsPerVoteRepository.delete(optionsPerVote);
	}

	// Other business methods --------------------------------------------------

}
