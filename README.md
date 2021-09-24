**Projeto para a disciplina projeto de software 2021.1**

**Code smells**: Aplicado na pasta employee
**Long Method**: Método editEmployee da classe EmployeeConf muito extensa; 
**Unclear/Comments:**
Nome dos métodos addCP--> addTimeCard;, adcrv-->addSaleReport;, addtx--> addServiceFee; Antes não estava explicado o que cada método fazia.


**Strategy**: Haviam muitos IF's na main e nos tipos de empregados também. Consegui criar classes separadas para cada um deles e setar as funções.

**Smells Simples**:  
O código estava dividido em duas partes apenas: **A main**(que ficava com o menu e algumas funcionalidades simples) e a **engine** que ficava com rodo controle do código, como classes e etc. Agora a divisão se concentra em App e Model;
Haviam códigos duplicados na maioria das funções;  

**Outras alterações**:  
Parte do código foi simplificada.  



