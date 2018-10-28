package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
	public static final Logger logger = Logger.getLogger(InvitationDaoImpl.class);
	
	public InvitationDaoImpl () {
		invites = null;
	}
	
	//a boolean value is return if an invite has been accepted
	public boolean acceptInvite(Invitation i) {
		logger.info("In Accept Invite");
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		boolean result = false;
		
		try {
			//using session persist , accepted flag is set to true
			logger.debug("Using session persist,event's accepted flag is set to true");
			t = s.beginTransaction();
			s.persist(i);
			i.setAcceptFlag(1);
			t.commit();
			result = true;
		}
		catch (Exception e) {
			logger.error("Exception is found in transaction");
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}

	//A boolean value is return if an invite has been accepted using invitation id
	public boolean acceptInvite(int id) {
		logger.info("In Accept Invite using invitation id");
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		boolean result = false;
		
		try {
			//invitation accepted flas is set to true
			logger.debug("Using session persist, invitation's accepted flag set to true");
			t = s.beginTransaction();
			Invitation inv = (Invitation) s.get(Invitation.class, id);
			inv.setAcceptFlag(1);
			t.commit();
			result = true;
		}
		catch (Exception e) {
			logger.error("Exception is found in transaction");
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}
	
	//Primary Criteria. Returns invitations from database.
	public Invitation selectInvitationById(int id) {
		logger.info("Select Invitation By ID");
		Invitation inv = null;
		Session s = HibernateUtil.getSession();
		
		try {
			//using criteria, returns invitation using invitation id
			logger.debug("Using criteria, invitation is return using invitition id");
			Criteria c = s.createCriteria(Invitation.class);
			c.add(Restrictions.like("id", id));
			inv = (Invitation) c.uniqueResult();
		}
		catch (Exception e){
			logger.error("Exception is found in transaction");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return inv;
	}
	
	//A list of all invitations is returned
	@SuppressWarnings("unchecked")
	public List<Invitation> selectAllInvitations() {
		logger.info("In Select All Invitations");
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			//returns a list of invitation
			logger.debug("Using query, a list of invitation is returned");
			invites = (List<Invitation>) s.createQuery("FROM Invitation").list();
		}
		catch (Exception e){
			logger.error("Exception is found in transaction");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return invites;
	}
	
	//A list of invitation for a account is returned
	@SuppressWarnings("unchecked")
	public List<Invitation> selectAllInvitesByAcc(Account acc){
		logger.info("In Select All Invites By ACC" );
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			// a list of invitation for a specific account is return 
			logger.debug("Using criteria, a list of invitation for a account is return");
			Criteria c = s.createCriteria(Invitation.class);
			c.add(Restrictions.like("acc", acc));
			invites = (List<Invitation>) c.list();
		}
		catch (Exception e){
			logger.error("Exception is found in transaction");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return invites;
	}
	
	//a list of events is return for a account
	public List<Event> selectAllEventsByAcc(Account acc){
		logger.info("In Select All Events By Account");
		invites = selectAllInvitesByAcc(acc);
		List<Event> events = new ArrayList<Event>();
		
		for (Invitation invite : invites) {
			events.add(invite.getEv());
		}
		
		return events;
	}
	
	//A list of invitation is return for a specific event
	@SuppressWarnings("unchecked")
	public List<Invitation> selectAllInvitesByEv(Event ev){
		logger.info("In select All invites by Ev");
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			//using criteria a list of invitation is return
			logger.debug("A list of invitation is return using criteria");
			Criteria c = s.createCriteria(Invitation.class);
			c.add(Restrictions.like("ev", ev));
			invites = (List<Invitation>) c.list();
		}
		catch (Exception e){
			logger.error("Exception is found in transaction");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return invites;
	}
	
	//Secondary Criteria, expect already get through a primary search.
	public List<Invitation> selectAllAcceptInvites(){
		logger.info("Select ALl Accept Invites");
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
	
	//A list of pending invitation is returned
	public List<Invitation> selectAllPendingInvites(){
		logger.info("In select All pending invites");
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
	
	//A list of invites 
	public List<Invitation> selectAllPrivInvites(){
		logger.info("In Select All Priv Invites");
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
	
	//An invitation is created and returns invitation id
	public Integer insertInvitation(Invitation inv) {
		logger.info("In insert Invitation");
		Integer result = null;
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		
		try {
			//Invitation is stored in database
			logger.debug("An invitation is stored in db using session save");
			t = s.beginTransaction();
			result = (Integer) s.save(inv);
			t.commit();
		}
		catch (Exception e) {
			logger.error("Exception is found in transaction");
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}
	
	//A invitation is deleted using event id
	public void deleteInvitationById(int id) {
		logger.info("In delete Event by ID");
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		
		try {
			//invitation is deleted from the database
			logger.debug("Invitation is deleted using session delete");
			t = s.beginTransaction();
			Invitation inv = (Invitation) s.load(Invitation.class, id);
			s.delete(inv);
			t.commit();
		}
		catch (Exception e) {
			logger.error("Exception is found in transaction");
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
	}
}
