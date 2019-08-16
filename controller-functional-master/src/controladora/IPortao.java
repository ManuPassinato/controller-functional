package controladora;

public interface IPortao {
	void tratarTempo(final Controladora controladora);
	void tratarBotao(final Controladora controladora, final Boolean portaoAbrindo);
	void tratarObstaculo(final Controladora controladora);
}
