/**
 * @author MP
 */


package primes.quadratic ;

import java.math.BigInteger ;
import primes.Item ;
import primes.Bidimensional ;
//import primes.erathostenes.Token ;

class Matrix extends Item<Token> implements Bidimensional<Token> {
private	BigInteger entry ;
private	Item<Token> nextrow ;

/** Costruttore che inserisce un nuovo elemento <em>e</em>
       nella matrice  che continua con la riga n
       e la colonna nrow:
       @param n argomento di tipo Item che punta al resto della riga
       @param nrow argomento di tipo Item che punta al resto della colonna
       @param e il valore intero da inserire nella matrice
    */

	Matrix(Item<Token> n, Item<Token> nrow, BigInteger e) {
		super(n) ;
		
		//System.out.println("constructing Matrix object: next = "+n+" column = "+nrow+" entry = "+e);
		
		this.set(nrow, e);
	}
       
 /** Metodo setter che prende 
       @param nrow la prossima riga della matrice 
       @param e    valore da immettere
    */
private	void set(Item<Token> nrow, BigInteger e) {
		this.nextrow = nrow;
		this.entry = e;
	}
	// getters
	
/** Implementazione del Metodo get ereditato
	calcolo del rango della matrice (da fare)
	@return restituisce l'intero nel token
 */
public Token get() {
	return null ;
}

/** implementazione del metodo value() ereditato
	@return restituisce il BigInteger dell'elemento della matrice
*/
public BigInteger value() {
	return this.entry;
     } 

/** implementazione di un metodo di stampa di una riga 
 * 	della matrice
 */

private void printrow() {
	//System.out.print("M:"+this.entry+"->") ;
	System.out.print(this.entry+" ") ;
	if (!(this.next()==null)) ((Matrix)this.next()).printrow();
}

public void print() {
	this.printrow();System.out.println();
	if (!(this.column()==null)) this.column().print();
	else 
		System.out.println();
}

/**
 * This method gives back the reference to the next element
 * in the same column of the Matrix
 * @return the reference to the Item linked by nextrow attribute.
 */
public Item<Token> column () {
	return this.nextrow ;
	}


}
