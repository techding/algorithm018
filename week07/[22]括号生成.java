//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1394 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrace(res, 0, 0, n, "");
        return res;
    }

    private void backtrace(List<String> res, int left, int right, int max, String s) {
        if (left == max && right == max) {
            res.add(s);
            return;
        }
        if (left < max) {
            backtrace(res, left + 1, right, max, s + "(");
        }
        if (right < left) {
            backtrace(res, left, right + 1, max, s + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
