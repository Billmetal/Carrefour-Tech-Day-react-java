package br.com.techday.carrefour.modelDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @summary Modelo de retorno
 * 
 * @author Willian K.
 * 
 * @apiNote Esta classe representa o retorno que será consumido
 * no Frontend.
 * 
 * @implSpec Foi usado as anotações Data,Builder,AllArgsConstructor,NoArgsConstructor para o 
 * constructor  , Getters e Setters serem criados pelo Lombok .
 * 
 * **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToFrontEnd {

	private List<Products> products;
	
	private String messageError; 
}
