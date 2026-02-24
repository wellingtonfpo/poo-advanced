package br.com.srp.booking;

import java.util.Date;

class BookingValidator {
    void validateDates(Date startDate, Date endDate) {
        if (startDate.after(endDate))
            throw new IllegalArgumentException("Start date must be before end date.");
    }
}

class BookingCostCalculator {
    double calculateTotalCost(Date startDate, Date endDate, double dailyRate) {
        long duration = (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
        return duration * dailyRate;
    }
}

class EmailService {
    void sendConfirmation(String email) {
        System.out.println("Email confirmation sent to: " + email);
    }
}


class BookingServiceSRP {
    private final BookingValidator validator;
    private final BookingCostCalculator costCalculator;
    private final EmailService emailService;

    public BookingServiceSRP(
            BookingValidator validator,
            BookingCostCalculator costCalculator,
            EmailService emailService
    ) {
        this.validator = validator;
        this.costCalculator = costCalculator;
        this.emailService = emailService;
    }

    public void processBooking(BookingData bookingData) {
        validator.validateDates(bookingData.startDate, bookingData.endDate);

        double totalCost = costCalculator.calculateTotalCost(
                bookingData.startDate,
                bookingData.endDate,
                bookingData.dailyRate
        );

        System.out.println("Total cost for booking: " + totalCost);
        emailService.sendConfirmation(bookingData.email);
    }
}
