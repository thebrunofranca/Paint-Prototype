/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.color.*;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Janela extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton btnPonto = new JButton("Ponto"),
            btnLinha = new JButton("Linha"),
            btnCirculo = new JButton("Circulo"),
            btnElipse = new JButton("Elipse"),
            btnCores = new JButton("Cores"),
            btnAbrir = new JButton("Abrir"),
            btnSalvar = new JButton("Salvar"),
            btnApagar = new JButton("Apagar"),
            btnSair = new JButton("Sair"),
            btnQuadrado = new JButton("Quadrado"),
            btnRetangulo = new JButton("Retangulo"),
            btnTexto = new JButton("Texto");

    private MeuJPanel pnlDesenho = new MeuJPanel();

    private JLabel statusBar1 = new JLabel("Mensagem:"),
            statusBar2 = new JLabel("Coordenada:");

    boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaInicioQuadrado, esperaFimQuadrado, esperaQuadrado;
    boolean esperaInicioCirculo, esperaFimCirculo; //booleans para criar o circulo
    boolean salvado, esperaInicioRetangulo, esperaFimRetangulo, esperaRetangulo;
    boolean esperaMeioElipse, esperaInicioElipse, esperaFimElipse, iniciotexto, fimtexto; //booleans da elipse

    private Color borda = Color.black;
    JTextField caixinha;
    private Color fundo = Color.LIGHT_GRAY;
    private Ponto p1;
    private Ponto p2;
    private Font Texto = new Font("SansSerif", Font.PLAIN, 10);
    //private Vector<Figura> figuras = new Vector<Figura>();
    
    //CRIA LISTA SIMPLES
    private ListaSimples l = new ListaSimples();
    //CRIA LISTA SIMPLES
    private NoLista aux = new NoLista();

    protected void zeraTudo() {
        esperaPonto = false;
        esperaInicioReta = false;
        esperaFimReta = false;
        esperaInicioQuadrado = false;
        esperaFimQuadrado = false;
        esperaQuadrado = false;
        esperaInicioCirculo = false;
        esperaFimCirculo = false; 
        esperaInicioRetangulo = false;
        esperaFimRetangulo = false;
        esperaRetangulo = false;
        esperaMeioElipse = false;
        esperaInicioElipse = false;
        esperaFimElipse = false;
        iniciotexto = false;
        fimtexto = false;
    }

    public Janela() {
        
        super("Editor Gráfico");

        try {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo ponto.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo linha.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo circulo.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo elipse.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCores.setIcon(new ImageIcon(btnCoresImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo cores.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo abrir.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo salvar.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo apagar.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo sair.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }
        try {
            Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.png"));
            btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo quadrado.png não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }
        try {
            Image btnRetanguloImg = ImageIO.read(getClass().getResource("resources/retangulo.png"));
            btnRetangulo.setIcon(new ImageIcon(btnRetanguloImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo quadrado.png não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnTextoImg = ImageIO.read(getClass().getResource("resources/texto.png"));
            btnTexto.setIcon(new ImageIcon(btnTextoImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo texto.png não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        btnPonto.addActionListener(new DesenhoDePonto());
        btnLinha.addActionListener(new DesenhoDeReta());
        btnCirculo.addActionListener(new DesenhoDeCirculo());
        btnElipse.addActionListener(new DesenhoDeElipse());
        btnAbrir.addActionListener(new AbrirFile());
        btnSalvar.addActionListener(new SalvarFile());
        btnCores.addActionListener(new pegacor());
        btnQuadrado.addActionListener(new DesenhoDeQuadrado());
        btnRetangulo.addActionListener(new DesenhoDeRetangulo());
        btnTexto.addActionListener(new FazTexto());

        JPanel pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout();
        pnlBotoes.setLayout(flwBotoes);

        pnlBotoes.add(btnAbrir);
        pnlBotoes.add(btnSalvar);
        pnlBotoes.add(btnPonto);
//        pnlBotoes.add(btnLinha);
//        pnlBotoes.add(btnCirculo);
//        pnlBotoes.add(btnElipse);
//        pnlBotoes.add(btnCores);
//        pnlBotoes.add(btnApagar);
//        pnlBotoes.add(btnSair);
//        pnlBotoes.add(btnQuadrado);
//        pnlBotoes.add(btnRetangulo);
//        pnlBotoes.add(btnTexto);

        JPanel pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1, 2);
        pnlStatus.setLayout(grdStatus);
        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);
        salvado = true;
        Container cntForm = this.getContentPane();
        cntForm.setLayout(new BorderLayout());
        cntForm.add(pnlBotoes, BorderLayout.NORTH);
        cntForm.add(pnlDesenho, BorderLayout.CENTER);
        cntForm.add(pnlStatus, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new FechamentoDeJanela());

        this.setSize(700, 500);
        this.setVisible(true);
    }

    private class MeuJPanel extends JPanel
            implements MouseListener,
            MouseMotionListener {

        private static final long serialVersionUID = 1L;

        public MeuJPanel() {
            super();

            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        public void paint(Graphics g) {
        	aux = l.getPrimeiro();
        	
        	if (!l.estaVazia()) {
	            while (aux.getProx() != null){
	                aux.getElemento().torneSeVisivel(g);
	                aux = aux.getProx();                
	            }
	            aux.getElemento().torneSeVisivel(g);
        	}
        }

        public void mousePressed(MouseEvent e) {
            if (esperaPonto) {
                salvado = false;
                
                l.insereNo(new NoLista(new Ponto(e.getX(), e.getY(), borda), null));
                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
            } 
            else if (esperaInicioReta) {
                salvado = false;
                aux = new NoLista(new Ponto(e.getX(), e.getY(), borda), null);
                esperaInicioReta = false;
                esperaFimReta = true;
                l.insereNo(aux);
                //figuras.add(new Ponto(p1));
                statusBar1.setText("Mensagem: clique o ponto final da reta");            
            } 
            else if (esperaInicioCirculo) {
                salvado = false;
                aux = new NoLista(new Ponto(e.getX(), e.getY(), borda), null);
                //figuras.add(p1);
                l.insereNo(aux);
                esperaInicioCirculo = false;
                esperaFimCirculo = true;
                statusBar1.setText("Mensagem: clique o ponto final do circulo");
            
            } 
            else if (esperaInicioElipse) {
                salvado = false;
                //p1 = new Ponto(e.getX(), e.getY(), borda);
                aux = new NoLista(new Ponto(e.getX(), e.getY(), borda), null);
                esperaInicioElipse = false;
                //figuras.add(p1);
                l.insereNo(aux);
                esperaFimElipse = true;
                statusBar1.setText("Mensagem: clique o raio de x do elipse");

            }

             else if (esperaInicioQuadrado) {
                salvado = false;
                //p1 = new Ponto(e.getX(), e.getY(), borda);
                aux = new NoLista(new Ponto(e.getX(), e.getY(), borda), null);

                esperaInicioQuadrado = false;
                //figuras.add(p1);
                l.insereNo(aux);
                esperaFimQuadrado = true;
                statusBar1.setText("Mensagem: clique o ponto final do quadrado");
            
            }
              else if (esperaInicioRetangulo) {
                        salvado = false;
                        aux = new NoLista(new Ponto(e.getX(), e.getY(), borda), null);
                        esperaInicioRetangulo = false;
                        l.insereNo(aux);
                        esperaFimRetangulo = true;
                        statusBar1.setText("Mensagem: clique o ponto final do retangulo");
                        
                    
                    } 
              
              else   
                  if (iniciotexto) {
                        caixinha = new JTextField(20);
                        caixinha.setFont(Texto);
                        aux = new NoLista(new Ponto(e.getX(), e.getY()), null);
                        caixinha.setBounds(e.getX(), e.getY(), 200, Texto.getSize());
                        add(caixinha);
                        setLayout(new BorderLayout());
                        iniciotexto = false;
                        fimtexto = true;
                    } else if (fimtexto) {
                        fimtexto = false;
                        String txt = caixinha.getText();
                        pnlDesenho.remove(caixinha);
                        setLayout(new BorderLayout());
                        pnlDesenho.getGraphics().clearRect(pnlDesenho.getX(), pnlDesenho.getY(), pnlDesenho.getWidth(), pnlDesenho.getHeight());
                        
                        aux = l.getPrimeiro();
                        
                        while (!l.estaVazia()){
                            aux.getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                            aux = aux.getProx();
                            if (aux.getProx() == null){
                            	break;
                            }
                        }
                        aux = new NoLista(new Texto(p1, Texto, txt, borda), null);
                        l.insereNo(aux);
                        l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());

                    }
        }
    
   

        public void mouseReleased(MouseEvent e) {
            if(esperaFimReta){
                esperaFimReta = false;
                esperaInicioReta = true;
            }
                else if(esperaFimCirculo){
           esperaFimCirculo = false;
                esperaInicioCirculo = true;
            }
               else if(esperaFimElipse){
           esperaFimElipse = false;
                esperaInicioElipse = true;
            }
           else if(esperaFimQuadrado){
           esperaFimQuadrado = false;
                esperaInicioQuadrado = true;
           }
            
            else if(esperaFimRetangulo){
           esperaFimRetangulo = false;
                esperaInicioRetangulo = true;
            }
            
      
        }
        
        public void mouseClicked(MouseEvent e) {
        }
  
        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
             if (esperaFimReta) {
                 esperaInicioReta = false;                 
                l.removeUltimo();
                //System.out.println(l.getUltimo().getElemento().toString() + " removeu");
                salvado = false;                
                l.insereNo(new NoLista(new Ponto(e.getX(), e.getY(), Color.black), null));
                BufferedImage print = new BufferedImage(pnlDesenho.getWidth(),pnlDesenho.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
                Graphics2D desenha = print.createGraphics();
                desenha.setColor(pnlDesenho.getBackground());
                desenha.fillRect(0,0,pnlDesenho.getWidth(),pnlDesenho.getHeight());
                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                repaint();
//                while (!l.estaVazia()){
//                    aux.getElemento().torneSeVisivel(pnlDesenho.getGraphics());
//                    aux = aux.getProx();
//                    if (aux.getProx() == null){
//                    	break;
//                    }
//                }
                desenha.dispose();
                Graphics2D desenhafinal = (Graphics2D)pnlDesenho.getGraphics();
                desenhafinal.drawImage(print, null, 0,0);
                desenhafinal.dispose();
                statusBar1.setText("Mensagem:");
                }
             
             
              if (esperaFimCirculo) {
                  
                l.removeUltimo();
                salvado = false;
                aux = new NoLista(new Circulo(p1.getX(), p1.getY(), ((int) Math.sqrt(Math.pow(e.getX() - p1.getX(), 2) + Math.pow(e.getY() - p1.getY(), 2))), borda, fundo), null);
                l.insereNo(aux);
                BufferedImage print = new BufferedImage(pnlDesenho.getWidth(),pnlDesenho.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
                Graphics2D desenha = print.createGraphics();
                desenha.setColor(pnlDesenho.getBackground());
                desenha.fillRect(0,0,pnlDesenho.getWidth(),pnlDesenho.getHeight());
                while (!l.estaVazia()){
                    aux.getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                    aux = aux.getProx();
                    if (aux.getProx() == null){
                    	break;
                    }
                }
                desenha.dispose();
                Graphics2D desenhafinal = (Graphics2D)pnlDesenho.getGraphics();
                desenhafinal.drawImage(print, null, 0,0);
                desenhafinal.dispose();
                statusBar1.setText("Mensagem:");
                }
              
                if(esperaFimElipse){
                   
                    l.removeUltimo();
                    salvado = false;
                    int x = Math.abs(p1.getX()-e.getX());
                    int y = Math.abs(p1.getY()-e.getY());
                    aux = new NoLista(new Elipse(p1.getX(), p1.getY(),x,y, borda, fundo), null);
                    l.insereNo(aux);
                    BufferedImage print = new BufferedImage(pnlDesenho.getWidth(),pnlDesenho.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
                    Graphics2D desenha = print.createGraphics();
                    desenha.setColor(pnlDesenho.getBackground());
                    desenha.fillRect(0,0,pnlDesenho.getWidth(),pnlDesenho.getHeight());
                    while (!l.estaVazia()){
                        aux.getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                        aux = aux.getProx();
                        if (aux.getProx() == null){
                        	break;
                        }
                    }
                    desenha.dispose();
                    Graphics2D desenhafinal = (Graphics2D)pnlDesenho.getGraphics();
                    desenhafinal.drawImage(print, null, 0,0);
                    desenhafinal.dispose();
                    statusBar1.setText("Mensagem:");
                    
                }
                
                if(esperaFimQuadrado){
                    
                    p2 = new Ponto(e.getX(), e.getY(), borda);
                    int x1 = p1.getX();
                    
                    int y1 = p1.getY();
                    int x2 = p2.getX();
                    int y2 = p2.getY();
                    int dx = x2 - x1;
                    int dy = y2 - y1;
                    if (Math.abs(dx) < Math.abs(dy)) {
                        int Sinal = dy / Math.abs(dy);
                        dy = Math.abs(dx) * Sinal;
                        y2 = y1 + dy;
                        p2 = new Ponto(e.getX(), y2);

                    } else if (Math.abs(dy) < Math.abs(dx)) {
                        int Sinal = dx / Math.abs(dx);
                        dx = Math.abs(dx) * Sinal;
                        x2 = x1 + dx;
                        p2 = new Ponto(x2, e.getY());
                        p2 = new Ponto(e.getX(), e.getY(), borda);
                        
                    l.removeUltimo();
                    salvado = false;
                    aux = new NoLista(new Quadrado(p1, p2, borda, fundo),null);
                    l.insereNo(aux);
                    BufferedImage print = new BufferedImage(pnlDesenho.getWidth(),pnlDesenho.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
                    Graphics2D desenha = print.createGraphics();
                    desenha.setColor(pnlDesenho.getBackground());
                    desenha.fillRect(0,0,pnlDesenho.getWidth(),pnlDesenho.getHeight());
                    while (!l.estaVazia()){
                        aux.getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                        aux = aux.getProx();
                        if (aux.getProx() == null){
                        	break;
                        }
                    }
                    desenha.dispose();
                    Graphics2D desenhafinal = (Graphics2D)pnlDesenho.getGraphics();
                    desenhafinal.drawImage(print, null, 0,0);
                    desenhafinal.dispose();
                    statusBar1.setText("Mensagem:");
                    
                }
                }
                
                if (esperaFimRetangulo) {
                
                l.removeUltimo();
                salvado = false;
                p2=new Ponto(e.getX(),e.getY());
                aux = new NoLista(new Retangulo(p1, p2, borda, fundo),null);
                 l.insereNo(aux);
                BufferedImage print = new BufferedImage(pnlDesenho.getWidth(),pnlDesenho.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
                Graphics2D desenha = print.createGraphics();
                desenha.setColor(pnlDesenho.getBackground());
                desenha.fillRect(0,0,pnlDesenho.getWidth(),pnlDesenho.getHeight());
                while (!l.estaVazia()){
                    aux.getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                    aux = aux.getProx();
                    if (aux.getProx() == null){
                    	break;
                    }
                }
                desenha.dispose();
                Graphics2D desenhafinal = (Graphics2D)pnlDesenho.getGraphics();
                desenhafinal.drawImage(print, null, 0,0);
                desenhafinal.dispose();
                statusBar1.setText("Mensagem:");
                }
                

                   
                        
                       

                    
                
        }
             
        

        public void mouseMoved(MouseEvent e) {
            statusBar2.setText("Coordenada: " + e.getX() + "," + e.getY());
        }
    }

    private class DesenhoDeQuadrado implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            zeraTudo();
            esperaInicioQuadrado = true;

            statusBar1.setText("Mensagem: clique o ponto inicial do quadrado"
                    + "");
        }
    }

    private class DesenhoDeRetangulo implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            zeraTudo();
            esperaInicioRetangulo = true;

            statusBar1.setText("Mensagem: clique o ponto inicial do retangulo"
                    + "");
        }
    }

    private class DesenhoDePonto implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            zeraTudo();
            esperaPonto = true;

            statusBar1.setText("Mensagem: clique o local do ponto desejado");
        }
    }

    private class DesenhoDeReta implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            zeraTudo();
            esperaInicioReta = true;

            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }

    private class DesenhoDeCirculo implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            zeraTudo();
            esperaInicioCirculo = true;

            statusBar1.setText("Mensagem: clique para o inicio do circulo");
        }
    }

    private class DesenhoDeElipse implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            zeraTudo();
            esperaInicioElipse = true;

            statusBar1.setText("Mensagem: clique para o centro da elipse");
        }
    }

    private class FechamentoDeJanela extends WindowAdapter {

        public void windowClosing(WindowEvent e) {

            if (salvado == false) {
                int b = 1;
                int i = JOptionPane.NO_OPTION;
                int b2 = JOptionPane.showConfirmDialog(rootPane,
                        "Deseja Salvar antes de sair?", "Confirmação", b);
                if (b2 == JOptionPane.YES_OPTION) {
                    JFileChooser chooser;
                    chooser = new JFileChooser();
                    String caminho = "";
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
                            "Kbl Images", ".kbl");
                    chooser.setFileFilter(filter);
                    int retorno = chooser.showSaveDialog(null);
                    while (retorno == JFileChooser.APPROVE_OPTION && i == JOptionPane.NO_OPTION) {
                        caminho = chooser.getSelectedFile().getAbsolutePath();
                        if (!caminho.endsWith(".kbl")) {
                            caminho = caminho + ".kbl";
                        }
                        File f = new File(caminho);
                        chooser.setSelectedFile(f);
                        if (chooser.getSelectedFile().exists()) {
                            i = JOptionPane.showConfirmDialog(rootPane,
                                    "Deseja Salvar sobre o arquivo "
                                    + chooser.getName(chooser.getSelectedFile())
                                    + "?", "Confirmação", retorno);
                            if (i == JOptionPane.NO_OPTION) {
                                retorno = chooser.showSaveDialog(null);
                            }
                        } else {
                            i = JOptionPane.YES_OPTION;
                        }
                    }
                    if (retorno == JFileChooser.CANCEL_OPTION) {
                        return;
                    }
                    if (!caminho.equals("")) {
                        PrintWriter saida = null;
                        try {
                            saida = new PrintWriter(new FileWriter(caminho));
                        } catch (IOException ex) {

                        }
                        while (!l.estaVazia()){
                            saida.println(aux.getElemento());
                            aux = aux.getProx();
                            if (aux.getProx() == null){
                            	break;
                            }
                        }
                        saida.close();

                        salvado = true;
                        System.exit(0);
                    } else {
                        try {
                            throw new FileNotFoundException();
                        } catch (FileNotFoundException ex) {

                        }
                    }
                } else if (b2 == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }

        }
    }

    private class pegacor implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            borda = JColorChooser.showDialog(rootPane, "escolha a cor da borda", borda);
            if (borda == null) {
                borda = Color.BLACK;
            }
            fundo = JColorChooser.showDialog(rootPane, "escolha a cor da fundo", fundo);
            if (borda == null) {
                borda = Color.LIGHT_GRAY;
            }
        }
    }

    private class FazTexto implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            JFontChooser JanelaTexto = new JFontChooser();
            int retorno = JanelaTexto.showDialog(rootPane);
            if (retorno == JFontChooser.OK_OPTION) {
                Texto = JanelaTexto.getSelectedFont();
            }
            iniciotexto = true;
        }
    }

    private class AbrirFile implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            pnlDesenho.getGraphics().clearRect(pnlDesenho.getX(), pnlDesenho.getY(), pnlDesenho.getWidth(), pnlDesenho.getHeight());
            JFileChooser chooser;
            chooser = new JFileChooser();
            String caminho = "";
            File file = null;
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Kbl Images", "kbl");
            chooser.setFileFilter(filter);
            int retorno = chooser.showOpenDialog(null);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                caminho = chooser.getSelectedFile().getAbsolutePath();
                if (!caminho.endsWith(".kbl")) {
                    caminho = caminho + ".kbl";
                }
            }
            if (!caminho.equals("")) {
                BufferedReader entrada = null;
                try {
                    entrada = new BufferedReader(new FileReader(caminho));
                } catch (FileNotFoundException ex) {

                }
                String linha;
                try {
                    l.removeTodosNos();
                    while (entrada.ready()) {
                        linha = entrada.readLine();
                        StringTokenizer classe = new StringTokenizer(linha, ":");
                        String tc = classe.nextToken();
                        switch (tc) {
                            case "p":
                            	aux = new NoLista(new Ponto(linha), null);
                                l.insereNo(aux);
                                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                                break;
                            case "r":
                                aux = new NoLista(new Linha(linha), null);
                                l.insereNo(aux);
                                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                                break;
                            case "c":
                                aux = new NoLista(new Circulo(linha), null);
                                l.insereNo(aux);
                                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                                break;
                            case "e":
                                aux = new NoLista(new Elipse(linha), null);
                                l.insereNo(aux);
                                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                                break;
                            case "q":
                                aux = new NoLista(new Quadrado(linha), null);
                                l.insereNo(aux);
                                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                                break;
                            case "retan":
                                aux = new NoLista(new Retangulo(linha), null);
                                l.insereNo(aux);
                                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                                break;
                            case "txt":
                                aux = new NoLista(new Texto(linha), null);
                                l.insereNo(aux);
                                l.getUltimo().getElemento().torneSeVisivel(pnlDesenho.getGraphics());
                                break;
                            default:
                                break;
                                
                        }
                    }
                } catch (IOException ex) {

                }
                try {
                    entrada.close();
                } catch (IOException ex) {

                }
            } else {
                try {
                    throw new FileNotFoundException();
                } catch (FileNotFoundException ex) {

                }
            }
        }
    }

    private class SalvarFile implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
        	
            JFileChooser chooser;
            chooser = new JFileChooser();
            String caminho = "";
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Kbl Images", "kbl");
            chooser.setFileFilter(filter);;
            int retorno = chooser.showSaveDialog(null);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                if (chooser.getSelectedFile().exists()) {
                    if (salvado == false) {
                        int i = JOptionPane.showConfirmDialog(rootPane,
                                "Deseja salvar sobre o arquivo"
                                + chooser.getName(chooser.getSelectedFile())
                                + "?", "Confirmação", retorno);
                        if (i == 0) {
                            caminho = chooser.getSelectedFile().getAbsolutePath();

                        }
                    }

                } else {
                    caminho = chooser.getSelectedFile().getAbsolutePath() + "";
                }

                if (!caminho.equals("")) {
                    PrintWriter saida = null;
                    try {
                        saida = new PrintWriter(new FileWriter(caminho+".kbl"));
                    } catch (IOException ex) {

                    }
                    aux = l.getPrimeiro();
                    while (aux.getProx() != null){
                        saida.println(aux.getElemento());
                        aux = aux.getProx();
                    }
                    saida.close();
                    l.percorreLista();
                } else {
                    try {
                        throw new FileNotFoundException();

                    } catch (FileNotFoundException ex) {
                    }
                }

            }
        }
    }

    public int hashCode() {
        int resultado = 7;

        resultado = resultado * 13 + this.btnPonto.hashCode();
        resultado = resultado * 13 + this.btnLinha.hashCode();
        resultado = resultado * 13 + this.btnCirculo.hashCode();
        resultado = resultado * 13 + this.btnElipse.hashCode();
        resultado = resultado * 13 + this.btnCores.hashCode();
        resultado = resultado * 13 + this.btnAbrir.hashCode();
        resultado = resultado * 13 + this.btnSalvar.hashCode();
        resultado = resultado * 13 + this.btnApagar.hashCode();
        resultado = resultado * 13 + this.btnSair.hashCode();
        resultado = resultado * 13 + this.pnlDesenho.hashCode();
        resultado = resultado * 13 + this.btnQuadrado.hashCode();
        resultado = resultado * 13 + this.btnRetangulo.hashCode();
        resultado = resultado * 13 + this.btnTexto.hashCode();

        resultado = resultado * 13 + this.statusBar1.hashCode();
        resultado = resultado * 13 + this.statusBar2.hashCode();

        resultado = resultado * 13 + (this.esperaInicioCirculo ? 1 : 0);
        resultado = resultado * 13 + (this.esperaInicioElipse ? 1 : 0);
        resultado = resultado * 13 + (this.esperaFimReta ? 1 : 0);
        resultado = resultado * 13 + (this.esperaFimCirculo ? 1 : 0);
        resultado = resultado * 13 + (this.esperaInicioReta ? 1 : 0);
        resultado = resultado * 13 + (this.esperaPonto ? 1 : 0);
        resultado = resultado * 13 + (this.esperaMeioElipse ? 1 : 0);
        resultado = resultado * 13 + (this.esperaFimElipse ? 1 : 0);
        resultado = resultado * 13 + (this.esperaInicioQuadrado ? 1 : 0);
        resultado = resultado * 13 + (this.esperaFimQuadrado ? 1 : 0);
        resultado = resultado * 13 + (this.esperaInicioRetangulo ? 1 : 0);
        resultado = resultado * 13 + (this.esperaFimRetangulo ? 1 : 0);
        resultado = resultado * 13 + (this.iniciotexto ? 1 : 0);
        resultado = resultado * 13 + (this.fimtexto ? 1 : 0);

        resultado = resultado * 13 + this.borda.hashCode();
        //resultado = resultado * 13 + this.figuras.hashCode();

        return resultado;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (obj instanceof Janela) {
            Janela j = (Janela) obj;

            if (this.btnPonto.equals(j.btnPonto)
                    && this.btnAbrir.equals(j.btnAbrir)
                    && this.btnApagar.equals(j.btnApagar)
                    && this.btnCirculo.equals(j.btnCirculo)
                    && this.btnCores.equals(j.btnCores)
                    && this.btnElipse.equals(j.btnElipse)
                    && this.btnLinha.equals(j.btnLinha)
                    && this.btnSair.equals(j.btnSair)
                    && this.btnSalvar.equals(j.btnSalvar)
                    && this.pnlDesenho.equals(j.pnlDesenho)
                    && this.statusBar1.equals(j.statusBar1)
                    && this.statusBar2.equals(j.statusBar2)
                    && this.btnQuadrado.equals(j.btnQuadrado)
                    && this.btnRetangulo.equals(j.btnRetangulo)
                    && this.btnTexto.equals(j.btnTexto)
                    && this.esperaInicioCirculo == j.esperaInicioCirculo
                    && this.esperaInicioElipse == j.esperaInicioElipse
                    && this.esperaFimReta == j.esperaFimReta
                    && this.esperaFimCirculo == j.esperaFimCirculo
                    && this.esperaInicioReta == j.esperaInicioReta
                    && this.esperaPonto == j.esperaPonto
                    && this.esperaFimElipse == j.esperaFimElipse
                    && this.esperaInicioRetangulo == j.esperaInicioRetangulo
                    && this.esperaFimQuadrado == j.esperaFimQuadrado
                    && this.esperaFimRetangulo == j.esperaFimRetangulo
                    && this.esperaInicioQuadrado == j.esperaInicioQuadrado
                    && this.iniciotexto == j.iniciotexto
                    && this.fimtexto == j.fimtexto
                    && this.borda.equals(j.borda))
                    //&& this.figuras.equals(j.figuras))
                    {
                return true;
            }

            return false;
        }

        return false;
    }

    public Object clone() throws NullPointerException {
        return new Janela(this);
    }

    public Janela(Janela modelo) throws NullPointerException {
        if (modelo == null) {
            throw new NullPointerException();
        } else {
            this.btnAbrir = modelo.btnAbrir;
            this.btnApagar = modelo.btnApagar;
            this.btnCirculo = modelo.btnCirculo;
            this.btnCores = modelo.btnCores;
            this.btnElipse = modelo.btnElipse;
            this.btnLinha = modelo.btnLinha;
            this.btnPonto = modelo.btnPonto;
            this.btnSair = modelo.btnSair;
            this.btnSalvar = modelo.btnSalvar;
            this.borda = modelo.borda;
            this.btnQuadrado = modelo.btnQuadrado;
            this.btnRetangulo = modelo.btnRetangulo;
            this.btnTexto = modelo.btnTexto;
            this.esperaInicioCirculo = modelo.esperaInicioCirculo;
            this.esperaFimCirculo = modelo.esperaFimCirculo;
            this.esperaInicioReta = modelo.esperaInicioReta;
            this.esperaFimReta = modelo.esperaFimReta;
            this.esperaInicioQuadrado = modelo.esperaInicioQuadrado;
            this.esperaFimQuadrado = modelo.esperaFimQuadrado;
            this.esperaInicioRetangulo = modelo.esperaInicioRetangulo;
            this.esperaFimRetangulo = modelo.esperaFimRetangulo;
            this.esperaPonto = modelo.esperaPonto;
            this.esperaInicioElipse = modelo.esperaInicioElipse;
            this.esperaFimElipse = modelo.esperaFimElipse;
            this.esperaMeioElipse = modelo.esperaMeioElipse;
            this.iniciotexto = modelo.iniciotexto;
            this.fimtexto = modelo.fimtexto;
            //this.figuras = modelo.figuras;
            this.p1 = modelo.p1;
            this.p2 = modelo.p2;
            this.pnlDesenho = modelo.pnlDesenho;
            this.statusBar1 = modelo.statusBar1;
            this.statusBar2 = modelo.statusBar2;
        }
    }
}
