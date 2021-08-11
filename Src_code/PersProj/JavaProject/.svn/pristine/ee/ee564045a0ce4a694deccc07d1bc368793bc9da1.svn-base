package DessignPattern.HeadFirst.State.Problem;

/**
 * Different State of the Gumball Machine.
 * 
 * Sold Out = There is no Gumball to sold.
 * Sold = 
 * No Quarter = No Quarter is put into Gumball Machine.
 * HAS QUARTER = Quarter is inserted into Gumball Machine.
 * 
 * At any given moment machine will be only in one of above state.
 * This functions will change the state of machine provide it meets prerequisites.
 * 
 * We have different function of Gumball machine:
 * insertQuarter - inert new quarter [into empty Gumball Machine]
 * 		invalid state - If quarter is already there.
 * 		valid state - If Quarter is not there. -> New state = HAS_QUARTER				
 * ejectQuarter - Getting back your quarter
 * 		invalid state - If quarter is not there.
 * 		valid state - If Quarter is already there. -> New state = No_QUARTER
 * turnCrank - turning crank to get gumball
 * 		valid state - If Quarter is there. and Gumball is not sold out. New state = SOLD
 * dispense - gumball has been given to you.
 * 
 * @author sinhama
 *
 */
public class ExistingSystemGumball {

	final static int SOLD = 0;
	final static int SOLD_OUT = 1;
	final static int NO_QUARTER = 2;
	final static int HAS_QUARTER = 3;

	int state = SOLD_OUT;	
	int count = 0;

	public ExistingSystemGumball (int count) {
		this.count = count;

		if (count > 0) {
			state = NO_QUARTER;
		}		
	}

	public void insertQuarter() {
		if (state==SOLD) {
			System.out.println("Wait... we are giving you a Gumball");
		}else if(state==SOLD_OUT){
			System.out.println("No Gumball ");
		}else if(state==NO_QUARTER){
			System.out.println();
			state = HAS_QUARTER;

		}else if(state==HAS_QUARTER){
			System.out.println("Quarter already inserted");
		}
	}

	public void ejectQuarter() {
		if (state==SOLD) {
			System.out.println("You can't eject. We are giving you a Gumball");
		}else if(state==SOLD_OUT){
			System.out.println("No Gumball ");
		}else if(state==NO_QUARTER){
			System.out.println("Nothing to eject");

		}else if(state==HAS_QUARTER){
			System.out.println("Collect your Quarter");
			state = NO_QUARTER;
		}
	}

	public void turnCrank() {
		if (state==SOLD) {
			System.out.println("You can't get two Guball by turning twice.");
		}else if(state==SOLD_OUT){
			System.out.println("No Gumball ");
		}else if(state==NO_QUARTER){
			System.out.println("Pay first ");


		}else if(state==HAS_QUARTER){
			System.out.println("You turned ...");
			state = SOLD;
			dispense();
		}
	}

	public void dispense() {
		if (state==SOLD) {
			System.out.println("Wait... we are giving you a Gumball");
		}else if(state==SOLD_OUT){
			System.out.println("No Gumball ");
		}else if(state==NO_QUARTER){
			System.out.println();
			state = HAS_QUARTER;

		}else if(state==HAS_QUARTER){
			System.out.println("Quarter already inserted");
		}
	}


}



