package com.leetcode.medium;

//630. Course Schedule III
//Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
//Output: 3
//Result: too slow
//Time complexity : O(n*d)O(n∗d). memomemo array of size nnxdd is filled once. 
//Here, nn refers to the number of courses in the given coursescourses array and 
//dd refers to the maximum value of the end day from all the end days in the coursescourses array.
class ScheduleCourseRecursive {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Integer[][] memo = new Integer[ courses.length][courses[courses.length -1][1] + 1];
        return schedule(courses, 0, 0, memo);
    }
    
    public int schedule(int[][] courses, int i, int time, Integer[][] memo ){
        if ( i == courses.length)
            return 0;  //finish
        if ( memo[i][time] != null)
            return memo[i][time]; //taken index;
        int taken =0;
        if ( time + courses[i][0] <= courses[i][1])
            taken = 1 + schedule( courses, i+1, time + courses[i][0], memo); 
        int noTaken = schedule(courses, i+1, time, memo);
        memo[i][time] = Math.max(taken, noTaken);
        return memo[i][time];
    }
}

// Time complexity : O(n^2). We iterate over the countcount array of size nn once. 
// For every element currently considered, we could scan backwards till the first element, 
// giving O(n^2) complexity. Sorting the countcount array takes O(nlogn) time for countcount array.

// Space complexity : O(1). Constant extra space is used.

public class ScheduleCourseIterative {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        for (int i = 0; i < courses.length; i++) {
            if ( time + courses[i][0] <= courses[i][1]){
                time += courses[i][0];
                 courses[count++] = courses[i];
            }else{
                int max_i = i;
                for (int j=0; j < count; j++){  //find the largest to drop 
                    if( courses[j][0] > courses[max_i][0] ){
                        max_i = j;
                    }
                }
                if ( courses[max_i][0] > courses[i][0]){
                    time +=  courses[i][0]- courses[max_i][0];
                    courses[max_i] = courses[i];
                }
                
            }
            
        }
        return count;
    }
}



//Time complexity : O(nlogn). At most nn elements are added to the queuequeue. 
//Adding each element is followed by heapification, which takes O(logn) time.
//Space complexity : O(n). The queuequeue containing the durations of the courses taken can have atmost nn elements
public class ScheduleCoursePriorityQueue {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue < Integer > queue = new PriorityQueue < > ((a, b) -> b - a);
        int time = 0;
        for (int[] c: courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }
}
