## 位运算
> - 在机器里的数字表示方式和存储格式都是二进制

### 位运算符
|  含义 | 运算符  |  示例 |
| ------------ | ------------ | ------------ |
|  左移 |  `<<` | 0011 `-->` 0110  |
|  右移 |  `>>` | 0110 `-->` 0011  |
|  按位或 | `｜`  | 0011 & 1011 `-->` 1011  |
|  按位与 |  `&` | 0011 & 1011 `-->` 0011  |
|  按位取反 | `~`  | 0011 `-->` 1100  |
|  按位异步(相同为0不同为1) | `^`  |  0011 & 1011 `-->` 1000 |
> - 请注意：算术移位和逻辑移位的不同 
> - `https://www.cnblogs.com/hpcpp/p/6291710.html`
> - `https://blog.csdn.net/xzg_2017/article/details/80158215`
> - 一句话总结：算术左移和逻辑左移的效果是一样的 效果都是*2 而逻辑右移最高位补0 算术右移最高位补符号位


### 异或
> - 相同为0 不同为1
```java
x ^ 0 = x
// 注意 1s(全1) 就是 ~0(给0取反)
x ^ 1s = ~x
x ^ (~x) = 1s
x ^ x = 0
// 交换两个数
c = a ^ b => a ^ c = b , b ^ c = a
// associative
a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c
```

### 指定位置的位运算
> - 将x 最右边的n 位清零：`x& (~0 << n)`
> - 获取x 的第n 位值（0 或者1）：`(x >> n) & 1`
> - 获取x 的第n 位的幂值：`x& (1 <<n)`
> - 仅将第n 位置为1：`x | (1 << n)`
> - 仅将第n 位置为0：`x & (~ (1 << n))`
> - 将x 最高位至第n 位（含）清零：`x& ((1 << n) -1)`
> - 将第n 位至第0 位（含）清零：`x& (~ ((1 << (n + 1)) -1))`


### 位运算的实战
```shell
# 判断奇偶
原写法：x % 2 == 1  新写法：(x & 1) == 1
原写法：x % 2 == 0  新写法：(x & 1) == 0

原写法：x >> 1      新写法：x / 2
原写法：x = x / 2   新写法：x = x >> 1;
原写法：mid = (left + right) / 2   新写法：mid = (left + right) >> 1;

清零最低位的1：X = X & (X-1)
得到最低位的1：X & -X
0：X & ~X
```

## 布隆过滤器 Bloom Filter
> - 布隆过滤器与哈希表类似 但不需要像哈希表一样把元素的所有都存储起来 而是只存储当前元素有或无的一个反馈

### Bloom Filter vs Hash Table
> - 一个很长的`二进制向量`和一系列`随机映射函数`
> - 布隆过滤器可以用于检索一个元素是否在一个集合中
> - 优点是空间效率和查询的时间都远远超过一般的算法
> - 缺点是有一定的误识别率和删除困难

### 布隆过滤器示意图
> - 存储元素时会把一个元素分散在不同的二进制索引位中
> - 如果一个元素`w`如果在二进制位中有任意情况下不为1 那就代表不在此布隆过滤器中
> - 当一个元素去布隆过滤器查询如果不在 那么肯定就是不存在的
> - 当一个元素去布隆过滤器查询如果存在 可能是误识别 那么可能是存在的

### 布隆过滤器使用场景
> - 布隆过滤器一般是用在最外层的缓存 要最快速的判断的 可以允许有一定的误识别率 真要要判定一个元素是否存在一般还是要去查库的 最外层的缓存只是作为一个快速的缓冲来使用 一般常用的案例如下：
> - 比特币网络
> - 分布式系统(Map-Reduce) - Hadoop、search engine
> - Redis缓存
> - 垃圾邮件、评论等的过滤

### 别人已经写好的轮子
> - https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java
> - https://github.com/Baqend/Orestes-Bloomfilter

## LRU Cache
> - LRU(最近最少使用)缓存机制 是一种内存的替换算法 是指最新最近的元素永远被放到最上方 也是一种缓存淘汰策略
> - 内存替换算法有很多种实现：`https://en.wikipedia.org/wiki/Cache_replacement_policies`
> - `LRU Cashe`本质是`Hash Table` + `Double LinkedList`
> - O(1) 查询
> - O(1) 修改、更新
> - LFU - `Least Frequently(使用频次) Used` - 常被用在推荐系统中
> - LRU - `Least Recently(最新最近) Used` - 面试常用

### LRU Cache工作示例
> - 最新的数据认为它是最可能下一次用到的数据
> - 缓存不够时 把最旧的数据从缓存中移除空出空间
> - 最近被使用的元素 永远被翻新到最上面


## 排序 Sort
> - 比较类排序
> - 常使用对整数数据的排序
>  - 通过比较来决定元素间的相对次序 由于其时间复杂度不能突破O(nlogn) 因为也被称为非线性时间比较类排序

> - 非比较类排序
> - 常使用对字符或引用类型的排序
>  - 不通过比较来决定元素间的相对次序 它可以突存基于比较排序的时间下界 以线性时间运行 因此也被称为线性时间非比较类排序


### 常用的排序分类
> - 十大排序算法：`https://www.cnblogs.com/onepixel/p/7674659.html`

### 排序的优先级
> -  一般`堆排序` `快速排序` `归并排序`一般要求要手写 其它排序了解即可

## 初级排序
### 选择排序 Selection Sort
>   - 每次找最小值 然后放到待排序数组的起始位置
```java
public void selectionSort(int[] nums) {
	int length = nums.length;
	for (int i = 0; i < length - 1; i++) {
		int min = nums[i];
		int minindex = i;
		for (int j = i + 1; j < length; j++) {
			if (min > nums[j]) {
				min = nums[j];
				minindex = j;
			}
		}
		if (minindex != i) {
			nums[minindex] = nums[i];
			nums[i] = min;
		}
	}
}
```

### 插入排序 Insertion Sort
>   - 从前到后逐步构建有序序列 对于未排序数据 在已排序序列中从后向前扫描 找到相应位置并插入
```java
public void insertionSort(int[] nums) {
	int length = nums.length;
	for (int i = 1; i < length; i++) {
		int num = nums[i];
		int insert = 0;
		for (int j = i - 1; j >= 0; j--) {
			if (nums[j] > num) {
				nums[j + 1] = nums[j];
			} else {
				insert = j + 1;
				break;
			}
		}
		nums[insert] = num;
	}
}
```

### 冒泡排序 Bubble Sort
>   - 嵌套循环 每次查看相邻的元素 如果逆序就交换 与选择排序不同 每次循环会把最大值放到最后
```java
public void bubbleSort(int[] nums) {
	int length = nums.length;
	boolean need = true;
	for (int i = 1; i < length && need; i++) {
		need = false;
		for (int j = 0; j < length - i; j++) {
			if (nums[j] > nums[j + 1]) {
				int temp = nums[j];
				nums[j] = nums[j + 1];
				nums[j + 1] = temp;
				need = true;
			}
		}
	}
}
```

## 高级排序
### 快速排序 Quick Sort
>  - 是各种高级语言最常见的排序
>  - 数组取标杆 `pivot` 将小元素放到 `pivot` 左边 大元素放 `pivot` 右侧 然后依次对左边和右边的子数组继续快排 以达到整个序列有序

### 归并排序 Merge Sort
>  - 归并排序使用了分治的思想 是快速排序的逆向操作
>  - 把长度为n的输入序列分为两个长度为n/2的子序列
>  - 对这两个子序列分别采用归并排序
>  - 将两个排序好的子序列合并成一个最终的排序序列

### 归并与快排的区别
> - 归并和快排具有相似性 但步骤顺序相反
> - 快排：先调配出左右子数组 然后对左右子数组进行排序
> - 归并：先排序左右子数组 然后合并两个有序子数组

### 堆排序 Heap Sort
> - 堆插入O(logn) 取最大/小值O(1)
> - 数组元素依次建立小顶堆
> - 依次取堆顶元素并删除

## 特殊排序
### 计数排序 Counting Sort
> - 计数排序要求输入的数据必须是有确定范围的整数
> - 将输入的数值转化为键存储在额外开辟的数组空间中
> - 然后依次把计数大于1的填充回原数据

### 桶排序 Bucket Sort
> - 是计数排序的升级版
> - 假设输入数据服从均匀分布 将数据分到有限数量的桶里 每个桶再分别排序(有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序)

### 基数排序 Radix Sort
> - 基数排序是按照低位先排序 然后收集
> - 再按高位排序 然后再收集 依次类推直到最高位
> - 有时候有些属性是有优先级顺序的 先按低优先级排序 再按高优先级排序