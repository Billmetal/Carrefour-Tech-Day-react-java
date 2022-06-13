package br.com.techday.carrefour.tranference;

import br.com.techday.carrefour.modelDTO.RegionResponse;

/**
 * @summary Métodos para o Componente TransferCarrefour
 * 
 * @author Willian K.
 * 
 * @apiNote Interface com os métodos para tratamento das APIs carrefour.
 * 
 * 
 * **/
public interface ApiTransference {

	RegionResponse[] sellers(String cep);
	
	String products(String seller);
}
