class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;
        int i = 0;

        while (true) {
            if (tickets[k] == 0) break;

            if (tickets[i] > 0) {
                tickets[i]--;
                time++;
            }

            i = (i + 1) % n;
        }

        return time;
    }
}