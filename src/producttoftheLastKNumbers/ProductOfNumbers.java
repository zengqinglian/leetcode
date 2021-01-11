package producttoftheLastKNumbers;

//20ms solution , meet avg speed
public class ProductOfNumbers {
    private int lastZeroIndex = -1;
    private int[] arrary = new int[40000];
    private int index = 0;
    private int total = 1;


    public ProductOfNumbers() {

    }

    public void add(int num) {
        if(num==0){
            total = 1;
            lastZeroIndex = index;
            arrary[index++] = 0;
        }else{
            total *= num;
            arrary[index++] = total;
        }
    }

    public int getProduct(int k) {
        int startIndex = index - k;
        if(lastZeroIndex >= startIndex){
            return 0;
        }
        if(startIndex == 0){
            return arrary[index-1];
        }
        if(arrary[startIndex-1] == 0){
            return arrary[index-1];
        }
        return arrary[index-1] / arrary[startIndex-1];
    }

    public static void main(String[] args) {
        ProductOfNumbers s = new ProductOfNumbers();
        s.add(3);
        s.add(0);
        s.add(2);
        s.add(5);
        s.add(4);
        s.getProduct(2);
        s.getProduct(3);
        s.getProduct(4);
        s.add(8);
        s.getProduct(2);
    }
}
