# Produtos-API-Java

API endpoints summary
Route             | Method   | Description
------------------|----------|--------------------
/api/produtos     | POST     | Create a product
/api/produtos     | GET      | Read all products
/api/produtos/:id | GET      | Read one product by ID
/api/produtos/:id | DELETE   | Delete one product by ID
/api/produtos/:id | PUT      | Update one product by ID

### POST https://plancto-diaryapp.herokuapp.com/api/produtos

##### HTTP Request Body Example
    
    {
    "nome": "Pão Russo",
    "quantidade": 500,
    "valor": 1.00,
    "observacao": "Pão direto da Russia (COMUNISMO)"
    }
    

##### HTTP Response Body Example

     {
    "id": 3,
    "nome": "Pão Russo",
    "quantidade": 500,
    "valor": 1.0,
    "observacao": "Pão direto da Russia (COMUNISMO)"
    }
    
### GET https://plancto-diaryapp.herokuapp.com/api/produtos

##### HTTP Request Body Example
  null
  
##### HTTP Response Body Example
    [
        {
            "id": 1,
            "nome": "Mouse Gamer",
            "quantidade": 200,
            "valor": 500.0,
            "observacao": "Mouse Gamer"
        },
        {
            "id": 2,
            "nome": "Pão Russo",
            "quantidade": 500,
            "valor": 1.0,
            "observacao": "Pão direto da Russia (COMUNISMO)"
        },
        {
            "id": 3,
            "nome": "Pão Russo",
            "quantidade": 500,
            "valor": 1.0,
            "observacao": "Pão direto da Russia (COMUNISMO)"
        }
    ]
    
### GET https://plancto-diaryapp.herokuapp.com/api/produtos/2
    
##### HTTP Request Body Example
  null
  
##### HTTP Response Body Example

    {
        "id": 2,
        "nome": "Pão Russo",
        "quantidade": 500,
        "valor": 1.0,
        "observacao": "Pão direto da Russia (COMUNISMO)"
     }
     
### DELETE https://plancto-diaryapp.herokuapp.com/api/produtos/2
    
##### HTTP Request Body Example
  null
  
##### HTTP Response Body Example
  null  obs: the item was deleted.
  
  
  
### PUT https://plancto-diaryapp.herokuapp.com/api/produtos/1
    
##### HTTP Request Body Example
    {
        "nome": "Pão Russo",
        "quantidade": 500,
        "valor": 1.0,
        "observacao": "Pão direto da Russia (COMUNISMO)"
     }
  
##### HTTP Response Body Example

    {
        "id": 1,
        "nome": "Pão Russo",
        "quantidade": 500,
        "valor": 1.0,
        "observacao": "Pão direto da Russia (COMUNISMO)"
     }
