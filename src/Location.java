import java.util.ArrayList;

/*
 * Wrote by Panshin Roman in 27.12.20
 * Location for QuestEngine v 1.1
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */


public class Location
{
	private String id;
	private String name;
	private String text;
	private boolean isFinish;
	ArrayList<Action> actions;
	public Location(String id, String text, String name, boolean isFinish, ArrayList<Action> actions){
		this.id = id;
		this.text = text;
		this.name= name;
		this.isFinish = isFinish;
		this.actions = actions;
	}
	public Location() {
	}
	public ArrayList<Action> getActions() {
		return actions;
	}
	public String toString() {
		return id + " " + text  + " " + name + " " + isFinish;  
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getText() {
		return text;
	}
	public boolean isFinish() {
		return isFinish;
	}
	
}
