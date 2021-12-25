package com.mars.leetcode.sort;

public class Offer45 {

    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder builder = new StringBuilder();
        for (int num: nums) {
            builder.append(num);
        }
        return builder.toString();
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int mark = left;
        int pivot = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (lessThan(nums[i], pivot)) {
                mark++;
                int temp = nums[mark];
                nums[mark] = nums[i];
                nums[i] = temp;
            }
        }
        nums[left] = nums[mark];
        nums[mark] = pivot;
        return mark;
    }

    public boolean lessThan(int x, int y) {
        String sx = String.valueOf(x);
        String sy = String.valueOf(y);
        return (sx + sy).compareTo(sy + sx) < 0;
    }
    
    public static void main(String[] args) {
        Offer45 offer45 = new Offer45();
    }

}
