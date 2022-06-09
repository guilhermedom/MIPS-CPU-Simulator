package mips;


/**
 * Classe que simula um program counter. Armazena a posi��o na mem�ria atual.
 */
public class ProgramCounter extends Registrador {
	
	/**
	 * Cria o program counter e o deixa apontado para a instru��o inicial.
	 */
	public ProgramCounter() {
		super(0);
	}
	
	/**
	 * Avan�a o program counter na mem�ria, palavra a palavra/linha a linha
	 * /posi��o a posi��o do hashmap de mem�ria.
	 */
	public void avanca() {
		//pc = getValue() + 1;
		valor++;
		System.out.println("Novo PC: " + valor);
	}
}
