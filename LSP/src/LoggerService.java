import without.Logger;

public class LoggerService {
    private final Logger logger;

    public LoggerService(Logger logger) {
        this.logger = logger;
    }

    public void logMessage(String message) {
        this.logger.log(message);
    }
}
