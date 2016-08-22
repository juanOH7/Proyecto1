package edpro1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class EDPro1 {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("final.csv"));
        StringBuilder sb = new StringBuilder();
        TDALista list = new VSArray(4);
        boolean running = true, contin = true;
        int resp,cont,result;
        String resp2;
        Random generator = new Random();
        File arc = new File("alumnos.txt");
        Scanner sc = new Scanner(arc);
        Scanner sc2 = new Scanner(System.in);
        while (sc.hasNextLine()) {       
            String comp = sc.nextLine();
            String divCom[] = comp.split(",");
            Person tmp = new Person(Integer.parseInt(divCom[0]), divCom[1], divCom[2]);
            list.insert(tmp, 0);
        }
        TDALista listRes = new VSArray(list.getSize());
        TDALista conteo = new VSArray(list.getSize());
        for (int i = 0; i < list.getSize(); i++) {
            listRes.insert(0, i);
        }for (int i = 0; i < list.getSize(); i++) {
            conteo.insert(0, i);
        }
        while (running) {   
            System.out.println("1-Listar\n2-Preguntas\n3-Resultados\n4-Salir");
            
            resp = sc2.nextInt();
            if (resp == 1){
                for (int i = 0; i < list.getSize(); i++) {
                     System.out.print(((Person) list.get(i)).getCuenta()+",");
                     System.out.print(((Person) list.get(i)).getNombre()+",");
                     System.out.print(((Person) list.get(i)).getCarrera());
                     System.out.println("");
                }
            }else  if (resp == 2) {
                while (contin) {
                    int numPos = generator.nextInt(list.getSize());
                    result = (int)listRes.get(numPos);
                    int numCon =(int)conteo.get(numPos);
                    System.out.println("Alumno "+((Person) list.get(numPos)).getNombre());
                    System.out.print("Score: ");
                    result += sc2.nextInt();
                    numCon++;
                    listRes.set(result, numPos);
                    conteo.set(numCon, numPos);
                    System.out.println("Continuar [S/N]");
                    resp2 = sc2.next();
                    contin = (resp2.equals("S") || resp2.equals("s"));
                }
            }else if(resp == 3){
                for (int i = 0; i < listRes.getSize(); i++) {
                    System.out.print(listRes.get(i)+ ",");
                    System.out.print(conteo.get(i));
                    System.out.println("");
                }
            }else{
                int prom;
                for (int i = 0; i < list.size; i++) {
                    while (!((int)conteo.get(i) == 0)) {                        
                        prom = (int)listRes.get(i)/(int)conteo.get(i);
                        sb.append(prom);
                        sb.append(",");
                        sb.append(((Person)list.get(i)).getCuenta());
                        sb.append("\n");
                    }
                }
                pw.write(sb.toString());
                pw.close();
                running = false;
            }
        } 
    }
}
