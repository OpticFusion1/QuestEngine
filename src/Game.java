import org.jgrapht.nio.ImportException;

/*
 * Wrote by Panshin Roman in 27.12.20
 * Game for QuestEngine v 1.1
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */


public class Game {
	public static void main(String[] args) {
		UI ui = new UI();
		Repo r = new Repo();
	    if(args.length == 0)
	    {
	    	ui.showError("Не указан игровой репозиторий.");
	        System.exit(1);
	    }
		try {
			r.initRepository(args[0]);
		}
		catch(ImportException e2) {
			ui.showError("Некорректный путь или тип файла.");
			System.exit(1);
		}
		Location loc= r.getLocation("1");
		
		do {
			ui.showLocation(loc);
			loc = r.getLocation(ui.getChoice(loc));
			
		}while(!loc.isFinish());
		ui.showLocation(loc);
	}
}
