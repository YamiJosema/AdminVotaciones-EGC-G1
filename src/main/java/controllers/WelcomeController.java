package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.CensusService;
import services.PollService;

/**
 * @Class WelcomeController
 * @classDec La clase contiene el controlador que maneja las acciones de
 *           bienvenida y para saber más de los desarrolladores
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeController extends AbstractController {
	
	// Services
	@Autowired
	private CensusService censusService;
	@Autowired	
	private PollService	pollService;
	
	
	// Constructors -----------------------------------------------------------
	/**
	 * @return Constructor del controlador.
	 */
	public WelcomeController() {
		super();
	}

	// Index ------------------------------------------------------------------
	/**
	 * @param name
	 *            String con el nombre del usuario logeado. Por defecto
	 *            Benavides.
	 * @return Este método devuelve el modelo de vista de la página principal
	 *         del proyecto.
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index(@RequestParam(required = false, defaultValue = "Benavides") String name) {
		ModelAndView result;
		SimpleDateFormat formatter;
		String moment;

		formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		moment = formatter.format(new Date());
		result = new ModelAndView("welcome/index");
		result.addObject("name", name);
		result.addObject("moment", moment);
		result.addObject("census", this.censusService.findAll().size());
		result.addObject("poll", this.pollService.findAll().size());

		return result;
	}

	/**
	 * @return Este método devuelve el modelo de vista de la página en la cual
	 *         podras saber quienes han sido los desarrolladores del proyecto.
	 */
	@RequestMapping(value = "/aboutus")
	public ModelAndView aboutUs() {
		ModelAndView result;
		result = new ModelAndView("welcome/aboutus");

		result.addObject("requestURI", "welcome/aboutus");
		
		SimpleDateFormat formatter;
		String moment;
		formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		moment = formatter.format(new Date());
		result.addObject("moment", moment);
		return result;

	}
}