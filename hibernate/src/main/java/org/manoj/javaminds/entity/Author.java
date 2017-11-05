package org.manoj.javaminds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AUTHOR")
@Table(name = "AUTHOR")
public class Author {
	
	public Author() {
		
	}
	
	public Author(String authorName, String authorEmail) {
		super();
		this.authorName = authorName;
		this.authorEmail = authorEmail;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTHOR_ID")
	private Integer authorId;

	@Column(name = "NAME")
	private String authorName;

	@Column(name = "EMAIL")
	private String authorEmail;

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

}
