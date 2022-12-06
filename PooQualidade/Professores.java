public class Professores extends Usuario {
    public String disciplina;
    public String identify;
    public Professores(String nome,String senha,String recuperar,String profissao, String identify, String disciplina){
        super(nome, senha, recuperar, profissao);
        this.disciplina = disciplina;
        this.identify = identify;
    }
    @Override
    public void printarInformacoesuser() {
        super.printarInformacoesuser();
        System.out.println("Numero de identificaçao: " + this.identify);
        System.out.println("Disciplina lecionada: " + this.disciplina);
    }
}
