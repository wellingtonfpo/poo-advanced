package service;

import interfaces.MessageService;
import interfaces.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final MessageService messageService;

    public UserService(UserRepository userRepository, MessageService messageService) {
        this.userRepository = userRepository;
        this.messageService = messageService;
    }

    public void registerUser(String username, String email) {
        System.out.println("--- Iniciando regras de negócio para registro de usuário ---");

        if (username == null || username.isEmpty()) {
            System.out.println("Erro: O nome de usuário não pode ser vazio.");
        }

        this.userRepository.save(username, email);
        this.messageService.sendMessage("Bem-vindo, " + username + "!", email);

        System.out.println("--- Registro de usuário concluído ---");
    }
}
