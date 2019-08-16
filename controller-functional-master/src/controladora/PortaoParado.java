package controladora;

public class PortaoParado implements IPortao {

	@Override
	public void tratarTempo(final Controladora controladora) {
		// aguardando o botao ser pressionado 
	}

	@Override
	public void tratarBotao(final Controladora controladora, final Boolean portaoAbrindo) {
		// movimentar o portao quando o botao for pressionado
		if (portaoAbrindo) {
			controladora.setPortao(new PortaoAbrindo());
		} else {
			controladora.setPortao(new PortaoFechando());
		}

	}

	@Override
	public void tratarObstaculo(final Controladora controladora) {
		// aguardando o botao ser pressionado
	}
}
