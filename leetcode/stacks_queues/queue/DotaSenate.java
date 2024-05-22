/*
649. Dota2 Senate
Solved
Medium
Topics
Companies
In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
*/

class DotaSenate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();

        int nextPosition = senate.length();
        for(int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') rad.offer(i);
            else dir.offer(i);
        }

        while(!rad.isEmpty() && !dir.isEmpty()) {
            // Winner goes to next round with highest index in queue (pushed at end of queue, has to wait for turn in next round after all others have voted in current round)

            if (rad.peek() < dir.peek()) rad.offer(nextPosition);    
            else dir.offer(nextPosition);

            // One senator will lose voting rights, other will move to end of queue
            // => So remove both of them from queue
            dir.poll();
            rad.poll();
            nextPosition++;
        }

        return !rad.isEmpty() ? "Radiant" : "Dire";
    }
}