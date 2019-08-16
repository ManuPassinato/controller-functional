package controladora;

public class PortaoFechando implements IPortao{
	
	@Override
	public void tratarTempo(final Controladora controladora) {
		// movimentando o portao
		controladora.setPosicaoPortao(controladora.getPosicaoPortao() - 1);
		// verificando se o portao chegou no limite inferior
		if (controladora.getPosicaoPortao() == 0) {
			// proximo movimento sera de abertura
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
		// abrindo o portao
		controladora.setPortao(new PortaoAbrindo());
	}

}
