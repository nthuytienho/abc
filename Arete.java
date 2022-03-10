fnasokdnsaodnsadoisandoiasnfaoifnsaofinfoinfoasnfoiasnfan
public class Arete implements Comparable<Arete>{

    // Une arete relie deux sommets, elle n'a pas de sens privilegie.
    // Les sommets sont reperes par un numero.
    
    public int sommetA; // Le sommet ayant le plus petit numero des deux.
    public int sommetB; // Le sommet ayant le plus grand numero des deux.
    public int poids;
    
    public Arete(int unSommet, int autreSommet, int unPoids){
        sommetA = Math.min(unSommet,autreSommet);
        sommetB = Math.max(unSommet,autreSommet);
        poids = unPoids;
    }
    
    public String toString(){
        return "Arete du sommet "+sommetA+" au sommet "+sommetB;
    }


    // Definitions des methodes de test d'egalite et de comparaison
    // en assurant la coherence entre les deux
    // c'est a dire: 'compareTo' renvoie 0 si est seulement
    // si 'equals' renvoie 'true'
    
    public boolean equals(Arete autreArete){
    
        return ((this.sommetA == autreArete.sommetA)
            && (this.sommetB == autreArete.sommetB)
            && (this.poids == autreArete.poids));
    }
    
    public int compareTo(Arete autreArete){
    
        // critere principal sur le poids
        if (this.poids < autreArete.poids){
            return -1;
        }else if (this.poids > autreArete.poids){
            return 1;
        }else{
            // dans le cas ou les poids sont egaux
            // pour maintenir la coherence avec 'equals'
            // on utilise un critere de comparaison sur
            // les numeros des sommets A et B
            
            if (this.sommetA < autreArete.sommetA){
                return -1;
            }else if (this.sommetA > autreArete.sommetA){
                return 1;
            // les sommets A sont les memes, on continue en
            // comparant les sommets B
            }else if (this.sommetB < autreArete.sommetB){
                return -1;
            }else if (this.sommetB > autreArete.sommetB){
                return 1;
            }else{
                return 0;
            }
        }
    }
    
    // En fait, pour pouvoir utiliser de facon coherente toutes les methodes
    // disponibles sur les objets qui implementent l'interface Comparable,
    // il conviendrait aussi de redefinir la methode hashCode.
    // Ceci est hors programme, si besoin voir:
    // https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object)
    // https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()
}

