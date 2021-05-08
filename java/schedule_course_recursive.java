//Leetcode
//630. Course Schedule III
//Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
//Output: 3
//Result: too slow
//Time complexity : O(n*d)O(n∗d). memomemo array of size nnxdd is filled once. 
//Here, nn refers to the number of courses in the given coursescourses array and 
//dd refers to the maximum value of the end day from all the end days in the coursescourses array.
class Schedule_Course_Recursive {
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
