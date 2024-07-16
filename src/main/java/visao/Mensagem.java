package visao;
import javax.swing.JOptionPane;

public class Mensagem {

    public static final String PALPITE_ANIMAL = "O animal que você pensou, é ";
    public static final String PALPITE_TRACO = "O animal que você pensou, ";
    String titulo = "Adivinhando o bicho";
    Object[] simNao = {"Sim", "Não"};

    public Mensagem() {
    }

    public int mostraMensagemInicial() {
        String mensagemInicial = "Pense em um animal.";
        Object[] opcaoInicio = {"Vamos lá!", "Não, quero sair!"};
        int numero = JOptionPane.showOptionDialog(null, mensagemInicial, titulo , JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcaoInicio, opcaoInicio[0]);

        return numero;
    }

    public int perguntaTraco(String trait) {
        StringBuilder string = new StringBuilder();
        string.append(PALPITE_TRACO +trait+"?");
        int resposta = JOptionPane.showOptionDialog(null, string, titulo, JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, simNao, simNao[0]);

        return resposta;
    }

    public int perguntaAnimal(String animal) {
        StringBuilder string = new StringBuilder();
        string.append(PALPITE_ANIMAL+animal+" ?");
        int resposta = JOptionPane.showOptionDialog(null, string, titulo, JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, simNao, simNao[0]);

        return resposta;
    }

    public String entrada(String mensagem) {
        String entradaDados = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
        return entradaDados;
    }

    public int perguntaNovoJogo(String vencedor) {
        String venci = "Então, "+vencedor+", quer jogar novamente ?";
        int numero = JOptionPane.showOptionDialog(null, venci, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, simNao, simNao[0]);

        return numero;
    }
}