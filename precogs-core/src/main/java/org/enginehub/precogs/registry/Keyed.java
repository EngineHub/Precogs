package org.enginehub.precogs.registry;

/**
 * Represents an objects that can be added to a registry and referenced by an id which is unique within its registry.
 */
public interface Keyed {
    /**
     * The id of this object in the registry. Must be unique, and lowercase. Certain registries (e.g Namespaced ones) may have additional restrictions.
     * @return an id
     */
    String getId();
}
