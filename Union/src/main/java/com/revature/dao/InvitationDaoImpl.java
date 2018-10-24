package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Invitation;
import com.revature.util.HibernateUtil;

public class InvitationDaoImpl {
	private List<Invitation> invites;
	
	public InvitationDaoImpl () {
		invites = null;
	}
	
	//Primary Criteria. Returns invitations from database.
	
	public List<Invitation> getAllInvitations() {
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			invites = (List<Invitation>) s.createQuery("FROM invitation").list();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return invites;
	}
	
	public List<Invitation> getAllInvitesByAccId(int id){
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Invitation.class);
			c.add(Restrictions.like("acc_id", id));
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
	
	public List<Invitation> getAllInvitesByEvId(int id){
		invites = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Invitation.class);
			c.add(Restrictions.like("ev_id", id));
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
	
	public List<Invitation> getAllAcceptInvites(){
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
	
	public List<Invitation> getAllPrivInvites(){
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
}
