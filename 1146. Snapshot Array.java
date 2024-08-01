import java.util.ArrayList;
import java.util.List;

class SnapshotArray {
    List<List<Record>> historyRecords;
    int snapId = 0;

    public SnapshotArray(int length) {
        historyRecords = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            List<Record> recordList = new ArrayList<>();
            recordList.add(new Record(0, 0));
            historyRecords.add(recordList);
        }
    }

    public void set(int index, int val) {
        List<Record> recordList = historyRecords.get(index);
        Record lastRecord = recordList.get(recordList.size() - 1);
        if (lastRecord.ver == snapId) {
            lastRecord.val = val;
        } else {
            recordList.add(new Record(val, snapId));
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<Record> recordList = historyRecords.get(index);
        int idx = nextSmallerElement(recordList, 0, recordList.size() - 1, snap_id);
        return recordList.get(idx).val;
    }

    private int nextSmallerElement(List<Record> recordList, int lo, int hi, int snap_id) {
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Record rec = recordList.get(mid);
            if (rec.ver == snap_id) {
                return mid;
            } else if (rec.ver > snap_id) {
                hi = mid - 1;
            } else {
                res = mid;
                lo = mid + 1;
            }
        }
        return res;
    }

    private class Record {
        int val;
        int ver;

        Record(int val, int ver) {
            this.val = val;
            this.ver = ver;
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
