//Playing_own_roles 
Start Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType); 
Add Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType) and SourceEqualsTarget();
Create Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType) and SourceEqualsTarget();
Reconnect Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType) and SourceEqualsTarget();