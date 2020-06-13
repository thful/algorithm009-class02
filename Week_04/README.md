## 深度优先搜索(Depth First Search)/广度优先搜索(Breadth First Search)
> - 是遍历`树`和`图`这两种数据结构中最常见的方法 是一种循环或递归写法的常见约定
> - 常规的搜索每个节点都要访问一次
> - 每个节点仅仅访问一次
> - 对于节点的访问顺序不限
>  - 深度优先：Depth First Search
>  - 广度优先：Breadth First Search
>  - 优先极搜索：启发式搜索(深度学习)


## 定义二叉树
```java
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
```

## 深度优先搜索-DFS
> - **使用DFS解决问题时最先想到的应该是 `递归` 和 `栈`**
> - DFS是从起始顶点开始 递归访问其所有邻近节点
> - 比如A节点是其第一个邻近节点 而B节点又是A的邻近节点 则DFS访问A节点后再访问B节点
> - 如果B节点有未访问的邻近节点的话将继续访问其邻近节点 否则继续访问A的未访问邻近节点
> - 当所有从A节点出去的路径都访问完之后 继续递归访问除A节以外未被访问的邻近节点

### DFS递归实现遍历二叉树
```java
// DFS递归实现
public void DFSWithRecursion(TreeNode root) {
    if (root == null) return;
    // 在这里处理遍历到的TreeNode节点
    if (root.left != null)
        DFSWithRecursion(root.left);
    if (root.right != null)
        DFSWithRecursion(root.right);
}
```

### DFS迭代实现遍历二叉树
```java
// 用Stack实现DFS
public void DFSWithStack(TreeNode root) {
     if (root == null) return;
     Stack<TreeNode> stack = new Stack<>();
     stack.push(root);
     while (!stack.isEmpty()) {
         TreeNode treeNode = stack.pop();
         // 在这里处理遍历到的TreeNode
         if (treeNode.right != null)
             stack.push(treeNode.right);
         if (treeNode.left != null)
             stack.push(treeNode.left);
     }
}
```

## 广度优先搜索-BFS
> - **使用BFS解决问题的时候最先想到的方式应该是`队列`**
> - 从起即点开始 将其邻近的所有顶点都加到一个去 标记这些顶点离起始点的距离为1 最后将起始顶点标记为已访问 今后就不会再访问
> - 再从队列中取出最先进队的顶点A 也取起其周边邻近节点 加入队列末尾 最后离开这个顶点A
> - 依次下去 直到队列为空为止 因为已访问的节点不会再访问所以每个节点最多被访问1次
```java
// 使用Queue实现BFS
public void BFSWithQueue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode treeNode = queue.poll();
        // 在这里处理遍历到的TreeNode节点
        if (treeNode.left != null)
            queue.add(treeNode.left);
        if (treeNode.right != null)
            queue.add(treeNode.right);
    }
}
```

### 定义N叉树
```java
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
```
> - 只需要把上面的代码用每个节点再循环即可


### 如何遍历图
> - 图和树的最大区别在于图的一下个节点可能指向已访问过的节点
> - 因此在使用BFS或DFS遍历时 应该维护一个Set 存放已被访问过的节点 在遍历时先判断节点未被访问过再遍历即可
```java
// 遍历图
public void BFSWithQueue(Node root) {
    Queue<Node> queue = new LinkedList<>();
    if (root != null) queue.add(root);
    Set<Node> visited = new HashSet<>();
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        visited.add(node);
        // 在这里处理遍历到的Node节点
        if (node.children != null) {
            for (Node child : node.children) {
                if (child != null && !visited.contains(child){
                    queue.add(child);
                }
            }
        }
    }
}
```

## 贪心算法 Greedy
> - `贪心算法`是一种在每一步选择中都采取在当前状态下最好或最优的选择 从而希望导致结果是全局最好或最优的算法
> - `念心算法`与`动态规划`的不同在于它对每个子问题的解决方案都做出选择 不能回退
> - `动态规划`则会保存以前的运算结果 并根据以前的结果对当前进行选择 有回退功能
> - 关联算法的区别
>  - 贪心：当下做局部最优判断
>  - 回溯：能够回退
>  - 动态规划：最优判断+回退
> - 贪心算法可以解决一些最优化的问题 `求图中的最小生成树` `求哈夫曼编码`
> - 对生工程或生活中的问题 `贪心算法`一般不能得到我们所要求的答案
> - 一旦一个问题可以通过`贪心算法`来解决 那么`贪心算法`一般是解决这个问题的最好办法
> - 由于`贪心算法`的高效性和其所求得的答案比较接近最优结果 `贪心算法`也可以用作铺助算法或直接解决一些要求结果不特别精确的问题

### 适用贪心算法的场景
> - 问题能够分解成子问题来解决 子问题的最优解能够递推到最终问题的最优解 这种子问题最优解称为最优子结构

## 二分查找
> - `二分查找`是一种主要针对`数组`的折半查找的常用策略

### 二分查找的必要前提
> - 目录函数的单调性 即递增或递减
> - 存在上下界
> - 能够通过索引访问

### 二分查找的标准代码模版
```java
public int BinarySearch(int[] arr,int key){
	int left = 0;
	int right = arr.length-1;
	int middle = 0;
	if(key < arr[left] || key > arr[right] || left > right) return -1;
	while(left <= right){
		middle = (left + right) / 2;
		// 比关键字大则关键字在左区域
		if(arr[middle] > key){ right = middle - 1; }
		// 比关键字小则关键字在右区域
		else if(arr[middle] < key ){ left = middle + 1; }
		else { return middle; }
	}
	return -1;
}
```