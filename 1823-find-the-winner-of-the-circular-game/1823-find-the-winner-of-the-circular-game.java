class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            arr.add(i);

        while (arr.size() != 1) {
            for (int i = 1; i < k; i++) {
                int x = arr.remove(0);
                arr.add(x);
            }
            arr.remove(0);
        }

        return arr.get(0);
    }
}