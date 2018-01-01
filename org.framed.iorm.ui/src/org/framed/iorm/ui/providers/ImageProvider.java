package org.framed.iorm.ui.providers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.URLLiterals;
import org.framed.iorm.ui.pattern.shapes.FRaMEDShapePattern;
import org.osgi.framework.Bundle;

/**
 * This class links image identifiers to the corresponding image file paths.
 * <p>
 * This is used to enable icons for create features. The features use the image identifiers established here  
 * as reference to the icons.
 * @author Kevin Kassin
 */
public class ImageProvider extends AbstractImageProvider {
 
    /**
     * the image identifiers for icons used for shape create features gathered from {@link IdentifierLiterals}
     * <p>
     * See {@link IdentifierLiterals} for further explanations.
     */
    private final String IMG_ID_FEATURE_COMPARTMENTTYPE = IdentifierLiterals.IMG_ID_FEATURE_COMPARTMENTTYPE,
    					 IMG_ID_FEATURE_NATURALTYPE = IdentifierLiterals.IMG_ID_FEATURE_NATURALTYPE,
    				     IMG_ID_FEATURE_ATTRIBUTE = IdentifierLiterals.IMG_ID_FEATURE_ATTRIBUTE,
 					     IMG_ID_FEATURE_OPERATION = IdentifierLiterals.IMG_ID_FEATURE_OPERATION,
    				     IMG_ID_FEATURE_GROUP = IdentifierLiterals.IMG_ID_FEATURE_GROUP,
    					 IMG_ID_FEATURE_ROLETYPE = IdentifierLiterals.IMG_ID_FEATURE_ROLETYPE;
    
    /**
     * the image identifiers for icons used for connection create features gathered from {@link IdentifierLiterals}
     * <p>
     * See {@link IdentifierLiterals} for further explanations.
     */
    private final String IMG_ID_FEATURE_INHERITANCE = IdentifierLiterals.IMG_ID_FEATURE_INHERITANCE,
    					 IMG_ID_FEATURE_ROLEIMPLICATION = IdentifierLiterals.IMG_ID_FEATURE_ROLEIMPLICATION,
    					 IMG_ID_FEATURE_ROLEEQUIVALENCE = IdentifierLiterals.IMG_ID_FEATURE_ROLEEQUIVALENCE,
  					     IMG_ID_FEATURE_ROLEPROHIBITION = IdentifierLiterals.IMG_ID_FEATURE_ROLEPROHIBITION,
  					     IMG_ID_FEATURE_RELATIONSHIP = IdentifierLiterals.IMG_ID_FEATURE_RELATIONSHIP,
  					     IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT = IdentifierLiterals.IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT,
  					     IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION = IdentifierLiterals.IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION,
 						 IMG_ID_FEATURE_RELATIONSHIP_PROHIBITION = IdentifierLiterals.IMG_ID_FEATURE_RELATIONSHIP_EXCLUSION,
 						 IMG_ID_FEATURE_FULFILLMENT = IdentifierLiterals.IMG_ID_FEATURE_FULFILLMENT;
    
    /**
     * the image file paths to icons used for shape create features gathered from {@link URLLiterals}
     * <p>
     * See {@link URLLiterals} for further explanations.
     */
    private final String IMG_FILEPATH_FEATURE_COMPARTMENTTYPE = URLLiterals.IMG_FILEPATH_FEATURE_COMPARTMENTTYPE,
    					 IMG_FILEPATH_FEATURE_NATURALTYPE = URLLiterals.IMG_FILEPATH_FEATURE_NATURALTYPE,
    				     IMG_FILEPATH_FEATURE_ATTRIBUTE = URLLiterals.IMG_FILEPATH_FEATURE_ATTRIBUTE,
  					     IMG_FILEPATH_FEATURE_OPERATION = URLLiterals.IMG_FILEPATH_FEATURE_OPERATION,
  					     IMG_FILEPATH_FEATURE_GROUP = URLLiterals.IMG_FILEPATH_FEATURE_GROUP,
    					 IMG_FILEPATH_FEATURE_ROLETYPE = URLLiterals.IMG_FILEPATH_FEATURE_ROLETYPE;
    
    /**
     * the image file paths to icons used for connection create features gathered from {@link URLLiterals}
     * <p>
     * See {@link URLLiterals} for further explanations.
     */
    private final String IMG_FILEPATH_FEATURE_INHERITANCE = URLLiterals.IMG_FILEPATH_FEATURE_INHERITANCE,
    					 IMG_FILEPATH_FEATURE_ROLEIMPLICATION = URLLiterals.IMG_FILEPATH_FEATURE_ROLEIMPLICATION,
    					 IMG_FILEPATH_FEATURE_ROLEEQUIVALENCE = URLLiterals.IMG_FILEPATH_FEATURE_ROLEEQUIVALENCE,
    					 IMG_FILEPATH_FEATURE_ROLEPROHIBITION = URLLiterals.IMG_FILEPATH_FEATURE_ROLEPROHIBITION,
    				     IMG_FILEPATH_FEATURE_RELATIONSHIP = URLLiterals.IMG_FILEPATH_FEATURE_RELATIONSHIP,
    					 IMG_FILEPATH_FEATURE_INTRARELATIONSHIP_CONSTRAINT = URLLiterals.IMG_FILEPATH_FEATURE_INTRARELATIONSHIP_CONSTRAINT,
    					 IMG_FILEPATH_FEATURE_RELATIONSHIP_IMPLICATION = URLLiterals.IMG_FILEPATH_FEATURE_RELATIONSHIP_IMPLICATION,
  						 IMG_FILEPATH_FEATURE_RELATIONSHIP_PROHIBTION = URLLiterals.IMG_FILEPATH_FEATURE_RELATIONSHIP_EXCLUSION,
  					     IMG_FILEPATH_FEATURE_FULFILLMENT = URLLiterals.IMG_FILEPATH_FEATURE_FULFILLMENT;
    
    /**
     * links the file paths to image identifiers
     * <p>
     * This is used to enable icons for create features. The features use the image identifiers linked here 
     * as reference to the icons.
     */
    @Override
    protected void addAvailableImages() {
    	List<Class<?>> patterns = findModulePatterns();
    	for(Class<?> patternClass : patterns) {
    		try {
	    		Object object = patternClass.newInstance();
				if(object instanceof FRaMEDShapePattern) {
					FRaMEDShapePattern framedPattern = (FRaMEDShapePattern) object;
					addImageFilePath(framedPattern.getCreateImageId(), framedPattern.getCreateImagePath());
				}
    		} catch (InstantiationException | IllegalAccessException e) { e.printStackTrace(); }
    	}
    	
    	
    	addImageFilePath(IMG_ID_FEATURE_NATURALTYPE, IMG_FILEPATH_FEATURE_NATURALTYPE);
        addImageFilePath(IMG_ID_FEATURE_ATTRIBUTE, IMG_FILEPATH_FEATURE_ATTRIBUTE);
        addImageFilePath(IMG_ID_FEATURE_OPERATION, IMG_FILEPATH_FEATURE_OPERATION);
        addImageFilePath(IMG_ID_FEATURE_GROUP, IMG_FILEPATH_FEATURE_GROUP);
        addImageFilePath(IMG_ID_FEATURE_COMPARTMENTTYPE, IMG_FILEPATH_FEATURE_COMPARTMENTTYPE);
        addImageFilePath(IMG_ID_FEATURE_ROLETYPE, IMG_FILEPATH_FEATURE_ROLETYPE);
        
        addImageFilePath(IMG_ID_FEATURE_INHERITANCE, IMG_FILEPATH_FEATURE_INHERITANCE);
        addImageFilePath(IMG_ID_FEATURE_ROLEIMPLICATION, IMG_FILEPATH_FEATURE_ROLEIMPLICATION);
        addImageFilePath(IMG_ID_FEATURE_ROLEEQUIVALENCE, IMG_FILEPATH_FEATURE_ROLEEQUIVALENCE);
        addImageFilePath(IMG_ID_FEATURE_ROLEPROHIBITION, IMG_FILEPATH_FEATURE_ROLEPROHIBITION);
        addImageFilePath(IMG_ID_FEATURE_RELATIONSHIP, IMG_FILEPATH_FEATURE_RELATIONSHIP);
        addImageFilePath(IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT, IMG_FILEPATH_FEATURE_INTRARELATIONSHIP_CONSTRAINT);
        addImageFilePath(IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION, IMG_FILEPATH_FEATURE_RELATIONSHIP_IMPLICATION);
        addImageFilePath(IMG_ID_FEATURE_RELATIONSHIP_PROHIBITION, IMG_FILEPATH_FEATURE_RELATIONSHIP_PROHIBTION);
        addImageFilePath(IMG_ID_FEATURE_FULFILLMENT, IMG_FILEPATH_FEATURE_FULFILLMENT);
    }
    
    private List<Class<?>> findModulePatterns() {
    	Bundle bundle = Platform.getBundle("org.framed.iorm.ui");
	    List<URL> patternURLs = Collections.list(bundle.findEntries("/modules", "*.java", true));
	    List<Class<?>> patternClasses = new ArrayList<Class<?>>();
	    for(URL patternURL : patternURLs) {
	    	try {
	    		Class<?> classForPattern = Class.forName(formatURL(patternURL.toString()));
	    		patternClasses.add(classForPattern);
			} catch (ClassNotFoundException e) { e.printStackTrace(); }
	    }
	    return patternClasses;
	}
	
	private String formatURL(String patternURL) {
		int cutStart = patternURL.indexOf("modules/")+"modules/".length(),
			cutEnd = patternURL.indexOf(".java");	
		patternURL = patternURL.substring(cutStart, cutEnd);
		return patternURL.replace("/", ".");
	}
}
