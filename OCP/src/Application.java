void main() {
    ReportProcessor processor = new ReportProcessor();
    processor.process("PDF");
    processor.process("CSV");
    processor.process("TXT");

    ReportProcessorOCP ocpProcessor = new ReportProcessorOCP();
    ocpProcessor.process(new PDFReporter());
    ocpProcessor.process(new CSVReporter());
}
