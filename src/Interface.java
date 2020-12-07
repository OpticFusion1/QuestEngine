import java.util.Scanner;
/*
 * Wrote by Panshin Roman in 05.12.20
 * UI for QuestEngine v 1.0
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */

public abstract class Interface{
	private static Scanner in = new Scanner(System.in);
	public static void printElementbyId(String id) {
		for(var v : Repository.getEventOutput(id)) {
			System.out.print(v);
		}
	}
	public static int getChoice() {
		int res = in.nextInt();
		return res;
	}
}
