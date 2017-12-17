package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.CensusRepository;
import domain.census;
import domain.poll;
import domain.question;

@Service
@Transactional
public class CensusService {

	// Managed repository ------------------------------------------------------

	@Autowired
	private CensusRepository censusRepository;

	// Supporting services -----------------------------------------------------

	// Constructors ------------------------------------------------------------

	public CensusService() {
		super();
	}

	// Simple CRUD methods -----------------------------------------------------


	public census findOne(final int censusId) {
		return this.censusRepository.findOne(censusId);
	}

	public Collection<census> findAll() {
		return this.censusRepository.findAll();
	}

	// Other business methods --------------------------------------------------

}
