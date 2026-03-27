package notify.v1;

public class EmailNotificationService {
    private final String smtpServer = System.getenv("SMTP_SERVER");
    private final String username = System.getenv("SMTP_USERNAME");
    private final String password = System.getenv("SMTP_PASSWORD");

    private final String awsRegion = System.getenv("AWS_REGION");
    private final String awsAccessKey = System.getenv("AWS_ACCESS_KEY");
    private final String awsSecretKey = System.getenv("AWS_SECRET_KEY");

    private final String sendGridApiKey = System.getenv("SENDGRID_API_KEY");

    public void sendEmail(String provider, String to, String message) throws Exception {
        if (provider.equals("SMTP")) {
            if (smtpServer.isEmpty() || username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("SMTP configuration is missing");
            }

            System.out.printf("SMTP: Sending Email to %s", to);
            System.out.printf("SMTP Server Config: Server=%s, User=%s", smtpServer, username);
            // Lógica de envio do email
        } else if (provider.equals("SES")) {
            if (awsRegion.isEmpty() || awsAccessKey.isEmpty() || awsSecretKey.isEmpty()) {
                throw new IllegalArgumentException("AWS SES configuration is missing");
            }

            System.out.printf("SES: Sending Email to %s", to);
            System.out.printf("AWS Config: Region=%s", awsRegion);
            // Lógica de envio do email
        } else if (provider.equals("Sendgrid")) {
            if (sendGridApiKey.isEmpty()) {
                throw new IllegalArgumentException("SendGrid configuration is missing");
            }

            System.out.printf("Sendgrid: Sending Email to %s", to);
            System.out.printf("Sendgrid Config: ApiKey=%s", sendGridApiKey);
            // Lógica de envio do email
        } else {
            throw new Exception("Unsupported email provider: " + provider);
        }
    }
}
