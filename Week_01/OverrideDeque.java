import java.util.Arrays;

public class OverrideDeque {
    public static void main(String[] args) {
        /**
         Deque<String> deque = new LinkedList<String>();
         // 入队
         deque.push("a");
         deque.push("b");
         deque.push("c");
         System.out.println(deque);
         // 取得队尾元素
         String str = deque.peek();
         System.out.println(str);
         // 没有出队 队列数据无变化
         System.out.println(deque);
         // 依次出队
         while (deque.size() > 0) {
         System.out.println(deque.pop());
         }
         // 没有数据的情况下再次出队 会报异常java.util.NoSuchElementException
         //deque.pop();
         // 出队之后队列就没有数据了
         System.out.println(deque);
         */

        // -------------开始改写-----------------
        // 开始改写 addFirst(e) 	removeFirst() getFirst()
        //Deque<String> deque = new LinkedList<>();
        // 在队首添加
        //deque.addFirst("1");
        //deque.offerFirst("2");
        // 添加数据
        //deque.add("3");
        // 在队尾添加
        //deque.addLast("44");
        //deque.offerLast("33");
        // [2, 1, 3, 44, 33]
        //System.out.println(deque);

        // -------------出队数据-----------------
        /**
         // 出队队首数据
         String t1 = deque.removeFirst();
         // 2
         System.out.println(t1);
         // 出队队尾数据
         String t2 = deque.removeLast();
         // 33
         System.out.println(t2);
         // [1, 3, 44]
         System.out.println(deque);
         */

        // -------------获取数据-----------------
        /**
         // 获取队首数据 但不会改变队列本身
         String t3 = deque.getFirst();
         // 2
         System.out.println(t3);
         // 获取队尾数据 但不会改变队列本身
         String t4 = deque.getLast();
         // 33
         System.out.println(t4);
         // [2, 1, 3, 44, 33]
         System.out.println(deque);
         */

        // -------------Case-----------------
        // 把队列数据全部清空
        //while (deque.size() > 0) {
        //    System.out.println(deque.removeFirst());
        //}
        // 队列无数据出队会报异常：java.util.NoSuchElementException
        //System.out.println(deque.removeFirst());
        // 不会报异常 返回null
        //System.out.println(deque.pollFirst());

        // 队列无数据获取会报异常：java.util.NoSuchElementException
        //System.out.println(deque.getFirst());
        // 不会报异常 返回null
        //System.out.println(deque.peekLast());
    }
}
