package implementation.main;

import core.location.CoordLocation;
import implementation.human.Human;
import implementation.object.Apple;
import implementation.world.SimpleWorldMaster;

public class Main {

	public static void main(String[] args) {
		SimpleWorldMaster master = new SimpleWorldMaster();
		Human bob = new Human(master, new CoordLocation(0, 0), "Bob");
		Human abe = new Human(master, new CoordLocation(10, 0), "Abe");
		master.spawnObject(bob);
		master.spawnObject(abe);
		
		System.out.println(bob.getAction());
		System.out.println(abe.getAction());
		
		Apple apple = new Apple(new CoordLocation(10, 10), "1");
		
		master.spawnObject(apple);
		
		System.out.println("---- apple spawn ----");
		
		System.out.println(bob + "'s action : " + bob.getAction());
		System.out.println(abe + "'s action : " + abe.getAction());

		apple = new Apple(new CoordLocation(0, 10), "2");
		
		master.spawnObject(apple);
		
		System.out.println("---- apple spawn ----");
		
		System.out.println(bob + "'s action : " + bob.getAction());
		System.out.println(abe + "'s action : " + abe.getAction());
		
		master.destroyObject(apple);
		
		System.out.println("---- apple destruction ----");
		
		System.out.println(bob + "'s action : " + bob.getAction());
		System.out.println(abe + "'s action : " + abe.getAction());
		
	}
}
