package br.com.techday.carrefour.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.techday.carrefour.model.DataCep;
import br.com.techday.carrefour.modelDTO.Products;
import br.com.techday.carrefour.modelDTO.ToFrontEnd;
import br.com.techday.carrefour.service.ApiService;

/**
 * @summary Classe de controle
 * 
 * @author Willian K.
 * 
 * @apiNote Classe de controle das requisições da API que recebe um cep do frontend e retorna
 * uma lista de produtos e uma mensagem de erro se houver .
 * 
 * @implSpec Anotação RestController para definir que esta será uma classe de controle e a 
 * anotação  RequestMapping para especificar o ponto que receberá os requests .
 * 
 * **/
@RestController
@RequestMapping("/carrefour")
public class ApiController {
	
	/**
	 * @implNote Auto implementando uma instância da classe de serviço
	 * 
	 * **/
	@Autowired
	private ApiService service;

	/**
	 * @implNote Método que recebe o Body do request contendo um cep e retorna uma lista de produtos 
	 * 
	 * @param cep ,Objeto do tipo DataCep que contém o cep enviado no body da requisição
	 * @return ResponseEntity<ToFrontEnd> 
	 * 
	 * **/
	@CrossOrigin(origins = "*",methods = RequestMethod.POST)
	@PostMapping("/cep")
	public ResponseEntity<ToFrontEnd> cepReciever(@Valid @RequestBody DataCep cep){
		List<Products> products = service.getProducts(cep.getCep());
		if(products != null) {
			return ResponseEntity.ok(ToFrontEnd.builder().products(products).messageError("").build());
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ToFrontEnd.builder().products(null).messageError("No content returned from server !").build());
		}
	} 
}
