package LeetCode;

public class CountOfMatchesInTournament {
    public static void main(String[] args) {
        System.out.println(new Solution1688().numberOfMatches(7));
    }
}
//https://leetcode.com/problems/count-of-matches-in-tournament/
class Solution1688 {//0 ms
    public int numberOfMatches(int n) {
        int advTeams=0,matches=0;
        while(advTeams!=1){
            if(n%2==0){
                advTeams=n/2;
            } else{
                advTeams=n/2+1;
            }
            matches+=n/2;
            n=advTeams;
        }
        return matches;
    }
}