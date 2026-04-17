package repository;

import interfaces.UserRepository;

public class MySqlUserRepository implements UserRepository {
    @Override
    public void save(String username, String email) {
        // Simulate saving to a PostgreSQL database
        System.out.println("[MySQL] Conectando ao banco de dados...");
        System.out.println("[MySQL] Executando: INSERT INTO users " +
                "(username, email) VALUES ('" + username + "', '" + email + "');");
        System.out.println("[MySQL] Transação concluída!");
    }
}
