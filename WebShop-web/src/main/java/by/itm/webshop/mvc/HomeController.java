package by.itm.webshop.mvc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itm.webshop.domain.Authority;
import by.itm.webshop.domain.User;
import by.itm.webshop.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final UserService userService;

	@Inject
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 * 
	 * return "home"; }
	 */

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String showHomePage(Map<String, Object> model) {
		User user;
		if ((user = userService.getUser("bob")) == null) {
			user = new User();
			user.setLogin("bob");
			user.setPassword("bob");
			Authority authority = new Authority("ROLE_USER");
			user.setAuthorities(new HashSet<Authority>(Arrays
					.asList((new Authority[] { authority }))));
		}
		userService.saveUser(user);
		// dao.addUserRole(authority);
		// userService.deleteUser(user.getId());

		logger.info("Welcome home!");
		// model.put("spittles",
		// spitterService.getRecentSpittles(spittlesPerPage));
		return "index";
	}

}
