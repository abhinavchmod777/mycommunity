package ModalClasses;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import ModalClasses.Enums.Role;

@Entity
public class CommunityMember 
{
//---------------------primary properties------------//	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Enumerated(EnumType.STRING)
	private Role role;

//-----------------------mapped--------------------//	
	@ManyToOne
	@JoinColumn(name="user_id")
	private RmeUser user;
	
	@ManyToOne
	@JoinColumn(name="community_id")
	private Community community;

	@ManyToMany(mappedBy="participants")
	private Set<Chat> chats = new HashSet<Chat>();

//----------------------getters and setters------------------//	
	public int getId() {
		return id;
	}

	public Set<Chat> getChats() {
		return chats;
	}

	public void setChats(Set<Chat> chats) {
		this.chats = chats;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RmeUser getUser() {
		return user;
	}

	public void setUser(RmeUser userId) {
		this.user = userId;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community communityId) {
		this.community = communityId;
	}
	


}
