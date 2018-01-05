package org.framed.iorm.ui.providers;

import java.lang.reflect.Modifier;
import java.util.List;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.framed.iorm.ui.FRaMEDConnectionPattern;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.URLLiterals;
import org.framed.iorm.ui.util.UIUtil;

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
    				     IMG_ID_FEATURE_GROUP = IdentifierLiterals.IMG_ID_FEATURE_GROUP;
       
    /**
     * the image file paths to icons used for shape create features gathered from {@link URLLiterals}
     * <p>
     * See {@link URLLiterals} for further explanations.
     */
    private final String IMG_FILEPATH_FEATURE_COMPARTMENTTYPE = URLLiterals.IMG_FILEPATH_FEATURE_COMPARTMENTTYPE,
  					     IMG_FILEPATH_FEATURE_GROUP = URLLiterals.IMG_FILEPATH_FEATURE_GROUP;
    
    /**
     * links the file paths to image identifiers using the following steps:
     * <p>
   	 * Step 1: It uses {@link UIUtil#findModuleJavaClasses()} to find all java classes in the modules dynamically by searching for them
	 * 		   in the module source folder.<br>
	 * Step 2: It checks all found classes for non abstract<br>
	 * 		   (a) {@link FRaMEDShapePattern} and<br>
	 * 		   (b) {@link FRaMEDConnectionPattern} to add to the link their image identifier to their file path. 
     * <p>
     * This is used to enable icons for create features of the module features. The features use the image identifiers linked here 
     * as reference to the icons.
     */
    @Override
    protected void addAvailableImages() {
    	//Step 1
    	List<Class<?>> classes = UIUtil.findModuleJavaClasses();
    	//Step 2
    	for(Class<?> cl : classes) {
	    	if(!Modifier.isAbstract(cl.getModifiers())) {
	    		if(UIUtil.getSuperClasses(cl).contains(FRaMEDShapePattern.class) ||
	    		   UIUtil.getSuperClasses(cl).contains(FRaMEDConnectionPattern.class)) {
	    			try {
			    		Object object = cl.newInstance();
						//(a)
			    		if(object instanceof FRaMEDShapePattern) {
							FRaMEDShapePattern framedPattern = (FRaMEDShapePattern) object;
							addImageFilePath(framedPattern.getCreateImageId(), framedPattern.getCreateImagePath());
						}
						//(b)
						if(object instanceof FRaMEDConnectionPattern) {
							FRaMEDConnectionPattern framedPattern = (FRaMEDConnectionPattern) object;
							addImageFilePath(framedPattern.getCreateImageId(), framedPattern.getCreateImagePath());
						}
		    		} catch (InstantiationException | IllegalAccessException e) { e.printStackTrace(); }
	    }	}	}
    	
    	//TODO delete after and after
        addImageFilePath(IMG_ID_FEATURE_GROUP, IMG_FILEPATH_FEATURE_GROUP);
        addImageFilePath(IMG_ID_FEATURE_COMPARTMENTTYPE, IMG_FILEPATH_FEATURE_COMPARTMENTTYPE);
    }
}
