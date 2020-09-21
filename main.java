package NotacionPolaca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner pen=new Scanner(System.in);
		System.out.println("BIENVENIDO A LA NOTACION POLACA");
		System.out.println("[1]ARCHIVO CON LETRAS      [2] ARCHIVO CON NUMEROS");
		int decide = pen.nextInt();
		if(decide==1) {
			System.out.println("Ingresa la ruta del archivo ejemplo(C:\\Users\\DELL\\Desktop\\)");
			String leer = pen.next();
			System.out.println("Ingresa el nombre del archivo, ejemplo(input.txt)");
			String nombre = pen.next();
			File file =new File(leer+nombre);
			FileReader reader = new FileReader (file);  
			BufferedReader li = new BufferedReader(reader);
			
			String linea1 = li.readLine();
			Lista cola=new Lista();
			for(int i=0;i<linea1.length();i++) {
				char letra= linea1.charAt(i);
				cola.put(letra);
			}
			Lista resultado = resuelve(cola);
			resultado.recorre();
			
			
			reader.close();
		}else if(decide==2) {
			System.out.println("Ingresa la ruta del archivo ejemplo(C:\\Users\\DELL\\Desktop\\)");
			String leer = pen.next();
			System.out.println("Ingresa el nombre del archivo, ejemplo(input.txt)");
			String nombre = pen.next();
			File file =new File(leer+nombre);
			FileReader reader = new FileReader (file);  
			BufferedReader li2 = new BufferedReader(reader);
			
			String linea2 = li2.readLine();
			Lista cola=new Lista();
			for(int i=0;i<linea2.length();i++) {
				char letra= linea2.charAt(i);
				cola.put(letra);
			}
			Lista resultado2 = resuelve(cola);
			int cifra= numerosresu(resultado2);
			System.out.println("El resultado de tu notacion polaca es: "+cifra);
			reader.close();
		}
		System.out.println("La opcion elegida no es correcta vuelve a inicar el programa.");
		System.out.println("Gracias :)");
	}
	public static int numerosresu(Lista y) {
		int resultado=0;
		Lista auxn=y;
		Cola aux=auxn.inicio;
		while(auxn.largo()!=1) {
			
			Cola aux2=aux.sig;
			Cola aux3=aux2.sig;
		if((aux.dato!='('||aux.dato != ')'||aux.dato != '*'||aux.dato != '+'||aux.dato != '-'||aux.dato != '/'||aux.dato != '^')&&(aux2.dato!='('||aux2.dato != ')'||aux2.dato != '*'||aux2.dato != '+'||aux2.dato != '-'||aux2.dato != '/'||aux2.dato != '^')&&(aux3.dato== '('||aux3.dato == ')'||aux3.dato == '*'||aux3.dato == '+'||aux3.dato == '-'||aux3.dato == '/'||aux3.dato == '^')) {
			int op= operacion(Character.getNumericValue(aux.dato),Character.getNumericValue(aux2.dato),aux3.dato);
			aux3.dato=(char) op;
			if(aux.ant!=null) {
				aux3.ant=aux.ant;
			}else {
				aux3.ant=null;
			}
			aux=aux3;
			}
		
		}
		return resultado;
	}
	
	public static int operacion(int x, int y, char s) {
		if(s=='+') {
			return x+y;
		}else if(s=='-') {
			return x-y;
		}else if(s=='*') {
			return x*y;
		}else if(s=='/') {
			return x/y;
		}else if(s=='^') {
			return (int) Math.pow(x, y);
		}
		return 0;
	}
	
	public static Lista resuelve(Lista x) {
		Lista aux = x;
		ListaP pila= new ListaP();
		Lista regreso=new Lista();
		while(aux.fin!=null) {
			char temp=aux.fin.dato;
			boolean es= verifica(temp);
			if(es==true) {
				int jerar = jerarquia(temp);
				if(pila.isEmpty()==true) {
					pila.push(temp);
				}else {
					if(jerar==0) {
						char prov=pila.pop();
						int pro=jerarquia(prov);
						while(pro!=1){
							regreso.put(prov);
							if(pila.isEmpty()!=true) {
							prov=pila.pop();
							pro=jerarquia(prov);
							}else {
								pro=1;
							}
							}
						
						
					}else if(jerar==1) {
						pila.push(temp);
					}else {
					char tienepila = pila.pick();
					int cotr = jerarquia(tienepila);
					boolean comparajerarquia=verificajera(jerar,cotr);
					if(comparajerarquia==true|| cotr==1) {
						pila.push(temp);
					}else {
						
							char trans=pila.pop();
							if(trans=='('|| trans==')') {
								
							}else {
							regreso.put(trans);
							}
							
						pila.push(temp);
						}
					}
				}
			}else {
				regreso.put(temp);
			}
			aux.fin=aux.fin.ant;
		}
		if(pila.isEmpty()!=true) {
			while(pila.isEmpty()!=true) {
			char ultimo=pila.pop();
			if(ultimo=='('|| ultimo==')') {
				
			}else {
			
			regreso.put(ultimo);
			}
			}
		}
		return regreso;
		
	}
	public static boolean verifica(char x) {
		char caracter=x;
		if(caracter == '('||caracter == ')'||caracter == '*'||caracter == '+'||caracter == '-'||caracter == '/'||caracter == '^') {
			return true;
		}else
			return false;
	}
	public static int jerarquia(char car) {
		char caracter=car;
		
		if(caracter == '+'||caracter == '-') {
			return 2;
		}else if(caracter == '*'||caracter == '/') {
			return 3;
		}else if(caracter == '^') {
			return 4;
		}else if(caracter == '(') {
			return 1;
		}
		return 0;
	}
	public static boolean verificajera(int x, int y) {
		return x>y;
	}
}
