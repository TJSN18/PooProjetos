import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Logado{
    static int index;
    static String nam;
}

public class Main {
    public static void main(String[] args) {
    tratarErro();
}

public static void tratarErro(){
    boolean tratar = false;

    while(!tratar){
        try{
            menu();
            tratar = true;
        }catch(NumberFormatException e){
            System.out.println("Ocorreu um erro no sistema, tente novamente!");
        }catch(NoSuchElementException e){
            System.out.println("Ocorreu um erro no sistema, tente novamente!");
        }
    }
}

public static void menu() throws NumberFormatException{
    Scanner escan = new Scanner(System.in);
    System.out.println("Digite 1 para: criar um usuario, recuperar a senha, criar um projeto ou uma atividade\nDigite 2 para: remover: um usuario, um projeto ou uma atividade\nDigite 3 para editar\nDigite 4 para consultar\nDigite 5 para relatorios\nDigite 6 para login\nDigite 7 para deslogar\nDigite 0 para sair");
    int opcao = escan.nextInt();
    escan.nextLine();

    switch(opcao){
        case 0:
        break;
        case 1:
        criar();
        case 2:
        remover();
        case 3:
        editar();
        case 4:
        consulta();
        case 5:
        relatorio();
        case 6:
        login();
        case 7:
        logado();
    }
    escan.close();
}
public static void criar() throws NumberFormatException{
    String nome, profissao, id, descricao, data_inicio, data_final, coord, procura, status;
    String senha, recuperar, nivel;
    double bolsa, periodo_bolsa;
    int opcao;
    ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    ArrayList<Projeto> projeto = new ArrayList<Projeto>();
    ArrayList<Atividade> atividade = new ArrayList<Atividade>();
    ArrayList<String> tasks = new ArrayList<String>();
    Scanner escan = new Scanner(System.in);
    System.out.printf("Digite 1 para criar login de usuario!\nDigite 2 para recuperar senha\nDigite 3 para adicionar um projeto!\nDigite 4 para adicionar uma atividade!\nDigite 0 para voltar ao menu!\n");
    opcao = escan.nextInt();
    escan.nextLine();
    if(opcao == 0){
        menu();;
    }
    else if(opcao == 1){
        System.out.println("Digite o nome do usuario:");
        nome = escan.nextLine();
        System.out.println("Digite a senha do usuario:");
        senha = escan.nextLine();
        System.out.println("Digite um email para recuperaçao da senha:");
        recuperar = escan.nextLine();
        System.out.println("Digite a profissao:");
        profissao = escan.nextLine();
        if(profissao.equals("aluno") || profissao.equals("Aluno")){
            System.out.println("Digite o Nivel de escolaride(Graduaçao, Mestrado ou Doutorado):");
            nivel = escan.nextLine();
            usuario.add(new Aluno(nome, senha, profissao, recuperar,nivel));
        }
        else{
            usuario.add(new Usuario(nome,senha,recuperar,profissao));
         }
    }
    else if(opcao == 2){
        System.out.println("digite o Email de recuperaçao:");
        recuperar = escan.nextLine();
        Usuario recUsuario = usuario.get(procurarSenha(recuperar, usuario));
        recUsuario.recuperarSenha();
    }                             
    else if(opcao == 3){
        System.out.println("Digite um Id para o Projeto:");
        id = escan.nextLine();
        System.out.println("Digite uma Descrição para o Projeto:");
        descricao = escan.nextLine();
        System.out.println("Digite a data e hora do inicio do projeto:");
        data_inicio = escan.nextLine();
        System.out.println("Digite o nome do coordenador responsavel pelo projeto:");
        coord = escan.nextLine();
        System.out.println("Digite o valor da bolsa desse projeto:");
        bolsa = escan.nextDouble();
        escan.nextLine();
        System.out.println("Digite o valor da bolsa para cada profissional!");
        periodo_bolsa = escan.nextDouble();
        escan.nextLine();
        data_final = "Aguardando conclusao do projeto!";
        status = "Em processo de criaçao";
        projeto.add(new Projeto(id, descricao, data_inicio, data_final, bolsa, periodo_bolsa, coord, status, usuario));                       
    }
    else if(opcao == 4){
        System.out.println("Digite um Id para a Atividade:");
        id = escan.nextLine();
        System.out.println("Digite uma Descrição para a Atividade:");
        descricao = escan.nextLine();
        System.out.println("Digite a data e hora do inicio da Atividade:");
        data_inicio = escan.nextLine();
        System.out.println("Digite o nome do coordenador responsavel pela Atividade:");
        coord = escan.nextLine();
        data_final = "Aguardando conclusao da Atividade!";
        System.out.println("Digite 1 para adicionar essa atividade em um projeto\nDigite 2 para continuar!");
        opcao = escan.nextInt();
        escan.nextLine();
        if(opcao == 1){
            System.out.println("Digite o Id do projeto para qual sera adicionado essa Atividade:");
            procura = escan.nextLine();
            Projeto addProjeto = projeto.get(procurarProjeto(procura, projeto));
            addProjeto.addAtividade(new Atividade(id, descricao, coord, data_inicio, data_final, usuario, tasks));
        }
        else{
            atividade.add(new Atividade(id, descricao, coord,data_inicio, data_final, usuario, tasks));
            menu();;
        }
    }
    escan.close();           
}

public static void remover() throws NumberFormatException{
    Scanner escan = new Scanner(System.in);
    ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    ArrayList<Projeto> projeto = new ArrayList<Projeto>();
    ArrayList<Atividade> atividade = new ArrayList<Atividade>();
    int opcao;
    String id;
    System.out.println("Digite 1 para remover um usuário\nDigite 2 para remover um projeto\nDigite 3 para remover uma atividade\nDigite 4 para voltar ao menu;");
    opcao = escan.nextInt();
    escan.nextLine();
    if(opcao == 1){
        System.out.println("Digite o nome do usuário a ser removido: ");
        id = escan.nextLine();
        usuario.remove(procurarUsuario(id, usuario));
        System.out.print("\n---Usuario removido com sucesso!---\n");
    }
    else if(opcao == 2){
        System.out.println("Digite o id do projeto a ser removido: ");
        id = escan.nextLine();
        projeto.remove(procurarProjeto(id, projeto));
        System.out.print("\n---Projeto removido com sucesso!---\n");
    }
    else if(opcao == 3){
        System.out.println("Digite o id da atividade a ser removido: ");
        id = escan.nextLine();
        atividade.remove(procurarAtividade(id, atividade));
        System.out.printf("\n---Atividade removida com sucesso!---\n");
    }
    else if(opcao == 4){
    menu();;
    }
    escan.close();
}

public static void editar() throws NumberFormatException{
    Scanner escan = new Scanner(System.in);
    ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    ArrayList<Projeto> projeto = new ArrayList<Projeto>();
    ArrayList<Atividade> atividade = new ArrayList<Atividade>();
    String nome, profissao, id, descricao, data_final, coord, status;
    String tarefa;
    double bolsa, periodo_bolsa;
    int opcao;
    if(Logado.index == 0){
        System.out.println("Efetue o Login para continuar!");
        menu();
    }
    Usuario desUsuario = usuario.get(procurarUsuario(Logado.nam, usuario));
    if(desUsuario.coord == false){
        System.out.println("Esse usuario nao tem acesso a essas informaçoes!");
        menu();
    }
    else if(Logado.index == 1 && desUsuario.coord == true){
    System.out.println("1 para editar usuario\n2 para editar projeto\n3 para editar atividade\n0 para voltar ao menu!\n");
    opcao = escan.nextInt();
    escan.nextLine();
    if(opcao == 0){
        menu();
    }
    else if(opcao == 1){
        System.out.println("Digite o nome do usuario que sera editado: ");
        nome = escan.nextLine();
        Usuario editNomeUsuario = usuario.get(procurarUsuario(nome, usuario));
        System.out.println("1 para editar o nome\n2 para editar profissao");
        opcao = escan.nextInt();
        escan.nextLine();
        if(opcao == 1){
            System.out.println("Digite o novo nome do usuario: ");
            nome = escan.nextLine();
            editNomeUsuario.nome = nome;
            System.out.println("nome alterado!");
        }
        else if(opcao == 2){
            System.out.println("Digite a nova profissao: ");
            profissao = escan.nextLine();
            editNomeUsuario.profissao = profissao;
            System.out.println("Profissao altera!");
        }
    }
    else if(opcao == 2){
        System.out.println("Digite o Id do projeto que sera alterado:");
        id = escan.nextLine();
        Projeto editProjeto = projeto.get(procurarProjeto(id, projeto));
        System.out.println("1 para editar o descriçao\n2 para editar data de termino ou status do projeto\n3 para editar o coordenador responsavel\n4 para editar valor da bolsa\n5 para editar o periodo de vigencia da bolsa\n6 para adicionar um profissional ao projeto\n7 para adicionar uma atividade ao projeto\n0 para voltar ao menu");
        opcao = escan.nextInt();
        escan.nextLine();
        if(opcao == 0){
            menu();
        }
        else if(opcao == 1){
            System.out.println("Digite a nova descriçao do projeto: ");
            descricao = escan.nextLine();
            editProjeto.descricao = descricao;
            System.out.println("Descriçao alterada!");
        }
        else if(opcao == 2){
            System.out.println("Digite 1 para editar status do projeto\nDigite 2 para editar data final do projeto");
            opcao = escan.nextInt();
            escan.nextLine();
            if(opcao == 1){
            System.out.println("Digite o novo status do projeto: ");
            status = escan.nextLine();
            editProjeto.status = status;
            System.out.println("Status alterado!");
            }
            else if(opcao == 2){
            System.out.println("Digite a nova data e hora de termino do projeto");
            data_final = escan.nextLine();
            editProjeto.data_hora_final = data_final;
            System.out.println("Data final alterada!");
            }
        }
        else if(opcao == 3){
            System.out.println("Digite o novo coordenador do projeto:");
            coord = escan.nextLine();
            editProjeto.projeto_cord = coord;
            System.out.println("coordenador alterado!");
        }
        else if(opcao == 4){
            System.out.println("Digite o novo valor da bolsa:");
            bolsa = escan.nextDouble();
            editProjeto.valor_proj = bolsa;
        }
        else if(opcao == 5){
            System.out.println("Digite o novo periodo de vigencia do projeto:");
            periodo_bolsa = escan.nextDouble();
            editProjeto.periodo_bolsa = periodo_bolsa;
        }
        else if(opcao == 6){
            System.out.println("Digite o nome do profissional que sera adicionado ao projeto:");
            nome = escan.nextLine();
            editProjeto.projetoUsuarios.add(usuario.get(procurarUsuario(nome, usuario)));
            System.out.println("Usuario adiconado ao projeto!");
        }
        else if(opcao == 7){
            System.out.println("Digite o Id da atividade que sera adicionada ao projeto:");
            id = escan.nextLine();
            editProjeto.projetoAtv.add(atividade.get(procurarAtividade(id, atividade)));
            System.out.println("Atividade adiconada ao projeto!");
        }
        
    }
    else if(opcao == 3){
        System.out.println("Digite o Id da atividade para ser alterada:");
        id = escan.next();
        Atividade editAtividade = atividade.get(procurarAtividade(id, atividade));
        System.out.println("1 para editar a descriçao\n2 para editar a data e hora final\n3 para alterar o coordenador da atividade\n4 para adicionar um profissional a atividade\n5 para adicionar tarefas a atividade\n0 para voltar ao menu");
        opcao = escan.nextInt();
        escan.nextLine();
        if(opcao == 0){
            menu();
        }
        else if(opcao == 1){
            System.out.println("Digite a nova descriçao da atividade:");
            descricao = escan.nextLine();
            editAtividade.descricao = descricao;
            System.out.println("Descriçao alterada!");
        }
        else if(opcao == 2){
            System.out.println("Digite a nova data e hora final da atividade:");
            data_final = escan.nextLine();
            editAtividade.data_horario_final = data_final;
            System.out.println("Data e hora alterada!");
        }
        else if(opcao == 3){
            System.out.println("Digite a novo coordenador da atividade:");
            coord = escan.nextLine();
            editAtividade.coord = coord;
            System.out.println("Coordenador alterado!");
        }
        else if(opcao == 4){
            System.out.println("Digite o nome do usuario que sera adicionado a atividade:");
            nome = escan.nextLine();
            editAtividade.prof_resp.add(usuario.get(procurarUsuario(nome, usuario)));
            System.out.println("Usuario adicionado!");
        }
        else if(opcao == 5){
            System.out.println("Digite uma tarefa a ser feita na atividade:");
            tarefa = escan.nextLine();
            editAtividade.tasks_reali.add(tarefa);
            System.out.println("Tarefa adicionada!");
        }
    }
}
escan.close();
}

public static void consulta() throws NumberFormatException{
    Scanner escan = new Scanner(System.in);
    ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    ArrayList<Projeto> projeto = new ArrayList<Projeto>();
    ArrayList<Atividade> atividade = new ArrayList<Atividade>();
    int opcao;
    String id, nome;
    System.out.println("1 para Consultar usuarios\n2 para Consultar projetos\n3 para Consultar atividades\n0 para voltar ao menu");
    opcao = escan.nextInt();
    escan.nextLine();
    if(opcao == 0) menu();
    else if(opcao == 1){
        System.out.println("Digite o nome do usuario:");
        nome = escan.nextLine();
        usuario.get(procurarUsuario(nome, usuario)).printarInformacoesuser();
    }
    else if(opcao == 2){
        System.out.println("Digite o Id do projeto");
        id = escan.nextLine();
        projeto.get(procurarProjeto(id, projeto)).printarInformacoesproj();
    }
    else if(opcao == 3){
        System.out.println("Digite o Id da atividade");
        id = escan.nextLine();
        atividade.get(procurarAtividade(id, atividade)).printarInformacoesatv();
    }
    escan.close();
}

public static void relatorio() throws NumberFormatException{
    Scanner escan = new Scanner(System.in);
    ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    ArrayList<Projeto> projeto = new ArrayList<Projeto>();
    ArrayList<Atividade> atividade = new ArrayList<Atividade>();
    int opcao;
    System.out.println("1 para relatorio de usuarios\n2 para projetos\n3 para atividades\n0 para voltar ao menu");
    opcao = escan.nextInt();
    escan.nextLine();
    if(opcao == 0){
        menu();
    }
    else if(opcao == 1){
       for (Usuario userUsuario : usuario) {
            userUsuario.printarInformacoesuser();
       }
    }
    else if(opcao == 2){
        for (Projeto proj : projeto) {
            proj.printarInformacoesproj();
        }
    }
    else if(opcao == 3){
        for (Atividade ativ : atividade) {
            ativ.printarInformacoesatv();
        }
    }
    escan.close();    
}

public static void login() throws NumberFormatException{
    Scanner escan = new Scanner(System.in);
    ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    String nome, senha;
    Integer verificar = Logado.index;
    if(verificar == 1){
        System.out.println("----Voce ja esta logado!----\n");
        menu();
    }
    else{
    System.out.println("Digite o nome do usuario:");
    nome = escan.nextLine();
    System.out.println(("Digite a senha do usuario:"));
    senha = escan.nextLine();
    logar(usuario, nome, senha);
    if(Logado.index == 1){
        System.out.println("Login efetuado!!");
    }
}
escan.close();    
}

public static void logado(){
    Logado.index = 0;
    System.out.println("Deslogado com sucesso!\n");
}

public static int procurarProjeto(String id, ArrayList<Projeto> projeto){
        int contador = 0;
        for (Projeto projeto2 : projeto) {
            if(projeto2.id_projeto == id){
                break;
            }
            else{
                contador++;
            }
        }
        return contador-1;
    }

public static int procurarAtividade(String id, ArrayList<Atividade> atividade){
        int contador = 0;
        for (Atividade atv : atividade) {
            if(atv.atv_id == id){
                break;
            }
            else{
                contador++;
            }
        }
        return contador-1;

}

 public static int procurarUsuario(String nome, ArrayList<Usuario> usuario){
        for (int i = 0; i < usuario.size(); i++) {
            if (usuario.get(i).nome.equals(nome))
               return i;
        }   
        return -1;
      }
      public static int procurarSenha(String recuperar, ArrayList<Usuario> usuario){
        for (int i = 0; i < usuario.size(); i++) {
            if (usuario.get(i).recuperar.equals(recuperar))
               return i;
        }   
        return -1;
      }

public static void logar(List<Usuario> usuarios,String name,String pass){
        boolean verificar = false;

        for (Usuario usuario : usuarios) {
            if(usuario.nome.equalsIgnoreCase(name) && usuario.senha.equalsIgnoreCase(pass)){
                verificar = true;
                Logado.index = 1;
                Logado.nam = name;
            }
        }
        if(verificar == false){
            System.out.println("Login Incorreto!!");
            Logado.index = 0;
        }
    }
}
