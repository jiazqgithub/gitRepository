package jia.test;

import jia.code.Z_convert;
import jia.code.findMedian;
import jia.code.longestPalindrome;
import jia.code.reverse;
import org.junit.Test;

public class LeetCodeTest {


    @Test
    public void findMedianTest(){

        findMedian f = new findMedian();
        int[] arr1 = {1,3};
        int[] arr2 = {2};

        double returnValue = f.findMedianSortedArrays(arr1 , arr2);

        System.out.println(returnValue);

    }

    @Test
    public void longestPalindromeTest(){

        String s = "baradgk";
        //String s = "babb";
        longestPalindrome longestPalindrome = new longestPalindrome();
        String returnValue = longestPalindrome.longestPalindrome(s);
        System.out.println(returnValue);


    }


    @Test
    public void Z_convertTest(){

        String s = "LEETCODEISHIRING";
        Z_convert z = new Z_convert();
        String result = z.convert(s,3);
        System.out.println(result);

    }

    @Test
    public void reverseTest(){

        reverse r = new reverse();
        System.out.println(r.toReverse(-12003));

    }


}
