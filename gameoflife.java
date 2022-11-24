import java.util.Random;

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
    static void wait(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
     Random gen = new Random();
        char [][] Tablica=new char[10][10];
        char Kopia1[][]=new char[10][10];
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

        Thread t1 = new Thread(() -> {
            for(int p1=0;p1<11;p1++) {
                System.out.println("Zaczynamy: "+p1);
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
            System.out.println("Plansza nr:"+p1);
            System.out.println(Plansza);
            wait(1000);
            }    
        });

        t1.start();
        Thread t2 = new Thread(() -> {
            for(int p=0;p<11;p++){
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
                            else if(j==9){
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
                            if (i==9){
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
                        else if (j==9){
                            if(i==9){
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
                        else if(i==9){
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
                wait(135);
                for (int i = 0; i < Tablica.length; i++) {
                    for (int j = 0; j < Tablica[i].length; j++) {
                        Tablica[i][j]=Kopia1[i][j];
                    }
                }
                System.out.println("zaaktualizowano: "+p);
                wait(850);
                System.out.println("koniec t2: "+p);
            }
        });
        t2.start();
    }
}