/*
 * Copyright 2013-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.logstash.logback.pattern;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

/**
 * Writes a JSON pattern node into JSON generator supplied.
 *
 * @param <Event> - type of the event (ILoggingEvent, IAccessEvent)
 *
 * @author <a href="mailto:dimas@dataart.com">Dmitry Andrianov</a>
 */
public interface NodeWriter<Event> {
    /**
     * Writes this node to the given generator
     * @param generator the generator to which to write the node
     * @param event the event from which to get data to write
     */
    void write(JsonGenerator generator, Event event) throws IOException;

    /**
     * Returns true if this node should be written.
     * If this returns true, then {@link #write(JsonGenerator, Object)} should not be called.
     *
     * This is used to potentially omit fields containing this node
     * (e.g. for omitting empty values)
     * @param generator
     * @param event
     * @return true if this node should be written.
     */
    boolean shouldWrite(JsonGenerator generator, Event event);
}
