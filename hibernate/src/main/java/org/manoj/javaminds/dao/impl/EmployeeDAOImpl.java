package org.manoj.javaminds.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.manoj.javaminds.dao.EmployeeDAO;
import org.manoj.javaminds.entity.ContractEmployee;
import org.manoj.javaminds.entity.Employee;
import org.manoj.javaminds.entity.RegularEmployee;
import org.manoj.javaminds.utils.HibernateUtils;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public void addEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void addRegularEmployee(RegularEmployee regEmp) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(regEmp);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void addCtrctEmployee(ContractEmployee ctrctEmp) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(ctrctEmp);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
	}

}
