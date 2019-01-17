package towerdefense.document.towers;

import com.googlecode.lanterna.TextColor;

import towerdefense.document.Color;
import towerdefense.document.Tower;

public class EarthTower extends Tower {

	public EarthTower() {
		super(12, 100,7, 1.1);
		super.setName("Earth");
	}

	@Override
	public void setIcon() {
		super.setIcon("data/towers/EarthTower.txt");
	}

}
