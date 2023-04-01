# Arquitetura Hexagonal - pacotes na raiz:

## adapters:

### inbound:

> entities, request, controllers

### outbound

> exemplo -> UsuarioAdapter (@Component) - usado na service - comunicação com coisas externas (client, banco de dados, etc...)

## config:

> tudo que for configuração

## application:

### core:

> domain - Entidades - usa no projeto inteiro (independente de framework)

> exception

> service - usar o port pra fazer comunicação com o externo

---

### ports:
        
        - in (interface) //  service implementa - padrao usar o sufixo Port
        - out (interface) // outbound implementa e a service usa - padrao usar o sufixo Port


## Resumo:

 
adapters:
    :  inbound 
    :  uotbound

---

config:
    : configs

---

 application:
        core
            : domain 
            : service 
            : exception
         ports
            : in
            : out 

        ports:
            : in
            : out 
