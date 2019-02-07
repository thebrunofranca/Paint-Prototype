/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.*;
import java.util.*;

public class Ponto extends Figura
{
    private int x,  y;

    public Ponto (int x, int y)
    {
        super ();

  	this.x = x;
        this.y = y;
    }
	  
    public Ponto (int x, int y, Color cor)
    {
        super (cor);

        this.x = x;
        this.y = y;
    }

    public Ponto (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        this.x = Integer.parseInt(quebrador.nextToken());
        this.y = Integer.parseInt(quebrador.nextToken());

        this.cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                              Integer.parseInt(quebrador.nextToken()),  // G
                              Integer.parseInt(quebrador.nextToken())); // B
    }

    public void setX (int x)
    {
        this.x = x;
    }
	  
    public void setY (int y)
    {
        this.y = y;
    }
	  
    public int getX ()
    {
        return this.x;
    }
	  
    public int getY ()
    {
  	return this.y;
    }
	  
    public void torneSeVisivel (Graphics g)
    {
  	g.setColor (this.cor);
  	g.drawLine (this.x,this.y,this.x,this.y);
    }

    public String toString()
    {
        return "p:" +
               this.x +
               ":" +
               this.y +
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
        resultado = 13*resultado + this.x;
        resultado = 13*resultado + this.y;
        
        return resultado;
    }
     
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj instanceof Ponto){
            Ponto parametro = (Ponto)obj;
            if(parametro.cor.equals(this.cor)){
                return false;
            }
            if(parametro.x != this.x){
                return false;
            }
            if(parametro.y != this.y){
                return false;
            }
            return true;
        }
        if(obj instanceof String){
           String Parametro = (String)obj;
           String str;
           StringTokenizer quebra = new StringTokenizer(Parametro,":");
           if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str = quebra.nextToken();
            }
            if(!str.equals("p")){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str = quebra.nextToken();
            }
            if(!str.equals(Integer.toString(this.x))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str = quebra.nextToken();
            }
            if(!str.equals(Integer.toString(this.y))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str = quebra.nextToken();
            }
            if(!str.equals(Integer.toString(this.getCor().getRed()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str = quebra.nextToken();
            }
            if(!str.equals(Integer.toString(this.getCor().getGreen()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str = quebra.nextToken();
            }
            if(!str.equals(Integer.toString(this.getCor().getBlue()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str = quebra.nextToken();
            }
            return true;
        }
        return false;
    }
    
    public Ponto(Ponto Modelo)throws NullPointerException{
        if(Modelo == null){
            throw new NullPointerException();
        }else{
            this.cor = Modelo.cor;
            this.x = Modelo.x;
            this.y = Modelo.y;
        }
    }
    
    public Object Clone()throws NullPointerException{
        return new Ponto(this);
    }
}