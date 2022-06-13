package br.com.techday.carrefour.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @summary Modelo de dados dos produtos
 * 
 * @author Willian K.
 * 
 * @apiNote Classe que representa as informações dos produtos para o retorno da API.
 * 
 * @implSpec Foi usado as anotações Data,Builder,AllArgsConstructor,NoArgsConstructor para o 
 * constructor  , Getters e Setters serem criados pelo Lombok .
 * 
 * **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Products {

	private String productId;
	
	private String productName;
	
	private String brand;
	
	private String category;
	
	private String link;
		
	private String imageUrl;
	
	private String addToCartLink;
	
	private String price;
	
	private boolean isAvailable;
	
}
