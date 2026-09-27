class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        int[] countP= new int[26];
        int[] countWindow= new int[26];
        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i) - 'a']++;
        }

        int left=0;
        for(int right=0; right< s.length(); right++){
            countWindow[s.charAt(right) - 'a']++;
            if (right-left+1 > p.length()){
                countWindow[s.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1== p.length() && matches(countP, countWindow)){
                result.add(left);
            }
        }
        return result;
    }
    private boolean matches(int[] countP, int[] countWindow){
        for(int i=0; i<26; i++){
            if (countP[i] != countWindow[i]){
            return false;}
        }
        return true;
    }
}