package notify.v2;

import notify.v2.factory.EmailNotificationFactory;

public class EmailNotificationService {
    public void sendEmail(EmailNotificationFactory provider, String to, String message) {
        provider.sendEmail(to, message);
    }
}
