import java.util.ArrayList;

public class Projeto {
    public String id_projeto, descricao, data_hora_inicio, data_hora_final, projeto_cord, status;
    public ArrayList<Usuario> projetoUsuarios;
    public ArrayList<Atividade> projetoAtv;
    public double valor_proj, periodo_bolsa;
    
    public Projeto(String id_projeto, String descricao, String data_hora_inicio, String data_hora_final,Double valor_proj ,Double periodo_bolsa, String projeto_cord, String status,ArrayList<Usuario> usuarios){
        this.id_projeto = id_projeto;
        this.descricao = descricao;
        this.data_hora_inicio = data_hora_inicio;
        this.data_hora_final = data_hora_final;
        this.valor_proj = valor_proj;
        this.periodo_bolsa = periodo_bolsa;
        this.projeto_cord = projeto_cord;
        this.status = status;
        this.projetoUsuarios = new ArrayList<Usuario>();
        this.projetoAtv = new ArrayList<Atividade>();
        System.out.printf("%nProjeto criado com sucesso. %nId: %s%nDescricao: %s%nCoordenador: %s%nStatus: %s%n", id_projeto, descricao, projeto_cord,status);
    }
    public void addUsuario(Usuario novoUsuario){
        this.projetoUsuarios.add(novoUsuario);
        System.out.println("Usuário adicionado ao projeto!");
    }

    public void addAtividade(Atividade novaAtividade){
        this.projetoAtv.add(novaAtividade);
        System.out.println("Atividade adicionada ao projeto!");
    }
    public void printarInformacoesproj(){
        System.out.println("Descrição do projeto: " + this.descricao);
        System.out.println("Coordenador do projeto: " + this.projeto_cord);
        System.out.println("Data de início do projeto: " + this.data_hora_inicio);
        System.out.println("Data de término do projeto: " + this.data_hora_final);
        System.out.println("Status: " + this.status);
    }
}
