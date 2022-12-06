public class Usuario {
    public String nome;
    public String senha;
    public String recuperar;
    public String profissao;
    public boolean coord;
    
    public Usuario(String nome,String senha,String recuperar,String profissao){
        this.nome = nome;
        this.profissao = profissao;
        this.senha = senha;
        this.recuperar = recuperar;
        if(profissao.equals("professor") || profissao.equals("coordenador") || profissao.equals("Professor") || profissao.equals("Coordenador")){
            coord = true;
        }
        else{
            coord = false;
        }
        System.out.println("\nUsuario adicionado com sucesso!\n");
    }
    public void printarInformacoesuser(){
        //return "\nNome do usuário: " + this.nome + "\nProfissão do usuário: " + this.profissao + "\nPode ser coordenador: " + (this.coord ? "Sim" : "Não");
        System.out.println("Nome do usuário: " + this.nome);
        System.out.println("Profissão do usuário: " + this.profissao);
        System.out.println("Pode ser coordenador: " + (this.coord ? "Sim" : "Não"));
    }
    public void recuperarSenha(){
        System.out.println("Senha do Usuario: " + this.senha + "\n");
    }
}
  