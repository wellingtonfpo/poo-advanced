package notify.v2;

public class SendGridEmailNotification implements IEmailNotification {
    private String sendGridApiKey;

    public SendGridEmailNotification(String sendGridApiKey) {
        this.sendGridApiKey = sendGridApiKey;
    }

    @Override
    public void sendEmail(String to, String message) {
        System.out.printf("Sendgrid: Sending Email to %s", to);
        System.out.printf("Sendgrid Config: ApiKey=%s", sendGridApiKey);
    }
}
