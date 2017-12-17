package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class question_option extends DomainEntity {

	/**
	 * @Class Option
	 * @classDec La clase contiene los atributos que forman la entidad Option (opción), así como las relaciones
	 *           que tiene esta entidad con el resto de entidades del dominio.
	 * 
	 */

	// Constructors -----------------------------------------------------------

	public question_option() {
		super();
	}

	// Attributes -------------------------------------------------------------

	private String	description;


	@NotBlank
	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}


	// Relationships ----------------------------------------------------------
	private question question;


	@Valid
	@ManyToOne(optional = false)
	public question getQuestion() {
		return this.question;
	}

	public void setQuestion(final question question) {
		this.question = question;
	}

}
