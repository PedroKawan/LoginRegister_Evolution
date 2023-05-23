# LoginRegister_Evolution
Project update: Project Patterns (MVC, Services with DAO and DTO),
    Maven, JPA, Hibernate, MySQL, exceptions, services, infrastructure.

Old Project: https://github.com/PedroKawan/LoginRegister

- Sorry for the Readme, but I'm not familiar with MarkDown! 😅👏
## Infos
This project is a update 'evolution' of project `LoginRegister` = [Repository](https://github.com/PedroKawan/LoginRegister).
Here has been add patterns, controllers, servicies, JPA, Hibernate, MySQL, and others.
The screens have been updated, security in login and register with warnings and exceptions!


# View

## Tree
Project Tree, changes of old project 'LoginRegister'

![tree](https://github.com/PedroKawan/imagens/blob/main/loginregister_evo/tree.PNG)

## Patterns
<html>
  Model View Controll(MVC), Data Access Object (DAO), Services, Data Transfer Object (DTO) <br>
  <img src="https://github.com/PedroKawan/imagens/blob/main/loginregister_evo/dao-dto.png" alt="dtodao">

  Access to DataBase with hibernate<br>
  <img src="https://github.com/PedroKawan/imagens/blob/main/loginregister_evo/daoclass.PNG" alt="dao">
  
  Abstraction of the object! only to view in web or screen!<br>
  <img src="https://github.com/PedroKawan/imagens/blob/main/loginregister_evo/dtoclass.PNG" alt="dto">

</html>

## Warnings
Login Security ('email not found', 'password not match with email')

![warn](https://github.com/PedroKawan/imagens/blob/main/loginregister_evo/warnings.png)


Register Security('name' or 'email' has already been registered, 'password has no letters') 

![namew](https://github.com/PedroKawan/imagens/blob/main/loginregister_evo/namew.PNG)
![emailw](https://github.com/PedroKawan/imagens/blob/main/loginregister_evo/emailw.PNG)


## Good practices ✔
![codeafter](https://github.com/PedroKawan/imagens/blob/main/loginregister_evo/aftercode.PNG)
