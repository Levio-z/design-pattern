### 代码解释
1. **`Expression`接口**：定义了一个`interpret`方法，所有具体的表达式类都实现了这个接口。
2. **`GreaterExpression`、`LessExpression`、`EqualExpression`**：分别实现了大于、小于和等于的逻辑。
3. **`AndExpression`**：处理逻辑与（`&&`）操作，它包含多个子表达式，只有所有子表达式都为`true`时，整个表达式才为`true`。
4. **`OrExpression`**：处理逻辑或（`||`）操作，它包含多个子表达式，只要有一个子表达式为`true`，整个表达式就为`true`。
5. **`AlertRuleInterpreter`**：解析告警规则字符串，构建表达式树，并调用`interpret`方法来判断是否触发告警。

### 测试用例解释
1. **`testAlertRuleInterpreter`**：测试了一个包含多个条件的告警规则，验证了规则解析和解释的正确性。
2. **`testInvalidExpression`**：测试了一个无效的告警规则，验证了在解析无效规则时会抛出异常。