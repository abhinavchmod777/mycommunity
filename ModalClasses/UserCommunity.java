package ModalClasses;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserCommunity 
{
	@OneToOne
	@JoinColumn(name="user_id")
	private RmeUser userId;
	
	@OneToOne
	@JoinColumn(name="community_id")
	private Community communityId;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	
//---------------getters and setters-----------------//

	public RmeUser getUserId() {
		return userId;
	}

	public void setUserId(RmeUser userId) {
		this.userId = userId;
	}

	public Community getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Community communityId) {
		this.communityId = communityId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserCommunity [userId=" + userId.getUserId() + ", communityId=" + communityId.getCommunityId() + ", role=" + role + "]";
	}
	
	

}
