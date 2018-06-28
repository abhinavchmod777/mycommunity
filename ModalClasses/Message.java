package ModalClasses;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message 
{
	//------------------primary properties-------------------------//
	@Id
	@Column(name="msg_id")
	private int msgId;
	
	//------------------mapped properties-------------------------//
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CHAT_ID")
	private Chat chat;
	
}
