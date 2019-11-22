package decaf.frontend.symbol;

import java.util.ArrayList;

import decaf.frontend.scope.ClassScope;
import decaf.frontend.scope.FormalScope;
import decaf.frontend.scope.LambdaScope;
import decaf.frontend.tree.Pos;
import decaf.frontend.tree.Tree;
import decaf.frontend.type.FunType;
import decaf.frontend.type.Type;

/**
 * Method symbol, representing a method definition.
 */
public final class LambdaSymbol extends Symbol {

    public final FunType type;

    /**
     * Associated formal scope of the method parameters.
     */
    public final LambdaScope scope;
    public ArrayList<Type> ret_types = new ArrayList<>();

    public LambdaSymbol(String name, FunType type, LambdaScope scope, Pos pos) {
        super(name, type, pos);
        this.type = type;
        this.scope = scope;
        scope.setOwner(this);
    }

    @Override
    public ClassScope domain() {
        return (ClassScope) definedIn;
    }

    @Override
    public boolean isLambdaSymbol() {
        return true;
    }

    @Override
    protected String str() {
        return String.format("function lambda%s : %s", name, type);
    }

}
