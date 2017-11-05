package org.manoj.javaminds.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.manoj.javaminds.dao.BooksDAO;
import org.manoj.javaminds.entity.Author;
import org.manoj.javaminds.entity.Books;
import org.manoj.javaminds.utils.HibernateUtils;

public class BooksDAOImpl implements BooksDAO{

	@Override
	public void addBooks(Books book) {
		
		Session session = null;
		Transaction tx= null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
		
	}

	@Override
	public List<Books> getBooks(List<Integer> bookIds) {
		// TODO Auto-generated method stub
		return null;
	}


}
