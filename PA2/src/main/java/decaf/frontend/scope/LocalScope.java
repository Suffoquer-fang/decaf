package decaf.frontend.scope;

import java.util.ArrayList;
import java.util.List;

/**
 * Local scope: stores locally-defined variables.
 */
public class LocalScope extends Scope {

    public LocalScope(Scope parent) {
        super(Kind.LOCAL);
        assert parent.isFormalOrLocalScope();
        if (parent.isFormalScope()) {
            ((FormalScope) parent).setNested(this);
        } else if(parent.isLambdaScope()){
            ((LambdaScope) parent).setNested(this);
            isInLambda = true;
            closestLambda = (LambdaScope)parent;
        }else {
            ((LocalScope) parent).nested.add(this);
            isInLambda = ((LocalScope) parent).isInLambda;
            closestLambda = ((LocalScope) parent).closestLambda;
        }
    }

    @Override
    public boolean isLocalScope() {
        return true;
    }

    /**
     * Collect all local scopes defined inside this scope.
     *
     * @return local scopes
     */
    public List<Scope> nestedLocalScopes() {
        return nested;
    }

    public void push(Scope p) {
        nested.add(p);
    }

    private List<Scope> nested = new ArrayList<>();
    public boolean isInLambda = false;
    public LambdaScope closestLambda = null;
}
