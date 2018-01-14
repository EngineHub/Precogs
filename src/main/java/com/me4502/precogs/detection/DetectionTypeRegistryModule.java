/*
 * Copyright (c) 2017-2018 Me4502 (Matthew Miller)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.me4502.precogs.detection;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.registry.AdditionalCatalogRegistryModule;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class DetectionTypeRegistryModule implements AdditionalCatalogRegistryModule<DetectionType>  {

    private final Map<String, DetectionType> detectionTypeMappings = new HashMap<>();

    @Override
    public Optional<DetectionType> getById(String id) {
        checkNotNull(id);
        return Optional.ofNullable(this.detectionTypeMappings.get(id));
    }

    @Override
    public Collection<DetectionType> getAll() {
        return ImmutableList.copyOf(detectionTypeMappings.values());
    }

    @Override
    public void registerAdditionalCatalog(DetectionType extraCatalog) {
        this.detectionTypeMappings.put(extraCatalog.getId().toLowerCase(Locale.ENGLISH), extraCatalog);
    }
}
