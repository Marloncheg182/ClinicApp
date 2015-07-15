package clinicspdata.util;

import clinicspdata.entity.Procedure;

/**
 * @author Oleg Romanenchuk
 */
public class ProcedureUtil {
    public static Procedure create() {
        Procedure procedure = new Procedure();
        procedure.setId(1);
        procedure.setDate("16.07.2015");
        procedure.setNotes("substitution of bandage");
        return procedure;
    }
}
