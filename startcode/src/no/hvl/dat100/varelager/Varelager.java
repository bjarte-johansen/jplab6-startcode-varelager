package no.hvl.dat100.varelager;

public class Varelager {

	protected Vare[] varer;
	protected int antall;
	
	public Varelager(int n) {		
		varer = new Vare[n];
		antall = 0;
	}
	
	public Vare[] getVarer() {
		return varer;
	}
	
	public boolean leggTilVare(Vare v) {
		if(antall < varer.length) {
			varer[antall++] = v;
			return true;
		}
		return false;
	}
	
	public boolean leggTil(int varenr, String navn, double pris) {
		Vare newItem = new Vare(varenr, navn, pris); 
		return leggTilVare(newItem);
	}
	
	public Vare finnVare(int varenr) {
		for(int i=0; i<antall; i++) {
			if(varer[i].getVarenr() == varenr) {
				return varer[i];
			}
		}
		return null;
	}
	
	private String SEP = "==============================";
	
	public void printVarelager() {
		System.out.println(SEP);
		for(var vare : varer) {
			System.out.println(vare.toString());
		}
		System.out.println(SEP);
	}
	
}
