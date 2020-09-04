package com.codingdojo.mvc.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Country;
import com.codingdojo.mvc.repositories.CountriesRepository;

@Service
public class ApiService {
	private final CountriesRepository CountryRepo;

	public ApiService(CountriesRepository b) {
		this.CountryRepo = b;
	}
	public List<Country> primerConsulta(){
		return CountryRepo.joinCountryAndLanguage1();
	}
	public List<Country> segundaConsulta(){
		return CountryRepo.joinCountryAndCity2();
	}
	public Country terceraConsulta(){
		return CountryRepo.joinCountryAndCity3();
	}
	public List<Country> cuartaConsulta(){
		return CountryRepo.joinCountryAndLanguage4();
	}
	public List<Country> quintaConsulta(){
		return CountryRepo.Country5();
	}
	public List<Country> sextaConsulta(){
		return CountryRepo.Country6();
	}
	public Country septimaConsulta(){
		return CountryRepo.joinCountryAndCity7();
	}
	public List<Object[]> octavaConsulta(){
		List<Object[]> table = CountryRepo.Country8();
		for(Object[] row : table) {
			System.out.println(row[1]);
		}
		return table;
	}
}