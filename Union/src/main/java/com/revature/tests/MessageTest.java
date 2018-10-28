package com.revature.tests;

import java.io.File;
import java.util.List;

import com.revature.messages.Message;
import com.revature.messages.MessageHandler;

public class MessageTest {
	public static boolean NOT_OKAY_TO_RUN = true;
	
	public static void main(String[] args) {
		if (NOT_OKAY_TO_RUN) {
			return;
		}
		
		MessageHandler mh = new MessageHandler('|');
		List<Message> ms = null;
		
		mh.record(1, 1, "stuff");
		
		mh.record(1, 3, "things");
		
		ms = mh.retreiveAll(1);
		for (Message m : ms) {
			System.out.println(m);
		}
		
		File f = new File("messages" + 1 + ".txt");
		f.delete();
	}

}
