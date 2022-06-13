package br.com.techday.carrefour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import br.com.techday.carrefour.modelDTO.Products;
import br.com.techday.carrefour.modelDTO.RegionResponse;
import br.com.techday.carrefour.modelDTO.SellerResponse;
import br.com.techday.carrefour.tranference.TransferCarrefour;

/**
 * @summary Classe de Serviço
 * 
 * @author Willian K.
 * 
 * @apiNote Classe que recebe as informações obtidas pelas apis do carrefour e modela 
 * para retornar ao frontend .
 * 
 * **/
@Service
public class ApiService {
	
	/**
	 * 
	 * @implNote Auto implementa uma instancia do componente TransferCarrefour.
	 * 
	 * **/
	@Autowired
	private TransferCarrefour transfer;
	
	/**
	 * 
	 * @implNote Método que retorna uma lista com produtos da loja mais próxima .
	 * 
	 * @param cep : String com um cep para busca
	 * 
	 * @return List<Products> uma lista com produtos da loja mais próxima .
	 * 
	 * **/
	public List<Products> getProducts(String cep) {		
			try {
				JSONArray json = new JSONArray(getSellerName(cep));
				List<Products> products = new ArrayList<Products>();
				for (int i = 0; i < json.length(); i++) {
					JSONObject obj = json.getJSONObject(i);
					JSONObject items01 = obj.getJSONArray("items").getJSONObject(0);
					products.add(Products.builder()
						.productId(obj.getString("productId"))
						.productName(obj.getString("productName"))
						.brand(obj.getString("brand"))
						.category(formatCategory(obj.getJSONArray("categories").getString(1)))
						.link(obj.getString("link"))
						.imageUrl(items01.getJSONArray("images").getJSONObject(0).getString("imageUrl"))
						.addToCartLink(items01.getJSONArray("sellers").getJSONObject(0).getString("addToCartLink"))
						.price(formatPrice(items01.getJSONArray("sellers").getJSONObject(0).getJSONObject("commertialOffer").getDouble("Price")))
						.isAvailable(items01.getJSONArray("sellers").getJSONObject(0).getJSONObject("commertialOffer").getBoolean("IsAvailable"))
						.build());
				}
				return products;
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	/**
	 * 
	 * @implNote Método que recebe uma lista com o nome das lojas e retorna a mais próxima .
	 * 
	 * @param cep : String com um cep para busca
	 * 
	 * @return String com o nome da loja
	 * 
	 * **/
	private String getSellerName(String cep) {
		RegionResponse[] regions = transfer.sellers(cep);
		RegionResponse region = regions[0];
		SellerResponse seller = region.getSellers().get(0);
		return transfer.products(seller.getName());
	}
	
	/**
	 * 
	 * @implNote Método que formata uma categoria recebida pela api carrefour .
	 * 
	 * @param category : recebe uma categoria em formato pastas (Ex. "/categoria/informação/")
	 * 
	 * @return String com uma categoria
	 * 
	 * **/
	private String formatCategory(String category) {
		String[] cat = category.split("/");
		return cat[1];
	}

	/**
	 * 
	 * @implNote Método que formata um objeto double em uma String em formato monetário
	 * (Ex. R$ 00,00).
	 * 
	 * @param price : double contendo um preço
	 * 
	 * @return String com um valor em formato monetário
	 * 
	 * **/
	private String formatPrice(double price) {
		return "R$ "+String.valueOf(price).replace(".",",");
	}
}
