/*
 * Copyright (c) 2023 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package tech.pantheon.triemap;

import static tech.pantheon.triemap.ImmutableTrieMap.unsupported;

import java.util.Collection;
import java.util.Spliterator;

final class ImmutableValues<K, V> extends AbstractValues<K, V, ImmutableTrieMap<K, V>> {
    ImmutableValues(final ImmutableTrieMap<K, V> map) {
        super(map);
    }

    @Override
    public ValuesIterator<K, V> iterator() {
        return immutableIterator();
    }

    @Override
    public void clear() {
        throw unsupported();
    }

    @Override
    @SuppressWarnings("checkstyle:parameterName")
    public boolean remove(final Object o) {
        throw unsupported();
    }

    @Override
    @SuppressWarnings("checkstyle:parameterName")
    public boolean retainAll(final Collection<?> c) {
        throw unsupported();
    }

    @Override
    @SuppressWarnings("checkstyle:parameterName")
    public boolean removeAll(final Collection<?> c) {
        throw unsupported();
    }

    @Override
    int spliteratorCharacteristics() {
        return Spliterator.DISTINCT | Spliterator.IMMUTABLE | Spliterator.NONNULL;
    }
}
