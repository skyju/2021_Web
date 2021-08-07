package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class RefererController {
	public String getHeader(
			@RequestHeader("referer") String reString, Model model
		) {
		System.out.println(reString);
		model.addAttribute("re", reString);

		// return "header/headerInfo";
		return "redirect:" + reString;
		// return "redirect:/member/login";

	}
}