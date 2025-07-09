AULA 1 

API Springboot usa um framework. A criar a api se tenha basicamento o código java dojndo dentro de uma estrutura de application server, que seria o Tomcat, um servidor web que ao invés de  hospedar páginas, ele armazena classes java. 

Ao rodar a api na própria máquina, ela se tornará um "site", uma máquina que outras máquinas solicitam dados.

Junto ao Tomcat se terá o Spring Framework.

framework -> estrutura pŕe fabricada. Já cuida de muito trabalho mecânico, como, gerenciamento de dados vindos de uma requisição url, como mandar os dados formatados etc.

Java anotations -> iniciam com @. Informam ao framework o que ele deve fazer. São pequenas instruções java que comaçam com @ e não alteram a lógica do código mas, são usadas pelo framework e toma atitudes baseados no que foi informado.

Classes Model -> São representações da estrutura do banco de dados

ORM -> Mapeamento da linguagem da linguagem orientada a objeto para o banco de dados relacional

services - responsável por encapsular as regras de negócio

controllers - dada uma url, vai execultar uma determinada ação

@Autowired - significa que no caso do event repo ser um repositório e extender o crud repository o spring boot vai buscar uma implementação, pegar os parametros do CrudRepository de evente e integer, vai criar um objeto e não será necessário usar o new. o @Autowired faz uma injeção de dependencia. Busca uma inplementação, cria uma instancia dessa implementação e deixa disponivel para uso.

interface de repositório -> o spring data [framework que usa o jpa], fornece a possibilidade de criar definições de métodos e esses nomes de métodos/funções são manipulados pelo jpa e, de acordo com o que tivermos, vai gerar uma string sql correspondente.
(findByPrettyName do eventRepo corresponde ao atributo 'private String prettyName' do eventService)
Todo evento iniciado com findBy/getBy permite recuperar a informação do atributo

public Event findByPrettyName(String prettyName); -> Baseado no 'findByPrettyName' o jpa lê a definição e gera uma string sql correspondente ao findBy

dto -> data transfer object

IntStream.range(0, ranking.size()) -> tipo um FOR



