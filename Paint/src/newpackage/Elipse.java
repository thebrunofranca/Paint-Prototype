/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.*;
import java.util.*;

public class Elipse extends Figura
{
    protected Ponto centro;

    protected int raio1, raio2;
	
    protected Color fundo=Color.LIGHT_GRAY;
    
    public Elipse (int x, int y, int r1, int r2)
    {
        super ();

        this.centro = new Ponto (x,y);

        this.raio1  = r1;
        this.raio2  = r2;
    }
	
    public Elipse (int x, int y, int r1, int r2, Color cor,Color cor2)
    {
        super (cor);

        this.centro = new Ponto (x,y);
        this.fundo = cor2;
        this.raio1  = r1;
        this.raio2  = r2;
    }

    public Elipse (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   r1  = Integer.parseInt(quebrador.nextToken());
        int   r2  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

        this.centro = new Ponto (x,y,cor);
        this.raio1  = r1;
        this.raio2  = r2;
        this.cor    = cor;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setRaio1 (int r1)
    {
        this.raio1 = r1;
    }

    public void setRaio2 (int r2)
    {
        this.raio2 = r2;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int setRaio1 ()
    {
        return this.raio1;
    }

    public int setRaio2 ()
    {
        return this.raio2;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor (this.cor);
        g.drawOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(fundo);
		g2d.fillOval(this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);	
    }

    public String toString()
    {
        return "e:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raio1 +
               ":" +
               this.raio2 +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue()+
                ":" +
                this.fundo.getRed() +
                   ":" +
               this.fundo.getGreen() +
                    ":" +
             this.fundo.getBlue();
    }
    public int hashCode(){
        int resultado = 7;
        resultado = 13*resultado + this.centro.hashCode();
        resultado = 13*resultado + this.cor.hashCode();
        resultado = 13*resultado + this.raio1;
        resultado = 13*resultado + this.raio2;
        resultado = 13*resultado + this.fundo.hashCode();
        return resultado;
    }
    
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj instanceof Elipse){
        Elipse parametro = (Elipse)obj;
        if(!parametro.cor.equals(this.cor)){
            return false;
        }
        if(parametro.centro.getX() != this.centro.getX()){
            return false;
        }
        if(parametro.centro.getY() != this.centro.getY()){
            return false;
        }
        if(parametro.raio1 != this.raio1){
            return false;
        }
        if(parametro.raio2 != this.raio2){
            return false;
        }
        if(!parametro.fundo.equals(this.fundo)){
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
            if(!str2.equals("c")){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.centro.getX()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.centro.getY()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.raio1))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.raio2))){
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
            if(!str2.equals(Integer.toString(this.fundo.getRed()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.fundo.getGreen()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.fundo.getBlue()))){
                return false;
            }else if(quebra.hasMoreTokens()){
                return false;
            }
            return true;
        }
        return false;
    }
    
    public Object Clone()throws NullPointerException{
        return new Elipse(this);
    }
    
    public Elipse(Elipse Modelo)throws NullPointerException{
        if(Modelo == null){
            throw new NullPointerException();
        }else{
            this.centro = new Ponto(Modelo.centro.getX(),Modelo.centro.getY());
            this.cor = Modelo.cor;
            this.raio1 = Modelo.raio1;
            this.raio2 = Modelo.raio2;
            this.fundo = Modelo.fundo;
        }
        
    }
}