package domain;

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
public class Question extends DomainEntity {

	/**
	 * @Class Question
	 * @classDec La clase contiene los atributos que forman la entidad Question (pregunta), así como las relaciones
	 *           que tiene esta entidad con el resto de entidades del dominio.
	 * 
	 */

	// Constructors -----------------------------------------------------------

	public Question() {
		super();
	}

	// Attributes -------------------------------------------------------------

	private String	title;
	private String	description;
	private Boolean optional;
	private Boolean multiple;


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
	public Boolean getOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	@NotNull
	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	// Relationships ----------------------------------------------------------
	private Collection<Option>	options;
	private Poll				poll;


	@Valid
	@OneToMany(mappedBy = "question")
	public Collection<Option> getOptions() {
		return this.options;
	}

	public void setOptions(final Collection<Option> options) {
		this.options = options;
	}

	@Valid
	@ManyToOne(optional = false)
	public Poll getPoll() {
		return this.poll;
	}

	public void setPoll(final Poll poll) {
		this.poll = poll;
	}
}
