package com.codingdojo.mvc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.mvc.models.Comment;
import com.codingdojo.mvc.models.Event;
import com.codingdojo.mvc.models.User;
import com.codingdojo.mvc.services.CommentService;
import com.codingdojo.mvc.services.EventService;
import com.codingdojo.mvc.services.UserService;

@Controller
public class RepasoController {
	private final UserService userServ;
	private final EventService evenServ;
	private final CommentService comServ;

	public RepasoController(UserService a, EventService b, CommentService c) {
		this.userServ = a;
		this.evenServ = b;
		this.comServ = c;
	}
	@RequestMapping("/")
	public String index() {
		return "/views/index.jsp";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@RequestParam("firstName") String nombre, @RequestParam("lastName") String apellido, @RequestParam("email") String correo, @RequestParam("city") String ciudad, @RequestParam("region") String region,@RequestParam("password") String contraseña,@RequestParam("confirmPassword") String confirmar, RedirectAttributes errors) {
		boolean err = false;
		if (nombre.length() < 2 || nombre.length() > 100) {
			errors.addFlashAttribute("errorA", "El nombre debe tener minimo 2 letras y maximo 100.");
			err = true;
		}
		if (apellido.length() < 2 || apellido.length() > 100) {
			errors.addFlashAttribute("errorB", "El apellido debe tener minimo 2 letras y maximo 100.");
			err = true;
		}
		// Patrón para validar el email
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(correo);

		if (mather.find() != true) {
			errors.addFlashAttribute("errorC", "Este correo no es valido.");
			err = true;
		} 
		if (ciudad.length() < 2 || ciudad.length() > 150) {
			errors.addFlashAttribute("errorD", "La ciudad debe tener minimo 2 letras y maximo 150.");
			err = true;
		}
		if (region.equals("null")) {
			errors.addFlashAttribute("errorE", "Debes selecionar una Region.");
			err = true;
		}
		//Validar Contraseña
		char clave;
		byte  contNumero = 0, contLetraMay = 0, contLetraMin=0;
		for (byte i = 0; i < contraseña.length(); i++) {
			clave = contraseña.charAt(i);
			String passValue = String.valueOf(clave);
			if (passValue.matches("[A-Z]")) {
				contLetraMay++;
			} else if (passValue.matches("[a-z]")) {
				contLetraMin++;
			} else if (passValue.matches("[0-9]")) {
				contNumero++;
			}
		}
		if (contraseña.length() < 8 || contNumero <= 0 || contLetraMay <= 0 || contLetraMin <= 0) {
			errors.addFlashAttribute("errorF", "Tu contraseña debe tener minimo 8 digitos, ademas de una Mayuscula, minuscula y numero.");
			err = true;
		}
		if (!confirmar.equals(contraseña)) {
			errors.addFlashAttribute("errorG", "Las contraseñas no coinciden.");
			err = true;
		}
		if (err) {
			return "redirect:/";
		} else {
			User test = userServ.findByEmail(correo);
			if (test == null) {
				List<Comment> comentarios = new ArrayList<Comment>();
				List<Event> miseventos = new ArrayList<Event>();
				List<Event> eventos = new ArrayList<Event>();
				User nuevo = new User(nombre, apellido, correo, ciudad, region, contraseña, confirmar, comentarios, miseventos, eventos);
				userServ.createUser(nuevo);
				errors.addFlashAttribute("result", "<p class='text-center text-success'><small>Cuenta nueva Creada</small></p>\"");
				return "redirect:/";
			} else {
				errors.addFlashAttribute("result", "<p class='text-center text-danger'><small>Cuenta ya existente</small></p>");
				return "redirect:/";
			}
		}
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("email") String correo, @RequestParam("password") String contraseña, RedirectAttributes errors, HttpSession session) {
		String result = userServ.authenticateUser(correo, contraseña);
		if (result.equals("listo")) {
			User a = userServ.findByEmail(correo);
			session.setAttribute("userid", a.getId());
			return "redirect:/dashboard";
		} else {
			errors.addFlashAttribute("errorH", result);
			return "redirect:/";
		}
	}
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userid");
		User user = userServ.findById(id);
		List<Event> eventos = evenServ.allEvents();
		List<Event> locales = evenServ.allEventsInRegion(user.getRegion());
		List<Event> externos = new ArrayList<Event>();
		for (int a=0;a < eventos.size();a++) {
			if (!eventos.get(a).getRegion().equals(user.getRegion())) {
				externos.add(eventos.get(a));
			}
		}
		System.out.println(user.getEvents().size());
		model.addAttribute("user", user);
		model.addAttribute("events", externos);
		model.addAttribute("locales", locales);
		return "/views/dashboard.jsp";
	}
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String login(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="/event/new", method=RequestMethod.POST)
	public String register(HttpSession session, @RequestParam("name") String nombre, @RequestParam("date") String fecha, @RequestParam("city") String ciudad, @RequestParam("region") String region, RedirectAttributes errors) throws ParseException {
		boolean err = false;
		Date today = new Date();
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		if (date.before(today)) {
			errors.addFlashAttribute("errorA", "No puedes ingresar fechas anteriores a la de hoy.");
			err = true;
		}
		if (ciudad.length() < 2 || ciudad.length() > 150) {
			errors.addFlashAttribute("errorB", "La ciudad debe tener minimo 2 letras y maximo 150.");
			err = true;
		}
		if (region.equals("null")) {
			errors.addFlashAttribute("errorC", "Debes selecionar una Region.");
			err = true;
		}
		if (err) {
			return "redirect:/dashboard";
		} else {
			Long id = (Long) session.getAttribute("userid");
			User user = userServ.findById(id);
			List<Comment> comentarios = new ArrayList<Comment>();
			List<User> invitados = new ArrayList<User>();
			Event nuevo = new Event(nombre, date, ciudad, region, comentarios, user, invitados);
			evenServ.createEvent(nuevo);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping(value="/event/{id}/delete", method=RequestMethod.POST)
	public String delete(@PathVariable("id") Long id) {
		evenServ.deleteEvent(id);
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/event/{id}/join", method=RequestMethod.POST)
	public String join(@PathVariable("id") Long id, HttpSession session) {
		Event even = evenServ.findEvent(id);
		Long userid = (Long) session.getAttribute("userid");
		User user = userServ.findById(userid);
		even.getGuests().add(user);
		evenServ.joinEvent(even);
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/event/{id}/cancel", method=RequestMethod.POST)
	public String cancel(@PathVariable("id") Long id, HttpSession session) {
		Event even = evenServ.findEvent(id);
		Long userid = (Long) session.getAttribute("userid");
		User user = userServ.findById(userid);
		even.getGuests().remove(user);
		evenServ.joinEvent(even);
		return "redirect:/dashboard";
	}
	@RequestMapping("/event/{id}")
	public String event(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userid = (Long) session.getAttribute("userid");
		User user = userServ.findById(userid);
		Event evento = evenServ.findEvent(id);
		model.addAttribute("user", user);
		model.addAttribute("event", evento);
		return "/views/event.jsp";
	}
	@RequestMapping(value="/event/{id}", method=RequestMethod.POST)
	public String coment(@PathVariable("id") Long id, HttpSession session, @RequestParam("message") String mensaje) {
		Event even = evenServ.findEvent(id);
		Long userid = (Long) session.getAttribute("userid");
		User user = userServ.findById(userid);
		Comment nuevo = new Comment(mensaje, user, even);
		comServ.createComent(nuevo);
		return "redirect:/event/"+id;
	}
	@RequestMapping("/event/{id}/edit")
	public String showedit(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userid = (Long) session.getAttribute("userid");
		User user = userServ.findById(userid);
		Event evento = evenServ.findEvent(id);
		model.addAttribute("user", user);
		model.addAttribute("event", evento);
		return "/views/edit.jsp";
	}
	@RequestMapping(value="/event/{id}/edit", method=RequestMethod.POST)
	public String edit(@PathVariable("id") Long id, HttpSession session, @RequestParam("name") String nombre, @RequestParam("date") String fecha, @RequestParam("city") String ciudad, @RequestParam("region") String region, RedirectAttributes errors) throws ParseException {
		boolean err = false;
		Date today = new Date();
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		if (date.before(today)) {
			errors.addFlashAttribute("errorA", "No puedes ingresar fechas anteriores a la de hoy.");
			err = true;
		}
		if (ciudad.length() < 2 || ciudad.length() > 150) {
			errors.addFlashAttribute("errorB", "La ciudad debe tener minimo 2 letras y maximo 150.");
			err = true;
		}
		if (region.equals("null")) {
			errors.addFlashAttribute("errorC", "Debes selecionar una Region.");
			err = true;
		}
		if (err) {
			return "redirect:/event/"+id+"/edit";
		} else {
			Event cambio = new Event(nombre, date, ciudad, region);
			evenServ.updateEvent(id, cambio);
			return "redirect:/dashboard";
		}
	}
}