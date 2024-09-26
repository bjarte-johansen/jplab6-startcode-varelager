package no.hvl.dat100.varelager;

public class VarelagerUtils {

	public static Vare finnBilligste(Vare[] varer) {	
		if(varer.length > 0) {		
			Vare found = varer[0];
			int n = varer.length;
			for(int i=1; i<n; i++) {
				if(varer[i].getPris() < found.getPris()) {
					found = varer[i];
				}
			}
			return found;
		}			
		return null;
	}
	
	public static double totalPris(Vare[] varer) {		
		double sum = 0.0;
		for(Vare vare : varer) {
			sum += vare.getPris();
		}
		return sum;
	}
	
	public static int[] finnVarenr(Vare[] varer) {
		int[] result = new int[varer.length];
		int n = varer.length;
		for(int i=0; i<n; i++) {
			result[i] = varer[i].getVarenr();
		}
		return result;
	}
	
	public static double[] finnPrisDifferanser(Vare[] varer) {
		if(varer.length < 2) {
			throw new RuntimeException("Antall varer må være minst 2");
		}
		
		int n = varer.length;
		double[] result = new double[n - 1];
		
		for(int i=1; i<n; i++) {
			result[i - 1] = varer[i].getPris() - varer[i - 1].getPris(); 
		}
		
		return result;
	}
}
