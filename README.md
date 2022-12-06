#Sistema para Gerenciamento de Projetos em uma Universidade!

Code Smells:
 Lazy class na subclasse Aluno.
 
 Smells:
  ```java
  public ArrayList<String> tasks_reali;
  ```
  ```java
  this.tasks_reali = new ArrayList<String>();
  ```
  resolvido com Replace Data Value with Object!
  
  ```java
  public ArrayList<Task> tasks_reali;
  ```
  ______________________________
  Lazy class resolvido com adição de 3 novas subclasses.
  ______________________________
  
  Smells:
  ```java
  if(profissao.equals("professor") || profissao.equals("coordenador") || profissao.equals("Professor") || profissao.equals("Coordenador")){
            coord = true;
        }
        else{
            coord = false;
        }
   ```
   Resolvido com Inline Method!
   ```java
   this.coord = getCoord();
   ```
   
   ```java
   public boolean getCoord(){
        return (profissao.equals("professor") || profissao.equals("coordenador") || profissao.equals("Professor") || profissao.equals("Coordenador")) ? this.coord == false : this.coord == true ;
    }
