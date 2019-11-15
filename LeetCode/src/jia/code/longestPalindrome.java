package jia.code;

/**
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */


/**
 * 思路：
 * 假设输入的字符串为 S ，首先我借助两个变量来保存最长回文字串的信息，分别为 l 和 j。其中 l 表示最长回文子串的长度，j 表示最长回文子串的尾字符在 S 中的下标。
 * 这样最后算法结束后，便可通过 l 和 j 定位到最长回文子串，并返回算法结果。另外还使用变量 ll 表示以当前字符为边界的最长回文子串的长度。
 * 算法的具体流程如下：
 * 如果当前遍历到 S 的第 i（从0开始）个字符（此时的 l 和 j 保存的是 S[0...i-1]的最长回文子串的信息），
 * 通过第 i-1 个字符的 ll 来判断当前字符有没有增加前一个最长回文子串的长度，如果增加了，则 ll 自增 2，
 * 此时更新后的 ll 代表的就是以第 i 个字符为边界的最长回文子串的长度。如果没有增加，就需要重新确定以第 i 个字符为边界的最长回文子串的长度，
 * 确认范围为从 ll+1 到 1。
 * ll 更新后，比较 ll 与 l 的大小，如果 ll 变得比 l 要大，则将当前 ll 的值赋给 l，i 的值赋给 j。
 * 上述流程的核心是，一定要在遍历的时候保证 ll 表示的一定是以当前字符为尾的最长回文子串的长度，这一点即本算法的循环不变式。遵循该循环不变式，
 * 遍历一遍 S 后即可得到结果。
 *
 * 作者：M_lear
 * 链接：https://www.jianshu.com/p/66b7a1934c82
 * 来源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */

public class longestPalindrome {

    public String longestPalindrome(String s) {

        if(s.length() <=1){
            return s;
        }
        int l = 1, j = 0, ll = 1;
        for(int i = 1; i < s.length(); ++i){
            //下面这个if语句就是用来维持循环不变式，即ll恒表示：以第i个字符为尾的最长回文子串的长度
            if(i - 1 - ll >= 0 && s.charAt(i) == s.charAt(i-1-ll))
                ll += 2;
            else{
                while(true){//重新确定以i为边界，最长的回文字串长度。确认范围为从ll+1到1
                    if(ll == 0||isPalindrome(s,i-ll,i)){
                        ++ll;
                        break;
                    }
                    --ll;
                }
            }
            if(ll > l){//更新最长回文子串信息
                l = ll;
                j = i;
            }
        }
        return s.substring(j-l+1, j+1);//返回从j-l+1到j长度为l的子串

    }

    public boolean isPalindrome(String s, int b, int e){//判断s[b...e]是否为回文字符串
        int i = b, j = e;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }

}
