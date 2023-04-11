package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;


public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,ControlTrouverEtalVendeur controlTrouverEtalVendeur,Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierId(String nomA)
	{
		return controlVerifierIdentite.verifierIdentite(nomA);
	
	}
	public void affichervendeurs()
	{
		String [] tab=village.donnerEtatMarche();
		for(int i=0;i<tab.length;i+=3)
		{
			System.out.println(((int)(i/3)+1) +"- "+ tab[i]);
		}
	}
	public String [] tabetal()
	{
		return village.donnerEtatMarche();
	}
	
	public void acheterProduit(String nom,int quantite,String nomP)
	{
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nom);///on a l'etal du vendeur
		if (etal.contientProduit(nomP))
		{
			int q=etal.acheterProduit(quantite);
		}
		else
		{
			System.out.println("L'etal ne contient pas de "+ nomP );
		}
	
	}
}