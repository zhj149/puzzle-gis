/*
 *    Puzzle GIS - Desktop GIS Platform
 *    http://puzzle-gis.codehaus.org
 *
 *    (C) 2007-2009, Johann Sorel
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 3 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.puzzle.print.action;

import java.util.ResourceBundle;

/**
 * I18N for this package
 * @author Johann Sorel (Puzzle-GIS)
 */
final class Utilities {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("org/puzzle/print/action/Bundle");

    static final String getString(final String key){
        return BUNDLE.getString(key);
    }

}
