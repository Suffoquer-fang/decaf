package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：function 'length' expects 0 argument(s) but 2 given<br>
 * PA2
 */
public class FunTypeArgsVoidError extends DecafError {


    public FunTypeArgsVoidError(Pos pos) {
        super(pos);
    }

    @Override
    protected String getErrMsg() {
        return "arguments in function type must be non-void known type";
    }

}
