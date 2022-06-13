package br.com.techday.carrefour.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @summary Modelo das lojas
 * 
 * @author Willian K.
 * 
 * @apiNote Classe que repressenta as informações das lojas retornadas pela api do carrefour .
 * 
 * @implSpec Foi usado as anotações Data,Builder,AllArgsConstructor,NoArgsConstructor para o 
 * constructor  , Getters e Setters serem criados pelo Lombok .
 * 
 * **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerResponse {

	private String id;
	
	private String name;
}
