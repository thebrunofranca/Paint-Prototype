/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author u14280
 */
public class NoLista {
    //apontador para objeto generico que armazena no campo info do nó
    private Figura elemento;
    private NoLista prox;
    
   public NoLista(){
       this(null,null);
   }
   
   //construtor com parametros
   public NoLista(Figura info, NoLista proximo){
       elemento = info;
       prox = proximo;
   }
   
   protected Figura getElemento(){
       return elemento;
   }
   
   protected NoLista getProx(){
       return prox;
   }
   
   protected void setElemento(Figura info){
       elemento = info;
   }
   
   protected void setProx(NoLista novoProximo){
       prox = novoProximo;
   } 
}
