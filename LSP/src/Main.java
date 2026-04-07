import without.ColorizedLogger;
//import without.LimitedLogger;
import with.LimitedLogger;
import without.Logger;

void main() {
    Logger simpleLogger = new Logger();
    ColorizedLogger colorizedLogger = new ColorizedLogger();
    LimitedLogger limitedLogger = new LimitedLogger(20);

    LoggerService simpleLoggerService = new LoggerService(simpleLogger);
    simpleLoggerService.logMessage("This is a simple log message.");

    LoggerService colorizedLoggerService = new LoggerService(colorizedLogger);
    colorizedLoggerService.logMessage("This is a colorized log message.");

    LoggerService limtedLoggerService = new LoggerService(limitedLogger);
    limtedLoggerService.logMessage("This is a short log message.");
}
