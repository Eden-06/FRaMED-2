//IntraRelationshipConstraint 
Add Irreflexive (Intra_Relationship_Constraints) when IsTargetConnectionType(Relationship); 
Start Irreflexive (Intra_Relationship_Constraints) when true;
Create Irreflexive (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);

Add Acyclic (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);
Start Acyclic (Intra_Relationship_Constraints) when true;
Create Acyclic (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);

Add Cyclic (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);
Start Cyclic (Intra_Relationship_Constraints) when true;
Create Cyclic (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);

Add Reflexive (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);
Start Reflexive (Intra_Relationship_Constraints) when true; 
Create Reflexive (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);

Add Total (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);
Start Total (Intra_Relationship_Constraints) when true;
Create Total (Intra_Relationship_Constraints) when  IsTargetConnectionType(Relationship);
