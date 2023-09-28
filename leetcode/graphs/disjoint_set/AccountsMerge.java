/*
721. Accounts Merge
Medium
Topics
Companies
Hint
Given a list of accounts where each element accounts[i] is a list of strings, where the
first element accounts[i][0] is a name, and the rest of the elements are emails representing
emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person
if there is some common email to both accounts. Note that even if two accounts have the same
name, they may belong to different people as people could have the same name. A person can
have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element
of each account is the name, and the rest of the elements are emails in sorted order. The
accounts themselves can be returned in any order.
*/
import java.util.*;

class AccountsMerge {
    /*
    Approach: Disjoint set
        1. Make each email group as nodes in graph 
        2. Use a hashmap1 DS to map emails to integer (email group or disjoint sets)
            => All emails in same group will be assigned same integer
        3. If same email is encountered in two different groups,
            then union those two email groups (=> they will have same root in UF DS)
        4. Iterate through each email group,
            Use a hashmap2 to map root index to set of emails
            Insert all emails in email groups with same root (using uf.find()) to common set<String>
        5. Iterate through about hashmap2,
            Sort all emails
            Insert owner (using hashmap1) at first position
    */
    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // List of accounts after merging
        List<List<String>> mergedAccounts = new ArrayList<List<String>>();

        // Make each email group as nodes in graph 
        int numAllAccounts = accounts.size();
        UnionFind uf = new UnionFind(numAllAccounts);

        /*
        Use a hashmap1 DS to map emails to integer (email group or disjoint sets)
            => All emails in same group will be assigned same integer
        */
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        for(int i=0; i<numAllAccounts; i++) {
            int numAccountsInGroup = accounts.get(i).size();
            // Iterate through emails in this group
            for(int j=1; j<numAccountsInGroup; j++) {
                String email = accounts.get(i).get(j);
                if (emailToIndex.containsKey(email)) {
                    // Union email groups if email repeats (root will be merged)
                    int root = emailToIndex.get(email);
                    uf.union(root, i);
                } else {
                    // For new emails, assign different group (root index)
                    emailToIndex.put(email, i);
                }
            }
        }

        /*
        Iterate through each email group,
            Use a hashmap2 to map root index to set of emails (disjoint sets)
            Insert all emails in email groups with same root (using uf.find()) to common set<String>
        */
        Map<Integer, Set<String>> emailGroups = new HashMap<Integer, Set<String>>();
        for(int i=0; i<numAllAccounts; i++) {
            int root = uf.find(i);

            Set<String> set = new HashSet<String>();
            if (emailGroups.containsKey(root))
                set = emailGroups.get(root);

            for(int j=1; j<accounts.get(i).size(); j++) {
                set.add(accounts.get(i).get(j));
            }
            emailGroups.put(root, set);
        }

        /*
        Iterate through about hashmap2,
            Sort all emails
            Insert owner (using hashmap1) at first position
        */
        for(int root: emailGroups.keySet()) {
            List<String> emails = new ArrayList<>();
            emails.addAll(emailGroups.get(root));
            // Sort emails within each group
            Collections.sort(emails);
            // Prepend name of owner to list of emails
            emails.add(0, accounts.get(root).get(0));
            mergedAccounts.add(emails);
        }


        return mergedAccounts;
    }


    /*
    Approach: DFS
    1. Each email is a node in the graph
    2. Create adj list based on emails in each account
    3. Run DFS from each unvisited node
        => All emails of same owner will be in separate connected components
    4. As we go through DFS, add all nodes belonging to same connected
        component into separate lists
    5. Each list: Sort, prepend owner name, return list of lists of merged accounts
    */
    private static List<List<String>> accountsMerge_dfs(List<List<String>> accounts) {
        // Email to owner and email to unique index mapping
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        Map<String, String> emailToOwner = new HashMap<String, String>();

        int numEmails = 0;
        for(int i=0; i<accounts.size(); i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                String owner = accounts.get(i).get(0);
                // Add email to owner mapping
                if (!emailToOwner.containsKey(email)) emailToOwner.put(email, owner);

                // Map unique id to email if doesn't exist yet
                if (!emailToIndex.containsKey(email)) emailToIndex.put(email, numEmails++);

            }
        }

        for(String email: emailToIndex.keySet()) {
            //System.out.println(email + "-" + emailToIndex.get(email));
        }

        // Build adj list
        List<String> adj[] = new ArrayList[numEmails];
        for(int i=0; i<numEmails; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<accounts.size(); i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                if (j<accounts.get(i).size()-1) {
                    String email1 = accounts.get(i).get(j);
                    String email2 = accounts.get(i).get(j+1);
                    adj[emailToIndex.get(email1)].add(email2);
                } else {
                    String email1 = accounts.get(i).get(j);
                    String email2 = accounts.get(i).get(1);
                    adj[emailToIndex.get(email1)].add(email2);
                }
            }
        }

        for(int i=0; i<numEmails; i++) {
            //System.out.println(adj[i]);
        }

        //Run DFS from each unvisited node
        //  => All emails of same owner will be in separate connected components
        boolean[] visited = new boolean[numEmails];
        List<List<String>> mergedAccounts = new ArrayList<List<String>>();
        for(String email: emailToIndex.keySet()) {
            if (!visited[emailToIndex.get(email)]) {
                Set<String> set = new HashSet<String>();
                set = dfs(adj, visited, emailToIndex.get(email), emailToIndex, set, email);
                System.out.println(set);
                List<String> emails = new ArrayList<>();
                emails.addAll(set);
                Collections.sort(emails);
                emails.add(0, emailToOwner.get(email));
                mergedAccounts.add(emails);
            }
        }

        return mergedAccounts;
    }

    private static Set<String> dfs(List<String>[] adj, boolean[] visited, int node, 
        Map<String, Integer> emailToIndex, Set<String> set, String email) {
        visited[node] = true;
        set.add(email);
        for(String dest: adj[node]) {
            if (!visited[emailToIndex.get(dest)]) {
                dfs(adj, visited, emailToIndex.get(dest), emailToIndex, set, dest);
            }
        }
        return set;
    }

    public static void main(String[] args) {
    	List<List<String>> accounts = Arrays.asList(
            Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co")
            /*
            Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
            Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co")
            Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
            Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
            Arrays.asList("Mary","mary@mail.com"),
            Arrays.asList("John","johnnybravo@mail.com")
            */
            );

        List<List<String>> mergedAccounts = accountsMerge_dfs(accounts);
        for(List<String> account: mergedAccounts) {
            System.out.println(account);
        }        

    }
}


class UnionFind {
    private int[] root;
    private int[] rank;
    private int numDisjointSets;

    // Constructor
    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        numDisjointSets = size;

        // Init root nodes as own and rank as 1 for all nodes
        for(int i=0; i<size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // Find root node (by path compression)
    public int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    // Union by rank
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }

            // For every union, decrement numDisjointSets by 1
            numDisjointSets--;
        }
    }

    public int getNumOfDisjointSets() {
        return numDisjointSets;
    }
}