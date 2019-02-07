package org.bhupinder.zversal.messenger.service;

import java.util.*;

import org.bhupinder.zversal.messenger.database.DatabaseClass;
import org.bhupinder.zversal.messenger.model.Message;

public class Messageservice {
	
	private Map<Long, Message> messages= DatabaseClass.getMessages();
	
	public Messageservice() {
		messages.put(1L,new Message(1,"Hello World","Bhupinder"));
		messages.put(2L,new Message(2,"Hello Zversal","Navi")  );
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
   
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	/*public List<Message> getAllMessagesForYear(int year){
	List<Message> messageForYear= new ArrayList<>();
	Calendar cal;
	cal= Calendar.getInstance();
	for(Message message:messages.values()) {
		cal.setTime(message.getCreated());
		if(cal.get(Calendar.YEAR)==year) {
			messageForYear.add(message);
		
		}
	}
	return messageForYear;
	}*/
	
	
	
	public Message addMessages(Message message ) {
		message.setId(messages.size()+1);
		messages.put( message.getId(),message);
		return message;
	}
	public Message updateMessage(Message message) {
		
		messages.put(message.getId(), message);
		return message;
	}
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	
}


