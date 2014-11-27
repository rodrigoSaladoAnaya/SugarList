package org.sugarlist.annotation

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.DeclarationExpression
import org.codehaus.groovy.ast.expr.Expression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.INITIALIZATION)
public class WithQuotationMarksTransformation implements ASTTransformation {
    def printProp = new org.sugarlist.utils.PropertiesFormater()

    private boolean isNodesOk(ASTNode[] nodes) {
        if (!nodes) return false;
        if (nodes.size() != 2) return false;
        if (!(nodes[1] instanceof DeclarationExpression)) return false;
        return true;
    }

    private BlockStatement createStatements() {
        def statements = """
            [1, 2, 3, 4]
        """
        AstBuilder ab = new AstBuilder()
        List<ASTNode> res = ab.buildFromString(
                CompilePhase.SEMANTIC_ANALYSIS, false, statements
        )
        return res[0] as BlockStatement
    }

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        println "nodes: ${nodes.properties}"

        return
        if (!isNodesOk(nodes)) return;

        DeclarationExpression node1 = nodes[1]
        String variableName = node1.variableExpression.name
        String lst = node1?.rightExpression?.text
        println " *** variableName: ${variableName}"
        println " *** variableValu: ${lst}"
        println "1......................................."

        ExpressionStatement vexp = createStatements().statements[0]
        node1?.rightExpression = vexp.expression
    }
}