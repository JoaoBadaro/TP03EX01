package trabalhopratico03;
import java.util.Scanner;

/*
Exercício 01
Crie a classe Hora conforme especificado

Jefferson Nacimento
João Pedro Badaro
 */

public class Hora {
    private int hora = -1;
    private int min = -1;
    private int seg = -1;
    Scanner ler = new Scanner(System.in);
    
    public Hora()
    {  
        setHor();
        setMin();
        setSeg();
    }
    
    public Hora(int h, int m, int s)
    {
        hora = h;
        min = m;
        seg = s;
    }
    
    public void setHor(int h)
    {
        hora = h;
    }
    public void setMin(int m)
    {
        min = m;
    }
    public void setSeg(int s)
    {
        seg = s;
    }
    
    public void setHor()
    {
        int h = -1;
        
        do
        {
            System.out.println("Digite a hora: ");
            
            if(ler.hasNextInt())
            {
                h = ler.nextInt();
        
                if(h<0 || h>23)
                    System.out.println("A hora digitada está incorreta. Tente novamente.");    
            }
            else
            {
                System.out.println("Entrada inválida! Digite um número.");
                ler.next();
            }
        }
        while(h<0 || h>23);
        
        hora = h;
    }
    public void setMin()
    {
        int m = -1;
        
        do
        {
            System.out.println("Digite o minuto: ");
            
            if(ler.hasNextInt())
            {
                m = ler.nextInt();
        
                if(m<0 || m>59)
                    System.out.println("O minuto digitado está incorreto. Tente novamente.");
            }
            else
            {
                System.out.println("Entrada inválida! Digite um número.");
                ler.next();
            }
        }
        while(m<0 || m>59);
        
        min = m;
    
    }
    public void setSeg()
    {
        int s = -1;
    
        do
        {
            System.out.println("Digite o segundo: ");
            
            if(ler.hasNextInt())
            {
                s = ler.nextInt();
        
                if(s<0 || s>59)
                    System.out.println("O segundo digitado está incorreto. Tente novamente.");
            }
            else
            {
                System.out.println("Entrada inválida! Digite um número.");
                ler.next();
            }
        }
        while(s<0 || s>59);
        
        seg = s;
    }
    
    public int getHor()
    {
        return hora;
    }
    public int getMin()
    {
        return min;
    }
    public int getSeg()
    {
        return seg;
    }
    
    public String getHora1()
    {
        if(hora == -1 && min == -1 && seg == -1)
        {
            System.out.print("Atributos não preenchidos!");
            return "";
        }
        else
        {
            String hora1 = String.format("%02d:%02d:%02d", hora, min, seg);
            return hora1;
        }
    }
    public String getHora2()
    {
        if(hora == -1 && min == -1 && seg == -1)
        {
            System.out.print("Atributos não preenchidos!");
            return "";
        }
        else
        {
            String hora2;
            if(hora < 12)
            {
                hora2 = String.format("%02d:%02d:%02d (AM)", hora, min, seg);
            }
            else
            {
                int horaFormatada = (hora%12 == 0) ? 12 : hora%12;
                hora2 = String.format("%02d:%02d:%02d (PM)", horaFormatada, min, seg);
            }
            return hora2;
        }
    }
    
    public int getSegundos()
    {
        int totalSeg = hora*3600 + min*60 + seg;
        return totalSeg;
    }
}