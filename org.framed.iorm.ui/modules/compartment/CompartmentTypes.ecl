//compartmentTypes
//If Compartment_Types is not set, then only one CompartmentType can be
//added in the top-level view (This will be named RoleModel).
Add CompartmentType (!Compartment_Types) when !InCompartment() and !ContainsCompartment();
Create CompartmentType (!Compartment_Types) when !InCompartment() and !ContainsCompartment();
Add CompartmentType (Compartment_Types) when !InCompartment();
Create CompartmentType (Compartment_Types) when !InCompartment();
 