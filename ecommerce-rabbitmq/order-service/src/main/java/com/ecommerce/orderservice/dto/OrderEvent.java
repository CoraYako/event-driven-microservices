package com.ecommerce.orderservice.dto;

public record OrderEvent(
        String message,
        String status,
        Order order
) {
    public static OrderEventBuilder builder() {
        return new OrderEventBuilder();
    }

    public static class OrderEventBuilder {
        private String message;
        private String status;
        private Order order;

        public OrderEventBuilder message(String message) {
            this.message = message;
            return this;
        }

        public OrderEventBuilder status(String status) {
            this.status = status;
            return this;
        }

        public OrderEventBuilder order(Order order) {
            this.order = order;
            return this;
        }

        public OrderEvent build() {
            return new OrderEvent(this.message, this.status, this.order);
        }
    }
}
