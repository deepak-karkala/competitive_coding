/*
1656. Design an Ordered Stream
Solved
Easy
Topics
Companies
Hint
There is a stream of n (idKey, value) pairs arriving in an arbitrary order, where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.

Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion. The concatenation of all the chunks should result in a list of the sorted values.

Implement the OrderedStream class:

OrderedStream(int n) Constructs the stream to take n values.
String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream, then returns the largest possible chunk of currently inserted values that appear next in the order.
*/

class OrderedStream {
    String[] stream;
    int ptr;

    public OrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> list = new ArrayList<>();
        while(ptr < stream.length && stream[ptr] != null) list.add(stream[ptr++]);
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */