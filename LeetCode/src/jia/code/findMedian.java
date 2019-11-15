package jia.code;

import java.util.Arrays;

/**
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 *
 */

public class findMedian {

    public static void main(String[] args){

        int[] arr1 = {1,3};
        int[] arr2 = {2};

        double returnValue = findMedianSortedArrays(arr1 , arr2);



    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double returnValue = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] nums = new int[len];

        System.arraycopy(nums1,0,nums,0,len1);
        System.arraycopy(nums2,0,nums,len1,len2);
        Arrays.sort(nums);

        if (len%2 == 0){
            int index = len/2;
            double test1 = nums[index-1];
            double test2 = nums[index];
            returnValue = (test1 + test2)/2;

        }else{
            int index = len/2;
            returnValue = nums[index];
        }

        return returnValue;
    }

}



