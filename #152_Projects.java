public int jobScheduling(int[] startingDays, int[] endingDays, int[] money) {
    int n = startingDays.length;
    int[][] jobs = new int[n][3];
    for (int i = 0; i < n; i++) {
        jobs[i] = new int[] {startingDays[i], endingDays[i], money[i]};
    }
    Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
    TreeMap<Integer, Integer> dp = new TreeMap<>();
    dp.put(0, 0);
    for (int[] job : jobs) {
        int cur = dp.floorEntry(job[0]).getValue() + job[2];
        if (cur > dp.lastEntry().getValue())
            dp.put(job[1], cur);
    }
    return dp.lastEntry().getValue();
}
/*
Time Complexity:

Sorting the jobs based on ending times takes O(n log n) time, where 'n' is the number of jobs.
The loop that iterates through the sorted jobs takes O(n) time.
Within the loop, operations on the TreeMap take logarithmic time complexity, O(log n).
Therefore, the overall time complexity is O(n log n).

Space Complexity:

The space complexity primarily depends on the size of the input and the internal data structures used.
The array 'jobs' takes O(n) space.
The TreeMap 'dp' stores at most 'n' entries, so it takes O(n) space.
Overall, the space complexity is O(n).

Explanation:

The code starts by converting the input arrays into a 2D array 'jobs' where each row represents a job with its start time, end time, and profit.
The jobs are then sorted based on their end times in ascending order.
A TreeMap 'dp' is used to keep track of the maximum profit that can be obtained by the end of each day.
The TreeMap is initialized with a key-value pair of (0, 0), indicating that at the start of day 0, the profit is 0.
The loop iterates through each job:
'cur' is calculated as the maximum profit obtained by considering the current job.
If 'cur' is greater than the last known maximum profit, it is added to the TreeMap.
Finally, the last entry in the TreeMap contains the maximum profit that can be obtained.
This algorithm efficiently finds the maximum profit that can be earned by scheduling non-overlapping jobs.
*/