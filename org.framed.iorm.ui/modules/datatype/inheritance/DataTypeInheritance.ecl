//Inheritance or Role_Inheritance/Data_Type_Inheritance/Compartment_Inheritance
Start Inheritance (Data_Type_Inheritance) when IsSourceType(DataType); 
Add Inheritance (Data_Type_Inheritance) when IsSourceType(DataType) and !SourceEqualsTarget() and SourceEqualsTargetType(); // check acyclic
Reconnect Inheritance (Data_Type_Inheritance) when IsSourceType(DataType) and !SourceEqualsTarget() and SourceEqualsTargetType(); // check acyclic