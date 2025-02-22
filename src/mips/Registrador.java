package mips;


/**
 * 
 * Classe feita para representar um registrador.
 * Os valores alterados por meio de m�todos set s� ser�o atualizados
 * ap�s a chamada do m�todo clock, que representa a ativa��o de um 
 * ciclo de clock.
 * 
 */
public class Registrador {
	
	/**
	 * Conte�do do registrador.
	 */
	protected long valor = 0;
	//protected long pc = 0;
	
	/**
	 * Controla quando o conte�do do registrador pode ser sobrescrito.
	 */
//	private boolean disableWrite = false;
	
	/**
	 * Novo conte�do do registrador que ser� atualizado quando clock()
	 * for chamado.
	 */
	protected long novoValor = -1;
	
	/**
	 * Construtor que inicia o registrador com conte�do 0.
	 */
	public Registrador() {
		this(0);
	}
	
	/**
	 * Construtor que inicia o registrador com conte�do do par�metro.
	 * @param valor � o valor que ser� inserido inicialmente no registrador.
	 */
	public Registrador(long valor) {
		this.valor = valor;
	}
	
	public long getValue() {
		return valor;
	}
	
	public void setValue(long novoValor) {
		this.valor = novoValor;
	}
	
}
