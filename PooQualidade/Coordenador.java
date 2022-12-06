public class Coordenador extends Usuario {
    public String identify;
    public Coordenador(String nome,String senha,String recuperar,String profissao, String identify){
        super(nome, senha, recuperar, profissao);
        this.identify = identify;
    }
    @Override
    public void printarInformacoesuser() {
        super.printarInformacoesuser();
        System.out.println("Numero de identificaçao: " + this.identify);
        System.out.println("Este Funcionario é um Coodenador!");
    }
}
