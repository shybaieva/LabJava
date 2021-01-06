//import java.util.Scanner;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        //Your task is to sort ascending numbers but even numbers must be on their places
        int [] arr = {1, 5, 7, 2, 9, 0};
        sort(arr);
        System.out.println(arr);

        //Find non equal number
        double [] arr2 = {1.0, 1.0, 6.9, 1.0, 1.0, 1.0};
        System.out.println(findUniq(arr2));

        //Given n, tale the sum of digits n
        System.out.println(reduce(154));

        //Reverse string array in such way word'a length stays the same as the length in orginary input
        String [] arr3 = {"Meow", "Bark", "Kitten", "Gog"};
        reverse(arr3);
        System.out.println(arr3);

        //Longest word in sentense
        String  sentense = "Meow said my kitten";
        System.out.println(length(sentense));

        //Implement method findMultiplex(x, n) which returns array of the first x multiplies of the real number n
        System.out.println(findMultiples(12, 48));

        //Implement method hasNoneLetter. It returns true if none of the letters is in a blacklist. Else - false
        String blacklist = "abc";
        String sentence1 = "My cat is sleeping";
        System.out.println(hasNoneLetters(blacklist, sentence1));

        //Write a function, which takes a non-negetive integer and returns a time in the format HH:MM:SS
        int num = 756;
        System.out.println(formatDate(num));

    }
    static void sort(int[] arr)
    {
        //Your task is to sort ascending numbers but even numbers must be on their places
        int[] odd = Arrays.stream(arr).filter(x -> x % 2 != 0).toArray();
        Arrays.sort(odd);
        int oddIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0) {
                arr[i] = odd[oddIndex];
                oddIndex++;
            }
        }
    }

    //Find non equal number
    public static double findUniq(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }

    //Given n, tale the sum of digits n
    static int reduce(int number) {
        int sum = String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
        if(sum > 9)
            return reduce(sum);
        return  sum;
    }

    //Reverse string array in such way word'a length stays the same as the length in orginary input
    static String[] reverse(String[] strings) {
        String buffer = new StringBuffer(String.join("", strings)).reverse().toString();
        int[] S = {0};
        return Arrays.stream(strings).map(V -> buffer.substring(S[0], S[0] += V.length())).toArray(String[]::new);
    }

    //Longest word in sentense
    static int length(String sentence) {
        try {
            String longest = Arrays.stream(sentence.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null);
            return longest.length();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    //Implement method findMultiplex(x, n) which returns array of the first x multiplies of the real number n
    static int[] findMultiples(int x, int n) {
        int[] multiples = new int[x];
        for(int i = 0; i < x; i++) {
            multiples[i] = n * (i + 1);
        }
        return  multiples;
    }

    //Implement method hasNoneLetter. It returns true if none of the letters is in a blacklist. Else - false
    static boolean hasNoneLetters(String blacklist, String phrase){
        char[] c1 = blacklist.toCharArray();
        char[] c2 = phrase.toCharArray();
        for(int i =0; i <  c1.length; i++){
            for(int j = 0; j < c2.length; j++){
                if (c1[i] == c2[j]){
                    return false;
                }
            }
        }
        return true;
    }

    //Write a function, which takes a non-negetive integer and returns a time in the format HH:MM:SS
    static String humanReadable(int seconds) {
        int hours = seconds / 3600, minutes = seconds / 60 % 60, newSeconds = seconds %  60;
        return formatDate(hours) + ':' + formatDate(minutes)+ ':' + formatDate(newSeconds);
    }

    static String formatDate(int n){
        return n > 9 ? Integer.toString(n) : '0' + Integer.toString(n);
    }

}

