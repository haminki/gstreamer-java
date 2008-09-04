/* 
 * Copyright (c) 2007, 2008 Wayne Meissner
 * 
 * This file is part of gstreamer-java.
 *
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * version 3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with this work.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.gstreamer.lowlevel;

import java.util.HashMap;
import java.util.Map;

import com.sun.jna.Library;

/**
 * A convenience wrapper to aid in loading an API interface.
 */
@SuppressWarnings("serial")
public final class GstNative {
    private GstNative() {
    }
    private static final Map<String, Object> options = new HashMap<String, Object>() {{
        put(Library.OPTION_TYPE_MAPPER, new GTypeMapper());
        put(Library.OPTION_FUNCTION_MAPPER, new GFunctionMapper());
    }};
    public static <T extends Library> T load(Class<T> interfaceClass) {
        return GNative.loadLibrary("gstreamer-0.10", interfaceClass, options);
    }
    public static <T extends Library> T load(String libraryName, Class<T> interfaceClass) {
        return GNative.loadLibrary(libraryName + "-0.10", interfaceClass, options);
    }
}
