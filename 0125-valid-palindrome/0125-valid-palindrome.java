class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) sb.append((char) ((int) s.charAt(i) + 32));

            else if ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122) sb.append(s.charAt(i));

            else if ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57) sb.append(s.charAt(i));
        }

        sb.toString();
        
        int x = 0;
        int y = sb.length()-1;

        while (x <= y) {
            if (sb.charAt(x) == sb.charAt(y)) {
                x++;
                y--;
            }
            else return false;
        }

        return true;
    }
}