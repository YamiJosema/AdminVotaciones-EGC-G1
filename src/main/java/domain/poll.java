package domain;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

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
	private int 	participantes_admitidos;
	private int		votos_actuales;


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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getParticipantes_admitidos() {
		return participantes_admitidos;
	}

	public void setParticipantes_admitidos(int participantes_admitidos) {
		this.participantes_admitidos = participantes_admitidos;
	}

	public int getVotos_actuales() {
		return votos_actuales;
	}

	public void setVotos_actuales(int votos_actuales) {
		this.votos_actuales = votos_actuales;
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
