**Projeto para a disciplina projeto de software 2021.1**

**Code smells**: Aplicados na pasta employee


**Long Method**: Método editEmployee da classe EmployeeConf muito extensa; 
**Unclear/Comments:**
Nomes dos métodos addCP, adcrv, addtx; Antes não estava explicado o que cada método fazia.


**Strategy**: Haviam muitos IF's na main e nos tipos de empregados também. Consegui criar classes separadas para cada um deles e setar as funções.

**Smells Simples**:  
O código estava dividido em duas partes apenas: **A main**(que ficava com o menu e algumas funcionalidades simples) e a **engine** que ficava com rodo controle do código, como classes e etc. Agora a divisão se concentra em App e Model;
Haviam códigos duplicados na maioria das funções;  

**Rename Method**: Como citado acima, alguns métodos não tinham um nome condizente com a função. Alterei para que ficasse mais compreensível.


**Nomes dos métodos** addCP--> 
addTimeCard; 
adcrv-->addSaleReport;, 
addtx--> addServiceFee


**Outras alterações**:  
Parte do código foi simplificada.  
Foram criados construtores para ajudar na alteração do tipo de empregado



