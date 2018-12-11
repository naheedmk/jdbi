/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdbi.v3.json;

import org.jdbi.v3.core.config.JdbiConfig;
import org.jdbi.v3.json.internal.JsonMapperImpl;
import org.jdbi.v3.meta.Beta;

@Beta
public class JsonConfig implements JdbiConfig<JsonConfig> {
    private JsonMapperImpl impl;

    public JsonConfig() {}

    private JsonConfig(JsonConfig other) {
        this.impl = other.impl;
    }

    public JsonConfig setImpl(JsonMapperImpl impl) {
        this.impl = impl;
        return this;
    }

    public JsonMapperImpl getImpl() {
        if (impl == null) {
            throw new IllegalStateException("No json implementation loaded, did you install e.g. Jackson2Module?");
        }
        return impl;
    }

    @Override
    public JsonConfig createCopy() {
        return new JsonConfig(this);
    }
}
