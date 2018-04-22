/**
 * 
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller is used to provide functionality for the home page.
 * 
 * @author Mularien
 *
 */
@Controller
public class LoginLogoutController {

	@RequestMapping(method=RequestMethod.GET, value="/login.do")
	public void login() {
		System.out.print("login");
	}
}
