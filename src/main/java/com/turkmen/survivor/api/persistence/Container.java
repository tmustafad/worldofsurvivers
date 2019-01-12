package com.turkmen.survivor.api.persistence;

import java.util.Map;

public interface Container<T> {

    Map<Integer, T> get();

    T add(T t);

}
