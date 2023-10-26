class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int len = arr.length;
        // 0: numerator idx, 1: denominator idx
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int s1 = arr[o1[0]] * arr[o2[1]];
                int s2 = arr[o2[0]] * arr[o1[1]];
                return s1 - s2;
            }
        });
        for (int i = 0; i < len-1; i++) {
            pq.add(new int[]{i, len-1});
        }
        for (int i = 0; i < k-1; i++) {
            int[] pop = pq.remove();
            int ni = pop[0];
            int di = pop[1];
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.add(pop);
            }
        }

        int[] peek = pq.peek();
        return new int[]{arr[peek[0]], arr[peek[1]]};
    }
}
