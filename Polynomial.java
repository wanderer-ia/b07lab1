public class Polynomial {
	double [] coeffitients;

	public Polynomial () {
		coeffitients = new double[1];
		coeffitients[0] = 0;
	}
 	public Polynomial (double [] a) {
                coeffitients = new double[a.length];
		for(int i=0;i<a.length;i++){
			coeffitients[i]=a[i];
			}
        }

	public Polynomial add(Polynomial p){
		Polynomial r;
		if(p.coeffitients.length > this.coeffitients.length){
			r = new Polynomial(p.coeffitients);
			for(int i=0;i<this.coeffitients.length;i++){ 
                        	r.coeffitients[i]=r.coeffitients[i] + this.coeffitients[i];
                        }
		}
		else{	r = new Polynomial(this.coeffitients);
			 for(int i=0;i<p.coeffitients.length;i++){ 
                                r.coeffitients[i]=r.coeffitients[i] + p.coeffitients[i];
                        }
		}
		return r;
	}
	
	public double evaluate(double x){
	double sum = 0;
	for(int i=0;i<this.coeffitients.length;i++){
		sum = sum + this.coeffitients[i]*Math.pow(x,i);
	}
	return sum;
	}
        public boolean hasRoot(double x){ 
        if(evaluate(x)==0){return true;}else{return false;}
        }

}

