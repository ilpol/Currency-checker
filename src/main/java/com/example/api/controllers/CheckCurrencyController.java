package com.example.api.controllers;

import com.example.api.domain.MoodChooser;
import com.example.api.remoteservices.RemoteServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//ebf77c6d832b4c5ea37958354fcba16d

//giphy
//9QGQ7Lf9QUdotQfaKQIZhJdj9D6PUQ1m


@Controller
public class CheckCurrencyController {


	@GetMapping("/check-currency")
	public String checkCurrency(@RequestParam(name="currency", required=false, defaultValue="AED") String currency, Model model) throws NoSuchFieldException, IllegalAccessException {

		RemoteServices remoteServices = new RemoteServices();
		String gifUrl;
		MoodChooser moodChooser = new MoodChooser();

		if (moodChooser.getMood(currency) ==true) {
			gifUrl = remoteServices.getGif(true);
		} else {
			gifUrl = remoteServices.getGif(false);
		}

		model.addAttribute("gifUrl", gifUrl);

		return "checkCurrency";
	}

}


