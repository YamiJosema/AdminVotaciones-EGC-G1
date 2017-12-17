package domain;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class poll extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public poll() {
		super();
	}


	// Attributes -------------------------------------------------------------

	private String	title;
	private String	description;
	private Date 	startDate;
	private Date 	endDate;


	@NotBlank
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	@NotBlank
	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
	
	@NotNull
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@NotNull
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	// Relationships ----------------------------------------------------------
	private Collection<question>	questions;
	private census					census;


	@Valid
	@OneToMany(mappedBy = "poll")
	@NotNull
	public Collection<question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(final Collection<question> questions) {
		this.questions = questions;
	}

	@Valid
	@ManyToOne(optional = false)
	public census getCensus() {
		return this.census;
	}

	public void setCensus(final census census) {
		this.census = census;
	}

}