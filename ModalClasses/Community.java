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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ModalClasses.Enums.PrivatePublic;


@Entity
public class Community {

//------------------primary properties---------------------//	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int communityId;
	@Column(name="community_name")
	private String communityName;
	private String description;
	@Enumerated(EnumType.STRING)
	private PrivatePublic status;

//------------mapped properties---------------------------//
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<RmeUser> members = new HashSet<RmeUser>();
	
	@OneToMany(mappedBy="community",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Invite> invites = new HashSet<Invite>();
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="community_chat")
	private Chat communityChat;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id")
	private RmeUser admin;
	
	
//------------------------getters and setters-------------//
	public int getCommunityId() {
		return communityId;
	}
	public Chat getCommunityChat() {
		return communityChat;
	}
	public void setCommunityChat(Chat communityChat) {
		this.communityChat = communityChat;
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
	}	
	
	public RmeUser getAdmin() {
		return admin;
	}
	public void setAdmin(RmeUser adminId) {
		this.admin = adminId;
	}
	@Override
	public String toString() {
		List<Integer> mids = new ArrayList<Integer>();
		for(RmeUser r : members)
			mids.add(r.getUserId());
		return "Community [" + communityId + ", "+ communityName + ", " + description + ", " + status + ", memberIDs=" + mids + "]";
	}
	
	
}
