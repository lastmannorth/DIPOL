package cl.dipol.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.Assert;

//@SpringBootTest
@RunWith(JUnit4.class)
class DipolApplicationTests {

	@Test
	 void runSum() {
		  String str = "123";
	        
	        int i=0;
	        ListNode result = new ListNode(str.charAt(str.length()-1) - '0');
	        System.out.print(str.charAt(0));
	        for (i=str.length()-2; i >=0; i--){
	            //result = result.next ;
	              
	              ListNode l = new ListNode(str.charAt(i) - '0', result.next);
	              result.next = l;
	        }
	        Assert.assertNotNull(result);
	}

	    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int num1 =0;
        int num2 = 0;
        int i =0;
        while(l1 != null && l2 != null){
            
            num1 = (l1.val * (int)(Math.pow(10, i)) + num1);
            num2 = (l2.val * (int)(Math.pow(10, i)) + num2);
            i++;
            
            l2 = l2.next;
            l1 = l1.next;
        }
        
        String str = "123";
        
        i=0;
        ListNode result = new ListNode(str.charAt(str.length()-1) - '0');
        System.out.print(str.charAt(0));
        for (i=str.length()-2; i >=0; i--){
            //result = result.next ;
              
              ListNode l = new ListNode(str.charAt(i) - '0', result.next);
              result.next = l;
        }

                              //ListNode result = new ListNode(x, start)  
        System.out.print(num1);

        
        return result;
    }
    
      private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
