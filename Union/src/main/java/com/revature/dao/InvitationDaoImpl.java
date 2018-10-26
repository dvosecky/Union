package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.beans.Invitation;
import com.revature.util.HibernateUtil;

public class InvitationDaoImpl {
	private List<Invitation> invites;
	
	public InvitationDaoImpl () {
		invites = null;
	}
	
	public boolean acceptInviteById(int inv_id) {
		Session s = HibernateUtil.getSession();
		
		try {
			
		}
		catch (Exception e) {
			
		}
		finally {
			
		}
		
		return false;
	}
	
	public boolean acceptInvite(Invitation i) {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		boolean result = false;
		
		try {
			t = s.beginTransaction();
			s.persist(i);
			i.setAcceptFlag(1);
			t.commit();
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}
	
	//Primary Criteria. Returns invitations from database.
	
	@SuppressWarnings("unchecked")
	public List<Invitation> selectAllInvitations() {
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			invites = (List<Invitation>) s.createQuery("FROM Invitation").list();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return invites;
	}
	
	@SuppressWarnings("unchecked")
	public List<Invitation> selectAllInvitesByAcc(Account acc){
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Invitation.class);
			c.add(Restrictions.like("acc", acc));
			invites = (List<Invitation>) c.list();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return invites;
	}
	
	public List<Event> selectAllEventsByAcc(Account acc){
		invites = selectAllInvitesByAcc(acc);
		List<Event> events = new ArrayList<Event>();
		
		for (Invitation invite : invites) {
			events.add(invite.getEv());
		}
		
		return events;
	}
	
	@SuppressWarnings("unchecked")
	public List<Invitation> selectAllInvitesByEv(Event ev){
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Invitation.class);
			c.add(Restrictions.like("ev", ev));
			invites = (List<Invitation>) c.list();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return invites;
	}
	
	//Secondary Criteria, expect already get through a primary search.
	
	public List<Invitation> selectAllAcceptInvites(){
		if (invites != null) {
			for (int i = 0; i < invites.size(); i++) {
				if (invites.get(i).getAcceptFlag() != 1) {
					invites.remove(i);
					i--;
				}
			}
		}
		return invites;
	}
	
	public List<Invitation> selectAllPendingInvites(){
		if (invites != null) {
			for (int i = 0; i < invites.size(); i++) {
				if (invites.get(i).getAcceptFlag() != 1) {
					invites.remove(i);
					i--;
				}
			}
		}
		return invites;
	}
	
	public List<Invitation> selectAllPrivInvites(){
		if (invites != null) {
			for (int i = 0; i < invites.size(); i++) {
				if (invites.get(i).getPrivilegeFlag() != 1) {
					invites.remove(i);
					i--;
				}
			}
		}
		return invites;
	}
	
	//ADD
	
	public Integer insertInvitation(Invitation inv) {
		Integer result = null;
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		
		try {
			t = s.beginTransaction();
			result = (Integer) s.save(inv);
			t.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}
	
	//DELETE
	
	public void deleteInvitationById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		
		try {
			t = s.beginTransaction();
			Invitation i = (Invitation) s.load(Invitation.class, id);
			s.delete(i);
			t.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
	}
}
