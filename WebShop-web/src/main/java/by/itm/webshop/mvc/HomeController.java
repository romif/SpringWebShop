package by.itm.webshop.mvc;

import java.util.Map;






import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itm.webshop.domain.Authority;
import by.itm.webshop.domain.User;
import by.itm.webshop.persistence.UserDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	UserDao dao;
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	
	@RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
	  public String showHomePage(Map<String, Object> model) {
		User user=new User();
		user.setLogin("bob");
		user.setPassword("bob");
		Authority authority = new Authority();
		authority.setUser(user);
		authority.setRolename("ROLE_USER");
		dao.addUser(user);
		dao.addUserRole(authority);
		dao.deleteUser(user);
		
		//logger.info("Welcome home!");
	    //model.put("spittles",       spitterService.getRecentSpittles(spittlesPerPage));
	    return "index";
	  }
	
}
