/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.*;
import java.util.*;

public class Circulo extends Figura
{
    protected Ponto centro;
    protected int   raio;
    protected Color fundo = Color.LIGHT_GRAY;

    public Circulo (int x, int y, int r)
    {
        super ();

        this.centro = new Ponto (x,y);
        this.raio   = r;
    }
	
    public Circulo (int x, int y, int r, Color cor,Color cor2)
    {
        super (cor);
        this.fundo = cor2;
        this.centro = new Ponto (x,y);
        this.raio   = r;
    }

    public Circulo (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   r   = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        Color cor2 = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                				Integer.parseInt(quebrador.nextToken()),  // G
                				Integer.parseInt(quebrador.nextToken())); // B
        
        this.fundo = cor2;
        this.centro = new Ponto (x,y,cor);
        this.raio   = r;
        this.cor    = cor;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setRaio (int r)
    {
        this.raio = r;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getRaio ()
    {
        return this.raio;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor (this.cor);
        g.drawOval (this.centro.getX()-raio, this.centro.getY()-raio, 2*raio, 2*raio);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(fundo);
		g2d.fillOval(this.centro.getX()-raio, this.centro.getY()-raio, 2*raio, 2*raio);
    }

    public String toString()
    {
        return "c:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raio +
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
        resultado = 13*resultado+this.cor.hashCode();
        resultado = 13*resultado+this.centro.hashCode();
        resultado = 13*resultado+this.raio;
        resultado = 13*resultado+this.fundo.hashCode();
        return resultado;
    }
    
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj instanceof Circulo){
            Circulo parametro = (Circulo)obj;
            if(this.centro.getX() != parametro.centro.getX()){
                return false;
            }
            if(this.centro.getY() != parametro.centro.getY()){
                return false;
            }
            if(!parametro.cor.equals(this.cor)){
                return false;
            }
            if(this.raio != parametro.raio){
                return false;
            }
            if(!parametro.fundo.equals(this.cor)){
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
            if(!str2.equals(Integer.toString(this.raio))){
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
            if(! str2.equals(Integer.toString(this.getCor().getBlue()))){
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
            if(! str2.equals(Integer.toString(this.fundo.getBlue()))){
                return false;
            }else if(quebra.hasMoreTokens()){
                return false;
            }
            return true;
        }
        return false;
    }
    
    public Object Clone()throws NullPointerException{
        return new Circulo(this);
    }
    
    public Circulo(Circulo obj) throws NullPointerException{
        if(obj != null){
        this.centro = new Ponto(obj.centro.getX(),obj.centro.getY());
        this.raio = obj.raio;
        this.cor = obj.cor;
        this.fundo = obj.fundo;
        }else{
        throw new NullPointerException();
        }
    }
}