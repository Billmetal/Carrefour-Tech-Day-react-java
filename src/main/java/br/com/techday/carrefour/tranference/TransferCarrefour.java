package br.com.techday.carrefour.tranference;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.techday.carrefour.modelDTO.RegionResponse;

/**
 * @summary Tratamento das APIs do Carrefour
 * 
 * @author Willian K.
 * 
 * @apiNote Classe que consome as apis do carrefour .
 * 
 * @implSpec Foi usado WebClient para requisição nas apis do carrefour.
 * 
 * **/
@Component
public class TransferCarrefour implements ApiTransference{
	
	/**
	 * 
	 * @implNote end points das APIs carrefour
	 * 
	 * **/
	private String urlSellers = "checkout/pub/regions?country=BRA&postalCode=";
	private String urlProducts = "catalog_system/pub/products/search?fq=";
	
	/**
	 * 
	 * @implNote Objeto que consome as APIs carrefour
	 * 
	 * **/
	private final WebClient client;
	
	/**
	 * 
	 * @implNote Construtor da classe que recebe um construtor que criará uma instância client do
	 * tipo WebClient
	 * 
	 * @param builder : construtor para o objeto client do tipo WebClient
	 * 
	 * **/
	public TransferCarrefour(WebClient.Builder builder) {
		this.client = builder.baseUrl("https://mercado.carrefour.com.br/api/").build();
	}


	/**
	 * 
	 * @implNote Método que executa uma requisição GET com o cep fornecido no link
	 * 
	 * @param cep : uma String contendo um cep
	 * 
	 * @return RegionResponse[] : retorna um array com objetos do tipo RegionResponse contendo
	 * as lojas mais próximas
	 * 
	 * **/
	@Override
	public RegionResponse[] sellers(String cep) {
		return client
				.get()
				.uri(urlSellers+cep)
				.retrieve()
				.bodyToMono(RegionResponse[].class).block();
	}


	/**
	 * 
	 * @implNote Método que executa uma requisição GET com a loja mais próxima no link
	 * 
	 * @param seller : uma String contendo o nome da loja mais próxima
	 * 
	 * @return String : retorna um Json com informações dos produtos no tipo String
	 * 
	 * **/
	@Override
	public String products(String seller) {
		return client
				.get()
				.uri(urlProducts+seller)
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}
	

}

