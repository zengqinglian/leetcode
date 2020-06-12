package iteratorforCombination;

//10ms solution, beat 90%
public class CombinationIterator {

    private char[] charArray;
    private int[] maxArray;
    private int[] currentArray;
    private StringBuilder sb = new StringBuilder();
    private int index=1;
    public CombinationIterator(String characters, int combinationLength) {
        charArray = characters.toCharArray();
        maxArray = new int[combinationLength];
        currentArray =new int[combinationLength];
        for(int i=0; i<combinationLength; i++){
            currentArray[i] = i;
            maxArray[i] = charArray.length - combinationLength + i;
        }
    }

    public String next() {
        sb.setLength(0);
        for(int v : currentArray){
            sb.append(charArray[v]);
        }
        index=-1;
        for(int i=currentArray.length-1; i>=0; i--){
            if(currentArray[i] < maxArray[i]){
                currentArray[i]++;
                index=i;
                break;
            }
        }
        if(index!=-1 ){
            for(int i=index+1; i<currentArray.length; i++){
                currentArray[i] = currentArray[i-1]+1;
            }
            return sb.toString();
        }
        return sb.toString();
    }

    public boolean hasNext() {
       if(index==-1){
           return false;
       }
       return true;
    }

    /**
     * Your CombinationIterator object will be instantiated and called as such:
     * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
     * String param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    public static void main(String[] args) {
        CombinationIterator ita = new CombinationIterator("chp", 1);
        ita.next();
        ita.hasNext();
        ita.next();
        ita.hasNext();
        ita.next();
        ita.hasNext();
    }
}
