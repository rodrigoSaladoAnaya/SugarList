import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.tools.ast.TransformTestHelper
import org.sugarlist.annotation.*

class RequiresTransformTestHelperTest extends GroovyTestCase {
        
    public void testInvokeUnitTest() {
        def file = new File('./org/sugarlist/test/WithQuotationMarksTest.groovy')
        assert file.exists()
 
        def invoker = new TransformTestHelper(
            new WithQuotationMarksTransformation(), CompilePhase.INITIALIZATION
        )

        def clazz = invoker.parse(file)
        def out = clazz.newInstance()
        
        assert out.test1().size() == 0
        //shouldFail { out.divide10By(0) }
   }
}