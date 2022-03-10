
/* Version de l'algorithme de Prim-Jarnik utilisant
une ArrayList pour les aretes et aussi pour les sommets rejoints

Graphe: aretes spécifiees par matrice de distances
*/

import java.util.*;

public class Main_reseau_fibre {    
    public static void main(String[] args){
        
        int nbSommets = 7;
        
        // matrice des distances entre sommets
        int [][] matDist = {
            { 0, 30, 40, 50, 20, 50, 20},
            {30,  0, 30,  0, 50,  0,  0},
            {40, 30,  0, 20, 50,  0,  0},
            {50,  0, 20,  0, 40,  0,  0},
            {20, 50, 50, 40,  0, 40, 30},
            {50,  0,  0,  0, 40,  0,  0},
            {20,  0,  0,  0, 30,  0,  0}};
        
        
        // representation de l'ensemble S de l'algorithme
        // par la liste suivante:
        ArrayList<Arete> lesAretes = new ArrayList<Arete>();
        
        // construction de l'ensemble des aretes a partir de
        // la matrice de distances
        for(int i=0;i<nbSommets-1;i++){
            for(int j=i+1;j<nbSommets;j++){
                if (matDist[i][j] != 0){
                    Arete uneArete = new Arete(i,j,matDist[i][j]);
                    lesAretes.add(uneArete);
                    
                    System.out.println(uneArete); // Pour voir les aretes dans la console
                    
                }
            }
        }

        // representation de l'ensemble R de l'algorithme
        // par la liste suivante:
        ArrayList<Integer> lesSommetsRejoints = new ArrayList<Integer>();
        // ATTENTION c'est bien Integer et non int
        
        // initialisation
        lesSommetsRejoints.add(0);
        // COMPLETER LE CODE ICI
        
        
        System.out.println(lesAretes.get(2));
        System.out.println(lesAretes.get(2).sommetA);
        System.out.println(lesAretes.size());
        
        Arete n =lesAretes.get(2);
        System.out.println(n);
        System.out.println("*******");
        
        
        
        ArrayList<Arete> lesAretesChoisi = new ArrayList<Arete>();
        
        while( lesSommetsRejoints.size() != nbSommets){
			ArrayList<Arete> lesArettesCompare = new ArrayList<Arete>();
			for( int i = 0 ; i<lesAretes.size() ; i++){
				if( (lesSommetsRejoints.contains(lesAretes.get(i).sommetA) && lesSommetsRejoints.contains(lesAretes.get(i).sommetB)==false)
					|| lesSommetsRejoints.contains(lesAretes.get(i).sommetB) && lesSommetsRejoints.contains(lesAretes.get(i).sommetA)==false){
					lesArettesCompare.add(lesAretes.get(i));
				}
			}
			Arete temporelle = lesArettesCompare.get(0);
			for( int i = 1 ; i<lesArettesCompare.size() ; i++){
				if( lesArettesCompare.get(i).compareTo(temporelle) == -1){
					temporelle = lesArettesCompare.get(i);
				}
			}
			lesAretesChoisi.add(temporelle);
			if( lesSommetsRejoints.contains(temporelle.sommetA)){
				lesSommetsRejoints.add(temporelle.sommetB);
			}else if( lesSommetsRejoints.contains(temporelle.sommetB)){
				lesSommetsRejoints.add(temporelle.sommetA);
			}
		}
		System.out.println(lesAretesChoisi);
		System.out.println(lesSommetsRejoints);
    }
}
