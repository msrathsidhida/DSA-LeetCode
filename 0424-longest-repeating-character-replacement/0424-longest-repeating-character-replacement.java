class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            int index = s.charAt(right) - 'A';
            count[index]++;

            // Update maximum frequency
            maxFreq = Math.max(maxFreq, count[index]);

            // If window needs too many replacements
            while ((right - left + 1) - maxFreq > k) {

                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;

                left++;
            }

            // Update maximum valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}