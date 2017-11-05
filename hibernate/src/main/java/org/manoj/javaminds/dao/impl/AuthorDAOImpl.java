package org.manoj.javaminds.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.manoj.javaminds.dao.AuthorDAO;
import org.manoj.javaminds.entity.Author;
import org.manoj.javaminds.utils.HibernateUtils;

public class AuthorDAOImpl implements AuthorDAO {

	@Override
	public void addAuthor(Author author) {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(author);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public List<Author> getAuthors(List<Integer> authorIds) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Author> authorsList = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			for(Integer authorId : authorIds) {
				Author author = new Author();
				author = (Author) session.get(Author.class, authorId);
				authorsList = new ArrayList<>();
				authorsList.add(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return authorsList;
	}

}
