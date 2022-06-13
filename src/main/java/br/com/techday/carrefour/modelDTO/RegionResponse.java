package br.com.techday.carrefour.modelDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @summary Modelo para consumo da API do carrefour
 * 
 * @author Willian K.
 * 
 * @apiNote Classe para receber as informações da api do carrefour com as lojas mais próximas.
 * 
 * @implSpec Foi usado as anotações Data,Builder,AllArgsConstructor,NoArgsConstructor para o 
 * constructor  , Getters e Setters serem criados pelo Lombok .
 * 
 * **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionResponse {

	private String id;
	
	private List<SellerResponse> sellers;
	
}
