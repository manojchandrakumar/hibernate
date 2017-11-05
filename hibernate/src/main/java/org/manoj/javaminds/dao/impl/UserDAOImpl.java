package org.manoj.javaminds.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.manoj.javaminds.dao.UserDAO;
import org.manoj.javaminds.entity.Address;
import org.manoj.javaminds.entity.UserDetails;
import org.manoj.javaminds.utils.HibernateUtils;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUserDetails(UserDetails userDetails) throws Exception {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(userDetails);
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
	public UserDetails getUserDetails(Integer userId) throws Exception {

		Session session = null;
		Transaction tx = null;
		UserDetails userDetails = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			userDetails = (UserDetails) session.get(UserDetails.class, userId);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return userDetails;
	}
}
