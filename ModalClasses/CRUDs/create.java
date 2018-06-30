package ModalClasses.CRUDs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ModalClasses.Chat;
import ModalClasses.Community;
import ModalClasses.CommunityMember;
import ModalClasses.Content;
import ModalClasses.Invite;
import ModalClasses.Message;
import ModalClasses.RmeUser;
import ModalClasses.Enums.PrivatePublic;
import ModalClasses.Enums.Role;



public class create {

	public static void main(String[] args)
	{
		Configuration con = new Configuration().configure();
		con.addAnnotatedClass(RmeUser.class);
		con.addAnnotatedClass(Community.class);
		con.addAnnotatedClass(Invite.class);
		con.addAnnotatedClass(CommunityMember.class);
		con.addAnnotatedClass(Chat.class);
		con.addAnnotatedClass(Message.class);
		con.addAnnotatedClass(Content.class);
		
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		RmeUser user1 = new RmeUser();
		user1.setUserName("Irshad");

		RmeUser user2 = new RmeUser();
		user2.setUserName("Deepak");

		Community comm1 = new Community();
		comm1.setDescription("buljsdk contksnt klajskf klankdfh jdf");
		comm1.setStatus(PrivatePublic.PRIVATE);
		comm1.setCommunityName("community 1");
		
		Community comm2 = new Community();
		comm2.setDescription(" ilsnafl buljsdk contksnt klajskf klankdfh jdf");
		comm2.setStatus(PrivatePublic.PUBLIC);
		comm2.setCommunityName("community 2");
		
		Community comm3 = new Community();
		comm3.setDescription("community content ajskf klankdfh jdf");
		comm3.setStatus(PrivatePublic.PRIVATE);
		comm3.setCommunityName("community 3");

		Invite invite1 = new Invite();
		Invite invite2 = new Invite();
		
		CommunityMember ucd1 = new CommunityMember();
		ucd1.setRole(Role.Broker);
		CommunityMember ucd2 = new CommunityMember();
		ucd2.setRole(Role.Builder);
		CommunityMember ucd3 = new CommunityMember();
		ucd3.setRole(Role.Developer);
		CommunityMember ucd4 = new CommunityMember();
		ucd4.setRole(Role.Builder);
		CommunityMember ucd5 = new CommunityMember();
		ucd5.setRole(Role.Developer);

		Chat chat1 = new Chat();
		chat1.setIsBroadcast(false);
		
		Chat chat2 = new Chat();
		chat2.setIsBroadcast(true);
		
		Message msg1 = new Message();
		msg1.setReceiver(ucd1);
		msg1.setSender(ucd4);
		
		Message msg2 = new Message();
		msg2.setReceiver(ucd4);
		msg2.setSender(ucd1);
		
		Message msg3 = new Message();
		msg3.setReceiver(null);
		msg3.setSender(ucd3);
		
		Message msg4 = new Message();
		msg4.setReceiver(ucd1);
		msg4.setSender(ucd4);
		
		Content c1 = new Content();
		Content c2 = new Content();
		Content c3 = new Content();
		Content c4 = new Content();
		
		
		//--------------------mapping setting
		user1.getCommunities().add(comm3);
		user1.getCommunities().add(comm2);
		user1.getCommunities().add(comm1);
		user2.getCommunities().add(comm2);
		user2.getCommunities().add(comm1);
		comm1.getMembers().add(user2);
		comm1.getMembers().add(user1);
		comm2.getMembers().add(user2);
		comm2.getMembers().add(user1);
		comm3.getMembers().add(user1);	
		user1.getInvites().add(invite2);
		user2.getInvites().add(invite1);
		comm1.getInvites().add(invite1);
		comm2.getInvites().add(invite2);
		invite1.setCommunity(comm2);
		invite2.setCommunity(comm1);
		invite1.setUser(user2);
		invite2.setUser(user1);
		ucd1.setCommunity(comm3);
		ucd1.setUser(user1);
		ucd2.setCommunity(comm2);
		ucd2.setUser(user1);
		ucd3.setCommunity(comm1);
		ucd3.setUser(user1);
		ucd4.setCommunity(comm2);
		ucd4.setUser(user2);
		ucd5.setCommunity(comm1);
		ucd5.setUser(user2);
		ucd1.getChats().add(chat1);
		ucd3.getChats().add(chat2);
		chat1.getParticipants().add(ucd1);
		chat1.getParticipants().add(ucd4);
		chat2.getParticipants().add(ucd3);
		chat1.getMessages().add(msg1);
		chat1.getMessages().add(msg2);
		chat1.getMessages().add(msg4);
		chat2.getMessages().add(msg3);
		msg1.setChat(chat1);
		msg2.setChat(chat1);
		msg3.setChat(chat2);
		msg4.setChat(chat1);
		msg1.setContent(c3);
		msg2.setContent(c4);
		msg3.setContent(c2);
		msg4.setContent(c1);
		ucd3.getCommunity().setCommunityChat(chat2);
		comm1.setAdmin(user1);
		comm2.setAdmin(user1);
//		comm1.setAdmin(user2);
//		comm2.setAdmin(user1);
//		comm3.setAdmin(user1);

		try
		{
			transaction=session.beginTransaction();

			//---------------------saving objects
//			session.save(comm1);
//			session.save(comm2);
//			session.save(comm3);
			session.persist(user1);
			session.persist(user2);
			session.save(chat1);
			session.save(chat2);
			session.save(msg4);
			session.save(msg3);
			session.save(msg2);
			session.save(msg1);
			session.save(c4);
			session.save(c3);
			session.save(c2);
			session.save(c1);
			session.persist(ucd1);
			session.persist(ucd2);
			session.persist(ucd3);
			session.persist(ucd4);
			session.persist(ucd5);

//			session.save(invite1);
//			session.save(invite2);
			
			transaction.commit();
			
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}

	}

}
