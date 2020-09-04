package com.codingdojo.mvc.models;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;


@Entity
@Table(name="countries")
public class Country{

	@Id
	private int id;
	@Nullable
	private Integer capital;
	@Nullable
	private String code;
	@Nullable
	private String code2;
	@Nullable
	private String continent;
	@Nullable
	private Double gnp;

	@Column(name="gnp_old")
	private Double gnpOld;

	@Column(name="government_form")
	private String governmentForm;

	@Column(name="head_of_state")
	private String headOfState;

	@Column(name="indep_year")
	private String indepYear;

	@Column(name="life_expectancy")
	private Double lifeExpectancy;

	@Column(name="local_name")
	private String localName;
	@Nullable
	private String name;
	@Nullable
	private Integer population;
	@Nullable
	private String region;

	@Column(name="surface_area")
	private Double surfaceArea;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<City> cities;

	//bi-directional many-to-one association to Language
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<Language> languages;

	public Country() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Integer getCapital() {
		return this.capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode2() {
		return this.code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getContinent() {
		return this.continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Double getGnp() {
		return this.gnp;
	}

	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}

	public Double getGnpOld() {
		return this.gnpOld;
	}

	public void setGnpOld(Double gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getGovernmentForm() {
		return this.governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return this.headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public String getIndepYear() {
		return this.indepYear;
	}

	public void setIndepYear(String indepYear) {
		this.indepYear = indepYear;
	}

	public Double getLifeExpectancy() {
		return this.lifeExpectancy;
	}

	public void setLifeExpectancy(Double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public String getLocalName() {
		return this.localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulation() {
		return this.population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getSurfaceArea() {
		return this.surfaceArea;
	}

	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setCountry(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setCountry(null);

		return city;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Language addLanguage(Language language) {
		getLanguages().add(language);
		language.setCountry(this);

		return language;
	}

	public Language removeLanguage(Language language) {
		getLanguages().remove(language);
		language.setCountry(null);

		return language;
	}

}