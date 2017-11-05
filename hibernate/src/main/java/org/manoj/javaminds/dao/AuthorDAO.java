package org.manoj.javaminds.dao;

import java.util.List;

import org.manoj.javaminds.entity.Author;

public interface AuthorDAO {
	
	public void addAuthor(Author author);
	
	public List<Author> getAuthors(List<Integer> authorIds);
	
}
