package de.cpg.oss.blz.validator;

@ValidatorData(posFrom=4, posTo=9, posChecksum=10)
public class Validator87MA extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int p;
		
		int[] konto = accountNumber.getZeroFilledArray();
		
		int[] tab1 = {0, 4, 3, 2, 6};
		int[] tab2 = {7, 1, 5, 9, 8};
		
		int i = (4 - 1); 
		
		while(konto[i] == 0) {
			i = i + 1;
		}
		
		int c2 = (i + 1) % 2;
		int d2 = 0;
		int a5 = 0;
		
		while(i < (10 - 1)) {
			
			switch(konto[i]) {
				case 0:
					konto[i] = 5;
					break;
				case 1:
					konto[i] = 6;
					break;
				case 5:
					konto[i] = 10;
					break;
				case 6:
					konto[i] = 1;
					break;
			}
			
			if(c2 == d2) {
			
				if(konto[i] > 5) {
					
					if(c2 == 0 && d2 == 0) {
						c2 = 1;
						d2 = 1;
						a5 = a5 + 6 - (konto[i] - 6);
					} else {
						c2 = 0;
						d2 = 0;
						a5 = a5 + konto[i];
					}
					
				} else {
					
					if(c2 == 0 && d2 == 0) {
						c2 = 1;
						a5 = a5 + konto[i];
					} else {
						c2 = 0;
						a5 = a5 + konto[i];
					}				
				}
				
			} else {
				
				if(konto[i] > 5) {
					
					if(c2 == 0) {
						c2 = 1;
						d2 = 0;
						a5 = a5 - 6 + (konto[i] - 6);
					} else {
						c2 = 0;
						d2 = 1;
						a5 = a5 - konto[i];
					}
					
				} else {
					
					if(c2 == 0) {
						c2 = 1;
						a5 = a5 - konto[i];
					} else {
						c2 = 0;
						a5 = a5 - konto[i];
					}				
				}				
			}
			
			i = i + 1;
		}
		
		while(a5 < 0 || a5 > 4) {
			
			if(a5 > 4) {
				a5 = a5 - 5;
			} else {
				a5 = a5 + 5;
			}
		}
		
		if(d2 == 0) {
			p = tab1[a5];
		} else {
			p = tab2[a5];
		}
		
		if(p == konto[(10 - 1)]) {
			return true;
		} else {
			
			if(konto[(4 - 1)] == 0) {
				
				if(p > 4) {
					p = p - 5;
				} else {
					p = p + 5;
				}
			}
			
			if(p == konto[(10 - 1)]) {
				return true;
			} 
		}
		
		return false;
	}

}
