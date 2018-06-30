package ModalClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Chat 
{
	//---------------------primary properties-------------------//
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="chat_id")
	private int chatId;
	private Boolean isBroadcast;

	//-----------------------mapped properties-------------------//
	@OneToMany(mappedBy="chat",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Message> messages = new ArrayList<Message>();

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PARTICIPANTS")
	private Set<CommunityMember> participants = new HashSet<CommunityMember>();
	
	//---------------------------getters and setters-------------------------------//
	public Set<CommunityMember> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<CommunityMember> participants) {
		this.participants = participants;
	}
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public Collection<Message> getMessages() {
		return messages;
	}
	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}
	public Boolean getIsBroadcast() {
		return isBroadcast;
	}
	public void setIsBroadcast(Boolean isBroadcast) {
		this.isBroadcast = isBroadcast;
	}
	@Override
	public String toString() {
		List<Integer> mids = new ArrayList<Integer>();
		for(Message m : messages)
			mids.add(m.getMsgId());
		List<Integer> pids = new ArrayList<Integer>();
		for(CommunityMember c : participants)
			pids.add(c.getId());
		return "Chat [chatId=" + chatId + ", participants=" + pids +  ", isBroadcast=" + isBroadcast
				+ ", messages=" + mids + "]";
	}
	
	
	

}
