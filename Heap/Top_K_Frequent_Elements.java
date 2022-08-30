/*
347. Top K Frequent Elements
-----------------------------
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order. 

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(int key:map.keySet()){
            pq.add(key);
            if(pq.size()>k)
                pq.poll();
        }
        int i=0;
        int[] res=new int[k];
        while(!pq.isEmpty()){
            res[i++]=pq.poll();
        }
        
        return res;
    }
}
