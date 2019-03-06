# Behavioral Design Patterns

See more at https://refactoring.guru/design-patterns/behavioral-patterns



## 1. Chain of Responsibility

[Read the post](https://refactoring.guru/design-patterns/chain-of-responsibility)

Run example at MainActivity:

```kotlin
// Admin account
Demo_CoR().runDemo("admin@example.com", "admin_pass")
// User account
Demo_CoR().runDemo("user@example.com", "user_pass")
// Invalid account
Demo_CoR().runDemo("abc@example.com", "user_pass")
Demo_CoR().runDemo("admin@example.com", "123")
```

