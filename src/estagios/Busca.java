package estagios;

import mips.MemoriaCPU;
import mips.ProgramCounter;
import mips.RegInterno;
import mips.TipoRegistrador;

/**
 * Classe que representa o est�gio de busca do pipeline.
 */

public class Busca {
	
	// Conjunto de registradores necess�rios para o est�gio, mem�ria da m�quina e pc.
	private final RegInterno if_id;
	private final MemoriaCPU memoria;
	private final ProgramCounter pc;
	
	/**
	 * Preenche os atributos necess�rios para o est�gio de busca.
	 * @param if_id Conte�do do conjunto de registradores internos if_id.
	 * @param memoria Mem�ria da m�quina (dados + instru��o por enquanto).
	 * @param pc Program Counter.
	 */
	public Busca(RegInterno if_id, MemoriaCPU memoria, ProgramCounter pc) {
		this.if_id = if_id;
		this.memoria = memoria;
		this.pc = pc;
	}
	
	/**
	 * Executa o est�gio de busca.
	 */
	public void run() {
		String instrucao = memoria.getValue(pc.getValue());
		
		System.out.println("Instru��o atual em execu��o: " + instrucao);
		
		// Pega uma instru��o na mem�ria onde o pc se encontra, passa para o conjunto interno
		// de registradores if_id que segue para o est�gio decodifica.
		if_id.setValueIns(instrucao);
		
		// Zera OP_CODE pois n�o se sabe OP_CODE da instru��o.
		if_id.setValue(TipoRegistrador.OP_CODE, 0);
		
		// Coloca o valor do pc no if_id.
		if_id.setValue(TipoRegistrador.PC, pc.getValue());
		
		// Avan�a o pc para a pr�xima linha da mem�ria, para a pr�xima vez que o est�gio busca executar.
		pc.avanca();
	}
}
