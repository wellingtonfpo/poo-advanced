package notify.v2;

public class SESEmailNotification implements IEmailNotification {
    private String awsRegion;
    private String awsAccessKey;
    private String awsSecreteKey;

    public SESEmailNotification(String awsRegion, String awsAccessKey, String awsSecreteKey) {
        this.awsRegion = awsRegion;
        this.awsAccessKey = awsAccessKey;
        this.awsSecreteKey = awsSecreteKey;
    }

    @Override
    public void sendEmail(String to, String message) {
        System.out.printf("SES: Sending Email to %s", to);
        System.out.printf("AWS Config: Region=%s", awsRegion);
        // Lógica de envio do email
    }
}
