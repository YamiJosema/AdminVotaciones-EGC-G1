package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.PollRepository;
import security.LoginService;
import security.UserAccount;
import domain.Poll;

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

	public Poll create() {
		Poll result;
		result = new Poll();
		return result;
	}

	public Collection<Poll> findByPrincipal() {
		final Collection<Poll> result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		// result = this.pollRepository.findByUserAccount(userAccount);

		return this.findAll();
	}

	public Poll findOne(final int pollId) {
		Poll result;

		result = this.pollRepository.findOne(pollId);

		return result;
	}

	public Poll findOneToEdit(final int PollId) {
		Poll result;

		result = this.findOne(PollId);
		// this.checkPrincipal(result);

		return result;
	}

	public Collection<Poll> findAll() {
		return this.pollRepository.findAll();
	}

	public void save(final Poll Poll) {
		// this.checkPrincipal(Poll);
		this.pollRepository.save(Poll);
	}

	public void delete(final Poll Poll) {
		// this.checkPrincipal(Poll);
		this.pollRepository.delete(Poll);
	}

	// Other business methods --------------------------------------------------

	// protected void checkPrincipal(final Poll Poll) {
	// Customer customer;
	//
	// customer = this.customerService.findByPrincipal();
	// Assert.isTrue(Poll.getCustomer().equals(customer));
	// }

}
