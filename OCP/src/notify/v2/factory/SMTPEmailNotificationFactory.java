package notify.v2.factory;

import notify.v2.IEmailNotification;
import notify.v2.SMTPEmailNotification;

public class SMTPEmailNotificationFactory extends EmailNotificationFactory {
    private final String smtpServer = System.getenv("SMTP_SERVER");
    private final String username = System.getenv("SMTP_USERNAME");
    private final String password = System.getenv("SMTP_PASSWORD");

    @Override
    public IEmailNotification createEmailNotification() {

        if (this.smtpServer.isEmpty() || this.username.isEmpty() || this.password.isEmpty()) {
            throw new IllegalArgumentException("SMTP configuration is missing");
        }

        return new SMTPEmailNotification(this.smtpServer, this.username, this.password);
    }
}
