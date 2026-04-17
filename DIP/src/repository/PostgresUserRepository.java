package repository;

import interfaces.UserRepository;

public class PostgresUserRepository implements UserRepository {
    @Override
    public void save(String username, String email) {
        // Simulate saving to a PostgreSQL database
        System.out.println("[PostgreSQL] Conectando ao banco de dados...");
        System.out.println("[PostgreSQL] Executando: INSERT INTO users " +
                "(username, email) VALUES ('" + username + "', '" + email + "');");
        System.out.println("[PostgreSQL] Transação concluída!");
    }
}
