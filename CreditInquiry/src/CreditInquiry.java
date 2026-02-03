private final static MenuOption[] choices = MenuOption.values();

private static MenuOption getRequest() {
    int request = 4;

    System.out.printf("Enter request%n%s%n%s%n%s%n%s%n",
            " 1 - List accounts with zero balances",
            " 2 - List accounts with credit balances",
            " 3 - List accounts with debit balances",
            " 4 - Terminate program");

    try {
        Scanner input = new Scanner(System.in);

        do {
            System.out.printf("%n? ");
            request = input.nextInt();
        } while ((request < 1 || request > 4));
    } catch (NoSuchElementException e) {
        System.err.println("Invalid input. Terminating.");
    }

    return choices[request - 1];
}

private static void readRecords(MenuOption accountType) {
    try (Scanner input = new Scanner(Paths.get("clients.txt"))) {
        while (input.hasNext()) {
            int accountNumber = input.nextInt();
            String firstName = input.next();
            String lastName = input.next();
            double balance = input.nextDouble();

            if (shouldDisplay(accountType, balance)) {
                System.out.printf("%-10d%-12s%-12s%10.2f%n",
                        accountNumber, firstName, lastName, balance);
            }
        }
    } catch (NoSuchElementException | IllegalStateException | IOException e) {
        System.err.println("Error processing file. Terminating.");
        System.exit(1);
    }
}

private static boolean shouldDisplay(MenuOption accountType, double balance) {
    if ((accountType == MenuOption.CREDIT_BALANCE) && (balance < 0))
        return true;
    else if ((accountType == MenuOption.DEBIT_BALANCE) && (balance > 0))
        return true;
    else return (accountType == MenuOption.ZERO_BALANCE) && (balance == 0);
}

void main() {
    MenuOption accountType = getRequest();

    while (accountType != MenuOption.END) {
        switch (accountType) {
            case ZERO_BALANCE:
                System.out.printf("%nAccounts with zero balances:%n");
                break;
            case CREDIT_BALANCE:
                System.out.printf("Accounts with credit balances:%n");
                break;
            case DEBIT_BALANCE:
                System.out.printf("Accounts with debit balances:%n");
                break;
        }

        readRecords(accountType);
        accountType = getRequest();
    }
}