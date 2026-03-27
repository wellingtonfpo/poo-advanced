package notify.v2.factory;

import notify.v2.IEmailNotification;

public abstract class EmailNotificationFactory {
    public abstract IEmailNotification createEmailNotification();

    public void sendEmail(String to, String message) {
        IEmailNotification emailNotification = createEmailNotification();
        emailNotification.sendEmail(to, message);
    }
}
