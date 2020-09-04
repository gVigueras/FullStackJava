package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Country;

@Repository
public interface CountriesRepository extends CrudRepository<Country, Long>{
	
	@Query("select c from Country c JOIN c.languages l WHERE language = 'Slovene' ORDER BY percentage DESC")
    List<Country> joinCountryAndLanguage1();
	
	@Query(value="select c from Country c JOIN c.cities l GROUP BY l.country ORDER BY COUNT(l) DESC ")
    List<Country> joinCountryAndCity2();
	
	@Query(value="select c from Country c JOIN c.cities l WHERE c.name = 'Mexico' and l.population > 500000 ORDER BY l.population DESC")
    Country joinCountryAndCity3();
	
	@Query("select c from Country c JOIN c.languages l WHERE percentage > 89 ORDER BY percentage DESC")
    List<Country> joinCountryAndLanguage4();
	
	@Query("select c from Country c WHERE surfaceArea < 501 and population > 100000")
    List<Country> Country5();
	
	@Query("select c from Country c WHERE governmentForm = 'Constitutional Monarchy' and capital > 200 and lifeExpectancy > 75")
    List<Country> Country6();
	
	@Query(value="select c from Country c JOIN c.cities l WHERE l.district = 'Buenos Aires' and l.population > 500000")
    Country joinCountryAndCity7();
	
	@Query(value="select c.region as name, COUNT(c.name) as cantidad from Country c group by c.region ORDER BY COUNT(c.name) DESC")
	List<Object[]> Country8();
}
