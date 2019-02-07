/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.*;

public abstract class Figura
{
    protected Color cor;
	  
    protected Figura ()
    {
        this.cor = Color.black;
    }
	  
    protected Figura (Color cor)
    {
        this.setCor (cor);
    }
	  
    protected void setCor (Color cor)
    {
        this.cor = cor;
    }
	  
    protected Color getCor()
    {
  	return this.cor;
    }

    public abstract String toString       ();	  
    public abstract void   torneSeVisivel (Graphics g);
   // public abstract int hashCode();
    //public abstract Object Clone();
    //public abstract boolean equals(Object obj);
}