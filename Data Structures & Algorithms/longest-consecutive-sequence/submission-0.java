class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        for(int it:set){
            if(!set.contains(it-1)){
                int cnt=1;
                int x = it;
                while(set.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
                longest = Math.max(longest,cnt);
            }
        }
        return longest;
    }
}
