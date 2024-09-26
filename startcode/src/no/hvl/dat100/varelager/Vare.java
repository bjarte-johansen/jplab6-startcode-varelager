package no.hvl.dat100.varelager;

public class Vare {
	private int varenr;
	private String navn;
	private double pris;
	
	public Vare(int varenr, String navn, double pris) {
		this.varenr = varenr;
		this.navn = navn;
		this.pris = pris;
	}
	
	public int getVarenr() {
		return varenr;
	}
	
	public void setVarenr(int varenr) {
		this.varenr = varenr; 
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public double getPris() {
		return pris;
	}
	
	public void setPris(double pris) {
		this.pris = pris; 
	}
	
	public double beregnMoms() {
		return this.pris * (20.0 / 100.0);
	}
	
	@Override
	public String toString() {
		String sPris = String.format("%.1f", pris).replace(',', '.');
		return String.format("Vare [varenr=%d, navn=%s, pris=%s]", varenr, navn, sPris);
	}
	
	public boolean erBilligereEnn(Vare v) {
		return pris < v.pris;
	}
	
}
