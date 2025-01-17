package frontiere;

import controleur.ControlEmmenager;
//import personnages.Druide;
//import villagegaulois.Village;

public class BoundaryEmmenager  {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue au druie " + nomVisiteur + "\n");
		question.append("Quelle est votre force ? \n");
		int forceDruide = Clavier.entrerEntier(question.toString());
		question.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
		int effPotionMin=Clavier.entrerEntier(question.toString());
		question.append("Quelle est la force de potion la plus forte que vous produisez ?\n" );
		int effPotionMax=Clavier.entrerEntier(question.toString());
		while(effPotionMin>effPotionMax){
			System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum \n");
			question.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
			effPotionMin=Clavier.entrerEntier(question.toString());
			question.append("Quelle est la force de potion la plus forte que vous produisez ?\n" );
			effPotionMax=Clavier.entrerEntier(question.toString());
		}
		
		controlEmmenager.ajouterDuide(nomVisiteur, forceDruide, effPotionMin, effPotionMax);
		
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue villageois " + nomVisiteur + "\n");
		question.append("Quelle est votre force ? \n");
		int forceGaulois = Clavier.entrerEntier(question.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
		
	}
}
