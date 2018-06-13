//Playing_own_roles 
Start Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType); 
Add Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType) and SourceEqualsTargetType();
Create Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType) and SourceEqualsTargetType();
Reconnect Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType) and SourceEqualsTargetType();