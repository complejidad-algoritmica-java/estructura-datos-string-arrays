package org.angelfg.abstractFactory;

import org.angelfg.abstractFactory.paso_1.AbstractCategoria;
import org.angelfg.abstractFactory.paso_2.ConcreteEstatalFactory;
import org.angelfg.abstractFactory.paso_2.ConcreteFederalFactory;
import org.angelfg.abstractFactory.paso_3.AbstractCategoriesFactory;
//import org.angelfg.abstractFactory.paso_3.CategoryEnum;

public class EjecucionCategoriaMain {

    public static void main(String[] args) {
        AbstractCategoria estatal = AbstractCategoriesFactory.getCategory(new ConcreteEstatalFactory());
        AbstractCategoria federal = AbstractCategoriesFactory.getCategory(new ConcreteFederalFactory());
        System.out.println(estatal.execution());
        System.out.println(federal.execution());

//        AbstractCategoria estatal = AbstractCategoriesFactory.getCategoryById(CategoryEnum.ESTATAL);
//        AbstractCategoria federal = AbstractCategoriesFactory.getCategoryById(CategoryEnum.FEDERAL);
//        System.out.println(estatal.execution());
//        System.out.println(federal.execution());
    }

}
