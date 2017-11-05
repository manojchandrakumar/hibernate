package org.manoj.javaminds.dao;

import java.util.List;

import org.manoj.javaminds.entity.Books;

public interface BooksDAO {
	
	public void addBooks(Books book);

	public List<Books> getBooks(List<Integer> bookIds);
}
