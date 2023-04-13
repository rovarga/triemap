/*
 * Copyright (c) 2023 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package tech.pantheon.triemap;

import static java.util.Objects.requireNonNull;

import java.util.Iterator;
import java.util.Map.Entry;
import org.eclipse.jdt.annotation.NonNull;

/**
 * An iterator based on {@link AbstractIterator}. Returned elements are transformed via {@link #transform(Entry)}.
 */
abstract class AbstractTransformIterator<E, K, V> implements Iterator<E> {
    private final @NonNull AbstractIterator<K, V> delegate;

    AbstractTransformIterator(final AbstractIterator<K, V> delegate) {
        this.delegate = requireNonNull(delegate);
    }

    @Override
    public final boolean hasNext() {
        return delegate.hasNext();
    }

    @Override
    public final E next() {
        return transform(delegate.next());
    }

    @Override
    public final void remove() {
        delegate.remove();
    }

    abstract E transform(Entry<K, V> entry);
}
