
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Option extends DomainEntity {

	/**
	 * @Class Option
	 * @classDec La clase contiene los atributos que forman la entidad Option (opción), así como las relaciones
	 *           que tiene esta entidad con el resto de entidades del dominio.
	 * 
	 */

	// Constructors -----------------------------------------------------------

	public Option() {
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
	private Question					question;


	@Valid
	@ManyToOne(optional = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(final Question question) {
		this.question = question;
	}

}
