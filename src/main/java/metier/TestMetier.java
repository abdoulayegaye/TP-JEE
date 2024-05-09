package metier;

public class TestMetier {
	public static void main(String[] args) {
		CreditMetierImpl creditMetierImpl = new CreditMetierImpl();
		double capital = 200000;
		double taux = 4.5;
		int duree = 240;
		
		double resultat = creditMetierImpl.calculerMensualiteCredit(capital, taux, duree);
		
		System.out.println("Resultat = " + resultat);
	}
}
