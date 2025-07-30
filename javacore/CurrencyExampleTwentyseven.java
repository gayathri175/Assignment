package practice1;
public class CurrencyExampleTwentyseven{

    // Step 1: Define enum
    enum CurrencyType {
        ONE_RUPEE, FIVE_RUPEE, TEN_RUPEE, TWENTY_RUPEE, FIFTY_RUPEE, HUNDRED_RUPEE
    }

    public static void main(String[] args) {
        // Step 2: Loop through enum values
        System.out.println("Available Currency Types:");
        for (CurrencyType ct : CurrencyType.values()) {
            System.out.println(ct);
        }

        System.out.println("\nCurrency Descriptions:");

        // Step 3: Use switch to describe each currency
        for (CurrencyType ct : CurrencyType.values()) {
            switch (ct) {
                case ONE_RUPEE:
                    System.out.println("ONE_RUPEE: Smallest denomination in coins.");
                    break;
                case FIVE_RUPEE:
                    System.out.println("FIVE_RUPEE: Coin or note, often used in daily transactions.");
                    break;
                case TEN_RUPEE:
                    System.out.println("TEN_RUPEE: Commonly used for snacks or transport.");
                    break;
                case TWENTY_RUPEE:
                    System.out.println("TWENTY_RUPEE: Often used for quick shopping or meals.");
                    break;
                case FIFTY_RUPEE:
                    System.out.println("FIFTY_RUPEE: Medium value currency, orange color note.");
                    break;
                case HUNDRED_RUPEE:
                    System.out.println("HUNDRED_RUPEE: High value note used widely in shopping.");
                    break;
                default:
                    System.out.println("Unknown currency.");
            }
        }
    }
}
/*Available Currency Types:
ONE_RUPEE
FIVE_RUPEE
TEN_RUPEE
TWENTY_RUPEE
FIFTY_RUPEE
HUNDRED_RUPEE

Currency Descriptions:
ONE_RUPEE: Smallest denomination in coins.
FIVE_RUPEE: Coin or note, often used in daily transactions.
TEN_RUPEE: Commonly used for snacks or transport.
TWENTY_RUPEE: Often used for quick shopping or meals.
FIFTY_RUPEE: Medium value currency, orange color note.
HUNDRED_RUPEE: High value note used widely in shopping.*/
