
public class SlidingWindow {
    public  static  int [] maxSlidingWindow(int [] nums,int k) {
            int[] res = new int[nums.length - k + 1];
            LinkedList<Integer> l = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {

                l.add(nums[i]);
    //          循环当 集合长度等于 k 吧0 位置数据 添加至res
                if (l.size() == k) {
                    res[i - k+1] = Collections.max(l);
                    l.removeFirst();
                }
            }
            return res;
        }
}