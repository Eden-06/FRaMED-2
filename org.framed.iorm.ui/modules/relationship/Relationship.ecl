//Relationships 
Start Relationship (Relationships) when true;
Add Relationship (Relationships) when true;
 
Start Relationship (true) when IsSourceType(RoleType);//For Relationship-Relation Source and Target must be Role-Type	
Add Relationship (true) when IsTargetType(RoleType) and IsSourceType(RoleType);