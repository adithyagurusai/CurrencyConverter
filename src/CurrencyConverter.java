import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

        private static final Map<String, Double> exchangeRates = new HashMap<>();

        static {
                // Sample exchange rates
                exchangeRates.put("USD", 1.0);      // Base currency: USD
                exchangeRates.put("EUR", 0.85);     // 1 USD = 0.85 EUR
                exchangeRates.put("JPY", 110.0);    // 1 USD = 110 JPY
                exchangeRates.put("GBP", 0.75);     // 1 USD = 0.75 GBP
        }

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter the amount in USD: ");
                double amount = scanner.nextDouble();

                System.out.print("Enter the target currency (EUR, JPY, GBP): ");
                String targetCurrency = scanner.next().toUpperCase();

                if (exchangeRates.containsKey(targetCurrency)) {
                        double convertedAmount = convertCurrency(amount, targetCurrency);
                        System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);
                } else {
                        System.out.println("Invalid currency code.");
                }

                scanner.close();
        }

        private static double convertCurrency(double amount, String targetCurrency) {
                return amount * exchangeRates.get(targetCurrency);
        }
}
