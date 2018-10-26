package com.revature.dto;

import com.revature.beans.Invitation;

public class InvitationDTO {
	private Integer id;
	private Integer acc_id;
	private Integer ev_id;
	private Integer privelegeFlag;
	private Integer acceptFlag;
	
	public InvitationDTO() {
		super();
	}
	
	public InvitationDTO(Invitation i) {
		id = i.getId();
		acc_id = i.getAcc().getId();
		ev_id = i.getEv().getId();
		privelegeFlag = i.getPrivilegeFlag();
		acceptFlag = i.getAcceptFlag();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}

	public Integer getEv_id() {
		return ev_id;
	}

	public void setEv_id(Integer ev_id) {
		this.ev_id = ev_id;
	}

	public Integer getPrivelegeFlag() {
		return privelegeFlag;
	}

	public void setPrivelegeFlag(Integer privelegeFlag) {
		this.privelegeFlag = privelegeFlag;
	}

	public Integer getAcceptFlag() {
		return acceptFlag;
	}

	public void setAcceptFlag(Integer acceptFlag) {
		this.acceptFlag = acceptFlag;
	}

	@Override
	public String toString() {
		return "InvitationDTO [id=" + id + ", acc_id=" + acc_id + ", ev_id=" + ev_id + ", privelegeFlag="
				+ privelegeFlag + ", acceptFlag=" + acceptFlag + "]";
	}
}
