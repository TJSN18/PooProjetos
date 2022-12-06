import java.util.ArrayList;

public class Atividade {
    public String atv_id;
    public String descricao;
    public String coord;
    public String data_horario_inicio;
    public String data_horario_final;
    public ArrayList<Usuario> prof_resp;
    public ArrayList<String> tasks_reali;

    public Atividade(String atv_id, String descricao,String coord,String horario_inicio,String horario_final, ArrayList<Usuario> prof_resp, ArrayList<String> tasks_reali){
        this.atv_id = atv_id;
        this.descricao = descricao;
        this.coord = coord;
        this.data_horario_inicio = horario_inicio;
        this.data_horario_final = horario_final;
        this.prof_resp = new ArrayList<Usuario>();
        this.tasks_reali = new ArrayList<String>();
        System.out.printf("--%nAtividade criada com sucesso. %nId: %s%nDescricao: %s%nSupervisor: %s%n--%n", atv_id, descricao, prof_resp);
    }    
    public void printarInformacoesatv(){
        System.out.println("Descrição da atividade: " + this.descricao);
        System.out.println("Responsavel da atividade: " + this.coord);
        System.out.println("Data de início da atividade: " + this.data_horario_inicio);
        System.out.println("Data de término da atividade: " + this.data_horario_final);
    }   
}