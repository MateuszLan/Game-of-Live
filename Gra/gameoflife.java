package gameoflife;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/*
    @author Mateusz Langaj
            Jakub Kapituła
*/

public class gameoflife {
    public static char czyzywa(char Tablica[][], int i, int j, int zywisasiedzi) {
        if (Tablica[i][j] == '*') {
            if (zywisasiedzi == 2 || zywisasiedzi == 3)
                return '*';
            else return '.';
        }
        else {
            if (zywisasiedzi == 3)
                return '*';
            else return '.';
        }
    }
    public static void main(String[] args) {
        long millisActualTime = System.currentTimeMillis();
     Random gen = new Random();
     //Główne zmienne
//        final int wielkosc_tab = 100; //plansza kwadratowa
        final int kol = 20; //liczba komórek w kolumnie 
        final int wiersze = 47; //liczba komórek w wierszu
        final int powtorzenia = 10; //liczba wykonań pętli    
        char [][] Tablica=new char[kol][wiersze];
        char Kopia1[][]=new char[kol][wiersze];
        for (int i = 0; i < Tablica.length; i++) {
            for (int j = 0; j < Tablica[i].length; j++) {
                boolean bol=gen.nextBoolean();
                if(bol){
                    Tablica[i][j] = '*';
                }
                else{
                    Tablica[i][j]= '.';
                }
            }
        }
        final AtomicInteger p = new AtomicInteger(0);
        final AtomicInteger p1 = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            while(p.intValue()<=powtorzenia){
//                System.out.println("Zaczynamy: "+p);
                String Plansza="";
                for (int i = 0; i < Tablica.length; i++) {
                    for (int j = 0; j < Tablica[i].length; j++) {
                        Plansza+=Tablica[i][j];
                        if (j==Tablica[i].length-1) Plansza+="\n";
                    }
                }
            Plansza+="\n";
            Plansza+="\n";
            Plansza+="\n";
            Plansza+="\n";
            Plansza+="\n";
//            System.out.println("Plansza nr:"+p);
            System.out.println(Plansza);
p1.getAndIncrement();
if(p1.intValue()>powtorzenia)
        break;
while(p.intValue()!=p1.intValue()){
//    System.out.println(p+" "+ p1);
}
            }    
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            while(p.intValue()<=powtorzenia){
                for (int i = 0; i < Tablica.length; i++) {
                    for (int j = 0; j < Tablica[i].length; j++) {
                        int zywisasiedzi=0;
                        if(i==0){
                            if(j==0){
                                if(Tablica[i+1][j] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j+1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i][j+1] == '*')
                                    zywisasiedzi++;
                                Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi);    
                            }
                            else if(j==Tablica[i].length-1){
                                if(Tablica[i][j-1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j-1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j] == '*')
                                    zywisasiedzi++;
                                Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi);  
                            }
                            else{
                                if(Tablica[i][j-1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j-1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j+1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i][j+1] == '*')
                                    zywisasiedzi++;
                                Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi);
                            }
                        }
                        else if(j==0){
                            if (i==Tablica.length-1){
                                if(Tablica[i-1][j] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i-1][j+1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i][j+1] == '*')
                                    zywisasiedzi++;
                                Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi);  
                            }
                            else{
                                if(Tablica[i-1][j] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i-1][j+1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i][j+1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j+1] == '*')
                                    zywisasiedzi++;
                                Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi);  
                            }
                        }
                        else if (j==Tablica[i].length-1){
                            if(i==Tablica.length-1){
                                if(Tablica[i-1][j] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i-1][j-1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i][j-1] == '*')
                                    zywisasiedzi++;
                                Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi); 
                            }
                            else{
                                if(Tablica[i-1][j] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i-1][j-1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i][j-1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j-1] == '*')
                                    zywisasiedzi++;
                                if(Tablica[i+1][j] == '*')
                                    zywisasiedzi++;
                                Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi);  
                            }
                        }
                        else if(i==Tablica.length-1){
                            if(Tablica[i][j-1] == '*')
                                zywisasiedzi++;
                            if(Tablica[i-1][j-1] == '*')
                                zywisasiedzi++;
                            if(Tablica[i-1][j] == '*')
                                zywisasiedzi++;
                            if(Tablica[i-1][j+1] == '*')
                                zywisasiedzi++;
                            if(Tablica[i][j+1] == '*')
                                zywisasiedzi++;
                            Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi);  
                        }
                        else {
                            if(Tablica[i-1][j-1] == '*')
                                zywisasiedzi++;
                            if(Tablica[i][j-1] == '*')
                                zywisasiedzi++;
                            if(Tablica[i+1][j-1] == '*')
                                zywisasiedzi++;
                            if(Tablica[i-1][j] == '*')
                                zywisasiedzi++;
                            if(Tablica[i+1][j] == '*')
                                zywisasiedzi++;
                            if(Tablica[i-1][j+1] == '*')
                                zywisasiedzi++;
                            if(Tablica[i][j+1] == '*')
                                zywisasiedzi++;
                            if(Tablica[i+1][j+1] == '*')
                                zywisasiedzi++;
                            Kopia1[i][j]=czyzywa(Tablica, i, j, zywisasiedzi);  
                        }        
                    }
                }
                while(p1.intValue()!=p.intValue()+1)
                {       
                }
                if(p1.intValue()>powtorzenia)
                    break;
//                System.out.println("Aktualizacja: "+p);
                for (int i = 0; i < Tablica.length; i++) {
                    for (int j = 0; j < Tablica[i].length; j++) {
                        Tablica[i][j]=Kopia1[i][j];
                    }
                }
//                System.out.println("koniec t2: "+p);
                p.getAndIncrement();
            }
        });
        t2.start();
        while(t1.isAlive() && t2.isAlive()){
        }
        long executionTime = System.currentTimeMillis() - millisActualTime;
            System.out.println("Program trwał: "+executionTime+"ms");
    }
}
