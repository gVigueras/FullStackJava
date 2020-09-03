package com.codingdojo.mvc.models;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue()
	private Long id;
	@Size(min=1, max=255)
	private String name;
	@NotNull
	@DateTimeFormat(pattern = "dd-MMMM-yyyy")
	private Date date;
	@Size(min=2, max=150)
	private String city;
	@Size(min=2, max=100)
	private String region;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	private List<Comment> comments;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="host_id")
	private User host;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "guests_events", 
			joinColumns = @JoinColumn(name = "event_id"), 
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> guests;

	public Event () {

	}
	public Event (String nombre, Date fecha, String ciudad, String region) {
		this.name = nombre;
		this.date = fecha;
		this.city = ciudad;
		this.region = region;
	}
	public Event (String nombre, Date fecha, String ciudad, String region, List<Comment> comentarios, User anfitrion, List<User> invitado) {
		this.name = nombre;
		this.date = fecha;
		this.city = ciudad;
		this.region = region;
		this.comments = comentarios;
		this.host = anfitrion;
		this.guests = invitado;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}
	public List<User> getGuests() {
		return guests;
	}
	public void setGuests(List<User> guests) {
		this.guests = guests;
	}
}