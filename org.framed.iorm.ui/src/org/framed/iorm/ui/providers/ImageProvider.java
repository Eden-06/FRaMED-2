package org.framed.iorm.ui.providers;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.URLLiterals;

/**
 * This class links image identifiers to the corresponding image file paths.
 * <p>
 * This is used to enable icons for create features. The features use the image identifiers established here  
 * as reference to the icons.
 * @author Kevin Kassin
 */
public class ImageProvider extends AbstractImageProvider {
 
    /**
     * the image identifiers for icons used for create features
     * <p>
     * can be:<br>
     * (1) the image identifier for the create feature of natural types or<br>
     * (2) the image identifier for the create feature of data types or<br>
     * (3) the image identifier for the create feature of attributes or<br>
     * (4) the image identifier for the create feature of operations or<br>
     * (5) the image identifier for the create feature of inheritances or<br>
     * (6) the image identifier for the create feature of groups
     */
    private final String IMG_ID_FEATURE_NATURALTYPE = IdentifierLiterals.IMG_ID_FEATURE_NATURALTYPE,
    				     IMG_ID_FEATURE_DATATYPE = IdentifierLiterals.IMG_ID_FEATURE_DATATYPE,
    				     IMG_ID_FEATURE_ATTRIBUTE = IdentifierLiterals.IMG_ID_FEATURE_ATTRIBUTE,
 					     IMG_ID_FEATURE_OPERATION = IdentifierLiterals.IMG_ID_FEATURE_OPERATION,
    				     IMG_ID_FEATURE_INHERITANCE = IdentifierLiterals.IMG_ID_FEATURE_INHERITANCE,
    				     IMG_ID_FEATURE_GROUP = IdentifierLiterals.IMG_ID_FEATURE_GROUP;
    
    /**
     * the image file paths to icons used for create features
     * <p>
     * can be:<br>
     * (1) the image file path for the create feature of natural types or<br>
     * (2) the image file path for the create feature of data types or<br>
     * (3) the image file path for the create feature of attributes or<br>
     * (4) the image file path for the create feature of operations or<br>
     * (5) the image file path for the create feature of inheritances or<br>
     * (6) the image file path for the create feature of groups
     */
    private final String IMG_FILEPATH_FEATURE_NATURALTYPE = URLLiterals.IMG_FILEPATH_FEATURE_NATURALTYPE,
    					 IMG_FILEPATH_FEATURE_DATATYPE = URLLiterals.IMG_FILEPATH_FEATURE_DATATYPE,
    				     IMG_FILEPATH_FEATURE_ATTRIBUTE = URLLiterals.IMG_FILEPATH_FEATURE_ATTRIBUTE,
  					     IMG_FILEPATH_FEATURE_OPERATION = URLLiterals.IMG_FILEPATH_FEATURE_OPERATION,
  					     IMG_FILEPATH_FEATURE_INHERITANCE = URLLiterals.IMG_FILEPATH_FEATURE_INHERITANCE,
  					     IMG_FILEPATH_FEATURE_GROUP = URLLiterals.IMG_FILEPATH_FEATURE_GROUP;
    
    /**
     * links the file paths to image identifiers
     * <p>
     * This is used to enable icons for create features. The features use the image identifiers linked here 
     * as reference to the icons.
     */
    @Override
    protected void addAvailableImages() {
        addImageFilePath(IMG_ID_FEATURE_NATURALTYPE, IMG_FILEPATH_FEATURE_NATURALTYPE);
        addImageFilePath(IMG_ID_FEATURE_DATATYPE, IMG_FILEPATH_FEATURE_DATATYPE);
        addImageFilePath(IMG_ID_FEATURE_ATTRIBUTE, IMG_FILEPATH_FEATURE_ATTRIBUTE);
        addImageFilePath(IMG_ID_FEATURE_OPERATION, IMG_FILEPATH_FEATURE_OPERATION);
        addImageFilePath(IMG_ID_FEATURE_INHERITANCE, IMG_FILEPATH_FEATURE_INHERITANCE);
        addImageFilePath(IMG_ID_FEATURE_GROUP, IMG_FILEPATH_FEATURE_GROUP);
    }
}
