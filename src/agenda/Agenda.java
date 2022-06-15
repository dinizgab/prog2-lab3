package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100
 * contatos.
 * 
 * @author nazareno
 *
 */
public class Agenda {

  private static final int TAMANHO_AGENDA = 100;

  private static final int TAMANHO_FAVORITOS = 10;

  private Contato[] contatos;

  private Contato[] favoritos;

  /**
   * Cria uma agenda.
   */
  public Agenda() {
    this.contatos = new Contato[TAMANHO_AGENDA];
    this.favoritos = new Contato[TAMANHO_FAVORITOS];
  }

  /**
   * Acessa a lista de contatos mantida.
   * 
   * @return O array de contatos.
   */
  public Contato[] getContatos() {
    return this.contatos.clone();
  }

  public Contato[] getFavoritos() {
    return this.favoritos.clone();
  }

  public void cadastraFavorito(int posicaoContato, int posicaoFavorito) {

    if(this.favoritos[posicaoFavorito] != null) {
      this.contatos[posicaoContato].setFavorito();
      this.favoritos[posicaoFavorito].setFavorito();
    } else {
      this.contatos[posicaoContato].setFavorito();
    }
    this.favoritos[posicaoFavorito] = this.contatos[posicaoContato];
  }

  public boolean validaFavorito(int posicaoContato) {
    for (int i = 0; i < favoritos.length; i++) {
      if (contatos[posicaoContato].equals(favoritos[i])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Acessa os dados de um contato específico.
   * 
   * @param posicao Posição do contato na agenda.
   * @return Dados do contato. Null se não há contato na posição.
   */
  public Contato getContato(int posicao) {
    return contatos[posicao];
  }

  /**
   * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe
   * sobrescreve o anterior.
   * 
   * @param posicao   Posição do contato.
   * @param nome      Nome do contato.
   * @param sobrenome Sobrenome do contato.
   * @param telefone  Telefone do contato.
   */
  public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
    Contato novoContato = new Contato(nome, sobrenome, telefone);
    this.contatos[posicao] = novoContato;
  }

  public void cadastraTag(String[] contatosDeCadastro, String tag, int posicaoTag) {
    for (String contato : contatosDeCadastro) {
      int indexContato = Integer.parseInt(contato);

      this.contatos[indexContato].adicionaTags(posicaoTag, tag);;
    }
  }
}