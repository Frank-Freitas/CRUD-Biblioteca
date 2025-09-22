# CRUD-Biblioteca

Projeto de 2° semestre da Faculdade com intuito de aprender conceitos básicos da linguagem java, com o padrão de projeto MVC;

## Tecnologias 

 - Linghagem Java;
 - Gerenciador de dependências Maven;
 - Padrão de projeto MVC;
 - H2-dataBase

## Configuração

**Clonar repositório:**

- Abra um terminal no local que deseja clonar o projeto:
   
   ***Git Bash, Cmd, PowerShell etc. (preferencialmente Git Bash)***

- No terminal, clone o projeto com o comando:
```bash
git clone git@github.com:Frank-Freitas/CRUD-Biblioteca.git
```

- Após clonar, va para a pasta raiz do projeto com o comando:
```bash
cd CRUD-Biblioteca/
```

- Na raiz do projeto, execute:
```bash
mvn clean install
```

Para compilar o sistema, na pasta raiz do terminal execute:
```bash
mvn compile
```

Para executar o sistema, na pasta raiz do terminal execute:
```bash
mvn exec:java -Dexec.mainClass="com.biblioteca.biblioteca.AppStart"

```

