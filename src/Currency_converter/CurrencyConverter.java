package Currency_converter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {

        HashMap<Integer, String> currencyCode = new HashMap<Integer, String>();

        // Add currency codes
        currencyCode.put(1, "USD");
        currencyCode.put(2, "EUR");
        currencyCode.put(3, "GBP");
        currencyCode.put(4, "CAD");
        currencyCode.put(5, "CNY");

        String fromCode, toCode;
        double amount;

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter");
        printCurrencyBoard();

        System.out.println("\nSelect currency to convert FROM: ");
        System.out.println("1:USD (US Dollar)\t 2:EUR (Euro)\t 3:GBP (British Pound) 4:CAD (Canadian Dollar)\t 5:CNY (Chinese Yuan)");
        fromCode = currencyCode.get(scan.nextInt());

        System.out.println("Select currency to convert TO: ");
        System.out.println("1:USD (US Dollar)\t 2:EUR (Euro)\t 3:GBP (British Pound) 4:CAD (Canadian Dollar)\t 5:CNY (Chinese Yuan)");
        toCode = currencyCode.get(scan.nextInt());

        System.out.println("Amount of currency you wish to convert: ");
        amount = scan.nextFloat();

        DecimalFormat f = new DecimalFormat("00.00");
        System.out.println("You get " + f.format(convertCurrency(fromCode, toCode, amount)) + toCode);
    }
    public static void printCurrencyBoard(){
        System.out.println("Actual Currency Exchange: \n 1. EUR/USD=1,089 \n 2. GBP/USD=1,296 \n 3. USD/CAD=1,391 \n 4. USD/CNY=7,12");
    }
    private static double convertCurrency(String fromCode, String toCode, double amount){
        Map<String, Double> conversionRate = new HashMap<>();

        conversionRate.put("USD", 1.0);
        conversionRate.put("EUR", 0.918);
        conversionRate.put("GBP", 0.772);
        conversionRate.put("CAD", 1.391);
        conversionRate.put("CNY", 7.12);

        if (!conversionRate.containsKey(fromCode)||!conversionRate.containsKey(toCode)){
            throw new IllegalArgumentException("Invalid currency code");
        }
        return amount * conversionRate.get(toCode) / conversionRate.get(fromCode);
    }
}