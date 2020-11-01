//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 555 👎 0


import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
// 1. bucket sort
//class Solution {
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        List<Integer>[] bucket = new List[nums.length + 1];
//
//        for (int key : map.keySet()) {
//            int frequency = map.get(key);
//            if (bucket[frequency] == null) {
//                bucket[frequency] = new ArrayList<>();
//            }
//            bucket[frequency].add(key);
//        }
//
//        int[] res = new int[k];
//        int count = 0;
//        for (int i = bucket.length - 1; i >= 0 && count < k;  i--) {
//            if (bucket[i] != null) {
//                for (int num : bucket[i]) {
//                    res[count++] = num;
//                }
//            }
//        }
//        return res;
//    }
//}
// 2. priority queue
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        int[] res = new int[k];
        int count = 0;
        while (count < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res[count++] = entry.getKey();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
