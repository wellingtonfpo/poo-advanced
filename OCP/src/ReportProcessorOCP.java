interface Reporter {
    void process();
}

class PDFReporter implements Reporter {
    @Override
    public void process() {
        System.out.println("Processing PDF report...");
        // Add PDF processing logic here
    }
}

class CSVReporter implements Reporter {
    @Override
    public void process() {
        System.out.println("Processing CSV report...");
        // Add CSV processing logic here
    }
}

class ReportProcessorOCP {
    public void process(Reporter reporter) {
        reporter.process();
    }
}
