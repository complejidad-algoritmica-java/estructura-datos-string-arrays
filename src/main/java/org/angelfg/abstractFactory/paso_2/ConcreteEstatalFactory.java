package org.angelfg.abstractFactory.paso_2;

import org.angelfg.abstractFactory.paso_1.AbstractCategoria;
import org.angelfg.abstractFactory.paso_1.Estatal;

public class ConcreteEstatalFactory implements AbstractFactory {

    @Override
    public AbstractCategoria createCategory() {
        return new Estatal();
    }

}
