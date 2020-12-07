import java.util.ArrayList;

/*
 * Wrote by Panshin Roman in 05.12.20
 * Game for QuestEngine v 1.0
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */


public abstract class Game {
	public static Repository rep; 
	private static String nowId = "1";
	private static boolean isFinish = false;
	private static  ArrayList <String> optionsId;
	
	public static void main(String[] args) {
		rep = new Repository(args[0]);
		while(true) {
			updata(nowId);
			if(isFinish)
				break;
			Interface.printElementbyId(nowId);
			nowId = optionsId.get(Interface.getChoice() - 1);
		}
		System.out.println("Игра окончена!");
		
	}
	
	private static void updata(String id) {
		optionsId = Repository.getOptionsFrom(id);
		isFinish =  Repository.isFinishbyId(id);
	}
}
