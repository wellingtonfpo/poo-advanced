package notify.v2.factory;

import notify.v2.IEmailNotification;
import notify.v2.SendGridEmailNotification;

public class SendGripEmailNotificationFactory extends EmailNotificationFactory {
    private final String sendGridApiKey = System.getenv("SENDGRID_API_KEY");

    @Override
    public IEmailNotification createEmailNotification() {
        if (sendGridApiKey == null) {
            throw new IllegalArgumentException("SendGrid API key is missing");
        }

        return new SendGridEmailNotification(sendGridApiKey);
    }
}
