package com.turkmen.survivor.service;

import com.turkmen.survivor.api.exception.ServiceException;

public interface Service<T> {
    T create(T t) throws ServiceException;
}
