package ModalClasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RMEUser")
public class RmeUser {

//------------------primary properties-----------------//	
	@Id
	@Column(name="user_id")
	private int userId;
	private String userName;

//-------------------mapped properties-----------------//	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Community> communities = new HashSet<Community>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private Set<Invite> invites = new HashSet<Invite>();

//-----------------------getters and setters-------------//	
	public Set<Community> getCommunities() {
		return communities;
	}
	public void setCommunities(Set<Community> communities) {
		this.communities = communities;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		List<Integer> cids = new ArrayList<Integer>();
		for(Community r : communities)
			cids.add(r.getCommunityId());
		return "RmeUser [" + userId + ", " + userName + ", communityIds=" + cids + "]";
	}
	

	
}

