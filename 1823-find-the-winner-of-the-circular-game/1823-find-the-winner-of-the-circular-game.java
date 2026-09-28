class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int z = 0;

        for (int i = 1; i <= n; i++)
            arr.add(i);

        while (arr.size() != 1) {
            z = (z + k - 1) % arr.size();
            arr.remove(z);
        }

        return arr.get(0);
    }
}