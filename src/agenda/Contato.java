package agenda;

public class Contato {
  private static final int TOTAL_TAGS = 5;
  private String nome;
  private String sobrenome;
  private String telefone;
  private boolean favorito;
  private String[] tags;

  Contato(String nome, String sobrenome, String telefone) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.telefone = telefone;
    this.favorito = false;
    this.tags = new String[TOTAL_TAGS];
  }

  public String getNomeCompleto() {
    return this.nome + " " + this.sobrenome;
  }

  @Override
  public boolean equals(Object obj) {
    String nomeContato = this.getNomeCompleto();

    if (obj == null)
      return false;
    if (obj.getClass() != this.getClass())
      return false;

    Contato objContato = (Contato) obj;
    return nomeContato.equals(objContato.getNomeCompleto());
  }

  @Override
  public String toString() {
    String tags = formataTags();
    return this.nome + " " + this.sobrenome + "\n" + this.telefone + "\n" + tags;
  }

  public void setFavorito() {
    this.favorito = !this.favorito;
  }

  public boolean getFavorito() {
    return this.favorito;
  }

  public String[] getTags() {
    return this.tags;
  }

  public void adicionaTags(int posicaoTag, String tag) {
    this.tags[posicaoTag] = tag;
  }

  private String formataTags() {
    String tagsFormatadas = "";
    for (String tag : tags) {
      if (tag != null) {
        tagsFormatadas += tag + " ";
      }
    }
    return tagsFormatadas;
  }

  public static boolean validaPosicao(int posicao) {
    if (0 > posicao || posicao > 100) {
      return false;
    }

    return true;
  }

  public static boolean validaCampoVazio(String campo) {
    if (campo.equals("") || campo == null) {
      return false;
    }

    return true;
  }

  public static boolean validaRepeticao(String nome, String sobrenome, Agenda agenda) {
    Contato[] listaDeContatos = agenda.getContatos();
    for (int i = 0; i < listaDeContatos.length; i++) {
      String nomeCadastro = nome + " " + sobrenome;

      if (listaDeContatos[i] != null && nomeCadastro.equals(listaDeContatos[i].getNomeCompleto())) {
        return false;
      }
    }
    return true;
  }
}