class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int min = nums[0];
       int max = nums[0];
       for(int i = 0; i < nums.length; i++) {
        min = Math.min(min, nums[i]);
        max = Math.max(max, nums[i]);
        }
        int[] freq = new int[max - min + 1];
        for(int i=0; i<nums.length; i++){
            freq[nums[i] - min]++;
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int i=0; i<freq.length; i++){
            if(freq[i] > 0){
                if(bucket[freq[i]] == null){
                    bucket[freq[i]] = new ArrayList<>();
                }
                bucket[freq[i]].add(i + min);
            }
        }
        int[] ans = new int[k];
        int index = 0;

        for(int i = bucket.length - 1; i>=0; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    ans[index++] = num;

                    if(index == k){
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}
