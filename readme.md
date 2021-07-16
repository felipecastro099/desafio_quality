# Desafio Quality

Repositório que contém a solução do desafio quality

- POST ```` /districts ````
- adiciona um novo distrito
    - body request:
    ````
    {
        "prop_district": "Distrito",
        "value_district_m2": 5
    }
    ````
    - body response
    ````
    {
      "id": 1,
      "prop_district": "Distrito",
      "value_district_m2": 5
    }
    ````
- POST ```` /properties ````
- adiciona uma nova propriedade
    - body request:
    ````
    {
        "prop_name": "Casa",
        "district": 1,
        "rooms": [
            {
                "room_name": "Comodo",
                "room_width": 10,
                "room_length": 10
            },
            {
                "room_name": "Comodo2",
                "room_width": 10,
                "room_length": 9
            }
        ]
    }
    ````
    - body response
    ````
    {
      "name": "Casa",
      "district": {
        "id": 1,
        "name": "Distrito",
        "value": 5
      },
      "rooms": [
        {
          "id": 1,
          "name": "Comodo",
          "width": 10.0,
          "length": 10.0
        },
        {
          "id": 2,
          "name": "Comodo2",
          "width": 10.0,
          "length": 9.0
        }
      ]
    }
    ````
- GET ```` /properties/{propertyId}/totalMeters ````
- verifica a quantidade de metros total da propriedade
    - body response
    ````
    {
      "name": "Casa",
      "totalMeters": 190.0
    }
    ```` 

- GET ```` /properties/{propertyId}/totalValue ````
- verifica o valor total da propriedade
    - body response
    ````
    {
      "name": "Casa",
      "totalValue": 950.0
    }
    ```` 

- GET ```` /properties/{propertyId}/rooms ````
- retorna a lista de cômodos de uma propriedade com o calculo de metros do mesmo
    - body response
    ````
    [
      {
        "id": 1,
        "name": "Comodo",
        "width": 10.0,
        "length": 10.0,
        "totalMeters": 100.0
      },
      {
        "id": 2,
        "name": "Comodo2",
        "width": 10.0,
        "length": 9.0,
        "totalMeters": 81.0
      }
    ]
    ```` 

- GET ```` /properties/{propertyId}/bigRoom ````
- retorna o maior comodo da propriedade
    - body response
    ````
    {
      "name": "Casa",
      "bigRoom": {
        "id": 1,
        "name": "Comodo",
        "width": 10.0,
        "length": 10.0
      }
    }
    ```` 