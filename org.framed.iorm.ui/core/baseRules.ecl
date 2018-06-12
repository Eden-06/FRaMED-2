//https://github.com/leondart/FRaMED/wiki/EditPolicy-Rules
//base rules  
Add RoleType (true) when InType(CompartmentType);  
Create RoleType (true) when InType(CompartmentType); 

Add NaturalType (true) when true;
Add Group (true) when true;
Create NaturalType (true) when true;
Create Group (true) when true;

Create Inheritance (true) when true;
Create Relationship (true) when true;

//enable all context menues
//Execute CompartmentType (true) when true;
Execute Relationship (true) when true;
//Execute Fulfillment (true) when true;
//Execute Inheritance (true) when true;
