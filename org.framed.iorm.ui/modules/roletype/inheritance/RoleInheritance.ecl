//Inheritance or Role_Inheritance/Data_Type_Inheritance/Compartment_Inheritance 
Start Inheritance (Role_Inheritance) when IsSourceType(RoleType);   
Add Inheritance (Role_Inheritance) when IsSourceType(RoleType) and !SourceEqualsTarget() and SourceEqualsTargetType();  //TODO, check acyclic 
Reconnect Inheritance (Role_Inheritance) when IsSourceType(RoleType) and !SourceEqualsTarget() and SourceEqualsTargetType();  //TODO, check acyclic 