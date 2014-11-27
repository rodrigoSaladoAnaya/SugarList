package org.sugarlist.annotation

import org.codehaus.groovy.transform.GroovyASTTransformationClass
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention

@Retention(RetentionPolicy.SOURCE)
@Target([ElementType.LOCAL_VARIABLE, ElementType.FIELD])
@GroovyASTTransformationClass('org.sugarlist.annotation.WithQuotationMarksTransformation')
public @interface WithQuotationMarks {

}
