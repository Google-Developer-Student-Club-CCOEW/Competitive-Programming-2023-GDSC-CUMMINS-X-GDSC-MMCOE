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
