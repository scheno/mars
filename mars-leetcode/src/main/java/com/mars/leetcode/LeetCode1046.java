import java.util.PriorityQueue;

/**
 * LeetCode1046.最后一块石头的重量
 */
public class LeetCode1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a != b) {
                queue.offer(Math.abs(a - b));
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
    
}
