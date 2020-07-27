package com.codingdojo.mvc.models;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subject;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "tags_questions", 
			joinColumns = @JoinColumn(name = "tag_id"), 
			inverseJoinColumns = @JoinColumn(name = "question_id")
			)
	private List<Question> question;

	public Tag() {

	}

	public Tag(String subject) {
		this.subject = subject;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String name) {
		this.subject = name;
	}
	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}
