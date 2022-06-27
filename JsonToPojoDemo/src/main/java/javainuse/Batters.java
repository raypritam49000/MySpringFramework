package javainuse;

import java.util.ArrayList;
import java.util.List;

public class Batters {
	private List<Batter> batter = new ArrayList<Batter>();

	public List<Batter> getBatter() {
		return batter;
	}

	public void setBatter(List<Batter> batter) {
		this.batter = batter;
	}

	@Override
	public String toString() {
		return "Batters [batter=" + batter + "]";
	}
	
	
}
