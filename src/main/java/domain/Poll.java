
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Poll extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Poll() {
		super();
	}


	// Attributes -------------------------------------------------------------

	private String	title;
	private String	description;


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


	// Relationships ----------------------------------------------------------

	private Collection<Question>	questions;
//	private Census					census;


	@Valid
	@OneToMany(mappedBy = "poll")
	@NotNull
	public Collection<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(final Collection<Question> questions) {
		this.questions = questions;
	}

//	@Valid
//	@ManyToOne(optional = false)
//	public Census getCensus() {
//		return this.census;
//	}
//
//	public void setCensus(final Census census) {
//		this.census = census;
//	}

}
