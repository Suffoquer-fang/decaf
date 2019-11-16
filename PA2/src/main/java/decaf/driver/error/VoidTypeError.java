package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：array subscript must be an integer<br>
 * PA2
 */
public class VoidTypeError extends DecafError {

    private String name;

    public VoidTypeError(Pos pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    protected String getErrMsg() {
        return "cannot declare identifier '" + name + "' as void type";
    }

}
