/*
 * Copyright (c) 2023 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package tech.pantheon.triemap;

import java.util.Map.Entry;

/**
 * Iterator given out by {@link AbstractValues} implementations.
 */
final class ValuesIterator<K, V> extends AbstractTransformIterator<V, K, V> {
    ValuesIterator(final AbstractIterator<K, V> delegate) {
        super(delegate);
    }

    @Override
    V transform(final Entry<K, V> entry) {
        return entry.getValue();
    }
}