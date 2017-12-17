package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.PollRepository;
import domain.census;
import domain.poll;

@Service
@Transactional
public class PollService {

	// Managed repository ------------------------------------------------------

	@Autowired
	private PollRepository pollRepository;

	// Supporting services -----------------------------------------------------

	// Constructors ------------------------------------------------------------

	public PollService() {
		super();
	}

	// Simple CRUD methods -----------------------------------------------------

	public poll create(census census) {
		poll result = new poll();
		result.setCensus(census);
		return result;
	}

	public poll findOne(final int pollId) {
		return this.pollRepository.findOne(pollId);
	}

	public Collection<poll> findAll() {
		return this.pollRepository.findAll();
	}

	public poll save(final poll poll) {
		Assert.notNull(poll);
		return this.pollRepository.save(poll);
	}

	// Other business methods --------------------------------------------------

}
