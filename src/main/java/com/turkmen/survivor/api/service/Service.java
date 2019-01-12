package com.turkmen.survivor.api.service;

import com.turkmen.survivor.api.exception.ServiceException;

import java.util.List;

public interface Service<T> {
    T create(T t) throws ServiceException;
    List<T> getAll() throws ServiceException;
    T get(String name);
}
