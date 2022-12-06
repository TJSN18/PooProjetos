public class Tecnico extends Usuario{
    public String funcionalidade;
    public String identify;
    public Tecnico(String nome,String senha,String recuperar,String profissao, String identify, String funcionalidade){
        super(nome, senha, recuperar, profissao);
        this.funcionalidade = funcionalidade;
        this.identify = identify;
    }
    @Override
    public void printarInformacoesuser() {
        super.printarInformacoesuser();
        System.out.println("Numero de identificaçao: " + this.identify);
        System.out.println("Funcionalidade tecnica: " + this.funcionalidade);
    }
}
