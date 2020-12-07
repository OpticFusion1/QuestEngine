/*
 * Wrote by Panshin Roman in 04.12.20
 * Graph for QuestEngine v 1.0
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
import org.jgrapht.nio.json.JSONImporter;
import org.jgrapht.util.SupplierUtil;

class GraphEvent{
	Graph<String, DefaultEdge> g;
	Map<String, Map<String, Attribute>> vertexAttributes;

	GraphEvent(String filename)
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
	
	public GraphElement getVertex(String id)
	{
		Map<String, Attribute>  vertexData =  vertexAttributes.get(id);
		String text = vertexData.get("text").toString();
		String name = vertexData.get("name").toString();
		boolean isFinish = Boolean.parseBoolean(vertexData.get("isFinish").toString());
//		boolean isStart = Boolean.parseBoolean(vertexData.get("isStart").toString());
		return new GraphElement(id, text, name, isFinish);
		
	}
	
	public ArrayList<GraphElement> getAllVariantsForVertex(String id)
	{
		ArrayList<GraphElement> list = new ArrayList<GraphElement>();
		List<String> verts = Graphs.successorListOf(g,id);
		for (var v : verts){
			list.add(getVertex(v));
		}
        return list;
		
	}
} 
