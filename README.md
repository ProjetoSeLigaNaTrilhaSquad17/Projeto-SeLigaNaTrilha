## Projeto-SeLigaNaTrilha

## Solução
Com o intuito de facilitar a busca por conteúdos agregadores, o Seliganatrilha é uma plataforma que busca auxiliar verdadeiramente a aprendizagem dos usuários por meio de trilhas de conhecimento, moderadas por profissionais qualificados da área.
## Status:
Em desenvolvimento

## Features:

- [✅] Cadastro de usuários
- [✅] Atualizar usuário
- [✅] Cadastro de Trilhas
- [✅] Atualizar Trilha
- [✅] Cadastro de aulas das trilhas
- [✅] Atualizar aulas
- [✅] Validação de trilhas pelo usuário curador
- [✅] Listar Trilhas
- [✅] Buscar Trilha por Id
- [✅] Listar Trilhas por Tema
- [✅] Listar Trilhas do mesmo criador
- [✅] Adicionar avaliação
- [✅] Listar avaliações de uma trilha

✅ - Implementada  
❌ - A fazer  
🔄 - Em andamento

## Pré-requisitos:
Para rodar essa aplicação, é necessário ter instalado o Java (Versão 17), um editor de códigos como Eclipse, IntelliJ ou Visual Studio Code(VS Code) e uma plataforma para construção e uso de APIs como Postman ou Thunder(como plug-in para o VS Code, caso esteja usando-o).

## Swagger:
````
http://localhost:8080/swagger-ui/index.html
````

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

#### Avaliação
````
{
    "comentario" : "Comentário Exemplo",
    "nota" : 0-5
}
````
