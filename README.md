## Projeto-SeLigaNaTrilha

## Solução
Com o intuito de facilitar a busca por conteúdos agregadores, o Seliganatrilha é uma plataforma que busca auxiliar verdadeiramente a aprendizagem dos usuários por meio de trilhas de conhecimento, moderadas por profissionais qualificados da área.
## Status:
Em desenvolvimento

## Features:

- [✅] Cadastro de usuários
- [🔄] Cadastro de Trilhas
- [❌] Cadastro de capítulos das trilhas
- [❌] Validação de trilhas pelo usuário curador
- [✅] Listar Trilhas
- [✅] Buscar Trilha por Id
- [❌] Listar Trilhas por Tema
- [❌] Listar Trilhas do mesmo criador
- [❌] Adicionar comentário

✅ - Implementada  
❌ - A fazer  
🔄 - Em andamento

<h2>Pré-requisitos:</h2>
Para rodar essa aplicação, é necessário ter instalado o Java (Versão 17), um editor de códigos como Eclipse, IntelliJ ou Visual Studio Code(VS Code) e uma plataforma para construção e uso de APIs como Postman ou Thunder(como plug-in para o VS Code, caso esteja usando-o).

### DTOs para as requisições POST e PUT
#### Usuário

````
{
    "nome" : "Nome Exemplo",
    "email" : "email@exemplo.com",
    "cpf" : "12345678901",
    "senha" : "senha3xemplo"
}
````

#### Trilha
````
{
    "nome" : "Nome Exemplo",
    "descricao" : "Descrição do conteúdo presente na trilha"
}
````