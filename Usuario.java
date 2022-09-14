public class Usuario {
    public String nome;
    public String profissao;
    public boolean coord;
    
    public Usuario(String nome, String profissao){
        this.nome = nome;
        this.profissao = profissao;
        if(profissao.equals("professor") || profissao.equals("coordenador") || profissao.equals("Professor") || profissao.equals("Coordenador")){
            coord = true;
        }
        else{
            coord = false;
        }
        System.out.println("Usuario adicionado com sucesso!");
    }
    public void printarInformacoesuser(){
        System.out.println("Nome do usuário: " + this.nome);
        System.out.println("Profissão do usuário: " + this.profissao);
        System.out.println("Pode ser coordenador: " + (this.coord ? "Sim" : "Não"));
    }
}