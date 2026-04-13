class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String s : operations) {
            if (s.equals("+")) {
                int sum = list.get(list.size() - 1) + list.get(list.size() - 2);
                list.add(sum);
            } else if (s.equals("D")) {
                int num = list.get(list.size() - 1) * 2;
                list.add(num);
            } else if (s.equals("C")) {
                list.remove(list.size() - 1);
            } else {
                list.add(Integer.parseInt(s));
            }
        }
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}