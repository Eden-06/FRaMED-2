//Inheritance or Role_Inheritance/Data_Type_Inheritance/Compartment_Inheritance     
Start Inheritance (Compartment_Inheritance) when IsSourceType(CompartmentType); 
Add Inheritance (Compartment_Inheritance) when IsSourceType(CompartmentType) and !SourceEqualsTarget() and SourceEqualsTargetType(); //acyclic
Create Inheritance (Compartment_Inheritance) when IsSourceType(CompartmentType) and !SourceEqualsTarget() and SourceEqualsTargetType(); //acyclic
   