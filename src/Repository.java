/*
 * Wrote by Panshin Roman in 04.12.20
 * Repository for QuestEngine v 1.0
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */
import java.util.ArrayList;


public class Repository {
	private static GraphEvent g;
	public Repository(String jsonFile) {
		g = new GraphEvent(jsonFile);
	}
	public static ArrayList <String> getEventOutput(String id) {
		ArrayList <String> output =new ArrayList<String>();
		GraphElement event = g.getVertex(id);
		output.add(event.getText() + "\n");
		int i =1;
		for(var v: g.getAllVariantsForVertex(id)) {
			output.add(Integer.toString(i) + ") " + v.getName() + "\n");
			i++;
		}
		return output;
	}
	public static boolean isFinishbyId(String id) {
		return g.getVertex(id).isFinish();
	}
	public static ArrayList <String> getOptionsFrom(String id) {
		ArrayList <String> output = new ArrayList<String>();
		for(var v: g.getAllVariantsForVertex(id)) {
			output.add(v.getId());
		}
		return output;
	}
}



