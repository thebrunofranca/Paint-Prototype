/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.*;
import java.util.*;

public class Linha extends Figura
{
    protected Ponto p1, p2;
	
    public Linha (int x1, int y1, int x2, int y2)
    {
        super();

        this.p1 = new Ponto (x1,y1);
        this.p2 = new Ponto (x2,y2);
    }
	
    public Linha (int x1, int y1, int x2, int y2, Color cor)
    {    	
        super(cor);        

        this.p1 = new Ponto (x1,y1,cor);
        this.p2 = new Ponto (x2,y2,cor);
    }

    public Linha (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x1  = Integer.parseInt(quebrador.nextToken());
        int   y1  = Integer.parseInt(quebrador.nextToken());

        int   x2  = Integer.parseInt(quebrador.nextToken());
        int   y2  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

        this.p1  = new Ponto (x1,y1,cor);
        this.p2  = new Ponto (x2,y2,cor);
        this.cor = cor;
    }

    public void setP1 (int x, int y)
    {
        this.p1 = new Ponto (x,y,this.getCor());
    }

    public void setP2 (int x, int y)
    {
        this.p2 = new Ponto (x,y,this.getCor());
    }

    public Ponto getP1 ()
    {
        return this.p1;
    }

    public Ponto getP2 ()
    {
        return this.p2;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor(this.cor);
        g.drawLine(this.p1.getX(), this.p1.getY(),   // ponto inicial
                   this.p2.getX(), this.p2.getY());  // ponto final
    }

    public String toString()
    {
        return "r:" +
               this.p1.getX() +
               ":" +
               this.p1.getY() +
               ":" +
               this.p2.getX() +
               ":" +
               this.p2.getY() +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
    
    public int hashCode(){
        int resultado = 7;
        resultado = 13*resultado + this.cor.hashCode();
        resultado = 13*resultado + this.p1.hashCode();
        resultado = 13*resultado + this.p2.hashCode();
        
        return resultado;
    }
    
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj instanceof Linha){
        Linha parametro = (Linha)obj;
        if(!parametro.cor.equals(this.cor)){
            return false;
        }
        if(!parametro.p1.equals(this.p1)){
            return false;
        }
        if(!parametro.p2.equals(this.p2)){
            return false;
        }
        return true;
        }
        if(obj instanceof String){
            String str = (String)obj;
            String str2;
            StringTokenizer quebra = new StringTokenizer(str,":");
            if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals("r")){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.p1.getX()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.p1.getY()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.p2.getX()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.p2.getY()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.getCor().getRed()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.getCor().getGreen()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.getCor().getBlue()))){
                return false;
            }else if(quebra.hasMoreTokens()){
                return false;
            }
            return true;
        }
        return false;
    }
    
    public Linha(Linha Modelo)throws NullPointerException{
        if(Modelo == null){
            throw new NullPointerException();
        }else{
            this.cor = Modelo.cor;
            this.p1 = new Ponto(Modelo.p1);
            this.p2 = new Ponto(Modelo.p2);
        }
    }
    
    public Object Clone() throws NullPointerException{
        return new Linha(this);
    }
    
    
    
}