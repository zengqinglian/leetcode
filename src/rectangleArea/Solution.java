package rectangleArea;

public class Solution
{
    public int computeArea( int A, int B, int C, int D, int E, int F, int G, int H ) {
        int area1_length = C - A;
        int area1_height = D - B;
        int area1 = area1_length * area1_height;

        int area2_length = G - E;
        int area2_height = H - F;
        int area2 = area2_length * area2_height;

        int overLap_length = 0;
        int overLap_height = 0;

        if( E >= C || G <= A || H <= B || F >= D ) {
            return area1 + area2;
        } else if( A <= E && C >= G && B <= F && D >= H ) {
            return area1;
        } else if( E <= A && G >= C && B >= F && H >= D ) {
            return area2;
        } else {
            if( E > A && C < G ) {
                overLap_length = C - E;
            } else if( A > E && C > G ) {
                overLap_length = G - A;
            } else {
                overLap_length = Math.min( G - E, C - A );
            }

            if( B > F && D > H ) {
                overLap_height = H - B;
            } else if( F > B && H > D ) {
                overLap_height = D - F;
            } else {
                overLap_height = Math.min( D - B, H - F );
            }

        }

        return area1 + area2 - overLap_height * overLap_length;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int A = -5;
        int B = 4;
        int C = 0;
        int D = 5;
        int E = -3;
        int F = -3;
        int G = 3;
        int H = 3;
        s.computeArea( A, B, C, D, E, F, G, H );
    }
}
