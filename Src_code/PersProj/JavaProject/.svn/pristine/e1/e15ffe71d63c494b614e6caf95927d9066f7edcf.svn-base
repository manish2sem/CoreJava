package DS.Other.CountDown;
/**
 * In ancient days, when computers were still chipped out of fused silica by hand, when 8-bit microcontrollers roamed the Earth, and when your teacher was young, 
 * there was a common machine instruction called decrement and skip if zero (DSZ). Hotshot assembly programmers used this instruction to implement loops.
 *  Later machines got fancier instructions, but there were still quite a few processors on which it was cheaper to compare something with zero than to compare with anything else.
 *   (It's true even on some modern RISC machines, like PPC or SPARC, which reserve a whole register to be always zero.)
 *   
 *   So, if you rig your loops to compare with zero instead of N, what might happen?
 *   You might save a register
 *   You might get a compare instruction with a smaller binary encoding
 *   If a previous instruction happens to set a flag (likely only on x86 family machines), you might not even need an explicit compare instruction
 *   
 *   comparing i>0 is cheaper than i < N.
 * @author sinhama
 *
 */
public class LoopDown {
	public static void main(String[] args) {
		for (int i=1000; i>=0; --i) {
				System.out.println("Which loop is faster");
		}


		for (int i=0; i<=1000; --i) {
			System.out.println("Which loop is faster");
		}
	}
}
