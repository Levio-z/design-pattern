package com.divine.code.combinator.example_01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 统计文件数和大小 1.0
 *
 * @author zenith
 * @date 2025/03/26
 */
public class FileSystemNode1 {

    private String path;

    private boolean isFile;

    private List<FileSystemNode1> subNodes = new ArrayList<>();

    public FileSystemNode1(String path, boolean isFile) {

        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {

        if (isFile) {
            return 1;
        }
        int numOfFiles = 0;
        for (FileSystemNode1 node : subNodes) {
            numOfFiles += node.countNumOfFiles();
        }
        return numOfFiles;
    }

    public long countSizeOfFiles() {
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) return 0;
            return file.length();
        }
        long sizeofFiles = 0;
        for (FileSystemNode1 fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    public String getPath() {

        return path;
    }

    public void addSubNode(FileSystemNode1 fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode1 fileOrDir) {

        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }

}
