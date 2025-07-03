# Java 文件排序策略设计与优化说明

## 一、设计目标

根据文件大小采用不同排序策略，提高性能与资源利用率：

- 小文件：QuickSort
- 中等文件：ExternalSort
- 大文件：ConcurrentExternalSort
- 超大文件：MapReduceSort

---

## 二、策略模式结构

### 策略接口

```java
public interface ISortAlg {
    void sort(String filePath);
}
```

### 策略实现类

```java
public class QuickSort implements ISortAlg {
    public void sort(String filePath) {
        System.out.println("使用 QuickSort 排序：" + filePath);
    }
}

public class ExternalSort implements ISortAlg {
    public void sort(String filePath) {
        System.out.println("使用 ExternalSort 排序：" + filePath);
    }
}

public class ConcurrentExternalSort implements ISortAlg {
    public void sort(String filePath) {
        System.out.println("使用 ConcurrentExternalSort 排序：" + filePath);
    }
}

public class MapReduceSort implements ISortAlg {
    public void sort(String filePath) {
        System.out.println("使用 MapReduceSort 排序：" + filePath);
    }
}
```

---

## 三、策略工厂

```java
public class SortAlgFactory {
    private static final Map<String, ISortAlg> algs = new HashMap<>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
        algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        algs.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        return algs.get(type);
    }
}
```

---

## 四、Sorter 初始版本（if-else）

```java
public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg;

        if (fileSize < 6 * GB) {
            sortAlg = SortAlgFactory.getSortAlg("QuickSort");
        } else if (fileSize < 10 * GB) {
            sortAlg = SortAlgFactory.getSortAlg("ExternalSort");
        } else if (fileSize < 100 * GB) {
            sortAlg = SortAlgFactory.getSortAlg("ConcurrentExternalSort");
        } else {
            sortAlg = SortAlgFactory.getSortAlg("MapReduceSort");
        }

        sortAlg.sort(filePath);
    }
}
```

---

## 五、查表法优化（消除分支）

### 数据结构与注册

```java
private static final List<AlgRange> algs = new ArrayList<>();

static {
    algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("QuickSort")));
    algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getSortAlg("ExternalSort")));
    algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
    algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
}
```

### 使用逻辑

```java
public void sortFile(String filePath) {
    File file = new File(filePath);
    long fileSize = file.length();

    for (AlgRange range : algs) {
        if (range.inRange(fileSize)) {
            range.getAlg().sort(filePath);
            return;
        }
    }
    throw new IllegalStateException("未匹配到合适的策略");
}
```

### 区间绑定类

```java
private static class AlgRange {
    private long start, end;
    private ISortAlg alg;

    public AlgRange(long start, long end, ISortAlg alg) {
        this.start = start;
        this.end = end;
        this.alg = alg;
    }

    public boolean inRange(long size) {
        return size >= start && size < end;
    }

    public ISortAlg getAlg() {
        return alg;
    }
}
```

---

## 六、优点总结

| 优点 | 说明 |
|------|------|
| 解耦 | 策略定义、创建、使用完全分离 |
| 可扩展 | 添加新策略无需修改核心逻辑 |
| 清晰 | 查表逻辑一目了然，避免嵌套分支 |
| 工程化 | 支持外部配置、热更新、策略注入 |

---

## 七、示例输出

```
使用 ConcurrentExternalSort 排序：data/bigdata.log
```

---

## 八、运行入口示例

```java
public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.sortFile("data/bigdata.log");
    }
}
```
