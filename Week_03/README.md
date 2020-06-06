## 递归
> - 计算机的汇编中 是没有循环的概念 只有通过递归来模拟循环
> - 递归就是通过函数体来进来的循环
>  - 从前有座山
>  - 山里有个庙
>  - 庙里有个老和尚在给小和尚讲故事
>  - 从前有座山……

### 递归的思维要点
> - 不要人肉递归
> - 找最近重复性 找到最近最简方法 将其拆解成可重复解决的问题（重复子问题）
> - 数学归纳法思维

### 递归标准模版
```java
public void recur(int level, int param) {
  // 1.递归终止条件
  if (level > MAX_LEVEL) { return; }
  // 2.处理当前层逻辑
  process(level, param);
  // 3.下探到下一层
  recur(level: level + 1, newParam);
  // 4.清理当前层(可选)
}
```

### 递归的简单实验
```java
public static void main(String[] args) {
    int val = 10;
    // 0 1 2 3 4 5 6 7 8 9
    testrecursion1(val);
    // 10 9 8 7 6 5 4 3 2 1
    testrecursion2(val);
}
public static void testrecursion1(int val) {
    if (val <= 0) return;
    testrecursion(--val);
    System.out.println(val);
}
public static void testrecursion2(int val) {
    if (val <= 0) return;
    System.out.println(val);
    testrecursion(--val);
}
```

## 分治(Divide & Conquer)
> - 分治和回溯本质上是一种复杂的递归 是递归的一种分类
> - 不管是递归 分治还是回溯 其实最后本质上就是找重复性以及分解问题和最后组合每个子问题的结果
> - 分治法是将原始问题分解成子问题 再通过每个子问题进行递归答案 将子问题的答案合并之后得到原始问题的答案

### 分治标准代码模板
```java
public static String divide_conquer(String problem, int param1, int param2) {
    // 1.递归终止条件
    String result = null;
    if (problem == null) return result;
    // 2.处理当前层逻辑
    // 模拟拿到结果
    List<String> list = new ArrayList<>();
    System.out.println(problem);
    // 3.下探到下一层
    String res1 = divide_conquer(list.get(0), param1, param2);
    String res2 = divide_conquer(list.get(1), param1, param2);
    String res3 = divide_conquer(list.get(2), param1, param2);
    // 4.组装结果并组合返回(这是和常规递归多的一种)
    result = res1 + res2 + res3;
    return result;
    // 5.清理当前层(可选)
}
```

## 回溯(Backtracking)
> - 回溯法采用试错的思想 它尝试分步的去解决一个问题
> - 在最坏的情况下 回溯法会导致一次复杂度为指数的时间的计算

## 总结
> - 递归不是一定会比迭代慢 而是迭代的一种有效补充
> - 迭代很难处理的循环体 反而递归会有一种良好的可执行性