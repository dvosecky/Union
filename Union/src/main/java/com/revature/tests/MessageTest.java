package com.revature.tests;

import java.util.List;

import com.revature.messages.Message;
import com.revature.messages.MessageHandler;

public class MessageTest {

	public static void main(String[] args) {
		MessageHandler mh = new MessageHandler('|');
		List<Message> ms = null;
		
		mh.record(1, 1, "stuff");
		
		mh.record(1, 3, "things");
		
		ms = mh.retreiveAll(1);
		for (Message m : ms) {
			System.out.println(m);
		}
	}

}
