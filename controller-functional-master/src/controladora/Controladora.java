package controladora;

public class Controladora {

	private IPortao portao;
	private int posicaoPortao = 0;
	private final int posicaoMaximaPortao = 5;

	public Controladora() {
		this.portao = new PortaoParado();
	}

	// GETTERS E SETTERS

	public void setPortao(IPortao portao) {
		this.portao = portao;
	}


	public int getPosicaoPortao() {
		return posicaoPortao;
	}


	public void setPosicaoPortao(int posicaoPortao) {
		this.posicaoPortao = posicaoPortao;
	}


	public int getPosicaoMaximaPortao() {
		return posicaoMaximaPortao;
	}

	public String executar(final String entrada) {
		final StringBuilder saida = new StringBuilder();
		boolean portaoAbrindo = true;
		for (int i = 0; i < entrada.length(); i++) {
			switch (entrada.charAt(i)) {
			case '.': 						// NADA A FAZER
				this.portao.tratarTempo(this);
				break;

			case 'P':						// BOTAO PRESSIONADO
				this.portao.tratarBotao(this, portaoAbrindo);
				this.portao.tratarTempo(this);
				break;

			case 'O':						// OBSTACULO
				this.portao.tratarObstaculo(this);
				this.portao.tratarTempo(this);
				break;
			}
			saida.append(Integer.toString(this.getPosicaoPortao()));
			portaoAbrindo = trataPortaoAbrindo(portaoAbrindo, this.portao, this.posicaoPortao, this.posicaoMaximaPortao);
		}

		return saida.toString();
	}

	public boolean trataPortaoAbrindo(boolean portaoAbrindo, final IPortao portao, final int posicaoPortao, final int posicaoMaximaPortao){
		if(!(this.portao instanceof PortaoParado)){
			portaoAbrindo = !(portao instanceof PortaoFechando);
		}
		if(portaoAbrindo && (posicaoPortao == posicaoMaximaPortao)){
			portaoAbrindo = false;
		}
		return portaoAbrindo;
	}

}
