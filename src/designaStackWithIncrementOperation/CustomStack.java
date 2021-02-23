package designaStackWithIncrementOperation;

/*
Runtime: 6 ms, faster than 51.12% of Java online submissions for Design a Stack With Increment Operation.
Memory Usage: 48 MB, less than 6.29% of Java online submissions for Design a Stack With Increment Operation.
 */
public class CustomStack {
    private int maxSize;
    private int topIndex = 0;
    private int[] customStack;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        customStack = new int[maxSize];
    }

    public void push(int x) {
        if (topIndex <= maxSize - 1) {
            customStack[topIndex++] = x;
        }
    }

    public int pop() {
        if (topIndex == 0) {
            return -1;
        }
        return customStack[--topIndex];

    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, topIndex); i++) {
            customStack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
