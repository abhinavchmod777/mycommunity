package ModalClasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Community {

//------------------primary properties---------------------//	
	@Id
	private int communityId;
	@Column(name="community_name")
	private String communityName;
	private String description;
	@Enumerated(EnumType.STRING)
	private PrivatePublic status;

//------------mapped properties---------------------------//
	@ManyToMany(mappedBy="communities",cascade=CascadeType.ALL)
	private Set<RmeUser> members = new HashSet<RmeUser>();
	
	@OneToMany(mappedBy="community",cascade=CascadeType.ALL)
	private Set<Invite> invites = new HashSet<Invite>();
	
	
//------------------------getters and setters-------------//
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PrivatePublic getStatus() {
		return status;
	}
	public void setStatus(PrivatePublic status) {
		this.status = status;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public Set<RmeUser> getMembers() {
		return members;
	}
	public void setMembers(Set<RmeUser> members) {
		this.members = members;
	}
	public Set<Invite> getInvites() {
		return invites;
	}
	public void setInvites(Set<Invite> invites) {
		this.invites = invites;
	}	@Override
	public String toString() {
		List<Integer> mids = new ArrayList<Integer>();
		for(RmeUser r : members)
			mids.add(r.getUserId());
		return "Community [" + communityId + ", "+ communityName + ", " + description + ", " + status + ", memberIDs=" + mids + "]";
	}
	
	
}
