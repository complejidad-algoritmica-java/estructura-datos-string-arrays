package org.angelfg.abstractFactory.paso_1;

import java.util.Collections;
import java.util.Map;

public class Federal implements AbstractCategoria {

    @Override
    public Map<String, Object> execution() {
        return Collections.singletonMap("tipo", "FEDERAL");
    }

}
