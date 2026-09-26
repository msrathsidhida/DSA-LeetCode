import java.util.HashMap;
import java.util.Map;
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        // Characters and frequencies required from t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // Characters and frequencies in current window
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int have = 0;
        int needCount = need.size();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // Add current character to window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If this character has now reached its required frequency
            if (need.containsKey(c)
                    && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }
            // Try shrinking while window is valid
            while (have == needCount) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing it makes the window invalid
                if (need.containsKey(leftChar)
                        && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    have--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLength);
    }
}