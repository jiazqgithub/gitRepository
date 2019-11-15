/**
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *         示例 1:
 *
 *         输入: 123
 *         输出: 321
 *          示例 2:
 *
 *         输入: -123
 *         输出: -321
 *         示例 3:
 *
 *         输入: 120
 *         输出: 21
 *
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/reverse-integer
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

package jia.code;

public class reverse {

    public int toReverse(int x) {

        StringBuffer buf=new StringBuffer();
        if(x>-2147483648||x<2147483647){
            int y=Math.abs(x);
            String s=String.valueOf(y);
            char[] ch=s.toCharArray();
            for(int i=ch.length-1;i>=0;i--){
                buf.append(ch[i]);
            }
            String str=buf.toString();
            try{
                int num=Integer.parseInt(str);
                if(x>=0)
                    x=num;
                if(x<0)
                    x=-num;
                return x;
            }catch(NumberFormatException e){
                System.out.println("NumberFormatException!please input the integer again!");
                return 0;
            }
        }else{
            return 0;
        }

    }

}
