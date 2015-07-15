package clinicspdata.util;

import clinicspdata.entity.Operation;

/**
 * @author Oleg Romanenchuk
 */
public class OperationUtil {
    public static Operation create() {
        Operation operation = new Operation();
        operation.setId(1);
        operation.setDate("15.06.2015");
        operation.setType("Operation on appendix");
        operation.setResult("perfect!");
        return operation;
    }
}
