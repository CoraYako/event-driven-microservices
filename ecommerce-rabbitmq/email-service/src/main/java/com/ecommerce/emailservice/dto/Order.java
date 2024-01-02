package com.ecommerce.emailservice.dto;

public record Order(
        Long orderId,
        String name,
        int quantity,
        double price
) {
    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {
        private Long orderId;
        private String name;
        private int quantity;
        private double price;

        public OrderBuilder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public OrderBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Order build() {
            return new Order(this.orderId, this.name, this.quantity, this.price);
        }
    }
}
