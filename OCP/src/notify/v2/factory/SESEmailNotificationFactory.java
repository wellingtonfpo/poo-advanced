package notify.v2.factory;

import notify.v2.IEmailNotification;
import notify.v2.SESEmailNotification;

public class SESEmailNotificationFactory extends EmailNotificationFactory {
    private final String awsRegion = System.getenv("AWS_REGION");
    private final String awsAccessKey = System.getenv("AWS_ACCESS_KEY");
    private final String awsSecretKey = System.getenv("AWS_SECRET_KEY");

    @Override
    public IEmailNotification createEmailNotification() {
        if (awsRegion == null || awsAccessKey == null || awsSecretKey == null) {
            throw new IllegalArgumentException("AWS SES configuration is missing");
        }

        return new SESEmailNotification(awsRegion, awsAccessKey, awsSecretKey);
    }
}
