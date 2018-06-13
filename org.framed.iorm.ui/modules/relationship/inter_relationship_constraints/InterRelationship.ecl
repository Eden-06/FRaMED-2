//InterRelationship  
Start RelationshipExclusion (Inter_Relationship_Constraints) when IsSourceType(Relationship);
Add RelationshipExclusion (Inter_Relationship_Constraints) when IsSourceType(Relationship) and SourceEqualsTargetType() and !SourceEqualsTarget(); 
Reconnect RelationshipExclusion (Inter_Relationship_Constraints) when IsSourceType(Relationship) and SourceEqualsTargetType() and !SourceEqualsTarget();
Create RelationshipExclusion (Inter_Relationship_Constraints) when IsSourceType(Relationship) and SourceEqualsTargetType() and !SourceEqualsTarget();

Start RelationshipImplication (Inter_Relationship_Constraints) when IsSourceType(Relationship);
Add RelationshipImplication (Inter_Relationship_Constraints) when IsSourceType(Relationship) and SourceEqualsTargetType() and !SourceEqualsTarget();
Reconnect RelationshipImplication (Inter_Relationship_Constraints) when IsSourceType(Relationship) and SourceEqualsTargetType() and !SourceEqualsTarget();
Create RelationshipImplication (Inter_Relationship_Constraints) when IsSourceType(Relationship) and SourceEqualsTargetType() and !SourceEqualsTarget();
