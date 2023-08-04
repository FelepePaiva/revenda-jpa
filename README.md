# REVENDA DE VEÍCULOS
Aplicação para controle de estoque de uma revenda de veículos 
# FUNCIONALIDADES
- Cadastro de veículos: Permite cadastrar novos veículos, fornecendo informações como modelo, montadora, cor, ano do modelo e preço.
- Pesquisa de veículos: Permite pesquisar veículos com base em critérios como:
      Busca por modelo
      Busca por montadora
      Busca por faixa de preço
      Busca por ano do modelo
- Exclusão de veículos: Permite excluir um veículo do banco de dados.
# ENDPOINTS
POST: `http://127.0.0.1:8080/vehicles`<br>
Adiciona um veículo no banco de dados. <br>
Exemplo de entrada: 
```
{
"model": "Pálio",
"assembler": "Fiat",
"color": "Prata",
"yearModel": 2008,
"price": 18000.0
}
```
![Post insert2](https://github.com/FelepePaiva/revenda-jpa/assets/99683278/c4a71f8b-069e-426c-8fe9-ae9fe97dedb5)<br>

DELETE: `http://127.0.0.1:8080/vehicles/{id}`<br>
Remove um veículo do banco de dados recebendo como parâmetro o ID do veículo.<br>
Exemplo de entrada: `http://127.0.0.1:8080/vehicles/9`<br>
![Delete id](https://github.com/FelepePaiva/revenda-jpa/assets/99683278/6073ff3f-2a3d-4956-b2de-8a07b932007c)<br>


GET: `http://127.0.0.1:8080/vehicles/model/{model}`<br>
Realiza uma busca no banco de dados utilizando o modelo como parâmentro retorando uma lista, caso encontre mais de um veículo. <br>
Exemplo de entrada: `http://127.0.0.1:8080/vehicles/model/compass`<br>
![Get model](https://github.com/FelepePaiva/revenda-jpa/assets/99683278/e4ef840b-faec-4172-b897-68c69ab2c000) <br>

GET: `http://127.0.0.1:8080/vehicles/assembler/{assembler}` <br>
Realiza uma busca no banco de dados utilizando a montadora como parâmetro, retornando uma lista dos veículos encontrados.<br>
Exemplo de entrada: `http://127.0.0.1:8080/vehicles/assembler/{jeep}`<br>
![Get assembler](https://github.com/FelepePaiva/revenda-jpa/assets/99683278/c66bf084-4fa6-446a-aa8f-09123db83f4b) <br>

GET: `http://127.0.0.1:8080/vehicles/yearModel/{yearModel}`<br>
Reliza uma busca no banco de dados utilizando o ano como parâmetro, retornando uma lista com os veículos encontrados.<br>
Exemplo de entrada: `http://127.0.0.1:8080/vehicles/yearModel/2017`<br>
![Get yearModel ](https://github.com/FelepePaiva/revenda-jpa/assets/99683278/c89a7b7d-b35c-4038-b7c5-eacddd1d52f5)<br>

GET: `http://127.0.0.1:8080/vehicles/price/?{minPrice=valor&maxPrice=valor}`<br>
Realiza uma busca no banco de dados utilizando a faixa de preço entre o valor mínimo e o máximo, retornando uma lista com os veículos encontrados. <br>
Exemplo de entrada: `http://127.0.0.1:8080/vehicles/price/?minPrice=90000&maxPrice=200000`<br>
![Get price](https://github.com/FelepePaiva/revenda-jpa/assets/99683278/d23d74cf-59a0-4245-a85f-78eb63aa4528)<br>




# TECNOLOGIAS EMPREGADAS
Java
Spring Boot,
JPA (Java Persistence API),
MySQL
# CONTATO
- EMAIL: felipe.geo.uece@gmail.com
- LINKEDIN: https://www.linkedin.com/in/felepe-paiva/
