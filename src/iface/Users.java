package iface;
import java.util.Scanner;
import java.util.ArrayList;

public class Users{
	public String login;
	public String nickname;
	private String password;
	public ArrayList<String> friends = new ArrayList<String>();
	public ArrayList<String> newfriends = new ArrayList<String>();
	
	
	public int age;
	public String city;
	public String country;
	public Comunidade mycommunity = null;
	public ArrayList<Message> mymessages = new ArrayList<Message>();
	public ArrayList<String> mycommunities = new ArrayList<String>();
	
	
	public void CreateNewAccount() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite seu login para criar a conta:\n");
		login = scanner.nextLine();
		
		System.out.println("Digiet seu username:\n");
		nickname = scanner.nextLine();
		
		System.out.println("Digite sua senha:\n");
		password = scanner.nextLine();
		
	}
	
	
	public String getPassword() {
		return this.password;
	}
	
	
	public void CreateProfile() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite sua idade:\n");
		age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Digite sua cidade:\n");
		city = scanner.nextLine();
		
		System.out.println("Digite seu país:\n");
		country = scanner.nextLine();
		
	}
	
	public void EditProfile() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("O que você deseja alterar?\n1 - Idade\n2 - Cidade\n3 - País\n");
				
		
		int editinput = scanner.nextInt();
		scanner.nextLine();
		
		switch(editinput) {
		
			case 1:
				System.out.println("Digite sua nova idade:\n");
				age = scanner.nextInt();
				scanner.nextLine();
				System.out.println("OK!");
				break;
			
			case 2:
				System.out.println("Digite sua nova cidade:\n");
				city = scanner.nextLine();
				System.out.println("OK!");
				break;
				
			case 3:
				System.out.println("Digite seu novo país:\n");
				country = scanner.nextLine();
				System.out.println("OK!");
				break;
			
			case 4:
				System.out.println("Digite sua nova idade:\n");
				age = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Digite sua nova cidade:\n");
				city = scanner.nextLine();
				
				System.out.println("Digite seu novo país:\n");
				country = scanner.nextLine();
				System.out.println("OK!");
				break;
		
		}
		
	}
	
	
	public void AddFriend(String yourname) {
		String message = yourname;
		newfriends.add(message);
		System.out.println("OK!");
	}
	
	
	public void ShowProfile() {
		int i;
		System.out.println("\n" + nickname.toUpperCase());
		System.out.println("------------------------------");
		System.out.println(age + " anos\n" + city + "     " + country);
		System.out.println("Lista de amigos:");
		for(i = 0; i < friends.size(); i++) {
			System.out.println("   " + friends.get(i));
		}
		if(mycommunity != null) {
			System.out.println("Minha Comunidade: " + mycommunity.communityname + "\n  Descrição: " + mycommunity.descrip);

		}
		System.out.println("Comunidades:");
		for(i = 0; i < mycommunities.size(); i++) {
			System.out.println("   " + mycommunities.get(i));
		}
	}
	
	
	public void CreateCommunity() {
		Comunidade community = new Comunidade();
		community.NewCommunity(this.nickname);
		mycommunity = community;
	}
	
	
	public void AddComunidade(ArrayList<Users> u) {
		
		Scanner scanner = new Scanner(System.in);
		
		int i;
		
		if(mycommunity != null) {
			
			System.out.println("\nDigite o username do membro que você deseja adicionar à comunidade:");
			
			String newname = scanner.nextLine();
			
			for(i = 0; i < u.size(); i++) {
				if(newname.equals(u.get(i).nickname)) {
					mycommunity.communitymembers.add(newname);
					u.get(i).mycommunities.add(mycommunity.communityname);
					System.out.println("\n" + newname + " add to your community!");
				}
				
			}
		}
		
		else {
			System.out.println("\nErro! Você não tem comunidades!\n");
		}
		
	}
	
	
	public void SendMessage(ArrayList<Users> u) {
		
		Scanner scanner = new Scanner(System.in);
		
		int i, j;
		
		String mess = null;
		
		System.out.println("\nDigite o username do membro que você deseja enviar uma mensagem:");
		
		String newname = scanner.nextLine();
		
		for(i = 0; i < mymessages.size(); i++) {
			
			if(newname.equals(mymessages.get(i).namemessage)) {
				
				System.out.println("\nSua mensagem:");
				
				mess = scanner.nextLine();
				
				this.mymessages.get(i).messages.add(this.nickname + ": " + mess);
			
			}
			
		}
		
		for(i = 0; i < u.size(); i++) {
			if(newname.equals(u.get(i).nickname)) {
				
				for(j = 0; j < u.get(i).mymessages.size(); j++) {
					
					if(this.nickname.equals(u.get(i).mymessages.get(j).namemessage)) {
						
						u.get(i).mymessages.get(j).messages.add(this.nickname + ": " + mess);
						
					}
				}
				
			}
		}
		
		System.out.println("\nOK!");

	}
	
	public void PeekMessages() {
		
		Scanner scanner = new Scanner(System.in);
		
		int i, flag = 0;
		
		System.out.println("\nDigite o username do membro que você deseja ler a mensagem:");
		
		String search = scanner.nextLine();
		
		for(i = 0; i < mymessages.size(); i++) {
			if(search.equals(mymessages.get(i).namemessage)) {
				mymessages.get(i).MessagesShow();
				flag++;
			}
		}
		
		if(flag == 0) {
			System.out.println("Não encontrado!");
		}
		
	}
}





