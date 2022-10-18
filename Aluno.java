public class Aluno extends Usuario{
    private String nivel;

    public Aluno(String nome,String senha,String profissao,String recuperar,String nivel){
        super(nome,senha,profissao,recuperar);
        this.nivel = nivel;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    @Override
    public void printarInformacoesuser() {
       super.printarInformacoesuser();
       System.out.println("Nivel escolar: " + this.nivel);
    }
}
