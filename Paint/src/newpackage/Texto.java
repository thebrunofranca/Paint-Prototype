/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.StringTokenizer;

/**
 *
 * @author u14280
 */
public class Texto extends Figura {
          protected Ponto p1;
          protected Font fonte; 
          protected String caixinha;
  
    public Texto (Ponto p1,Font f,String cx,Color c) {
         super ();
         this.p1 = new Ponto(p1);
         this.fonte = f;
         this.caixinha = cx; 
         this.cor = c;
    }
    
    
 public void torneSeVisivel (Graphics g) {
     g.setFont(fonte);
     g.setColor(this.cor);
     g.drawString(this.caixinha, p1.getX(), p1.getY());     
 }
 
 public Texto (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();
        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());
        Font fonte = new Font (quebrador.nextToken(), Integer.parseInt(quebrador.nextToken()), Integer.parseInt(quebrador.nextToken()));
        String txt = quebrador.nextToken();
        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        
        
        this.fonte = fonte;
        this.p1 = new Ponto (x,y);
        this.caixinha = txt;
        this.cor = cor;
        
       
    } 
   
    @Override
    public String toString() {
        return "txt:" +
               this.p1.getX() +
               ":" +
               this.p1.getY() +
               ":"+
               this.fonte.getFamily()+
               ":" +
               this.fonte.getStyle()+
               ":" +
               this.fonte.getSize()+
               ":" + 
               this.caixinha +
               ":" + 
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }

        public int hashCode(){
        int resultado = 7;

        resultado = 13*resultado+this.p1.hashCode();
        resultado = 13*resultado+this.fonte.hashCode();
        resultado = 13*resultado+this.caixinha.hashCode();
        resultado = 13*resultado+this.cor.hashCode();

        return resultado;
    }
        
}
