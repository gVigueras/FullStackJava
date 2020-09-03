package com.codingdojo.mvc.models;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue()
	private Long id;
	@Size(min=2, max=100)
	private String firstName;
	@Size(min=2, max=100)
	private String lastName;
	@Email
	private String email;
	@Size(min=2, max=150)
	private String city;
	@Size(min=2, max=100)
	private String region;
	@Size(min=8)
	private String password;
	@Transient
	private String passwordConfirmation;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Comment> comments;
	@OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	private List<Event> myEvents;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "guests_events", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "event_id")
			)
	private List<Event> events;

	public User() {

	}
	public User(String nombre, String apellido, String correo, String ciudad, String sector, String contraseña, String confirmacion, List<Comment> comentarios, List<Event> misEventos, List<Event> eventos) {
		this.firstName = nombre;
		this.lastName = apellido;
		this.email = correo;
		this.city = ciudad;
		this.region = sector;
		this.password = contraseña;
		this.passwordConfirmation = confirmacion;
		this.comments = comentarios;
		this.myEvents = misEventos;
		this.events = eventos;

	}
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Comment> getComents() {
		return comments;
	}
	public void setComents(List<Comment> coments) {
		this.comments = coments;
	}
	public List<Event> getMyEvents() {
		return myEvents;
	}
	public void setMyEvents(List<Event> myEvents) {
		this.myEvents = myEvents;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
}