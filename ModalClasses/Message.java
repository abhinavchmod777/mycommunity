package ModalClasses;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message 
{
	//------------------primary properties-------------------------//
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="msg_id")
	private int msgId;
	
	
	//------------------mapped properties-------------------------//
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CHAT_ID")
	private Chat chat;
	
	@OneToOne
	@JoinColumn(name="CONTENT")
	private Content content;

	// will be set manually as sender = chat.getUser1(); or receiver = chat,getUser2(); 
	@ManyToOne
	@JoinColumn(name="sender")
	private CommunityMember sender;

	@ManyToOne
	@JoinColumn(name="receiver")
	private CommunityMember receiver;


	//-------------------getters and setters----------------------//
	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public CommunityMember getSender() {
		return sender;
	}

	public void setSender(CommunityMember sender) {
		this.sender = sender;
	}

	public CommunityMember getReceiver() {
		return receiver;
	}

	public void setReceiver(CommunityMember receiver) {
		this.receiver = receiver;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	
	
}
