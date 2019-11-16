package decaf.frontend.scope;

import decaf.frontend.symbol.LambdaSymbol;
import decaf.frontend.symbol.MethodSymbol;

/**
 * Formal scope: stores parameter variable symbols. It is owned by a method symbol.
 */
public class FormalScope extends Scope {

    public FormalScope() {
        super(Kind.FORMAL);
    }

    public MethodSymbol getOwner() {
        return owner;
    }

    public LambdaSymbol getLambdaOwner() {
        return lambdaOwner;
    }

    public void setOwner(MethodSymbol owner) {
        this.owner = owner;
    }

    public void setOwner(LambdaSymbol owner) {
        this.lambdaOwner = owner;
    }

    @Override
    public boolean isFormalScope() {
        return true;
    }

    /**
     * Get the local scope associated with the method body.
     *
     * @return local scope
     */
    public LocalScope nestedLocalScope() {
        return nested;
    }

    /**
     * Set the local scope.
     *
     * @param scope local scope
     */
    void setNested(LocalScope scope) {
        nested = scope;
    }

    private MethodSymbol owner;
    private LambdaSymbol lambdaOwner;

    private LocalScope nested;
}
