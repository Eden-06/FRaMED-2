//Fullfillment or Players?? 
Add Fulfillment (Naturals) when IsSourceType(NaturalType) and IsTargetType(CompartmentType);
Start Fulfillment (Naturals) when IsSourceType(NaturalType); 
Add Fulfillment (Roles) when IsSourceType(RoleType) and IsTargetType(CompartmentType);
Start Fulfillment (Roles) when IsSourceType(RoleType);
Add Fulfillment (Compartments) when IsSourceType(CompartmentType) and IsTargetType(CompartmentType) and !SourceEqualsTarget();
Start Fulfillment (Compartments) when IsSourceType(CompartmentType);
Add Fulfillment (Dates) when IsSourceType(DataType);
Start Fulfillment (Dates) when IsSourceType(DataType);