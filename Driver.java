import java.io.File;    

public class Driver {
public static void main(String [] args) {

/// No one said anything about sorting, so nothing is sorted: use hash map and merge sort otherwise.

double [] c1 = {6,-2, 5};
int [] c2 = {0,1,3};
Polynomial p1 = new Polynomial(c1,c2);
double [] c3 = {1,1, 1,1};
int [] c4 = {2,4,5,6};
Polynomial p2 = new Polynomial(c3,c4);

////////////////////////////////////////////////////////////////
System.out.println("Test 1: One is bigger + Disjoint");
String output = "";
for(int i = 0; i < p1.exponents.length;i++){output = output + p1.coeffitients[i] + "x^" + p1.exponents[i] + " ";};
System.out.println("p1(x)="+output);

output = "";
for(int i = 0; i < p2.exponents.length;i++){output = output + p2.coeffitients[i] + "x^" + p2.exponents[i] + " ";};
System.out.println("p2(x)="+output);
////////
Polynomial s = p2.add(p1);
////////
output = "";
for(int i = 0; i < s.exponents.length;i++){output = output + s.coeffitients[i] + "x^" + s.exponents[i] + " ";};
System.out.println("p1(x)+p2(x)=s(x)="+output);
System.out.println("s(2) = " + s.evaluate(2));
//////////////////////////////////////

////////////////////////////////////////////////////////////////
System.out.println("Test 2: Another one is bigger + Disjoint");
output = "";
for(int i = 0; i < p1.exponents.length;i++){output = output + p1.coeffitients[i] + "x^" + p1.exponents[i] + " ";};
System.out.println("p1(x)="+output);

output = "";
for(int i = 0; i < p2.exponents.length;i++){output = output + p2.coeffitients[i] + "x^" + p2.exponents[i] + " ";};
System.out.println("p2(x)="+output);
////////
s = p1.add(p2);
////////
output = "";
for(int i = 0; i < s.exponents.length;i++){output = output + s.coeffitients[i] + "x^" + s.exponents[i] + " ";};
System.out.println("p1(x)+p2(x)=s(x)="+output);
System.out.println("s(2) = " + s.evaluate(2));
//////////////////////////////////////

////////////////////////////////////////////////////////////////
System.out.println("Test 2.5: Multiplication");
output = "";
for(int i = 0; i < p1.exponents.length;i++){output = output + p1.coeffitients[i] + "x^" + p1.exponents[i] + " ";};
System.out.println("p31(x)="+output);

output = "";
for(int i = 0; i < p2.exponents.length;i++){output = output + p2.coeffitients[i] + "x^" + p2.exponents[i] + " ";};
System.out.println("p2(x)="+output);
////////
s = p1.multiply(p2);
////////
output = "";
for(int i = 0; i < s.exponents.length;i++){output = output + s.coeffitients[i] + "x^" + s.exponents[i] + " ";};
System.out.println("p1(x)*p2(x)=s(x)="+output);
System.out.println("s(2) = " + s.evaluate(2));
//////////////////////////////////////



double [] c5 = {6,-2, 5};
int [] c6 = {0,1,3};
p1 = new Polynomial(c5,c6);
double [] c7 = {1,1, 1,1};
int [] c8 = {0,3,5,6};
p2 = new Polynomial(c7,c8);

////////////////////////////////////////////////////////////////
System.out.println("Test 3: One is bigger + Intersection");
output = "";
for(int i = 0; i < p1.exponents.length;i++){output = output + p1.coeffitients[i] + "x^" + p1.exponents[i] + " ";};
System.out.println("p3(x)="+output);

output = "";
for(int i = 0; i < p2.exponents.length;i++){output = output + p2.coeffitients[i] + "x^" + p2.exponents[i] + " ";};
System.out.println("p4(x)="+output);
////////
s = p2.add(p1);
////////
output = "";
for(int i = 0; i < s.exponents.length;i++){output = output + s.coeffitients[i] + "x^" + s.exponents[i] + " ";};
System.out.println("p3(x)+p4(x)=s(x)="+output);
System.out.println("s(2) = " + s.evaluate(2));
//////////////////////////////////////

////////////////////////////////////////////////////////////////
System.out.println("Test 4: Another one is bigger + Intersection");
output = "";
for(int i = 0; i < p1.exponents.length;i++){output = output + p1.coeffitients[i] + "x^" + p1.exponents[i] + " ";};
System.out.println("p3(x)="+output);

output = "";
for(int i = 0; i < p2.exponents.length;i++){output = output + p2.coeffitients[i] + "x^" + p2.exponents[i] + " ";};
System.out.println("p4(x)="+output);
////////
s = p1.add(p2);
////////
output = "";
for(int i = 0; i < s.exponents.length;i++){output = output + s.coeffitients[i] + "x^" + s.exponents[i] + " ";};
System.out.println("p1(x)+p2(x)=s(x)="+output);
System.out.println("s(2) = " + s.evaluate(2));
//////////////////////////////////////

////////////////////////////////////////////////////////////////
System.out.println("Test 5: Add again to test reference");
output = "";
for(int i = 0; i < p1.exponents.length;i++){output = output + p1.coeffitients[i] + "x^" + p1.exponents[i] + " ";};
System.out.println("p3(x)="+output);

output = "";
for(int i = 0; i < p2.exponents.length;i++){output = output + p2.coeffitients[i] + "x^" + p2.exponents[i] + " ";};
System.out.println("p4(x)="+output);
////////
s = p1.add(p2);
s = s.add(p2);
////////
output = "";
for(int i = 0; i < s.exponents.length;i++){output = output + s.coeffitients[i] + "x^" + s.exponents[i] + " ";};
System.out.println("p1(x) + p2(x) + p2(s)=s(x)="+output);
System.out.println("s(2) = " + s.evaluate(2));
//////////////////////////////////////

////////////////////////////////////////////////////////////////
System.out.println("Test 6: Multiplication");
output = "";
for(int i = 0; i < p1.exponents.length;i++){output = output + p1.coeffitients[i] + "x^" + p1.exponents[i] + " ";};
System.out.println("p3(x)="+output);

output = "";
for(int i = 0; i < p2.exponents.length;i++){output = output + p2.coeffitients[i] + "x^" + p2.exponents[i] + " ";};
System.out.println("p4(x)="+output);
////////
s = p1.multiply(p2);
////////
output = "";
for(int i = 0; i < s.exponents.length;i++){output = output + s.coeffitients[i] + "x^" + s.exponents[i] + " ";};
System.out.println("p1(x)*p2(x)=s(x)="+output);
System.out.println("s(2) = " + s.evaluate(2));
//////////////////////////////////////

////////////////////////////////////////////////////////////////
System.out.println("Test 7: File Methods");
s.saveToFile("out.txt");
File f = new File("out.txt");
Polynomial p = new Polynomial(f);
output = "";
for(int i = 0; i < p.exponents.length;i++){output = output + p.coeffitients[i] + "x^" + p.exponents[i] + " ";};
System.out.println("file content after save (should be the same as above multiplication)="+output);
//////////////////////////////////////

if(s.hasRoot(1))
System.out.println("1 is a root of s");
else
System.out.println("1 is not a root of s");
}
}
