/*
 * AdministratorController.java
 * 
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.CensusService;
import services.PollService;
import domain.census;
import domain.poll;

/**
 * @Class AdministratorController
 * @classDec La clase contiene el controlador que maneja las acciones del usuario con Rol Administrador
 */
@Controller
@RequestMapping("/poll")
public class PollController extends AbstractController {

	@Autowired
	private PollService		pollService;
	@Autowired
	private CensusService	censusService;


	// Constructors -----------------------------------------------------------
	/**
	 * @return Constructor del controlador.
	 */
	public PollController() {
		super();
	}

	// Creation ---------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		final poll poll = this.pollService.create();

		result = this.createEditModelAndView(poll);

		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final poll poll, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(poll);
		else
			try {
				this.pollService.save(poll);
				result = new ModelAndView("redirect:/");
			} catch (final Throwable oops) {
				System.out.println(oops.getCause());
				result = this.createEditModelAndView(poll, "sponsorship.commit.error");
			}

		return result;
	}

	protected ModelAndView createEditModelAndView(final poll poll, final String message) {
		final ModelAndView result = new ModelAndView("poll/create");
		final Collection<census> census = this.censusService.findAll();

		result.addObject("censuses", census);
		result.addObject("poll", poll);

		return result;
	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final poll poll) {
		ModelAndView result;

		result = this.createEditModelAndView(poll, null);

		return result;
	}

}
