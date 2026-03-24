package report;

public class ReportProcessor {
    public void process(String type) {
        if (type.equals("PDF")) {
            System.out.println("Processing PDF report...");
            // Add PDF processing logic here
        } else if (type.equals("CSV")) {
            System.out.println("Processing CSV report...");
            // Add Excel processing logic here
        } else {
            System.out.println("Unknown report type: " + type);
        }
    }
}
