/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**


 * @author u14280
 */
import java.awt.*;
import java.util.*;

public class Retangulo  extends Figura {
    
    protected Ponto p1, p2, p3, p4;
  

    protected Color fundo = Color.LIGHT_GRAY;
    
public Retangulo (Ponto p1, Ponto p2) {
     
       super ();

       this.p1 = new Ponto(Math.min(p1.getX(),p2.getX()),Math.min(p1.getY(),p2.getY()));
       this.p2 = new Ponto(Math.max(p1.getX(),p2.getX()),Math.min(p1.getY(),p2.getY()));
       this.p3 = new Ponto(Math.max(p1.getX(),p2.getX()),Math.max(p1.getY(),p2.getY()));
       this.p4 = new Ponto(Math.min(p1.getX(),p2.getX()),Math.max(p1.getY(),p2.getY()));
       
    }

    public Retangulo (Ponto p1, Ponto p2, Color cor,Color cor2) {
     
       super (cor);
       this.fundo = cor2;
        
       this.p1 = new Ponto(Math.min(p1.getX(),p2.getX()),Math.min(p1.getY(),p2.getY()));
       this.p2 = new Ponto(Math.max(p1.getX(),p2.getX()),Math.min(p1.getY(),p2.getY()));
       this.p3 = new Ponto(Math.max(p1.getX(),p2.getX()),Math.max(p1.getY(),p2.getY()));
       this.p4 = new Ponto(Math.min(p1.getX(),p2.getX()),Math.max(p1.getY(),p2.getY()));
       
    }
    
    public Retangulo (String s){
        
       StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x1   = Integer.parseInt(quebrador.nextToken());
        int   y1   = Integer.parseInt(quebrador.nextToken());
        int   x2   = Integer.parseInt(quebrador.nextToken());
        int   y2   = Integer.parseInt(quebrador.nextToken());
        int   x3   = Integer.parseInt(quebrador.nextToken());
        int   y3   = Integer.parseInt(quebrador.nextToken());
        int   x4   = Integer.parseInt(quebrador.nextToken());
        int   y4   = Integer.parseInt(quebrador.nextToken());

       

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        Color cor2 = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                				Integer.parseInt(quebrador.nextToken()),  // G
                				Integer.parseInt(quebrador.nextToken())); // B
        
        this.fundo = cor2;
        this.p1 = new Ponto (x1,y1,cor);
        this.p2 = new Ponto (x2,y2,cor);
        this.p3 = new Ponto (x3,y3,cor);
        this.p4 = new Ponto (x4,y4,cor);
       this.cor    = cor;
    }


         
    public void torneSeVisivel (Graphics g)
    {
        int base = p2.getX() -p1.getX();
        int altura = p3.getY() - p2.getY();
        g.setColor (this.cor);
        g.drawRect(p1.getX(),p1.getY(),base, altura);
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(fundo);   
          g2d.fillRect(p1.getX()+1,p1.getY()+1,base-1, altura-1);
    }
    
    
    
     public String toString()
    {
        return "retan:" +
               this.p1.getX() +
               ":" +
               this.p1.getY() +
               ":" +
                this.p2.getX() +
               ":" +
               this.p2.getY() +
               ":" +
                this.p3.getX() +
               ":" +
               this.p3.getY() +
               ":" +
                this.p4.getX() +
               ":" +
               this.p4.getY() +
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
        resultado = 13*resultado+this.p1.hashCode();
        resultado = 13*resultado+this.p2.hashCode();
        resultado = 13*resultado+this.p3.hashCode();
       resultado = 13*resultado+this.p4.hashCode();
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
        if(obj instanceof Quadrado){
           Quadrado parametro = (Quadrado)obj;
            if(this.p1.getX() != parametro.p1.getX()){
                return false;
            }
            if(this.p1.getY() != parametro.p1.getY()){
                return false;
            }
           
            if(this.p2.getX() != parametro.p2.getX()){
                return false;
            }
            if(this.p2.getY() != parametro.p2.getY()){
                return false;
            }
              if(this.p3.getX() != parametro.p3.getX()){
                return false;
            }
            if(this.p3.getY() != parametro.p3.getY()){
                return false;
            }
              if(this.p4.getX() != parametro.p4.getX()){
                return false;
            }
            if(this.p4.getY() != parametro.p4.getY()){
                return false;
            }
            if(!parametro.cor.equals(this.cor)){
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
            if(!str2.equals("retan")){
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
            
            if(!str2.equals(Integer.toString(this.p2.getX()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
            if(!str2.equals(Integer.toString(this.p3.getY()))){
                return false;
            }else if(!quebra.hasMoreTokens()){
                return false;
            }else{
                str2 = quebra.nextToken();
            }
           if(!str2.equals(Integer.toString(this.p4.getX()))){
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
        return new Retangulo(this);
    }
    
    public Retangulo( Retangulo obj) throws NullPointerException{
        if(obj != null){
        this.p1 = new Ponto(obj.p1.getX(),obj.p1.getY());
        this.p2 = new Ponto(obj.p2.getX(),obj.p2.getY());
        this.p3 = new Ponto(obj.p3.getX(),obj.p3.getY());
        this.p4 = new Ponto(obj.p4.getX(),obj.p4.getY());
        this.cor = obj.cor;
        this.fundo = obj.fundo;
        }else{
        throw new NullPointerException();
        }
    }
    
}
