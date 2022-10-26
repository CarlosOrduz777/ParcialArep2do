package com.palindrome;

public class Palindrone {



    public static boolean isPalindrome(String word){
        char[] array = word.toCharArray();
        int limit  = (array.length / 2) - 1;
        int j = array.length -1;

        boolean isPal = true;
        for (int i = 0; i < limit; i++) {
            if(array[i] != array[j]){
                isPal = false;
                break;
            }
            j--;
        }
        return isPal;

    }
}
