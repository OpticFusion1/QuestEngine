/*
 * Wrote by Panshin Roman in 05.12.20
 * GraphElement for QuestEngine v 1.0
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */

public class GraphElement
{
	private String id;
	private String name;
	private String text;
	private boolean isFinish;
	public GraphElement(String id, String text, String name, boolean isFinish) {
		this.id = id;
		this.text = text;
		this.name= name;
		this.isFinish = isFinish;
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
