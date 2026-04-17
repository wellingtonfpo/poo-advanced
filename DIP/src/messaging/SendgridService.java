package messaging;

import interfaces.MessageService;

public class SendgridService implements MessageService {
    @Override
    public void sendMessage(String message, String receiver) {
        // Simulate sending an email
        System.out.println("[Sendgrid] Sending email to " + receiver + ": " + message);
    }
}
