import java.io.*;
public class Proyecto1LaCifraVigenere {
   
// Programa Codificador y Decodificador usando la Cifra Vigenere (Proyecto1)
    
    public static void main(String[] args) {

//Declaracion de Variables
    
    int opcion,longitudClave,longitudTexto,i,minuscula,diferente,n,j,k,l,error;
    String salidaprograma, texto, clave,textoCod,A,a,claveCod,Codificado;
    char f;

//Inicializacion de Variables
    
    opcion=0;longitudClave=0;longitudTexto=0;minuscula=0;diferente=0;j=0;l=0;error=0; 
    salidaprograma=""; texto=""; clave="";textoCod="";A="A";a="a";claveCod="";Codificado="";
    
    do {
    
//Menu Principal
    
    System.out.println ("//////////////////////////////////////////////////////");
    System.out.println ("//  UCV. Facultad de Ciencias                       //");
    System.out.println ("//  Escuela de Computacion                          //");
    System.out.println ("//  Algoritmos y Programacion                       //");
    System.out.println ("//  Proyecto 1. La Cifra Vigenere                   //");
    System.out.println ("//////////////////////////////////////////////////////");
    System.out.println ("//                      Menu                        //");
    System.out.println ("//////////////////////////////////////////////////////");	
    System.out.println ("//  1. Desarrollador                                //");
    System.out.println ("//  2. Codificar mensaje                            //");
    System.out.println ("//  3. Decodificar mensaje                          //");
    System.out.println ("//  4. Salir                                        //");
    System.out.println ("//////////////////////////////////////////////////////");	
    System.out.println ("//  Introduzca la opcion deseada                    //");
    System.out.println ("//////////////////////////////////////////////////////");
    
//Se lee la opcion del menu que desea el usuario
      	 
    try{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		 opcion=Integer.parseInt(bf.readLine	());
   }catch(Exception E){
		               opcion=0; //Si entra un error por aqui, la opcion se hace 0, entrando por el default del switch
		              }      

//Posibles casos de la variable opcion
		         	
    switch(opcion){
           	
//Opcion 1, nombre del desarrollador
           		
         case 1 : System.out.println ("//////////////////////////////////////////////////////");
      	          System.out.println ("//  Opcion 1: Desarrollador                         //");
      	          System.out.println ("//////////////////////////////////////////////////////");
                  System.out.println ("//  Abelardo Moreno                                 //");
                  System.out.println ("//  18.002.106                                      //");
                  System.out.println ("//  Seccion C1                                      //");
                  System.out.println ("//////////////////////////////////////////////////////"); break;
      	     
//Opcion 2, Codificacion del Mensaje

		 case 2 : do{ //repetir en caso de error
//Se pide el texto a codificar		 
		 	      System.out.println ("//////////////////////////////////////////////////////");
      	          System.out.println ("//  Opcion 2: Codificar Mensaje                     //");
      	          System.out.println ("//////////////////////////////////////////////////////");
                  System.out.println ("//  Introduzca el texto a Codificar                 //");
                  System.out.println ("//////////////////////////////////////////////////////");               		
           	      
//Se lee el texto que desea codificar el usuario
           	      
           	      error=0; //la variable error se hace 0 para que no tenga valores anteriores	
           	        try{
		              BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		              texto=bf.readLine();
                 }catch(Exception E){
                 	  System.out.println ("//////////////////////////////////////////////////////");
		              System.out.println ("//  Se ha producido un error                        //");
		              error=1; //Si se produce un error al leer el texto, la variable error se hace 1 y se alerta al usuario
		              } 

//Se valida que el texto no este en blanco
		              	
		           if(texto.equals("")){//Se usa equals para comparar directamente el texto con vacio		           	  
		           	  System.out.println ("//////////////////////////////////////////////////////");
		           	  System.out.println ("//  Debe introducir un texto                        //");
		           	  error=1; //Si el texto estaba en blanco, la variable error se hace 1 y se alerta al usuario
		            }    	
		              	
		          }while(error==1); //Si la variable error es 1, se repetira la solicitud del texto  
		          		  	
           	    do{ //repetir en caso de error
           	    
//Se pide la clave           	    
           	      System.out.println ("//////////////////////////////////////////////////////");
                  System.out.println ("//  Introduzca la Clave                             //");
                  System.out.println ("//////////////////////////////////////////////////////");

//Se lee la clave que desea utilizar el usuario para codificar
                  
                  error=0; //Se hace error igual a 0 para que no tenga valores anteriores
                     try{
		              BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		              clave=bf.readLine();
                 }catch(Exception E){
		               error=1;//Si se produce un error al leer el texto, la variable error se hace 1 y se alerta al usuario
		               System.out.println ("//////////////////////////////////////////////////////");
		               System.out.println ("//  Se ha producido un error                        //");
		               } 
		               	
//Se valida que el texto no este en blanco		               	
		          if(clave.equals("")){ //Se usa equals para comparar directamente la clave con vacio
		          	System.out.println ("//////////////////////////////////////////////////////");
		          	System.out.println ("//  Debe introducir una clave                       //");
		          	error=1;//Si el texto estaba en blanco, la variable error se hace 1 y se alerta al usuario
		          }     	
		               	
           	    }while(error==1); //Si se produce un error al leer la clave, se repetira la solicitud de la clave   
           	    	 	
//Se asigna a una variable entero la longitud del texto y la clave
		              	
           	     longitudClave=clave.length();
		         longitudTexto=texto.length();
		         
/*Las variables "Codificado", "i" y "j" se declaran vacias y cero
 para evitar que tenga algun dato de una codificacion previa*/
 		         
		         Codificado="";
		         i=0;
		         j=0;

//Se hace un "Para" que durara hasta que i sea menor que la longitud del texto
		         
		         for(i=0; i<longitudTexto; i++){
		        	
/*Las siguientes variables se hacen cero al empezar cada ciclo del "Para", para
 evitar que posean valores de otros ciclos*/
 		        	
		        	 minuscula=0;
		        	 diferente=0;
		        	 
/*Se toma cada caracter por separado con substring y se usa compareTo para compararlo		        	 
con la letra "A", y luego ese valor se le saca el negativo para hacerlo positivo (0="A", 25="Z")*/

		             textoCod=texto.substring(i,i+1);
		             n=A.compareTo(textoCod); //"A" es una variable string que equivale a "A"
		             n=-n;
		             
/*Si el "n" que se obtuvo con el compareTo es mayor que 31 y menor que 58
 entonces el caracter es una letra minuscula (32="a", 57="z") */
 		             
		             if(n>31 && n<58){

/* Al ser una letra minuscula se compara cara caracter con la letra "a" y se coloca negativo
 para hacer el valor positivo, y la variable minuscula se hace 1*/
 	             	
		                n=a.compareTo(textoCod); //"a" es una variable string que equivale a "a"
		                n=-n;
		                minuscula=1; 
		             }else{
		             	
/*Si en cambio, "n" es menor que cero o mayor que 25 y menor que 32 o mayor que 57, entonces el caracter
 no forma parte del alfabeto que estamos usando para codificar y la variable "diferente" se hace 1
 para alertar posteriormente que no es un caracter que interesa codificar*/
 		             	
		             	if(n<0 || (n>25 && n<32) || (n>57)){
		             	diferente=1;	
		             	}
		              }	
		            
/*Se hace el mismo procedimiento anterior con la clave, en este caso se usa "j" en el substring
para hacerlo independiente del i del "Para"
		             
Se toma cada caracter por separado con substring y se usa compareTo para compararlo		        	 
con la letra "A", y luego ese valor se le saca el negativo para hacerlo positivo (0="A", 25="Z")*/	
	             
		             claveCod=clave.substring(j,j+1);		             
		             k=A.compareTo(claveCod);
		             k=-k;
		             
/*Si el "k" que se obtuvo con el compareTo es mayor que 31 y menor que 58
 entonces el caracter es una letra minuscula (32="a", 57="z")*/
 		             
		             if(k>31 && k<58){
		             	
/* Al ser una letra minuscula se compara cara caracter con la letra "a" y se coloca negativo
 para hacer el valor positivo, al ser esta la clave, no nos interesa si esta en mayusculas o minusculas*/		             	
		             	
		              k=a.compareTo(claveCod);
		              k=-k;		  
		              	        		
		             }else{
		             	
/*Si en cambio, "k" es menor que cero o mayor que 25 y menor que 32 o mayor que 57, entonces el caracter
 no forma parte del alfabeto que estamos usando para codificar y la variable "diferente" se hace 1
 para alertar posteriormente que no es un caracter que interesa codificar*/
 		             	
		             	if(k<0 || (k>25 && k<32) || (k>57)){
		             	diferente=1;	
		             	}
		              }	

//Ahora se suman los valores de n y k para obtener una codificacion parcial
		              	
		             l=n+k;
		             
		             if(l>=26){//Si l es mayor que 26, entonces se le resta 26 para que el resultado este entre 0 y 25
		                   
		                   l=l-26;	
		               }     
		               	
		             if(minuscula==0){//Si el texto era en mayuscula, se le suma 65 para obtener si equivalente en el codigo ascii
		           	     
		           	    l=l+65; 
	    	    			           	 	           	    	
		             }else{//Si el texto era minuscula, se le suma 97 para obtener su equivalente en el codigo ascii
		             			           	        
		           	     l=l+97;
		             	  }
		             	  
//Ahora se empieza a ver como se imprimiran los caracteres
		           		 	
/*Si se tenia la variable "diferente" igual a 1, entonces ese caracter no se va a codificar
 y se concadena el caracter a la variable "Codificado"*/
 		           		 	
		           if(diferente==1){
		         	
		             Codificado=Codificado+textoCod;			           
		                      
		         
				 }else{ //Si "diferente" no era igual a 1, entonces se concadena el caracter codificado a la variable "Codificado"
	         
		              f=(char)l; //se le asigna a la variable de tipo char "f" el equivalente en caracter del entero "l"
		              Codificado=Codificado+f;  	              
		  	          }
		               
		             j=j+1;//Al acabarse el ciclo, se aumenta en 1 la variable j  
		             	
		              if(j>=longitudClave){ //Si j llega a ser mayor o igual que la longitud de la clave, entonces se hace cero para que empieze otra vez
		             	
		                j=0;	
		                }
		        }//fin del "Para"
		       
//Fuera del "Para" se imprime todo lo que se concadeno a "Codificado"		        
		        
		        System.out.println ("//////////////////////////////////////////////////////");
		        System.out.println ("//  El texto Codificado es                          //");
		        System.out.println ("//////////////////////////////////////////////////////");
                System.out.println ("//  "+Codificado); 		 	
		        System.out.println ("//////////////////////////////////////////////////////");break;
		 
//Opcion 3, Decodificacion del Mensaje

         case 3 : do{//repetir en caso de error
         
//Se pide el texto a codificar         
         	      System.out.println ("//////////////////////////////////////////////////////");
      	          System.out.println ("//  Opcion 3: Decodificar Mensaje                   //");
      	          System.out.println ("//////////////////////////////////////////////////////");
                  System.out.println ("//  Introduzca el texto a Decodificar               //");
                  System.out.println ("//////////////////////////////////////////////////////");               		

//Se lee el texto que se desea decodificar
           	       
           	      error=0;//la variable error se hace 0 para que no tenga valores anteriores 	
           	        try{
		              BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		              texto=bf.readLine();
                 }catch(Exception E){
		              error=1; //Si se produce un error al leer el texto, la variable error se hace 1 y se alerta al usuario
		              System.out.println ("//////////////////////////////////////////////////////");	
		              System.out.println ("//  Se ha Producido un error                        //");
		              }
		              
//Se valida que el texto no este en blanco	
	              
		           if(texto.equals("")){//Se usa equals para comparar directamente el texto con vacio
		           
		           	   error=1;//Si el texto estaba en blanco, la variable error se hace 1 y se alerta al usuario
		           	   System.out.println ("//////////////////////////////////////////////////////");
		           	   System.out.println ("//  Debe introducir un texto                        //");
		           }   
                 }while(error==1);//Si la variable error es 1, se repetira la solicitud del texto
                
                  do{//repetir en caso de error

//Se pide la clave con la que se va a decodificar
                           	
           	      System.out.println ("//////////////////////////////////////////////////////");
                  System.out.println ("//  Porfavor, Introduzca la Clave                   //");
                  System.out.println ("//////////////////////////////////////////////////////");
             
//Se lee la clave con la que se va a decodificar

                  error=0;//la variable error se hace 0 para que no tenga valores anteriores	
                     try{
		              BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		              clave=bf.readLine();
                 }catch(Exception E){
		              error=1;//Si se produce un error al leer la clave, la variable error se hace 1 y se alerta al usuario
		              System.out.println ("//////////////////////////////////////////////////////");
		              System.out.println ("//  Se ha Producido un error                        //");
		              } 
		              	
//Se valida que la clave no este en blanco		              	
		              	
		           if(clave.equals("")){//Se usa equals para comparar directamente la clave con vacio
		           
		           	error=1;//Si la clave estaba en blanco, la variable error se hace 1 y se alerta al usuario
		           	System.out.println ("//////////////////////////////////////////////////////");
		           	System.out.println ("//  Debe introducir una clave                       //");
		           }   	
                  }while(error==1);//Si la variable error es 1, se repetira la solicitud de la clave  	
	
//Se asigna a una variable entero la longitud del texto y la clave	
	              	
           	     longitudClave=clave.length();
		         longitudTexto=texto.length();
		         
/*Las variables "Codificado", "i" y "j" se declaran vacias y cero
 para evitar que tenga algun dato de una codificacion previa*/
 		         
		         Codificado="";
		         i=0;
		         j=0;
		       
//Se hace un "Para" que durara hasta que i sea menor que la longitud del texto
		         
		         for(i=0; i<longitudTexto; i++){
		        
/*Las siguientes variables se hacen cero al empezar cada ciclo del "Para", para
 evitar que posean valores de otros ciclos*/
 		        	
		        	 minuscula=0;		        
		        	 diferente=0;

/*Se toma cada caracter por separado con substring y se usa compareTo para compararlo		        	 
con la letra "A", y luego ese valor se le saca el negativo para hacerlo positivo (0="A", 25="Z")*/
		        	 
		             textoCod=texto.substring(i,i+1);
		             n=A.compareTo(textoCod); //"A" es una variable string que equivale a "A"
		             n=-n;

/*Si el "n" que se obtuvo con el compareTo es mayor que 31 y menor que 58
 entonces el caracter es una letra minuscula (32="a", 57="z") */
 		             
		             if(n>31 && n<58){

/* Al ser una letra minuscula se compara cara caracter con la letra "a" y se coloca negativo
 para hacer el valor positivo, y la variable minuscula se hace 1*/
 		             	
		                n=a.compareTo(textoCod);//"a" es una variable string que equivale a "a"
		                n=-n;
		                minuscula=1;
		             }else{
		             	
/*Si en cambio, "n" es menor que cero o mayor que 25 y menor que 32 o mayor que 57, entonces el caracter
 no forma parte del alfabeto que estamos usando para codificar y la variable "diferente" se hace 1
 para alertar posteriormente que no es un caracter que interesa codificar*/
 		             	
		             	if(n<0 || (n>25 && n<32) || (n>57)){
		             	diferente=1;	
		             	}
		             }

/*Se hace el mismo procedimiento anterior con la clave, en este caso se usa "j" en el substring
para hacerlo independiente del i del "Para"
		             
Se toma cada caracter por separado con substring y se usa compareTo para compararlo		        	 
con la letra "A", y luego ese valor se le saca el negativo para hacerlo positivo (0="A", 25="Z")*/
		             
		             claveCod=clave.substring(j,j+1);
		             k=A.compareTo(claveCod);//"A" es una variable string que equivale a "A"
		             k=-k;
		          
/*Si el "k" que se obtuvo con el compareTo es mayor que 31 y menor que 58
 entonces el caracter es una letra minuscula (32="a", 57="z") */
 		             
		             if(k>31 && k<58){
		             	
/* Al ser una letra minuscula se compara cara caracter con la letra "a" y se coloca negativo
 para hacer el valor positivo, y la variable minuscula se hace 1*/		             	
		             	
		              k=a.compareTo(claveCod);//"a" es una variable string que equivale a "a"
		              k=-k;		              		
		             }else{
		             	
/*Si en cambio, "k" es menor que cero o mayor que 25 y menor que 32 o mayor que 57, entonces el caracter
 no forma parte del alfabeto que estamos usando para codificar y la variable "diferente" se hace 1
 para alertar posteriormente que no es un caracter que interesa codificar*/	
 		             	
		             	if(k<0 || (k>25 && k<32) || (k>57)){
		             	diferente=1;	
		             	}
		             }

//Si "k" es mayor que "n" entonces se le suma 26
		             
		             if (k>n){
		             	
		             	n=n+26;
		             }

//Ahora se restan los valores para obtener una decodificacion parcial
		             
		             l=n-k;
		             
		             if (l>=26){//Si l es mayor que 26, entonces se le resta 26 para que el resultado este entre 0 y 25
		             	
		             	l=l-26;
		             }
		             
		             if(minuscula==0){//Si el texto era en mayuscula, se le suma 65 para obtener si equivalente en el codigo ascii
		           	     
		           	    l=l+65; 	
		           	    	
		             }else{//Si el texto era en minuscula, se le suma 97 para obtener si equivalente en el codigo ascii          		
		             		
		              l=l+97;
		           	     
		           	   }
//Ahora se empieza a ver como se imprimiran los caracteres
		           		 	
/*Si se tenia la variable "diferente" igual a 1, entonces ese caracter no se va a decodificar
 y se concadena el caracter a la variable "Codificado"*/		           	  
		           		 	
		           if(diferente==1){
		         	
		             Codificado=Codificado+textoCod;	
		             	
		          }else{//Si "diferente" no era igual a 1, entonces se concadena el caracter decodificado a la variable "Codificado"
		         
		              f=(char)l;//se le asigna a la variable de tipo char "f" el equivalente en caracter del entero "l"
		              Codificado=Codificado+f;  
		          }
		          
		            j=j+1;//Al acabarse el ciclo, se aumenta la variale "j" en 1
		         
		             if(j>=longitudClave){//Si j llega a ser mayor o igual que la longitud de la clave, entonces se hace cero para que empieze otra vez
		             	
		               j=0;	
		             }
		          
		        }//Fin del "Para"
	
//Fuera del "Para" se imprime todo lo que se concadeno a "Codificado"
		        
		        System.out.println ("//////////////////////////////////////////////////////");
		        System.out.println ("//  El texto Decodificado es                        //");
		        System.out.println ("//////////////////////////////////////////////////////");
                System.out.println ("//  "+Codificado); 		 	
		        System.out.println ("//////////////////////////////////////////////////////");break; 
		                		                		                	
//Opcion 4, Salir del programa
           	      	
         case 4 : System.out.println ("//////////////////////////////////////////////////////");
         	      System.out.println ("//  Usted ha salido del programa, bye bye (:        //");
                  System.out.println ("//////////////////////////////////////////////////////");break;
                  
//Validacion de la opcion
           	      
        default : System.out.println ("//////////////////////////////////////////////////////"); 
         	      System.out.println ("//  Error, verifique los datos suministrados        //");break;
             	  }	    
  
//Muestra mensaje para repetir el programa si no se ha elegido la opcion 4 de salir
             	  	       
    if (opcion !=4){
        
    	System.out.println ("//  Presione la tecla 'Enter' para continuar        //");
    	System.out.println ("//////////////////////////////////////////////////////");
    	
//Lee cualquier tecla introducida por el usuario para empezar el programa denuevo    	 

    	    try{
		     BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		     salidaprograma=bf.readLine	();
	   }catch(Exception E){ }      
                   }
    
//Se repite todo el programa si la opcion no es la de salida    

    }while (opcion != 4);
        	     	
  	}
    }
    	
   

