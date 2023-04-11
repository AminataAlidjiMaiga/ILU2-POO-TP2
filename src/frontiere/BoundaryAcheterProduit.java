package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	
	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	
	public void acheterProduit(String nomAcheteur) {
	
		if (controlAcheterProduit.verifierId(nomAcheteur))
		{
		System.out.println("Quelle produit voulez vous acheter ?\n");
		String produit=scan.next();
		System.out.println("Chez quel commercant voulez vous acheter des "+ produit+" ?\n");
		controlAcheterProduit.affichervendeurs();
		int res=scan.nextInt();
		acheter(nomAcheteur,res,produit);
		}
	}
	public void acheter(String nom,int x,String produit)
	{
		String[] tab=controlAcheterProduit.tabetal();
		String nomvendeur=tab[(x-1)*3];///nom du vendeur
		System.out.println(nom +" se éplace jusqu'à l'étal du vendeur "+ nomvendeur+"\n");
		System.out.println("Bonjour, "+ nom +"\n");
		System.out.println("Combien de " + produit +" voulez-vous acheter ?" + "\n");
		int nbProduits=scan.nextInt();
		
		controlAcheterProduit.acheterProduit(nomvendeur,nbProduits,produit);
		
		System.out.println(nom +" a acheté 5 de fleurs à " + nomvendeur);
	
	}
 
}
