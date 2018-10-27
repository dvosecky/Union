package com.revature.messages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageHandler {
	private char delimiter;
	
	public MessageHandler(char c) {
		delimiter = c;
	}
	
	public void record(int event_id, int account_id, String message) {
		String fileName = "messages" + event_id + ".txt";
		Timestamp time = new Timestamp(0);
		time.setTime(System.currentTimeMillis());
		Message m = new Message(account_id, message, time, delimiter);
		
		try {
			File file = new File(fileName);
			boolean exists = file.exists();
			BufferedWriter bf = new BufferedWriter(new FileWriter(fileName, true));
			if (!exists) {
				bf.write("MESSAGES FOR EVENT " + event_id + " :");
			}
			bf.write("\n" + m.toString());
			bf.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Message> retreiveAll(int event_id) {
		String fileName = "messages" + event_id + ".txt";
		List<Message> all_messages = new ArrayList<Message>();
		
		try {
			File file = new File(fileName);
			if (file.exists()) {
				Scanner scanner = new Scanner(file);
				
				if (scanner.hasNextLine()) {
					scanner.nextLine();
				}
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					//Get location of first delimit.
					int first_delimit_location = line.indexOf(delimiter);
					if (first_delimit_location < 0 || first_delimit_location == line.length() - 1) {
						break;
					}
					//Get item delimited by delimit: Account id
					Integer account_id = Integer.parseInt(line.substring(0, first_delimit_location));
					
					//Get location of second delimit
					int second_delimit_location = line.indexOf(delimiter, first_delimit_location + 1);
					if (second_delimit_location < 0) {
						break;
					}
					//Get item delimited by delimit: timestamp
					Timestamp time = Timestamp.valueOf(line.substring(first_delimit_location + 1, second_delimit_location));
					
					//Get item undelimited/last item: message content itself, using ternary operator for succinctness
					String content = (second_delimit_location == line.length() - 1) ? "" : line.substring(second_delimit_location + 1);
					
					all_messages.add(new Message(account_id, content, time, delimiter));
				}
				scanner.close();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return all_messages;
	}
	
	public Message parseLine(FileReader fr) {
		Message m = new Message();
		
		//TODO
		
		return m;
	}
}
