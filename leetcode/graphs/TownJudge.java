/*
997. Find the Town Judge
Easy
5.8K
462
Companies
In a town, there are n people labeled from 1 to n. There is a rumor that one of these
people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person
labeled ai trusts the person labeled bi. If a trust relationship does not exist in
trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified,
or return -1 otherwise.
*/

class TownJudge {
	// Approach: Directed graph
	// To be a judge, indegree - outdegree = N-1
	// Time: O(T+N) Space: O(N)
    private static int findJudge(int n, int[][] trust) {
        int[] count = new int[n];

        // Compute indegree-outdegree iterating through trust array
        for(int i=0; i<trust.length; i++) {
        	count[trust[i][0]-1]--;
        	count[trust[i][1]-1]++;
        }

        // Check if any of the nodes indegree-outdegree==N-1
        for (int i=0; i<n; i++) {
        	if (count[i]==n-1) return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
    	int n = 3;
    	int[][] trust = { {1,3}, {2,3} };
    	int judge = findJudge(n, trust);
    	System.out.println(judge);
    }
}