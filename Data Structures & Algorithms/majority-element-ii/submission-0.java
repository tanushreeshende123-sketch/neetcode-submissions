class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int el1=0, el2=0;
        for(int i=0; i<nums.length; i++){
            if(cnt1==0 && el2!=nums[i]){
                el1 = nums[i];
                cnt1++;
            }else if(cnt2==0 && el1!=nums[i]){
                el2 = nums[i];
                cnt2++;
            }else if(el1==nums[i]){
                cnt1++;
            }else if(el2==nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==el1){
                cnt1++;
            }else if(nums[i]==el2){
                cnt2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if(cnt1 > n/3){
            result.add(el1);
        }
        if(cnt2 > n/3){
            result.add(el2);
        }
        return result;
    }
}