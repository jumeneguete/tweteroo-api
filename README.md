# tweteroo

Api-REST construida com Spring Framework na Aceleração Java da <a href="https://driveneducation.com.br/" target="blank" style="text-decoration: none; color:purple">Driven Education</a>.

O objetivo do projeto é ser uma api-REST para um frontend inspirado no Twitter.

<b>Funcionalidades</b>

- Armazenamento de dados
    - [ ]  Utiliza H2 Database para persistência de dados em memória
    - [ ]  O formato de um **usuário** é:
        
        ```jsx
        {
        	username: 'bobesponja', 
        	avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info" 
        }
        ```
        
    - [ ]  O formato de um **tweet** é:
        
        ```jsx
        [
        	{
        		username: "bobesponja",
        		avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
        		tweet: "eu amo o hub"
        	}
        ]
        ```
        
- **POST** `/sign-up`
    - [ ]  Recebe pelo body da request um parâmetro **username** e um **avatar**, contendo o nome do username do usuário e a sua foto de avatar:
        
        ```jsx
        {
        	username: 'bobesponja', 
        	avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info" 
        }
        ```
        
    - [ ]  Por fim, retornar a mensagem `“OK”`
    
- **POST** `/tweets`
    - [ ]  Recebe pelo body da request os parâmetros `username` e `tweet`:
        ```jsx
        [
        	{
        		username: "bobesponja",
        		tweet: "eu amo o hub"
        	}
        ]
        ```
        
    - [ ]  Salva esse tweet num array de tweets do servidor
    - [ ]  Por fim, retornar a mensagem `“OK”`
    
- **GET** `/tweets` com paginação
    - [ ]  Retorna os 5 últimos tweets publicados
    - [ ]  Esse endpoint recebe a página identificada via query string (`?page=1`).
    - [ ]  Retorna os tweets da “página” (`page`) atual, esse endpoint também será chamado ao clicar no botão “**Carregar mais**” (isso já foi implementado no front-end). A primeira página corresponde aos últimos 5 tweets, a segunda do 6 ao 10, a terceira do 11 ao 15, etc…
        
        ```jsx
        [
        	{
        		username: "bobesponja",
        		avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
        		tweet: "eu amo o hub"
        	}
        ]
        ```
        
- **GET** `/tweets/USERNAME`
    - [ ]  Retorna todos os tweets publicados do usuario recebido por parâmetro de rota
    - [ ]  Aplica também a paginação
        
        ```jsx
        [
        	{
        		username: "bobesponja",
        		avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
        		tweet: "eu amo o hub"
        	}
        ]
        ```
