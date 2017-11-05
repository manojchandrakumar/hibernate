package org.manoj.javaminds.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.manoj.javaminds.dao.ShoppingDAO;
import org.manoj.javaminds.entity.Cart;
import org.manoj.javaminds.entity.Items;
import org.manoj.javaminds.utils.HibernateUtils;

public class ShoppingDAOImpl implements ShoppingDAO {

	@Override
	public void addItemsToCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(cart);
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
	public void addItems(List<Items> items) {
		// TODO Auto-generated method stub

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			for(Items item : items) {
				session.save(item);
			}
			tx.commit();	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

}
