package ModalClasses;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Invite {

//----------------primary properties----------------//	
	@Id
	@Column(name="invitation_id")
	private int invitationId;
	private boolean added;
	private Status status;
	
//------------------------------mapped properties------------------//
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="community_id")
	private Community community;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private RmeUser user;
	
//--------------------getters and setters--------------//	
	public int getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(int invitationId) {
		this.invitationId = invitationId;
	}
	public boolean isAdded() {
		return added;
	}
	public void setAdded(boolean added) {
		this.added = added;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Community getCommunity() {
		return community;
	}
	public void setCommunity(Community community) {
		this.community = community;
	}
	public RmeUser getUser() {
		return user;
	}
	public void setUser(RmeUser user) {
		this.user = user;
	}
	
	
}
