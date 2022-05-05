package iface;
import java.util.Scanner;

public class IFaceJava {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = -1;
		
		System.out.println("Seja bem-vindo ao iFace!\n");
		System.out.println("Digite sua opção:\n0 - Sair da página\n1 - Criar uma nova conta\n2- Entrar\n");
		
		java.util.ArrayList<Users> users = new java.util.ArrayList<Users>();
		
		while(input != 0) {
	
			try {
				
				input = scanner.nextInt();
				scanner.nextLine();
				switch(input) {
				
					case 1:
						Users user = new Users();
						user.CreateNewAccount();
						user.CreateProfile();
						users.add(user);					
						
						System.out.println("Sua conta foi criada com sucesso!\n");
						
						break;
					
					case 2:
						
						int i, id = 0;
						int flag0 = 0;
						
						String password = null;
						System.out.println("Login:");
						String login = scanner.nextLine();
						
						for(i = 0; i < users.size(); i++) {
							if(login.equals(users.get(i).login)) {
								id = i;
								System.out.println("Senha:");
								password = scanner.nextLine();
								flag0++;
								break;
							}
						}
						
						if(flag0 == 0) {
							System.out.println("Erro: login ou senha inválido!\nTente novamente!");
							break;
						}
						
						else if(password.equals(users.get(id).getPassword())){
							System.out.println("\nSeja bem vindo, " + users.get(id).nickname + "!\n");
							System.out.println("\nEscolha uma opção:\n1 - Editar meu perfil\n2 - Adicionar um novo amigo\n3 - Aceitar nova solicitação de amizade\n4 - Visualizar seu perfil\n5 - Visualizar o perfil de um membro\n6 - Visualizar uma comunidade\n7 - Enviar uma mensagem\n8 - Ler suas mensanges\n9 - Criar uma comunidade\n10 - Adicionar um membro à sua comunidade\n11 - Apagar sua conta\n12 - Sair\n");
							
							
							int inputcase2 = -1;
							
							while(inputcase2 != 12) {
								
								try {
									
									inputcase2 = scanner.nextInt();
									scanner.nextLine();
									
									switch(inputcase2) {
									
									case 1:
										
										users.get(id).EditProfile();
										
										break;
									
									case 2:
										
										int flag = 0;
										
										System.out.println("Digite o user que deseja encontrar:\n");
										
										String friendname = scanner.nextLine();
										
										for(i = 0; i < users.size(); i++) {
											
											if(friendname.equals(users.get(i).nickname)) {
												users.get(i).AddFriend(users.get(id).nickname);
												flag++;
												break;
											}
											
										}
										
										if(flag == 0) {
											System.out.println("Não foi possível encontrar!\n");
										}
										
										break;
										
										case 3:
											
											int j;
											System.out.println("Pedidos de amizade:\n1 - Aceitar o pedido\n2 - Recusar o pedido\n");
											
											for(i = 0; i < users.get(id).newfriends.size(); i++) {
												
												System.out.println("\n" + users.get(id).newfriends.get(i) + "quer ser seu amigo!");
												
												int accept = scanner.nextInt();
												
												if(accept == 1) {
													
													Message message = new Message();
													
													users.get(id).friends.add(users.get(id).newfriends.get(i));
													
													message.namemessage = users.get(id).newfriends.get(i);
													
													users.get(id).mymessages.add(message);
													
													for(j = 0; j < users.size(); j++) {
														
														if(users.get(id).newfriends.get(i).equals(users.get(j).nickname)) {
															
															users.get(j).friends.add(users.get(id).nickname);
															
															Message message2 = new Message();
															
															message2.namemessage = users.get(id).nickname;
															
															users.get(j).mymessages.add(message2);
															
															System.out.println("\nVocê aceitou o pedido de " + users.get(id).newfriends.get(i) + "!");
														}
													}
													
													users.get(id).newfriends.remove(i);
												}
												
												else {
													
													users.get(id).newfriends.remove(i);
													System.out.println("Pedido recusado.");
												}
											}
											
											break;
										
										case 4:
										
											users.get(id).ShowProfile();
											
											break;
											
										case 5:
											
											int flag2 = 0;
											
											System.out.println("Digite o nome do membro que deseja encontrar:");
											
											String member = scanner.nextLine();
											
											for(i = 0; i < users.size(); i++) {
												if(member.equals(users.get(i).nickname)) {
													users.get(i).ShowProfile();
													flag2++;
												}
											}
											
											if(flag2 == 0) {
												System.out.println("\nMembro não encontrado!\n");
											}
											
											break;
											
										case 6:
											
											int flag3 = 0;
											
											System.out.println("\nDigite o nome da comunidade que você deseja encontrar:");
											
											String com = scanner.nextLine();
											
											for(i = 0; i < users.size(); i++) {
												if(users.get(i).mycommunity != null && com.equals(users.get(i).mycommunity.communityname)) {
													users.get(i).mycommunity.ShowCommunity();
													flag3++;
												}
											}
											
											if(flag3 == 0) {
												System.out.println("\nComunidade não encontrada!\n");
											}
											
											break;
											
										case 7:
											
											users.get(id).SendMessage(users);
											break;
											
										case 8:
											users.get(id).PeekMessages();
											break;
											
										case 9:
											
											users.get(id).CreateCommunity();
											break;
											
										case 10:
											
											users.get(id).AddComunidade(users);
											break;
											
										case 11:
											
											for(i = 0; i < users.size(); i++) {
												for(j = 0; j < users.get(i).friends.size(); j++) {
													if(users.get(id).nickname.equals(users.get(i).friends.get(j))) {
														users.get(i).friends.remove(j);
													}
												}
											}
											
											
											for(i = 0; i < users.size(); i++) {
												for(j = 0; j < users.get(i).mymessages.size(); j++) {
													if(users.get(id).nickname.equals(users.get(i).mymessages.get(j).namemessage)) {
														users.get(i).mymessages.remove(j);
													}
												}
											}
											
											for(i = 0; i < users.size(); i++) {
												for(j = 0; j < users.get(i).newfriends.size(); j++) {
													if(users.get(id).nickname.equals(users.get(i).newfriends.get(j))) {
														users.get(i).newfriends.remove(j);
													}
												}
											}
											
											
											for(i = 0; i < users.size(); i++) {
												if(users.get(i).mycommunity != null) {
													for(j = 0; j < users.get(i).mycommunity.communitymembers.size(); j++) {
														if(users.get(id).nickname.equals(users.get(i).mycommunity.communitymembers.get(j))) {
															users.get(i).mycommunity.communitymembers.remove(j);
														}
													}
												}
											}
											
											
											users.remove(id);
											System.out.println("\nExcluido com sucesso!\n");
											inputcase2 = 12;
											break;									
									}
									
									System.out.println("\nEscolha uma opção:\n1 - Editar meu perfil\n2 - Adicionar um novo amigo\n3 - Aceitar nova solicitação de amizade\n4 - Visualizar seu perfil\n5 - Visualizar o perfil de um membro\n6 - Visualizar uma comunidade\n7 - Enviar uma mensagem\n8 - Ler suas mensagens\n9 - Criar uma comunidade\n10 - Adicionar um membro à sua comunidade\n11 - Apagar sua conta\n12 - Sair\n");
									
									
									
									
								}
								
								catch(Exception e) {
									scanner.nextLine();
									scanner.nextLine();
									System.out.println("\nErro! Tente novamente!");
									System.out.println("\nEscolha uma opção:\n1 - Editar meu perfil\n2 - Adicionar um novo amigo\n3 - Aceitar nova solicitação de amizade\n4 - Visualizar seu perfil\n5 - Visualizar o perfil de um membro\n6 - Visualizar uma comunidade\n7 - Enviar uma mensagem\n8 - Ler suas mensagens\n9 - Criar uma comunidade\n10 - Adicionar um membro à sua comunidade\n11 - Apagar sua conta\n12 - Sair\n");
								 }
								
							}
						}
						else {
							 System.out.println("\nSenha inválida!\nTente novamente!");
						 }
						
						break; 
				}
				
			}
			
			catch(Exception e) {
				scanner.nextLine();
				System.out.println("\nErro! Tente novamente!");

			}
			
			System.out.println("\nEscolha uma opcao:\n0 - Sair da pagina\n1 - Criar uma nova conta\n2 - Login");

		}
		
		scanner.close();
	}
	
	
}