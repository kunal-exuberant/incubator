package likedriving.problemsolving.Array;
/*
https://leetcode.com/problems/insert-interval/

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public static void main(String[] args) {
       /* int [][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] newInterval = {4,8};*/

        int [][] intervals = {{1,3},{6,9}};
        int [] newInterval = {2,5};
        int [][] ans = insert(intervals, newInterval);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0]+","+ans[i][1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if(newInterval == null || newInterval.length == 0){
            return intervals;
        }

        int [][] ans = new int[1][2];
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0){
            ans[0] = newInterval;
            return ans;
        }

        int start = 0, end = intervals.length-1,  mid = -1, lowerbound = -1, upperbound = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (intervals[mid][1] < newInterval[0]) {
                start = mid + 1;
            } else if (intervals[mid][0] > newInterval[1]) {
                end = mid - 1;
            } else {
                System.out.println("overlapping case: mid=" + mid);
                break;
            }
        }
        // overlapping case, search lowerbound and upperbound indexes
        int ilstart = 0, ilend = mid + 1;

        while (ilstart <= ilend) {
            int ilmid = (ilstart + ilend) / 2;
            if (intervals[ilmid][1] < newInterval[0]) {
                ilstart = ilmid + 1;
            } else if (intervals[ilmid][0] > newInterval[0]) {
                ilend = ilmid - 1;
            } else {
                lowerbound = ilmid;
                break;
            }
        }
        int irstart = mid, irend = end;
        upperbound = lowerbound;
        while (irstart <= irend) {
            int irmid = (irstart + irend) / 2;
            if (intervals[irmid][1] < newInterval[1]) {
                irstart = irmid + 1;
            } else if (intervals[irmid][0] > newInterval[1]) {
                irend = irmid - 1;
            } else {
                upperbound = irmid;
                break;
            }
        }

        System.out.println("bounds: "+lowerbound+","+upperbound);

        int length = intervals.length;

        int [][] result = new int [length][2];
        int ir = 0;
        int [] mergedInterval = new int[2];
        for(int i=0; i<length; i++){
            if(i >= lowerbound && i <= upperbound){
                if(i == lowerbound){
                    //mergedInterval[0] = intervals[i][0];
                    mergedInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                }
                if(i == upperbound){
                    //mergedInterval[1] = intervals[i][1];
                    mergedInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                    result[ir] = mergedInterval;
                    ir++;
                }
            }
            else{
                result[ir] = intervals[i];
                ir++;
            }
        }

        ans = new int [ir][2];
        System.arraycopy(result, 0, ans, 0, ir);
        return ans;
    }
}
