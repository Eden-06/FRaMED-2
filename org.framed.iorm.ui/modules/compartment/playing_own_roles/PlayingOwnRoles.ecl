//Playing_own_roles
Start Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType); //sourceEqualsTarget not available on Start
Add Fulfillment (Playable_by_Defining_Compartment) when IsSourceType(CompartmentType) and SourceEqualsTarget();