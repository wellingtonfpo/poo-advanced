package notify.v2;

public class SMTPEmailNotification implements IEmailNotification {
    private String smtpServer;
    private String username;
    private String password;

    public SMTPEmailNotification(String smtpServer, String username, String password) {
        this.smtpServer = smtpServer;
        this.username = username;
        this.password = password;
    }

    @Override
    public void sendEmail(String to, String message) {
        System.out.printf("SMTP: Sending Email to %s", to);
        System.out.printf("SMTP Server Config: Server=%s, User=%s", smtpServer, username);
        // Lógica de envio do email
    }
}
