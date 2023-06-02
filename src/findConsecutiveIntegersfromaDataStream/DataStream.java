package findConsecutiveIntegersfromaDataStream;
/*
Runtime
33 ms
Beats
83.78%
Memory
94.2 MB
Beats
27.3%
 */
public class DataStream {

    private int value;
    private int k;

    private int counter = 0;
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        if (num == value) {
            counter++;
            if (counter >= k) {
                return true;
            }else{
                return false;
            }
        }else {
            counter = 0;
            return false;
        }
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
