package iface;

import java.util.ArrayList;

public class Message{
	
	public String namemessage;
	public ArrayList<String> messages = new ArrayList<String>();

	public void MessagesShow() {
		int i;
		if(messages.size() > 0) {
			System.out.println("\nSua conversa com:" + namemessage);
			for(i = 0; i < messages.size(); i++) {
				System.out.println(messages.get(i));
			}
		}
		else {
			System.out.println("Não há nenhum histórico de conversa com" + this.namemessage);
		}
	}
	
}