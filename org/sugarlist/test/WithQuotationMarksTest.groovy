package org.sugarlist.test

import org.sugarlist.annotation.WithQuotationMarks

public class WithQuotationMarksTransformation {

    def test1() {
        @WithQuotationMarks def lst_1 = [
                pepe
                caro
                coco
        ]
        return lst_1
    }
}

