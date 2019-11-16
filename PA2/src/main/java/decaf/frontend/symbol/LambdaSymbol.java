package decaf.frontend.symbol;

import decaf.frontend.scope.ClassScope;
import decaf.frontend.scope.FormalScope;
import decaf.frontend.scope.LocalScope;
import decaf.frontend.tree.Pos;
import decaf.frontend.tree.Tree;
import decaf.frontend.type.FunType;

/**
 * Method symbol, representing a method definition.
 */
public final class LambdaSymbol extends Symbol {

    public final FunType type;

    /**
     * Associated formal scope of the method parameters.
     */
    public final FormalScope formalScope;
    public final LocalScope localScope;

    public LambdaSymbol(String name, FunType type, FormalScope formalScope, LocalScope localScope, Pos pos) {
        super(name, type, pos);
        this.type = type;
        this.formalScope = formalScope;
        this.localScope = localScope;
        formalScope.setOwner(this);
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
