package practice.course.basics.application;

import practice.course.atividades.order01.entities.Order;
import practice.course.atividades.order01.enums.OrderStatus;

public class ProgramEnum {

    public static void main(String[] args) {
        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);
    }
}