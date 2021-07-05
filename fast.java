import java.net.*;
import java.util.*;
import java.io.*;
import java.math.*;
import javax.crypto.*;
import java.security.*;

//Name: Muhammad Nuh Bin Norseni
//java version "1.8.0_212"

class Fast{	
	public static int a, b, p, val, val2;
	public static String binB, bSX;
	public static List<String> bSXList = new ArrayList<String>();

	public static void main( String args[] ) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		//input of all three parameters.
		System.out.println("\nPlease key in the values for a^b mod p.");
		while(true){
			try{
				while(true){
					System.out.printf("a = ");
					a = scanner.nextInt();
					System.out.printf("b = ");
					b = scanner.nextInt();
					System.out.printf("p = ");
					p = scanner.nextInt();
					if(p == 0){
						System.out.println("Invalid input, p cannot be 0, please re-enter.");
					}
					else{
						break;
					}
				}
				break;
			}
			catch(InputMismatchException e){
				String badInput = scanner.next();
				System.out.println("Invalid input, a,b and p needs to be an integer.");
				continue;
			}
		}
		
		//convertion of b to binary.
		binB = Integer.toBinaryString(b);
		System.out.println("Binary of " + b + " is " + binB);
		
		//convertion of binary to S and X notation.
		bSX = "";
		for(int i = 0; i < binB.length(); i++){ 
			char c = binB.charAt(i);
			if(i == binB.length() - 1){
				if(c == '1'){
					bSX += "SX";
				}
				else{
					bSX += "S";
				}
			}
			else{
				if(c == '1'){
					bSX += "SX ";
				}
				else{
					bSX += "S ";
				}
			}
		}
		//output of SX form before removal of first SX.
		System.out.println("The SX form: " + bSX);
		
		//output of SX form after removal of first SX.
		bSX = bSX.replaceFirst("SX ", "");
		System.out.println("Drop the first SX: " + bSX + "\n");
		
		bSXList = Arrays.asList(bSX.split(" ", -1));
		
		//computing according to the sequence.
		val = a;
		for(int i = 0; i < bSXList.size(); i++){
			if((bSXList.get(i)).equals("SX")){
				val2 = (val*val*a)%p;
				System.out.println((i+1) + ".SX: " + val  + "^2" + " x " + a + "mod" + p + " = " + val2);
				val = val2;
			}
			else{
				val2 = (val*val)%p;
				System.out.println((i+1) + ".S:  " + val  + "^2" + " mod" + p + " = " + val2);
				val = val2;
			}
		}
		System.out.println("\nHence " + a + "^" + b +" mod " + p + " = " + val2);
	}
}













