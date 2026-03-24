//import validator.v1.Validator;
import validator.v2.Validator;
import validator.v2.EmailValidator;
import validator.v2.PhoneValidator;

void main() {
//    ReportProcessor processor = new ReportProcessor();
//    processor.process("PDF");
//    processor.process("CSV");
//    processor.process("TXT");
//
//    ReportProcessorOCP ocpProcessor = new ReportProcessorOCP();
//    ocpProcessor.process(new PDFReporter());
//    ocpProcessor.process(new CSVReporter());

//    ValidatorV1 validatorV1 = new ValidatorV1();
//    System.out.println("Email validation (v1): " + validatorV1.validate("email", "ligton.ribeiro@gmail.com"));
//    System.out.println("Phone validation (v1): " + validatorV1.validate("phone", "1234567890"));

    Validator validator = new Validator();
    validator.addStrategy("email", new EmailValidator());
    validator.addStrategy("phone", new PhoneValidator());

    System.out.println("Email validation (v2): " + validator.validate("email", "ligton.ribeiro@gmail.com"));
    System.out.println("Phone validation (v2): " + validator.validate("phone", "1234567890"));
}
