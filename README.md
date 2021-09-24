**Projeto para a disciplina projeto de software 2021.1**

***Sistema de Folha de Pagamento***


O objetivo do projeto é construir um sistema de folha de pagamento. O sistema consiste do 
gerenciamento de pagamentos dos empregados de uma empresa. Além disso, o sistema deve 
gerenciar os dados destes empregados, a exemplo os cartões de pontos. Empregados devem receber 
o salário no momento correto, usando o método que eles preferem, obedecendo várias taxas e 
impostos deduzidos do salário. 

• Alguns empregados são horistas. Eles recebem um salário por hora trabalhada. Eles 
submetem "cartões de ponto" todo dia para informar o número de horas trabalhadas naquele 
dia. Se um empregado trabalhar mais do que 8 horas, deve receber 1.5 a taxa normal 
durante as horas extras. Eles são pagos toda sexta-feira. 

• Alguns empregados recebem um salário fixo mensal. São pagos no último dia útil do mês 
(desconsidere feriados). Tais empregados são chamados "assalariados". 

• Alguns empregados assalariados são comissionados e portanto recebem uma comissão, um 
percentual das vendas que realizam. Eles submetem resultados de vendas que informam a 
data e valor da venda. O percentual de comissão varia de empregado para empregado. Eles 
são pagos a cada 2 sextas-feiras; neste momento, devem receber o equivalente de 2 semanas 
de salário fixo mais as comissões do período. 

o Empregados podem escolher o método de pagamento. 
o Podem receber um cheque pelos correios 
o Podem receber um cheque em mãos 
o Podem pedir depósito em conta bancária 


• Alguns empregados pertencem ao sindicato (para simplificar, só há um possível sindicato). 
O sindicato cobra uma taxa mensal do empregado e essa taxa pode variar entre 
empregados. A taxa sindical é deduzida do salário. Além do mais, o sindicato pode 
ocasionalmente cobrar taxas de serviços adicionais a um empregado. Tais taxas de serviço 
são submetidas pelo sindicato mensalmente e devem ser deduzidas do próximo 
contracheque do empregado. A identificação do empregado no sindicato não é a mesma da 
identificação no sistema de folha de pagamento. 

• A folha de pagamento é rodada todo dia e deve pagar os empregados cujos salários vencem 
naquele dia. O sistema receberá a data até a qual o pagamento deve ser feito e calculará o 
pagamento para cada empregado desde a última vez em que este foi pago





---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Code smells**: 

Descrição: Aplicados na pasta employees, na pasta payments e na EmployeeMenu


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
Parte do código foi simplificada;  
Foram criados construtores para ajudar na alteração do tipo de empregado;



