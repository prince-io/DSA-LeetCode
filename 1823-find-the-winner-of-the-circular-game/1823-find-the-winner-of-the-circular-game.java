class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        List<Integer> part = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            arr.add(i);

        int z = 0;

        while (arr.size() != 1) {
            // for (int i = 1; i < k; i++) {
            //     int x = arr.remove(0);
            //     arr.add(x);
            // }

            z = (z + k - 1) % arr.size();
            arr.remove(z);

            // int y = (k-1) % arr.size() ;

            // part = arr.subList(0, y);
            // arr.subList(0, y).clear();

            // arr.addAll(part);

            
            // arr.remove(0);
        }

        return arr.get(0);
    }
}