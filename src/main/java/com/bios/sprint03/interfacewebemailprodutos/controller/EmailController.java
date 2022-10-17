package com.bios.sprint03.interfacewebemailprodutos.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bios.sprint03.interfacewebemailprodutos.model.Email;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/email")
public class EmailController {

	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView modelView = new ModelAndView("/email/lista");

		try {
			URL url = new URL("http://localhost:8080/email/lista");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			String json = "";
			Scanner scanner = new Scanner(url.openStream());

			while (scanner.hasNext()) {
				json += scanner.nextLine();
			}

			scanner.close();

			ObjectMapper mapper = new ObjectMapper();

			List<Email> listaEmails = Arrays.asList(mapper.readValue(json, Email[].class));

			modelView.addObject("listaEmails", listaEmails);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return modelView;
	}

	@GetMapping("/lista/{dataEnvio}")
	public ModelAndView listaFiltrada(@PathVariable String dataEnvio) {
		ModelAndView modelView = new ModelAndView("/email/lista");

		try {
			URL url = new URL("http://localhost:8080/email/" + dataEnvio);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			System.out.println(conn.getResponseCode());

			String json = "";
			Scanner scanner = new Scanner(url.openStream());

			while (scanner.hasNext()) {
				json += scanner.nextLine();
			}

			scanner.close();

			ObjectMapper mapper = new ObjectMapper();

			List<Email> listaEmails = Arrays.asList(mapper.readValue(json, Email[].class));

			modelView.addObject("listaEmails", listaEmails);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return modelView;
	}

}
