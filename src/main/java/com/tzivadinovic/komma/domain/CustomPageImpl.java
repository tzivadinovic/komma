package com.tzivadinovic.komma.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class CustomPageImpl<T> extends PageImpl<T> {

    public CustomPageImpl(Page<T> page) {
        super(page.getContent(), page.getPageable(), page.getTotalElements());
    }

    public int size() {
        return super.getSize();
    }
}
