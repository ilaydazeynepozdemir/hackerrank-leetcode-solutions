import java.util.Scanner;

class PalindromeCheck
{
    public static boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1)
            return true; 
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPalindrome(s.substring(1, s.length()-1));
        }
        return false;
    }

    public static void main(String[]args)
    {
    	//For capturing user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String for check:");
        String string = scanner.nextLine();
        /* If function returns true then the string is
         * palindrome else not
         */
        if(isPalindrome(string))
            System.out.println(string + " is a palindrome");
        else
            System.out.println(string + " is not a palindrome");
    }
}