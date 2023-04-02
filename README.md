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

![imagem](https://media.licdn.com/dms/image/C4D12AQES-h5bvz2mtg/article-inline_image-shrink_1000_1488/0/1650235003343?e=1684972800&v=beta&t=gfDZ5RzJ11jMC1zRKAErLgGdj117KobrT4-IVIFzvOU)
