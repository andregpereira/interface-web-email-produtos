package com.bios.sprint03.interfacewebemailprodutos.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bios.sprint03.interfacewebemailprodutos.model.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@GetMapping("/criar")
	public ModelAndView criar() {
		ModelAndView modelView = new ModelAndView("/produto/criar");
		return modelView;
	}

	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView modelView = new ModelAndView("/produto/lista");
		return modelView;
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") String id) {
		ModelAndView modelView = new ModelAndView("/produto/alterar");

		try {
			URL url = new URL("http://localhost:8082/produto/" + id);
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

			Produto produto = mapper.readValue(json, Produto.class);

			modelView.addObject(produto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return modelView;
	}

}
