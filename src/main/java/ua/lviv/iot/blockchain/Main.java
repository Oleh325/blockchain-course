package ua.lviv.iot.blockchain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> bits_list = Arrays.asList(8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096);
        bits_list.forEach(bits -> {
            AmountOfKeys(bits);
        });
        bits_list.forEach(bits -> {
            String key = GenerateKey(bits);
            BruteforceKeySearch(key);
        });
    }

    public static void AmountOfKeys(int bits) {
        BigInteger two = new BigInteger("2");
        BigInteger result = two.pow(bits);
        System.out.println("For " + bits + " bits: " + result + " of different keys \n");
    }

    public static String GenerateKey(int bits) {
        String result = "0x";
        List<Character> symbols = "0123456789abcdefABCDEF"
                .chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());
        for (int i = 0; i < bits; i++) {
            Random rand = new Random();
            Character randomElement = symbols.get(rand.nextInt(symbols.size()));
            result += randomElement;
        }
        return result;
    }

    public static void BruteforceKeySearch(String keyStr) {
        long start = System.nanoTime();

        String bruteforceKeyStr = "0x";
        for (int i = 0; i < keyStr.length() - 2; i++) {
            bruteforceKeyStr += "0";
        }

        List<Character> bruteforceKey = bruteforceKeyStr
                .chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());

        List<Character> key = keyStr
                .chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());

        BruteforceListRecursion(bruteforceKey, key);

        long elapsedTime = System.nanoTime() - start;
        System.out.println("Found " + keyStr + " key in " + elapsedTime + "ms!");
    }

    public  static void BruteforceListRecursion(List<Character> bruteforceKey, List<Character> key, boolean is) {
        List<Character> symbols = "0123456789abcdefABCDEF"
                .chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());

        for (int i = 2; i < key.size(); i++) {

        }

    }

}

