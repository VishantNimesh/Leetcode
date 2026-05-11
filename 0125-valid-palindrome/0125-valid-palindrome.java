// class Solution {
//     public boolean isPalindrome(String s) {
//         int n = s.length();
//         for(int i = 0; i < s.length()/2; i++) {
//             if(s.charAt(i) != s.charAt(n-i-1)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }



class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer forward if character is not alphanumeric
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } 
            // Move right pointer backward if character is not alphanumeric
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } 
            // Compare characters after converting both to lowercase
            else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}