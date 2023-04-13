/*
 * Copyright (c) 2023 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package tech.pantheon.triemap;

import java.util.Spliterator;

final class MutableValues<K, V> extends AbstractValues<K, V, MutableTrieMap<K, V>> {
    MutableValues(final MutableTrieMap<K, V> map) {
        super(map);
    }

    @Override
    public ValuesIterator<K, V> iterator() {
        return new ValuesIterator<>(map.iterator());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    int spliteratorCharacteristics() {
        return Spliterator.DISTINCT | Spliterator.CONCURRENT | Spliterator.NONNULL;
    }
}
