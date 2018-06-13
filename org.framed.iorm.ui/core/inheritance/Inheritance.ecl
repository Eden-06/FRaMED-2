//Inheritance  
Start Inheritance (Naturals) when IsSourceType(NaturalType); 
Add Inheritance (Naturals) when IsSourceType(NaturalType) and SourceEqualsTargetType() and !SourceEqualsTarget();
Reconnect Inheritance (Naturals) when IsSourceType(NaturalType) and SourceEqualsTargetType() and !SourceEqualsTarget();
Create Inheritance (Naturals) when IsSourceType(NaturalType) and SourceEqualsTargetType() and !SourceEqualsTarget();

Execute Inheritance (true) when true;
 
