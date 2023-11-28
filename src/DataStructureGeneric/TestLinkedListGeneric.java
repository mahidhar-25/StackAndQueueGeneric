package DataStructureGeneric;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestLinkedListGeneric {
    /*
    @desc :
     * Test case for the `search` method in the LinkedlistGeneric class.
     * Steps:
     * 1. Create a LinkedlistGeneric instance and insert elements (1, 2, 3).
     * 2. Instantiate the LinkedlistGeneric class for comparison.
     * 3. Invoke the `search` method with the value 2.
     * 4. Assert that the result is not null and the data of the result node is equal to 2.
     */
    @Test
    public void testSearch() {
        // Step 1
        LinkedlistGeneric<Integer> linkedList = new LinkedlistGeneric<>();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);

        // Step 2
        LinkedlistGeneric<Integer> yourClassInstance = new LinkedlistGeneric();

        // Step 3
        LinkedlistGeneric<Integer>.Node<Integer> result = linkedList.search(2);

        // Step 4
        assertNotNull(result);
        assertEquals( (Integer)2, (Integer) result.data);

    }
    /*
    @desc :
     * Tests the `insertAfterNode` method of the LinkedlistGeneric class.
     *
     * This test case verifies that the `insertAfterNode` method correctly inserts a new node with the specified data
     * after the given node in the linked list.
     */
    @Test
    public void testInsertAfterNode() {
        // Step 1: Create a linked list and insert nodes (1, 2, 3)
        LinkedlistGeneric<Integer> linkedList = new LinkedlistGeneric<>();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);

        // Step 2: Call the method to insert a new node after the second node (with data 2)
        LinkedlistGeneric<Integer>.Node<Integer> nodeToInsertAfter = linkedList.search(2);
        linkedList.insertAfterNode(nodeToInsertAfter, 4);

        // Step 3: Validate the updated linked list
        LinkedlistGeneric<Integer>.Node<Integer> currentNode = nodeToInsertAfter.next;
        assertEquals((Integer) 4, currentNode.data);
    }

    /*
    @desc :
     * Tests the `popByKey` method of the LinkedlistGeneric class.
     *
     * This test case verifies that the `popByKey` method correctly removes the node with the specified key from the linked list
     * and returns its data.
     */
    @Test
    public void testPopByKey() {
        // Step 1: Create a linked list and insert nodes (1, 2, 3)
        LinkedlistGeneric<Integer> linkedList = new LinkedlistGeneric<>();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);

        // Step 2: Call the method to pop the node with key 2
        Integer poppedData = linkedList.popByKey(2);

        // Step 3: Validate the result
        assertEquals((Integer) 2, poppedData);

        // Step 4: Validate that the node with key 2 is no longer present in the linked list
        assertEquals(2 , linkedList.size());
    }
}
