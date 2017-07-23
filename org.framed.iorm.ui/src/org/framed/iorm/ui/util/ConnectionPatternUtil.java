package org.framed.iorm.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Shape;
import org.framed.iorm.model.Type;

public class ConnectionPatternUtil {

	public static List<Relation> getRelationForClassOrRole(Shape classOrRole, Type type) {
		List<Relation> relations = new ArrayList<Relation>();
		for(Relation relation : classOrRole.getIncomingRelations()) {
			if(relation.getType() == type) relations.add(relation);
		}
		for(Relation relation : classOrRole.getOutgoingRelations()) {
			if(relation.getType() == type) relations.add(relation);
		}
		return relations;
	}
	
	public static List<Relation> getRelationsBetweenClassesOrRoles(Shape sourceClassOrRole, Shape targetClassOrRole, Type type) {
		List<Relation> commonRelations = new ArrayList<Relation>();
		List<Relation> sourceRelations = getRelationForClassOrRole(sourceClassOrRole, type);
		List<Relation> targetRelations = getRelationForClassOrRole(targetClassOrRole, type);
		for(Relation relation : targetRelations) {
			if(sourceRelations.contains(relation))
				commonRelations.add(relation);
		}
		return commonRelations;
	}
	
}
