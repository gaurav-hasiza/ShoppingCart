## Requirements
```agsl
Q. Build a Shopping cart API with following functionalities:
- Ability to create account with two roles (admin, user) and log in
- Admin should be able to
- Add items
- Suspend user
- User should be able to
- List available items
- Add items to a cart (if there are items in stock)
- Remove items from their cart
- Restrict the access to APIs through RBAC mechanism
- Add unit test with extensive cases wherever possible (Bonus: E2E tests)
- Follow proper coding conventions and add documentation & code comments wherever necessary
- Create Readme for easy setup and testing of the API
  Note: Candidates may use any coding language, though Golang would be preferable
```
## Setup Information:
```
java-19
Junit version 5 
.. TO ADD
```
## API Request Response 
## Create User
### Request
```agsl
curl --location 'localhost:8080/v0/users/createUser' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Gaurav",
    "password": "Password",
    "userRole": "ADMIN"

}'
```
### Response
```agsl
{
    "name": "Gaurav",
    "userRole": "ADMIN",
    "userID": "a8e86975-ba76-472a-b428-856d6f346b18"
}
```

## Login User
### Request
```agsl
curl --location 'localhost:8080/v0/users/login' \
--header 'Content-Type: application/json' \
--data '{
    "id": "a99c0bbe-a79e-403f-94bf-da8d393e9702",
    "password": "Password" 
}'
```
### Response
```
{
"sessionId": "9dd0e12d-ed72-4ac1-bdfe-67c578051aac"
}
```

## Logout User
### Request
```agsl
curl --location 'localhost:8080/v0/users/logout' \
--header 'Content-Type: application/json' \
--header 'sessionId: aab44bd4-ba92-4927-86f1-17c3a23309c1' \
--data '{
    "sessionId": "339ad40e-3d7a-40da-8caf-2d9f97768382"
}'
```
### Response:
```Session Logged out```

## Create Product
### Request
```agsl
curl --location 'localhost:8080/v0/products/create' \
--header 'sessionId: b12bbb0e-85ef-49ee-b98a-ac70c77fc472' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Maggi",
    "description": "Maggi",
    
    
    "status": "AVAILABLE",
    
    "price": 20.3,
    "stockQuantity": 1
}
'
```
### Response:
```agsl
{
    "id": "be371ac1-6694-468f-8ef4-b8f7f7f59356",
    "name": "Maggi",
    "status": "AVAILABLE",
    "price": 20.3,
    "stockQuantity": 1,
    "description": "Maggi"
}
```
## Product List 

### Request
```agsl
curl --location 'localhost:8080/v0/products/list' \
--header 'sessionId: 9dd0e12d-ed72-4ac1-bdfe-67c578051aac' \
--data ''
```
### Response
```agsl
{
    "productList": [
        {
            "createdAt": null,
            "updatedAt": null,
            "id": "d30a0bc6-e045-4246-8607-c64c40a6130f",
            "name": "Maggi",
            "status": "AVAILABLE",
            "price": 20.3,
            "stockQuantity": 1,
            "description": "Maggi"
        }
    ]
}
```
## Add to Cart
### Request 
```agsl
curl --location 'localhost:8080/v0/shopping/addToCart' \
--header 'sessionId: 392e170b-2a23-43e1-807b-22ef5b982cea' \
--header 'Content-Type: application/json' \
--data '{
    "productId": "231c0f6d-a6e9-44e0-a3d1-e631df9e4b19",
    "quantity": 1
}'
```
### Response
```agsl
Status Ok
```

## Cart List
### Request
```agsl
curl --location 'localhost:8080/v0/shopping/getCart' \
--header 'sessionId: 392e170b-2a23-43e1-807b-22ef5b982cea'
```
### Response:
```agsl
[
    {
        "productId": "9aceb187-d793-4489-a8a4-18700736c49c",
        "quantity": 1
    },
    {
        "productId": "231c0f6d-a6e9-44e0-a3d1-e631df9e4b19",
        "quantity": 1
    }
]
```