//TC:O(1)   worst:O(∞)
//SC:O(1)

//Generalization
//Implement randM() using randN() when M > N:
//Step 1: Use randN() to generate randX(), where X >= M. In this problem, I use 7 * (rand7() - 1) + (rand7() - 1) to generate rand49() - 1.
//Step 2: Use randX() to generate randM(). In this problem, I use rand49() to generate rand40() then generate rand10.
//Note: N^b * (randN() - 1) + N^(b - 1) * (randN() - 1) + N^(b - 2) * (randN() - 1) + ... + N^0 * (randN() - 1) generates randX() - 1, where X = N^(b + 1).

class Solution extends SolBase {
    public int rand10() {
        int res = 40;
        while(res >= 40){  
           res = 7 * (rand7() - 1) + (rand7() - 1);  
        } 
        return res % 10 + 1;
    }
}