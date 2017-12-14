package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class OptionsPerVote extends DomainEntity {

	/**
	 * @Class OptionsPerVote
	 * @classDec La clase contiene los atributos que forman la entidad OptionsPerVote (opciones por voto), así como las relaciones
	 *           que tiene esta entidad con el resto de entidades del dominio.
	 * 
	 */

	// Constructors -----------------------------------------------------------

	public OptionsPerVote() {
		super();
	}


	// Relationships ----------------------------------------------------------

	private Option				option;
//	private Vote				vote;


	@Valid
	@ManyToOne(optional = false)
	public Option getOption() {
		return this.option;
	}

	public void setOption(final Option option) {
		this.option = option;
	}

//	@Valid
//	@ManyToOne(optional = false)
//	public Vote getVote() {
//		return this.vote;
//	}
//
//	public void setVote(final Vote vote) {
//		this.vote = vote;
//	}
}
