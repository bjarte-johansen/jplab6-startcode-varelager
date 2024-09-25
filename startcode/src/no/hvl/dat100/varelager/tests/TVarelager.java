package no.hvl.dat100.varelager.tests;

import no.hvl.dat100.varelager.Varelager;
import no.hvl.dat100.varelager.Vare;

public class TVarelager extends Varelager {

	public TVarelager(int n) {
		super(n);
	}
	
	public int getAntall () {
		return this.antall;
	}
	
	public Vare[] getTVarer () {
		return this.varer;
	}
}
