//RoleConstraints 
Start RoleImplication (Role_Implication) when IsSourceType(RoleType); 
Add RoleImplication (Role_Implication) when IsSourceType(RoleType) and !SourceEqualsTarget() and SourceEqualsTargetType(); 
Reconnect RoleImplication (Role_Implication) when IsSourceType(RoleType) and !SourceEqualsTarget() and SourceEqualsTargetType(); 
 
Start RoleEquivalence (Role_Equivalence) when IsSourceType(RoleType); 
Add RoleEquivalence (Role_Equivalence) when IsSourceType(RoleType) and !SourceEqualsTarget() and SourceEqualsTargetType(); 
Reconnect RoleEquivalence (Role_Equivalence) when IsSourceType(RoleType) and !SourceEqualsTarget() and SourceEqualsTargetType(); 

Start RoleProhibition (Role_Prohibition) when IsSourceType(RoleType); 
Add RoleProhibition (Role_Prohibition) when IsSourceType(RoleType) and !SourceEqualsTarget() and SourceEqualsTargetType(); 
Reconnect RoleProhibition (Role_Prohibition) when IsSourceType(RoleType) and !SourceEqualsTarget() and SourceEqualsTargetType(); 
