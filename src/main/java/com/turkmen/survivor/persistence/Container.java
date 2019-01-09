package com.turkmen.survivor.persistence;

import java.util.Map;

public interface Container<T> {

    Map<Integer, T> get();

    void add(T t);
}
