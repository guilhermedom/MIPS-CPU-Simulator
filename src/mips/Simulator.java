package mips;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import estagios.Busca;
import estagios.Decodifica;
import estagios.Executa;
import estagios.Memoria;
import estagios.Writeback;

import tabela.Tabela;

/**
 * Classe principal do simulador. Controla os est�gios do pipeline e declara os
 * conjuntos de registradores.
 */

public class Simulator {	
	
	static Tabela lc = new Tabela();
	
	private static ArrayList<String> entrada = new ArrayList<String>();
	
	/**
	 * Conjunto de registradores entre cada est�gio de pipeline.
	 */
	private RegInterno if_id = new RegInterno();
	private static RegInterno id_ex = new RegInterno();
	private RegInterno ex_mem = new RegInterno();
	private RegInterno mem_wb = new RegInterno();
	
	private ProgramCounter pc = new ProgramCounter();
	
	/**
	 * Banco de registradores da CPU
	 */
	private static BancoRegistradores bReg = new BancoRegistradores();
	
	private static MemoriaCPU memoriaCPU;
	
	/**
	 * Conjunto de estados do pipeline
	 */
	private Busca busca;
	private Decodifica decodifica;
	private Executa executa;
	private Memoria memoria;
	private Writeback writeback;
	
	/**
	 * Fun��o main do programa.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {	
			String palavra;
		
			do {
				System.out.println("Digite uma instrucao: ");
				palavra = scanner.nextLine();
				if (palavra.compareTo("pare") == 0)
					break;
				entrada.add(palavra);
			} while (true);
			
			entrada.add("|");
			
			do {
				System.out.println("Digite um dado: ");
				palavra = scanner.nextLine();
				if (palavra.compareTo("pare") == 0)
					break;
				entrada.add(palavra);
			} while (true);
		
			Simulator sim = new Simulator(entrada);
		
			// Executa o simulador criado acima.
			sim.run();
		}
                
	}
	
	/**
	 * Cria o simulador como um todo, desde mem�ria at� est�gios de pipeline.
	 */
	public Simulator(String arq) throws IOException {
		// Mem�ria de instru��es e de dados
		memoriaCPU = new MemoriaCPU(arq);
		
		// Est�gios do pipeline
		busca = new Busca(if_id, memoriaCPU, pc);
		decodifica = new Decodifica(if_id, id_ex, bReg, pc);
		executa = new Executa(id_ex, ex_mem, mem_wb);
		memoria = new Memoria(ex_mem, mem_wb, memoriaCPU);
		writeback = new Writeback(mem_wb, bReg);
	}
	
	public Simulator(ArrayList<String> entrada) throws IOException {
		// Mem�ria de instru��es e de dados
		memoriaCPU = new MemoriaCPU(entrada);
		
		// Est�gios do pipeline
		busca = new Busca(if_id, memoriaCPU, pc);
		decodifica = new Decodifica(if_id, id_ex, bReg, pc);
		executa = new Executa(id_ex, ex_mem, mem_wb);
		memoria = new Memoria(ex_mem, mem_wb, memoriaCPU);
		writeback = new Writeback(mem_wb, bReg);
	}
	
	/**
	 * Executa o simulador
	 * @throws IOException 
	 */
	public void run() throws IOException {
		int i = 0;
		
		int tamanhoMemIns = memoriaCPU.getLimite();
		// Contador de n�mero de ciclos.
		int numCiclos = 0;
			
		Scanner scanner = new Scanner(System.in);
		
			
		
			if (memoriaCPU.getValue(pc.getValue()) != "|") {
				busca.run();
				numCiclos++;
				i++;
				lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
				scanner.nextLine();
				lc.removePainel();
			}
			
			if (memoriaCPU.getValue(pc.getValue()) != "|") {
				decodifica.run();
				busca.run();
				numCiclos++;
				i++;
				lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
				scanner.nextLine();
				lc.removePainel();
			}

			if (memoriaCPU.getValue(pc.getValue()) != "|") {
				executa.run();
				decodifica.run();
				busca.run();
				numCiclos++;
				i++;
				lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
				scanner.nextLine();
				lc.removePainel();
			}

			if (memoriaCPU.getValue(pc.getValue()) != "|") {
				memoria.run();
				executa.run();
				decodifica.run();
				busca.run();
				numCiclos++;
				i++;
				lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
				scanner.nextLine();
				lc.removePainel();
			}
			while (memoriaCPU.getValue(pc.getValue()) != "|") {
				writeback.run();
				memoria.run();
				executa.run();
				decodifica.run();
				busca.run();			
				numCiclos++;
				i++;
				lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
				scanner.nextLine();
				lc.removePainel();
			}

			writeback.run();
			memoria.run();
			executa.run();
			decodifica.run();
			numCiclos++;
			lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
			scanner.nextLine();
			lc.removePainel();

			writeback.run();
			memoria.run();
			executa.run();
			numCiclos++;
			lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
			scanner.nextLine();
			lc.removePainel();

			writeback.run();
			memoria.run();
			numCiclos++;
			lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
			scanner.nextLine();
			lc.removePainel();

			writeback.run();
			numCiclos++;
			lc.criaJanela(bReg.toString(), memoriaCPU.toString(),if_id.toString(),id_ex.toString(),ex_mem.toString(),mem_wb.toString(),executa.toString());
			
		
			System.out.println("Numero de ciclos: " + numCiclos);
			
	}
	
}
