package bulbSwitcher;

public class Solution1
{
    /*
     * For any light, say, light k, it only gets switched when the interval is a factor of k. Now, notice that factors come in
     * pairs, that is, if a*b==k, you will switch light k at both intervals a and b. As long as a !=b, the light k will be off in
     * the end. The only chance that light k remains on is when a==b, that is, k==a^2, , in this case it only gets switched once for
     * this pair of factors. So, k needs to be a square number!
     * 
     * Then the question is really asking how many square numbers are smaller or equal to N, which is trivial to programmers.
     */
    public int bulbSwitch( int n ) {
        if( n <= 0 )
            return 0;
        return (int) Math.sqrt( n );
    }
}
