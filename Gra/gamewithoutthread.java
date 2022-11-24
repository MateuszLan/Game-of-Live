package gameoflife;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/*
    @author Mateusz Langaj
            Jakub Kapituła
*/

public class gamewithoutthread {
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
        final int wielkosc_tab = 100; //plansza kwadratowa
        final int powtorzenia = 1100; //liczba wykonań pętli
     
        char [][] Tablica=new char[wielkosc_tab][wielkosc_tab];
        char Kopia1[][]=new char[wielkosc_tab][wielkosc_tab];
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
            
            while(p.intValue()<powtorzenia){
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
                            else if(j==wielkosc_tab-1){
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
                            if (i==wielkosc_tab-1){
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
                        else if (j==wielkosc_tab-1){
                            if(i==wielkosc_tab-1){
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
                        else if(i==wielkosc_tab-1){
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
                for (int i = 0; i < Tablica.length; i++) {
                    for (int j = 0; j < Tablica[i].length; j++) {
                        Tablica[i][j]=Kopia1[i][j];
                    }
                }
                p.getAndIncrement();
            }
            long executionTime = System.currentTimeMillis() - millisActualTime;
            System.out.println("Program trwał: "+executionTime+"ms");
    }
}