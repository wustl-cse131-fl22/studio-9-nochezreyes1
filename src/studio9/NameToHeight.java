package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<String, Integer> heightThing = new HashMap<>();
		
		heightThing.put("mo",61);
		heightThing.put("ariel", 68);
		
		String name = "";
		
		while(!name.equals("quit"))
		{
			while(name.equals(null))
			{
				System.out.println("This is null. Do something else.");
			}
			
			System.out.println("Please enter name. (If you want to quit, please enter 'quit')");
			name = in.nextLine();
			System.out.println(name + ": " + heightThing.get(name));
		}
	
	}

	}

