/*
 * Wrote by Panshin Roman in 27.12.20
 * Repository for QuestEngine v 1.1
 * QuestEngine - Java interpreter of JSON-graphs into text game
 */


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.ImportException;
import org.jgrapht.nio.json.JSONImporter;
import org.jgrapht.util.SupplierUtil;

class Repo implements IRepository{
	private static final String TEXT = "text";
	private static final String NAME = "name";
	Graph<String, DefaultEdge> g;
	Map<String, Map<String, Attribute>> vertexAttributes;
	Repo(){}
	public void initRepository(String filename) throws ImportException
	{
			this.g = GraphTypeBuilder
			          .directed().allowingMultipleEdges(true).allowingSelfLoops(true)
			          .vertexSupplier(SupplierUtil.createStringSupplier(1))
			          .edgeSupplier(SupplierUtil.DEFAULT_EDGE_SUPPLIER).buildGraph();
	
					JSONImporter<String, DefaultEdge> importer = new JSONImporter<>();
					
					this.vertexAttributes = new HashMap<>();
				        importer.addVertexAttributeConsumer((p, a) -> {
				            Map<String, Attribute> attrs = vertexAttributes.get(p.getFirst());
				            if (attrs == null) {
				                attrs = new HashMap<>();
				                vertexAttributes.put(p.getFirst(), attrs);
				            }
				            attrs.put(p.getSecond(), a);
				        });
					importer.importGraph(g, new File(filename));
		}

	public String toString()
	{	
		return g.toString() + "\n" + vertexAttributes.toString();
	}
	
	
	public Location getLocation(String id)
	{
		Map<String, Attribute>  vertexData =  vertexAttributes.get(id);
		
		String text = vertexData.get(TEXT).toString();
		String name = vertexData.get(NAME).toString();
		boolean isFinish = Boolean.parseBoolean(vertexData.get("isFinish").toString());
		ArrayList <Action> actions = getAllVariantsForLocation(id);
		
		return new Location(id, text, name, isFinish, actions);
		
	}
	
	private ArrayList <Action> getAllVariantsForLocation(String id)
	{
		ArrayList <Action> actions = new ArrayList<Action>();
		
		List<String> verts = Graphs.successorListOf(g,id);
		for (var v : verts){
			Map<String, Attribute>  vertexData =  vertexAttributes.get(v);
			actions.add(new Action(vertexData.get(NAME).toString(), v));
		}
		
        return actions;
	}
	
	public ArrayList<Location> getAllVariantsForLocation(Location loc)
	{
		ArrayList<Location> list = new ArrayList<Location>();
		List<String> verts = Graphs.successorListOf(g, loc.getId());
		for (var v : verts){
			list.add(getLocation(v));
		}
        return list;
	}
} 
