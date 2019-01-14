package com.turkmen.survivor.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <h1>The generic builder class for creating any type of object.This class is used throught the project</h1>
 *
 * Especially used for DTO to Entity conversion
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.service.impl.CharacterServiceImpl
 * @see com.turkmen.survivor.service.impl.GameServiceImpl
 * @see com.turkmen.survivor.service.impl.PlayerServiceImpl
 * @see com.turkmen.survivor.service.impl.PlanetServiceImpl
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class GenericBuilder<T> {

    private final Supplier<T> instantiator;

    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public GenericBuilder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
        return new GenericBuilder<T>(instantiator);
    }

    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        instanceModifiers.add(c);
        return this;
    }

    public T build() {
        T value = instantiator.get();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        instanceModifiers.clear();
        return value;
    }

}
