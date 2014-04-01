
package example14;

//class Number {
//	int a, b;
//	
//	Number(int aa, int bb){
//		a = aa;
//		b = bb;
//	}
//	
//	void print(){} //will be overridden with subclasses
//	
//	Number add(Number n1, Number n2){
//		return new Number(0,0);
//	}
//	
//	
//}

abstract class Number {
	int a, b;
	
	Number(int aa, int bb){
		a = aa;
		b = bb;
	}
	
	abstract void print();//will be overridden with subclasses
	
	abstract Number add(Number n1, Number n2);	
}

class Complex extends Number{
	Complex(int aa, int bb){
		super(aa, bb);
	}
	
	void print(){
		System.out.println(a+"+"+b+"i");
	}
	
	Number add(Number n1, Number n2){
		return new Complex(n1.a + n2.a, n1.b + n2.b);
	}
}

class Rational extends Number{
	
	Rational(int aa, int bb){
		super(aa, bb);
	}
	
	void print(){
		System.out.println(a+"/"+b);
	}
	
	Number add(Number n1, Number n2){
		return new Rational(n1.a*n2.b + n2.a*n1.b, n1.b*n2.b);
	}
}
public class Example14 {

	public static void main(String[] args) {
		// TODO code application logic here
		
		Complex c1 = new Complex(2, 3);
		Complex c2 = new Complex(-2, -3);
		Rational r1 = new Rational(3, 4);
		Rational r2 = new Rational(5, -2);
		
		c1.print();
		c2.print();
		r1.print();
		r2.print();
		
		c1.add(c1, c2).print();
		r1.add(r1, r2).print();
		
		Number numList[] = {new Complex(2,9), new Complex(-3,10),
							new Rational(1,4), new Rational(1,3)};
		
		System.out.println("\nNumber List:");
		for(int i=0; i<numList.length; i++){
			numList[i].print();
		}
	}
	
}
