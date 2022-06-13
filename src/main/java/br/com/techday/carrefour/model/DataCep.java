package br.com.techday.carrefour.model;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @summary Modelo de request
 * 
 * @author Willian K.
 * 
 * @apiNote Classe que representa o body do request da API.
 * 
 * @implSpec Foi usado as anotações Data,Builder,AllArgsConstructor,NoArgsConstructor para o 
 * constructor  , Getters e Setters serem criados pelo Lombok .
 * 
 * **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataCep {

	@Size(min = 8, max = 9,message = "Formato do cep inválido !")
	private String cep;
}
