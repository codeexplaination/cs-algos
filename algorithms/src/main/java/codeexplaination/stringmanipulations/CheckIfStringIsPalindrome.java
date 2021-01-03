package codeexplaination.stringmanipulations;

public class CheckIfStringIsPalindrome {
    public static Boolean isPalindrome(String input) {
        if (input != null) {
            int start = 0;
            int end = input.length() - 1;

            while (start < end) {
                if (input.charAt(start) != input.charAt(end)) {
                    return false;
                }

                start++;
                end--;
            }

        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "MADAM";
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

        input = "MAD";
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

        input = "KAYAK";
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

        input = "CIVIC";
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

        input = "";
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

        input = null;
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

        input = "LEVEL";
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

        input = "LEEL";
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

        input = "LEAD";
        System.out.println("String " + input + " is palindrome=" + isPalindrome(input));

    }
}
