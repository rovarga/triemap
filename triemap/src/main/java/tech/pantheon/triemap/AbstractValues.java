/*
 * Copyright (c) 2023 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package tech.pantheon.triemap;

import static java.util.Objects.requireNonNull;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Abstract base class for implementing {@link TrieMap} values collection.
 *
 * @author Robert Varga
 *
 * @param <V> the type of entry values
 */
abstract sealed class AbstractValues<K, V, M extends TrieMap<K, V>> extends AbstractCollection<V>
        permits ImmutableValues, MutableValues {
    final @NonNull M map;

    AbstractValues(final M map) {
        this.map = requireNonNull(map);
    }

    @Override
    @SuppressWarnings("checkstyle:parameterName")
    public final boolean addAll(final Collection<? extends V> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("checkstyle:parameterName")
    public final boolean contains(final Object o) {
        return map.containsValue(o);
    }

    @Override
    public final boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public final int size() {
        return map.size();
    }

    @Override
    public final Spliterator<V> spliterator() {
        // TODO: this is backed by an Iterator, we should be able to do better
        return Spliterators.spliterator(immutableIterator(), Long.MAX_VALUE, spliteratorCharacteristics());
    }

    @Override
    public abstract ValuesIterator<K, V> iterator();

    final ValuesIterator<K, V> immutableIterator() {
        return new ValuesIterator<>(map.immutableIterator());
    }

    abstract int spliteratorCharacteristics();
}
