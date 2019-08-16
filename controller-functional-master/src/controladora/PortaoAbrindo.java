package controladora;

public class PortaoAbrindo implements IPortao {
	
	@Override
	public void tratarTempo(final Controladora controladora) {
		// movimentando o portao 
		controladora.setPosicaoPortao(controladora.getPosicaoPortao() + 1);
		// verificando se o portao atingiu o limite maximo de abertura
		if (controladora.getPosicaoPortao() >= controladora.getPosicaoMaximaPortao()) {
			// proximo movimento sera de fechamento
			controladora.setPortao(new PortaoParado());
		}
		
	}

	@Override
	public void tratarBotao(final Controladora controladora, final Boolean portaoAbrindo) {
		// parando o portao
		controladora.setPortao(new PortaoParado());
	}

	@Override
	public void tratarObstaculo(final Controladora controladora) {
		// fechando o portao
		controladora.setPortao(new PortaoFechando());
	}

}
