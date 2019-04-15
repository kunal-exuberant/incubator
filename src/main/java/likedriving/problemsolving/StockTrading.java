package likedriving.problemsolving;

import java.util.*;

public class StockTrading {

    public static void main(String[] args) throws Exception{

        List stockPrices = Arrays.asList(10,7,5,8,11,9);
        System.out.println(stockTrading(stockPrices));
    }


    private static int stockTrading(List<Integer> stockPrices) throws Exception{

        HashMap<String, Integer> ss = new HashMap<String, Integer>();

        ss.put("abc",3);


        if (stockPrices.size() < 2)
            throw new Exception();

        int minBuyingTime = 0;
        int maxSellingTime = 1;

        int maxProfit = stockPrices.get(maxSellingTime) - stockPrices.get(minBuyingTime);

        for (int stockTime = 2; stockTime < stockPrices.size(); stockTime++) {
            if(stockPrices.get(stockTime) - stockPrices.get(maxSellingTime) > maxProfit){
                maxSellingTime = stockTime;
            }
            maxProfit = stockPrices.get(maxSellingTime) - stockPrices.get(minBuyingTime);
            if(stockPrices.get(maxSellingTime) - stockPrices.get(stockTime-1) > maxProfit) {
                minBuyingTime = stockTime;
            }
            maxProfit = stockPrices.get(maxSellingTime) - stockPrices.get(minBuyingTime);
        }
        return maxProfit;
    }



    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            // this value can't be 0 because of the assumption made in the question
            int totalElements = nums1.length + nums2.length;

            boolean oddLength = true;
            int overallIndexCounter = 1,
                    num1Index=0,
                    num2Index=0;

            if(totalElements % 2 == 0)
                oddLength = false;

            if(oddLength){

                int medianIndex = totalElements/2,
                        fromArray = 0;

                while(num1Index < nums1.length && num2Index < nums2.length){
                    if(overallIndexCounter < medianIndex){
                        overallIndexCounter++;
                        if(nums2[num2Index] > nums1[num1Index]){
                            num1Index++;
                            fromArray = 0;
                        }
                        else{
                            num2Index++;
                            fromArray = 1;
                        }
                    }
                }
                if(fromArray == 0) return nums1[num1Index];
                else return nums2[num2Index];
            }
            else{
                int medianIndex1 = (totalElements -1) /2;
                int medianIndex2 = totalElements/2;
                int fromArray1 = 0, fromArray2 = 0;

                while(num1Index < nums1.length && num2Index < nums2.length){
                    if(overallIndexCounter < medianIndex1){
                        overallIndexCounter++;
                        if(nums2[num2Index] > nums1[num1Index]){
                            num1Index++;
                            fromArray1 = 0;
                        }
                        else{
                            num2Index++;
                            fromArray1 = 1;
                        }
                    }
                }

                while(num1Index < nums1.length || num2Index < nums2.length){
                    if(overallIndexCounter < medianIndex2){
                        overallIndexCounter++;
                        if(nums2[num2Index] > nums1[num1Index]){
                            num1Index++;
                            fromArray2 = 0;
                        }
                        else{
                            num2Index++;
                            fromArray2 = 1;
                        }
                    }
                }
                if(fromArray1 == 0 && fromArray2 == 0) return (nums1[num1Index-1] + nums1[num1Index])/2;
                else if(fromArray1 == 0 && fromArray2 == 1) return (nums1[num1Index] + nums1[num2Index])/2;
                else if(fromArray1 == 1 && fromArray2 == 0) return (nums1[num1Index] + nums1[num2Index])/2;
                else return (nums2[num1Index] + nums2[num1Index])/2;

            }
        }
    }





}
