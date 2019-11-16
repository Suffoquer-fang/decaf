package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：function 'length' expects 0 argument(s) but 2 given<br>
 * PA2
 */
public class BadAbstractClassError extends DecafError {

    private String name;

    public BadAbstractClassError(Pos pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    protected String getErrMsg() {
        return "'" + name + "' is not abstract and does not override all abstract methods";
    }

}
