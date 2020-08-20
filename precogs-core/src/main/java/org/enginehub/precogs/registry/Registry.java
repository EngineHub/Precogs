package org.enginehub.precogs.registry;

import com.sun.istack.internal.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;

public class Registry<V extends Keyed> implements Iterable<V> {
    private final Map<String, V> map = new HashMap<>();
    private final String name;

    public Registry(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public V get(final String key) {
        checkState(key.equals(key.toLowerCase(Locale.ROOT)), "key must be lowercase");
        return this.map.get(key);
    }

    public V register(final String key, final V value) {
        requireNonNull(key, "key");
        requireNonNull(value, "value");
        checkState(key.equals(key.toLowerCase(Locale.ROOT)), "key must be lowercase");
        checkState(!this.map.containsKey(key), "key '%s' already has an associated %s", key, this.name);
        this.map.put(key, value);
        return value;
    }

    public Set<String> keySet() {
        return Collections.unmodifiableSet(this.map.keySet());
    }

    public Collection<V> values() {
        return Collections.unmodifiableCollection(this.map.values());
    }

    @Override
    public Iterator<V> iterator() {
        return this.map.values().iterator();
    }

}
