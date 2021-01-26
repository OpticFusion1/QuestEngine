/*
 * Wrote by Panshin Roman in 26.12.20
 * Action for QuestEngine v 1.1
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */

public class Action {
	private String name;
	private String id;
	public Action(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
}
