package com.divine.code.strategy.file.use;

import com.divine.code.strategy.file.factory.SortAlgFactory;
import com.divine.code.strategy.file.strategy.ISortAlg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;
    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("QuickSort")));
        algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getSortAlg("ExternalSort")));
        algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
        algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
    }

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        extracted(filePath, file, fileSize);

        for (AlgRange algRange : algs) {
            if (algRange.inRange(fileSize)) {
                algRange.getAlg().sort(filePath);
                return;
            }
        }

        throw new IllegalStateException("未匹配到合适的排序算法");
    }

    private static void extracted(String filePath, File file, long fileSize) {
        System.out.println("当前路径为: "+System.getProperty("user.dir"));
        if (!file.exists()) {
            System.out.println("文件不存在: " + filePath);
        } else if (!file.isFile()) {
            System.out.println("目标不是普通文件: " + filePath);
        } else {
            System.out.println("文件存在，大小为: " + fileSize + " 字节");
        }
    }

    // 区间绑定的内部类
    private static class AlgRange {
        private final long start;
        private final long end;
        private final ISortAlg alg;

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
}
