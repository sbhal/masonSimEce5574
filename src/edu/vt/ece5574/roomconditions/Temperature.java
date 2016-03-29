package edu.vt.ece5574.roomconditions;
import java.util.concurrent.atomic.AtomicInteger;
import edu.vt.ece5574.sim.Simulation;
import sim.engine.SimState;

//Author :- Ameya Khandekar

/*each room can have a temperature class whcih can be accessed by the agents present inside the rooms. 

The building agent will update the temperature according to a default in each step.
The other agents can accordingly update the temperature variables in each step as the need arises. */

public class Temperature  {

	private static final long serialVersionUID = 1;
	

	protected String buildingID = "0"; //a building will have the same ID as building ID
	protected String roomID;

    private AtomicInteger temp;  
	//protected LinkedList<Event> events;
	private Simulation state;
	
	public Temperature(SimState state_){
		state = (Simulation)state_;
		temp = new AtomicInteger(75);
	}
	
	public Temperature(int temperature_,SimState state_){
		state = (Simulation)state_;
		temp = new AtomicInteger(temperature_);
	}

	public int getTemperature(){

		return temp.get();
	}

	public void defTempChange(){
		//default Temperature change
		int val = temp.get();

		val = (((state.random.nextInt()%10) + 100)* val)/100  ; 
		temp.set(val);

	}	

	public void fireTempChange(int severity){

		int val = temp.get();

		val = val + severity*100;
		temp.set(val);

	}

	public void robotTempChange(int rate){

		int val = temp.get();
		val = val - rate*1000;
		temp.set(val);
	}

}
