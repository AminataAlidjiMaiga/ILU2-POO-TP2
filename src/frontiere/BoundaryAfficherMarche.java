package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String [] tab = controlAfficherMarche.donnerInfosMarche();
		if (tab.length==0) {
			System.out.println("Le marché est vide, revenez plus tard. \n");
		}
		else {
			System.out.println(nomAcheteur+" , vous trouverez au marché : \n");
			for (int i=0; i<tab.length;i+=3) {
				System.out.println("- "+tab[i]+" qui vend "+tab[i+1]+" "+ tab[i+2]+ "\n");
			}
		}
	}
}
