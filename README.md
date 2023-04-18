
# Escopo e objetivo

_Projeto que serve de referência para o desenvolvimento de software em Java_.

É um projeto proposto para ser clonado e reutilizado, faz uso de 
Spring Boot 3, JDK 17 (exigido) e Maven 3.8.6.


Para ilustrar o projeto inclui:
(a) API REST utilizando Spring Boot - Implementação de CRUD;
(b) Utilização das bibliotecas, como o driver do MySQL, o Flyway e o Lombok;
(c) alguns de seus módulos, como Web, Validação e Spring Data JPA.

> _Objetivo: ilustrar uma organização de código em Java usando
> "boas práticas" para inspirar projetos reais_.

## Iniciando...

- `git clone https://github.com/lkazumi/api-rest-java-volmed.git`

Agora você poderá executar os vários comandos abaixo.

## Pré-requisitos

- `mvn --version`<br>
  você deverá ver a indicação da versão do Maven instalada e
  a versão do JDK, dentre outras. Observe que o JDK é obrigatório, assim como
  a definição das variáveis de ambiente **JAVA_HOME**.

## Limpar, compilar, executar testes de unidade e cobertura

- `mvn clean`<br>
  remove diretório _target_

- `mvn compile`<br>
  compila o projeto, deposita resultados no diretório _target_


## Produzindo código executável (depende da JVM)

- `mvn package`<br>
  gera arquivo _exemplo.jar_ no diretório _target_. Observe que
  o arquivo gerado não é executável. Um arquivo jar é um arquivo no formato
  zip. Você pode verificar o conteúde deste arquivo ao executar o comando `jar vft exemplo.jar`.

- `mvn package -P executavel-dir`<br>
  gera _exemplo-dir.jar_, executável, mas dependente do diretório _jars_,
  também criado no diretório _target_. Para executar basta o comando
  `java -jar target/exemplo-dir.jar`. Observe que se o diretório _jars_ for
  removido, então este comando falha. Por último, o diretório _jars_ deve
  ser depositado no mesmo diretório do arquivo _exemplo.jar_. A execução deste
  arquivo refere-se à aplicação via linha de comandos.

- `mvn package -P executavel-unico`<br>
  gera jar executável correspondente ao aplicativo a ser executado via linha de comandos,
  em um único arquivo, _target/exemplo-unico.jar_,
  suficiente para ser transferido e executado. Para executá-lo basta o
  comando `java -jar target/exemplo-unico.jar`.

- `mvn package -P api`<br>
  gera jar executável juntamente com todas as dependências reunidas em um único arquivo,
  _target/api.jar_. Este arquivo jar pode ser transferido para outro diretório
  ou máquina e ser executado pelo comando `java -jar target/api.jar`. 

A execução e exemplos de chamadas são fornecidos na seção seguinte.

## Executando a REST API

- `mvn exec:java -Dexec.mainClass="nome.completo.Classe" -Dexec.args="arg1 arg2"`<br>
  executa o método _main_ da classe indicada na configuração do _plugin_ pertinente
  no arquivo pom.xml. Depende de `mvn compile`.

- `java -jar target/exemplo-unico.jar`<br>
  executa o aplicativo por meio do arquivo jar criado pelo comando `mvn package -P executavel-unico`, conforme comentado anteriormente. Observe que o comando
  anterior e o corrente produzem o mesmo efeito, contudo, o arquivo jar
  permite que seja enviado para um outro diretório ou outro computador,
  onde pode ser executado, enquanto o comando anterior (acima) exige,
  inclusive, a disponibilidade do Maven (o que pode ser útil em tempo de
  desenvolvimento).

- `java -jar target/api.jar` ou ainda `mvn spring-boot:run`<br>
  coloca em execução a API gerada por `mvn package -P api` na porta padrão (8080). Para fazer uso de porta
  diferente use `java -jar -Dserver.port=9876 target/api.jar`, por exemplo. Requisições podem ser
  submetidas conforme abaixo:
  - Abra o endereço _http://localhost:8080/medicos no seu navegador.
  - Via Postman ou Insomnia, `GET http://localhost:8080/medicos`.
  - Via Postman ou Insomnia, `PUT http://localhost:8080/medicos` dados body via json(id, nome, telefone, endereco).
  - Via Postman ou Insomnia, `POST http://localhost:8080/medicos` dados body via json(nome,email,crm,telefone,especialidade,endereco":{logradouro,bairro,cep,cidade,uf,numero,complemento}).
  - Via Postman ou Insomnia, `DEL http://localhost:8080/medicos/id`.

## Produzindo código executável

- JDK 17
- Visual Studio (Windows)