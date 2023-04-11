package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean check;
		check=controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!check) {
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut être un habitatnt de notre village pour commencer ici.\n");
			
		}
		else {
			System.out.println("Bonjour "+ nomVendeur + ", je vais regarder si je peux vous trouver un étal\n");
			boolean x=controlPrendreEtal.resteEtals();
			if (!x) {
				System.out.println("Désolé "+nomVendeur+ " je n'ai pas d'étal qui ne soit pas déjà occupé.\n");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un étal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignements\n");
		System.out.println("Quels produit souhaitez-vous vendre ?\n");
		String produit=scan.next();
		System.out.println("Combien voulez vous en vendre ?\n");
		int nbp=scan.nextInt();
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbp);
		if (numeroEtal!=1)
		{
			numeroEtal+=1;
			System.out.println("Le vendeur "+ nomVendeur+ " s'est installé à l'étal N° "+numeroEtal+" \n");
		}
		
	}
}
