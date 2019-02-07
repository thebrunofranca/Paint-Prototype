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
public class ListaSimples {
    
    private NoLista primeiro,ultimo, aux, anterior;
    private int tamanho;
    
    
    public ListaSimples(){
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }
    
    protected NoLista getPrimeiro(){
        return primeiro;
    }
    
    protected NoLista getUltimo(){
        return ultimo;
    }
    
    protected void setPrimeiro(NoLista p){
        primeiro = p;
    }
    
    protected void setUltimo(NoLista p){
        ultimo = p;
    }
    
    protected boolean estaVazia(){
        return (primeiro == null);
    }
    
    protected int getTamanho(){
        return tamanho;
    }
    
    protected void insereNo(NoLista p){
    	
        if(tamanho == 0){
        	
        	primeiro = p;
            ultimo = p;            
        } else if (tamanho > 0) {
        	
        	ultimo.setProx(p);
        	ultimo = p; 	
        }
        tamanho++;
    }
    
    protected void percorreLista(){
        NoLista atual = primeiro;
        while (atual != null){
            
            atual = atual.getProx();
        }
    }
    
    protected void removeUltimo(){
    	aux = primeiro;
    	anterior = null;
    	if (tamanho == 1) {
    		
    		primeiro = null;
    		ultimo = null;
    		tamanho = 0;
    	} else if (tamanho > 1) {
	    	while(true){
	    		if (aux == ultimo){
	    			
	    			anterior.setProx(null);	    			
	    			ultimo = anterior;	    			
	    			tamanho--;
	    			break;
	    		} else {
	    			
	    			anterior = aux;
	    			aux = aux.getProx();
	    		}
	    	}
      }
    }
    
    protected void removeTodosNos(){
    	primeiro = null;
        ultimo = null;
        tamanho = 0;
    }
    
}








