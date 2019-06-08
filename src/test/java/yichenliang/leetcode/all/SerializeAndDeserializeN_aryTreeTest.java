package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SerializeAndDeserializeN_aryTreeTest {
	
	private SerializeAndDeserializeN_aryTree solution;

    @BeforeEach
    void beforeEach() {
        solution = new SerializeAndDeserializeN_aryTree();
    }

//    @Test
//    void test1() {
//    	List<Node> children5 = null;
//    	Node n5 = new Node(5, children5);
//    	
//    	List<Nnode> children6 = null;
//    	Nnode n6 = new Nnode(6, children6);
//    	
//    	List<Nnode> children3 = new ArrayList<>();
//    	children3.add(n5);
//    	children3.add(n6);
//    	Nnode n3 = new Nnode(3, children3);
//    	
//    	List<Nnode> children2 = null;
//    	Nnode n2 = new Nnode(2, children2);
//    	
//    	List<Nnode> children4 = null;
//    	Nnode n4 = new Nnode(4, children4);
//    	
//    	List<Nnode> children1 = new ArrayList<>();
//    	children1.add(n3);
//    	children1.add(n2);
//    	children1.add(n4);
//    	Nnode n1 = new Nnode(1, children1);
//    	String ans = solution.serialize(n1);
//    	//String[] show = ans.split(" ");
//        Assertions.assertEquals("1 [ 3 [ 5 [ ] 6 [ ] ] 2 [ ] 4 [ ] ] ", ans);
//    }


}
