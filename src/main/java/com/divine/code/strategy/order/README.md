### 订单折扣策略模块
- strategy
  - DiscountStrategy.java：定义折扣策略接口。
  - GrouponDiscountStrategy.java：实现团购折扣策略。
  - NormalDiscountStrategy.java：实现普通折扣策略。
  - PromotionDiscountStrategy.java：实现促销折扣策略。

- order
  - Order.java：订单类。
  - OrderService.java：订单服务类，负责处理订单逻辑。
  - OrderType.java：订单类型枚举。
- factory
  - DiscountStrategyFactory.java：折扣策略工厂类，根据订单类型获取对应的折扣策略。
    - 无状态：我们用 Map 来缓存策略，根据 type 直接从 Map 中获取对应的策略
    - 有状态：如果策略需要状态，可以在 OrderService 中传入状态信息。
