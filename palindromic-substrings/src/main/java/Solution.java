class Solution {
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                if (isPalindromic(subString)) {
                    count++;
                }
            }
        }
        return count;
    }

    /*public static boolean isPalindromic(String subs) {
        if (subs.length() == 0 || subs.length() == 1) {
            return true;
        }
        if (subs.charAt(0) == subs.charAt(subs.length() - 1)) {
            return isPalindromic(subs.substring(1, subs.length() - 1));
        }
        return false;
    }*/

    /**
     * https://www.geeksforgeeks.org/java-program-to-find-all-palindromic-sub-strings-of-a-string/
     *
     * @param subS
     * @return
     */
    public static boolean isPalindromic(String subS) {
        int size = subS.length();

        // Iterating over string till midway to
        // check palindromic behavior
        for (int i = 0; i < size / 2; i++) {

            if (subS.charAt(i)
                    != subS.charAt(size - i - 1)) {

                // Non-palindromic behavior
                return false;
            }
        }

        // Palindromic behavior
        return true;
    }

    public static void main(String[] args) {

        // Custom input string
        String str = "MALAYALAM";

        int count = countSubstrings(str);

        System.out.println(
                "No.of palindromic substrings in the given string are "
                        + count);
    }
}