//Fullfillment or Players?? 
Start Fulfillment (Naturals) when IsSourceType(NaturalType); 
Add Fulfillment (Naturals) when IsSourceType(NaturalType) and IsTargetType(CompartmentType);
Reconnect Fulfillment (Naturals) when IsSourceType(NaturalType) and IsTargetType(CompartmentType);

Start Fulfillment (Roles) when IsSourceType(RoleType);
Add Fulfillment (Roles) when IsSourceType(RoleType) and IsTargetType(CompartmentType);
Reconnect Fulfillment (Roles) when IsSourceType(RoleType) and IsTargetType(CompartmentType);

Start Fulfillment (Compartments) when IsSourceType(CompartmentType);
Add Fulfillment (Compartments) when IsSourceType(CompartmentType) and IsTargetType(CompartmentType) and !SourceEqualsTarget();
Reconnect Fulfillment (Compartments) when IsSourceType(CompartmentType) and IsTargetType(CompartmentType) and !SourceEqualsTarget();

Start Fulfillment (Dates) when IsSourceType(DataType);
Add Fulfillment (Dates) when IsSourceType(DataType);
Reconnect Fulfillment (Dates) when IsSourceType(DataType);