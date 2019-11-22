package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：function 'length' expects 0 argument(s) but 2 given<br>
 * PA2
 */
public class AssignMemberMethodError extends DecafError {

    private String name;

    public AssignMemberMethodError(Pos pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    protected String getErrMsg() {
        return "cannot assign value to class member method '" + name + "'";
    }

}
