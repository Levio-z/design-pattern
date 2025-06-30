package com.divine.code.memento.text2;

import java.util.Stack;

public class SnapshotHolder {
    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }

    public Stack<Snapshot> getSnapshots() {

        return snapshots;
    }

}
