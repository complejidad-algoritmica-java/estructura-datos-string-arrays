package org.angelfg.abstractFactory.paso_3;

import org.angelfg.abstractFactory.paso_1.AbstractCategoria;
import org.angelfg.abstractFactory.paso_2.AbstractFactory;
import org.angelfg.abstractFactory.paso_2.ConcreteEstatalFactory;
import org.angelfg.abstractFactory.paso_2.ConcreteFederalFactory;

public class AbstractCategoriesFactory {

    public static AbstractCategoria getCategory(AbstractFactory factory) {
        return factory.createCategory();
    }

    public static AbstractCategoria getCategoryById(CategoryEnum category) {

        return switch (category) {
            case ESTATAL -> new ConcreteEstatalFactory().createCategory();
            case FEDERAL -> new ConcreteFederalFactory().createCategory();
            // default -> throw new RuntimeException("No existe esa categoria");
        };

    }

}
