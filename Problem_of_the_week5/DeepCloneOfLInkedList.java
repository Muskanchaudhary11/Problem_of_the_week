
// the time complexity and space complexity both is O(1)

import java.util.Map;
import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a mapping from original nodes to their copies
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val)); // copy node with same value
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            Node copyNode = map.get(curr);
            copyNode.next = map.get(curr.next);       // may be null
            copyNode.random = map.get(curr.random);   // may be null
            curr = curr.next;
        }

        // Step 3: Return the head of the copied list
        return map.get(head);
    }
}
