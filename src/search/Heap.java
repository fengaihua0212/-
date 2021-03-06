package search;

/**
 * 堆
 * @author fah
 */
public class Heap {

    /**
     * 数组，从下标1开始存储数据
     */
    private int[] a;

    /**
     * 堆可以存储的最大数据数量
     */
    private int n;

    /**
     * 堆中已经存储的数据数量
     */
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        // 堆满了
        if (count >= n) {
            return;
        }

        ++count;
        a[count] = data;
        int i = count;
        // 自下往上堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        // 堆中没有数据
        if (0 == count) {
            return ;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 建堆
     * @param a
     * @param n
     */
    public void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >=1 ; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 自上往下堆化
     * @param a
     * @param count
     * @param i
     */
    private void heapify(int[] a, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }

            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }

            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 交换数据
     * @param a
     * @param i
     * @param j
     */
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 排序
     * @param a
     * @param n
     */
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }
}
