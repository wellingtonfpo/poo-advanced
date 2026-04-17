import interfaces.MessageService;
import interfaces.UserRepository;
import repository.MySqlUserRepository;
import service.UserService;

public class Main {

    public static void main(String[] args) {
        SimpleDIContainer container = new SimpleDIContainer();
        container.register(UserRepository.class, MySqlUserRepository.class);
        container.register(MessageService.class, messaging.SendgridService.class);

        UserService userService = container.resolve(UserService.class);
        userService.registerUser("john_doe", "john_doe@mail.com");
    }
}
