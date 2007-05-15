/*
 * GType.java
 */

package org.gstreamer.lowlevel;

/**
 *
 */
public enum GType {
    INVALID                  (0),
    NONE                     (1),
    INTERFACE                (2),
    CHAR                     (3),
    UCHAR                    (4),
    BOOLEAN                  (5),
    INT                      (6),
    UINT                     (7),
    LONG                     (8),
    ULONG                    (9),
    INT64                    (10),
    UINT64                   (11),
    ENUM                     (12),
    FLAGS                    (13),
    FLOAT                    (14),
    DOUBLE                   (15),
    STRING                   (16),
    POINTER                  (17),
    BOXED                    (18),
    PARAM                    (19),
    OBJECT                   (20);

    
    GType(int t) {
        type = t << 2;
    }
    public long longValue() {
        return type;
    }
    public static final GType valueOf(long type) {
        for (GType t : values()) {
            if (t.type == type) {
                return t;
            }
        }
        return INVALID;
    }
    long type;
}
