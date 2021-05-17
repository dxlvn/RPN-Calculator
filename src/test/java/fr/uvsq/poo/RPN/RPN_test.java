package fr.uvsq.poo.RPN;

import static org.junit.Assert.*;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;


public class RPN_test {

	 @Before
	 public void setup() {		 
		 Invoker in = new Invoker();
		 MoteurRPN moteur = new MoteurRPN(in);
		 Command ApOP = new ApOP(moteur);
		 Command retOP = new RetOP(moteur);
		 Command regOP = new RegOP(moteur);
		 Command exit = new Exit(moteur);
		 ApOP plus = new Plus(moteur);
		 ApOP minus = new Minus(moteur);
		 ApOP times = new Times(moteur);
		 ApOP divide = new Divide(moteur);
		 in.register("Plus",plus);
		 in.register("Minus",minus);
		 in.register("Times",times);
		 in.register("Divide",divide);
		 in.register("RetOP",retOP);
		 in.register("RegOP",regOP);
		 in.register("exit",exit);
		 Stack<Integer> verif_stack = new Stack<Integer>();
	  }
	 
	 @Test
	 public void test_add() {
		 Invoker in = new Invoker();
		 MoteurRPN moteur = new MoteurRPN(in);
		 ApOP plus = new Plus(moteur);
		 in.register("Plus",plus);
		 moteur.regOP(18);
		 moteur.regOP(14);
		 moteur.apOP(plus);
		 Stack<Integer> verif_stack = new Stack<Integer>();
		 verif_stack.push(32);
		 assertEquals(verif_stack,moteur.retOP());
	 }
	 
	 @Test
	 public void test_sub() {
		 Invoker in = new Invoker();
		 MoteurRPN moteur = new MoteurRPN(in);
		 ApOP minus = new Minus(moteur);
		 in.register("Minus",minus);
		 moteur.regOP(25);
		 moteur.regOP(9);
		 moteur.apOP(minus);
		 Stack<Integer> verif_stack = new Stack<Integer>();
		 verif_stack.push(-16);
		 assertEquals(verif_stack,moteur.retOP());
	 }
	 
	 @Test
	 public void test_mult() {
		 Invoker in = new Invoker();
		 MoteurRPN moteur = new MoteurRPN(in);
		 ApOP times = new Times(moteur);
		 in.register("Times",times);
		 moteur.regOP(18);
		 moteur.regOP(5);
		 moteur.apOP(times);
		 Stack<Integer> verif_stack = new Stack<Integer>();
		 verif_stack.push(90);
		 assertEquals(verif_stack,moteur.retOP());
	 }
	 
	 @Test
	 public void test_div() {
		 Invoker in = new Invoker();
		 MoteurRPN moteur = new MoteurRPN(in);
		 ApOP divide = new Divide(moteur);
		 in.register("Divide",divide);
		 moteur.regOP(5);
		 moteur.regOP(60);
		 moteur.apOP(divide);
		 Stack<Integer> verif_stack = new Stack<Integer>();
		 verif_stack.push(12);
		 assertEquals(verif_stack,moteur.retOP());
	 }
	 
	 @Test
	 public void test_undo_1() {
		 Invoker in = new Invoker();
		 MoteurRPN moteur = new MoteurRPN(in);
		 moteur.regOP(12);
		 moteur.regOP(13);
		 moteur.regOPUndo();
		 Stack<Integer> verif_stack = new Stack<Integer>();
		 verif_stack.push(12);
		 assertEquals(verif_stack,moteur.retOP()); // apOPUndo(int nbr1,int nbr2
	 }
	 
	 @Test
	 public void test_undo_2() {
		 Invoker in = new Invoker();
		 MoteurRPN moteur = new MoteurRPN(in);
		 ApOP plus = new Plus(moteur);
		 in.register("Plus",plus);
		 moteur.regOP(12);
		 moteur.regOP(13);
		 moteur.apOP(plus);
		 moteur.apOPUndo(13,12);
		 Stack<Integer> verif_stack = new Stack<Integer>();
		 verif_stack.push(12);
		 verif_stack.push(13);
		 assertEquals(verif_stack,moteur.retOP()); // 
	 }
	
	
	@Test
	public void big_test() {
		Invoker in = new Invoker();
	    MoteurRPN moteur = new MoteurRPN(in);
	    //SaisieRPN entry = new SaisieRPN(in,moteur);
		ApOP plus = new Plus(moteur);
		ApOP minus = new Minus(moteur);
		ApOP times = new Times(moteur);
		ApOP divide = new Divide(moteur);
		in.register("Plus",plus);
		in.register("Minus",minus);
		in.register("Times",times);
		in.register("Divide",divide);
		Stack<Integer> verif_stack = new Stack<Integer>();
		//Stack<Stack<Integer>> verif_history = new Stack<Stack<Integer>>();
		
		
		moteur.regOP(15);
		moteur.regOP(3);
		moteur.apOP(divide);
		moteur.regOP(7);
		moteur.regOP(4);
		moteur.apOP(plus);
		moteur.apOP(times);
		moteur.regOP(15);
		moteur.regOP(62);
		moteur.regOPUndo();
		moteur.regOPUndo();
		moteur.regOPUndo();
		moteur.regOP(14);
		moteur.regOP(3);
		moteur.regOP(17);
		moteur.apOP(minus);
		moteur.regOP(4);
		moteur.regOPUndo();
		moteur.regOP(2);
		moteur.regOP(23);
		
		
		verif_stack.push(15);
		verif_stack.push(3);
		verif_stack.push(verif_stack.pop() / verif_stack.pop());
		verif_stack.push(7);
		verif_stack.push(4);
		verif_stack.push(verif_stack.pop() + verif_stack.pop());
		verif_stack.push(verif_stack.pop() * verif_stack.pop());
		verif_stack.push(15);
		verif_stack.push(62);
		verif_stack.pop();
		verif_stack.pop();
		verif_stack.pop();
		verif_stack.push(14);
		verif_stack.push(3);
		verif_stack.push(17);
		verif_stack.push(verif_stack.pop() - verif_stack.pop());
		verif_stack.push(4); 
		verif_stack.pop();
		verif_stack.push(2);
		verif_stack.push(23);
		

		assertEquals(verif_stack,moteur.retOP());
		
	}

}
