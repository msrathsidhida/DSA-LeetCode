class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()> s2.length()){
            return false;
        }
        int[] count1= new int[26];
        int[] count2= new int[26];

        for (int i=0; i< s1.length(); i++){
            count1[s1.charAt(i) - 'a']++;
        }
        int left=0;

        for(int right=0; right<s2.length(); right++){
            count2[s2.charAt(right)- 'a']++;
            if (right-left+1>s1.length()){
                count2[s2.charAt(left)- 'a']--;
                left++;
            }
            if(right-left +1== s1.length() && matches(count1,count2)){
                return true;
            }
        }
        return false;

    }

    private boolean matches(int[] count1, int[] count2){
        for (int i=0; i<26; i++){
            if (count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
}