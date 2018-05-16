package primes.quadratic ;
import java.math.BigInteger;

import primes.Item;
//import primes.Bidimensional ;
//import primes.erathostenes.Token;
public class Sieve extends primes.Sieve<Token> {
 BigInteger factoring ;
 static boolean mode ;

/**
 * In the extension of a class constructors are not inherited
 */
public	Sieve (String[] args) {
		super(args, new Counter(new BigInteger(args[1]) )) ;
		Sieve.mode = false ; // factoring mode
		this.factoring = ((Counter)this.next()).factoring();
		System.out.println("constructing quadratic Sieve");
	
		this.mainloop();
		this.print() ;
	}

	
	
public	boolean testloop(Token factortoken) {
	//BigInteger safenum,candidate,residue ;
	Token primetoken ;
	
	System.out.println("factoring token in testloop:\n residue :"+factortoken.value()+" intero: "+factortoken.value2());
	
	while (factortoken.testincompletefactoring())
	{
		// passo in modalita generazione
		Sieve.mode = true ; // generating mode
		primetoken.SetPrimality(Sieve.mode);
		primetoken = this.next().get();
		
		this.seteuler() ;
		this.set( new Filter(this.next() , primetoken.value(),factortoken));	
	}
	
	Sieve.mode = false;
	return ((Matrix)(((Filter)this.next()).column()).quadratictest());
}
	
/**
 * @override of the erathosenes.Sieve mainloop
 * the only difference is on the test of
 * the primality boolean in order to create a new Filter objet
 */
	public void mainloop() {
		Token factoringtoken ;
		
		
		factoring.SetPrimality(Sieve.mode);
		factoringtoken = (Token) this.next().get() ;
		System.out.println("in Q:S:mailoop before while "+token.value2());
		
		//genera candidati finche' non trovo la combinazione
		//di righe nulla
		while (testloop(factoringtoken)) {
			
			factoringtoken = (Token) this.next().get() ;
			
		}
		
		System.out.println("in Q:S:mailoop after while : ready to new S:get()");
		token = this.next().get() ;
			
		System.out.println("in Q:S:mailoop new integer : "+token.value2()+" "+token.value());
	}
	
	public void printmatrix() {
		/* bisogna essere sicuri che si ha un Filter o un Matrix */
		((Filter)this.next()).column().print() ;
		
	}

	public Token get() {
		return null ;
	}

}
