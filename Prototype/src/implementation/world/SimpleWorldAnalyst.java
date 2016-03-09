package implementation.world;

import implementation.world.listeners.ObjectRemovalAnalyst;
import implementation.world.listeners.ObjectSpawnAnalyst;

import java.util.LinkedList;
import java.util.List;

import core.world.WorldAnalyst;

public class SimpleWorldAnalyst implements ObjectRemovalAnalyst, ObjectSpawnAnalyst {
	//Listeners
	private List<ObjectRemovalAnalyst> removal_analysts;
	private List<ObjectSpawnAnalyst> spawn_analysts;
	
	//Gestionnaire graphique
	//private GraphicWorldAnalyst graphic_analyst;
	
	//Gestionnaires d'index
	private SimpleIndexMaster index_master;
	
	//initialise l'ensemble des analystes avec l'artiste en paramètre relié par un analyste graphique
	public SimpleWorldAnalyst(/*Artist artist*/) {
		removal_analysts = new LinkedList<ObjectRemovalAnalyst>();
		spawn_analysts = new LinkedList<ObjectSpawnAnalyst>();
		
		//graphic_analyst = new GraphicWorldAnalyst(artist);
		//this.addAnalyst(graphic_analyst);
		index_master = new SimpleIndexMaster(this);
	}
	
	/*public GraphicWorldAnalyst getGraphicAnalyst() {
		return graphic_analyst;
	}*/
	
	public SimpleIndexMaster getIndexMaster() {
		return index_master;
	}
	
	public void addAnalyst(WorldAnalyst analyst) {
		if( analyst instanceof ObjectRemovalAnalyst )
			removal_analysts.add((ObjectRemovalAnalyst) analyst);
		if( analyst instanceof ObjectSpawnAnalyst )
			spawn_analysts.add((ObjectSpawnAnalyst) analyst);
	}
	
	public void removeAnalyst(WorldAnalyst analyst) {
		if( analyst instanceof ObjectRemovalAnalyst )
			removal_analysts.remove((ObjectRemovalAnalyst) analyst);
		if( analyst instanceof ObjectSpawnAnalyst )
			spawn_analysts.remove((ObjectSpawnAnalyst) analyst);
	}
	
	@Override
	public void onRemoval(Object object) {
		for(ObjectRemovalAnalyst analyst : removal_analysts)
			analyst.onRemoval(object);
	}

	@Override
	public void onSpawn(Object object) {
		for(ObjectSpawnAnalyst analyst : spawn_analysts)
			analyst.onSpawn(object);
	}
}
