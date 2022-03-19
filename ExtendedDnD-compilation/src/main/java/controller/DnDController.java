package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DnDController {
	
	@GetMapping("/login")
	public String getPaisesContinente() {
		return "login";
	}
}
