package ModalClasses;

import javax.persistence.CascadeType;

@Entity
public class Chat 
{
	//---------------------primary properties-------------------//
	@Id
	@Column(name="chat_id")
	private int chatId;
	
	//-----------------------mapped properties-------------------//
	@OneToMany(mappedBy="chat",cascade=CascadeType.ALL)
	private Collection<Message> messages = 
	
	

}
