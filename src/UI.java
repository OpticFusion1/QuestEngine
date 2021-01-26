import java.util.ArrayList;
import java.util.Scanner;
/*
 * Wrote by Panshin Roman in 27.12.20
 * UI for QuestEngine v 1.1
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */


public class UI{
	private static Scanner in = new Scanner(System.in);
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	private static final String ANSI_CLEAR = "\033[H\033[2J";
	
	public UI() {
	    System.out.print(ANSI_CLEAR);  
	    System.out.println(ANSI_YELLOW+ "QuestEngine\n"
	    		+"Copyright (c) 2020, Roman Panshin\n"
	    		+ "All rights reserved.\n" + ANSI_RESET);
	    System.out.flush(); 
	}
	
	public void showLocation(Location loc){
		System.out.print(loc.getText() + "\n");
		int i = 1;
		for(var v : loc.getActions()) {
			System.out.printf("%d) %s\n", i, v.getName());
			i++;
		}
	}
	public String getChoice(Location loc) {
		boolean isCorect = false;
		ArrayList<Action> actions = loc.getActions();
		int res = 0;
		do {
			
			res = in.nextInt();			
			res --;
			isCorect = res<actions.size() && res>=0;
			if (!isCorect)
				System.out.printf(ANSI_RED + "Введено неверное значение\n" + ANSI_RESET);
			System.out.println();
				
		}while(!isCorect);
	
		return actions.get(res).getId();
	}
	public void showError(String input) {
		System.out.println(ANSI_RED + input + ANSI_RESET);
	}
	
}
