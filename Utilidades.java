package br.com.srctreinamentotecnologico.sgcintegrado.utilidades;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public abstract class Utilidades{
	
	//fazendo com que a hora fique no formato do horario do so
	public static Date parseHora( String hora, String mascara ) throws ParseException {
		if ( hora != null && !"".equals( hora ) ) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();

			if ( mascara != null && !"".equals( mascara ) && hora.length() > 10 ) {
				dateFormat.applyPattern( mascara );
			} else {
				dateFormat.applyPattern( "HH:mm:ss" );
			}

			dateFormat.setLenient( false );
			return dateFormat.parse( hora );
		}
		/*DateFormat formatter = new SimpleDateFormat("HH:mm:ss");*/

		return null;
	}
	
	
	public static String parseHora( Date hora, String mascara ) throws ParseException {
		if ( hora != null ) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();

			if ( mascara != null && !"".equals( mascara ) ) {
				dateFormat.applyPattern( mascara );
			} else {
				dateFormat.applyPattern( "HH:mm:ss" );
			}

			dateFormat.setLenient( false );
			return dateFormat.format( hora ); // <-- O format é o que difere do outro método.
		}

		return null;
	}
	
	
	
	//cnpj
		public static boolean isCNPJ( String CNPJ ) {
			CNPJ = CNPJ.replace( ".", "" ).replace( "-", "" ).replace( "/", "" ).trim();
			// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
			if ( CNPJ.equals( "00000000000000" ) || CNPJ.equals( "11111111111111" ) || CNPJ.equals( "22222222222222" ) || CNPJ.equals( "33333333333333" ) || CNPJ.equals( "44444444444444" ) || CNPJ.equals( "55555555555555" ) || CNPJ.equals( "66666666666666" ) || CNPJ.equals( "77777777777777" ) || CNPJ.equals( "88888888888888" ) || CNPJ.equals( "99999999999999" ) || ( CNPJ.length() != 14 ) ) {
				System.out.println( "falso" + CNPJ );

				return ( false );
			}

			char dig13, dig14;
			int sm, i, r, num, peso;

			// "try" - protege o código para eventuais erros de conversao de tipo (int)
			try {
				// Calculo do 1o. Digito Verificador
				sm = 0;
				peso = 2;
				for ( i = 11; i >= 0; i-- ) {
					// converte o i-ésimo caractere do CNPJ em um número:
					// por exemplo, transforma o caractere '0' no inteiro 0
					// (48 eh a posição de '0' na tabela ASCII)
					num = (int) ( CNPJ.charAt( i ) - 48 );
					sm = sm + ( num * peso );
					peso = peso + 1;
					if ( peso == 10 )
						peso = 2;
				}

				r = sm % 11;
				if ( ( r == 0 ) || ( r == 1 ) )
					dig13 = '0';
				else
					dig13 = (char) ( ( 11 - r ) + 48 );

				// Calculo do 2o. Digito Verificador
				sm = 0;
				peso = 2;
				for ( i = 12; i >= 0; i-- ) {
					num = (int) ( CNPJ.charAt( i ) - 48 );
					sm = sm + ( num * peso );
					peso = peso + 1;
					if ( peso == 10 )
						peso = 2;
				}

				r = sm % 11;
				if ( ( r == 0 ) || ( r == 1 ) )
					dig14 = '0';
				else
					dig14 = (char) ( ( 11 - r ) + 48 );

				// Verifica se os dígitos calculados conferem com os dígitos informados.
				if ( ( dig13 == CNPJ.charAt( 12 ) ) && ( dig14 == CNPJ.charAt( 13 ) ) )
					return ( true );
				else
					return ( false );
			} catch ( InputMismatchException erro ) {
				return ( false );
			}
		}
	
	public static boolean matchesOnlyText(String text) {
	    return text.matches("[^\\d]+"); //Passa para o método matches a regex
	    //Se tiver número na string irá retornar falso
	    //Note o uso de duas \\, uma sendo obrigatória para servir de caracter de escape
	}
	
	
	//valida se for string
	public static boolean validaString(String str) {
        return str.matches("[a-zA-Z0-9]+");
    }
	
	public static boolean isCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		    if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
		        CPF.equals("22222222222") || CPF.equals("33333333333") ||
		        CPF.equals("44444444444") || CPF.equals("55555555555") ||
		        CPF.equals("66666666666") || CPF.equals("77777777777") ||
		        CPF.equals("88888888888") || CPF.equals("99999999999") ||
		       (CPF.length() != 11))
		       return(false);

		    char dig10, dig11;
		    int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		    try {
		// Calculo do 1o. Digito Verificador
		      sm = 0;
		      peso = 10;
		      for (i=0; i<9; i++) {              
		// converte o i-esimo caractere do CPF em um numero:
		// por exemplo, transforma o caractere '0' no inteiro 0         
		// (48 eh a posicao de '0' na tabela ASCII)         
		        num = (int)(CPF.charAt(i) - 48); 
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }

		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig10 = '0';
		      else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

		// Calculo do 2o. Digito Verificador
		      sm = 0;
		      peso = 11;
		      for(i=0; i<10; i++) {
		        num = (int)(CPF.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }

		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig11 = '0';
		      else dig11 = (char)(r + 48);

		// Verifica se os digitos calculados conferem com os digitos informados.
		      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
		         return(true);
		      else return(false);
		    } catch (InputMismatchException erro) {
		        return(false);
		    }
		  }

		  public static String imprimeCPF(String CPF) {
		    return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
		      CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
		  }
		
	
	
	
	public Date dataF(String data) {
        if (data == null) {
            return null;
        }
        Date dataF = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            long tempo = dateFormat.parse(data).getTime();
            dataF = new Date(tempo);
        } catch (ParseException pe) {
            System.out.println("deu erro na conversão");
        }
        return dataF;
    }

	


	
	public static Date parseDate( String data, String mascara ) throws ParseException {
		if ( data != null && !"".equals( data ) ) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();

			if ( mascara != null && !"".equals( mascara ) && data.length() > 10 ) {
				dateFormat.applyPattern( mascara );
			} else {
				dateFormat.applyPattern( "dd/MM/yyyy" );
			}

			dateFormat.setLenient( false );
			return dateFormat.parse( data );
		}

		return null;
	}

	

	public static boolean isNuloOuVazio( Object valor ) {
		if ( valor instanceof String ) {
			String string = (String) valor;
			if ( string == null || string.isEmpty() ) {
				return true;
			}
		} else if ( valor instanceof ArrayList ) {
			ArrayList arrayList = (ArrayList) valor;
			if ( arrayList == null || arrayList.isEmpty() ) {
				return true;
			}
		} else if ( valor instanceof HashSet ) {
			HashSet setList = (HashSet) valor;
			if ( setList == null || setList.isEmpty() ) {
				return true;
			}
		} else {
			return valor == null;
		}

		return false;
	}

	public static void validarCampoData( JTextField data ) {
		if ( data.getText() != null && !data.getText().replace( "/", "" ).trim().isEmpty() ) {
			try {
				SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yyyy" );
				df.setLenient( false );
				df.parse( data.getText() );

				data.setForeground( Color.BLACK );
			} catch ( ParseException e ) {
				data.setForeground( Color.RED );
				data.requestFocus();
			}
		} else {
			( (JFormattedTextField) data ).setValue( "" );
			data.setForeground( Color.BLACK );
		}
	}
	

/*	public static void validarCampoCPF( JTextField cpf ) {
		
		if ( cpf.getText() != null && !cpf.getText().replace( ".", "" ).replace( "-", "" ).trim().isEmpty() ) {
			if ( isCpfValido( cpf.getText().replace( ".", "" ).replace( "-", "" ) ) ) {
				cpf.setForeground( Color.BLACK );
			} else {
				cpf.setForeground( Color.RED );
				cpf.requestFocus();
			}
		} else {
			( (JFormattedTextField) cpf ).setValue( "" );
			cpf.setForeground( Color.BLACK );
		}
	}*/
	
	public static String removeMask(String cpf) {
	    String str = cpf;
	    while (str.indexOf("-") != -1) {
	      if (str.indexOf("-") != 0) {
	        str = str.substring(0, str.indexOf("-")) +
	            str.substring(str.indexOf("-") + 1);
	      }
	      else {
	        str = str.substring(str.indexOf("-") + 1);
	      }
	    }
	    while (str.indexOf(".") != -1) {
	      if (str.indexOf(".") != 0) {
	        str = str.substring(0, str.indexOf(".")) +
	            str.substring(str.indexOf(".") + 1);
	      }
	      else {
	        str = str.substring(str.indexOf(".") + 1);
	      }
	    }
	    return str;
	  }
	
	public static String removerMascara(String cpf){
	    return cpf.replaceAll("\\D", "");
	}
	
	public static String removeContaMask(String str){
    	StringBuffer pkWithoutMask = new StringBuffer("");
    	String pk = str;
    	try {
    		if (pk != null) {
    	    	for (int i = 0; pk.length() > i; i++) {
    	    		if (pk.charAt(i) != '.') {
    	    			pkWithoutMask.append(pk.charAt(i));
    	    		}
    		    }
    	    }
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return pkWithoutMask.toString().trim();
    }

	
	public static String parseDate( Date data, String mascara ) throws ParseException {
		if ( data != null ) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();

			if ( mascara != null && !"".equals( mascara ) ) {
				dateFormat.applyPattern( mascara );
			} else {
				dateFormat.applyPattern( "dd/MM/yyyy" );
			}

			dateFormat.setLenient( false );
			return dateFormat.format( data ); // <-- O format é o que difere do outro método.
		}

		return null;
	}
	
	public static String formatCPF(String cpf) {
		Pattern pattern = Pattern.compile(cpf);
		Matcher matcher = pattern.matcher(cpf);
		if (matcher.matches()) 
			cpf = matcher.replaceAll("$1.$2.$3-$4");
		return cpf;		
	}
	
	public static boolean isCpfValido( String CPF ){		
		CPF = CPF.replace(".","").replace("-", "").trim();
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais 
		if ( CPF.equals( "00000000000" ) || CPF.equals( "11111111111" ) || CPF.equals( "22222222222" ) || CPF.equals( "33333333333" ) || CPF.equals( "44444444444" ) || CPF.equals( "55555555555" ) || CPF.equals( "66666666666" ) || CPF.equals( "77777777777" ) || CPF.equals( "88888888888" ) || CPF.equals( "99999999999" ) || ( CPF.length() != 11 ) ) {
			System.out.println("cpf invalido" + CPF);
			
			return (  false );
		}
		 
		
		  
		char dig10, dig11;
		int sm, i, r, num, peso;
		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador 
			sm = 0;
			peso = 10;
			for ( i = 0; i < 9; i++ ) {
				// converte o i-esimo caractere do CPF em um numero: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posicao de '0' na tabela ASCII) 
				num = (int) ( CPF.charAt( i ) - 48 );
				sm = sm + ( num * peso );
				peso = peso - 1;
			}
			r = 11 - ( sm % 11 );
			if ( ( r == 10 ) || ( r == 11 ) ) {
				dig10 = '0';
			} else {
				dig10 = (char) ( r + 48 );
			}
			// converte no respectivo caractere numerico 
			// Calculo do 2o. Digito Verificador 
			sm = 0;
			peso = 11;
			for ( i = 0; i < 10; i++ ) {
				num = (int) ( CPF.charAt( i ) - 48 );
				sm = sm + ( num * peso );
				peso = peso - 1;
			}
			r = 11 - ( sm % 11 );
			if ( ( r == 10 ) || ( r == 11 ) ) {
				dig11 = '0';
			} else {
				dig11 = (char) ( r + 48 );
			}
			// Verifica se os digitos calculados conferem com os digitos informados. 
			if ( ( dig10 == CPF.charAt( 9 ) ) && ( dig11 == CPF.charAt( 10 ) ) ) {
				return ( true );
			} else {
				return ( false );
			}
		} catch ( InputMismatchException erro ) {
			return ( false );
		}

		
	}
		 
	
}
