package com.formationkilo.security.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formationkilo.security.config.HibernateUtil;
import com.formationkilo.security.entities.AppRole;

public class AppRoleImpl implements IAppRole{

	private Session session;
	private Transaction transaction;
	
	
	public AppRoleImpl() {
		session=HibernateUtil.getSessionFactory().openSession();
	}

	public int save(AppRole appRole) {
		try {
			transaction =session.beginTransaction();
			session.save(appRole);
			transaction.commit();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public AppRole get(int id) {
		try {
			return session.get(AppRole.class, id);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
	     }	
	}

	public int update(AppRole appRole) {
		try {
			transaction=session.beginTransaction();
			session.merge(appRole);
			transaction.commit();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int remove(int id) {
		try {
			transaction=session.beginTransaction();
			//session.delete(session.get(AppRole.class, id));
			session.delete(get(id));
			transaction.commit();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
	     }	
	}

	@SuppressWarnings("unchecked")
	public List<AppRole> getAll() {
		try {
		
			return session.createQuery("select role from AppRole role").getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
	     }	
	}

}
