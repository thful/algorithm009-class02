## 字典树 Trie
> - 字典树即Trie树 是一种多叉树型结构 也叫前缀树
> - 典型应用是用于统计和排序大量的字符串(不仅限) 所以经常被搜索引擎用于文本词频统计
> - 优点：最大限度地减少无谓的字符串比较 查询效率比哈希表高
![](index_files/13696a48-bdc3-4aef-aeb3-0717fe8e60be.jpg)

### 字典树的基本性质
> - 结点本身不存完整单词
> - 从根结点到某一结点 路径上经过的字符连接起来 为该结点对应的字符串
> - 每个结点的所有子结点路径代表的字符都不相同

### 字典树的核心思想
> - 核心思想是空间换时间
> - 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

### 字符树存在的意义
> - 尽量哈希表可以在O(1)时间内寻找键值 即可法高效完成以下操作
>  - 找到具有同一前缀的全部链值
>  - 按词典序枚举字符串的数据集
> - 字典树优于哈希表的另一个理由是：随着哈希表大小增加 会出现大量的冲突 时间可能增加到O(n) 其中n是插入键的数量
> - 与哈希表相比 字典树在存储多个具有相同前缀的键时可以使用较少的空间 此时字典树只需要O(m)的时间复杂度 其中m为键长 而在AVL树中查找键值需要O(nlogn)时间复杂度

## 代码实现
```java
class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;
    public TrieNode() {
        links = new TrieNode[26];
    }
    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
```
```java
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }
    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
}
```

## 作业
> - 分析单词搜索2 用 Tire 树方式实现的时间复杂度
>  - 因为要先遍历一遍单词数组 所以时间复杂度为O(n) 插入字典树复杂度为O(1)
>  - 再遍历二维数组时间复杂度是O(m*m) 遍历二维数组内部递归调用 递归深度是单词的长度平均为4
>  - 综上所述 时间复杂度为O(n+1+m*m*4)

## 并查集 Disjoint Set
> - 主要解决组团与配对问题 多应用于组群关系与朋友圈之类的概念
> - 初始化 每个元素的`parent`都指向自己
![](index_files/3544a86d-1fa0-4d2a-82aa-776ccb66821e.jpg)
> - 查询的时候就是一直往上找`parent`如果找到了`parent`等于自己的元素 那么这个元素就是集合的领头元素
> - 合并是把两个集合其中的一个的`parent`指向另外一个的`parent` 把`e`指向`a`是合并 把`a`指向`e`也可以
![](index_files/d68b14d0-a2fc-4ce8-b0d4-cb6035b37e8b.jpg)
> - 路径压缩
![](index_files/aeb7136e-cbf2-4041-b268-3845beaa370f.jpg)

## 代码模块
> - `makeSet(s)`：建立一个新的并查集 其中包含`s`个单元素的集合
> - `unionSet(x,y)`：把元素`x`和元素`y`所在的集合进行合并 要求`x`和`y`所在的集合不相交 如果相交则不合并
> - `find(x)`：找到元素`x`所在的集合的代表 该操作也可以用于判断两个元素是否位于同一个集合 只要将它们各自的代表比较一下就可以了
```java
class UnionFind {
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
```