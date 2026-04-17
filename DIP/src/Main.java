import interfaces.*;
import repository.MySqlUserRepository;
import service.UserService;
//import repository.PostgresUserRepository;

void main() {
    SimpleDIContainer container = new SimpleDIContainer();
    container.register(UserRepository.class, MySqlUserRepository.class);
    container.register(MessageService.class, messaging.SendgridService.class);

    UserService userService = container.resolve(UserService.class);
    userService.registerUser("john_doe", "john_doe@mail.com");
}
