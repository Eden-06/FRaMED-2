//RoleConstraints and RoleGroups
Start RoleImplication (Role_Implication and Group_Constraints) when
  IsSourceType(RoleType) or IsSourceType(RoleGroup); 
Add RoleImplication (Role_Implication and Group_Constraints) when
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup)); 
Reconnect RoleImplication (Role_Implication and Group_Constraints) when
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup)); 
Create RoleImplication (Role_Implication and Group_Constraints) when
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup));
 
Start RoleEquivalence (Role_Equivalence and Group_Constraints) when
  IsSourceType(RoleType) or IsSourceType(RoleGroup); 
Add RoleEquivalence (Role_Equivalence and Group_Constraints) when
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup)); 
Reconnect RoleEquivalence (Role_Equivalence and Group_Constraints) when
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup)); 
Create RoleEquivalence (Role_Equivalence and Group_Constraints) when
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup));
  
Start RoleProhibition (Role_Prohibition and Group_Constraints) when
  IsSourceType(RoleType) or IsSourceType(RoleGroup); 
Add RoleProhibition (Role_Prohibition and Group_Constraints) when
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup)); 
Reconnect RoleProhibition (Role_Prohibition and Group_Constraints) when
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup)); 
Create RoleProhibition (Role_Prohibition and Group_Constraints) when 
  (IsSourceType(RoleType) or IsSourceType(RoleGroup)) and !SourceEqualsTarget() and
  (IsTargetType(RoleType) or IsTargetType(RoleGroup));