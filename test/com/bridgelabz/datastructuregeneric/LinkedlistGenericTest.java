package com.bridgelabz.datastructuregeneric;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LinkedlistGenericTest {

    private LinkedlistGeneric<Integer> linkedList;

    @Before
    public void initiateLinkedList(){
       linkedList = new LinkedlistGeneric<>();
    }


@Test
public void testInsertAtEnd(){
    linkedList.insertAtEnd(1);
    linkedList.insertAtEnd(2);
    linkedList.insertAtEnd(3);
    assertEquals( (Integer)3, linkedList.popLast());
}

@Test
public void testInsertByPosition(){
    LinkedlistGeneric<Integer> linkedList = new LinkedlistGeneric<>();
    linkedList.insertAtEnd(1);
    linkedList.insertAtBegin(2);
    linkedList.insertByPosition(3 , 1);
    linkedList.pop();

    assertEquals( (Integer)3, linkedList.pop());

    linkedList.insertByPosition(1 , 10);
    assertEquals( (Integer)1, linkedList.pop());

    linkedList.insertAtEnd(1);

    linkedList.insertByPosition(2 , 0);
    assertEquals( (Integer)1, linkedList.popLast());


    linkedList.insertAtEnd(2);
    linkedList.insertAtEnd(3);
    linkedList.insertAtEnd(4);
    assertEquals( (Integer)4, linkedList.popLast());

}
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



        // Step 3
      Node<Integer> result = linkedList.search(2);

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
        Node<Integer> nodeToInsertAfter = linkedList.search(2);
        linkedList.insertAfterNode(nodeToInsertAfter, 4);

        // Step 3: Validate the updated linked list
        Node<Integer> currentNode = nodeToInsertAfter.next;
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

    @Test
    public void testSize() {
           linkedList.insertAtEnd(1);
           linkedList.insertAtEnd(2);
           assertEquals(2 , linkedList.size());
           linkedList.pop();
           linkedList.pop();
        assertEquals(0 , linkedList.size());
    }

    @Test
    public void testInsertByOrder(){
        linkedList.insertByOrder(1);
        linkedList.insertByOrder(3);
        linkedList.insertByOrder(2);
        assertEquals((Integer)3 , linkedList.popLast());
    }
    @Test
    public void testPrintList() {
        // Add some elements to the list (optional)
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method you want to test
        linkedList.printList();

        // Reset System.out
        System.setOut(System.out);

        // Assert the printed output
        assertEquals("LinkedList: 1 2 3", outputStream.toString().trim());
    }
}