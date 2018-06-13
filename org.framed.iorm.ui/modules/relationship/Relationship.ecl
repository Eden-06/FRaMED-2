//Relationships  
Start Relationship (Relationships) when IsSourceType(RoleType);
Add Relationship (Relationships) when IsTargetType(RoleType) and IsSourceType(RoleType) and !SourceEqualsTarget();
Reconnect Relationship (Relationships) when IsTargetType(RoleType) and IsSourceType(RoleType) and !SourceEqualsTarget();
Create Relationship (Relationships) when IsTargetType(RoleType) and IsSourceType(RoleType) and !SourceEqualsTarget();
 
Execute Relationship (Relationships) when true;
