import java.io.File; 
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Polynomial {
	double [] coeffitients;
	int [] exponents;

	public Polynomial () {
		coeffitients = new double[1];
		exponents = new int[1];
		coeffitients[0] = 0;
		exponents[0] = 0;
	}
	
	public Polynomial (File f) {
	    if(f.canRead()){
	        try(Scanner myReader = new Scanner(f)){
	        String data = myReader.nextLine();
	        String regex = "[-\\+]";
	        int l = 0;
            String[] m = data.split(regex);
            		double [] coeffitient = new double[m.length];
		            int [] exponent = new int[m.length];
		            int c = 0;
            for(int i = 0;i < m.length;i++){
                
                String[] m2 = m[i].split("x");
                if(m2[0].length()==0){continue;}
                if(m2.length == 1){exponent[c]=0;coeffitient[c]= Double.parseDouble(data.charAt(l)+m2[0]);c++;}
                
                else if(m2.length > 1) {exponent[c]=Integer.parseInt(m2[1]);coeffitient[c]= Double.parseDouble(data.charAt(l)+m2[0]);c++;}
            l = l + m[i].length() + 1;
            }
            coeffitients = new double[c];
		    exponents = new int[c];
            for(int i=0; i < c;i++){coeffitients[i]=coeffitient[i];exponents[i]=exponent[i];};
	    }catch (FileNotFoundException e) {}
	}
	
	}
 	public Polynomial (double [] a, int [] p) {
                coeffitients = new double[a.length];
                exponents = new int[p.length];
		for(int i=0;i<a.length;i++){
			coeffitients[i]=a[i];
			exponents[i]=p[i];
			}
        }
    public void saveToFile(String s){
            try{FileWriter myWriter = new FileWriter(s);
            String m = "";
            for(int i = 0; i < this.exponents.length;i++){
                if(this.exponents[i]==0){
                    if(this.coeffitients[i]>0){m = m + "+" + this.coeffitients[i];}
                    else{m = m + this.coeffitients[i];}
                }
                else{
                    if(this.coeffitients[i]>0){m = m + "+" + this.coeffitients[i]+ "x"+this.exponents[i];}
                    else{m = m + this.coeffitients[i]+ "x"+this.exponents[i];}
                    
                }
            }
            myWriter.write(m);
            myWriter.close();}catch (IOException e) {}
    }

	public Polynomial add(Polynomial p){
		int c = 0;
		int members = 0;
		
		int matp = p.exponents[p.exponents.length-1];
		int matt = this.exponents[this.exponents.length-1];
		int m = 0;
		
		if(matp > matt){m = matp;}else{m = matt;};
		
		/*if(p.exponents.length > this.exponents.length){
    		for(int i = 0; i < this.exponents.length && c < p.exponents.length;i++){
    		    if(p.exponents[c] == this.exponents[i]){c++;members++;}
    		    else if(p.exponents[c] > this.exponents[i]){members++;}
    		    else if(p.exponents[c] < this.exponents[i]){members++;c++;i--;}
    		}
    		for(int i = this.exponents.length; i < p.exponents.length;i++){
    		    c++;members++;
    		}
		    
		}
		else{//for(int j = 0; j < p.exponents.length;j++){System.out.println(p.exponents[j] + " pppp: " + p.coeffitients[j]);};
		    for(int i = 0; i < p.exponents.length && c < p.exponents.length;i++){
    		    if(p.exponents[c] == this.exponents[i]){c++;members++;}
    		    else if(p.exponents[c] > this.exponents[i]){members++;}
    		    else if(p.exponents[c] < this.exponents[i]){members++;c++;i--;}
    		}
		        for(int i = p.exponents.length; i < this.exponents.length;i++){
    		    c++;members++;
    		}
		}
		*/
		
		for(int i=0;i<this.exponents.length;i++){
		    for(int j=0;j<p.exponents.length;j++){if(this.exponents[i] == p.exponents[j]){members++;break;}};
		}
		members = this.exponents.length + p.exponents.length - members;
		
		int [] rexponents = new int[members];
		double [] rcoeffitients = new double[members];
		
		c = 0;
		
		for(int i = 0; i < p.exponents.length;i++){rexponents[i]=p.exponents[i];rcoeffitients[i]=p.coeffitients[i];}
		for(int j =0; j< members;j++){for(int i=0;i < this.exponents.length;i++){if(rexponents[j]==this.exponents[i]){rcoeffitients[j]=rcoeffitients[j]+this.coeffitients[i];};};}
        for(int i = p.exponents.length; i < members; i++){
            for(int j =0; j < this.exponents.length;j++){
                for(int x =0; x <= i;x++){if(rexponents[x]==this.exponents[j]){c=1;break;}}
                if(c==0){rexponents[i]=this.exponents[j];rcoeffitients[i]=this.coeffitients[j];break;}else{c=0;}
            }
        }
		/*
		for(int i = 0; i <= m && c < this.exponents.length; i++){
	        if(i == this.exponents[c]){rcoeffitients[c]=rcoeffitients[c] + this.coeffitients[c];rexponents[c] = i;c++;};
	    }
		*/
		return new Polynomial(rcoeffitients, rexponents);

	}
	
	public Polynomial monomial_multiply(double c, int e, Polynomial p){
	    int [] expo = new int[p.exponents.length];
	    double [] coef = new double[p.coeffitients.length];
	    for(int i =0; i < p.exponents.length;i++){expo[i]=p.exponents[i]+e;coef[i]=p.coeffitients[i]*c;}
	    //for(int i = 0; i < p.exponents.length;i++){System.out.println(expo[i] + " c: " + coef[i]);};
	    return new Polynomial(coef,expo);
	}

	public Polynomial eliminateo(Polynomial p){

	    int members = p.exponents.length;
	    for(int i = 0; i < p.exponents.length;i++){if(Double.compare(p.coeffitients[i], 0.0) == 0){members=members-1;}}

	    int [] expo = new int[members];
	    double [] coef = new double[members];
	    int c = 0;
	    for(int i =0; i < p.exponents.length;i++){if(p.coeffitients[i] != 0.0){expo[c]=p.exponents[i];coef[c]=p.coeffitients[i];c++;}}
	    return new Polynomial(coef,expo);
	}
	 
	 	 
	public Polynomial multiply(Polynomial p){
	    Polynomial r = new Polynomial();
	    Polynomial pp = new Polynomial();
	    Polynomial in = new Polynomial();
	    for(int i = 0; i<this.exponents.length;i++){
	        pp=monomial_multiply(this.coeffitients[i], this.exponents[i],p);
	        //for(int j = 0; j < pp.exponents.length;j++){System.out.println(pp.exponents[j] + " c: " + pp.coeffitients[j]);};
	        r = pp.add(r);
	        //for(int j = 0; j < r.coeffitients.length;j++){System.out.println(r.exponents[j] + " c: " + r.coeffitients[j]);};
	        
	    ;}
	    
	    return eliminateo(r);
	}
	
	public double evaluate(double x){
	double sum = 0;
	for(int i=0;i<this.coeffitients.length;i++){
		sum = sum + this.coeffitients[i]*Math.pow(x,this.exponents[i]);
	}
	return sum;
	}
        public boolean hasRoot(double x){ 
        if(evaluate(x)==0){return true;}else{return false;}
        }

}

