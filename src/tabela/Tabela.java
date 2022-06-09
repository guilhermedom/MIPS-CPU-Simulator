/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabela extends JFrame {
    JPanel painelFundo;
    JTable tabelaBancoReg;
    JTable tabelaMemoria;
    JTable tabelaRegInterIF_ID;
    JTable tabelaRegInterID_EX;
    JTable tabelaRegInterEX_MEM;
    JTable tabelaRegInterMEM_WB;
    
    JTable tabelaULA;
    
    JScrollPane barraRolagem;
       
    Object [][] dados = {
        {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}
    };
    
    String [] colunas = {"Nome"};

    //if_id Id_ex ex_mem mem_wb
    public void criaJanela(String bancoReg, String memoria, String regInterIF_ID, String regInterID_EX, String regInterEX_MEM,String regInterMEM_WB, String ULA) {

    	//Cria array de String separadas por '\n'
    	String[] bancoRegTela = bancoReg.split("\\n");
        String[] memoriaTela = memoria.split("\\n");
        String[] regIntermediarioIF_ID = regInterIF_ID.split("\\n");
        String[] regIntermediarioID_EX = regInterID_EX.split("\\n");
        String[] regIntermediarioEX_MEM = regInterEX_MEM.split("\\n");
        String[] regIntermediarioMEM_WB = regInterMEM_WB.split("\\n");
        String[] ulaString = ULA.split("\\n");
        
        //Cria Modelos para exibicao no painel
        DefaultTableModel modelBancoReg = new DefaultTableModel();
        modelBancoReg.addColumn("Banco de Registradores", bancoRegTela);
        
        DefaultTableModel modelMemoria = new DefaultTableModel();
        modelMemoria.addColumn("Memoria", memoriaTela);
        
        DefaultTableModel modelRegInterIF_ID = new DefaultTableModel();
        modelRegInterIF_ID.addColumn("Reg Inter IF_ID", regIntermediarioIF_ID);
        
        DefaultTableModel modelRegInterID_EX = new DefaultTableModel();
        modelRegInterID_EX.addColumn("Reg Inter ID_EX", regIntermediarioID_EX);
        
        DefaultTableModel modelRegInterEX_MEM = new DefaultTableModel();
        modelRegInterEX_MEM.addColumn("Reg Inter EX_MEM", regIntermediarioEX_MEM);
        
        DefaultTableModel modelRegInterMEM_WB = new DefaultTableModel();
        modelRegInterMEM_WB.addColumn("Reg Inter MEM_WB", regIntermediarioMEM_WB);
        
        DefaultTableModel modelULA= new DefaultTableModel();
        modelULA.addColumn("ULA", ulaString);
        
        
        //Cria Painel
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        
        painelFundo.setFocusable(true);
        painelFundo.requestFocusInWindow();

        
        //Adicionar modelos no painel
        tabelaBancoReg = new JTable(modelBancoReg);
        barraRolagem = new JScrollPane(tabelaBancoReg);
        painelFundo.add(barraRolagem);
        tabelaBancoReg.getColumn("Banco de Registradores").setMaxWidth(150);
        tabelaBancoReg.setEnabled(false);
        
        tabelaMemoria = new JTable(modelMemoria);
        barraRolagem = new JScrollPane(tabelaMemoria);
        painelFundo.add(barraRolagem);
        tabelaMemoria.getColumn("Memoria").setMaxWidth(200);
        tabelaMemoria.setEnabled(false);
        
        tabelaRegInterIF_ID = new JTable(modelRegInterIF_ID);
        barraRolagem = new JScrollPane(tabelaRegInterIF_ID);
        painelFundo.add(barraRolagem);
        tabelaRegInterIF_ID.getColumn("Reg Inter IF_ID").setMaxWidth(150);
        tabelaRegInterIF_ID.setEnabled(false);
        
        tabelaRegInterID_EX = new JTable(modelRegInterID_EX);
        barraRolagem = new JScrollPane(tabelaRegInterID_EX);
        painelFundo.add(barraRolagem);
        tabelaRegInterID_EX.getColumn("Reg Inter ID_EX").setMaxWidth(150);
        tabelaRegInterID_EX.setEnabled(false);
        
        tabelaRegInterEX_MEM = new JTable(modelRegInterEX_MEM);
        barraRolagem = new JScrollPane(tabelaRegInterEX_MEM);
        painelFundo.add(barraRolagem);
        tabelaRegInterEX_MEM.getColumn("Reg Inter EX_MEM").setMaxWidth(150);
        tabelaRegInterEX_MEM.setEnabled(false);
        
        tabelaRegInterMEM_WB = new JTable(modelRegInterMEM_WB);
        barraRolagem = new JScrollPane(tabelaRegInterMEM_WB);
        painelFundo.add(barraRolagem);
        tabelaRegInterMEM_WB.getColumn("Reg Inter MEM_WB").setMaxWidth(150);
        tabelaRegInterMEM_WB.setEnabled(false);
        
        tabelaULA = new JTable(modelULA);
        barraRolagem = new JScrollPane(tabelaULA);
        painelFundo.add(barraRolagem);
        tabelaULA.getColumn("ULA").setMaxWidth(150);
        tabelaULA.setEnabled(false);
        
        addPainel();
    }
    
    public void addPainel(){
	    getContentPane().add(painelFundo);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(1000, 700);
	    setVisible(true);
    }
    
    public void removePainel(){
    	getContentPane().remove(painelFundo);
    }
    
}