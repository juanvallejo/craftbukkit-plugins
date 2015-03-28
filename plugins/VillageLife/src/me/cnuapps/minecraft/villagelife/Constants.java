package me.cnuapps.minecraft.villagelife;

/**
 * Global constants to use for this plugin.
 * 
 * @author juanvallejo
 * @date 3/22/15
 */

public class Constants {

	public static enum Location {

		HOME(5, 7, 5);

		private int x;
		private int y;
		private int z;

		private Location(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public int getZ() {
			return this.z;
		}

	}

}