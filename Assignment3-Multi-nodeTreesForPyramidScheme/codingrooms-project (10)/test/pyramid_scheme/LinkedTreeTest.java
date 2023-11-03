package pyramid_scheme;

import Exceptions.ElementNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;

/**
 * @author pmele
 * @version 3/28/2019
 */
public class LinkedTreeTest {

    private LinkedTree<String> instance;
    private MultiTreeNode<String> root;
    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private String s5;

    /**
     * Sets up the later tests.
     */
    @Before
    public void initialize() {
        s1 = "Elem 1";
        s2 = "Elem 2";
        s3 = "Elem 3";
        s4 = "Elem 4";
        s5 = "Elem 5";
        root = new MultiTreeNode<String>(s1);
        instance = new LinkedTree<String>(root);
    }

    /**
     * Test of getRootElement method, of class LinkedTree.
     */
    @Test
    public void testGetRootElement() {
        // todo improve tests as required

        initialize();
        assertTrue(instance.size() == 1);
        String rootEle = instance.getRootElement();
        assertEquals(s1, rootEle);
        assertNotNull(instance.getRootElement());
    }

    /**
     * Test of addChild method, of class LinkedTree.
     */
    @Test
    public void testAddChild() {
        // todo improve tests as required
        initialize();

        try {

            // correct case

            instance.addChild(s1, s2);
            assertTrue(instance.size() == 2);
            MultiTreeNode<String> rootNode = instance.findNode(s1);
            assertTrue(s2.equalsIgnoreCase(rootNode.getChild(0).getElement()));
            assertTrue(rootNode.getNumChildren() == 1);

            instance.addChild(s1, s3);
            assertTrue(instance.size() == 3);
            assertTrue(s3.equalsIgnoreCase(rootNode.getChild(1).getElement()));

            assertTrue(rootNode.getNumChildren() == 2);

        } catch (Exception ex) {
            if (ex instanceof ElementNotFoundException) {
                assertTrue(true);
            } else {
                assertTrue(false);
            }
        }

        String s8 = null;
try
            {
                instance.addChild(s8, s1);
            }
            catch (Exception ex)
            {
                assertTrue(ex instanceof ElementNotFoundException);
            }
    }

    /**
     * Test of findNode method, of class LinkedTree.
     */
    @Test
    public void testFindNode() {
        initialize();
        try {
            // Can find root
            assertEquals(s1, instance.findNode(s1).getElement());
            instance.addChild(s1, s2);
            // Can find a child node
            assertEquals(s2, instance.findNode(s2).getElement());
            instance.addChild(s2, s3); // Add several deep
            instance.addChild(s3, s4);
            instance.addChild(s4, s5);
            // Can find a child node deep within tree
            assertEquals(s5, instance.findNode(s5).getElement());
            // Trying to find things not in the tree returns null
            assertEquals(null, instance.findNode("Unreal element"));
        } catch (Exception ex) {
            fail("Unexpected Exception");
        }
    }

    /**
     * x
     * Test of contains method, of class LinkedTree.
     */
    @Test
    public void testContains() {
        // todo improve tests as required
        initialize();

        try {
            // Can find root
            assertTrue(instance.contains(s1));
            instance.addChild(s1, s2);
            // Can find a child node
            assertTrue(instance.contains(s2));
            instance.addChild(s2, s3); // Add several deep
            instance.addChild(s3, s4);
            instance.addChild(s4, s5);
            assertTrue(instance.contains(s3));
            assertTrue(instance.contains(s4));
            assertTrue(instance.contains(s5));
            assertFalse(instance.contains("Elemt 6"));

        } catch (Exception ex) {
            fail("Unexpected Exception");
        }
    }

    /**
     * Test of size method, of class LinkedTree.
     */
    @Test
    public void testSize() {
        // todo improve tests as required
        initialize();

        try {
            assertTrue(instance.size() == 1);
            instance.addChild(s1, s2);
            assertTrue(instance.size() == 2);

            instance.addChild(s2, s3); // Add several deep

            instance.addChild(s3, s4);

            instance.addChild(s4, s5);
            assertTrue(instance.size() == 5);

        } catch (Exception ex) {
            fail("Unexpected Exception");

        }

    }
}
