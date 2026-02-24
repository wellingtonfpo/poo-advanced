package br.com.srp.booking;

class BookingService {
    public void processBooking(BookingData bookingData) {
        // validate booking data
        if (bookingData.startDate.after(bookingData.endDate))
            throw new IllegalArgumentException("Start date must be before end date.");

        // calculate total cost
        long duration = (bookingData.endDate.getTime() - bookingData.startDate.getTime()) / (1000 * 60 * 60 * 24);
        double totalCost = duration * bookingData.dailyRate;
        System.out.println("Total cost for booking: " + totalCost);

        //send email confirmation (placeholder)
        System.out.println("Email confirmation sent to: " + bookingData.email);
    }
}
